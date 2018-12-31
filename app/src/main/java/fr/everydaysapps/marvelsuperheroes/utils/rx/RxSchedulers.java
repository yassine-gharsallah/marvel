package fr.everydaysapps.marvelsuperheroes.utils.rx;


import io.reactivex.Scheduler;

/**
 * Created by ygharsallah on 30/03/2017.
 */

public interface RxSchedulers {


    Scheduler runOnBackground();

    Scheduler io();

    Scheduler compute();

    Scheduler androidThread();

    Scheduler internet();



}
