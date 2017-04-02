package fr.everydaysapps.marvelsuperheroes.screens.details.dagger;

import dagger.Component;
import fr.everydaysapps.marvelsuperheroes.screens.details.HeroDetailsActivity;

/**
 * Created by yassinegharsallah on 02/04/2017.
 */
@Component(modules = {HeroDetailsModule.class})
public interface HeroDetailsComponent {
    void inject(HeroDetailsActivity context);
}
