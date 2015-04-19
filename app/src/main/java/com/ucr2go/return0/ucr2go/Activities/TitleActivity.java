package com.ucr2go.return0.ucr2go.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ucr2go.return0.ucr2go.Model.RestaurantListAdapter;
import com.ucr2go.return0.ucr2go.R;


public class TitleActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        ListView listView = (ListView) findViewById(R.id.restaurant_list);
        String[] restaurants = getResources().getStringArray(R.array.restaurants);

        RestaurantListAdapter adapter = new RestaurantListAdapter(this, restaurants);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new ListView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TitleActivity.this, ResultsActivity.class);
                String message = null;
                switch(position){
                    case 0:
                        message = "JAVA LATTE SUPREME?";
                        intent = new Intent(TitleActivity.this, CoffeeBeanActivity.class);
                        break;
                    case 1:
                        message = "MUY CALIENTE";
                        break;
                    case 2:
                        message = "COMO SI CHIAMMA?";
                        intent = new Intent(TitleActivity.this, LaFiammaActivity.class);
                        break;
                    case 3:
                        message = "FRIED CHICKEN...I GOT TIME FOR THAT.";
                        intent = new Intent(TitleActivity.this, LatitudeActivity.class);
                        break;
                    case 4:
                        message = "FORTUNE COOKIE ALWAYS WRONG";
                        intent = new Intent(TitleActivity.this, PandaActivity.class);
                        break;
                    case 5:
                        message = "EAT FRESH";
                        intent = new Intent(TitleActivity.this, SubwayActivity.class);
                        break;
                }
                intent.putExtra("message", message);
                startActivity(intent);
            }
        });

    }

    private class RestaurantListListener implements ListView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(TitleActivity.this, "HELLO WORLD " + position, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_title, menu);
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
