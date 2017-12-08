package com.example.konye.lingo;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

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
import java.nio.Buffer;

/**
 * Created by ALPHA AND JAM on 12/6/2017.
 */

public class BackgroundTask extends AsyncTask<String, Void, String> {
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
