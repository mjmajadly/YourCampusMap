package com.yourcampusmap.themap;

    import android.app.Activity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.view.inputmethod.InputMethodManager;
    import android.widget.TextView;

    public class SingleItemView extends Activity {
        // Declare Variables
        TextView txtstate;
        TextView txtuni;

        String state;
        String uni;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleitemview);
        // Hide the keyboard
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        // Retrieve data from MainActivity on item click event
        Intent i = getIntent();
        // Get the results of state
        state = i.getStringExtra("state");
        // Get the results of uni
        uni = i.getStringExtra("uni");

        // Locate the TextViews in singleitemview.xml
        txtstate = (TextView) findViewById(R.id.state);
        txtuni = (TextView) findViewById(R.id.uni);

        // Load the results into the TextViews
        txtstate.setText(state);
        txtuni.setText(uni);}

        public void gotomainmenu (View v) {

            Intent intent = new Intent(this, MainMenu.class);
            startActivity(intent);

    }
}