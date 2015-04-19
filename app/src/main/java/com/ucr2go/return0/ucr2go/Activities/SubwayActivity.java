package com.ucr2go.return0.ucr2go.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.ucr2go.return0.ucr2go.Model.CustomGridAdapter;
import com.ucr2go.return0.ucr2go.Model.HashMapStringConverter;
import com.ucr2go.return0.ucr2go.Model.Node;
import com.ucr2go.return0.ucr2go.R;

import java.text.DecimalFormat;
import java.util.HashMap;


public class SubwayActivity extends ActionBarActivity {


    private int [] m_Subway_Food_Pics = {
        R.drawable.subway1_blackforestham,
        R.drawable.subway2_blt,
        R.drawable.subway4_meatball_marinara,
        R.drawable.subway5_primeribandcheese,
        R.drawable.subway6_seafood,
        R.drawable.subway7_spicyitalian,
        R.drawable.subway8_steakncheese,
        R.drawable.subway9_tuna,
        R.drawable.subway10_veggiedelite,
        R.drawable.subway11_egg_and_cheese,
        R.drawable.subway12_eggandham,
        R.drawable.subway_3chickenbaconranch

    };

    private double [] m_Prices = {
            5.99,
            6.99,
            5.99,
            5.99,
            6.99,
            7.99,
            7.99,
            6.99,
            5.99,
            5.99,
            5.99,
            6.99

    };

    private boolean m_subway_presses[] = {
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

    private TextView mTotalPrice;
    private CustomGridAdapter mAdapter;
    private GridView m_Grid_View;
    private HashMap<Integer, Node> mSubwaySelections;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subway);

        mSubwaySelections = new Hashmap<>();
        Button subway_button = (Button) findViewById(R.id.subway_button);

        subway_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String json = HashMapStringConverter.hashMapToString(mSubwaySelections);
                Intent intent = new Intent(SubwayActivity.this, ResultsActivity.class);
                intent.putExtra("hashmap", json);
                startActivity(intent);
            }
        });

        mTotalPrice = (TextView) findViewById(R.id.total_price_subway);
        mAdapter = new CustomGridAdapter(this, R.array.subway_food_items, m_Subway_Food_Pics,
                m_Prices, m_subway_presses);

        m_Grid_View = (GridView) findViewById(R.id.subway_gridview);
        m_Grid_View.setAdapter(mAdapter);

        m_Grid_View.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Double total_price = Double.valueOf(mTotalPrice.getText().toString().substring(1));
                Double price = (Double) mAdapter.getItem(position);
                if (m_subway_presses[position]) {
                    total_price -= price;
                    m_subway_presses[position] = false;
                } else {
                    total_price += price;
                    m_subway_presses[position] = true;
                }

                DecimalFormat formatter = new DecimalFormat("#0.00");
                mTotalPrice.setText("$" + formatter.format(total_price));
                m_Grid_View.invalidateViews();
            }
        });
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_subway, menu);
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
