package com.demafayz.myhappagg.ItemLossProfit;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demafayz.myhappagg.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LossProfitFragment extends Fragment {


    public LossProfitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_loss_profit, container, false);
        // Inflate the layout for this fragment

        return v;
    }
}
