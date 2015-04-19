package com.ucr2go.return0.ucr2go.Activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.ucr2go.return0.ucr2go.Model.CustomGridAdapter;
import com.ucr2go.return0.ucr2go.R;

import java.text.DecimalFormat;


public class LaFiammaActivity extends ActionBarActivity {

    private boolean[] fiamma_presses = {
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false
    };

    private CustomGridAdapter mAdapter;
    private TextView mTotalPrice;
    private GridView mGridView;
    private boolean fiamma[] = {false,false,false,false,false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_la_fiamma);

        mTotalPrice = (TextView) findViewById(R.id.total_price_fiamma);
        mAdapter = new CustomGridAdapter(this, R.array.fiamma_food_items, null,
                null, fiamma_presses);

        mGridView = (GridView) findViewById(R.id.fiamma_gridview);
        mGridView.setAdapter(mAdapter);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

               // if(fiamma[0] && (fiamma_presses[0] || fiamma_presses[1] || fiamma_presses[2]) )

                if (fiamma_presses[position]) {
                    fiamma_presses[position] = false;
                } else {

                    fiamma_presses[position] = true;
                }

                DecimalFormat formatter = new DecimalFormat("#0.00");
                mGridView.invalidateViews();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_la_fiamma, menu);
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
