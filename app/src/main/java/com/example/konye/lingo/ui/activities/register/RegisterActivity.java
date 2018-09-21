package com.example.konye.lingo.ui.activities.register;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.konye.lingo.R;
import com.example.konye.lingo.ui.activities.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    String firstname, surname, username, email, password, retypedPassword;
    EditText firstnameEdit, surnameEdit, usernameEdit, emailEdit, passwordEdit, retypedPasswordEdit;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //changeWidgetsFont();
        //firebaseAuth = FirebaseAuth.getInstance();
        //addding the widgets
        progressDialog = new ProgressDialog(this);
        firstnameEdit = findViewById(R.id.reg_firstname_editTextView);
        surnameEdit = findViewById(R.id.reg_surname_editTextView);
        usernameEdit = findViewById(R.id.reg_username_editTextView);
        emailEdit = findViewById(R.id.reg_email_editTextView);
        passwordEdit = findViewById(R.id.reg_password_editTextView);
        retypedPasswordEdit = findViewById(R.id.reg_retype_password_editTextView);
        Button registerButton = findViewById(R.id.register_button);
        TextView signInTextView = findViewById(R.id.sign_in_textVIew);

        registerButton.setOnClickListener(v -> {
            //getUserDetailsAndCheckEmptyAndRegisterUser();
            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
            finish();
        });

        signInTextView.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }

    /*private void getUserDetailsAndCheckEmptyAndRegisterUser(){
        firstname = firstnameEdit.getText().toString().trim();
        surname = surnameEdit.getText().toString().trim();
        username = usernameEdit.getText().toString().trim();
        email = emailEdit.getText().toString().trim();
        password = passwordEdit.getText().toString().trim();
        retypedPassword = retypedPasswordEdit.getText().toString().trim();

        if(TextUtils.isEmpty(firstname)){
            Toast.makeText(this, "please enter your first name", Toast.LENGTH_LONG).show();
        }
        if(TextUtils.isEmpty(surname)){
            Toast.makeText(this, "please enter surname", Toast.LENGTH_LONG).show();
        }
        if(TextUtils.isEmpty(username)){
            Toast.makeText(this, "please enter username", Toast.LENGTH_LONG).show();
        }
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "please enter email", Toast.LENGTH_LONG).show();
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "please enter password", Toast.LENGTH_LONG).show();
        }
        if(TextUtils.isEmpty(retypedPassword)){
            Toast.makeText(this, "please confirm password", Toast.LENGTH_LONG).show();
        }
        if(!retypedPassword.equals(password)){
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_LONG).show();
        }

        progressDialog.setMessage("Registering account...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                      if(task.isSuccessful()){
                          finish();
                          Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                          //pass in necessary information here.
                          startActivity(intent);
                      }else{
                          Toast.makeText(getApplicationContext(), "Registration not successful... try  Again", Toast.LENGTH_LONG).show();
                      }
                    }
                });
    }*/

    private void createAccount(){
        String method = "register";
        firstname = firstnameEdit.getText().toString().trim();
        surname = surnameEdit.getText().toString().trim();
        username = usernameEdit.getText().toString().trim();
        email = emailEdit.getText().toString().trim();
        password = passwordEdit.getText().toString().trim();
        retypedPassword = retypedPasswordEdit.getText().toString().trim();

        if(TextUtils.isEmpty(firstname)){
            Toast.makeText(this, "please enter your first name", Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(surname)){
            Toast.makeText(this, "please enter surname", Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(username)){
            Toast.makeText(this, "please enter username", Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "please enter email", Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "please enter password", Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(retypedPassword)){
            Toast.makeText(this, "please confirm password", Toast.LENGTH_LONG).show();
            return;
        }
        if(!retypedPassword.equals(password)){
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_LONG).show();
            return;
        }
        LoginActivity.BackgroundTask backgroundTask = new LoginActivity.BackgroundTask(this);
        backgroundTask.execute(method, firstname, surname, username, email, password);
        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);
        finish();

    }


    /*private void changeWidgetsFont(){
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("helvetica_font_normal.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }*/
}
