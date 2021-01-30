package com.mnf.raisoniworkshop30012021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    TextView loginIDTxtview;

    String loginID="",password="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        Bundle bundleFromMainActivity = getIntent().getExtras();

        if(bundleFromMainActivity!=null){
            loginID = bundleFromMainActivity.getString(AppConstant.LOGINID_KEY,"");
            password = bundleFromMainActivity.getString(AppConstant.PASSWORD_KEY,"");
        }
        loginIDTxtview = findViewById(R.id.loginid_txtview);

        loginIDTxtview.setText(loginID+"\n"+password);
    }
}