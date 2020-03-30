package com.veolus.auditoria;

import android.Manifest;
import android.app.Activity;
import android.app.Instrumentation;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;


import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class Fotos extends Activity {

    private final static String MY_PROVIDER = BuildConfig.APPLICATION_ID + ".providers.FileProvider";
    private final String CARPETA_RAIZ = "/ImagenesAuditoria";
    private final String RUTA_IMAGEN = CARPETA_RAIZ + "Veolus/";

    Button camara;
    ImageView foto;
    Context mcontext;
    private Button mSaveButton;

    private String mPath;

    String path;
    Bitmap bitmap;
    private static final int COD_SELECCIONA = 10;
    private static final int COD_FOTO = 20;
    private final int PHOTO_CODE = 200;
    private final int PICTURE_RESULT = 122;
    private final int REQUEST_IMAGE_CAPTURE = 10;
    private Uri imageUri;
    private ContentValues values;
    byte[] byteArray;

    private static final String URLGPS = "http://www.veolus.com/gps/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotos);

        mcontext=this;
        mSaveButton = (Button) findViewById(R.id.save_button);
        foto = (ImageView) findViewById(R.id.imagendelafoto);

        //PERMISO PARA MOSTRAR LAS IMAGENES DEL S.O MAYORES O IGUAL A ANDROID 6.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(!checkExternalStoragePermission()){
             return;
            }
        }

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Bitmap fileDecode =  bitmap;
                if (convertirImgString()) {
                    Toast.makeText(Fotos.this, "Imagen Guardada", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(Fotos.this, "Unable", Toast.LENGTH_SHORT).show();
                }
            }
        });

//BOTON EN DONDE MANDAS A LLAMAR LA CAMARA JUNTO CON EL METODO
        camara = (Button) findViewById(R.id.abrircamara);
        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               tomarfoto(); //METODO
              /* values = new ContentValues();
                values.put(MediaStore.Images.Media.TITLE, "MyPicture");
                values.put(MediaStore.Images.Media.DESCRIPTION, "Photo taken on " + System.currentTimeMillis());
                imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, PICTURE_RESULT);*/
            }
        });
    }

    //PERMISO PARA LEER EL ALMACENAMIENTO EXTERNO Y MOSTRAR EN IMAGEVIEW
    private boolean checkExternalStoragePermission() {
        int permissionCheck = ContextCompat.checkSelfPermission(
                this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Log.i("Mensaje", "No se tiene permiso parsa leer");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 225);
        } else {
            Log.i("Mesaje", "Se tiene permiso para leer");
            return true;
        }
        return false;
    }

    //METODO PARA TOMAR LA FOTO Y ALMACENARLA EN EL DISPOSITIVO
    private void tomarfoto() {
        final String dir = Environment.getExternalStorageDirectory() + RUTA_IMAGEN; //Abrir la imagen
        String nombre = (System.currentTimeMillis()/1000)+".jpg"; // Devuelve la hora actul en milesegundos junto con la extencion del archivo .jpg
        File newdir = new File(dir);
        boolean creado = newdir.mkdirs();

        path  = dir+nombre; //Ruta de almacenamiento mas el nombre

        File imagen = new File(path); // Crea el archivo
        try {
            imagen.createNewFile();
        }
        catch (IOException e)
        {
        }
        //     Uri outputFileUri = Uri.fromFile(newfile);
        Uri outputFileUri = FileProvider.getUriForFile(this, MY_PROVIDER, imagen);

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //Activar la opcion de camara
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri); // Enviar la imagen como parametro y almacenarla
        startActivityForResult(cameraIntent, COD_FOTO); // Toma la foto
        mSaveButton.setEnabled(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case COD_FOTO:
                    try {
                        MediaScannerConnection.scanFile(this, new String[]{path}, null,
                                new MediaScannerConnection.OnScanCompletedListener() {
                                    @Override
                                    public void onScanCompleted(String path, Uri uri) {
                                    }
                                });
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        bitmap = BitmapFactory.decodeFile(path, options);
                        int h = (int) Math.ceil(options.outHeight / (float) 1000);
                        int w = (int) Math.ceil(options.outWidth / (float) 1000);

                        if (h > 1 || w > 1) {
                            if (h > w) {
                                options.inSampleSize = h;

                            } else {
                                options.inSampleSize = w;
                            }
                        }
                        options.inJustDecodeBounds = false;
                        bitmap = BitmapFactory.decodeFile(path, options);
                        foto.setImageBitmap(bitmap);
                        mSaveButton.setEnabled(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        }

    }

        public String getRealPathFromURI(Uri contentUri) {
            String[] proj = { MediaStore.Images.Media.DATA };
            Cursor cursor = managedQuery(contentUri, proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }

        public boolean convertirImgString (){
            boolean result = false;
            try {
                int camera;
                String numFoto = "";
                int zona= 0;
                Intent resultIntent = new Intent();
                Intent formIntent = getIntent();
                numFoto = formIntent.getStringExtra("numFoto");
                zona = formIntent.getIntExtra("flgZona", 0);
                camera = formIntent.getIntExtra("Camera", 5);
                resultIntent.putExtra("numFoto", numFoto);
                resultIntent.putExtra("flgZona", zona);
                if (camera == 0) {
                    resultIntent.putExtra("FotoUno", path);
                    resultIntent.putExtra("FotoDos", "vacio");
                    resultIntent.putExtra("FotoTres", "vacio");
                    resultIntent.putExtra("FotoCuatro", "vacio");
                    resultIntent.putExtra("FotoCnco", "vacio");
                    resultIntent.putExtra("FotoSeis", "vacio");
                    resultIntent.putExtra("FotoSite", "vacio");
                    resultIntent.putExtra("FotoOcho", "vacio" );
                    resultIntent.putExtra("FotoNueve", "vacio" );
                    resultIntent.putExtra("FotoDiez", "vacio");
                } else if (camera == 1) {
                    resultIntent.putExtra("FotoUno", "vacio");
                    resultIntent.putExtra("FotoDos", path);
                    resultIntent.putExtra("FotoTres", "vacio");
                    resultIntent.putExtra("FotoCuatro", "vacio");
                    resultIntent.putExtra("FotoCnco", "vacio");
                    resultIntent.putExtra("FotoSeis", "vacio");
                    resultIntent.putExtra("FotoSite", "vacio");
                    resultIntent.putExtra("FotoOcho", "vacio" );
                    resultIntent.putExtra("FotoNueve", "vacio" );
                    resultIntent.putExtra("FotoDiez", "vacio");
                } else if (camera == 2) {
                    resultIntent.putExtra("FotoUno", "vacio");
                    resultIntent.putExtra("FotoDos", "vacio");
                    resultIntent.putExtra("FotoTres", path);
                    resultIntent.putExtra("FotoCuatro", "vacio");
                    resultIntent.putExtra("FotoCnco", "vacio");
                    resultIntent.putExtra("FotoSeis", "vacio");
                    resultIntent.putExtra("FotoSite", "vacio" );
                    resultIntent.putExtra("FotoOcho", "vacio" );
                    resultIntent.putExtra("FotoNueve", "vacio" );
                    resultIntent.putExtra("FotoDiez", "vacio");
                } else if (camera == 3) {
                    resultIntent.putExtra("FotoUno", "vacio");
                    resultIntent.putExtra("FotoDos", "vacio");
                    resultIntent.putExtra("FotoTres", "vacio");
                    resultIntent.putExtra("FotoCuatro", path);
                    resultIntent.putExtra("FotoCnco", "vacio");
                    resultIntent.putExtra("FotoSeis", "vacio");
                    resultIntent.putExtra("FotoSite", "vacio");
                    resultIntent.putExtra("FotoOcho", "vacio" );
                    resultIntent.putExtra("FotoNueve", "vacio" );
                    resultIntent.putExtra("FotoDiez", "vacio");
                } else if (camera == 4) {
                    resultIntent.putExtra("FotoUno", "vacio");
                    resultIntent.putExtra("FotoDos", "vacio");
                    resultIntent.putExtra("FotoTres", "vacio");
                    resultIntent.putExtra("FotoCuatro", "vacio");
                    resultIntent.putExtra("FotoCnco", path);
                    resultIntent.putExtra("FotoSeis", "vacio");
                    resultIntent.putExtra("FotoSite", "vacio");
                    resultIntent.putExtra("FotoOcho", "vacio" );
                    resultIntent.putExtra("FotoNueve", "vacio" );
                    resultIntent.putExtra("FotoDiez", "vacio");
                } else if (camera == 5) {
                    resultIntent.putExtra("FotoUno", "vacio");
                    resultIntent.putExtra("FotoDos", "vacio");
                    resultIntent.putExtra("FotoTres", "vacio");
                    resultIntent.putExtra("FotoCuatro", "vacio");
                    resultIntent.putExtra("FotoCnco", "vacio");
                    resultIntent.putExtra("FotoSeis", path);
                    resultIntent.putExtra("FotoSite", "vacio");
                    resultIntent.putExtra("FotoOcho", "vacio" );
                    resultIntent.putExtra("FotoNueve", "vacio" );
                    resultIntent.putExtra("FotoDiez", "vacio");
                } else if (camera == 6) {
                    resultIntent.putExtra("FotoUno", "vacio");
                    resultIntent.putExtra("FotoDos", "vacio");
                    resultIntent.putExtra("FotoTres", "vacio");
                    resultIntent.putExtra("FotoCuatro", "vacio");
                    resultIntent.putExtra("FotoCnco", "vacio");
                    resultIntent.putExtra("FotoSeis", "vacio" );
                    resultIntent.putExtra("FotoSite", path );
                    resultIntent.putExtra("FotoOcho", "vacio" );
                    resultIntent.putExtra("FotoNueve", "vacio" );
                    resultIntent.putExtra("FotoDiez", "vacio");
                } else if (camera == 7) {
                    resultIntent.putExtra("FotoUno", "vacio");
                    resultIntent.putExtra("FotoDos", "vacio");
                    resultIntent.putExtra("FotoTres", "vacio");
                    resultIntent.putExtra("FotoCuatro", "vacio");
                    resultIntent.putExtra("FotoCnco", "vacio");
                    resultIntent.putExtra("FotoSeis", "vacio" );
                    resultIntent.putExtra("FotoSite", "vacio");
                    resultIntent.putExtra("FotoOcho", path );
                    resultIntent.putExtra("FotoNueve", "vacio" );
                    resultIntent.putExtra("FotoDiez", "vacio");
                } else if (camera == 8) {
                    resultIntent.putExtra("FotoUno", "vacio");
                    resultIntent.putExtra("FotoDos", "vacio");
                    resultIntent.putExtra("FotoTres", "vacio");
                    resultIntent.putExtra("FotoCuatro", "vacio");
                    resultIntent.putExtra("FotoCnco", "vacio");
                    resultIntent.putExtra("FotoSeis", "vacio" );
                    resultIntent.putExtra("FotoSite", "vacio");
                    resultIntent.putExtra("FotoOcho", "vacio" );
                    resultIntent.putExtra("FotoNueve", path );
                    resultIntent.putExtra("FotoDiez", "vacio");
                } else if (camera == 9) {
                    resultIntent.putExtra("FotoUno", "vacio");
                    resultIntent.putExtra("FotoDos", "vacio");
                    resultIntent.putExtra("FotoTres", "vacio");
                    resultIntent.putExtra("FotoCuatro", "vacio");
                    resultIntent.putExtra("FotoCnco", "vacio");
                    resultIntent.putExtra("FotoSeis", "vacio" );
                    resultIntent.putExtra("FotoSite", "vacio");
                    resultIntent.putExtra("FotoOcho", "vacio" );
                    resultIntent.putExtra("FotoNueve", "vacio" );
                    resultIntent.putExtra("FotoDiez", path);
                }



                setResult(RESULT_OK, resultIntent);
                result = true;
                finish();
            } catch (Exception e) {
                e.getMessage();
            }
            return result;
        }

        public class ImagenTask extends AsyncTask<Void, Void, Void> {
            String url = URLGPS + "Default.aspx/cargarReporte";
            String respuesta, image;
            JSONArray array = new JSONArray();

            public ImagenTask(String image) {
                this.image = image;
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
                        respuesta = sb.toString();
                      //  Log.e("Nota", "Este es el json que regresa el servicor: " + sb.toString() + "\n*******");
                        //success = true;

                    } else {
                      //  Log.e("Nota", con.getResponseMessage());
                     //   Log.e("Nota", "error en asynctask getordenes");
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
                 //   Log.e("Nota", "tiempo excedido :P");
                    respuesta = "[]";
                    //guardarParaReenviar((float)Latitud, (float)Longitud);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                String json = respuesta;
           //     Log.e("Nota", json);
            }
        }
}

