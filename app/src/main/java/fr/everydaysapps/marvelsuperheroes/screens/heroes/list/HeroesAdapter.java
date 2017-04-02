package fr.everydaysapps.marvelsuperheroes.screens.heroes.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import fr.everydaysapps.marvelsuperheroes.R;
import fr.everydaysapps.marvelsuperheroes.models.Hero;
import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by yassinegharsallah on 01/04/2017.
 */

public class HeroesAdapter extends RecyclerView.Adapter<HeroViewHolder> {

    private final PublishSubject<Integer> itemClicks = PublishSubject.create();
    ArrayList<Hero> listHeroes = new ArrayList<>();


    public void swapAdapter(ArrayList<Hero> heroes)
    {
        this.listHeroes.clear();
        this.listHeroes.addAll(heroes);
        notifyDataSetChanged();
    }

    public Observable<Integer> observeClicks() {
        return itemClicks;
    }


    @Override
    public HeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hero, parent, false);
        return new HeroViewHolder(view ,itemClicks);
    }

    @Override
    public void onBindViewHolder(HeroViewHolder holder, int position) {

        Hero hero = listHeroes.get(position);
        holder.bind(hero);

    }


    @Override
    public int getItemCount() {
        if (listHeroes != null && listHeroes.size() > 0) {
            return listHeroes.size();
        } else {
            return 0;
        }
    }
}
