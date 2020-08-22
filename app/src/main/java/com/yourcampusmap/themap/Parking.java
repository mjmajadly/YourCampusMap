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
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;


public class Parking extends SherlockFragmentActivity {

    private SupportMapFragment mapFragment;
    private GoogleMap googleMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //View Google Maps
        setContentView(R.layout.activity_parking);

        //GPS Location Devices
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        googleMap = mapFragment.getMap();
        googleMap.setMyLocationEnabled(true);

        //Set up Parking Locations

        //Green 1
        Polygon polygon = googleMap.addPolygon(new PolygonOptions()
                .add(new LatLng(39.548405, -119.819069),
                     new LatLng(39.547767, -119.818921),
                     new LatLng(39.547747, -119.819286),
                     new LatLng(39.547975, -119.819290),
                     new LatLng(39.547963, -119.819623),
                     new LatLng(39.547888, -119.819736),
                     new LatLng(39.547787, -119.820192),
                     new LatLng(39.547942, -119.820254),
                     new LatLng(39.548070, -119.819701),
                     new LatLng(39.548391, -119.819775))
                .strokeColor(Color.GREEN)
               // .fillColor(Color.GREEN)
        );
        LatLng Green1 = new LatLng(39.548148, -119.819283);
        Marker green1 = googleMap.addMarker(new MarkerOptions()
                .position(Green1)
                .title("Green Parking (With Carpool)"));

        //Green2
        Polygon polygon2 = googleMap.addPolygon(new PolygonOptions()
                        .add(new LatLng(39.547657, -119.820013),
                                new LatLng(39.547171, -119.820084),
                                new LatLng(39.547147, -119.819684),
                                new LatLng(39.547594, -119.819521))
                        .strokeColor(Color.GREEN));
        LatLng Green2 = new LatLng(39.547397, -119.819811);
        Marker green2 = googleMap.addMarker(new MarkerOptions()
                .position(Green2)
                .title("Green Parking"));

        //Green3
        Polygon polygon3 = googleMap.addPolygon(new PolygonOptions()
                        .add(new LatLng(39.548536, -119.819716),
                                new LatLng(39.548533, -119.820080),
                                new LatLng(39.548808, -119.820611),
                                new LatLng(39.549066, -119.820630),
                                new LatLng(39.549088, -119.821018),
                                new LatLng(39.550068, -119.821428),
                                new LatLng(39.550132, -119.819161),
                                new LatLng(39.549157, -119.819143),
                                new LatLng(39.549136, -119.819838))
                        .strokeColor(Color.GREEN));
        LatLng Green3 = new LatLng(39.549386, -119.820073);
        Marker green3 = googleMap.addMarker(new MarkerOptions()
                .position(Green3)
                .title("Green Parking"));

        //Green4
        Polygon polygon4 = googleMap.addPolygon(new PolygonOptions()
                        .add(new LatLng(39.549406, -119.819031),
                                new LatLng(39.549399, -119.818804),
                                new LatLng(39.549111, -119.818793),
                                new LatLng(39.549103, -119.818482),
                                new LatLng(39.548931, -119.818492),
                                new LatLng(39.548924, -119.818987))
                        .strokeColor(Color.GREEN) );
        LatLng Green4 = new LatLng(39.549158, -119.8188793);
        Marker green4 = googleMap.addMarker(new MarkerOptions()
                .position(Green4)
                .title("Green Parking"));


        //Blue1
        Polygon polygon5 = googleMap.addPolygon(new PolygonOptions()
                        .add(new LatLng(39.550203, -119.821372),
                                new LatLng(39.550706, -119.821273),
                                new LatLng(39.551090, -119.818278),
                                new LatLng(39.550360, -119.818246),
                                new LatLng(39.550220, -119.819087))
                        .strokeColor(Color.BLUE) );
        LatLng Blue1 = new LatLng(39.550513, -119.820186);
        Marker blue1 = googleMap.addMarker(new MarkerOptions()
                .position(Blue1)
                .title("Blue Parking"));

        //Blue2
        Polygon polygon6 = googleMap.addPolygon(new PolygonOptions()
                .add(new LatLng(39.548508, -119.814267),
                        new LatLng(39.548637, -119.813928),
                        new LatLng(39.548758, -119.813589),
                        new LatLng(39.548724, -119.813555),
                        new LatLng(39.548210, -119.813736),
                        new LatLng(39.548060, -119.813673),
                        new LatLng(39.548038, -119.813704))
                .strokeColor(Color.BLUE));
        LatLng Blue2 = new LatLng(39.548432, -119.813776);
        Marker blue2 = googleMap.addMarker(new MarkerOptions()
                .position(Blue2)
                .title("Blue Parking"));

        //Blue3
        Polygon polygon7 = googleMap.addPolygon(new PolygonOptions()
                        .add(new LatLng(39.549098, -119.812793),
                                new LatLng(39.549425, -119.812601),
                                new LatLng(39.549275, -119.812178),
                                new LatLng(39.549118, -119.812120),
                                new LatLng(39.548892, -119.811867),
                                new LatLng(39.549118, -119.812120),
                                new LatLng(39.548871, -119.811843),
                                new LatLng(39.548861, -119.811731),
                                new LatLng(39.548896, -119.811570),
                                new LatLng(39.548320, -119.811684),
                                new LatLng(39.547735, -119.812006),
                                new LatLng(39.547811, -119.812226),
                                new LatLng(39.547958, -119.812074),
                                new LatLng(39.548401, -119.811863),
                                new LatLng(39.548520, -119.812082),
                                new LatLng(39.548608, -119.812038),
                                new LatLng(39.548864, -119.812424),
                                new LatLng(39.549053, -119.812513))
                        .strokeColor(Color.BLUE) );
        LatLng Blue3 = new LatLng(39.548973, -119.812291);
        Marker blue3 = googleMap.addMarker(new MarkerOptions()
                .position(Blue3)
                .title("Blue Parking"));

        //Blue4
        Polygon polygon8 = googleMap.addPolygon(new PolygonOptions()
                        .add(new LatLng(39.540806, -119.807789),
                                new LatLng(39.540808, -119.807437),
                                new LatLng(39.540294, -119.807449),
                                new LatLng(39.540311, -119.807740))
                        .strokeColor(Color.BLUE));
        LatLng Blue4 = new LatLng(39.540489, -119.807556);
        Marker blue4 = googleMap.addMarker(new MarkerOptions()
                .position(Blue4)
                .title("Blue Parking"));

        //Blue5
        Polygon polygon9 = googleMap.addPolygon(new PolygonOptions()
                .add(new LatLng(39.538885, -119.807688),
                        new LatLng(39.538890, -119.806641),
                        new LatLng(39.538141, -119.806610),
                        new LatLng(39.538123, -119.806531),
                        new LatLng(39.537531, -119.806525),
                        new LatLng(39.537524, -119.806845),
                        new LatLng(39.537446, -119.806849),
                        new LatLng(39.537473, -119.807606),
                        new LatLng(39.538816, -119.807680),
                        new LatLng(39.538823, -119.807525),
                        new LatLng(39.537807, -119.807468),
                        new LatLng(39.537798, -119.807413),
                        new LatLng(39.537637, -119.807404),
                        new LatLng(39.537661, -119.806656),
                        new LatLng(39.538030, -119.806639),
                        new LatLng(39.538019, -119.806781),
                        new LatLng(39.538085, -119.806788),
                        new LatLng(39.538080, -119.807260),
                        new LatLng(39.538313, -119.807256),
                        new LatLng(39.538332, -119.806747),
                        new LatLng(39.538823, -119.806750),
                        new LatLng(39.538823, -119.807525),
                        new LatLng(39.538816, -119.807680))
                .strokeColor(Color.BLUE));
        LatLng Blue5 = new LatLng(39.538231, -119.806926);
        Marker blue5 = googleMap.addMarker(new MarkerOptions()
                .position(Blue5)
                .title("Blue Parking"));

        //Orange1
        Polygon polygon10 = googleMap.addPolygon(new PolygonOptions()
                .add(new LatLng(39.547093, -119.813975),
                        new LatLng(39.547412, -119.813398),
                        new LatLng(39.547498, -119.812757),
                        new LatLng(39.547331, -119.812499),
                        new LatLng(39.546533, -119.813077))
                .strokeColor(Color.RED));
        LatLng Orange1 = new LatLng(39.547058, -119.813160);
        Marker orange1 = googleMap.addMarker(new MarkerOptions()
                .position(Orange1)
                .title("Orange Parking"));

        //Yellow1
        Polygon polygon11 = googleMap.addPolygon(new PolygonOptions()
                .add(new LatLng(39.540414, -119.818862),
                        new LatLng(39.540401, -119.818436),
                        new LatLng(39.539485, -119.818426),
                        new LatLng(39.539490, -119.818825))
                .strokeColor(Color.YELLOW));
        LatLng Yellow1 = new LatLng(39.539901, -119.818662);
        Marker yellow1 = googleMap.addMarker(new MarkerOptions()
                .position(Yellow1)
                .title("Yellow (1) Parking"));

        //Yellow2
        Polygon polygon12 = googleMap.addPolygon(new PolygonOptions()
                .add(new LatLng(39.537492, -119.817268),
                        new LatLng(39.537412, -119.817245),
                        new LatLng(39.537294, -119.817836),
                        new LatLng(39.537142, -119.817773),
                        new LatLng(39.537233, -119.817193),
                        new LatLng(39.537170, -119.817173),
                        new LatLng(39.537036, -119.817842),
                        new LatLng(39.537083, -119.817859),
                        new LatLng(39.537072, -119.817933),
                        new LatLng(39.537352, -119.818029))
                .strokeColor(Color.YELLOW));
        LatLng Yellow2 = new LatLng(39.537109, -119.817857);
        Marker yellow2 = googleMap.addMarker(new MarkerOptions()
                .position(Yellow2)
                .title("Yellow (2) Parking"));

        //Yellow3
        Polygon polygon13 = googleMap.addPolygon(new PolygonOptions()
                .add(new LatLng(39.546807, -119.814413),
                        new LatLng(39.546930, -119.814223),
                        new LatLng(39.546358, -119.813511),
                        new LatLng(39.546200, -119.813574))
                .strokeColor(Color.YELLOW));
        LatLng Yellow3 = new LatLng(39.546559, -119.813926);
        Marker yellow3 = googleMap.addMarker(new MarkerOptions()
                .position(Yellow3)
                .title("Yellow (3) Parking"));

        //Purple 1
        Polygon polygon14 = googleMap.addPolygon(new PolygonOptions()
                        .add(new LatLng(39.549849, -119.814536),
                                new LatLng(39.549850, -119.814477),
                                new LatLng(39.549900, -119.814467),
                                new LatLng(39.549909, -119.814001),
                                new LatLng(39.549864, -119.814001),
                                new LatLng(39.549855, -119.813940),
                                new LatLng(39.549735, -119.813936),
                                new LatLng(39.549740, -119.814536))
                        .strokeColor(Color.WHITE));
        LatLng Purple1 = new LatLng(39.549813, -119.814216);
        Marker purple1 = googleMap.addMarker(new MarkerOptions()
                .position(Purple1)
                .title("Purple Parking"));

        //Purple2
        Polygon polygon15 = googleMap.addPolygon(new PolygonOptions()
                .add(new LatLng(39.548410, -119.818892),
                        new LatLng(39.548414, -119.817631),
                        new LatLng(39.548133, -119.817609),
                        new LatLng(39.548086, -119.818612),
                        new LatLng(39.547930, -119.818585),
                        new LatLng(39.547763, -119.818823))
                .strokeColor(Color.WHITE));
        LatLng Purple2 = new LatLng(39.548147, -119.818700);
        Marker purple2 = googleMap.addMarker(new MarkerOptions()
                .position(Purple2)
                .title("Purple Parking"));

        //Purple3
        Polygon polygon16 = googleMap.addPolygon(new PolygonOptions()
                .add(new LatLng(39.548722, -119.818066),
                        new LatLng(39.548726, -119.817574),
                        new LatLng(39.548583, -119.817572),
                        new LatLng(39.548574, -119.818046))
                .strokeColor(Color.WHITE));
        LatLng Purple3 = new LatLng(39.548623, -119.817843);
        Marker purple3 = googleMap.addMarker(new MarkerOptions()
                .position(Purple3)
                .title("Purple Parking"));

        //Purple4
        Polygon polygon17 = googleMap.addPolygon(new PolygonOptions()
                .add(new LatLng(39.548909, -119.818986),
                        new LatLng(39.548912, -119.818154),
                        new LatLng(39.548569, -119.818123),
                        new LatLng(39.548561, -119.818963))
                .strokeColor(Color.WHITE));
        LatLng Purple4 = new LatLng(39.548763, -119.818603);
        Marker purple4 = googleMap.addMarker(new MarkerOptions()
                .position(Purple4)
                .title("Purple Parking"));

        //Pink1
        Polygon polygon18 = googleMap.addPolygon(new PolygonOptions()
                .add(new LatLng(39.549252, -119.817150),
                        new LatLng(39.549256, -119.817098),
                        new LatLng(39.549137, -119.817097),
                        new LatLng(39.549139, -119.817152))
                .strokeColor(Color.MAGENTA));
        LatLng Pink1 = new LatLng(39.549199, -119.817118);
        Marker pink1 = googleMap.addMarker(new MarkerOptions()
                .position(Pink1)
                .title("Pink Parking"));

        //Pink2
        Polygon polygon19 = googleMap.addPolygon(new PolygonOptions()
                .add(new LatLng(39.546577, -119.815664),
                        new LatLng(39.546621, -119.815606),
                        new LatLng(39.546327, -119.815269),
                        new LatLng(39.546295, -119.815307))
                .strokeColor(Color.MAGENTA));
        LatLng Pink2 = new LatLng(39.546458, -119.815449);
        Marker pink2 = googleMap.addMarker(new MarkerOptions()
                .position(Pink2)
                .title("Pink Parking"));

        //Pink3
        Polygon polygon20 = googleMap.addPolygon(new PolygonOptions()
                .add(new LatLng(39.546204, -119.815216),
                        new LatLng(39.546226, -119.815165),
                        new LatLng(39.545962, -119.814889),
                        new LatLng(39.545648, -119.814349),
                        new LatLng(39.545610, -119.814388),
                        new LatLng(39.545934, -119.814939))
                .strokeColor(Color.MAGENTA));
        LatLng Pink3 = new LatLng(39.545921, -119.814864);
        Marker pink3 = googleMap.addMarker(new MarkerOptions()
                .position(Pink3)
                .title("Pink Parking"));

        //Pink4
        Polygon polygon21 = googleMap.addPolygon(new PolygonOptions()
                .add(new LatLng(39.546097, -119.815319),
                        new LatLng(39.546125, -119.815279),
                        new LatLng(39.545887, -119.815026),
                        new LatLng(39.545646, -119.814638),
                        new LatLng(39.545610, -119.814677),
                        new LatLng(39.545851, -119.815067))
                .strokeColor(Color.MAGENTA));
        LatLng Pink4 = new LatLng(39.545869, -119.815033);
        Marker pink4 = googleMap.addMarker(new MarkerOptions()
                .position(Pink4)
                .title("Pink Parking"));

        //Pink5
        Polygon polygon22 = googleMap.addPolygon(new PolygonOptions()
                .add(new LatLng(39.544332, -119.817177),
                        new LatLng(39.544356, -119.817184),
                        new LatLng(39.544142, -119.818163),
                        new LatLng(39.544124, -119.818160))
                .strokeColor(Color.MAGENTA));
        LatLng Pink5 = new LatLng(39.544251, -119.817597);
        Marker pink5 = googleMap.addMarker(new MarkerOptions()
                .position(Pink5)
                .title("Pink Parking"));

        //Pink6
        Polygon polygon23 = googleMap.addPolygon(new PolygonOptions()
                .add(new LatLng(39.543101, -119.817197),
                        new LatLng(39.543244, -119.816858),
                        new LatLng(39.543344, -119.816833),
                        new LatLng(39.543449, -119.816840),
                        new LatLng(39.543481, -119.816772),
                        new LatLng(39.543642, -119.816844),
                        new LatLng(39.543747, -119.816951),
                        new LatLng(39.543938, -119.816950),
                        new LatLng(39.544148, -119.817048),
                        new LatLng(39.543935, -119.818016),
                        new LatLng(39.543920, -119.818045),
                        new LatLng(39.543860, -119.818072),
                        new LatLng(39.543818, -119.818057),
                        new LatLng(39.543160, -119.817296))
                .strokeColor(Color.MAGENTA));
        LatLng Pink6 = new LatLng(39.546458, -119.815449);
        Marker pink6 = googleMap.addMarker(new MarkerOptions()
                .position(Pink6)
                .title("Pink Parking"));

        //Pink7
        Polygon polygon24 = googleMap.addPolygon(new PolygonOptions()
                .add(new LatLng(39.541898, -119.816957),
                        new LatLng(39.541823, -119.816959),
                        new LatLng(39.541818, -119.816711),
                        new LatLng(39.541900, -119.816714))
                .strokeColor(Color.MAGENTA));
        LatLng Pink7 = new LatLng(39.541861, -119.816824);
        Marker pink7 = googleMap.addMarker(new MarkerOptions()
                .position(Pink7)
                .title("Pink Parking"));

        //Pink8
        Polygon polygon25 = googleMap.addPolygon(new PolygonOptions()
                .add(new LatLng(39.543824, -119.814501),
                        new LatLng(39.543830, -119.813865),
                        new LatLng(39.543584, -119.813841),
                        new LatLng(39.543490, -119.814326))
                .strokeColor(Color.MAGENTA));
        LatLng Pink8 = new LatLng(39.543669, -119.814154);
        Marker pink8 = googleMap.addMarker(new MarkerOptions()
                .position(Pink8)
                .title("Pink Parking"));

        //Pink9
        Polygon polygon26 = googleMap.addPolygon(new PolygonOptions()
                .add(new LatLng(39.541388, -119.812863),
                        new LatLng(39.541394, -119.812823),
                        new LatLng(39.541168, -119.812789),
                        new LatLng(39.541155, -119.812844))
                .strokeColor(Color.MAGENTA));
        LatLng Pink9 = new LatLng(39.541326, -119.812837);
        Marker pink9 = googleMap.addMarker(new MarkerOptions()
                .position(Pink9)
                .title("Pink Parking"));

        //Pink10
        Polygon polygon27 = googleMap.addPolygon(new PolygonOptions()
                .add(new LatLng(39.537947, -119.811387),
                        new LatLng(39.538436, -119.811746),
                        new LatLng(39.538474, -119.811655),
                        new LatLng(39.538221, -119.811464),
                        new LatLng(39.538194, -119.811485),
                        new LatLng(39.537974, -119.811314))
                .strokeColor(Color.MAGENTA));
        LatLng Pink10 = new LatLng(39.538260, -119.811557);
        Marker pink10 = googleMap.addMarker(new MarkerOptions()
                .position(Pink10)
                .title("Pink Parking"));

        //Pink11
        Polygon polygon28 = googleMap.addPolygon(new PolygonOptions()
                .add(new LatLng(39.538138, -119.817009),
                        new LatLng(39.537988, -119.816966),
                        new LatLng(39.537929, -119.817414),
                        new LatLng(39.538138, -119.817484))
                .strokeColor(Color.MAGENTA));
        LatLng Pink11 = new LatLng(39.538039, -119.817256);
        Marker pink11 = googleMap.addMarker(new MarkerOptions()
                .position(Pink11)
                .title("Pink Parking"));

        //Pink12
        Polygon polygon29 = googleMap.addPolygon(new PolygonOptions()
                .add(new LatLng(39.537299, -119.816444),
                        new LatLng(39.537245, -119.816301),
                        new LatLng(39.536895, -119.816199),
                        new LatLng(39.536839, -119.816292))
                .strokeColor(Color.MAGENTA));
        LatLng Pink12 = new LatLng(39.537090, -119.816329);
        Marker pink12 = googleMap.addMarker(new MarkerOptions()
                .position(Pink12)
                .title("Pink Parking"));

        //Pink13
        Polygon polygon30 = googleMap.addPolygon(new PolygonOptions()
                .add(new LatLng(39.537425, -119.814137),
                        new LatLng(39.537454, -119.813671),
                        new LatLng(39.537810, -119.813614),
                        new LatLng(39.537779, -119.813512),
                        new LatLng(39.537350, -119.813493),
                        new LatLng(39.537304, -119.813744),
                        new LatLng(39.537363, -119.813780),
                        new LatLng(39.537338, -119.813883),
                        new LatLng(39.537271, -119.813869),
                        new LatLng(39.537134, -119.814253),
                        new LatLng(39.537279, -119.814542),
                        new LatLng(39.537396, -119.814567),
                        new LatLng(39.537458, -119.814197))
                .strokeColor(Color.MAGENTA));
        LatLng Pink13 = new LatLng(39.537393, -119.813839);
        Marker pink13 = googleMap.addMarker(new MarkerOptions()
                .position(Pink13)
                .title("Pink Parking"));

        //Silver







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