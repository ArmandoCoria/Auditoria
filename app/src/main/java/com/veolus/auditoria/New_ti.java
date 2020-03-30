package com.veolus.auditoria;

import androidx.annotation.RequiresApi;

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
import android.icu.text.SimpleDateFormat;
import android.icu.util.TimeZone;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class New_ti extends Activity {

    public static final String USER_CRED = "UserCredencials";
    public static String id = "";
    private String idUSer;

    // sqlite
    MyOpenHelper dbHelper;
    SQLiteDatabase db;


    Bitmap bitmap;
    byte[] byteArray;
    String imagenString;

    private informe_tecnico.taskFormularioITLibre miTaskFormularioITLibre = null;
    private static final String URLGPS = "http://www.veolus.com/gps/";
    OutputStreamWriter archivo = null;
    private int asunto = -1;

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
    private String fotosiete = "";
    private String fotoocho = "";
    private String fotonueve = "";
    private String fotodiez = "";

    private Context mContext;
    private LinearLayout oe;

    private Button btnmp;
    private Button btnmm;
    private Button btnfa;
    private Button btnite;

    private LinearLayout bmp;
    private LinearLayout bmm;
    private LinearLayout bfa;
    private LinearLayout bite;

    private EditText etSitio;
    private EditText etSector;
    private EditText etProyecto;

    private CheckBox revision;
    private CheckBox inspeccion;
    private CheckBox diagnostico;
    private CheckBox mmtmayor;
    private CheckBox fallas;
    private CheckBox reparacion;

    private EditText etequipo;
    private EditText etmarca;
    private EditText etmodelo;
    private EditText etnoserie;
    private EditText etubicacion;

    //Antecedentes
    //MP
    private EditText etfechaMP1;
    private EditText etbreveMP1;
    private EditText etfechaMP2;
    private EditText etbreveMP2;
    private EditText etfechaMP3;
    private EditText etbreveMP3;

    //Antecendentes
    //MttoMayor
    private EditText etfechaMM1;
    private EditText etbreveMM1;
    private EditText etfechaMM2;
    private EditText etbreveMM2;
    private EditText etfechaMM3;
    private EditText etbreveMM3;

    //Antecedentes
    //Fallas
    private EditText etnoOSfallas1;
    private EditText etfechafallas1;
    private EditText etbrevefallas1;
    private EditText etnoOSfallas2;
    private EditText etfechafallas2;
    private EditText etbrevefallas2;
    private EditText etnoOSfallas3;
    private EditText etfechafallas3;
    private EditText etbrevefallas3;

    //Antecedentes
    //ITE
    private EditText etnoOSite1;
    private EditText etfechaite1;
    private EditText etbreveite1;
    private EditText etnoOSite2;
    private EditText etfechaite2;
    private EditText etbreveite2;
    private EditText etnoOSite3;
    private EditText etfechaite3;
    private EditText etbreveite3;
    //Desarrollo
    private EditText etdescripciondesarrollo;
    private EditText etobservaciondesarrollo;
    private EditText etreparaciondesarrollo;
    private EditText etestadodesarrollo;
    private String[] nomotor;

    private EditText etdescripcionDesa1;
    private EditText etdescripcionDesa2;
    private EditText etdescripcionDesa3;
    private EditText etdescripcionDesa4;
    private EditText etdescripcionDesa5;
    private EditText etdescripcionDesa6;
    private EditText etdescripcionDesa7;
    private EditText etdescripcionDesa8;
    private EditText etdescripcionDesa9;
    private EditText etdescripcionDesa10;

    //Imagenes
    private Button btncamara1;
    private Button btncamara2;
    private Button btncamara3;
    private Button btncamara4;
    private Button btncamara5;
    private Button btncamara6;
    private Button btncamara7;
    private Button btncamara8;
    private Button btncamara9;
    private Button btncamara10;
    // Conclusiones
    private EditText etconclusiones;
    //Recomendaciones
    private String[] norecomendacion;

    private EditText etrecomendacion1;
    private EditText etrecomendacion2;
    private EditText etrecomendacion3;
    private EditText etrecomendacion4;
    private EditText etrecomendacion5;
    private EditText etrecomendacion6;
    private EditText etrecomendacion7;
    private EditText etrecomendacion8;
    private EditText etrecomendacion9;
    private EditText etrecomendacion10;

    private List<String> fotos = new ArrayList<String>();
    private List<String> fotosg = new ArrayList<String>();

    //Firmas
    private Button btnEnviar;
    private Button btnFirmaTec;
    private Button btnFirmaResp;

    private String firmaJFSitio = "";
    private String firmaJFMtto = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_ti);

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
        SharedPreferences userCred = getSharedPreferences(USER_CRED, 0);
        idUSer = String.valueOf(userCred.getInt("IDUser", 0));
        oe = findViewById(R.id.OE);

        btnEnviar = findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                enviarFormulario();
                btnEnviar.setEnabled(false);
            }
        });


        bmp = (LinearLayout) findViewById(R.id.mp);
        bmm = (LinearLayout) findViewById(R.id.mm);
        bfa = (LinearLayout) findViewById(R.id.fa);
        bite = (LinearLayout) findViewById(R.id.ite);

        btnmp = (Button) findViewById(R.id.botonMP);
        btnmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bmp.getVisibility() == View.VISIBLE){
                    btnmp.setText("+");
                    bmp.setVisibility(View.GONE);
                } else {
                    btnmp.setText("-");
                    bmp.setVisibility(View.VISIBLE);
                }
            }
        });

        btnmm = (Button) findViewById(R.id.botonMM);
        btnmm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bmm.getVisibility() == View.VISIBLE){
                    btnmm.setText("+");
                    bmm.setVisibility(View.GONE);
                } else {
                    btnmm.setText("-");
                    bmm.setVisibility(View.VISIBLE);
                }
            }
        });

        btnfa = (Button) findViewById(R.id.botonfallas);
        btnfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bfa.getVisibility() == View.VISIBLE){
                    btnfa.setText("+");
                    bfa.setVisibility(View.GONE);
                } else {
                    btnfa.setText("-");
                    bfa.setVisibility(View.VISIBLE);
                }
            }
        });

        btnite = (Button) findViewById(R.id.botonITE);
        btnite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bite.getVisibility() == View.VISIBLE) {
                btnite.setText("+");
                bite.setVisibility(View.GONE);
            } else {
                btnite.setText("-");
                bite.setVisibility(View.VISIBLE);
            }
        }
        });

        btnFirmaTec = findViewById(R.id.btnFirmaTec);
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

        btnFirmaResp = findViewById(R.id.btnFirmaResp);
        btnFirmaResp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), FirmaActivity.class);
                in.putExtra("FirmaDE", 1);
                startActivityForResult(in, 1);
                //btnFirmaResp.setEnabled(false);
            }
        });

        btncamara1 = findViewById(R.id.btnopencamara);
        btncamara1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                startActivityForResult(in, 1);
            }
        });

        btncamara2 = findViewById(R.id.btnopencamara2);
        btncamara2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                startActivityForResult(in, 1);
            }
        });

        btncamara3 = findViewById(R.id.btnopencamara3);
        btncamara3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                startActivityForResult(in, 1);
            }
        });

        btncamara4 = findViewById(R.id.btnopencamara4);
        btncamara4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                startActivityForResult(in, 1);
            }
        });

        btncamara5 = findViewById(R.id.btnopencamara5);
        btncamara5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                startActivityForResult(in, 1);
            }
        });

        btncamara6 = findViewById(R.id.btnopencamara6);
        btncamara6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 5);
                startActivityForResult(in, 1);
            }
        });

        btncamara7 = findViewById(R.id.btnopencamara7);
        btncamara7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 6);
                startActivityForResult(in, 1);
            }
        });

        btncamara8 = findViewById(R.id.btnopencamara8);
        btncamara8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 7);
                startActivityForResult(in, 1);
            }
        });

        btncamara9 = findViewById(R.id.btnopencamara9);
        btncamara9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 8);
                startActivityForResult(in, 1);
            }
        });

        btncamara10 = findViewById(R.id.btnopencamara10);
        btncamara10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 9);
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
                    && "vacio".equals(data.getStringExtra("FotoSeis"))&& "vacio".equals(data.getStringExtra("FotoSiete"))
                    && "vacio".equals(data.getStringExtra("FotoOcho")) && "vacio".equals(data.getStringExtra("FotoNueve"))
                    && "vacio".equals(data.getStringExtra("FotoDiez"))){
                bitmap = BitmapFactory.decodeFile(data.getStringExtra("FotoUno"));
                ByteArrayOutputStream array = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,  10, array);
                byteArray = array.toByteArray();
                imagenString = Base64.encodeToString(byteArray, Base64.DEFAULT);
                fotouno = imagenString;
                btncamara1.setEnabled(false);

            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoTres"))
                    && "vacio".equals(data.getStringExtra("FotoCuatro")) && "vacio".equals(data.getStringExtra("FotoCnco"))
                    && "vacio".equals(data.getStringExtra("FotoSeis"))&& "vacio".equals(data.getStringExtra("FotoSiete"))
                    && "vacio".equals(data.getStringExtra("FotoOcho")) && "vacio".equals(data.getStringExtra("FotoNueve"))
                    && "vacio".equals(data.getStringExtra("FotoDiez"))){
                bitmap = BitmapFactory.decodeFile(data.getStringExtra("FotoDos"));
                ByteArrayOutputStream array = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,  10, array);
                byteArray = array.toByteArray();
                imagenString = Base64.encodeToString(byteArray, Base64.DEFAULT);
                fotodos = imagenString;
                btncamara2.setEnabled(false);

            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoDos"))
                    && "vacio".equals(data.getStringExtra("FotoCuatro")) && "vacio".equals(data.getStringExtra("FotoCnco"))
                    && "vacio".equals(data.getStringExtra("FotoSeis"))&& "vacio".equals(data.getStringExtra("FotoSiete"))
                    && "vacio".equals(data.getStringExtra("FotoOcho")) && "vacio".equals(data.getStringExtra("FotoNueve"))
                    && "vacio".equals(data.getStringExtra("FotoDiez"))){
                bitmap = BitmapFactory.decodeFile(data.getStringExtra("FotoTres"));
                ByteArrayOutputStream array = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,  10, array);
                byteArray = array.toByteArray();
                imagenString = Base64.encodeToString(byteArray, Base64.DEFAULT);
                fototres = imagenString;
                btncamara3.setEnabled(false);

            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoDos"))
                    && "vacio".equals(data.getStringExtra("FotoTres")) && "vacio".equals(data.getStringExtra("FotoCnco"))
                    && "vacio".equals(data.getStringExtra("FotoSeis"))&& "vacio".equals(data.getStringExtra("FotoSiete"))
                    && "vacio".equals(data.getStringExtra("FotoOcho")) && "vacio".equals(data.getStringExtra("FotoNueve"))
                    && "vacio".equals(data.getStringExtra("FotoDiez"))){
                bitmap = BitmapFactory.decodeFile(data.getStringExtra("FotoCuatro"));
                ByteArrayOutputStream array = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,  10, array);
                byteArray = array.toByteArray();
                imagenString = Base64.encodeToString(byteArray, Base64.DEFAULT);
                fotocuatro = imagenString;
                btncamara4.setEnabled(false);

            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoDos"))
                    && "vacio".equals(data.getStringExtra("FotoTres")) && "vacio".equals(data.getStringExtra("FotoCuatro"))
                    && "vacio".equals(data.getStringExtra("FotoSeis"))&& "vacio".equals(data.getStringExtra("FotoSiete"))
                    && "vacio".equals(data.getStringExtra("FotoOcho")) && "vacio".equals(data.getStringExtra("FotoNueve"))
                    && "vacio".equals(data.getStringExtra("FotoDiez"))){
                bitmap = BitmapFactory.decodeFile(data.getStringExtra("FotoCnco"));
                ByteArrayOutputStream array = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,  10, array);
                byteArray = array.toByteArray();
                imagenString = Base64.encodeToString(byteArray, Base64.DEFAULT);
                fotocinco = imagenString;
                btncamara5.setEnabled(false);

            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoDos"))
                    && "vacio".equals(data.getStringExtra("FotoTres")) && "vacio".equals(data.getStringExtra("FotoCuatro"))
                    && "vacio".equals(data.getStringExtra("FotoCnco"))&& "vacio".equals(data.getStringExtra("FotoSiete"))
                    && "vacio".equals(data.getStringExtra("FotoOcho")) && "vacio".equals(data.getStringExtra("FotoNueve"))
                    && "vacio".equals(data.getStringExtra("FotoDiez"))){
                bitmap = BitmapFactory.decodeFile(data.getStringExtra("FotoSeis"));
                ByteArrayOutputStream array = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,  10, array);
                byteArray = array.toByteArray();
                imagenString = Base64.encodeToString(byteArray, Base64.DEFAULT);
                fotoseis = imagenString;
                btncamara6.setEnabled(false);

            }  else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoDos"))
                    && "vacio".equals(data.getStringExtra("FotoTres")) && "vacio".equals(data.getStringExtra("FotoCuatro"))
                    && "vacio".equals(data.getStringExtra("FotoCnco")) && "vacio".equals(data.getStringExtra("FotoSeis"))
                    && "vacio".equals(data.getStringExtra("FotoOcho")) && "vacio".equals(data.getStringExtra("FotoNueve"))
                    && "vacio".equals(data.getStringExtra("FotoDiez"))){
                bitmap = BitmapFactory.decodeFile(data.getStringExtra("FotoSiete"));
                ByteArrayOutputStream array = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,  10, array);
                byteArray = array.toByteArray();
                imagenString = Base64.encodeToString(byteArray, Base64.DEFAULT);
                fotosiete = imagenString;
                btncamara7.setEnabled(false);

            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoDos"))
                    && "vacio".equals(data.getStringExtra("FotoTres")) && "vacio".equals(data.getStringExtra("FotoCuatro"))
                    && "vacio".equals(data.getStringExtra("FotoCnco")) && "vacio".equals(data.getStringExtra("FotoSeis"))
                    && "vacio".equals(data.getStringExtra("FotoSiete")) && "vacio".equals(data.getStringExtra("FotoNueve"))
                    && "vacio".equals(data.getStringExtra("FotoDiez"))){
                bitmap = BitmapFactory.decodeFile(data.getStringExtra("FotoOcho"));
                ByteArrayOutputStream array = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,  10, array);
                byteArray = array.toByteArray();
                imagenString = Base64.encodeToString(byteArray, Base64.DEFAULT);
                fotoocho = imagenString;
                btncamara8.setEnabled(false);

            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoDos"))
                    && "vacio".equals(data.getStringExtra("FotoTres")) && "vacio".equals(data.getStringExtra("FotoCuatro"))
                    && "vacio".equals(data.getStringExtra("FotoCnco")) && "vacio".equals(data.getStringExtra("FotoSeis"))
                    && "vacio".equals(data.getStringExtra("FotoSiete")) && "vacio".equals(data.getStringExtra("FotoOcho"))
                    && "vacio".equals(data.getStringExtra("FotoDiez"))){
                bitmap = BitmapFactory.decodeFile(data.getStringExtra("FotoNueve"));
                ByteArrayOutputStream array = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,  10, array);
                byteArray = array.toByteArray();
                imagenString = Base64.encodeToString(byteArray, Base64.DEFAULT);
                fotonueve = imagenString;
                btncamara9.setEnabled(false);

            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoDos"))
                    && "vacio".equals(data.getStringExtra("FotoTres")) && "vacio".equals(data.getStringExtra("FotoCuatro"))
                    && "vacio".equals(data.getStringExtra("FotoCnco")) && "vacio".equals(data.getStringExtra("FotoSeis"))
                    && "vacio".equals(data.getStringExtra("FotoSiete")) && "vacio".equals(data.getStringExtra("FotoOcho"))
                    && "vacio".equals(data.getStringExtra("FotoNueve"))){
                bitmap = BitmapFactory.decodeFile(data.getStringExtra("FotoDiez"));
                ByteArrayOutputStream array = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,  10, array);
                byteArray = array.toByteArray();
                imagenString = Base64.encodeToString(byteArray, Base64.DEFAULT);
                fotodiez = imagenString;
                btncamara10.setEnabled(false);

            }
        }

    }

    private void enviarFormulario() {
        addAsunto();

    }

    public void addAsunto(){
        revision = (CheckBox) findViewById(R.id.revision);
        inspeccion = (CheckBox) findViewById(R.id.inspe);
        diagnostico = (CheckBox) findViewById(R.id.diagnostico);
        mmtmayor = (CheckBox) findViewById(R.id.mttmayor);
        fallas = (CheckBox) findViewById(R.id.fallas);
        reparacion = (CheckBox) findViewById(R.id.repara);

        String result = "";

        if (revision.isChecked()){
            result += revision.getText()+"|";
        }


    }

    public void borrarif(View v) {

        MyOpenHelper dbHelper = new MyOpenHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("DELETE FROM NIFSQL");
        Toast.makeText(this, "Los datos se han borrado", Toast.LENGTH_SHORT).show();
    }

    public void grabar(View v) {
        dbHelper = new MyOpenHelper(this);
        db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM NIFSQL", null);
        ContentValues cv = insertsql();
        if (c.getCount() ==0){
            db.insert("NIFSQL", null, cv);
            Toast.makeText(this, "Los datos han sigo grabados", Toast.LENGTH_SHORT).show();
        } else {
            c.moveToFirst();
            int id = c.getInt(c.getColumnIndex("_id"));
            db.update("NIFSQL",  cv, "_id="+id, null);
            Toast.makeText(this, "Los datos se han actualizado", Toast.LENGTH_SHORT).show();
        }
        c.close();
        db.close();
    }

    public void recuperarau(View view) {

        dbHelper = new MyOpenHelper(this);
        db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM NIFSQL", null);
        if (c.getCount() != 0 ) {
            c.moveToFirst();
            do{
                etSitio.setText(c.getString(c.getColumnIndex("Sitio")));
                etSector.setText(c.getString(c.getColumnIndex("Sector")));
                etProyecto.setText(c.getString(c.getColumnIndex("Proyecto")));
                etequipo.setText(c.getString(c.getColumnIndex("Equipo")));
                etmarca.setText(c.getString(c.getColumnIndex("Antecedentes")));
                etmodelo.setText(c.getString(c.getColumnIndex("Tanquedia")));
                etnoserie.setText(c.getString(c.getColumnIndex("Tanqueprin")));
                etubicacion.setText(c.getString(c.getColumnIndex("Nivelcombus")));
                etfechaMP1.setText(c.getString(c.getColumnIndex("Aceite")));
                etbreveMP1.setText(c.getString(c.getColumnIndex("Presionace")));
                etfechaMP2.setText(c.getString(c.getColumnIndex("Nivelagua")));
                etfechaMP3.setText(c.getString(c.getColumnIndex("Electrolito")));
                etbreveMP3.setText(c.getString(c.getColumnIndex("Temperatura")));
                etfechaMM1.setText(c.getString(c.getColumnIndex("Carga")));
                etbreveMM1.setText(c.getString(c.getColumnIndex("Bateria")));
                etfechaMM2.setText(c.getString(c.getColumnIndex("Voltaje")));
                etbreveMM2.setText(c.getString(c.getColumnIndex("Standby")));
                etfechaMM3.setText(c.getString(c.getColumnIndex("Alternadorarra")));
                etbreveMM3.setText(c.getString(c.getColumnIndex("Alternadorby")));
                etnoOSfallas1.setText(c.getString(c.getColumnIndex("NO")));
                etfechafallas1.setText(c.getString(c.getColumnIndex("FechaFA")));
                etbrevefallas1.setText(c.getString(c.getColumnIndex("BreveFA")));
                etnoOSfallas2.setText(c.getString(c.getColumnIndex("NO1")));
                etfechafallas2.setText(c.getString(c.getColumnIndex("FechaFA1")));
                etbrevefallas2.setText(c.getString(c.getColumnIndex("BreveFA1")));
                etnoOSfallas3.setText(c.getString(c.getColumnIndex("NO2")));
                etfechafallas3.setText(c.getString(c.getColumnIndex("FechaFA2")));
                etbrevefallas3.setText(c.getString(c.getColumnIndex("BreveFA2")));
                etnoOSite1.setText(c.getString(c.getColumnIndex("NOITE")));
                etfechaite1.setText(c.getString(c.getColumnIndex("FechaITE")));
                etbreveite1.setText(c.getString(c.getColumnIndex("BreveITE")));
                etnoOSite2.setText(c.getString(c.getColumnIndex("NOITE1")));
                etfechaite2.setText(c.getString(c.getColumnIndex("FechaITE1")));
                etbreveite2.setText(c.getString(c.getColumnIndex("BreveITE1")));
                etnoOSite3.setText(c.getString(c.getColumnIndex("NOITE2")));
                etfechaite3.setText(c.getString(c.getColumnIndex("FechaITE2")));
                etbreveite3.setText(c.getString(c.getColumnIndex("BreveITE2")));
                etdescripciondesarrollo.setText(c.getColumnIndex("BreveDesa"));
                etobservaciondesarrollo.setText(c.getColumnIndex("HallazgoDesa"));
                etreparaciondesarrollo.setText(c.getColumnIndex("RepaDesa"));

                etTimeRTrans.setText(c.getString(c.getColumnIndex("Tiempo")));
                etLectura.setText(c.getString(c.getColumnIndex("Horometro")));
                etMedicionCorrienteGen.setText(c.getString(c.getColumnIndex("Corriente")));
                etTimeArr.setText(c.getString(c.getColumnIndex("Tiempocon")));
                etObserv.setText(c.getString(c.getColumnIndex("Observacionescon")));
                etTimeArrCS.setText(c.getString(c.getColumnIndex("Tiemposin")));
                etObserv1.setText(c.getString(c.getColumnIndex("Observacionessin")));
                etTimeArrVacio.setText(c.getString(c.getColumnIndex("Tiempovacio")));
                etConclusiones.setText(c.getString(c.getColumnIndex("Conclusionesservi")));
                etRecomendaciones.setText(c.getString(c.getColumnIndex("Recomendacionesservi")));
                etCommentJFMtto.setText(c.getString(c.getColumnIndex("Comentariosjefe")));
                etCorreo.setText(c.getString(c.getColumnIndex("Correo")));
                etNumEqNav.setText(c.getString(c.getColumnIndex("Numnav")));

                String Imau = c.getString(c.getColumnIndex("Imagenes"));
                String Asunto = c.getString(c.getColumnIndex("Asunto"));

                String [] ima = null;

                String[] Checks1 = Asunto.split(", ");

                revision.setChecked(Boolean.parseBoolean(Checks1[0]));
                inspeccion.setChecked(Boolean.parseBoolean(Checks1[1]));
                diagnostico.setChecked(Boolean.parseBoolean(Checks1[2]));
                mmtmayor.setChecked(Boolean.parseBoolean(Checks1[3]));
                fallas.setChecked(Boolean.parseBoolean(Checks1[4]));
                reparacion.setChecked(Boolean.parseBoolean(Checks1[5]));

                firmaJFMtto = c.getString(c.getColumnIndex("FirmaTec"));
                firmaJFSitio = c.getString(c.getColumnIndex("FirmaRes"));

                // llenar arreglo auxiliar de fotos y bloquear los botones para no reescribir la foto
                if(!Imau.equals("")){
                    ima = Imau.split(", ");
                    for (int j = 0; j < ima.length; j++){
                        if(ima[j].contains("Foto01")){
                            btncamara1.setEnabled(false);
                        }
                        else if(ima[j].contains("Foto02")){
                            btncamara2.setEnabled(false);
                        }
                        else if(ima[j].contains("Foto03")){
                            btncamara3.setEnabled(false);
                        }
                        else if(ima[j].contains("Foto04")){
                            btncamara4.setEnabled(false);
                        }
                        else if(ima[j].contains("Foto05")){
                            btncamara5.setEnabled(false);
                        }
                        else if(ima[j].contains("Foto06")){
                            btncamara6.setEnabled(false);
                        }
                        else if(ima[j].contains("Foto07")){
                            btncamara7.setEnabled(false);
                        }
                        else if(ima[j].contains("Foto08")){
                            btncamara8.setEnabled(false);
                        }
                        else if(ima[j].contains("Foto09")){
                            btncamara9.setEnabled(false);
                        }
                        else if(ima[j].contains("Foto10")){
                            btncamara10.setEnabled(false);
                        }
                        fotosg.add(ima[j]);
                    }
                }

            }while (c.moveToNext());
            for (int i=0; i< fotosg.size(); i++){
                String str = fotosg.get(i).substring(7);
                String idImg = "";

                if(i+1 < 10)
                    idImg = "Foto0"+(i+1) + ":";
                else
                    idImg = "Foto"+(i+1) + ":";

                fotos.add(idImg+convertirimagen(str));
            }

        }else {
            Toast.makeText(this, "No hay datos para recuperar", Toast.LENGTH_SHORT).show();
        }

        c.close();
        db.close();
    }

    private ContentValues insertsql(){

        String cadena = "";
        ContentValues cv = new ContentValues();

        cv. put("Sitio", etSitio.getText().toString());
        cv. put("Sector", etSector.getText().toString());
        cv. put("Proyecto", etProyecto.getText().toString());
        cv.put("Asunto", revision.isChecked() + ", " + inspeccion.isChecked() + ", " + diagnostico.isChecked() +
                ", " + mmtmayor.isChecked() + ", " + fallas.isChecked() + ", " + reparacion.isChecked());
        cv. put("Equipo", etequipo.getText().toString());
        cv. put("Marca", etmarca.getText().toString());
        cv.put("Modelo", etmodelo.getText().toString() );
        cv.put("Noserie", etnoserie.getText().toString());
        cv.put("Ubicacion", etubicacion.getText().toString());
        cv.put("FechaMP", etfechaMP1.getText().toString());
        cv.put("BreveMP", etbreveMP1.getText().toString());
        cv.put("FechaMP1", etfechaMP2.getText().toString());
        cv.put("BreveMP1", etbreveMP2.getText().toString());
        cv.put("FechaMP2", etfechaMP3.getText().toString());
        cv.put("BreveMP2", etbreveMP3.getText().toString());
        cv.put("FechaMM", etfechaMM1.getText().toString());
        cv.put("BreveMM", etbreveMM1.getText().toString());
        cv.put("FechaMM1", etfechaMM2.getText().toString());
        cv.put("BreveMM1", etbreveMM2.getText().toString());
        cv.put("FechaMM2", etfechaMM3.getText().toString());
        cv.put("BreveMM2", etbreveMM3.getText().toString());
        cv.put("NO", etnoOSfallas1.getText().toString());
        cv.put("FechaFA", etfechafallas1.getText().toString());
        cv.put("BreveFA", etbrevefallas1.getText().toString());
        cv.put("NO1", etnoOSfallas2.getText().toString());
        cv.put("FechaFA1", etfechafallas2.getText().toString());
        cv.put("BreveFA1", etbrevefallas2.getText().toString());
        cv.put("NO2", etnoOSfallas3.getText().toString());
        cv.put("FechaFA2", etfechafallas3.getText().toString());
        cv.put("BreveFA2", etbrevefallas3.getText().toString());
        cv.put("NOITE", etnoOSite1.getText().toString());
        cv.put("FechaITE", etfechaite1.getText().toString());
        cv.put("BreveITE", etbreveite1.getText().toString());
        cv.put("NOITE1", etnoOSite2.getText().toString());
        cv.put("FechaITE1", etfechaite2.getText().toString());
        cv.put("BreveITE1", etbreveite2.getText().toString());
        cv.put("NOITE2", etnoOSite3.getText().toString());
        cv.put("FechaITE2", etfechaite3.getText().toString());
        cv.put("BreveITE2", etbreveite3.getText().toString());
        cv.put("BreveDesa", etdescripciondesarrollo.getText().toString());
        cv.put("HallazgoDesa", etobservaciondesarrollo.getText().toString());
        cv.put("RepaDesa", etreparaciondesarrollo.getText().toString());
        cv.put("EstadoDesa", etestadodesarrollo.getText().toString());
        cv.put("DescripcionDesa1", etdescripcionDesa1.getText().toString());
        cv.put("DescripcionDesa2", etdescripcionDesa2.getText().toString());
        cv.put("DescripcionDesa3", etdescripcionDesa3.getText().toString());
        cv.put("DescripcionDesa4", etdescripcionDesa4.getText().toString());
        cv.put("DescripcionDesa5", etdescripcionDesa5.getText().toString());
        cv.put("DescripcionDesa6", etdescripcionDesa6.getText().toString());
        cv.put("DescripcionDesa7", etdescripcionDesa7.getText().toString());
        cv.put("DescripcionDesa8", etdescripcionDesa8.getText().toString());
        cv.put("DescripcionDesa9", etdescripcionDesa9.getText().toString());
        cv.put("DescripcionDesa10", etdescripcionDesa10.getText().toString());

        cv.put("Conclusion", etconclusiones.getText().toString());

        cv.put("DescripcionConclu1", etrecomendacion1.getText().toString());
        cv.put("DescripcionConclu2", etrecomendacion2.getText().toString());
        cv.put("DescripcionConclu3", etrecomendacion3.getText().toString());
        cv.put("DescripcionConclu4", etrecomendacion4.getText().toString());
        cv.put("DescripcionConclu5", etrecomendacion5.getText().toString());
        cv.put("DescripcionConclu6", etrecomendacion6.getText().toString());
        cv.put("DescripcionConclu7", etrecomendacion7.getText().toString());
        cv.put("DescripcionConclu8", etrecomendacion8.getText().toString());
        cv.put("DescripcionConclu9", etrecomendacion9.getText().toString());
        cv.put("DescripcionConclu10", etrecomendacion10.getText().toString());

        if (fotosg.size()!=0){
            cadena = fotosg.toString();
            cv.put("Imagenes", cadena.substring(1, cadena.length() -1));
        }else{
            cv.put("Imagenes", "");
        }

        cv.put("FirmaTec", firmaJFSitio);
        cv.put("Firmante", "");
        cv.put("FirmaRes", firmaJFMtto);
        cv.put("Firmanres", "");

        return cv;

    }

    private String convertirimagen(String path){
        String bit;
        bitmap = BitmapFactory.decodeFile(path);
        ByteArrayOutputStream array = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,  10, array);
        byteArray = array.toByteArray();
        bit = Base64.encodeToString(byteArray, Base64.DEFAULT);
        return bit;
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
            URL destinoURL;
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
