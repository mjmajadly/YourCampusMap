package com.yourcampusmap.themap;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;


public class PlacesToEat extends SherlockFragmentActivity {



    GoogleMap map;
    RadioButton rbDriving;
    RadioButton rbWalking;
    RadioGroup rgModes;
    ArrayList<LatLng> markerPoints;
    int mMode=0;
    final int MODE_DRIVING=0;
    final int MODE_WALKING=1;
    double longitude;
    double latitude;
    LatLng origin;
    LatLng dest;

    //Building Locations for Destinations
    LatLng DCC = new LatLng(39.538783, -119.817901);
    LatLng JJ = new LatLng(39.536250, -119.815438);
    LatLng WD = new LatLng(39.540732, -119.817376);
    LatLng WAL = new LatLng(39.547631, -119.821571);
    LatLng ARCH = new LatLng(39.548872, -119.821717);
    LatLng OFC = new LatLng(39.538609, -119.815875);

    LatLng I = new LatLng(39.550109, -119.816089);
    LatLng II = new LatLng(39.538948, -119.812409);
    LatLng IV = new LatLng(39.539230, -119.815303);
    LatLng V = new LatLng(39.540126, -119.814785);
    LatLng VI = new LatLng(39.538786, -119.817643);
    LatLng VII = new LatLng(39.542275, -119.816103);
    LatLng VIII = new LatLng(39.540281, -119.816402);
    LatLng IX = new LatLng(39.543739, -119.815643);
    LatLng X = new LatLng(39.544724, -119.816060);
    LatLng XI = new LatLng(39.544616, -119.815910);
    LatLng XII = new LatLng(39.544296, -119.816111);
    LatLng XIII = new LatLng(39.544258, -119.816089);
    LatLng XIV = new LatLng(39.544413, -119.815843);
    LatLng XV = new LatLng(39.544393, -119.815800);
    LatLng L = new LatLng(39.544395, -119.815751);
    LatLng U = new LatLng(39.544670, -119.816162);

    LatLng CAP = new LatLng(39.535155, -119.817110);
    LatLng GAI = new LatLng(39.535099, -119.816086);
    LatLng SUB = new LatLng(39.546589, -119.820905);

    //Building strings in the destination dropdown
    String[] palces = new String[] {
            "Archie's Giant Humburgers & Breakfast", //ARCH
            "Bo Dawgs", // (viii)",
            "Bytes", // (ix)",
            "Cantina Del Lobo", // (x)",
            "Capriottis Sandwich Shop", // CAP
            "Dining Conference Center (DCC)",
            "Einstein Brothers Bagels", // (xi)",
            "Elements", // (ii)",
            "Giant Burger", // GAI
            "Great Full Gardens", // (L)"
            "Jimmy Johns", //  (JJ)",
            "Jolt N Java", // (iv)",
            "Keva Juice", // (xii)",
            "Las Trojes Express", // (v)",
            "Little Waldorf Saloon (The Wal)", //  (WAL)",
            "Panda Express", // (xiv)",
            "Pathways Café", // (i)", //
            "Port of Subs", // (xv)",
            "Starbucks", // (xiii)",
            "Subway", // SUB
            "The Downunder Café", // (vi)",
            "The Overlook Food Court", //  (OFC)",
            "The Wolf Den", //  (WD)",
            "The Works", // (vii)",
            "U-Swirl" // (V)",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_to_eat);

        //get gps coordinates using locationmanager
        LocationListener locationListener = new MyLocationListener();
        LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, locationListener);
        //end gps coordinates

        // Getting reference to rb_driving
        rbDriving = (RadioButton) findViewById(R.id.rb_driving);
        // Getting reference to rb_walking
        rbWalking = (RadioButton) findViewById(R.id.rb_walking);
        // Getting Reference to rg_modes
        rgModes = (RadioGroup) findViewById(R.id.rg_modes);

        //Start of the creating of the DropDown Menu
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), R.layout.sherlock_spinner_item, palces);
        getSupportActionBar().setNavigationMode(com.actionbarsherlock.app.ActionBar.NAVIGATION_MODE_LIST);
        ActionBar.OnNavigationListener navigationListener = new ActionBar.OnNavigationListener() {


            @Override
            public boolean onNavigationItemSelected(int itemPosition, long itemId) {
                Toast.makeText(getBaseContext(), "Destination: " + palces[itemPosition], Toast.LENGTH_SHORT).show();



                if (palces[itemPosition] == "Archie's Giant Humburgers & Breakfast") dest = ARCH;
                if (palces[itemPosition] == "Dining Conference Center (DCC)") dest = DCC;
                if (palces[itemPosition] == "Jimmy Johns") dest = JJ;
                if (palces[itemPosition] == "The Overlook Food Court") dest = OFC;
                if (palces[itemPosition] == "Little Waldorf Saloon (The Wal)") dest = WAL;
                if (palces[itemPosition] == "The Wolf Den") dest = WD;
                if (palces[itemPosition] == "Bo Dawgs") dest = VIII;
                if (palces[itemPosition] == "Bytes") dest = IX;
                if (palces[itemPosition] == "Cantina Del Lobo") dest = X;
                if (palces[itemPosition] == "Einstein Brothers Bagels") dest = XI;
                if (palces[itemPosition] == "Elements") dest = II;
                if (palces[itemPosition] == "Great Full Gardens") dest = L;
                if (palces[itemPosition] == "Jolt N Java") dest = IV;
                if (palces[itemPosition] == "Keva Juice") dest = XII;
                if (palces[itemPosition] == "Las Trojes Express") dest = V;
                if (palces[itemPosition] == "Panda Express") dest = XIV;
                if (palces[itemPosition] == "Pathways Café") dest = I;
                if (palces[itemPosition] == "Port of Subs") dest = XV;
                if (palces[itemPosition] == "Starbucks") dest = XIII;
                if (palces[itemPosition] == "The Downunder Café") dest = VI;
                if (palces[itemPosition] == "The Works") dest = VII;
                if (palces[itemPosition] == "U-Swirl") dest = U;

                if (palces[itemPosition] == "Capriottis Sandwich Shop") dest = CAP;
                if (palces[itemPosition] == "Giant Burger") dest = GAI;
                if (palces[itemPosition] == "Subway") dest = SUB;

                return false;
            }
        };
        getSupportActionBar().setListNavigationCallbacks(adapter, navigationListener);
        adapter.setDropDownViewResource(R.layout.sherlock_spinner_dropdown_item);
        //Finish Drop Down Menu

        rgModes.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // Checks whether start and end locations are captured
                if(markerPoints.size() >= 0){ //size is 1
                    //LatLng origin = markerPoints.get(0);
                    origin = new LatLng(latitude,longitude);

                    // Getting URL to the Google Directions API
                    String url = getDirectionsUrl(origin, dest);

                    DownloadTask downloadTask = new DownloadTask();

                    // Start downloading json data from Google Directions API
                    downloadTask.execute(url);
                }
            }
        });

        // Initializing
        markerPoints = new ArrayList<LatLng>();

        // Getting reference to SupportMapFragment of the activity_main
        SupportMapFragment fm = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);

        // Getting Map for the SupportMapFragment
        map = fm.getMap();

        // Enable MyLocation Button in the Map
        map.setMyLocationEnabled(true);

        //Set up Map Type
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        // googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);
        // googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        // googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        //googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // Setting onclick event listener for the map
        map.setOnMapClickListener(new OnMapClickListener() {

            @Override
            public void onMapClick(LatLng point) {

                // Already two locations
                if(markerPoints.size()>=0){ //1
                    markerPoints.clear();
                    map.clear();
                }

                // Adding new item to the ArrayList
                markerPoints.add(point);

                // Draws Start and Stop markers on the Google Map
                drawStartStopMarkers();

                // Checks, whether start and end locations are captured
                if(markerPoints.size() >= 1){
                    // LatLng origin = markerPoints.get(0);
                    origin = new LatLng(latitude,longitude);
                    //dest = markerPoints.get(0);

                    // Getting URL to the Google Directions API
                    String url = getDirectionsUrl(origin, dest);

                    DownloadTask downloadTask = new DownloadTask();

                    // Start downloading json data from Google Directions API
                    downloadTask.execute(url);
                }

            }
        });
    }

    // Drawing Start and Stop locations
    private void drawStartStopMarkers(){

        //for(int i=0;i<=markerPoints.size();i++){ //<
        // int i = 0;
        // Creating MarkerOptions
        // MarkerOptions options = new MarkerOptions();


        // Setting the position of the marker
        // options.position(markerPoints.get(i) );

        /**
         * For the start location, the color of marker is GREEN and
         * for the end location, the color of marker is RED.
         */
        // if(i==0){
        // options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        // }
        //else if(i==1){
        //options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        // }

        // Add new marker to the Google Map Android API V2
        ///map.addMarker(options);
        map.addMarker(new MarkerOptions().position(dest));
        //}
    }


    private String getDirectionsUrl(LatLng origin,LatLng dest){

        // Origin of route
        String str_origin = "origin="+origin.latitude+","+origin.longitude;

        // Destination of route
        String str_dest = "destination="+dest.latitude+","+dest.longitude;

        // Sensor enabled
        String sensor = "sensor=false";

        // Travelling Mode
        String mode = "mode=driving";

        if(rbDriving.isChecked()){
            mode = "mode=driving";
            mMode = 0 ;
        }else if(rbWalking.isChecked()){
            mode = "mode=walking";
            mMode = 1;
        }


        // Building the parameters to the web service
        String parameters = str_origin+"&"+str_dest+"&"+sensor+"&"+mode;

        // Output format
        String output = "json";

        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/"+output+"?"+parameters;


        return url;
    }

    /** A method to download json data from url */
    private String downloadUrl(String strUrl) throws IOException{
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try{
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb  = new StringBuffer();

            String line = "";
            while( ( line = br.readLine())  != null){
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        }catch(Exception e){
            Log.d("Exception while downloading url", e.toString());
        }finally{
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }



    // Fetches data from url passed
    private class DownloadTask extends AsyncTask<String, Void, String>{

        // Downloading data in non-ui thread
        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try{
                // Fetching the data from web service
                data = downloadUrl(url[0]);
            }catch(Exception e){
                Log.d("Background Task",e.toString());
            }
            return data;
        }

        // Executes in UI thread, after the execution of
        // doInBackground()
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask();

            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);

        }
    }

    /** A class to parse the Google Places in JSON format */
    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String,String>>> >{

        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try{
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();

                // Starts parsing data
                routes = parser.parse(jObject);
            }catch(Exception e){
                e.printStackTrace();
            }
            return routes;
        }


        // Executes in UI thread, after the parsing process
        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;
            MarkerOptions markerOptions = new MarkerOptions();

           // float c = result.size();
          //  Toast.makeText(getBaseContext(), "The value of result.size1 is: " + c, Toast.LENGTH_SHORT).show();

            // Traversing through all the routes
            for(int i=0;i< result.size() ;i++){
                points = new ArrayList<LatLng>();
                lineOptions = new PolylineOptions();

                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);

                // Fetching all the points in i-th route
                for(int j=0;j<path.size();j++){
                    HashMap<String,String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(7);

                // Changing the color polyline according to the mode
                if(mMode==MODE_DRIVING)
                    lineOptions.color(Color.YELLOW);
                else if(mMode==MODE_WALKING)
                    lineOptions.color(Color.RED);
            }

            if (result.size()<1){
            //    Toast.makeText(getBaseContext(), "The value of result.size2 is: " + c, Toast.LENGTH_SHORT).show();
                return;
            }

            // Drawing polyline in the Google Map for the i-th route
            map.addPolyline(lineOptions);

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

    private final class MyLocationListener implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            longitude = location.getLongitude();
            latitude = location.getLatitude();
        }

        @Override
        public void onProviderDisabled(String provider) {
            // called when the GPS provider is turned off (user turning off the GPS on the phone)
        }

        @Override
        public void onProviderEnabled(String provider) {
            // called when the GPS provider is turned on (user turning on the GPS on the phone)
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            // called when the status of the GPS provider changes
        }
    }

}
