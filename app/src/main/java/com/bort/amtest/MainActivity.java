package com.bort.amtest;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
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
                mInterstitialAd.setAdUnitId("ca-app-pub-6760835969070814/4954882160");
                //real: ca-app-pub-6760835969070814/4954882160
                //testing: ca-app-pub-3940256099942544/1033173712

                mInterstitialAd.setAdListener(new AdListener() {
                    @Override
                    public void onAdLoaded() {
                        // Code to be executed when an ad finishes loading.
                        Log.d("admob","onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(int errorCode) {
                        // Code to be executed when an ad request fails.
                        Log.d("admob","onAdFailedToLoad");
                    }

                    @Override
                    public void onAdOpened() {
                        // Code to be executed when the ad is displayed.
                        Log.d("admob","onAdOpened");
                    }

                    @Override
                    public void onAdClicked() {
                        // Code to be executed when the user clicks on an ad.
                        Log.d("admob","onAdClicked");
                    }

                    @Override
                    public void onAdLeftApplication() {
                        // Code to be executed when the user has left the app.
                        Log.d("admob","onAdLeftApplication");
                    }

                    @Override
                    public void onAdClosed() {
                        // Code to be executed when the interstitial ad is closed.
                        Log.d("admob","onAdClosed");
                    }
                });
            }
        });

        load_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mInterstitialAd.loadAd(new AdRequest.Builder().build());

            }
        });

        play_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

    }
}
