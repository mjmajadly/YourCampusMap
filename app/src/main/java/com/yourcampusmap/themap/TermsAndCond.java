package com.yourcampusmap.themap;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;


public class TermsAndCond extends SherlockActivity {

 /*   public void onCreate(){
        boolean firstboot = getSharedPreferences("BOOT_PREF", MODE_PRIVATE).getBoolean("firstboot", true);

        if (firstboot){
            // 1) Launch the authentication activity

            // 2) Then save the state
            getSharedPreferences("BOOT_PREF", MODE_PRIVATE)
                    .edit()
                    .putBoolean("firstboot", false)
                    .commit();
        }
    }
*/
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);
       // goTermsCond();
       // setContentView(R.layout.terms_cond);
    }

    public void goTermsCond(View view){
        setContentView(R.layout.terms_cond);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getSupportMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.menu_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void gotoactivity (View v) {

        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);

    }

}