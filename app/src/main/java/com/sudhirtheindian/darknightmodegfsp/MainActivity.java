package com.sudhirtheindian.darknightmodegfsp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    /*
    Dark mode or night mode has been getting a lot of buzz lately as Google has included it
    into their Latest Android version i.e Android Q(API Level 29) and following that more and
     more apps started supporting dark mode natively because it has many benefits:Dark mode or night mode
     has been getting a lot of buzz lately as Google has included it into their Latest
      Android version i.e Android Q(API Level 29) and following that more and more apps started supporting dark mode
       natively because it has many benefits:

       Reduces battery/power usage.
     Improves visibility for users with low vision and those who are sensitive to bright light.
       Makes it easier to use device in a low-light.
     */
    private Button btnToggleDark;

//    @SuppressLint("SetTextI18n")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToggleDark = findViewById(R.id.btnToggleDark);

        // Saving state of our app
        // using SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        final boolean isDarkModeOn = sharedPreferences.getBoolean("isDarkModeOn", false);

        // When user reopens the app
        // after applying dark/light mode
        if (isDarkModeOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            btnToggleDark.setText("Disable Dark Mode");
        }
        else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            btnToggleDark.setText("Enable Dark Mode");
        }



        btnToggleDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When user taps the enable/disable
                // dark mode button
                if (isDarkModeOn) {

                    // if dark mode is on it
                    // will turn it off

                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    // it will set isDarkModeOn
                    // boolean to false
                    editor.putBoolean("isDarkModeOn", false);
                    editor.apply();

                    // change text of Button
                    btnToggleDark.setText("Enable Dark Mode");
                }
                else {

                    // if dark mode is off
                    // it will turn it on
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                    // it will set isDarkModeOn
                    // boolean to true
                    editor.putBoolean("isDarkModeOn", true);
                    editor.apply();

                    // change text of Button
                    btnToggleDark.setText("Disable Dark Mode");
                }
            }
        });



    }
}
/*
   in kotlin
      // Declare the switch from the layout file
        val btn = findViewById<Switch>(R.id.switch1)

        // set the switch to listen on checked change
        btn.setOnCheckedChangeListener { _, isChecked ->

            // if the button is checked, i.e., towards the right or enabled
            // enable dark mode, change the text to disable dark mode
            // else keep the switch text to enable dark mode
            if (btn.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                btn.text = "Disable dark mode"
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                btn.text = "Enable dark mode"
            }
 */