package com.yourcampusmap.themap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Intent;
import android.graphics.Color;
import android.location.Criteria;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.actionbarsherlock.app.ActionBar;
import com.google.android.gms.maps.SupportMapFragment;
import com.actionbarsherlock.app.ActionBar.OnNavigationListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.apache.http.HttpConnection;
import org.json.JSONObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;


public class LocationActivity extends SherlockFragmentActivity {

    LatLng KC = new LatLng(39.543402, -119.815747);
    LatLng SEM = new LatLng(39.539869, -119.813425);
    LatLng Stadium = new LatLng(39.546949, -119.817585);

    private SupportMapFragment mapFragment;
    private GoogleMap googleMap;
    //Google_Directions dir;

    String[] actions = new String[] {
            "KC",
            "SEM",
            "Stadium"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //View Google Maps
        setContentView(R.layout.activity_location);

        //GPS Location Devices
        //dir = new Google_Directions();
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        googleMap = mapFragment.getMap();
        googleMap.setMyLocationEnabled(true);

       // googleMap.moveCamera(CameraUpdateFactory()
       // googleMap.animateCamera(CameraUpdateFactory.zoomTo(10));


        //Set up Map Type
         googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
       // googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);
        // googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        // googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        //googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        //Marker for Destinations
        MarkerOptions options = new MarkerOptions();
        options.position(KC);
        options.position(SEM);
        options.position(Stadium);
        googleMap.addMarker(options);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(KC,
                13));
        addMarkers();

        // Show lines from GPS to Destination
     //   Document doc = dir.getDocument(KC, SEM, Google_Directions.MODE_DRIVING);
        //int duration = dir.getDurationValue(doc);
        //String distance = dir.getDistanceText(doc);
        //String start_address = dir.getStartAddress(doc);
       // String copy_right = dir.getCopyRights(doc);
     //   ArrayList<LatLng> directionPoint = dir.getDirection(doc);
        PolylineOptions rectLine = new PolylineOptions().width(3).color(Color.RED);

       // for(int i = 0 ; i < directionPoint.size() ; i++) {
         //   rectLine.add(directionPoint.get(i));
       // }

        googleMap.addPolyline(rectLine);







        //Start of the creating of the DropDown Menu
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), R.layout.sherlock_spinner_item, actions);
        getSupportActionBar().setNavigationMode(com.actionbarsherlock.app.ActionBar.NAVIGATION_MODE_LIST);
        ActionBar.OnNavigationListener navigationListener = new ActionBar.OnNavigationListener() {


            @Override
            public boolean onNavigationItemSelected(int itemPosition, long itemId) {
                Toast.makeText(getBaseContext(), "Current Action : " + actions[itemPosition], Toast.LENGTH_SHORT).show();


                return false;
            }
        };
        getSupportActionBar().setListNavigationCallbacks(adapter, navigationListener);
        adapter.setDropDownViewResource(R.layout.sherlock_spinner_dropdown_item);
        //Finish Drop Down Menu
    }

    private void addMarkers() {
        if (googleMap != null) {
            googleMap.addMarker(new MarkerOptions().position(KC)
                    .title("First Point"));
            googleMap.addMarker(new MarkerOptions().position(SEM)
                    .title("Second Point"));
            googleMap.addMarker(new MarkerOptions().position(Stadium)
                    .title("Third Point"));
        }
    }




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

}