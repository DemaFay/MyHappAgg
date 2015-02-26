package com.demafayz.myhappagg.navigationdrawer;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.demafayz.myhappagg.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DemaFayz on 03.02.2015.
 */
public class NavigationDrawerAdapter extends ArrayAdapter<NavigationDrawerItem> {
    private static final String TAG = "NavigationDrawerAdapter";
    private List<NavigationDrawerItem> list = new ArrayList<NavigationDrawerItem>();
    private class ViewHolder{
        ImageView iv_Icon;
        TextView tv_Title;
    }
    private ViewHolder vh;
    private int selectPosition;
    private LayoutInflater layoutInflater;
    public NavigationDrawerAdapter(Context context, int resource, List<NavigationDrawerItem> objects, int selectPosition) {
        super(context, resource, objects);
        list = objects;
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);


        this.selectPosition = selectPosition;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG, "getViewCalled");
        View itemView = convertView;
        if (itemView == null) {
            vh = new ViewHolder();
            itemView = layoutInflater.inflate(R.layout.navigation_drawer_item, parent, false);
            vh.tv_Title = (TextView) itemView.findViewById(R.id.tv_nd_item_title);
            vh.iv_Icon = (ImageView) itemView.findViewById(R.id.iv_nd_item_icon);
            itemView.setTag(vh);
        } else {
            vh = (ViewHolder) itemView.getTag();
        }
        vh.tv_Title.setText(list.get(position).getTitle());
        vh.iv_Icon.setImageResource(list.get(position).getIcon());
        if (position == selectPosition) {
            Log.d(TAG, "Position = "+ position);
            Log.d(TAG, ""+ selectPosition);
            itemView.setBackgroundResource(R.drawable.navigationDrawerItemHold);

        }
        itemView.setTag(vh);

        return itemView;
    }
}
