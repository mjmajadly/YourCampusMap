package com.yourcampusmap.themap;

import android.content.Intent;
import android.location.Criteria;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



public class ATM extends SherlockFragmentActivity {

    private SupportMapFragment mapFragment;
    private GoogleMap googleMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //View Google Maps
        setContentView(R.layout.activity_atm);

        //GPS Location Devices
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        googleMap = mapFragment.getMap();
        googleMap.setMyLocationEnabled(true);

        //Set up ATM Locations
        LatLng ATM1 = new LatLng(39.544734, -119.816497);
        Marker Main1 = googleMap.addMarker(new MarkerOptions()
                .position(ATM1)
                .title("Bank of America")
                .snippet("Joe Crowley Student Union: Second Floor"));
        LatLng ATM2 = new LatLng(39.544666, -119.816518);
        Marker Main2 = googleMap.addMarker(new MarkerOptions()
                .position(ATM2)
                .title("Wells Fargo")
                .snippet("Joe Crowley Student Union: Second Floor"));


        //Set up Map Type
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        // googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);
        // googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        // googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        //googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // googleMap.moveCamera(CameraUpdateFactory()
        // googleMap.animateCamera(CameraUpdateFactory.zoomTo(10));
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
