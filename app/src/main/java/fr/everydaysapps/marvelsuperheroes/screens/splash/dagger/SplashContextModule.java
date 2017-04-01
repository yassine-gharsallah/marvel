package fr.everydaysapps.marvelsuperheroes.screens.splash.dagger;

import dagger.Module;
import dagger.Provides;
import fr.everydaysapps.marvelsuperheroes.screens.splash.SplashScreenActivity;

/**
 * Created by yassinegharsallah on 01/04/2017.
 */
@Module
public class SplashContextModule {

    SplashScreenActivity splashContext;

    public SplashContextModule(SplashScreenActivity context) {
        this.splashContext = context;
    }

    @SplashScope
    @Provides
    SplashScreenActivity provideSplashContext() {
        return splashContext;
    }


}
