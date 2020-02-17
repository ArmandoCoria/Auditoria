package com.veolus.auditoria;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;

public class logeo extends AppCompatActivity {

    public static final String USER_CRED = "UserCredencials";
    private static final String URL_GPS= "http://www.veolus.com/gps/";
    private static final int duration = Toast.LENGTH_LONG;

    //AsyncTask
    private UserLoginTask mAuthTask = null;
  //  private comprobarVersion cVersionTask= null;

    // UI references.
    private EditText mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private TextView version;

    //Determina si la aplicación esta actualizada
    boolean actualizado=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logeo2);

        verificarSesion();
        int versionCode= getVersionCode();
        //Verifica que se tenga instalada la ultima versión
        //Actualizado: Continua con la revision de permisos y revisión del estado de sesión
        //Desactualizado: Abre Play Store hasta que se actualice la app


        mEmailView = (EditText) findViewById(R.id.user);
        mPasswordView = (EditText) findViewById(R.id.password);
        mLoginFormView = findViewById(R.id.email_login_form);
        mProgressView = findViewById(R.id.login_progress);
        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);

        //Imprime el nombre de la version
        version= (TextView)findViewById(R.id.verscode);
        version.setText("Version code: "+ versionCode);

        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }

    public void onBackPressed(){

    }

    private int getVersionCode()
    {
        int verSionCode=0;

        try {
            PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            verSionCode= pInfo.versionCode;

        }
        catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return verSionCode;
    }

/*
    private class comprobarVersion extends AsyncTask<Void, Void, String>
    {

        String respuesta;


       @Override
        protected String doInBackground(Void... params) {
            try
            {

                URL urlLogin=new URL(URL_GPS + "Login.aspx/comprobarActualizacion");
                HttpURLConnection con = (HttpURLConnection) urlLogin.openConnection();
                con.setDoOutput(true);
                con.setDoInput(true);
                con.setRequestProperty("Content-Type", "application/json");
                con.setRequestProperty("Accept", "application/json");
                con.setRequestMethod("POST");
                con.setConnectTimeout(3000);
                con.setReadTimeout(3000);
                //JSON que vas enviar a la url


                //display what returns the POST request
                StringBuilder sb = new StringBuilder();
                int HttpResult = con.getResponseCode();
                if (HttpResult == HttpURLConnection.HTTP_OK) {
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(con.getInputStream(), "utf-8"));
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    br.close();


                } else {
                    System.out.println(con.getResponseMessage());
                    System.out.println(con.getResponseMessage());
                    System.out.println("algo anda mal :P");
                }
                respuesta= sb.toString();
                System.out.println("Este es el json que regresa el servidor: " + respuesta);
                return respuesta;

            }
            catch (MalformedURLException e) {

                e.printStackTrace();
            }
            catch (SocketTimeoutException e)
            {
                e.printStackTrace();
            }
            catch (UnknownHostException e)
            {
                e.printStackTrace();
            }
            catch (IOException e) {

                e.printStackTrace();
            }
            return null;
        }



        @Override
        protected void onPostExecute(String respuesta) {
            super.onPostExecute(respuesta);
            JSONObject obj;
            verificarSesion();
        }
    }
*/
    private void verificarSesion()
    {
        //Si existen credenciales de inicio de sesion entonces abrir la siguiente actividad
        SharedPreferences userCred = getSharedPreferences(USER_CRED, 0);
        if(userCred.getInt("IDUser",0)!=0)
        {
            Intent in = new Intent(getApplicationContext(), Formatos.class);
            startActivity(in);//tambien mandar cookie!!
        }
    }


    private void attemptLogin() {
        Context context = getApplicationContext();
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            /*mPasswordView.setError(getString(R.string.error_invalid_password));*/
            Toast toast = Toast.makeText(context, "Llena los campos faltantes", duration);
            toast.show();
            focusView = mEmailView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            /* mEmailView.setError(getString(R.string.error_field_required));*/
            Toast toast = Toast.makeText(context, "Ingresa un usuario", duration);
            toast.show();
            focusView = mEmailView;
            cancel = true;
        }
        if (TextUtils.isEmpty(password)) {
            /*mPasswordView.setError(getString(R.string.error_field_required));*/
            Toast toast = Toast.makeText(context, "Ingresa la contraseña", duration);
            toast.show();
            focusView = mPasswordView;
            cancel = true;
        }/*else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }*/

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            mAuthTask = new UserLoginTask(email, password);
            mAuthTask.execute((Void) null);
        }
    }

    private boolean isPasswordValid(String password) {

        return password.length() > 4;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    public class UserLoginTask extends AsyncTask<Void, Void, Integer> {

        String respuesta;
        StringBuilder builder = new StringBuilder();

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }



        @Override
        protected Integer doInBackground(Void... params) {



            try {

                URL urlLogin=new URL(URL_GPS + "Login.aspx/userLogin2");

                HttpURLConnection con = (HttpURLConnection) urlLogin.openConnection();
                con.setDoOutput(true);
                con.setDoInput(true);
                con.setRequestProperty("Content-Type", "application/json");
                con.setRequestProperty("Accept", "application/json");
                con.setRequestMethod("POST");
                con.setConnectTimeout(3000);
                con.setReadTimeout(3000);
                //JSON que vas enviar a la url
                JSONObject credenciales = new JSONObject();
                credenciales.put("user", mEmail);
                credenciales.put("pass", mPassword);

                OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
                wr.write(credenciales.toString());
                wr.flush();

                //display what returns the POST request
                StringBuilder sb = new StringBuilder();
                int HttpResult = con.getResponseCode();
                if (HttpResult == HttpURLConnection.HTTP_OK) {
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(con.getInputStream(), "utf-8"));
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    br.close();
                    respuesta= sb.toString();
                    System.out.println("Este es el json que regresa el servicor: " + respuesta);


                } else {
                    System.out.println(con.getResponseMessage());
                    System.out.println("algo anda mal :P");
                    System.out.println("email: "+ mEmail+ " pass: "+ mPassword);
                    return 2;

                }

            } /*catch (InterruptedException e) {
                return false;
            }*/
            catch (MalformedURLException e) {

                e.printStackTrace();
                return 2;
            }
            catch (JSONException e) {
                e.printStackTrace();
                return 2;
            }
            catch (SocketTimeoutException e)
            {
                e.printStackTrace();
                return 1;
            }
            catch (UnknownHostException e)
            {
                e.printStackTrace();
                return 1;
            }
            catch (IOException e) {

                e.printStackTrace();
                return 2;
            }



            return 0;
        }

        @Override
        protected void onPostExecute(final Integer success) {
            mAuthTask = null;
            showProgress(false);
            int idUsuario;

            Context context = getApplicationContext();

            if (success==0)
            {
                System.out.println("Algo anda bien :D ");
                System.out.println(builder);

                String json = respuesta;
                JSONObject obj;

                try {

                    obj = new JSONObject(json);
                    obj= obj.getJSONObject("d");

                    idUsuario= Integer.parseInt(obj.getString("id"));
                    if(idUsuario>0)
                    {
                        SharedPreferences settings = getSharedPreferences(USER_CRED, 0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putInt("IDUser", idUsuario);
                        editor.putString("Username", String.valueOf(obj.getString("Nombre")));
                        editor.putString("NoEmpleado",String.valueOf(obj.getString("no_Empleado")));
                        //correo

                        // Commit the edits!
                        editor.commit();
                        System.out.println("id en Login: " + idUsuario);

                        Intent in = new Intent(getApplicationContext(), Formatos.class);
                        startActivity(in);
                        finish();
                    }
                    else {
                        Toast toast = Toast.makeText(context, "Usuario o contraseña incorrectos", duration);
                        toast.show();
                        //mPasswordView.setError("Incorrecto");
                    }

                } catch (Throwable t) {
                    Log.e("Nota", "Could not parse malformed JSON: \"" + json + "\"");
                    t.printStackTrace();
                }


            } else if(success==1){
                Toast toast = Toast.makeText(context, "Comprueba tu conexión a Internet", duration);
                toast.show();
                //mPasswordView.setError(getString(R.string.error_incorrect_password));
                //mPasswordView.requestFocus();
            }

        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
            Toast toast = Toast.makeText(getApplicationContext(), "El servidor esta tardando en responder intentalo de nuevo", duration);
            toast.show();
        }
    }


}

