package fr.everydaysapps.marvelsuperheroes.application.builder;

import java.io.File;

import dagger.Module;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by ygharsallah on 30/03/2017.
 */


@Module(includes = {CacheModule.class, })
public class OkHttpClientModule {

    OkHttpClient provideHttpClient(HttpLoggingInterceptor  logger ,Cache cache )
    {

        OkHttpClient.Builder  builder = new OkHttpClient().newBuilder();
        builder.addInterceptor(logger);
        builder.cache(cache);
       return   builder.build();
    }


}
