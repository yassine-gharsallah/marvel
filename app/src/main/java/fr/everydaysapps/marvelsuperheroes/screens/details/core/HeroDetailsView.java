package fr.everydaysapps.marvelsuperheroes.screens.details.core;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.everydaysapps.marvelsuperheroes.R;
import fr.everydaysapps.marvelsuperheroes.models.Hero;
import fr.everydaysapps.marvelsuperheroes.screens.details.HeroDetailsActivity;

/**
 * Created by yassinegharsallah on 02/04/2017.
 */

public class HeroDetailsView {


    @BindView(R.id.hero_details_activity_image)
    ImageView  imageHero;
    @BindView(R.id.hero_details_activity_intro)
    TextView introduction;
    @BindView(R.id.hero_details_activity_text)
    TextView text;

    View view;

    public HeroDetailsView(HeroDetailsActivity activity, Hero hero)
    {
        FrameLayout layout = new FrameLayout(activity);
        layout.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        view = LayoutInflater.from(activity).inflate(R.layout.activity_hero_details,layout,true);
        ButterKnife.bind(this,view);

        Glide.with(activity).load(hero.getImage()).into(imageHero);
        introduction.setText(TextUtils.isEmpty(hero.getIntro()) ? "no intro" : hero.getIntro());
        text.setText(TextUtils.isEmpty(hero.getText()) ? "no text" : hero.getText());

    }

    public View view()
    {
        return view;
    }



}
