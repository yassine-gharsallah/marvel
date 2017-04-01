package fr.everydaysapps.marvelsuperheroes.application.builder;

import dagger.Module;
import dagger.Provides;
import fr.everydaysapps.marvelsuperheroes.utils.rx.AppRxSchedulers;
import fr.everydaysapps.marvelsuperheroes.utils.rx.RxSchedulers;

/**
 * Created by yassinegharsallah on 31/03/2017.
 */

@Module
public class RxModule {

    @Provides
    RxSchedulers provideRxSchedulers() {
        return new AppRxSchedulers();
    }
}
