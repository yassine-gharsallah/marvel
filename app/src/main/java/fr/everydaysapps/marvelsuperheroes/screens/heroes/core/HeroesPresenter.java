package fr.everydaysapps.marvelsuperheroes.screens.heroes.core;

import android.util.Log;

import java.util.ArrayList;

import fr.everydaysapps.marvelsuperheroes.models.Hero;
import fr.everydaysapps.marvelsuperheroes.utils.UiUtils;
import fr.everydaysapps.marvelsuperheroes.utils.rx.RxSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by yassinegharsallah on 02/04/2017.
 */

public class HeroesPresenter {

    HeroesView view;
    HeroesModel model;
    RxSchedulers rxSchedulers;
    CompositeDisposable subscriptions;
    ArrayList<Hero> heros = new ArrayList<>();

    public HeroesPresenter(RxSchedulers schedulers, HeroesModel model, HeroesView view, CompositeDisposable sub) {
        this.rxSchedulers = schedulers;
        this.view = view;
        this.model = model;
        this.subscriptions = sub;
    }

    public void onCreate() {

        Log.d("enter to presenter", "oki");
        subscriptions.add(getHeroesList());
        subscriptions.add(respondToClick());
    }

    public void onDestroy() {
        subscriptions.clear();
    }


    private Disposable respondToClick() {

        return view.itemClicks().subscribe(integer -> model.gotoHeroDetailsActivity(heros.get(integer)));
    }


    private Disposable getHeroesList() {

        return model.isNetworkAvailable().doOnNext(networkAvailable -> {
            if (!networkAvailable) {
                Log.d("no conn", "no connexion");
                // UiUtils.showSnackbar();
                // Show Snackbar can't use app
            }
        }).
                filter(isNetworkAvailable -> true).
                flatMap(isAvailable -> model.provideListHeroes()).
                subscribeOn(rxSchedulers.internet()).
                observeOn(rxSchedulers.androidThread()).subscribe(heroes -> {
                    Log.d("ok loaded", "cccc");
                    view.swapAdapter((ArrayList<Hero>) heroes.getElements());
                    heros = (ArrayList<Hero>) heroes.getElements();
                }, throwable -> {
                    UiUtils.handleThrowable(throwable);
                }
        );

    }
}
