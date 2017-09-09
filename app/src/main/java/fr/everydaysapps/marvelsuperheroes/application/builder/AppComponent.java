package fr.everydaysapps.marvelsuperheroes.application.builder;

import dagger.Component;
import fr.everydaysapps.marvelsuperheroes.api.HeroApi;
import fr.everydaysapps.marvelsuperheroes.utils.rx.RxSchedulers;

/**
 * Created by ygharsallah on 30/03/2017.
 */
@AppScope
@Component(modules = {NetworkModule.class, AppContextModule.class, RxModule.class, HereosApiServiceModule.class})
public interface AppComponent {

    RxSchedulers rxSchedulers();
    HeroApi apiService();


}
