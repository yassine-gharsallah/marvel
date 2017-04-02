package fr.everydaysapps.marvelsuperheroes.screens.heroes.core;

import fr.everydaysapps.marvelsuperheroes.api.HeroApi;
import fr.everydaysapps.marvelsuperheroes.models.Hero;
import fr.everydaysapps.marvelsuperheroes.models.Heroes;
import fr.everydaysapps.marvelsuperheroes.screens.heroes.HeroesListActivity;
import fr.everydaysapps.marvelsuperheroes.utils.NetworkUtils;
import rx.Observable;

/**
 * Created by yassinegharsallah on 02/04/2017.
 */

public class HeroesModel {

    HeroesListActivity context;
    HeroApi api;

    public HeroesModel(HeroesListActivity context, HeroApi api) {
        this.api = api;
        this.context = context;
    }


    Observable<Heroes> provideListHeroes() {
        return api.getHeroes();
    }

    Observable<Boolean> isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailableObservable(context);
    }



    public void gotoHeroDetailsActivity(Hero hero) {
        context.goToHeroDetailsActivity(hero);
    }


}
