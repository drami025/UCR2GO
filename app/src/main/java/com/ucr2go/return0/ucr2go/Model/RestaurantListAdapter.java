package com.ucr2go.return0.ucr2go.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ucr2go.return0.ucr2go.R;

/**
 * Created by daniel on 4/18/15.
 */
public class RestaurantListAdapter extends ArrayAdapter<String> {
    private Context mContext;
    private String[] mRestaurant;
    private int[] mRestaurantIconIds = {
            R.drawable.coffee_bean_logo,
            R.drawable.habaneros_logo,
            R.drawable.la_fiamma_logo,
            R.drawable.latitude_55_logo,
            R.drawable.panda_express_logo,
            R.drawable.subway_logo
    };

    public RestaurantListAdapter(Context context, String[] restaurants){
        super(context, R.layout.restaurant_list_item, restaurants);
        mContext = context;
        mRestaurant = restaurants;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)
                mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = convertView;
        if(rowView == null) {
            rowView = inflater.inflate(R.layout.restaurant_list_item, parent, false);
        }
        TextView textView = (TextView) rowView.findViewById(R.id.restaurant_name);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.restaurant_logo);

        textView.setText(mRestaurant[position]);
        imageView.setImageResource(mRestaurantIconIds[position]);

        return rowView;
    }
}
