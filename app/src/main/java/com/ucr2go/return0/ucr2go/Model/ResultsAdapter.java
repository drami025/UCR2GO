package com.ucr2go.return0.ucr2go.Model;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ucr2go.return0.ucr2go.R;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by daniel on 4/19/15.
 */
public class ResultsAdapter extends ArrayAdapter {

    private Integer[] mDrawableIds;
    private Double[] mPrices;
    private String[] mNames;
    private Context mContext;

    public ResultsAdapter(Context context, HashMap<Integer, Node> hashMap, String[] names, int size) {
        super(context, R.layout.selection_list_item, names);
        mNames = new String[size];
        mDrawableIds = new Integer[size];
        mPrices = new Double[size];
        mContext = context;

        int i = 0;
        for(int j = 0; j < 40; j++){
            Node n = hashMap.get(j);

            if(n != null) {
                mNames[i] = n.getName();
                mDrawableIds[i] = n.getDrawableId();
                mPrices[i] = n.getPrice();
                i++;
                Log.e("CHECK NAME", n.getName());
            }
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)
                mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = convertView;
        if(rowView == null){
            rowView = inflater.inflate(R.layout.selection_list_item, parent, false);
        }

        TextView nameText = (TextView) rowView.findViewById(R.id.result_name);
        TextView priceText = (TextView) rowView.findViewById(R.id.result_price);
        ImageView image = (ImageView) rowView.findViewById(R.id.result_image);
        EditText addMoreText = (EditText) rowView.findViewById(R.id.result_add_more);


        int amountMore = 1; // Integer.getInteger(addMoreText.getText().toString());

        if(mPrices[position] == 0){
            priceText.setVisibility(View.INVISIBLE);
            addMoreText.setVisibility(View.INVISIBLE);
        }
        else{
            priceText.setText(mPrices[position] + "");
            double item_price = Double.valueOf(priceText.getText().toString());
            priceText.setText(item_price * amountMore + "");
        }

        if(mDrawableIds[position] == 0){
            image.setVisibility(View.INVISIBLE);
        }
        else{
            image.setImageResource(mDrawableIds[position]);
        }

        nameText.setText(mNames[position]);

        return rowView;
    }
}
