package com.yourcampusmap.themap;

import android.content.Intent;
import android.graphics.Color;
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
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class CampusStops extends SherlockFragmentActivity {

    private SupportMapFragment mapFragment;
    private GoogleMap googleMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //View Google Maps
        setContentView(R.layout.activity_campus_stops);

        //GPS Location Devices
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        googleMap = mapFragment.getMap();
        googleMap.setMyLocationEnabled(true);

        //Set up Campus Stop Locations for the Main Shuttle
        LatLng Stop1 = new LatLng(39.543791, -119.816909);
        Marker Main1 = googleMap.addMarker(new MarkerOptions()
                .position(Stop1)
                .title("Knowledge Center Shuttle Stop"));
        // .snippet("Knowledge Center Shuttle Stop"));
        LatLng Stop2 = new LatLng(39.542377, -119.815791);
        Marker Main2 = googleMap.addMarker(new MarkerOptions()
                .position(Stop2)
                .title("Fitzgerald Shuttle Stop"));
        //.snippet("Fitzgerald Shuttle Stop"));
        LatLng Stop3 = new LatLng(39.540560, -119.816274);
        Marker Main3 = googleMap.addMarker(new MarkerOptions()
                .position(Stop3)
                .title("Church of Fine Arts Shuttle Stop"));
        // .snippet("Church of Fine Arts Shuttle Stop"));
        LatLng Stop4 = new LatLng(39.545561, -119.816151);
        Marker Main4 = googleMap.addMarker(new MarkerOptions()
                .position(Stop4)
                .title("Lombardi Shuttle Stop"));
        // .snippet("Lombardi Shuttle Stop"));
        LatLng Stop5 = new LatLng(39.548433, -119.817021);
        Marker Main5 = googleMap.addMarker(new MarkerOptions()
                .position(Stop5)
                .title("Medical Shuttle Stop"));
        // .snippet("Medical Shuttle Stop"));
        LatLng Stop6 = new LatLng(39.550886, -119.819202);
        Marker Main6 = googleMap.addMarker(new MarkerOptions()
                .position(Stop6)
                .title("Blue Shuttle Stop"));
        // .snippet("Blue Shuttle Stop"));
        LatLng Stop7 = new LatLng(39.548110, -119.819105);
        Marker Main7 = googleMap.addMarker(new MarkerOptions()
                .position(Stop7)
                .title("Green Shuttle Stop"));
        // .snippet("Green Shuttle Stop"));
        LatLng Stop8 = new LatLng(39.546039, -119.818008);
        Marker Main8 = googleMap.addMarker(new MarkerOptions()
                .position(Stop8)
                .title("Parking Garage Shuttle Stop"));
        //.snippet("Parking Garage Shuttle Stop"));

        //Campus Bus Route for Main Shuttle
        Polyline line = googleMap.addPolyline(new PolylineOptions()
                .add(new LatLng(39.542354, -119.815696),
                        new LatLng(39.541951, -119.815674),
                        new LatLng(39.541759, -119.815964),
                        new LatLng(39.541167, -119.816143),
                        new LatLng(39.540701, -119.816159),
                        new LatLng(39.540142, -119.816359),
                        new LatLng(39.540157, -119.817090),
                        new LatLng(39.542267, -119.817081),
                        new LatLng(39.542500, -119.817116),
                        new LatLng(39.542998, -119.817421),
                        new LatLng(39.543945, -119.818416),
                        new LatLng(39.544316, -119.816809),
                        new LatLng(39.545017, -119.816848),
                        new LatLng(39.545313, -119.816651),
                        new LatLng(39.546190, -119.815277),
                        new LatLng(39.546489, -119.815595),
                        new LatLng(39.547928, -119.817222),
                        new LatLng(39.548282, -119.817169),
                        new LatLng(39.548488, -119.817032),
                        new LatLng(39.548615, -119.817185),
                        new LatLng(39.549847, -119.817195),
                        new LatLng(39.550116, -119.817262),
                        new LatLng(39.550648, -119.817793),
                        new LatLng(39.551036, -119.817868),
                        new LatLng(39.551181, -119.818170),
                        new LatLng(39.551066, -119.819132),
                        new LatLng(39.550183, -119.819043),
                        new LatLng(39.549469, -119.819074),
                        new LatLng(39.548471, -119.819038),
                        new LatLng(39.547571, -119.818824),
                        new LatLng(39.547271, -119.818876),
                        new LatLng(39.547011, -119.818833),
                        new LatLng(39.546815, -119.818714),
                        new LatLng(39.545960, -119.817858),
                        new LatLng(39.545796, -119.817702),
                        new LatLng(39.545545, -119.817180),
                        new LatLng(39.545064, -119.816925),
                        new LatLng(39.543804, -119.816836),
                        new LatLng(39.543178, -119.816423),
                        new LatLng(39.542729, -119.816190),
                        new LatLng(39.542479, -119.815748),
                        new LatLng(39.542354, -119.815696))
                .width(5)
                .color(Color.BLUE));

        //Campus Bus Route for East Shuttle
        Polyline line2 = googleMap.addPolyline(new PolylineOptions()
                .add(new LatLng(39.552504, -119.805152),
                        new LatLng(39.552576, -119.804956),
                        new LatLng(39.552657, -119.804963),
                        new LatLng(39.552724, -119.804989),
                        new LatLng(39.552742, -119.805102),
                        new LatLng(39.552687, -119.805217),
                        new LatLng(39.552600, -119.805249),
                        new LatLng(39.552510, -119.805473),
                        new LatLng(39.552427, -119.805605),
                        new LatLng(39.552355, -119.805643),
                        new LatLng(39.552103, -119.805636),
                        new LatLng(39.552006, -119.806161),
                        new LatLng(39.551786, -119.806940),
                        new LatLng(39.551703, -119.807404),
                        new LatLng(39.551521, -119.808580),
                        new LatLng(39.550849, -119.811682),
                        new LatLng(39.550781, -119.811798),
                        new LatLng(39.550735, -119.811815),
                        new LatLng(39.549278, -119.811511),
                        new LatLng(39.549118, -119.811501),
                        new LatLng(39.548823, -119.811505),
                        new LatLng(39.548613, -119.811548),
                        new LatLng(39.548372, -119.811605),
                        new LatLng(39.548125, -119.811711),
                        new LatLng(39.547911, -119.811821),
                        new LatLng(39.547028, -119.812492),
                        new LatLng(39.546088, -119.813206),
                        new LatLng(39.545611, -119.813521),
                        new LatLng(39.544805, -119.813804),
                        new LatLng(39.544578, -119.813839),
                        new LatLng(39.543734, -119.813824),
                        new LatLng(39.543464, -119.813786),
                        new LatLng(39.542732, -119.813457),
                        new LatLng(39.541882, -119.812840),
                        new LatLng(39.541714, -119.812771),
                        new LatLng(39.541120, -119.812707),
                        new LatLng(39.540949, -119.812535),
                        new LatLng(39.540813, -119.812366),
                        new LatLng(39.540669, -119.812209),
                        new LatLng(39.538925, -119.811145),
                        new LatLng(39.538677, -119.811001),
                        new LatLng(39.538429, -119.810965),
                        new LatLng(39.538210, -119.810989),
                        new LatLng(39.538019, -119.811058),
                        new LatLng(39.537859, -119.811186),
                        new LatLng(39.537357, -119.811640),
                        new LatLng(39.537378, -119.811678),
                        new LatLng(39.537437, -119.811772),
                        new LatLng(39.537487, -119.811792),
                        new LatLng(39.537560, -119.811733),
                        new LatLng(39.537617, -119.811663),
                        new LatLng(39.537516, -119.811433),
                        new LatLng(39.537967, -119.811005),
                        new LatLng(39.538128, -119.810937),
                        new LatLng(39.538286, -119.810898),
                        new LatLng(39.538621, -119.810931),
                        new LatLng(39.538820, -119.811003),
                        new LatLng(39.540670, -119.812157),
                        new LatLng(39.540856, -119.812338),
                        new LatLng(39.541044, -119.812591),
                        new LatLng(39.541143, -119.812655),
                        new LatLng(39.541711, -119.812699),
                        new LatLng(39.541893, -119.812771),
                        new LatLng(39.542628, -119.813334),
                        new LatLng(39.543397, -119.813694),
                        new LatLng(39.543820, -119.813789),
                        new LatLng(39.544457, -119.813807),
                        new LatLng(39.544917, -119.813739),
                        new LatLng(39.545363, -119.813590),
                        new LatLng(39.545818, -119.813347),
                        new LatLng(39.547628, -119.811981),
                        new LatLng(39.547696, -119.811972),
                        new LatLng(39.547731, -119.812075),
                        new LatLng(39.547717, -119.812272),
                        new LatLng(39.547546, -119.812931),
                        new LatLng(39.547550, -119.813364),
                        new LatLng(39.547347, -119.813682),
                        new LatLng(39.547008, -119.814581),
                        new LatLng(39.546718, -119.814976),
                        new LatLng(39.546519, -119.815113),
                        new LatLng(39.546349, -119.815159),
                        new LatLng(39.546254, -119.815296),
                        new LatLng(39.547906, -119.817215),
                        new LatLng(39.548319, -119.817159),
                        new LatLng(39.548462, -119.817070),
                        new LatLng(39.548543, -119.817112),
                        new LatLng(39.548584, -119.817175),
                        new LatLng(39.549923, -119.817211),
                        new LatLng(39.550070, -119.817239),
                        new LatLng(39.550217, -119.817332),
                        new LatLng(39.550318, -119.817371),
                        new LatLng(39.550413, -119.817257),
                        new LatLng(39.550450, -119.817129),
                        new LatLng(39.550468, -119.814487),
                        new LatLng(39.550618, -119.812855),
                        new LatLng(39.550897, -119.811392),
                        new LatLng(39.551502, -119.808384),
                        new LatLng(39.551783, -119.806606),
                        new LatLng(39.551973, -119.805821),
                        new LatLng(39.552087, -119.805492),
                        new LatLng(39.552318, -119.805536),
                        new LatLng(39.552397, -119.805503),
                        new LatLng(39.552434, -119.805378),
                        new LatLng(39.552504, -119.805152))
                .width(5)
                .color(Color.GREEN));


        //Campus Stop Location for Sub Shuttle
        LatLng Stop9 = new LatLng(39.537509, -119.811798);
        Marker Sub1 = googleMap.addMarker(new MarkerOptions()
                .position(Stop9)
                .title("Fleishmann Shuttle Stop"));
        //.snippet("Parking Garage Shuttle Stop"));
        LatLng Stop10 = new LatLng(39.540484, -119.812196);
        Marker Sub2 = googleMap.addMarker(new MarkerOptions()
                .position(Stop10)
                .title("Earthquake Lab Shuttle Stop"));
        LatLng Stop11 = new LatLng(39.548417, -119.817035);
        Marker Sub3 = googleMap.addMarker(new MarkerOptions()
                .position(Stop11)
                .title("Medical Shuttle Stop"));
        //.snippet("Parking Garage Shuttle Stop"));
        LatLng Stop12 = new LatLng(39.552425, -119.805104);
        Marker Sub4 = googleMap.addMarker(new MarkerOptions()
                .position(Stop12)
                .title("Highlands Shuttle Stop"));
        //.snippet("Parking Garage Shuttle Stop"));
        LatLng Stop13 = new LatLng(39.550967, -119.811435);
        Marker Sub5 = googleMap.addMarker(new MarkerOptions()
                .position(Stop13)
                .title("The Republic Shuttle Stop 1"));
        LatLng Stop14 = new LatLng(39.550859, -119.811346);
        Marker Sub6 = googleMap.addMarker(new MarkerOptions()
                .position(Stop14)
                .title("The Republic Shuttle Stop 2"));
        //.snippet("Parking Garage Shuttle Stop"));
        LatLng Stop15 = new LatLng(39.546290, -119.813121);
        Marker Sub7 = googleMap.addMarker(new MarkerOptions()
                .position(Stop15)
                .title("Ponderosa Shuttle Stop"));
        //.snippet("Parking Garage Shuttle Stop"));
        LatLng Stop16 = new LatLng(39.542179, -119.813118);
        Marker Sub8 = googleMap.addMarker(new MarkerOptions()
                .position(Stop16)
                .title("IELC Shuttle Stop"));
        //.snippet("Parking Garage Shuttle Stop"));
        LatLng Stop17 = new LatLng(39.547345, -119.813718);
        Marker Sub9 = googleMap.addMarker(new MarkerOptions()
                .position(Stop17)
                .title("Practice Fields Shuttle Stop"));
        //.snippet("Parking Garage Shuttle Stop"));



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