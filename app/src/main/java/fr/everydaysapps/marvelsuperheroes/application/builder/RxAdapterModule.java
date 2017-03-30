package fr.everydaysapps.marvelsuperheroes.application.builder;

import dagger.Module;
import dagger.Provides;
import fr.everydaysapps.marvelsuperheroes.utils.rx.AppRxSchedulers;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by ygharsallah on 30/03/2017.
 */

@Module
public class RxAdapterModule  {

    @Provides
    RxJavaCallAdapterFactory provideRxAdapter()
    {
        return RxJavaCallAdapterFactory.createWithScheduler(AppRxSchedulers.INTERNET_SCHEDULERS);
    }

}
