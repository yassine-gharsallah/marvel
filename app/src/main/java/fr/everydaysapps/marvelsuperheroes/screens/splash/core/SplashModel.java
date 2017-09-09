package fr.everydaysapps.marvelsuperheroes.screens.splash.core;

import fr.everydaysapps.marvelsuperheroes.api.HeroApi;
import fr.everydaysapps.marvelsuperheroes.models.Heroes;
import fr.everydaysapps.marvelsuperheroes.screens.splash.SplashScreenActivity;
import fr.everydaysapps.marvelsuperheroes.utils.NetworkUtils;
import rx.Observable;

/**
 * Created by yassinegharsallah on 01/04/2017.
 */

public class SplashModel {


    private HeroApi api;
    private SplashScreenActivity splashContext;

    public SplashModel(HeroApi api, SplashScreenActivity splashCtx) {
        this.api = api;
        this.splashContext = splashCtx;

    }

    Observable<Heroes> provideListHeroes() {
        return api.getHeroes();
    }

    Observable<Boolean> isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailableObservable(splashContext);
    }


    public void gotoHeroesListActivity() {
        splashContext.showHeroesListActivity();

    }


}
