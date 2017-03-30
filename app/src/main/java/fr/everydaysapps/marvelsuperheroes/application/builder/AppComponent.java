package fr.everydaysapps.marvelsuperheroes.application.builder;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by ygharsallah on 30/03/2017.
 */

@Component(dependencies = {RetrofitModule.class})
public interface AppComponent {

    Retrofit provideNetworkApi();

}
