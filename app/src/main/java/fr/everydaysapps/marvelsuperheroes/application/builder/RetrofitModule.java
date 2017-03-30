package fr.everydaysapps.marvelsuperheroes.application.builder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ygharsallah on 30/03/2017.
 */

@Module(includes = {GsonModule.class , RxAdapterModule.class, OkHttpClientModule.class})
public class RetrofitModule {
    @Provides
    Retrofit provideRetrofit(OkHttpClient client , GsonConverterFactory gson , RxJavaCallAdapterFactory rxAdapter)
    {
        return new Retrofit.Builder().client(client).baseUrl("url").addConverterFactory(gson).addCallAdapterFactory(rxAdapter).build();
    }

}
