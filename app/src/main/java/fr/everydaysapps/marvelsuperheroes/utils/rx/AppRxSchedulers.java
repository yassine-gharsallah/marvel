package fr.everydaysapps.marvelsuperheroes.utils.rx;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ygharsallah on 30/03/2017.
 */

public class AppRxSchedulers implements RxSchedulers {


    public static Executor backgroundExecutor = Executors.newCachedThreadPool();
    public static Scheduler BACKGROUND_SCHEDULERS = Schedulers.from(backgroundExecutor);
    public static Executor internetExecutor = Executors.newCachedThreadPool();
    public static Scheduler INTERNET_SCHEDULERS = Schedulers.from(internetExecutor);

    @Override
    public Scheduler runOnBackground() {
        return BACKGROUND_SCHEDULERS;
    }

    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    public Scheduler compute() {
        return Schedulers.computation();
    }

    @Override
    public Scheduler androidThread() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public Scheduler internet() {
        return INTERNET_SCHEDULERS;
    }
}
