package com.yourcampusmap.themap;

import java.util.ArrayList;
import java.util.Locale;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuItem.OnActionExpandListener;
import com.actionbarsherlock.view.MenuItem.OnMenuItemClickListener;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends SherlockActivity{

    // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    EditText editsearch;
    String[] state;
    String[] uni;
    ArrayList<CampusName> arraylist = new ArrayList<CampusName>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);

        // Generate sample data
        state = new String[]{"California", "California", "California",
                "Hawaii", "Michigan", "Michigan",
                "Nevada", "Nevada", "Nevada", "New Mexico"};


        uni = new String[]{
                "University of California, Berkeley (UC Berkeley)",
                "University of California, Davis(UC Davis)",
                "University of California, Los Angeles (UCLA)",
                "University of Hawaii at Manoa (UH)",
                "Central Michigan University (CMU)",
                "Eastern Michigan University (EMU)",
                "University of Nevada, Reno (UNR)",
                "University of Nevada, Las Vegas (UNLV)",
                "Truckee Meadows Community College (TMCC)",
                "University of New Mexico (UNM)"};

        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < state.length; i++) {
            CampusName wp = new CampusName(state[i], uni[i]);
            // Binds all strings into an array
            arraylist.add(wp);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);
    }

    // Create the options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Get the options menu view from menu.xml in menu folder
        getSupportMenuInflater().inflate(R.menu.menu, menu);

        // Locate the EditText in menu.xml
        editsearch = (EditText) menu.findItem(R.id.menu_search).getActionView();

        // Capture Text in EditText
        editsearch.addTextChangedListener(textWatcher);

        // Show the search menu item in menu.xml
        MenuItem menuSearch = menu.findItem(R.id.menu_search);

        menuSearch.setOnActionExpandListener(new OnActionExpandListener() {

            // Menu Action Collapse
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                // Empty EditText to remove text filtering
                editsearch.setText("");
                editsearch.clearFocus();
                return true;
            }

            // Menu Action Expand
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                // Focus on EditText
                editsearch.requestFocus();

                // Force the keyboard to show on EditText focus
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
                return true;
            }
        });

        // Show the settings menu item in menu.xml
        MenuItem menuSettings = menu.findItem(R.id.menu_settings);

        // Capture menu item clicks
        menuSettings.setOnMenuItemClickListener(new OnMenuItemClickListener() {

         @Override
        public boolean onMenuItemClick(MenuItem item) {
            // TODO Auto-generated method stub
            // Do something here
            Toast.makeText(getApplicationContext(), "Nothing here!",
            Toast.LENGTH_LONG).show();
            return false;
        }
    });

        return true;
    }

    // EditText TextWatcher
    private TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
            String text = editsearch.getText().toString()
                    .toLowerCase(Locale.getDefault());
            adapter.filter(text);
        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                  int arg3) {
            // TODO Auto-generated method stub

        }

    };
}
