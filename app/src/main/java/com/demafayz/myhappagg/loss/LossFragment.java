package com.demafayz.myhappagg.loss;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.demafayz.myhappagg.MainActivity;
import com.demafayz.myhappagg.R;
import com.demafayz.myhappagg.dialog.DialogLossAndProfitFragment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 */
public class LossFragment extends Fragment {

    private static final String DIALOG_DATE = "date";
    private static final int REQUEST_DIALOG_DATE_GET = 1999;

    private static final String DIALOG_CLICKED_POSITION = "dialog clicked";
    private static final int DIALOG_DEFAULT_CLICKED_POSITION = 4;

    private static final int REQUEST_DATE = 0;

    AlertDialog.Builder alBuilder;
    private DialogLossAndProfitFragment dialog;
    private FragmentManager fragmentManager;


    private class ViewHolder {
        ListView lv_Loss;
    }

    private ViewHolder vh = new ViewHolder();
    private List<LossItem> myLossItem = new ArrayList<LossItem>();
    public void setMyLossItem(List<LossItem> myLossItem) {
        this.myLossItem = myLossItem;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_loss, container, false);
        vh.lv_Loss = (ListView) view.findViewById(R.id.lv_loss);
        createListView();

        // Inflate the layout for this fragment
        return view;
    }

    private void createListView() {
        populateListItems();
        createNewAdapter();
        setColorListView();
        onClickedRegister();
        getClickedDialog();
    }

    private void getClickedDialog() {

    }



    private void onClickedRegister() {
        fragmentManager = getActivity()
                .getFragmentManager();
        vh.lv_Loss.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String title = myLossItem.get(position).getTitle();
                dialog = newInstance(title);
                dialog.setTargetFragment(LossFragment.this, REQUEST_DATE);
                dialog.show(fragmentManager, DIALOG_DATE);
                //Intent i = new Intent(getActivity(), DialogLossAndProfitFragment.class);
                //getActivity().startActivityForResult(i, 4);
            }
        });
    }


    private void setColorListView() {
    vh.lv_Loss.setDivider(getResources().getDrawable(R.color.fragmentListDividerColor));
    }

    private void createNewAdapter() {
        ArrayAdapter<LossItem> adapter = new LossAdapter(this.getActivity(), 0, myLossItem);
        vh.lv_Loss.setAdapter(adapter);
    }

    private void populateListItems() {
        myLossItem.add(new LossItem(1, "Foot", "I bay foot", 567.3, "06.02.2015 17:04"));
        myLossItem.add(new LossItem(2, "MacBok", "Its my new comp", 120000, "08.02.2015 12:35"));
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == getActivity().RESULT_OK && requestCode == REQUEST_DATE) {
            int position = data.getIntExtra(DialogLossAndProfitFragment.DIALOG_CLICKED_POSITION,  4);
            Log.d("DIALOG",String.valueOf(position));
        }





    }

    public static DialogLossAndProfitFragment newInstance(String title) {
        DialogLossAndProfitFragment dialogLossAndProfitFragment = new DialogLossAndProfitFragment();
        Bundle args = new Bundle();
        args.putString("Loss_Title", title);
        dialogLossAndProfitFragment.setArguments(args);
        return dialogLossAndProfitFragment;
    }
}
