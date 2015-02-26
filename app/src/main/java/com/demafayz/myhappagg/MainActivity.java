package com.demafayz.myhappagg;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NavUtils;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.demafayz.myhappagg.DB.DBHelper;
import com.demafayz.myhappagg.adddatalossandfrofit.AddData;
import com.demafayz.myhappagg.navigationdrawer.NavigationDrawerFragment;


public class MainActivity extends ActionBarActivity {
    private DBHelper dbHelper;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout)findViewById(R.id.drawer_layout), toolbar);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {return;}
        String title = data.getStringExtra("title");
        String description = data.getStringExtra("description");
        String sum = String.valueOf(data.getStringExtra("sum"));
        Toast.makeText(MainActivity.this, title, Toast.LENGTH_LONG).show();
        //Create object for data's
        ContentValues cv = new ContentValues();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        cv.put("title", title);
        cv.put("description", description);
        cv.put("sum", sum);
        // OSTALSYA TUT

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(MainActivity.this, "Hey you just his " + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.navigate) {

            startActivityForResult(new Intent(this, AddData.class), 1);
        }
        if (id == R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }
}
