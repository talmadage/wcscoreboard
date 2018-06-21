package com.example.chinmaypurandare.wcscoreboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button click;
    public static TextView match;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                click = findViewById(R.id.button3);
                match = findViewById(R.id.match);

            click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FetchData process = new FetchData();
                    process.execute();

                }
            });
    }
}
