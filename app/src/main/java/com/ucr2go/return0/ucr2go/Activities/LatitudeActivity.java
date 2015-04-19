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
import com.ucr2go.return0.ucr2go.Model.Node;
import com.ucr2go.return0.ucr2go.R;

import java.text.DecimalFormat;
import java.util.LinkedList;


public class LatitudeActivity extends ActionBarActivity {


    private int[] latitude_food = {
            R.drawable.latitude_Chickenstrips,
            R.drawable.latitude_Hamburger,
            R.drawable.latitude_DoubleCheeseBurger,
            R.drawable.latitude_GrilledCheese,
            R.drawable.latitude_Fries
    };

    private double[] latitude_food_prices = {
            3.99,
            4.99,
            3.99,
            3.99,
            1.99
    };

    private boolean[] latitude_presses = {
            false,
            false,
            false,
            false,
            false
    };

    // Member Variables
    private CustomGridAdapter mAdapter;
    private TextView mTotalPrice;
    private GridView mGridView;

    private LinkedList<Node> checkout_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latitude);

        mTotalPrice = (TextView) findViewById(R.id.total_price_latitude);
        mAdapter = new CustomGridAdapter(this, R.array.latitude_food_items, latitude_food,
                latitude_food_prices, latitude_presses);

        mGridView = (GridView) findViewById(R.id.latitude_gridview);
        mGridView.setAdapter(mAdapter);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Double total_price = Double.valueOf(mTotalPrice.getText().toString().substring(1));
                Double price = (Double) mAdapter.getItem(position);

                // Create Node to put onto checkout list
                Node node(mAdapter.getStringItem(position),latitude_food_prices[position],latitude_food[position]);

                if (latitude_presses[position]) {
                    total_price -= price;
                    latitude_presses[position] = false;

                    // Remove an item from the checkout List
                    checkout_list.remove(node);

                } else {
                    total_price += price;
                    latitude_presses[position] = true;

                    // Add an item from the checkout List
                    checkout_list.add(node);
                }

                DecimalFormat formatter = new DecimalFormat("#0.00");
                mTotalPrice.setText("$" + formatter.format(total_price));
                mGridView.invalidateViews();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_latitude, menu);
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
