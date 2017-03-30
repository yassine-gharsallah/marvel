package fr.everydaysapps.marvelsuperheroes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = new TextView(this);

        text.setOnClickListener(view -> Toast.makeText(MainActivity.this,"ffff", Toast.LENGTH_LONG).show());




    }
}
