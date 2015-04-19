package com.ucr2go.return0.ucr2go.Activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.ucr2go.return0.ucr2go.Model.CustomGridAdapter;
import com.ucr2go.return0.ucr2go.R;

import java.text.DecimalFormat;


public class PandaActivity extends ActionBarActivity {

    private int[] panda_food = {
            R.drawable.panda_express_orangechicken,
            R.drawable.panda_express_sweetfirechickenbreast,
            R.drawable.panda_express_stringbeanchickenbreast,
            R.drawable.panda_express_kungpaochicken,
            R.drawable.panda_express_blackpepperchicken,
            R.drawable.panda_express_teriyakichicken,
            R.drawable.panda_expressribs,
            R.drawable.panda_express_broccolibeef,
            R.drawable.panda_express_shainghaiangussteak,
            R.drawable.panda_express_beijingbeef,
            R.drawable.panda_express_orangechikenshrimp,
            R.drawable.panda_express_tofu,
            R.drawable.panda_express_chowmein,
            R.drawable.panda_express_friedrice,
            R.drawable.panda_express_vegetables,
            R.drawable.panda_express_whiterice,
            R.drawable.panda_express_brownrice,
            R.drawable.panda_express_dumplings,
            R.drawable.panda_express_potstickers,
            R.drawable.panda_express_springroll,
            R.drawable.panda_express_eggroll,
            R.drawable.panda_express_mushroomsoup,
            R.drawable.panda_express_friedshrimp,
            R.drawable.panda_express_fortunecookie,
            R.drawable.panda_express_cookie
    };

    private double[] panda_food_prices = {
            3.99,
            3.99,
            3.99,
            3.99,
            3.99,
            3.99,
            3.99,
            3.99,
            3.99,
            3.99,
            3.99,
            3.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            0.99,
            0.99
    };

    private CustomGridAdapter mAdapter;
    private TextView mTotalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panda);

        mTotalPrice = (TextView) findViewById(R.id.total_price_panda);
        mAdapter = new CustomGridAdapter(this, R.array.panda_food_items, panda_food, panda_food_prices);

        GridView gridview = (GridView) findViewById(R.id.panda_gridview);
        gridview.setAdapter(mAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Double total_price = Double.valueOf(mTotalPrice.getText().toString().substring(1));
                Double price = (Double) mAdapter.getItem(position);
                total_price += price;
                DecimalFormat formatter = new DecimalFormat("#0.00");
                mTotalPrice.setText("$" + formatter.format(total_price));
                Toast.makeText(PandaActivity.this, "" + price,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_panda, menu);
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
