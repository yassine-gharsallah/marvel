package fr.everydaysapps.marvelsuperheroes.screens.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import fr.everydaysapps.marvelsuperheroes.models.Hero;
import fr.everydaysapps.marvelsuperheroes.screens.details.core.HeroDetailsView;
import fr.everydaysapps.marvelsuperheroes.screens.details.dagger.DaggerHeroDetailsComponent;
import fr.everydaysapps.marvelsuperheroes.screens.details.dagger.HeroDetailsModule;

/**
 * Created by yassinegharsallah on 02/04/2017.
 */

public class HeroDetailsActivity extends AppCompatActivity {


    @Inject
    HeroDetailsView view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Hero hero = (Hero) getIntent().getExtras().get("hero");

        DaggerHeroDetailsComponent.builder().heroDetailsModule(new HeroDetailsModule(this, hero)).build().inject(this);

        setContentView(view.view());

    }
}
