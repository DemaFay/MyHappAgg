package com.demafayz.myhappagg.profit;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.demafayz.myhappagg.R;
import com.demafayz.myhappagg.loss.LossAdapter;
import com.demafayz.myhappagg.loss.LossItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfitFragment extends Fragment {

    private class ViewHolder {
        ListView lv_Profit;
    }

    private ViewHolder vh = new ViewHolder();

    public ProfitFragment() {
        // Required empty public constructor
    }

    private List<ProfitItem> myProfitItem = new ArrayList<ProfitItem>();
    public void setMyProfitItem(List<LossItem> myLossItem) {
        this.myProfitItem = myProfitItem;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profit, container, false);
        // Inflate the layout for this fragment
        vh.lv_Profit = (ListView) view.findViewById(R.id.lv_profit);
        createListView();
        return view;
    }

    private void createListView() {
        populateListItems();
        createNewAdapter();
        setColorListView();
    }

    private void setColorListView() {
        vh.lv_Profit.setDivider(getResources().getDrawable(R.color.fragmentListDividerColor));
    }

    private void createNewAdapter() {
        ArrayAdapter<ProfitItem> adapter = new ProfitAdapter(this.getActivity(), 0, myProfitItem);
        vh.lv_Profit.setAdapter(adapter);
    }

    private void populateListItems() {
        myProfitItem.add(new ProfitItem(1, "Foot", "I bay foot1", 56, "06.02.2015 17:04"));
        myProfitItem.add(new ProfitItem(2, "MacBok", "Its my new comp1", 120, "08.02.2015 12:35"));
    }


}
