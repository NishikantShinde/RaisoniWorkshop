package com.mnf.raisoniworkshop30012021;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText loginIDEdittext;
    EditText passwordEdittext;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginIDEdittext=findViewById(R.id.user_name);
        passwordEdittext=findViewById(R.id.user_password);
        loginButton=findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loginID=loginIDEdittext.getText().toString();
                String password=passwordEdittext.getText().toString();

                Toast.makeText(MainActivity.this, loginID, Toast.LENGTH_SHORT).show();
                Snackbar.make(view,password, BaseTransientBottomBar.LENGTH_SHORT).show();

                Bundle bundleForDashboard = new Bundle();
                bundleForDashboard.putString(AppConstant.LOGINID_KEY,loginID);
                bundleForDashboard.putString(AppConstant.PASSWORD_KEY,password);

                Intent intentForDashboard = new Intent(MainActivity.this,DashboardActivity.class);
                intentForDashboard.putExtras(bundleForDashboard);
                startActivity(intentForDashboard);
            }
        });



//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}