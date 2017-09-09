package fr.everydaysapps.marvelsuperheroes.application;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import fr.everydaysapps.marvelsuperheroes.application.builder.AppComponent;
import fr.everydaysapps.marvelsuperheroes.application.builder.AppContextModule;
import fr.everydaysapps.marvelsuperheroes.application.builder.DaggerAppComponent;
import timber.log.BuildConfig;
import timber.log.Timber;

/**
 * Created by ygharsallah on 30/03/2017.
 */


public class AppController extends Application {


    private static AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        initialiseLogger();
        initAppComponent();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder().appContextModule(new AppContextModule(this)).build();
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

    public static AppComponent getNetComponent() {
        return appComponent;
    }

}
