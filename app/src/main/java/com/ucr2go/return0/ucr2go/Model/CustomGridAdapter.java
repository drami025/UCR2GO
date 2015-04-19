package com.ucr2go.return0.ucr2go.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ucr2go.return0.ucr2go.R;

/**
 * Created by bananapanda on 4/18/15.
 */
public class CustomGridAdapter extends BaseAdapter{

    private Context mContext;
    private String[] mfood_items;
    private int[] mfood_pics;

    public CustomGridAdapter(Context c, int string_array_id, int[] drawable_id_array) {
        mfood_items = c.getResources().getStringArray(string_array_id);
        mContext = c;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_item, null);
            TextView textView = (TextView) grid.findViewById(R.id.food_item);
            ImageView imageView = (ImageView)grid.findViewById(R.id.food_item_image);
            textView.setText(mfood_items[position]);
            imageView.setImageResource(mfood_pics[position]);
        } else {
            grid = (View) convertView;
        }

        return grid;

    }
}