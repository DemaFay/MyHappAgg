package com.demafayz.myhappagg.dialog;


import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.demafayz.myhappagg.R;
import com.demafayz.myhappagg.loss.LossFragment;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class DialogLossAndProfitFragment extends DialogFragment {

    public static final String DIALOG_CLICKED_POSITION = "dialog clicked";
    public static final int REQUEST_DATE = 0;
    public static final String EXTRA_DATE = "com.demafayz.myhappagg.dialog";
    private Date mDate;

    private class ViewHolder {
        ListView lv_dialog;
    }

    private Intent intent;
    public DialogLossAndProfitFragment() {
        // Required empty public constructor
    }

    ViewHolder viewHolder = new ViewHolder();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_dialog_loss_and_profit, null);
        viewHolder.lv_dialog = (ListView) v.findViewById(R.id.lv_dialog_loss_and_profit);
        final String[] dialogList = getResources().getStringArray(R.array.dialog);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, dialogList);
        getDialog().setTitle(getTitle() + "");
        viewHolder.lv_dialog.setAdapter(adapter);
        viewHolder.lv_dialog.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            sendResult(Activity.RESULT_OK, position);
            dismiss();
            }
        });

        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }


    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);

    }
    private String getTitle() {
        return getArguments().getString("Loss_Title");
    }

    private void sendResult(int resultCode, int position) {
        if (getTargetFragment() == null) return;
        Intent i = new Intent();
        i.putExtra(DIALOG_CLICKED_POSITION, position);
        getTargetFragment()
                .onActivityResult(getTargetRequestCode(), resultCode, i);
    }
}

