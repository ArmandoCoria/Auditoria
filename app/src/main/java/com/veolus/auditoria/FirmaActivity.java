package com.veolus.auditoria;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;

import com.github.gcacace.signaturepad.views.SignaturePad;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;


public class FirmaActivity extends Activity {

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private SignaturePad mSignaturePad;
    private Button mClearButton;
    private Button mSaveButton;
    private EditText nombre;

    private FirmaTask firmaTask = null;

    byte[] byteArray;

    private static final String URLGPS = "http://www.veolus.com/gps/";

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        verifyStoragePermissions(this);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.firmante);

        mSignaturePad = (SignaturePad) findViewById(R.id.signature_pad);
        mSignaturePad.setOnSignedListener(new SignaturePad.OnSignedListener() {
            @Override
            public void onStartSigning() {
                //Toast.makeText(FirmaActivity.this, "OnStartSigning", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSigned() {
                mSaveButton.setEnabled(true);
                mClearButton.setEnabled(true);

            }

            @Override
            public void onClear() {
                mSaveButton.setEnabled(false);
                mClearButton.setEnabled(false);

            }
        });

        mClearButton = (Button) findViewById(R.id.clear_button);
        mSaveButton = (Button) findViewById(R.id.save_button);


        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSignaturePad.clear();
                nombre.setText("");
            }
        });

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap signatureBitmap = mSignaturePad.getSignatureBitmap();

                if(nombre.getText().length() == 0)
                {
                    Toast.makeText(FirmaActivity.this, "Se requiere que el campo NOMBRE tenga dato", Toast.LENGTH_SHORT).show();
                }
                else if (!addJpgSignatureToGallery(signatureBitmap)) {
                    Toast.makeText(FirmaActivity.this, "Unable", Toast.LENGTH_SHORT).show();
                }
                else if (!addSvgSignatureToGallery(mSignaturePad.getSignatureSvg())) {
                    Toast.makeText(FirmaActivity.this, "Unable", Toast.LENGTH_SHORT).show();
                } else {

                }
            }
        });
    }

    public void onBackPressed(){

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_EXTERNAL_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length <= 0
                        || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(FirmaActivity.this, "Cannot write images to external storage", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public File getAlbumStorageDir(String albumName) {
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), albumName);
        if (!file.mkdirs()) {
            Log.e("SignaturePad", "Directory not created");
        }
        return file;
    }

    public void saveBitmapToJPG(Bitmap bitmap, File photo) throws IOException {
        Bitmap newBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(newBitmap);
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(bitmap, 0, 0, null);
        OutputStream stream = new FileOutputStream(photo);
        newBitmap.compress(Bitmap.CompressFormat.JPEG, 80, stream);
        stream.close();
    }

    public boolean addJpgSignatureToGallery(Bitmap signature) {
        boolean result = false;
        try {
            int firmaDe;
            String firmante = nombre.getText().toString();

            File photo = new File(getAlbumStorageDir("SignaturePad"), String.format("Signature_%d.jpg", System.currentTimeMillis()));
            saveBitmapToJPG(signature, photo);
            scanMediaFile(photo);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();

            signature.compress(Bitmap.CompressFormat.JPEG, 10, stream);

            byteArray = stream.toByteArray();
            //Log.e("Nota", Base64.encodeToString(byteArray, Base64.DEFAULT));

            Intent resultIntent = new Intent();
            Intent formIntent= getIntent();
            firmaDe= formIntent.getIntExtra("FirmaDE",2);
            if (firmaDe==0)
            {
                resultIntent.putExtra("NombreTec", firmante);
                resultIntent.putExtra("FirmaTEC", Base64.encodeToString(byteArray, Base64.DEFAULT));
                resultIntent.putExtra("FirmaRESP", "vacio");
            }
            else if(firmaDe==1)
            {
                resultIntent.putExtra("NombreResp", firmante);
                resultIntent.putExtra("FirmaTEC", "vacio");
                resultIntent.putExtra("FirmaRESP", Base64.encodeToString(byteArray, Base64.DEFAULT));

            } else if (firmante == "" && firmante == ""){
                Toast.makeText(this, "Se requiere que el campo NOMBRE tenga dato", Toast.LENGTH_SHORT).show();
            }

            setResult(Activity.RESULT_OK, resultIntent);
            finish();

            /*firmaTask= new FirmaTask(Base64.encodeToString(byteArray, Base64.DEFAULT));
            firmaTask.execute((Void)null);*/
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void scanMediaFile(File photo) {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri contentUri = Uri.fromFile(photo);
        mediaScanIntent.setData(contentUri);
        FirmaActivity.this.sendBroadcast(mediaScanIntent);
    }

    public boolean addSvgSignatureToGallery(String signatureSvg) {
        boolean result = false;
        try {
            File svgFile = new File(getAlbumStorageDir("SignaturePad"), String.format("Signature_%d.svg", System.currentTimeMillis()));
            OutputStream stream = new FileOutputStream(svgFile);
            OutputStreamWriter writer = new OutputStreamWriter(stream);
            writer.write(signatureSvg);
            writer.close();
            stream.flush();
            stream.close();
            scanMediaFile(svgFile);
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Checks if the app has permission to write to device storage
     * <p/>
     * If the app does not has permission then the user will be prompted to grant permissions
     *
     * @param activity the activity from which permissions are checked
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }


    public void onResumenClicked(View view)
    {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        Bundle extras = getIntent().getExtras();
        String[] errores={"Sitio: " + extras.getString("sitio"),
                "Atendido: " + extras.getString("secciones")};
        builder.setItems(errores, new DialogInterface.OnClickListener()
        {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        })
                .setTitle("Servicio de Mtto. Preventivo de " + extras.getString("equipoName") + " del mes "+ extras.getString("mes"))
                .setNegativeButton("Continuar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                })
                .show();
    }

    public class FirmaTask extends AsyncTask<Void, Void, Void>
    {
        String url = URLGPS + "Default.aspx/cargarReporte";
        String respuesta,image;
        JSONArray array= new JSONArray();

        public FirmaTask(String image)
        {
            this.image= image;
        }


        @Override
        protected Void doInBackground(Void... params) {
            URL destinoURL = null;
            try {

                destinoURL = new URL(url);
                HttpURLConnection con = (HttpURLConnection) destinoURL.openConnection();

                con.setDoOutput(true);
                con.setDoInput(true);
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type", "application/json");
                con.setRequestProperty("Accept", "application/json");

                con.setConnectTimeout(3000);
                con.setReadTimeout(3000);

                JSONObject posiciones = new JSONObject();
                posiciones.put("image", image);
                //Log.e("Nota", "antes del flush: ");
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(con.getOutputStream());
                outputStreamWriter.write(posiciones.toString());
                outputStreamWriter.flush();
                //Log.e("Nota", "despues del flush: ");

                StringBuilder sb = new StringBuilder();
                int HttpResult = con.getResponseCode();
                if (HttpResult == HttpURLConnection.HTTP_OK) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));

                    String line = null;
                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    br.close();
                    respuesta= sb.toString();
                    Log.e("Nota", "Este es el json que regresa el servidor: " + sb.toString()+"\n*******");
                    //success = true;

                } else {
                    Log.e("Nota", con.getResponseMessage());
                    Log.e("Nota", "error en asynctask getordenes");
                    //Log.e("NOTA", "latitud: " + NumEmpleadod);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("Nota", "tiempo excedido :P");
                respuesta="[]";
                //guardarParaReenviar((float)Latitud, (float)Longitud);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            String json = respuesta;

            Log.e("Nota", json);
        }

    }

}
