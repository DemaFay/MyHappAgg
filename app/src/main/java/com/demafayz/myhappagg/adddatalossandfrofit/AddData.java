package com.demafayz.myhappagg.adddatalossandfrofit;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.demafayz.myhappagg.MainActivity;
import com.demafayz.myhappagg.R;

public class AddData extends ActionBarActivity {
    private class ViewHolder {
        EditText et_Title;
        EditText et_Description;
        EditText et_Sum;
        Button bt_add;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewHolder vh = new ViewHolder();
        vh.bt_add = (Button) findViewById(R.id.bt_add_data_add_data);
        vh.bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewHolder vh = new ViewHolder();
                vh.et_Title = (EditText) findViewById(R.id.et_add_data_title);
                vh.et_Description = (EditText) findViewById(R.id.et_add_data_subtitle);
                vh.et_Sum = (EditText) findViewById(R.id.et_add_data_sum);

                Intent intent = new Intent();
                intent.putExtra("fragment", 0);
                intent.putExtra("title", vh.et_Title.getText().toString());
                intent.putExtra("description", vh.et_Description.getText().toString());
                intent.putExtra("sum", vh.et_Sum.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_data, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
