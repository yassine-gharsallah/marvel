package fr.everydaysapps.marvelsuperheroes.api;


import fr.everydaysapps.marvelsuperheroes.models.Heroes;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by ygharsallah on 30/03/2017.
 */

public interface HeroApi {

    @GET("test-mobile/iOS/json/test2.json")
    Observable<Heroes> getHeroes();


}
