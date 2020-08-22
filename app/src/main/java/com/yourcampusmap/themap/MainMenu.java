package com.yourcampusmap.themap;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class MainMenu extends SherlockFragmentActivity{

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
/*
        //Use VideoView -- to change video, replace R.raw.(Name Here)
        videoView = (VideoView)findViewById(R.id.VideoView);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.video_file_2;

        //Sets the Video into URI and then starts it initially in background once
        videoView.setVideoURI(Uri.parse(path));
        videoView.start();

        //This Function is for starting video after coming back from other classes
        //and to loop it continuously forever and ever
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                mp.setLooping(true);
            }
        });*/
    }

    public void goBuildings(View view){
        Intent intent = new Intent(this, Buildings.class);
        startActivity(intent);
    }


    public void goShuttleStops(View view) {
        Intent intent = new Intent(this, CampusStops.class);
        startActivity(intent);

    }

    public void goEatPlace(View view){
        Intent intent = new Intent(this, PlacesToEat.class);
        startActivity(intent);
    }
    public void goATM(View view){
        Intent intent = new Intent(this, ATM.class);
        startActivity(intent);
    }
    public void goLocation(View view){
        Intent intent = new Intent(this, LocationActivity.class);
        startActivity(intent);
    }
    public void goLocation2(View view){
        Intent intent = new Intent(this, LocationActivity2.class);
       // intent.putExtra("userurl", url);
        startActivity(intent);
    }
    public void goInfo(View view){
        Intent intent = new Intent(this, Information.class);
        startActivity(intent);
    }

    public void goParking(View view){
        Intent intent = new Intent(this, Parking.class);
        startActivity(intent);
    }
/*
    @Override
    public boolean onOptionsItemSelected(com.actionbarsherlock.view.MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, MainMenu.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
        }
        return true;
    }
*/
}
