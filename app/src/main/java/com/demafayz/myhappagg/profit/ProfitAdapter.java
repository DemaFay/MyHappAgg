package com.demafayz.myhappagg.profit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.demafayz.myhappagg.R;
import com.demafayz.myhappagg.loss.LossItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DemaFayz on 06.02.2015.
 */
public class ProfitAdapter extends ArrayAdapter<ProfitItem> {

    private List<ProfitItem> list = new ArrayList<ProfitItem>();
    private class ViewHolder {
        TextView tv_Title;
        TextView tv_SubTitle;
    }
    private LayoutInflater layoutInflater;

    public ProfitAdapter(Context context, int resource, List<ProfitItem> objects) {
        super(context, resource, objects);
        list = objects;
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            ViewHolder vh = new ViewHolder();
            itemView = layoutInflater.inflate(R.layout.loss_item, parent, false);
            vh.tv_Title = (TextView) itemView.findViewById(R.id.tv_loss_title);
            vh.tv_SubTitle = (TextView) itemView.findViewById(R.id.tv_loss_subtitle);
            itemView.setTag(vh);
        }
        ViewHolder vh = (ViewHolder) itemView.getTag();
        vh.tv_Title.setText(list.get(position).getTitle());
        vh.tv_SubTitle.setText(String.valueOf(list.get(position).getSum()));
        itemView.setTag(vh);
        return itemView;
    }
}
