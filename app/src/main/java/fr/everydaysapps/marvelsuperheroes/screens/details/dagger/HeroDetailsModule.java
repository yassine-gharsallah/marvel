package fr.everydaysapps.marvelsuperheroes.screens.details.dagger;

import dagger.Module;
import dagger.Provides;
import fr.everydaysapps.marvelsuperheroes.models.Hero;
import fr.everydaysapps.marvelsuperheroes.screens.details.HeroDetailsActivity;
import fr.everydaysapps.marvelsuperheroes.screens.details.core.HeroDetailsView;

/**
 * Created by yassinegharsallah on 02/04/2017.
 */

@Module
public class HeroDetailsModule  {

    HeroDetailsActivity detailsContext;
    Hero hero;

    public HeroDetailsModule(HeroDetailsActivity context, Hero aHero)
    {
        this.detailsContext = context;
        this.hero = aHero;
    }

    @Provides
    HeroDetailsView provideView()
    {
        return  new HeroDetailsView(detailsContext,hero);
    }
}
