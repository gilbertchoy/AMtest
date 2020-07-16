package com.bort.amtest;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.InterstitialAd;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private Button init_btn, play_btn, load_btn;
    private Context context = this;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_btn = findViewById(R.id.init);
        play_btn = findViewById(R.id.play);
        load_btn = findViewById(R.id.load);

        init_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MobileAds.initialize(context, new OnInitializationCompleteListener() {
                    @Override
                    public void onInitializationComplete(InitializationStatus initializationStatus) {
                        Log.wtf("admob","onInitializationComplete");
                    }
                });
                mInterstitialAd = new InterstitialAd(context);
                mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
            }
        });

        load_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String x = MobileAds.getVersionString();

                Log.i("admob", String.format("init status:" + MobileAds.getInitializationStatus()));

                MobileAds.getInitializationStatus();
            }
        });

        play_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

    }
}
