package com.example.konye.lingo.ui.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.konye.lingo.R;
import com.google.firebase.auth.FirebaseAuth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

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
        editLoginEmail = findViewById(R.id.login_email_editView);
        editLoginPassword = findViewById(R.id.login_password_editView);
        Button loginButton = findViewById(R.id.login_button);
        TextView signUpTextView = findViewById(R.id.sign_up_textVIew);

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

    /**
     * Created by ALPHA AND JAM on 12/6/2017.
     */

    public static class BackgroundTask extends AsyncTask<String, Void, String> {
        Context context;
        String database_firstname;
        String database_surname;
        String database_username;
        String database_email;
        String database_password;
        String database_login_email;
        String database_login_password;
        String charsetUTF = "UTF-8";
        String charsetISO = "iso-8859-1";
        public boolean loginResult = false;

        BackgroundTask(Context context){
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String...params) {
            String reg_url = "";
            String login_url = "";
            String method = params[0];
            if(method.equals("register")){
                String firstname = params[1];
                String surname = params[2];
                String username = params[3];
                String email = params[4];
                String password = params[5];
                try {
                    URL url = new URL(reg_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, charsetUTF));
                    String data = URLEncoder.encode(database_firstname,charsetUTF)+"="+URLEncoder.encode(firstname,charsetUTF)+"&"+
                            URLEncoder.encode(database_surname,charsetUTF)+"="+URLEncoder.encode(surname,charsetUTF)+"&"+
                            URLEncoder.encode(database_username,charsetUTF)+"="+URLEncoder.encode(username,charsetUTF)+"&"+
                            URLEncoder.encode(database_email,charsetUTF)+"="+URLEncoder.encode(email,charsetUTF)+"&"+
                            URLEncoder.encode(database_password,charsetUTF)+"="+URLEncoder.encode(password,charsetUTF);
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    //create inputstream to receive info from the server
                    InputStream inputStream = httpURLConnection.getInputStream();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return "...Registration Successful";
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if(method.equals("login")){
                String email = params[1];
                String password = params[2];
                try {
                    URL url = new URL(login_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,charsetUTF));
                    String data = URLEncoder.encode(database_login_email,charsetUTF)+"="+URLEncoder.encode(email,charsetUTF)+"&"+
                            URLEncoder.encode(database_login_password,charsetUTF)+"="+URLEncoder.encode(password,charsetUTF);
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,charsetISO));
                    String response = "";
                    String line = "";
                    while((line = bufferedReader.readLine()) != null){
                        response += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return response;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            if(result == null){
                //do what you like here
                Toast.makeText(context,"Something went wrong", Toast.LENGTH_LONG).show();
            }else if(result.equals("...Registration Successful")){
                Toast.makeText(context, result, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, LoginActivity.class);
                context.startActivity(intent);
            }else if(result.contains("Login Successful")){
                Toast.makeText(context, result, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, LandingPageActivity.class);
                context.startActivity(intent);
            }
        }
    }
}
