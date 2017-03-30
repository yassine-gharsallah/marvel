package fr.everydaysapps.marvelsuperheroes.application.builder;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;

/**
 * Created by ygharsallah on 30/03/2017.
 */

@Module (includes = {CacheModule.class})
public class CacheModule {

    @Provides
    Cache provideCache(File file) {
        return new Cache(file, 10 * 10 * 1000);
    }

}
