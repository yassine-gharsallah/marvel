package fr.everydaysapps.marvelsuperheroes.application.builder;

import dagger.Module;
import dagger.Provides;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ygharsallah on 30/03/2017.
 */

@Module
public class GsonModule {

    @Provides
    GsonConverterFactory  provideGsonClient()
    {
        return GsonConverterFactory.create();
    }

}
