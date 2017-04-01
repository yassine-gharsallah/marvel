package fr.everydaysapps.marvelsuperheroes.application.builder;

import android.content.Context;

import dagger.Component;
import fr.everydaysapps.marvelsuperheroes.MainActivity;
import fr.everydaysapps.marvelsuperheroes.api.HeroApi;
import fr.everydaysapps.marvelsuperheroes.utils.rx.RxSchedulers;
import retrofit2.Retrofit;

/**
 * Created by ygharsallah on 30/03/2017.
 */
@AppScope
@Component(modules = {NetworkModule.class, AppContextModule.class, RxModule.class, HereosApiServiceModule.class})
public interface AppComponent {


    Context getAppContext();

    RxSchedulers rxSchedulers();


    HeroApi apiService();


    // void inject(MainActivity activity);
    //Retrofit provideNetworkApi();

}
