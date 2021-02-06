package com.mnf.raisoniworkshop30012021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText userFullNameEdittxt;
    EditText userEmaiIdEdittxt;
    EditText userPasswordEdittxt;
    EditText userRepasswordEdittxt;
    Button submitBtn;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userFullNameEdittxt = findViewById(R.id.full_name_edttxt);
        userEmaiIdEdittxt = findViewById(R.id.emailid_edttxt);
        userPasswordEdittxt = findViewById(R.id.password_edttxt);
        userRepasswordEdittxt = findViewById(R.id.repassword_edttxt);
        submitBtn = findViewById(R.id.submit_btn);
        sharedPreferences = getSharedPreferences(AppConstant.LOGIN_SHAREDPREFRECES,MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName= userFullNameEdittxt.getText().toString();
                String emailAddress= userEmaiIdEdittxt.getText().toString();
                String password= userPasswordEdittxt.getText().toString();

                if(validateMyData(fullName,emailAddress,password)) {
                    editor.putString(AppConstant.NAME, fullName);
                    editor.putString(AppConstant.EMAILID, emailAddress);
                    editor.putString(AppConstant.PASSWORD, password);
                    editor.commit();

                    Toast.makeText(RegisterActivity.this, "Commited", Toast.LENGTH_SHORT).show();
                    Toast.makeText(RegisterActivity.this, sharedPreferences.getString(AppConstant.NAME, "xyz"), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public boolean validateMyData(String fullName, String emailID, String password){
        boolean isValidate=true;
        if(AppConstant.isEmptyField(fullName)){
            userFullNameEdittxt.setError(getResources().getString(R.string.full_name_error));
            isValidate=false;
        }

        if(AppConstant.isEmptyField(emailID)){
            userEmaiIdEdittxt.setError(getResources().getString(R.string.emailId_error));
            isValidate=false;
        }

        if(AppConstant.isEmptyField(password)){
            userPasswordEdittxt.setError(getResources().getString(R.string.password_error));
            isValidate=false;
        }

        return isValidate;
    }
}