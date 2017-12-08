package com.example.konye.lingo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class LoginActivity extends AppCompatActivity {

    EditText editLoginEmail, editLoginPassword;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        changeWidgetsFont();
        /*firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null){
            finish();
            Intent intent = new Intent(getApplicationContext(),LanguageListActivity.class);
            startActivity(intent);
        }*/

        progressDialog = new ProgressDialog(this);
        //adding necessary widgets.
        editLoginEmail = (EditText) findViewById(R.id.login_email_editView);
        editLoginPassword = (EditText) findViewById(R.id.login_password_editView);
        Button loginButton = (Button) findViewById(R.id.login_button);
        TextView signUpTextView = (TextView) findViewById(R.id.sign_up_textVIew);

        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //getUserDetailsAndCheckEmptyAndRegisterUser();
                Intent intent = new Intent(getApplicationContext(), LandingPageActivity.class);
                startActivity(intent);
                finish();
            }
        });
        signUpTextView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    /*private void getUserDetailsAndCheckEmptyAndRegisterUser(){
        String email = editLoginEmail.getText().toString().trim();
        String password = editLoginPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "please enter email", Toast.LENGTH_LONG).show();
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "please enter password", Toast.LENGTH_LONG).show();
        }

        progressDialog.setMessage("Signing In...");
        progressDialog.show();

        /*firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            finish();
                            Intent intent = new Intent(getApplicationContext(),ChooseLanguageActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(getApplicationContext(), "Login not successful... try  Again", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }*/

    private void loginAccount(){
        String method = "login";
        String email = editLoginEmail.getText().toString().trim();
        String password = editLoginPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "please enter email", Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "please enter password", Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("Signing in");
        progressDialog.show();
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, email, password);
    }

    private void changeWidgetsFont(){
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("helvetica_font_normal.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
