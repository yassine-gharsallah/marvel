package fr.everydaysapps.marvelsuperheroes.application.builder;

import dagger.Module;
import dagger.Provides;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by ygharsallah on 30/03/2017.
 */

@Module
public class logInterceptorModule {

    @Provides
    HttpLoggingInterceptor provideInterceptor()
    {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

}
