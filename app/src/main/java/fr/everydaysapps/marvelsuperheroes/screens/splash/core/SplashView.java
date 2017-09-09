package fr.everydaysapps.marvelsuperheroes.screens.splash.core;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import butterknife.ButterKnife;
import fr.everydaysapps.marvelsuperheroes.R;
import fr.everydaysapps.marvelsuperheroes.screens.splash.SplashScreenActivity;

/**
 * Created by yassinegharsallah on 01/04/2017.
 */

public class SplashView {

    private View view;

    public SplashView(SplashScreenActivity context) {
        FrameLayout parent = new FrameLayout(context);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(context).inflate(R.layout.activity_splash, parent, true);
        ButterKnife.bind(view, context);
    }

    public View constructView() {
        return view;
    }


}
