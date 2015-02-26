package com.demafayz.myhappagg.kvota.addkvota;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.demafayz.myhappagg.R;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddKvotaFragment extends Fragment {
    private class ViewHolder{
        EditText et_Title;
        EditText et_Description;
        EditText et_Sum;
        Button bt_Add;
    }

    private String title;
    private String description;
    private double sum;
    private int day;
    private int month;
    private int year;

    public AddKvotaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_kvota, container, false);
        ViewHolder vh = new ViewHolder();
        vh.et_Title = (EditText) view.findViewById(R.id.et_add_kvota_title);
        vh.et_Description = (EditText) view.findViewById(R.id.et_add_kvota_description);
        vh.et_Sum = (EditText) view.findViewById(R.id.etet_add_kvota_sum);
        vh.bt_Add = (Button) view.findViewById(R.id.bt_add_data_add_data);
        title = vh.et_Title.getText().toString();
        description = vh.et_Description.getText().toString();
        sum = Double.parseDouble(vh.et_Sum.getText().toString());
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = Calendar.MONTH;
        day = calendar.get(Calendar.DAY_OF_MONTH);
//        Log.d("Date_Calendar", String.valueOf("" + year + " " + month + " " + day));
//        vh.et_Title.setText(String.valueOf("" + year + " " + month + " " + day));
        // Inflate the layout for this fragment
        return view;
    }


}
