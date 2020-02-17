package com.veolus.auditoria;

import android.annotation.TargetApi;
import android.app.Activity;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.icu.text.SimpleDateFormat;
import android.icu.util.TimeZone;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;

import net.sourceforge.jtds.jdbc.DateTime;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class informe_tecnico extends Activity {
    public static final String USER_CRED = "UserCredencials";
    public static String id = "";
    private String idUSer;


    private EditText etDireccion_Sitio;
    private EditText etReparacion;
    private EditText etRecomendaciones;
    private EditText etAntecedentes;
    private EditText etDesarrollo;
    private EditText etConclusiones;

    private RadioGroup radioEquiGroup;
    private RadioButton radioEquiButton;

    private RadioButton escalera;
    private RadioButton elevador;
    private RadioButton rampa_acera;
    private RadioButton salvaescalera;
    private RadioButton otros;
    private EditText etOtros;
    TextView texto;

    private Button btnEnviar;
    private Button btnFirmaTec;
    private Button btnFirmaResp;

    private Button btncamara1;
    private Button btncamara2;
    private Button btncamara3;
    private Button btncamara4;
    private Button btncamara5;
    private Button btncamara6;

    Bitmap bitmap;
    byte[] byteArray;
    String imagenString;

    private taskFormularioITLibre miTaskFormularioITLibre = null;
    private static final String URLGPS = "http://www.veolus.com/gps/";
    OutputStreamWriter archivo = null;
    private int equipo = -1;

    private String firmaTec = "";
    private String firmaResp = "";
    private String firmanteTec = "";
    private String firmanteResp = "";
    private String fotouno = "";
    private String fotodos = "";
    private String fototres = "";
    private String fotocuatro = "";
    private String fotocinco = "";
    private String fotoseis = "";
    private Context mContext;
    private LinearLayout oe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informe_tecnico_auditoria);
        mContext = this;

        Thread t = new Thread() {
            public void run() {
                while (!isInterrupted()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runOnUiThread(new Runnable() {
                        @TargetApi(Build.VERSION_CODES.N)
                        @RequiresApi(api = Build.VERSION_CODES.N)
                        @Override
                        public void run() {
                            TextView tdate = (TextView) findViewById(R.id.fechain);
                            long date = System.currentTimeMillis();
                            SimpleDateFormat adf = null;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                adf = new SimpleDateFormat("MMMM dd/yyyy");
                            }
                            String dateString = adf.format(date);
                            tdate.setText(dateString);
                        }
                    });
                }
            }
        };
        t.start();

        mContext = this;
        SharedPreferences userCred = getSharedPreferences(USER_CRED, 0);
        idUSer = String.valueOf(userCred.getInt("IDUser", 0));
        oe = (LinearLayout) findViewById(R.id.OE);
        etDireccion_Sitio = (EditText) findViewById(R.id.direccionSitio);
        etReparacion = (EditText) findViewById(R.id.reparacion);
        etAntecedentes = (EditText) findViewById(R.id.antecedentes);
        etDesarrollo = (EditText) findViewById(R.id.desarrollo);
        etRecomendaciones = (EditText) findViewById(R.id.recomendaciones);
        etConclusiones = (EditText) findViewById(R.id.conclusiones);

        escalera = (RadioButton) findViewById(R.id.escalera);
        elevador = (RadioButton) findViewById(R.id.elevador);
        rampa_acera = (RadioButton) findViewById(R.id.rampa_acera);
        salvaescalera = (RadioButton) findViewById(R.id.salvaescalera);
        otros = (RadioButton) findViewById(R.id.otro);
        etOtros = (EditText) findViewById(R.id.otroequipo);

        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                enviarFormulario();
                btnEnviar.setEnabled(false);
            }
        });

        otros = (RadioButton) findViewById(R.id.otro);
        otros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oe.getVisibility() == View.VISIBLE) {
                    oe.setVisibility(View.GONE);
                   // texto.setTextColor(Color.GRAY);
                }else{
                    oe.setVisibility(View.VISIBLE);
                }
            }
        });


        btnFirmaTec = (Button) findViewById(R.id.btnFirmaTec);
        btnFirmaTec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), FirmaActivity.class);
                //0 para regresar firma del responsable de sitio y 1 para regresar firmadel tecnico
                in.putExtra("FirmaDE", 0);
                startActivityForResult(in, 1);
               // btnFirmaTec.setEnabled(false);
            }
        });

        btnFirmaResp = (Button) findViewById(R.id.btnFirmaResp);
        btnFirmaResp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), FirmaActivity.class);
                in.putExtra("FirmaDE", 1);
                startActivityForResult(in, 1);
                //btnFirmaResp.setEnabled(false);
            }
        });

        btncamara1 = (Button) findViewById(R.id.btnopencamara);
        btncamara1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                startActivityForResult(in, 1);
            }
        });

        btncamara2 = (Button) findViewById(R.id.btnopencamara2);
        btncamara2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                startActivityForResult(in, 1);
            }
        });

        btncamara3 = (Button) findViewById(R.id.btnopencamara3);
        btncamara3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                startActivityForResult(in, 1);
            }
        });

        btncamara4 = (Button) findViewById(R.id.btnopencamara4);
        btncamara4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                startActivityForResult(in, 1);
            }
        });

        btncamara5 = (Button) findViewById(R.id.btnopencamara5);
        btncamara5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                startActivityForResult(in, 1);
            }
        });

        btncamara6 = (Button) findViewById(R.id.btnopencamara6);
        btncamara6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 5);
                startActivityForResult(in, 1);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }

    private BroadcastReceiver networkStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo ni = manager.getActiveNetworkInfo();
            onNetworkChange(ni);
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            registerReceiver(networkStateReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onPause() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            unregisterReceiver(networkStateReceiver);
        }
        super.onPause();
    }

    private void onNetworkChange(NetworkInfo networkInfo) {
        if (networkInfo != null) {
            if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                Log.d("informe_tecnico", "CONNECTED");
            } else {
                Log.d("informe_tecnico", "DISCONNECTED");
            }
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            if ("vacio".equals(data.getStringExtra("FirmaRESP"))) {
                firmaTec = data.getStringExtra("FirmaTEC");
                firmanteTec = data.getStringExtra("NombreTec");
                btnFirmaTec.setEnabled(false);
            } else if ("vacio".equals(data.getStringExtra("FirmaTEC"))) {
                firmaResp = data.getStringExtra("FirmaRESP");
                firmanteResp = data.getStringExtra("NombreResp");
                btnFirmaResp.setEnabled(false);
            }

            if ("vacio".equals(data.getStringExtra("FotoDos")) && "vacio".equals(data.getStringExtra("FotoTres"))
                    && "vacio".equals(data.getStringExtra("FotoCuatro")) && "vacio".equals(data.getStringExtra("FotoCnco"))
                    && "vacio".equals(data.getStringExtra("FotoSeis"))) {
                bitmap = BitmapFactory.decodeFile(data.getStringExtra("FotoUno"));
                ByteArrayOutputStream array = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,  10, array);
                byteArray = array.toByteArray();
                imagenString = Base64.encodeToString(byteArray, Base64.DEFAULT);
                fotouno = imagenString;
                btncamara1.setEnabled(false);

            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoTres"))
                    && "vacio".equals(data.getStringExtra("FotoCuatro")) && "vacio".equals(data.getStringExtra("FotoCnco"))
                    && "vacio".equals(data.getStringExtra("FotoSeis"))) {
                bitmap = BitmapFactory.decodeFile(data.getStringExtra("FotoDos"));
                ByteArrayOutputStream array = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,  10, array);
                byteArray = array.toByteArray();
                imagenString = Base64.encodeToString(byteArray, Base64.DEFAULT);
                fotodos = imagenString;
                btncamara2.setEnabled(false);

            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoDos"))
                    && "vacio".equals(data.getStringExtra("FotoCuatro")) && "vacio".equals(data.getStringExtra("FotoCnco"))
                    && "vacio".equals(data.getStringExtra("FotoSeis"))) {
                bitmap = BitmapFactory.decodeFile(data.getStringExtra("FotoTres"));
                ByteArrayOutputStream array = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,  10, array);
                byteArray = array.toByteArray();
                imagenString = Base64.encodeToString(byteArray, Base64.DEFAULT);
                fototres = imagenString;
                btncamara3.setEnabled(false);

            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoDos"))
                    && "vacio".equals(data.getStringExtra("FotoTres")) && "vacio".equals(data.getStringExtra("FotoCnco"))
                    && "vacio".equals(data.getStringExtra("FotoSeis"))) {
                bitmap = BitmapFactory.decodeFile(data.getStringExtra("FotoCuatro"));
                ByteArrayOutputStream array = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,  10, array);
                byteArray = array.toByteArray();
                imagenString = Base64.encodeToString(byteArray, Base64.DEFAULT);
                fotocuatro = imagenString;
                btncamara4.setEnabled(false);

            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoDos"))
                    && "vacio".equals(data.getStringExtra("FotoTres")) && "vacio".equals(data.getStringExtra("FotoCuatro"))
                    && "vacio".equals(data.getStringExtra("FotoSeis"))) {
                bitmap = BitmapFactory.decodeFile(data.getStringExtra("FotoCnco"));
                ByteArrayOutputStream array = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,  10, array);
                byteArray = array.toByteArray();
                imagenString = Base64.encodeToString(byteArray, Base64.DEFAULT);
                fotocinco = imagenString;
                btncamara5.setEnabled(false);

            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoDos"))
                    && "vacio".equals(data.getStringExtra("FotoTres")) && "vacio".equals(data.getStringExtra("FotoCuatro"))
                    && "vacio".equals(data.getStringExtra("FotoCnco"))) {
                bitmap = BitmapFactory.decodeFile(data.getStringExtra("FotoSeis"));
                ByteArrayOutputStream array = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,  10, array);
                byteArray = array.toByteArray();
                imagenString = Base64.encodeToString(byteArray, Base64.DEFAULT);
                fotoseis = imagenString;
                btncamara6.setEnabled(false);

            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void enviarFormulario() {
        //Valida formulario, tomar en cuanta el tamaño maximo de los campos en la base de datos
        getRadios();
        if (equipo == -1) {
            Toast.makeText(this, "Hay campos sin llenar, el formulario no se envio", Toast.LENGTH_SHORT).show();
        } else if (fotouno.equals("")) {
            Toast.makeText(this, "Se requiere de la Foto Uno como evidencia, obligatoria", Toast.LENGTH_SHORT).show();
        }else if (fotodos.equals("")) {
            Toast.makeText(this, "Se requiere de la Foto Dos como evidencia, obligatoria", Toast.LENGTH_SHORT).show();
        } else if (fototres.equals("")) {
            Toast.makeText(this, "Se requiere de la Foto Tres como evidencia, obligatoria", Toast.LENGTH_SHORT).show();
        }else if (fotocuatro.equals("")) {
            Toast.makeText(this, "Se requiere de la Foto Cuatro como evidencia, obligatoria", Toast.LENGTH_SHORT).show();
        }else if (fotocinco.equals("")) {
            Toast.makeText(this, "Se requiere de la Foto Cinco como evidencia, obligatoria", Toast.LENGTH_SHORT).show();
        }else if (fotoseis.equals("")) {
            Toast.makeText(this, "Se requiere de la Foto Seis como evidencia, obligatoria", Toast.LENGTH_SHORT).show();
        }else if (firmaTec.equals("") && firmaResp.equals("")) {
            Toast.makeText(this, "Se requieren las Firmas, el formulario no se envío ", Toast.LENGTH_SHORT).show();
        }else if (firmaTec.equals("")) {
            Toast.makeText(this, "Se requiere de la Firma Técnico como evidencia, obligatoria", Toast.LENGTH_SHORT).show();
        }else if (firmaResp.equals("")) {
            Toast.makeText(this, "Se requiere de la Firma Responsable como evidencia, obligatoria", Toast.LENGTH_SHORT).show();
        } else {
            btnEnviar.setEnabled(false);
            Bundle extras = getIntent().getExtras();
            Toast.makeText(this, "Enviando Formulario", Toast.LENGTH_SHORT).show();
            Gson gsonFrom = new Gson();
            StoreFormIT miForm = new StoreFormIT();
            id = getCurrentTime();
            miForm.setId(id);
            miForm.setIdUser(idUSer);
            miForm.setDireccion(etDireccion_Sitio.getText().toString());
            miForm.setAntecedentes(etAntecedentes.getText().toString());
            miForm.setReparaciones(etReparacion.getText().toString());
            miForm.setDesarrollo(etDesarrollo.getText().toString());
            miForm.setRecomendaciones(etRecomendaciones.getText().toString());
            miForm.setConclusiones(etConclusiones.getText().toString());
            miForm.setEquipo(equipo);
            miForm.setOtros(etOtros.getText().toString());
            miForm.setFirmaTec(firmaTec);
            miForm.setFirmaResp(firmaResp);
            miForm.setFirmanteTec(firmanteTec);
            miForm.setFirmanteResp(firmanteResp);
            miForm.setFotouno(fotouno);
            miForm.setFotodos(fotodos);
            miForm.setFototres(fototres);
            miForm.setFotocuatro(fotocuatro);
            miForm.setFotocnco(fotocinco);
            miForm.setFotoseis(fotoseis);
            //miForm.setNumeroOrden(extras.getString("numOrden"));
            //miForm.setSitio(extras.getString("sitio"));

            //   Log.e("Nota", gsonFrom.toJson(miForm));
            try {
                miTaskFormularioITLibre = new taskFormularioITLibre(gsonFrom.toJson(miForm));
                Toast.makeText(this, "Procesando solicitud", Toast.LENGTH_LONG).show();
                miTaskFormularioITLibre.execute((Void) null);
            } catch (Exception e) {
                e.getMessage();
            }

            //Enviar formulario para ser guardado y segun sea el caso tambien se envia por email
            //Si no hay conexion a internet es necesario guardar el formulario para despues enviarlo
        }
    }

    public void getRadios() {
        radioEquiGroup = (RadioGroup) findViewById(R.id.radioGroupEquipo);
        radioEquiButton = (RadioButton) findViewById(radioEquiGroup.getCheckedRadioButtonId());
        String miRadioText;
        try {
            miRadioText = radioEquiButton.getText().toString();
            switch (miRadioText) {
                case "Escalera":
                    equipo = 0;
                    break;
                case "Elevador":
                    equipo = 1;
                    break;
                case "Rampa/Acera":
                    equipo = 2;
                    break;
                case "Salvaescalera":
                    equipo = 3;
                    break;
                case "Otros":
                    equipo = 4;
                    break;
            }

            Log.e("IdEquipo", equipo + "");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void getEquipo(int radio){
        try {
            switch (radio){
                case 0:
                    escalera.setChecked(true);
                    break;
                case 1:
                    elevador.setChecked(true);
                    break;
                case 2:
                    rampa_acera.setChecked(true);
                    break;
                case 3:
                    salvaescalera.setChecked(true);
                    break;
                case 4:
                    otros.setChecked(true);
                    break;
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public void borrarif(View v) {

        MyOpenHelper dbHelper = new MyOpenHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("DELETE FROM IFSQL");
        Toast.makeText(this, "Los datos se han borrado", Toast.LENGTH_SHORT).show();
    }

    public void grabar(View v) {
        getRadios();
        MyOpenHelper dbHelper = new MyOpenHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if (db != null){
            ContentValues cv = new ContentValues();
            cv. put("Sitio", etDireccion_Sitio.getText().toString());
            cv. put("Reparacion", etReparacion.getText().toString());
            cv. put("Antecedentes", etAntecedentes.getText().toString());
            cv. put("Desarrollo", etDesarrollo.getText().toString());
            cv. put("Recomendaciones", etRecomendaciones.getText().toString());
            cv. put("Conclusiones", etConclusiones.getText().toString());
            cv.put("Radio",equipo);
            cv. put("Otros", etOtros.getText().toString());
            cv.put("Imagen1", fotouno);
            cv.put("Imagen2", fotodos);
            cv.put("Imagen3", fototres);
            cv.put("Imagen4", fotocuatro);
            cv.put("Imagen5", fotocinco);
            cv.put("Imagen6", fotoseis);
            cv.put("FirmaTec", firmaTec);
            cv.put("Firmante", firmanteTec);
            cv.put("FirmaRes", firmaResp);
            cv.put("Firmanres", firmanteResp);


            db.insert("IFSQL", null, cv);

            Toast.makeText(this, "Los datos fueron grabados", Toast.LENGTH_SHORT).show();
        }
    }

    public void recuperar(View v) throws UnsupportedEncodingException {
        try {
            MyOpenHelper dbHelper = new MyOpenHelper(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            Cursor c = db.rawQuery("SELECT _id, Sitio, Reparacion, Antecedentes, Desarrollo,  Recomendaciones, " +
                    "Conclusiones, Radio, Otros, Imagen1, Imagen2, Imagen3, Imagen4, Imagen5, Imagen6, FirmaTec, Firmante, FirmaRes, Firmanres FROM IFSQL", null);
            if (c.getCount() != 0 ) {
                c.moveToFirst();
                do {
                    String Sitio = c.getString(c.getColumnIndex("Sitio"));
                    String Reparacion = c.getString(c.getColumnIndex("Reparacion"));
                    String Recomendaciones = c.getString(c.getColumnIndex("Recomendaciones"));
                    String Antecedentes = c.getString(c.getColumnIndex("Antecedentes"));
                    String Desarrollo = c.getString(c.getColumnIndex("Desarrollo"));
                    String Conclusiones = c.getString(c.getColumnIndex("Conclusiones"));
                    int Radio = c.getInt(c.getColumnIndex("Radio"));
                    String Otros = c.getString(c.getColumnIndex("Otros"));
                    String Imagen1 = c.getString(c.getColumnIndex("Imagen1"));
                    String Imagen2 = c.getString(c.getColumnIndex("Imagen2"));
                    String Imagen3 = c.getString(c.getColumnIndex("Imagen3"));
                    String Imagen4 = c.getString(c.getColumnIndex("Imagen4"));
                    String Imagen5 = c.getString(c.getColumnIndex("Imagen5"));
                    String Imagen6 = c.getString(c.getColumnIndex("Imagen6"));
                    String FirmaTec = c.getString(c.getColumnIndex("FirmaTec"));
                    String Firmante = c.getString(c.getColumnIndex("Firmante"));
                    String FirmaRes = c.getString(c.getColumnIndex("FirmaRes"));
                    String Firmanres = c.getString(c.getColumnIndex("Firmanres"));

                    etDireccion_Sitio.setText(Sitio);
                    etReparacion.setText(Reparacion);
                    etRecomendaciones.setText(Recomendaciones);
                    etAntecedentes.setText(Antecedentes);
                    etDesarrollo.setText(Desarrollo);
                    etConclusiones.setText(Conclusiones);
                    getEquipo(Radio);
                    etOtros.setText(Otros);
                    fotouno = Imagen1;
                    fotodos = Imagen2;
                    fototres = Imagen3;
                    fotocuatro = Imagen4;
                    fotocinco = Imagen5;
                    fotoseis = Imagen6;
                    firmaTec = FirmaTec;
                    firmanteTec = Firmante;
                    firmaResp = FirmaRes;
                    firmanteResp = Firmanres;

                    if (!fotouno.equals("")) {
                        btncamara1.setEnabled(false);
                    }

                    if (!fotodos.equals("")) {
                        btncamara2.setEnabled(false);
                    }

                    if (!fototres.equals("")) {
                        btncamara3.setEnabled(false);
                    }

                    if (!fotocuatro.equals("")) {
                        btncamara4.setEnabled(false);
                    }

                    if (!fotocinco.equals("")) {
                        btncamara5.setEnabled(false);
                    }

                    if (!fotoseis.equals("")) {
                        btncamara6.setEnabled(false);
                    }

                    if (!firmaTec.equals("")) {
                        btnFirmaTec.setEnabled(false);
                    }

                    if (!firmanteTec.equals("")) {

                    }

                    if (!firmaResp.equals("")) {
                        btnFirmaResp.setEnabled(false);
                    }

                    if (!firmanteResp.equals("")) {

                    }

                } while (c.moveToNext());
            }else {
                Toast.makeText(this, "No hay datos para recuperar", Toast.LENGTH_SHORT).show();
            }
            c.close();
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class taskFormularioITLibre extends AsyncTask<Void, Void, Boolean> {
            private String formualrio;
            private String respuesta = "{'d':''}";
            String url = URLGPS + "EnvioFormITAuditoria.aspx/GuardarFormIT";
            MyOpenHelper dbHelper = new MyOpenHelper(mContext);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            public taskFormularioITLibre(String formualrio) {
                this.formualrio = formualrio;
            }

            @Override
            protected Boolean doInBackground(Void... voids) {
                URL destinoURL = null;
                try {
                    destinoURL = new URL(url);
                    HttpURLConnection con = (HttpURLConnection) destinoURL.openConnection();

                    con.setDoOutput(true);
                    con.setDoInput(true);
                    con.setRequestMethod("POST");
                    con.setRequestProperty("Content-Type", "application/json");
                    con.setRequestProperty("Accept", "application/json");

                    con.setConnectTimeout(15000);
                    con.setReadTimeout(15000);

                    formualrio = "{\"fAFIT\":" + formualrio + "}";
                    Log.e("Nota", formualrio);

                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(con.getOutputStream());
                    outputStreamWriter.write(formualrio);
                    outputStreamWriter.flush();

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
                        Log.e("Nota", "Este es el json que regresa el servidor: " + sb.toString() + "\n*******");

                        return true;

                    } else {
                        Gson gsonFrom = new Gson();
                        Log.e("Nota", con.getResponseMessage());
                        //Log.e("Nota", gsonFrom.toJson(con));
                        //Log.e("Nota", con.get);
                        Log.e("Nota", "algo anda mal :P  EnvioFormIT.aspx/guardarFormIT");

                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return false;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
                try {
                    JSONObject JSON = new JSONObject(respuesta);
                    if (JSON.getString("d").equals("Formulario guardado y enviado por correo.")) {
                        alertDialog.setTitle("Hecho");
                        alertDialog.setMessage("Formulario guardado y enviado por correo.");
                        alertDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent detail = new Intent(mContext, Formatos.class);
                                startActivity(detail);
                                db.execSQL("DELETE FROM IFSQL");
                            }
                        });

                        //Toast.makeText(getApplicationContext(), "Reporte enviado exitósamente..", Toast.LENGTH_SHORT).show();
                    } else if (JSON.getString("d").equals("Error al guardar")) {
                        alertDialog.setTitle("Error");
                        alertDialog.setMessage("El reporte no se pudo enviar a los destinatarios.");
                        alertDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        //Toast.makeText(getApplicationContext(), "Reporte enviado exitósamente..", Toast.LENGTH_SHORT).show();
                    } else {
                        alertDialog.setTitle("Error");
                        alertDialog.setMessage("El reporte no se pudo enviar por que no tiene conexión a internet. "+JSON.getString("d"));
                        alertDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        btnEnviar.setEnabled(true);
                    }
                    alertDialog.setCancelable(false);
                    AlertDialog result = alertDialog.create();
                    result.show();
                } catch (JSONException je) {
                    je.printStackTrace();
                }

                //Log.e("Nota", "algo anda mal :P post execute");
            }
        }
}