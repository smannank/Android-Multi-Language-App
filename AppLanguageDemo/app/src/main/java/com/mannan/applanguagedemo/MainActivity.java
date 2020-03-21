package com.mannan.applanguagedemo;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button btnLanguage;
    private AppConfigFile appConfig;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        btnLanguage = findViewById(R.id.btnLanguage);


        //Set User's Selected Language, retrieved from shared preference file (AppConfigFile)
        //If no language choice is found then set it to default english
        appConfig = new AppConfigFile(this.getApplicationContext());
        String sSysLanguage = appConfig.getsSysLanguage();
        Toast.makeText(this, "Selected Language " + sSysLanguage, Toast.LENGTH_SHORT).show();
        if (sSysLanguage != null) {
            Locale locale;
            switch (sSysLanguage) {
                case "Marathi":
                    locale = new Locale("mr");
                    break;
                default:
                    locale = new Locale("en");
                    break;
            }
            Configuration newConfig = new Configuration();
            newConfig.locale = locale;
            onConfigurationChanged(newConfig);
        }

        super.onCreate(savedInstanceState);
    }


    public void buttonPressed(View view) {

        //Change App Language on button Click
        if (view.getId() == R.id.btnLanguage) {
            Button b = (Button) view;
            String Language = String.valueOf(b.getText());
            Locale locale;
            switch (Language) {
                case "मराठी":
                    locale = new Locale("mr");
                    appConfig.setsSysLanguage("Marathi");
                    break;
                default:
                    locale = new Locale("en");
                    appConfig.setsSysLanguage("English");
                    break;
            }
            Toast.makeText(this, "Selected Language " +  appConfig.getsSysLanguage(), Toast.LENGTH_SHORT).show();

            Configuration newConfig = new Configuration();
            newConfig.locale = locale;
            onConfigurationChanged(newConfig);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getBaseContext().getResources().updateConfiguration(newConfig, getBaseContext().getResources().getDisplayMetrics());
        setContentView(R.layout.activity_main);
        setTitle(R.string.app_name);

    }

}

