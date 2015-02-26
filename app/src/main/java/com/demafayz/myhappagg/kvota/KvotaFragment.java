package com.demafayz.myhappagg.kvota;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.demafayz.myhappagg.R;

import java.util.ArrayList;
import java.util.List;
import com.demafayz.myhappagg.kvota.KvotaItem;
import com.demafayz.myhappagg.kvota.addkvota.AddKvotaFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class KvotaFragment extends Fragment {


    public KvotaFragment() {
        // Required empty public constructor
    }

    private class ViewHolder{
        ListView lv_Kvota;
        Button bt_Add;
    }

    private ViewHolder vh = new ViewHolder();
    private List<KvotaItem> myKvotaItems = new ArrayList<KvotaItem>();

    public void setMyKvotaItems(List<KvotaItem> myKvotaItems) {
        this.myKvotaItems = myKvotaItems;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_kvota, container, false);
        // Inflate the layout for this fragment

        vh.lv_Kvota = (ListView) v.findViewById(R.id.lv_kvota);

        createListView();
        inflateAddFragment(v);

        return v;
    }

    private void inflateAddFragment(View v) {
        vh.bt_Add = (Button) v.findViewById(R.id.bt_kvota_add);
        vh.bt_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                AddKvotaFragment addKvotaFragment = new AddKvotaFragment();
                fragmentTransaction.replace(R.id.fragment_container, addKvotaFragment);
                fragmentTransaction.commit();
            }
        });

    }

    private void createListView() {
        populateListItems();
        createAdapter();
    }

    private void createAdapter() {
        ArrayAdapter<KvotaItem> adapter = new KvotaAdapter(this.getActivity(), 0, myKvotaItems);
        vh.lv_Kvota.setAdapter(adapter);
    }

    private void populateListItems() {
        myKvotaItems.add(new KvotaItem("Internet", "bay Yota internet", 250, 18, 2, 2015));
        myKvotaItems.add(new KvotaItem("Mobile", "may telephone for call and internet", 200, 18, 2, 2015));
    }


}
