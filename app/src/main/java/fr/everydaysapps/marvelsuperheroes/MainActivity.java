package fr.everydaysapps.marvelsuperheroes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import fr.everydaysapps.marvelsuperheroes.application.AppController;
import fr.everydaysapps.marvelsuperheroes.application.builder.AppComponent;
import fr.everydaysapps.marvelsuperheroes.models.Heroes;
import fr.everydaysapps.marvelsuperheroes.utils.rx.RxSchedulers;
import retrofit2.Retrofit;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = (TextView) findViewById(R.id.hello);

        text.setOnClickListener(view -> Toast.makeText(MainActivity.this,"ffff", Toast.LENGTH_LONG).show());

        AppComponent contro =   ((AppController) getApplication()).getNetComponent();

        AppComponent contro1 =   ((AppController) getApplication()).getNetComponent();



        Log.i("ccc",contro.toString());
        Log.i("ddd",contro1.toString());
        RxSchedulers schedule = contro.rxSchedulers();
       // CompositeSubscription compositeSubscription = new CompositeSubscription();

//        compositeSubscription.add(
//        contro.apiService().getHeroes().subscribeOn(schedule.internet()).observeOn(schedule.androidThread()).subscribe(heroes -> {
//            Timber.i("fgg");
//            text.setText(heroes.getElements().get(0).getTitle());
//        }));




        Subscription sub = ((AppController) getApplication()).getNetComponent().apiService().getHeroes().subscribe(new Subscriber<Heroes>() {
            @Override
            public void onCompleted() {
                Timber.i("fgg-complete");

            }

            @Override
            public void onError(Throwable e) {
                Timber.i("fgg", e);
            }

            @Override
            public void onNext(Heroes heroes) {
                Timber.i("fgg");
                text.setText(heroes.getElements().get(0).getTitle());
            }
        });


//compositeSubscription.add(sub);



    }
}
