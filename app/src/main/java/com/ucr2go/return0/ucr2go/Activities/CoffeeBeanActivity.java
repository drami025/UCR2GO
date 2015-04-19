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


public class CoffeeBeanActivity extends ActionBarActivity {

    //private array of ints for coffee images
    private int mCoffeeBeanPics[] = {
     R.drawable.coffee_bean01,
     R.drawable.coffee_bean02,
     R.drawable.coffee_bean03,
     R.drawable.coffee_bean04,
     R.drawable.coffee_bean05,
     R.drawable.coffee_bean06,
     R.drawable.coffee_bean07,
     R.drawable.coffee_bean08,
     R.drawable.coffee_bean09,
     R.drawable.coffee_bean10,
     R.drawable.coffee_bean11,
     R.drawable.coffee_bean12,
     R.drawable.coffee_bean13,
     R.drawable.coffee_bean14,
     R.drawable.coffee_bean15,
     R.drawable.coffee_bean16,
     R.drawable.coffee_bean17,
     R.drawable.coffee_bean18,
     R.drawable.coffee_bean19,
     R.drawable.coffee_bean20,
     R.drawable.coffee_bean21,
     R.drawable.coffee_bean22,
     R.drawable.coffee_bean23,
     R.drawable.coffee_bean24,
     R.drawable.coffee_bean25,
     R.drawable.coffee_bean26,
     R.drawable.coffee_bean27,
     R.drawable.coffee_bean28,
     R.drawable.coffee_bean29,
     R.drawable.coffee_bean30,
     R.drawable.coffee_bean31,
     R.drawable.coffee_bean32
    };

    //private double array for the prices
    private double coffee_price[] =
        {
                1.55,
                3.14,
                1.01,
                5.00,
                1.89,
                2.13,
                4.32,
                2.21,
                9.99,
                10.00,
                1.55,
                3.14,
                1.01,
                5.00,
                1.89,
                2.13,
                4.32,
                2.21,
                9.99,
                5.95,
                1.55,
                3.14,
                1.31,
                6.66,
                1.89,
                2.13,
                4.32,
                2.21,
                9.99,
                10.00,
                11.11,
                1.00
        };

    private boolean[] coffee_presses = {
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_bean);


        mTotalPrice = (TextView) findViewById(R.id.total_price_coffee);
        mAdapter = new CustomGridAdapter(this, R.array.coffee_bean_items, mCoffeeBeanPics, coffee_price
        , coffee_presses);

        mGridView = (GridView) findViewById(R.id.coffee_gridview);
        mGridView.setAdapter(mAdapter);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Double total_price = Double.valueOf(mTotalPrice.getText().toString().substring(1));
                Double price = (Double) mAdapter.getItem(position);
                if (coffee_presses[position]) {
                    total_price -= price;
                    coffee_presses[position] = false;
                } else {
                    total_price += price;
                    coffee_presses[position] = true;
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
        getMenuInflater().inflate(R.menu.menu_coffee_bean, menu);
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
