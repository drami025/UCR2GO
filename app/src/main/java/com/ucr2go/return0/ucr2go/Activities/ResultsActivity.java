package com.ucr2go.return0.ucr2go.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.ucr2go.return0.ucr2go.Model.HashMapStringConverter;
import com.ucr2go.return0.ucr2go.Model.Node;
import com.ucr2go.return0.ucr2go.Model.ResultsAdapter;
import com.ucr2go.return0.ucr2go.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


public class ResultsActivity extends ActionBarActivity {

    private HashMap<Integer, Node> mSelections;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Intent intent = getIntent();
        String result_message = intent.getStringExtra("hashmap");
        mSelections = HashMapStringConverter.stringToHashMap(result_message);

        Collection<Node> hashmap = mSelections.values();
        int size = hashmap.size();
        String[] names = new String[size];
        int i = 0;
        for(Node n : hashmap){
            names[i] = n.getName();
            i++;
        }

        ListView resultList = (ListView) findViewById(R.id.selection_list);
        resultList.setAdapter(new ResultsAdapter(this, mSelections, names));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_results, menu);
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
