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

public class LocationActivity2 extends SherlockFragmentActivity {



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
    LatLng AHS = new LatLng(39.549228, -119.816929);
    LatLng AB = new LatLng(39.540037, -119.814669);
    LatLng ARF = new LatLng(39.544343, -119.814726);
    LatLng AH = new LatLng(39.538832, -119.817893);
    LatLng ARTM = new LatLng(39.538540, -119.818087);
    LatLng CH = new LatLng(39.539721, -119.817706);
    LatLng CMM = new LatLng(39.550104, -119.816696);
    LatLng CHP = new LatLng(39.540220, -119.814045);
    LatLng CS = new LatLng(39.548993, -119.819467);
    LatLng CB = new LatLng(39.540666, -119.814476);
    LatLng CCF = new LatLng(39.550520, -119.821520);
    LatLng CFA = new LatLng(39.541307, -119.816527);
    LatLng CA = new LatLng(39.537849, -119.815006);
    LatLng CC = new LatLng(39.547431, -119.819260);
    LatLng CE = new LatLng(39.537778, -119.817127);
    LatLng DMSC = new LatLng(39.538959, -119.812863);
    LatLng DCC = new LatLng(39.538783, -119.817901);
    LatLng EJCH = new LatLng(39.542221, -119.813902);
    LatLng ERF = new LatLng(39.547837, -119.819516);
    LatLng EL = new LatLng(39.540519, -119.812558);
    LatLng FMC = new LatLng(39.548302, -119.816884);
    LatLng FS = new LatLng(39.539736, -119.814489);
    LatLng FSSB = new LatLng(39.542322, -119.816104);
    LatLng FA = new LatLng(39.537681, -119.812091);
    LatLng FP = new LatLng(39.545864, -119.819356);
    LatLng FH = new LatLng(39.538344, -119.815331);
    LatLng HREL = new LatLng(39.540536, -119.813220);
    LatLng HMS = new LatLng(39.548959, -119.815685);
    LatLng JCSU = new LatLng(39.544509, -119.816007);
    LatLng JC = new LatLng(39.538309, -119.814746);
    LatLng JT = new LatLng(39.538580, -119.816372);
    LatLng JH = new LatLng(39.538005, -119.816532);
    LatLng LEC = new LatLng(39.544584, -119.818318);
    LatLng LEGH = new LatLng(39.545263, -119.817352);
    LatLng LP = new LatLng(39.541259, -119.814111);
    LatLng LS = new LatLng(39.538290, -119.812460);
    LatLng LHD = new LatLng(39.539470, -119.816321);
    LatLng LR = new LatLng(39.545461, -119.815675);
    LatLng LME = new LatLng(39.539048, -119.813788);
    LatLng LMR = new LatLng(39.538732, -119.813277);
    LatLng MIKC = new LatLng(39.543517, -119.815631);
    LatLng MSS = new LatLng(39.540799, -119.815255);
    LatLng MM = new LatLng(39.539342, -119.814465);
    LatLng MS = new LatLng(39.538227, -119.813596);
    LatLng MHS = new LatLng(39.549129, -119.816230);
    LatLng MAH = new LatLng(39.537552, -119.816299);
    LatLng MWPB = new LatLng(39.545587, -119.816838);
    LatLng MH = new LatLng(39.537719, -119.813948);
    LatLng MP = new LatLng(39.549819, -119.818158);
    LatLng NJC = new LatLng(39.543068, -119.814284);
    LatLng NJR = new LatLng(39.548233, -119.816110);
    LatLng NBS = new LatLng(39.549665, -119.816610);
    LatLng NLLC = new LatLng(39.540312, -119.817477);
    LatLng NSHL = new LatLng(39.548801, -119.817777);
    LatLng NH = new LatLng(39.539203, -119.817871);
    LatLng OB = new LatLng(39.538147, -119.812873);
    LatLng PE = new LatLng(39.539480, -119.812908);
    LatLng PHS = new LatLng(39.549020, -119.814489);
    LatLng PMB = new LatLng(39.548708, -119.815950);
    LatLng RRC = new LatLng(39.538714, -119.813326);
    LatLng RSJ = new LatLng(39.541411, -119.815266);
    LatLng RH = new LatLng(39.538947, -119.814929);
    LatLng SFB = new LatLng(39.537404, -119.813299);
    LatLng SMS = new LatLng(39.548913, -119.816562);
    LatLng S = new LatLng(39.546929, -119.817559);
    LatLng SLH = new LatLng(39.541028, -119.814612);
    LatLng SEM = new LatLng(39.539856, -119.813592);
    LatLng SH = new LatLng(39.537340, -119.817100);
    LatLng SMC = new LatLng(39.545731, -119.816509);
    LatLng TB = new LatLng(39.539017, -119.815408);
    LatLng VSG = new LatLng(39.540461, -119.816679);
    LatLng WSPC = new LatLng(39.545986, -119.818080);
    LatLng WPH = new LatLng(39.539387, -119.816783);
    LatLng WRB = new LatLng(39.542088, -119.814928);
    LatLng WPI = new LatLng(39.549984, -119.815019);


    LatLng IC = new LatLng(39.536054, -119.815151);
    LatLng REO = new LatLng(39.536054, -119.815151);
    LatLng SML = new LatLng(39.548643, -119.815912);
    LatLng DLM = new LatLng(39.539318, -119.814438);
    LatLng TLT = new LatLng(39.542048, -119.813378);
    LatLng IELC = new LatLng(39.542377, -119.813772);
    LatLng OISS = new LatLng(39.542322, -119.816104);
    LatLng AR = new LatLng(39.542322, -119.816104);
    LatLng CO = new LatLng(39.542322, -119.816104);
    LatLng GH = new LatLng(39.545881, -119.813705);
    LatLng RLHFS = new LatLng(39.538236, -119.816519);
    LatLng QUAD = new LatLng(39.538530, -119.814219);
    LatLng HP = new LatLng(39.540683, -119.814870);
    LatLng ML = new LatLng(39.537480, -119.815573);
    LatLng MB = new LatLng(39.536723, -119.815586);
    LatLng DRC = new LatLng(39.539017, -119.815324);
    LatLng HR = new LatLng(39.538536, -119.817905);
    LatLng OFC = new LatLng(39.538609, -119.815875);
    LatLng PS = new LatLng(39.546627, -119.819997);
    LatLng PO = new LatLng(39.548537, -119.820638);
    LatLng KNPB = new LatLng(39.548090, -119.820532);
    LatLng CCC = new LatLng(39.538055, -119.817743);
    LatLng NHS = new LatLng(39.547204, -119.820384);
    LatLng PD = new LatLng(39.549022, -119.818410);
    LatLng HC = new LatLng(39.548389, -119.816498);
    LatLng CBCC = new LatLng(39.551278, -119.814958);
    LatLng TC = new LatLng(39.547231, -119.815733);
    LatLng JSIPF = new LatLng(39.547815, -119.814294);
    LatLng WPP = new LatLng(39.548080, -119.812617);
    LatLng SSPC = new LatLng(39.539526, -119.818514);
    LatLng USAC = new LatLng(39.540510, -119.816454);

    //Building strings in the destination dropdown
    String[] actions = new String[] {
            "Admissions and Records (AR)",
            "Anderson Health Science (AHS)",
            "Ansari Business Building (AB)",
            "Applied Research Facility (ARF)",
            "Argenta Hall (AH)",
            "Artemesia Building (ARTM)",
            "Athletic Academic Center (MWPB)",
            "Canada Hall (CH)",
            "Cashiers Office (CO)",
            "Center for Molecular Medicine (CMM)",
            "Central Heat Plant (CHP)",
            "Central Services (CS)",
            "Chemistry Building (CB)",
            "Child Care Center (CCC)",
            "Child Care Facility (CCF)",
            "Childrens Behavioral Center Complex (CBCC)",
            "Church Fine Arts (CFA)",
            "Clark Administration (CA)",
            "Computing Center (CC)",
            "Continuing Education (CE)",
            "Davidson Academy (JT)",
            "Davidson Mathematics and Science Center (DMSC)",
            "DeLaMare Library (DLM)",
            "Dining Conference Center (DCC)",
            "Disability Resource Center (DRC)",
            "Edmund J. Cain Hall (EJCH)",
            "Environmental Research Facility (ERF)",
            "Earthquake Laboratory (EL)",
            "Family Medicine Center (FMC)",
            "Facilities Services (FS)",
            "Fitzgerald Student Services Building (FSSB)",
            "Fleischmann Agriculture (FA)",
            "Fleischmann Panetarium (FP)",
            "Frandsen Humanities (FH)",
            "Graduate Housing (GH)",
            "Harry Reid Engineering Laboratory (HREL)",
            "Health Center (HC)",
            "Hillard Plaza (HP)",
            "Howard Medical Sciences (HMS)",
            "Human Resources (HR)",
            "Intensive English Language Center (IELC)",
            "International Center (IC)",
            "Joe Crowley Student Union (JCSU)",
            "John Sala Intramural Practice Field (JSIPF)",
            "Jones Center (JC)",
            "Jot Travis Building (JT)",
            "Juniper Hall (JH)",
            "Knowledge Center (MIKC)",
            "Lawlor Events Center (LEC)",
            "Legacy Hall (LEGH)",
            "Leifson Physics (LP)",
            "Life Science (LS)",
            "Lincoln Hall (LHD)",
            "Lombardi Recreation Center (LR)",
            "Mack Social Science (MSS)",
            "Mackey Mines (MM)",
            "Mackey Science (MS)",
            "Mackey Stadium (S)",
            "Manville Health Science (MHS)",
            "Manzanita Bowl(MB)",
            "Manzanita Hall (MAH)",
            "Manzanita Lake(ML)",
            "Marquerite W. Peterson Building (MWPB)",
            "Mathewson - IGT Knowledge Center (MIKC)",
            "Morrill Hall (MH)",
            "Motor Pool (MP)",
            "National Judicial College (NJC)",
            "Nell J. Redfield Building (NJR)",
            "Nellor Biomedical Sciences (NBS)",
            "Nevada Historical Society (NHS)",
            "Nevada Living Learning Community (NLLC)",
            "Nevada State Health Laboratory (NSHL)",
            "Nye Hall (NH)",
            "Office of International Students and Scholars (OISS)",
            "Orvis Building (OB)",
            "Palmer Engineering (PE)",
            "Parking Services (PS)",
            "Paul Laxalt Mineral Engineering (LME)",
            "Paul Laxalt Mineral Research (LMR)",
            "Pennington Health Sciences Building (PHS)",
            "Pennington Medical Education Building (PMB)",
            "Purchasing Department (PD)",
            "Real Estate Office (REO)",
            "Renewable Resource Center (RRC)",
            "Reno KNPB (KNPB)",
            "Residential Life, Housing and Food Service (RLHFS)",
            "Reynolds School of Journalism (RSJ)",
            "Ross Hall (RH)",
            "Sarah H Fleischmann Building (SFB)",
            "Savitt Medical Library (SML)",
            "Savitt Medical Science (SMS)",
            "Schulic Lecture Hall (SLH)",
            "Scrugham Engineering / Mines (SEM)",
            "Sierra Hall (SH)",
            "Sierra Street Parking Complex (SSPC)",
            "Sports Medicine Complex (SMC)",
            "Teaching & Learning Technologies (TLT)",
            "Tennis Courts (TC)",
            "The Overlook Food Court (OFC)",
            "The Quad (QUAD)",
            "Thompson Building (TB)",
            "University Studies Abroad Consortium (USAC)",
            "U.S. Post Office (PO)",
            "Virginia Street Gym (VSG)",
            "West Stadium Parking Complex (WSPC)",
            "White Pine Hall (WPH)",
            "Whittemore - Peterson Institue (WPI)",
            "William Peccole Park (WPP)",
            "William Raggio Building (WRB)"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

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
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), R.layout.sherlock_spinner_item, actions);
        getSupportActionBar().setNavigationMode(com.actionbarsherlock.app.ActionBar.NAVIGATION_MODE_LIST);
        ActionBar.OnNavigationListener navigationListener = new ActionBar.OnNavigationListener() {


            @Override
            public boolean onNavigationItemSelected(int itemPosition, long itemId) {
                Toast.makeText(getBaseContext(), "Destination: " + actions[itemPosition], Toast.LENGTH_SHORT).show();



                /*if (actions[itemPosition] == "SEM")
                    dest = SEM;
                else if (actions[itemPosition] == "KC")
                    dest = MIKCKC;
                else if (actions[itemPosition] == "Stadium")
                    dest = MS;*/
                if (actions[itemPosition] == "Admissions and Records (AR)") dest = AR;
                if (actions[itemPosition] == "Anderson Health Science (AHS)") dest = AHS;
                if (actions[itemPosition] == "Ansari Business Building (AB)") dest = AB;
                if (actions[itemPosition] == "Applied Research Facility (ARF)") dest = ARF;
                if (actions[itemPosition] == "Argenta Hall (AH)") dest = AH;
                if (actions[itemPosition] == "Artemesia Building (ARTM)") dest = ARTM;
                if (actions[itemPosition] == "Athletic Academic Center (MWPB)") dest = MWPB;
                if (actions[itemPosition] == "Canada Hall (CH)") dest = CH;
                if (actions[itemPosition] == "Cashiers Office (CO)") dest = CO;
                if (actions[itemPosition] == "Center for Molecular Medicine (CMM)") dest = CMM;
                if (actions[itemPosition] == "Central Heat Plant (CHP)") dest = CHP;
                if (actions[itemPosition] == "Central Services (CS)") dest = CS;
                if (actions[itemPosition] == "Chemistry Building (CB)") dest = CB;
                if (actions[itemPosition] == "Child Care Center (CCC)") dest = CCC;
                if (actions[itemPosition] == "Child Care Facility (CCF)") dest = CCF;
                if (actions[itemPosition] == "Childrens Behavioral Center Complex (CBCC)") dest = CBCC;
                if (actions[itemPosition] == "Church Fine Arts (CFA)") dest = CFA;
                if (actions[itemPosition] == "Clark Administration (CA)") dest = CA;
                if (actions[itemPosition] == "Computing Center (CC)") dest = CC;
                if (actions[itemPosition] == "Continuing Education (CE)") dest = CE;
                if (actions[itemPosition] == "Davidson Academy (JT)") dest = JT;
                if (actions[itemPosition] == "Davidson Mathematics and Science Center (DMSC)") dest = DMSC;
                if (actions[itemPosition] == "DeLaMare Library (DLM)") dest = DLM;
                if (actions[itemPosition] == "Dining Conference Center (DCC)") dest = DCC;
                if (actions[itemPosition] == "Disability Resource Center (DRC)") dest = DRC;
                if (actions[itemPosition] == "Edmund J. Cain Hall (EJCH)") dest = EJCH;
                if (actions[itemPosition] == "Environmental Research Facility (ERF)") dest = ERF;
                if (actions[itemPosition] == "Earthquake Laboratory (EL)") dest = EL;
                if (actions[itemPosition] == "Family Medicine Center (FMC)") dest = FMC;
                if (actions[itemPosition] == "Facilities Services (FS)") dest = FS;
                if (actions[itemPosition] == "Fitzgerald Student Services Building (FSSB)") dest = FSSB;
                if (actions[itemPosition] == "Fleischmann Agriculture (FA)") dest = FA;
                if (actions[itemPosition] == "Fleischmann Panetarium (FP)") dest = FP;
                if (actions[itemPosition] == "Frandsen Humanities (FH)") dest = FH;
                if (actions[itemPosition] == "Graduate Housing (GH)") dest = GH;
                if (actions[itemPosition] == "Harry Reid Engineering Laboratory (HREL)") dest = HREL;
                if (actions[itemPosition] == "Health Center (HC)") dest = HC;
                if (actions[itemPosition] == "Hillard Plaza (HP)") dest = HP;
                if (actions[itemPosition] == "Howard Medical Sciences (HMS)") dest = HMS;
                if (actions[itemPosition] == "Human Resources (HR)") dest = HR;
                if (actions[itemPosition] == "Intensive English Language Center (IELC)") dest = IELC;
                if (actions[itemPosition] == "International Center (IC)") dest = IC;
                if (actions[itemPosition] == "Joe Crowley Student Union (JCSU)") dest = JCSU;
                if (actions[itemPosition] == "John Sala Intramural Practice Field (JSIPF)") dest = JSIPF;
                if (actions[itemPosition] == "Jones Center (JC)") dest = JC;
                if (actions[itemPosition] == "Jot Travis Building (JT)") dest = JT;
                if (actions[itemPosition] == "Juniper Hall (JH)") dest = JH;
                if (actions[itemPosition] == "Knowledge Center (MIKC)") dest = MIKC;
                if (actions[itemPosition] == "Lawlor Events Center (LEC)") dest = LEC;
                if (actions[itemPosition] == "Legacy Hall (LEGH)") dest = LEGH;
                if (actions[itemPosition] == "Leifson Physics (LP)") dest = LP;
                if (actions[itemPosition] == "Life Science (LS)") dest = LS;
                if (actions[itemPosition] == "Lincoln Hall (LHD)") dest = LHD;
                if (actions[itemPosition] == "Lombardi Recreation Center (LR)") dest = LR;
                if (actions[itemPosition] == "Mack Social Science (MSS)") dest = MSS;
                if (actions[itemPosition] == "Mackey Mines (MM)") dest = MM;
                if (actions[itemPosition] == "Mackey Science (MS)") dest = MS;
                if (actions[itemPosition] == "Mackey Stadium (S)") dest = S;
                if (actions[itemPosition] == "Manville Health Science (MHS)") dest = MHS;
                if (actions[itemPosition] == "Manzanita Bowl(MB)") dest = MB;
                if (actions[itemPosition] == "Manzanita Hall (MAH)") dest = MAH;
                if (actions[itemPosition] == "Manzanita Lake(ML)") dest = ML;
                if (actions[itemPosition] == "Marquerite W. Peterson Building (MWPB)") dest = MWPB;
                if (actions[itemPosition] == "Mathewson / IGT Knowledge Center (MIKC)") dest = MIKC;
                if (actions[itemPosition] == "Morrill Hall (MH)") dest = MH;
                if (actions[itemPosition] == "Motor Pool (MP)") dest = MP;
                if (actions[itemPosition] == "National Judicial College (NJC)") dest = NJC;
                if (actions[itemPosition] == "Nell J. Redfield Building (NJR)") dest = NJR;
                if (actions[itemPosition] == "Nellor Biomedical Sciences (NBS)") dest = NBS;
                if (actions[itemPosition] == "Nevada Historical Society (NHS)") dest = NHS;
                if (actions[itemPosition] == "Nevada Living Learning Community (NLLC)") dest = NLLC;
                if (actions[itemPosition] == "Nevada State Health Laboratory (NSHL)") dest = NSHL;
                if (actions[itemPosition] == "Nye Hall (NH)") dest = NH;
                if (actions[itemPosition] == "Office of International Students and Scholars (OISS)") dest = OISS;
                if (actions[itemPosition] == "Orvis Building (OB)") dest = OB;
                if (actions[itemPosition] == "Palmer Engineering (PE)") dest = PE;
                if (actions[itemPosition] == "Parking Services (PS)") dest = PS;
                if (actions[itemPosition] == "Paul Laxalt Mineral Engineering (LME)") dest = LME;
                if (actions[itemPosition] == "Paul Laxalt Mineral Research (LMR)") dest = LMR;
                if (actions[itemPosition] == "Pennington Health Sciences Building (PHS)") dest = PHS;
                if (actions[itemPosition] == "Pennington Medical Education Building (PMB)") dest = PMB;
                if (actions[itemPosition] == "Purchasing Department (PD)") dest = PD;
                if (actions[itemPosition] == "Real Estate Office (REO)") dest = REO;
                if (actions[itemPosition] == "Renewable Resource Center (RRC)") dest = RRC;
                if (actions[itemPosition] == "Reno KNPB (KNPB)") dest = KNPB;
                if (actions[itemPosition] == "Residential Life, Housing and Food Service (RLHFS)") dest = RLHFS;
                if (actions[itemPosition] == "Reynolds School of Journalism (RSJ)") dest = RSJ;
                if (actions[itemPosition] == "Ross Hall (RH)") dest = RH;
                if (actions[itemPosition] == "Sarah H Fleischmann Building (SFB)") dest = SFB;
                if (actions[itemPosition] == "Savitt Medical Library (SML)") dest = SML;
                if (actions[itemPosition] == "Savitt Medical Science (SMS)") dest = SMS;
                if (actions[itemPosition] == "Schulic Lecture Hall (SLH)") dest = SLH;
                if (actions[itemPosition] == "Scrugham Engineering / Mines (SEM)") dest = SEM;
                if (actions[itemPosition] == "Sierra Hall (SH)") dest = SH;
                if (actions[itemPosition] == "Sierra Street Parking Complex (SSPC)") dest = SSPC;
                if (actions[itemPosition] == "Sports Medicine Complex (SMC)") dest = SMC;
                if (actions[itemPosition] == "Teaching & Learning Technologies (TLT)") dest = TLT;
                if (actions[itemPosition] == "Tennis Courts (TC)") dest = TC;
                if (actions[itemPosition] == "The Overlook Food Court (OFC)") dest = OFC;
                if (actions[itemPosition] == "The Quad (QUAD)") dest = QUAD;
                if (actions[itemPosition] == "Thompson Building (TB)") dest = TB;
                if (actions[itemPosition] == "University Studies Abroad Consortium (USAC)") dest = USAC;
                if (actions[itemPosition] == "U.S. Post Office (PO)") dest = PO;
                if (actions[itemPosition] == "Virginia Street Gym (VSG)" ) dest = VSG;
                if (actions[itemPosition] == "West Stadium Parking Complex (WSPC)" ) dest = WSPC;
                if (actions[itemPosition] == "White Pine Hall (WPH)") dest = WPH;
                if (actions[itemPosition] == "Whittemore - Peterson Institue (WPI)") dest = WPI;
                if (actions[itemPosition] == "William Peccole Park (WPP)") dest = WPP;
                if (actions[itemPosition] == "William Raggio Building (WRB)") dest = WRB;

                return false;
            }
        }; //d
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

        //start map markers
        Marker AHS1 = map.addMarker(new MarkerOptions()
                .position(AHS)
                .title("Anderson Health Science (AHS)"));
        Marker AB1 = map.addMarker(new MarkerOptions()
                .position(AB)
                .title("Ansari Business Building (AB)"));
        Marker ARF1 = map.addMarker(new MarkerOptions()
                .position(ARF)
                .title("Applied Research Facility (ARF)"));
        Marker AH1 = map.addMarker(new MarkerOptions()
                .position(AH)
                .title("Argenta Hall (AH)"));
        Marker ARTM1 = map.addMarker(new MarkerOptions()
                .position(ARTM)
                .title("Artemesia Building (ARTM)"));
        Marker CH1 = map.addMarker(new MarkerOptions()
                .position(CH)
                .title("Canada Hall (CH)"));
        Marker CMM1 = map.addMarker(new MarkerOptions()
                .position(CMM)
                .title("Center for Molecular Medicine (CMM)"));
        Marker CHP1 = map.addMarker(new MarkerOptions()
                .position(CHP)
                .title("Central Heat Plant (CHP)"));
        Marker CS1 = map.addMarker(new MarkerOptions()
                .position(CS)
                .title("Central Services (CS)"));
        Marker CB1 = map.addMarker(new MarkerOptions()
                .position(CB)
                .title("Chemistry Building (CB)"));
        Marker CCF1 = map.addMarker(new MarkerOptions()
                .position(CCF)
                .title("Child Care Facility (CCF)"));
        Marker CFA1 = map.addMarker(new MarkerOptions()
                .position(CFA)
                .title("Church of Fine Arts (CFA)"));
        Marker CA1 = map.addMarker(new MarkerOptions()
                .position(CA)
                .title("Clark Administration (CA)"));
        Marker CC1 = map.addMarker(new MarkerOptions()
                .position(CC)
                .title("Computing Center (CC)"));
        Marker CE1 = map.addMarker(new MarkerOptions()
                .position(CE)
                .title("Continuing Education (CE)"));
        Marker DMSC1 = map.addMarker(new MarkerOptions()
                .position(DMSC)
                .title("Davidson Mathematics and Science Center (DMSC)"));
        Marker DCC1 = map.addMarker(new MarkerOptions()
                .position(DCC)
                .title("Dining Conference Center (DCC)"));
        Marker EJCH1 = map.addMarker(new MarkerOptions()
                .position(EJCH)
                .title("Edmund J. Cain Hall (EJCH)"));
        Marker ERF1 = map.addMarker(new MarkerOptions()
                .position(ERF)
                .title("Environmental Research Facility (ERF)"));
        Marker EL1 = map.addMarker(new MarkerOptions()
                .position(EL)
                .title("Earthquake Laboratory (EL)"));
        Marker FMC1 = map.addMarker(new MarkerOptions()
                .position(FMC)
                .title("Family Medicine Center (FMC)"));
        Marker FS1 = map.addMarker(new MarkerOptions()
                .position(FS)
                .title("Facility Servies (FS)"));
        Marker FSSB1 = map.addMarker(new MarkerOptions()
                .position(FSSB)
                .title("Fitzgerald Student Services Building (FSSB)"));
        //end map markers

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
                if(markerPoints.size()>0){ //1
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

        //    float c = result.size();
        //    Toast.makeText(getBaseContext(), "The value of result.size1 is: " + c, Toast.LENGTH_SHORT).show();

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
            //   Toast.makeText(getBaseContext(), "The value of result.size2 is: " + c, Toast.LENGTH_SHORT).show();
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