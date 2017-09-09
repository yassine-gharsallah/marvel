package fr.everydaysapps.marvelsuperheroes.screens.splash.dagger;

import dagger.Component;
import fr.everydaysapps.marvelsuperheroes.application.builder.AppComponent;
import fr.everydaysapps.marvelsuperheroes.screens.splash.SplashScreenActivity;

/**
 * Created by yassinegharsallah on 01/04/2017.
 */
@SplashScope
@Component(modules = {SplashContextModule.class, SplashModule.class}, dependencies = {AppComponent.class})
public interface SplashComponent {
    void inject(SplashScreenActivity activity);
}
