package fr.everydaysapps.marvelsuperheroes.application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Debug;
import android.widget.TimePicker;

import java.io.File;

import fr.everydaysapps.marvelsuperheroes.api.HeroApi;
import fr.everydaysapps.marvelsuperheroes.models.Hero;
import fr.everydaysapps.marvelsuperheroes.models.Heroes;
import fr.everydaysapps.marvelsuperheroes.utils.rx.AppRxSchedulers;
import fr.everydaysapps.marvelsuperheroes.utils.rx.RxSchedulers;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import timber.log.BuildConfig;
import timber.log.Timber;

/**
 * Created by ygharsallah on 30/03/2017.
 */



public class AppController extends Application {

    // il nous faut le context App context
    // retrofit
    // Okhttpclient                                  GsonFactory               RxApadter
    //  Logging Interceptor &&  Cache
    //                          File cache





    @Override
    public void onCreate() {
        super.onCreate();
        initialiseLogger();


        Context context = this.getApplicationContext();



        SharedPreferences preferences  = context.getSharedPreferences("" , 0);



        RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(AppRxSchedulers.INTERNET_SCHEDULERS);

        GsonConverterFactory gson = GsonConverterFactory.create();

        OkHttpClient.Builder  builder = new OkHttpClient().newBuilder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(httpLoggingInterceptor);

        File cacheFile = new File("path_to_file");

        Cache cache = new Cache(cacheFile, 10*10*1000 );

        builder.cache(cache);


        OkHttpClient client =  builder.build();





        Retrofit retrofit = new Retrofit.Builder().client(client).baseUrl("url").addConverterFactory(gson).addCallAdapterFactory(rxAdapter).build();


        HeroApi api =   retrofit.create(HeroApi.class);


        Subscription sb = api.getHeroes().subscribeOn(AppRxSchedulers.INTERNET_SCHEDULERS).observeOn(new AppRxSchedulers().androidThread()).subscribe(new Subscriber<Heroes>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Heroes heroes) {

            }
        });









    }






    private void initialiseLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new Timber.Tree() {
                @Override
                protected void log(int priority, String tag, String message, Throwable t) {
                    //TODO  decide what to log in release version
                }
            });
        }
    }
}
