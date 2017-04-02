package fr.everydaysapps.marvelsuperheroes.screens.heroes.core;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.everydaysapps.marvelsuperheroes.R;
import fr.everydaysapps.marvelsuperheroes.models.Hero;
import fr.everydaysapps.marvelsuperheroes.screens.heroes.HeroesListActivity;
import fr.everydaysapps.marvelsuperheroes.screens.heroes.list.HeroesAdapter;
import rx.Observable;

/**
 * Created by yassinegharsallah on 01/04/2017.
 */

public class HeroesView {

    @BindView(R.id.activity_heroes_list_recycleview)
    RecyclerView list;

    View view;

    HeroesAdapter adapter;

    public HeroesView(HeroesListActivity context ) {
        FrameLayout parent = new FrameLayout(context);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(context).inflate(R.layout.activity_heroes_list, parent, true);
        ButterKnife.bind(this, view);

        adapter = new HeroesAdapter();

        list.setAdapter(adapter);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        list.setLayoutManager(mLayoutManager);


    }

    public Observable<Integer>  itemClicks()
    {
        return adapter.observeClicks();
    }

    public View view() {
        return view;
    }

    public void swapAdapter(ArrayList<Hero> heroes)
    {
        adapter.swapAdapter(heroes);
    }

}
