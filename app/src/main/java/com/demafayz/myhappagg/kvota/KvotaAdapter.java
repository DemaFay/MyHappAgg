package com.demafayz.myhappagg.kvota;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.demafayz.myhappagg.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DemaFayz on 17.02.2015.
 */
public class KvotaAdapter extends ArrayAdapter<KvotaItem> {
    private class ViewHolder {
        TextView tv_Title;
        TextView tv_Sum;
        TextView tv_Date;
    }

    private List<KvotaItem> list = new ArrayList<KvotaItem>();
    private LayoutInflater layoutInflater;

    public KvotaAdapter(Context context, int resource, List<KvotaItem> objects) {
        super(context, resource, objects);
        list = objects;
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            ViewHolder vh = new ViewHolder();
            itemView = layoutInflater.inflate(R.layout.kvota_item, parent, false);
            vh.tv_Title = (TextView) itemView.findViewById(R.id.tv_kvota_title);
            vh.tv_Sum = (TextView) itemView.findViewById(R.id.tv_kvota_sum);
            vh.tv_Date = (TextView) itemView.findViewById(R.id.tv_kvota_date);
            itemView.setTag(vh);
        }
        ViewHolder vh = (ViewHolder) itemView.getTag();
        vh.tv_Title.setText(String.valueOf(list.get(position).getTitle()));
        vh.tv_Sum.setText(String.valueOf(list.get(position).getSum()));
        vh.tv_Date.setText(String.valueOf(list.get(position).getDay() + "." +
                list.get(position).getMonth() + "." +
                list.get(position).getYear()));
        itemView.setTag(vh);
        return itemView;
    }
}
