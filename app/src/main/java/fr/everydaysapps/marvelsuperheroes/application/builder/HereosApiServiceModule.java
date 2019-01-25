package fr.everydaysapps.marvelsuperheroes.application.builder;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import dagger.Module;
import dagger.Provides;
import fr.everydaysapps.marvelsuperheroes.api.HeroApi;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yassinegharsallah on 31/03/2017.
 */

@Module
public class HereosApiServiceModule {

    private static final String BASE_URL = "http://coemygroup.fr/";
    @AppScope
    @Provides
    HeroApi provideApiService(OkHttpClient client, GsonConverterFactory gson, RxJava2CallAdapterFactory rxAdapter)
    {
        Retrofit retrofit =   new Retrofit.Builder().client(client)
                .baseUrl(BASE_URL).addConverterFactory(gson).
                        addCallAdapterFactory(rxAdapter).build();

        return  retrofit.create(HeroApi.class);
    }


}
