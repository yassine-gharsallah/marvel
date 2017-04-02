package fr.everydaysapps.marvelsuperheroes.screens.heroes.core;

import android.util.Log;

import java.util.ArrayList;

import fr.everydaysapps.marvelsuperheroes.models.Hero;
import fr.everydaysapps.marvelsuperheroes.utils.UiUtils;
import fr.everydaysapps.marvelsuperheroes.utils.rx.RxSchedulers;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by yassinegharsallah on 02/04/2017.
 */

public class HeroesPresenter {

    HeroesView view;
    HeroesModel model;
    RxSchedulers rxSchedulers;
    CompositeSubscription subscriptions;
    ArrayList<Hero> heros = new ArrayList<>();

    public HeroesPresenter(RxSchedulers schedulers, HeroesModel model, HeroesView view, CompositeSubscription sub) {
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


    private Subscription respondToClick() {

        return view.itemClicks().subscribe(integer -> model.gotoHeroDetailsActivity(heros.get(integer)));
    }


    private Subscription getHeroesList() {

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
