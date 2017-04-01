package fr.everydaysapps.marvelsuperheroes.application.builder;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yassinegharsallah on 31/03/2017.
 */
@Module
public class AppContextModule {


    private final Context context;

    public AppContextModule(Context aContext) {
        this.context = aContext;
    }

    @AppScope
    @Provides
    Context provideAppContext() {
        return context;
    }

}
