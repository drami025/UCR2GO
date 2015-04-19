package com.ucr2go.return0.ucr2go.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ucr2go.return0.ucr2go.R;




public class InformationActivity extends ActionBarActivity {

    private EditText mName;
    private EditText mCredit;
    private EditText mLocation;

    private Button mButton;

    public class MyActivity extends ActionBarActivity {
        public final static String EXTRA_MESSAGE = "com.ucr2g0.return0.ucr2g0.MESSAGE";

    }

    private void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.credit);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }



    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        //Intent intent = getIntent();
        //String message = intent.getStringExtra(InformationActivity.EXTRA_MESSAGE);
        mName = (EditText) findViewById(R.id.info);
        mCredit = (EditText) findViewById(R.id.credit);
        mLocation = (EditText) findViewById(R.id.location);

        mButton = (Button) findViewById(R.id.buttoninfo);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_information, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
