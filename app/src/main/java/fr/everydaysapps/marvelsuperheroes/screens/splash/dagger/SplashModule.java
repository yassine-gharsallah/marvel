package fr.everydaysapps.marvelsuperheroes.screens.splash.dagger;

import dagger.Module;
import dagger.Provides;
import fr.everydaysapps.marvelsuperheroes.api.HeroApi;
import fr.everydaysapps.marvelsuperheroes.screens.splash.SplashScreenActivity;
import fr.everydaysapps.marvelsuperheroes.screens.splash.core.SplashModel;
import fr.everydaysapps.marvelsuperheroes.screens.splash.core.SplashPresenter;
import fr.everydaysapps.marvelsuperheroes.screens.splash.core.SplashView;
import fr.everydaysapps.marvelsuperheroes.utils.rx.RxSchedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by yassinegharsallah on 01/04/2017.
 */


@Module
public class SplashModule {


    @SplashScope
    @Provides
    SplashPresenter providePresenter(RxSchedulers schedulers, SplashModel model) {
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        return new SplashPresenter(model, schedulers, compositeSubscription);
    }


    @SplashScope
    @Provides
    SplashView provideSplashView(SplashScreenActivity context) {
        return new SplashView(context);
    }


    @SplashScope
    @Provides
    SplashModel provideSplashModel(HeroApi api, SplashScreenActivity ctx) {
        return new SplashModel(api, ctx);
    }

}

