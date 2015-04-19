package com.ucr2go.return0.ucr2go.Model;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ucr2go.return0.ucr2go.R;

/**
 * Created by bananapanda on 4/18/15.
 */
public class CustomGridAdapter extends BaseAdapter{

    private Context mContext;
    private String[] mfood_items;
    private int[] mfood_pics;
    private double[] mfood_prices;
    private boolean[] mPressed;

    public CustomGridAdapter(Context c, int string_array_id, int[] drawable_id_array) {
        mfood_items = c.getResources().getStringArray(string_array_id);
        mfood_pics = drawable_id_array;
        mContext = c;
    }

    public CustomGridAdapter(Context c, int string_array_id, int[] drawable_id_array, double[] prices,
                             boolean[] presses){
        mfood_items = c.getResources().getStringArray(string_array_id);
        mfood_pics = drawable_id_array;
        mContext = c;
        mfood_prices = prices;
        mPressed = presses;
    }

    @Override
    public int getCount() {
        return mfood_items.length;
    }

    @Override
    public Object getItem(int position) {
        if(mfood_prices == null)
            return 0;
        return new Double(mfood_prices[position]);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View grid = convertView;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            grid = inflater.inflate(R.layout.grid_item, parent, false);

        }
        LinearLayout layout = (LinearLayout) grid.findViewById(R.id.grid_item_layout);
        TextView foodNameTextView = (TextView) grid.findViewById(R.id.food_item);
        if(mfood_pics != null) {
            ImageView imageView = (ImageView) grid.findViewById(R.id.food_item_image);
            imageView.setImageResource(mfood_pics[position]);
        }
        foodNameTextView.setText(mfood_items[position]);



        if(mPressed[position]){
            layout.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        }
        else{
            layout.setBackgroundColor(Color.parseColor("#00000000"));
        }

        if(mfood_prices != null){
            TextView foodPriceTextView = (TextView) grid.findViewById(R.id.item_price);
            foodPriceTextView.setText(mfood_prices[position] + "");
        }

        return grid;

    }
}
