package fr.everydaysapps.marvelsuperheroes.utils;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import fr.everydaysapps.marvelsuperheroes.R;
import timber.log.Timber;

/**
 * Created by yassinegharsallah on 01/04/2017.
 */

public class UiUtils {


    public static void handleThrowable(Throwable throwable) {
        Timber.e(throwable, throwable.toString());
    }

    public static void showSnackbar(View view, String message, int length) {
        Snackbar.make(view, message, length).setAction("Action", null).show();
    }

    private static void launchFragmentKeepingInBackStack(Context context, Fragment fragmentToLaunch, String fragmentTag) {
        FragmentManager supportFragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, fragmentToLaunch, fragmentTag)
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }

    public static void launchFragmentKeepingInBackStack(Context context, Fragment fragmentToLaunch) {
        launchFragmentKeepingInBackStack(context, fragmentToLaunch, fragmentToLaunch.getClass().getName());
    }

    public static void launchFragmentWithoutKeepingInBackStack(Context context, Fragment fragmentToLaunch) {
        launchFragmentWithoutKeepingInBackStack(context, fragmentToLaunch, fragmentToLaunch.getClass().getName());
    }

    private static void launchFragmentWithoutKeepingInBackStack(Context context, Fragment fragmentToLaunch, String fragmentTag) {
        FragmentManager supportFragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, fragmentToLaunch, fragmentTag)
                .commitAllowingStateLoss();
    }
}
