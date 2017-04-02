package fr.everydaysapps.marvelsuperheroes.screens.heroes.dagger;

import dagger.Component;
import fr.everydaysapps.marvelsuperheroes.application.builder.AppComponent;
import fr.everydaysapps.marvelsuperheroes.screens.heroes.HeroesListActivity;

/**
 * Created by yassinegharsallah on 01/04/2017.
 */
@HeroesScope
@Component(dependencies = {AppComponent.class} , modules = {HeroesModule.class})
public interface HereosComponent {

    void inject (HeroesListActivity heroesActivity);
}
