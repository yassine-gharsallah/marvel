package fr.everydaysapps.marvelsuperheroes.application.builder;

import java.io.File;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ygharsallah on 30/03/2017.
 */
@Module
public class FileModule {

    @Provides
    File provideCacheFile()
    {
        return new File("path_to_file");
    }

}
