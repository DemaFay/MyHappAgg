package com.demafayz.myhappagg.navigationdrawer;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.demafayz.myhappagg.R;
import com.demafayz.myhappagg.kvota.KvotaFragment;
import com.demafayz.myhappagg.loss.LossFragment;
import com.demafayz.myhappagg.profit.ProfitFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment {

    private static final String TAG = "NavigationDrowerFragment";
    public static final String PREF_FILE_NAME = "testpref";
    public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    private boolean mUserLearnedDrawer;
    private boolean mFromSavedInstanceState;
    private View containerView;

    private int defSelectedPositionND = -1;
    private ArrayAdapter<NavigationDrawerItem> adapter;

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }
    private class ViewHolder{
        ListView lv;
    }
    private ViewHolder vh = new ViewHolder();
    private List<NavigationDrawerItem> myDrawerItem = new ArrayList<NavigationDrawerItem>();

    public void setMyDrawerItem(List<NavigationDrawerItem> myDrawerItem) {
        this.myDrawerItem = myDrawerItem;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserLearnedDrawer = Boolean.valueOf(readFromPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, "false"));
        if (savedInstanceState != null) {
            mFromSavedInstanceState = true;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        vh.lv = (ListView) view.findViewById(R.id.lv_nd);
        createNavigationDrowwer();
        openStartFragment();
        return view;
    }

    private void openStartFragment() {
//        View oneView = vh.lv.getView
    }

    private void createNavigationDrowwer() {
        populateListItems();
        createNewAdapter();
        setDividerColor();
        listViewClickedRegister();

    }

    private void listViewClickedRegister() {
        vh.lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setSelected(true);
                FragmentManager fragmentManager = getActivity().getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                defSelectedPositionND = position;

                switch (position) {
                    case 0: {
                        LossFragment lossFragment = new LossFragment();
                        fragmentTransaction.replace(R.id.fragment_container, lossFragment);
                        fragmentTransaction.commit();
                    } break;
                    case 1: {
                        ProfitFragment profitFragment = new ProfitFragment();
                        fragmentTransaction.replace(R.id.fragment_container, profitFragment);
                        fragmentTransaction.commit();
                    } break;
                    case 2: {
                        KvotaFragment kvotaFragment = new KvotaFragment();
                        fragmentTransaction.replace(R.id.fragment_container, kvotaFragment);
                        fragmentTransaction.commit();
                    } break;
                }
            }
        });


    }


    private void setDividerColor() {
        vh.lv.setDivider(getResources().getDrawable(R.color.navigationDrawerDividersColor));
    }

    private void createNewAdapter() {
        adapter = new NavigationDrawerAdapter(this.getActivity(), 0, myDrawerItem, 2);
        vh.lv.setAdapter(adapter);
    }

    private void populateListItems() {
        myDrawerItem.add(new NavigationDrawerItem("Item 1", R.drawable.launch_icon));
        myDrawerItem.add(new NavigationDrawerItem("Item 2", R.drawable.launch_icon));
        myDrawerItem.add(new NavigationDrawerItem("Item 3", R.drawable.launch_icon));
        myDrawerItem.add(new NavigationDrawerItem("Item 4", R.drawable.launch_icon));
    }


    public void setUp(int fragmentId, DrawerLayout drawerLayout, Toolbar toolbar) {
        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (!mUserLearnedDrawer){
                    mUserLearnedDrawer = true;
                    saveToPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, mUserLearnedDrawer + "");
                }
                getActivity().invalidateOptionsMenu();
//                adapter.notifyDataSetChanged();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }
        };
        if (!mUserLearnedDrawer && !mFromSavedInstanceState){
            mDrawerLayout.openDrawer(containerView);
        }
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }

    public static void saveToPreferences(Context context, String preferenceName, String preferenceValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(preferenceName, preferenceValue);
        editor.apply();
    }

    public  static String readFromPreferences(Context context, String preferenceName, String preferenceValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(preferenceName, preferenceValue);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
