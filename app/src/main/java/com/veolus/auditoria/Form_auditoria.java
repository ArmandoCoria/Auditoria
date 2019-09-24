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
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Path;
import android.icu.text.SimpleDateFormat;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Form_auditoria extends Activity {

    public static final String USER_CRED = "UserCredencials";

    private EditText etDgc;
    private EditText etMotivo;
    private EditText etSitio;
    private EditText etSector;
    private EditText etProyecto;
    private EditText etFecha;
    private EditText etObservaciones;
    private EditText etObservaciones1;
    private EditText etPromesas;
    private EditText etPromesas1;

    private EditText detalles;
    private EditText detalles1;
    private EditText detalles2;
    private EditText detalles3;
    private EditText detalles4;
    private EditText detalles5;
    private EditText detalles6;
    private EditText detalles7;
    private EditText detalles8;
    private EditText detalles9;
    private EditText detalles10;
    private EditText detalles11;
    private EditText detalles12;
    private EditText detalles13;
    private EditText detalles14;
    private EditText detalles15;
    private EditText detalles16;
    private EditText detalles17;
    private EditText detalles18;
    private EditText detalles19;

    private EditText peticiones;
    private EditText peticiones1;
    private EditText peticiones2;
    private EditText peticiones3;
    private EditText peticiones4;
    private EditText peticiones5;
    private EditText peticiones6;
    private EditText peticiones7;
    private EditText peticiones8;
    private EditText peticiones9;
    private EditText peticiones10;
    private EditText peticiones11;
    private EditText peticiones12;
    private EditText peticiones13;
    private EditText peticiones14;
    private EditText peticiones15;
    private EditText peticiones16;
    private EditText peticiones17;
    private EditText peticiones18;
    private EditText peticiones19;

    private LinearLayout zpi;
    private LinearLayout ztc;
    private LinearLayout zmt;
    private LinearLayout zfr;
    private LinearLayout zlv;
    private LinearLayout zlvt;
    private LinearLayout zlva;
    private LinearLayout zlve;
    private LinearLayout zlvo;
    private LinearLayout zlvp;
    private LinearLayout zlvk;
    private LinearLayout zlvc;
    private LinearLayout zlvf;
    private LinearLayout zlvy;
    private LinearLayout zlvh;
    private LinearLayout zlvx;
    private LinearLayout zlvm;
    private LinearLayout zlvn;
    private LinearLayout zlvs;
    private LinearLayout zlvxx;

    private CheckBox peines, demarcaciones, fosas, pasamanos, funcionamiento; // escaleras
    private CheckBox cables, poleas, correcto; // elevadores
    private CheckBox correctos, correctas, correcto1; // montacargas
    private CheckBox combustion, electrica, bitacoras, orden, fugas ; // BCI
    private CheckBox prueba, cuenta1, limpieza1, presenta; // pem
    private CheckBox correcto2, encuentran, orden1, zonas1;// subestacion
    private CheckBox equipo, se, tienen, limpieza2; // chillers
    private CheckBox operando, presenta1; // bombas
    private CheckBox correcto3, orden2, fugas2; // torres
    private CheckBox herramienta, epi, sgi; // checklist
    private CheckBox etm, elevadores, montacargas, bci, pem, subestacion, chillers, bombas, torres, umas, ups, ulas, minis, extractores, tableros, cocinas, sanitarios, check, Direccion, jefe; // checklist

    private AutoCompleteTextView autoCompleteTextView;
    private String[] sitios;
    private getSitio miSitio = null;

    private AutoCompleteTextView autoCompleteEquipo;
    private String[] equipos;
    private getEquipo miEquipo = null;

    private Button btnEnviar;
    private Button btnFirmaTec;
    private Button btnFirmaResp;

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
    private Button btncamara11;
    private Button btncamara12;
    private Button btncamara13;
    private Button btncamara14;
    private Button btncamara15;
    private Button btncamara16;
    private Button btncamara17;
    private Button btncamara18;
    private Button btncamara19;
    private Button btncamara20;
    private Button btncamara21;
    private Button btncamara22;
    private Button btncamara23;
    private Button btncamara24;
    private Button btncamara25;
    private Button btncamara26;
    private Button btncamara27;
    private Button btncamara28;
    private Button btncamara29;
    private Button btncamara30;
    private Button btncamara31;
    private Button btncamara32;
    private Button btncamara33;
    private Button btncamara34;
    private Button btncamara35;
    private Button btncamara36;
    private Button btncamara37;
    private Button btncamara38;
    private Button btncamara39;
    private Button btncamara40;
    private Button btncamara41;
    private Button btncamara42;
    private Button btncamara43;
    private Button btncamara44;
    private Button btncamara45;
    private Button btncamara46;
    private Button btncamara47;
    private Button btncamara48;
    private Button btncamara49;
    private Button btncamara50;
    private Button btncamara51;
    private Button btncamara52;
    private Button btncamara53;
    private Button btncamara54;
    private Button btncamara55;
    private Button btncamara56;
    private Button btncamara57;
    private Button btncamara58;
    private Button btncamara59;
    private Button btncamara60;
    private Button btncamara61;
    private Button btncamara62;
    private Button btncamara63;
    private Button btncamara64;
    private Button btncamara65;
    private Button btncamara66;
    private Button btncamara67;
    private Button btncamara68;
    private Button btncamara69;
    private Button btncamara70;
    private Button btncamara71;
    private Button btncamara72;
    private Button btncamara73;
    private Button btncamara74;
    private Button btncamara75;
    private Button btncamara76;
    private Button btncamara77;
    private Button btncamara78;
    private Button btncamara79;
    private Button btncamara80;
    private Button btncamara81;
    private Button btncamara82;
    private Button btncamara83;
    private Button btncamara84;
    private Button btncamara85;
    private Button btncamara86;
    private Button btncamara87;
    private Button btncamara88;
    private Button btncamara89;
    private Button btncamara90;

    Bitmap bitmap;
    byte[] byteArray;
    String imagenString;

    // Duración en milisegundos que se mostrará el la pantalla principal desps de enviar el reporte
    private final int DURACION_SPLASH = 4000; // 4 segundos

    private Form_auditoria.taskZonaPuntosdeInicioOT2 taskZonaPuntosdeInicioOT2 = null;
   // private taskGetDireccionSitioOT2 miTaskGetDireccionSitioOT2 = null;
    private static final String URLGPS = "http://www.veolus.com/gps/";

    private String partida_concepto = "";
    private String zonas = "";
    private String firmaTec = "";
    private String firmaResp = "";
    private String firmanteTec = "";
    private String firmanteResp = "";

    private boolean Zonas1;

    TextView texto;

    private List<String> fotos = new ArrayList<String>();
    private List<String> fotosg = new ArrayList<String>();
  //  private List<String> fotospath = new ArrayList<String>();

   //*private String direccion = "";
    private Context mContext;
    private String mes;

    private Boolean fEsc;
    private Boolean fEle;
    private Boolean fMon;
    private Boolean fBCI;
    private Boolean fPEM;
    private Boolean fSube;
    private Boolean fChill;
    private Boolean fBom;
    private Boolean fTorres;
    private Boolean fUMAs;
    private Boolean fUPs;
    private Boolean fULAs;
    private Boolean fMini;
    private Boolean fExtrac;
    private Boolean fTableros;
    private Boolean fCocinas;
    private Boolean fSanitarios;
    private Boolean fDireccion;
    private Boolean fJefe;
    private Boolean fchecklist;

    // banderas de validacion de foto para zonas
    private Boolean ffEsc = false;
    private Boolean ffEle= false;
    private Boolean ffMon= false;
    private Boolean ffBCI= false;
    private Boolean ffPEM= false;
    private Boolean ffSube= false;
    private Boolean ffChill= false;
    private Boolean ffBom= false;
    private Boolean ffTorres= false;
    private Boolean ffUMAs= false;
    private Boolean ffUPs= false;
    private Boolean ffULAs= false;
    private Boolean ffMini= false;
    private Boolean ffExtrac= false;
    private Boolean ffTableros= false;
    private Boolean ffCocinas= false;
    private Boolean ffSanitarios= false;
    private Boolean ffchecklist= false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_libre_auditoria);
        mContext = this;

        //Fecha
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
                            TextView tdate = (TextView) findViewById(R.id.fecha);
                            long date = System.currentTimeMillis();
                            SimpleDateFormat adf = null;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                adf = new SimpleDateFormat("MMM dd/yy");
                            }
                          String dateString = adf.format(date);
                    tdate.setText(dateString);
                        }
                    });
                }
            }
        };
            t.start();

        etDgc = (EditText) findViewById(R.id.dgc);
        etMotivo = (EditText) findViewById(R.id.motivo);
        etSector = (EditText) findViewById(R.id.sector);
        etProyecto = (EditText) findViewById(R.id.proyecto);
        etSitio = (EditText)findViewById(R.id.sitio);

        // cajas de comentarios por cada zona
        detalles =  (EditText) findViewById(R.id.detalles);
        detalles1 = (EditText) findViewById(R.id.detalles1);
        detalles2 = (EditText) findViewById(R.id.detalles2);
        detalles3 = (EditText) findViewById(R.id.detalles3);
        detalles4 = (EditText) findViewById(R.id.detalles4);
        detalles5 = (EditText) findViewById(R.id.detalles5);
        detalles6 = (EditText) findViewById(R.id.detalles6);
        detalles7 = (EditText) findViewById(R.id.detalles7);
        detalles8 = (EditText) findViewById(R.id.detalles8);
        detalles9 = (EditText) findViewById(R.id.detalles9);
        detalles10 = (EditText) findViewById(R.id.detalles10);
        detalles11 = (EditText) findViewById(R.id.detalles11);
        detalles12 = (EditText) findViewById(R.id.detalles12);
        detalles13 = (EditText) findViewById(R.id.detalles13);
        detalles14 = (EditText) findViewById(R.id.detalles14);
        detalles15 = (EditText) findViewById(R.id.detalles15);
        detalles16 = (EditText) findViewById(R.id.detalles16);
        detalles17 = (EditText) findViewById(R.id.detalles17);
        detalles18 = (EditText) findViewById(R.id.detalles18);
        detalles19 = (EditText) findViewById(R.id.detalles19);

        peticiones = (EditText) findViewById(R.id.peticiones);
        peticiones1 = (EditText) findViewById(R.id.peticiones1);
        peticiones2 = (EditText) findViewById(R.id.peticiones2);
        peticiones3 = (EditText) findViewById(R.id.peticiones3);
        peticiones4 = (EditText) findViewById(R.id.peticiones4);
        peticiones5 = (EditText) findViewById(R.id.peticiones5);
        peticiones6 = (EditText) findViewById(R.id.peticiones6);
        peticiones7 = (EditText) findViewById(R.id.peticiones7);
        peticiones8 = (EditText) findViewById(R.id.peticiones8);
        peticiones9 = (EditText) findViewById(R.id.peticiones9);
        peticiones10 = (EditText) findViewById(R.id.peticiones10);
        peticiones11 = (EditText) findViewById(R.id.peticiones11);
        peticiones12 = (EditText) findViewById(R.id.peticiones12);
        peticiones13 = (EditText) findViewById(R.id.peticiones13);
        peticiones14 = (EditText) findViewById(R.id.peticiones14);
        peticiones15 = (EditText) findViewById(R.id.peticiones15);
        peticiones16 = (EditText) findViewById(R.id.peticiones16);
        peticiones17 = (EditText) findViewById(R.id.peticiones17);
        peticiones18 = (EditText) findViewById(R.id.peticiones18);
        peticiones19 = (EditText) findViewById(R.id.peticiones19);

        // Layouts de los checkbox por cada zona
        zpi = (LinearLayout) findViewById(R.id.ZPI);
        zfr = (LinearLayout) findViewById(R.id.ZFR);
        ztc = (LinearLayout) findViewById(R.id.ZTC);
        zmt = (LinearLayout) findViewById(R.id.ZMT);
        zlv = (LinearLayout) findViewById(R.id.ZLV);
        zlvt = (LinearLayout) findViewById(R.id.ZLVT);
        zlva = (LinearLayout) findViewById(R.id.ZLVA);
        zlve = (LinearLayout) findViewById(R.id.ZLVE);
        zlvo = (LinearLayout) findViewById(R.id.ZLVO);
        zlvp = (LinearLayout) findViewById(R.id.ZLVP);
        zlvk = (LinearLayout) findViewById(R.id.ZLVK);
        zlvc = (LinearLayout) findViewById(R.id.ZLVC);
        zlvf = (LinearLayout) findViewById(R.id.ZLVF);
        zlvy = (LinearLayout) findViewById(R.id.ZLVY);
        zlvh = (LinearLayout) findViewById(R.id.ZLVH);
        zlvx = (LinearLayout) findViewById(R.id.ZLVX);
        zlvm = (LinearLayout) findViewById(R.id.ZLVM);
        zlvn = (LinearLayout) findViewById(R.id.ZLVN);
        zlvs = (LinearLayout) findViewById(R.id.ZLVS);
        zlvxx = (LinearLayout) findViewById(R.id.ZLVXX);

        etObservaciones = (EditText) findViewById(R.id.observaciones);
        etObservaciones1 = (EditText) findViewById(R.id.observaciones1);
        etPromesas = (EditText) findViewById(R.id.promesas);
        etPromesas1 = (EditText) findViewById(R.id.promesas1);

        check = (CheckBox) findViewById(R.id.button1);

        peines = (CheckBox) findViewById(R.id.peines);
        demarcaciones = (CheckBox) findViewById(R.id.demarcacion);
        fosas = (CheckBox) findViewById(R.id.fosas);
        pasamanos = (CheckBox) findViewById(R.id.pasamanos);
        funcionamiento = (CheckBox) findViewById(R.id.funcionamiento);

        cables = (CheckBox) findViewById(R.id.cables);
        poleas = (CheckBox) findViewById(R.id.poleas);
        correcto = (CheckBox) findViewById(R.id.correcto);

        correctos = (CheckBox) findViewById(R.id.correctos);
        correctas = (CheckBox) findViewById(R.id.correctas);
        correcto1 = (CheckBox) findViewById(R.id.correcto1);

        combustion = (CheckBox) findViewById(R.id.combustion);
        electrica = (CheckBox) findViewById(R.id.electrica);
        bitacoras = (CheckBox) findViewById(R.id.bitacoras);
        orden = (CheckBox) findViewById(R.id.orden);
        fugas = (CheckBox) findViewById(R.id.fugas);

        prueba = (CheckBox) findViewById(R.id.prueba);
        cuenta1 = (CheckBox) findViewById(R.id.cuenta1);
        limpieza1 = (CheckBox) findViewById(R.id.limpieza1);
        presenta = (CheckBox) findViewById(R.id.presenta);

        correcto2 = (CheckBox) findViewById(R.id.correcto2);
        encuentran = (CheckBox) findViewById(R.id.encuentran);
        orden1 = (CheckBox) findViewById(R.id.orden1);
        zonas1 = (CheckBox) findViewById(R.id.zonas1);

        equipo = (CheckBox) findViewById(R.id.equipo);
        se = (CheckBox) findViewById(R.id.se);
        tienen = (CheckBox) findViewById(R.id.tienen);
        limpieza2 = (CheckBox) findViewById(R.id.limpieza2);

        operando = (CheckBox) findViewById(R.id.operando);
        presenta1 = (CheckBox) findViewById(R.id.presenta);

        correcto3 = (CheckBox) findViewById(R.id.correcto3);
        orden2 = (CheckBox) findViewById(R.id.orden2);
        fugas2 = (CheckBox) findViewById(R.id.fugas2);

        herramienta = (CheckBox) findViewById(R.id.herramienta);
        epi = (CheckBox) findViewById(R.id.epi);
        sgi = (CheckBox) findViewById(R.id.sgi);

        // Botón '+' para mostrar/ocultar los checkbox de cada zona
        etm = (CheckBox ) findViewById(R.id.button01);
        etm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zpi.getVisibility() == View.VISIBLE) {
                    zpi.setVisibility(View.GONE);
                    texto.setTextColor(Color.GRAY);
                }else{
                    zpi.setVisibility(View.VISIBLE);
                    texto = (TextView) findViewById(R.id.etm);
                    texto.setTextColor(Color.GREEN);
                }
            }
        });

        elevadores = (CheckBox) findViewById(R.id.button02);
        elevadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ztc.getVisibility() == View.VISIBLE){
                    //si es Visible lo pones Gone
                    ztc.setVisibility(View.GONE);
                    texto.setTextColor(Color.GRAY);
                }else{
                    // si no es Visible, lo pones
                    ztc.setVisibility(View.VISIBLE);
                    texto = (TextView) findViewById(R.id.elevadores);
                    texto.setTextColor(Color.GREEN);
                }
            }
        });

        montacargas = (CheckBox) findViewById(R.id.button03);
        montacargas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zmt.getVisibility() == View.VISIBLE) {
                    zmt.setVisibility(View.GONE);
                    texto.setTextColor(Color.GRAY);
                }
                else{
                    zmt.setVisibility(View.VISIBLE);
                    texto = (TextView) findViewById(R.id.montacargas);
                    texto.setTextColor(Color.GREEN);
                }
            }
        });

        bci = (CheckBox) findViewById(R.id.button04);
        bci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zfr.getVisibility() == View.VISIBLE) {
                    zfr.setVisibility(View.GONE);
                    texto.setTextColor(Color.GRAY);
                }
                else{
                    zfr.setVisibility(View.VISIBLE);
                    texto = (TextView) findViewById(R.id.bci);
                    texto.setTextColor(Color.GREEN);
                }
            }
        });

        pem = (CheckBox) findViewById(R.id.button05);
        pem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zlv.getVisibility() == View.VISIBLE) {
                    zlv.setVisibility(View.GONE);
                    texto.setTextColor(Color.GRAY);
                }
                else{
                    zlv.setVisibility(View.VISIBLE);
                    texto = (TextView) findViewById(R.id.pem);
                    texto.setTextColor(Color.GREEN);
                }
            }
        });

        subestacion = (CheckBox) findViewById(R.id.button06);
        subestacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zlvt.getVisibility() == View.VISIBLE) {
                    zlvt.setVisibility(View.GONE);
                    texto.setTextColor(Color.GRAY);
                }
                else{
                    zlvt.setVisibility(View.VISIBLE);
                    texto = (TextView) findViewById(R.id.subestacion);
                    texto.setTextColor(Color.GREEN);
                }
            }
        });

        chillers = (CheckBox) findViewById(R.id.button07);
        chillers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zlva.getVisibility() == View.VISIBLE) {
                    zlva.setVisibility(View.GONE);
                    texto.setTextColor(Color.GRAY);
                }
                else{
                    zlva.setVisibility(View.VISIBLE);
                    texto = (TextView) findViewById(R.id.chillers);
                    texto.setTextColor(Color.GREEN);
                }
            }
        });

        bombas = (CheckBox) findViewById(R.id.button08);
        bombas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zlve.getVisibility() == View.VISIBLE) {
                    zlve.setVisibility(View.GONE);
                    texto.setTextColor(Color.GRAY);
                }
                else{
                    zlve.setVisibility(View.VISIBLE);
                    texto = (TextView) findViewById(R.id.bombas);
                    texto.setTextColor(Color.GREEN);
                }
            }
        });

        torres = (CheckBox) findViewById(R.id.button09);
        torres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zlvo.getVisibility() == View.VISIBLE) {
                    zlvo.setVisibility(View.GONE);
                    texto.setTextColor(Color.GRAY);
                }
                else{
                    zlvo.setVisibility(View.VISIBLE);
                    texto = (TextView) findViewById(R.id.torres);
                    texto.setTextColor(Color.GREEN);
                }
            }
        });

        umas = (CheckBox) findViewById(R.id.button10);
        umas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zlvp.getVisibility() == View.VISIBLE) {
                    zlvp.setVisibility(View.GONE);
                    texto.setTextColor(Color.GRAY);
                }
                else{
                    zlvp.setVisibility(View.VISIBLE);
                    texto = (TextView) findViewById(R.id.umas);
                    texto.setTextColor(Color.GREEN);
                }
            }
        });

        ups = (CheckBox) findViewById(R.id.button11);
        ups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zlvk.getVisibility() == View.VISIBLE) {
                    zlvk.setVisibility(View.GONE);
                    texto.setTextColor(Color.GRAY);
                }
                else{
                    zlvk.setVisibility(View.VISIBLE);
                    texto = (TextView) findViewById(R.id.ups);
                    texto.setTextColor(Color.GREEN);
                }
            }
        });

        ulas = (CheckBox) findViewById(R.id.button12);
        ulas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zlvc.getVisibility() == View.VISIBLE) {
                    zlvc.setVisibility(View.GONE);
                    texto.setTextColor(Color.GRAY);
                }
                else{
                    zlvc.setVisibility(View.VISIBLE);
                    texto = (TextView) findViewById(R.id.ulas);
                    texto.setTextColor(Color.GREEN);
                }
            }
        });

        minis = (CheckBox) findViewById(R.id.button13);
        minis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zlvf.getVisibility() == View.VISIBLE) {
                    zlvf.setVisibility(View.GONE);
                    texto.setTextColor(Color.GRAY);
                }
                else{
                    zlvf.setVisibility(View.VISIBLE);
                    texto = (TextView) findViewById(R.id.minis);
                    texto.setTextColor(Color.GREEN);
                }
            }
        });

        extractores = (CheckBox) findViewById(R.id.button14);
        extractores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zlvy.getVisibility() == View.VISIBLE) {
                    zlvy.setVisibility(View.GONE);
                    texto.setTextColor(Color.GRAY);
                }
                else{
                    zlvy.setVisibility(View.VISIBLE);
                    texto = (TextView) findViewById(R.id.extractores);
                    texto.setTextColor(Color.GREEN);
                }
            }
        });

        tableros = (CheckBox) findViewById(R.id.button15);
        tableros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zlvh.getVisibility() == View.VISIBLE) {
                    zlvh.setVisibility(View.GONE);
                    texto.setTextColor(Color.GRAY);
                }
                else{
                    zlvh.setVisibility(View.VISIBLE);
                    texto = (TextView) findViewById(R.id.tableros);
                    texto.setTextColor(Color.GREEN);
                }
            }
        });

        cocinas = (CheckBox) findViewById(R.id.button16);
        cocinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zlvx.getVisibility() == View.VISIBLE) {
                    zlvx.setVisibility(View.GONE);
                    texto.setTextColor(Color.GRAY);
                }
                else{
                    zlvx.setVisibility(View.VISIBLE);
                    texto = (TextView) findViewById(R.id.cocinas);
                    texto.setTextColor(Color.GREEN);
                }
            }
        });

        sanitarios = (CheckBox) findViewById(R.id.button17);
        sanitarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zlvm.getVisibility() == View.VISIBLE) {
                    zlvm.setVisibility(View.GONE);
                    texto.setTextColor(Color.GRAY);
                }
                else{
                    zlvm.setVisibility(View.VISIBLE);
                    texto = (TextView) findViewById(R.id.sanitarios);
                    texto.setTextColor(Color.GREEN);
                }
            }
        });

        check = (CheckBox) findViewById(R.id.button1);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zlvxx.getVisibility() == View.VISIBLE) {
                    zlvxx.setVisibility(View.GONE);
                    texto.setTextColor(Color.GRAY);
                }
                else{
                    zlvxx.setVisibility(View.VISIBLE);
                    texto = (TextView) findViewById(R.id.check);
                    texto.setTextColor(Color.GREEN);
                }
            }
        });

        Direccion = (CheckBox) findViewById(R.id.button18);
        Direccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zlvn.getVisibility() == View.VISIBLE) {
                    zlvn.setVisibility(View.GONE);
                    texto.setTextColor(Color.GRAY);
                }
                else{
                    zlvn.setVisibility(View.VISIBLE);
                    texto = (TextView) findViewById(R.id.direccion);
                    texto.setTextColor(Color.GREEN);
                }
            }
        });

        jefe = (CheckBox) findViewById(R.id.button19);
        jefe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zlvs.getVisibility() == View.VISIBLE) {
                    zlvs.setVisibility(View.GONE);
                    texto.setTextColor(Color.GRAY);
                }
                else{
                    zlvs.setVisibility(View.VISIBLE);
                    texto = (TextView) findViewById(R.id.jefe);
                    texto.setTextColor(Color.GREEN);
                }
            }
        });

        // botón que realiza validaciones y envia el formulario
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarFormulario();
            }
        });

        // Botones para realizar las firmas
        btnFirmaTec = (Button) findViewById(R.id.btnFirmaTec);
        btnFirmaTec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), FirmaActivity.class);
                //0 para regresar firma del responsable de sitio y 1 para regresar firmadel tecnico
                in.putExtra("FirmaDE", 0);
              //  in.putExtra("hechos", "Servicio de Mantenimiento Preventivo de " + autoCompleteEquipo.getText().toString() + " del mes "+ mes);
                startActivityForResult(in, 1);

            }
        });

        btnFirmaResp = (Button) findViewById(R.id.btnFirmaResp);
        btnFirmaResp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), FirmaActivity.class);
                in.putExtra("FirmaDE", 1);
           //     in.putExtra("hechos", "Servicio de Mantenimiento Preventivo de " + autoCompleteEquipo.getText().toString() + " del mes "+ mes);
                startActivityForResult(in, 1);

            }
        });

        // botones para tomas las evidencias fotográficas
        btncamara1 = (Button) findViewById(R.id.btnopencamara);
        btncamara1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Imagen01");
                in.putExtra("flgZona", 1);
                startActivityForResult(in, 1);
            }
        });

        btncamara2 = (Button) findViewById(R.id.btnopencamara2);
        btncamara2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =  new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                in.putExtra("numFoto", "Imagen02");
                in.putExtra("flgZona", 1);
                startActivityForResult(in, 1);
            }
        });

        btncamara3 = (Button) findViewById(R.id.btnopencamara3);
        btncamara3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                in.putExtra("numFoto", "Imagen03");
                in.putExtra("flgZona", 1);
                startActivityForResult(in, 1);
            }
        });
        btncamara4 = (Button) findViewById(R.id.btnopencamara4);
        btncamara4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                in.putExtra("numFoto", "Imagen04");
                in.putExtra("flgZona", 1);
                startActivityForResult(in, 1);
            }
        });
        btncamara5 = (Button) findViewById(R.id.btnopencamara5);
        btncamara5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                in.putExtra("numFoto", "Imagen05");
                in.putExtra("flgZona", 1);
                startActivityForResult(in, 1);
            }
        });
        btncamara6 = (Button) findViewById(R.id.btnopencamara6);
        btncamara6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Imagen06");
                in.putExtra("flgZona", 2);
                startActivityForResult(in, 1);
            }
        });
        btncamara7 = (Button) findViewById(R.id.btnopencamara7);
        btncamara7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                in.putExtra("numFoto", "Imagen07");
                in.putExtra("flgZona", 2);
                startActivityForResult(in, 1);
            }
        });
        btncamara8 = (Button) findViewById(R.id.btnopencamara8);
        btncamara8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                in.putExtra("numFoto", "Imagen08");
                in.putExtra("flgZona", 2);
                startActivityForResult(in, 1);
            }
        });
        btncamara9 = (Button) findViewById(R.id.btnopencamara9);
        btncamara9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                in.putExtra("numFoto", "Imagen09");
                in.putExtra("flgZona", 2);
                startActivityForResult(in, 1);
            }
        });
        btncamara10 = (Button) findViewById(R.id.btnopencamara10);
        btncamara10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                in.putExtra("numFoto", "Imagen10");
                in.putExtra("flgZona", 2);
                startActivityForResult(in, 1);
            }
        });
        btncamara11 = (Button) findViewById(R.id.btnopencamara11);
        btncamara11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Imagen11");
                in.putExtra("flgZona", 3);
                startActivityForResult(in, 1);
            }
        });
        btncamara12 = (Button) findViewById(R.id.btnopencamara12);
        btncamara12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                in.putExtra("numFoto", "Imagen12");
                in.putExtra("flgZona", 3);
                startActivityForResult(in, 1);
            }
        });
        btncamara13 = (Button) findViewById(R.id.btnopencamara13);
        btncamara13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                in.putExtra("numFoto", "Imagen13");
                in.putExtra("flgZona", 3);
                startActivityForResult(in, 1);
            }
        });
        btncamara14 = (Button) findViewById(R.id.btnopencamara14);
        btncamara14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                in.putExtra("numFoto", "Imagen14");
                in.putExtra("flgZona", 3);
                startActivityForResult(in, 1);
            }
        });
        btncamara15 = (Button) findViewById(R.id.btnopencamara15);
        btncamara15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                in.putExtra("numFoto", "Imagen15");
                in.putExtra("flgZona", 3);
                startActivityForResult(in, 1);
            }
        });
        btncamara16 = (Button) findViewById(R.id.btnopencamara16);
        btncamara16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Imagen16");
                in.putExtra("flgZona", 4);
                startActivityForResult(in, 1);
            }
        });
        btncamara17 = (Button) findViewById(R.id.btnopencamara17);
        btncamara17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                in.putExtra("numFoto", "Imagen17");
                in.putExtra("flgZona", 4);
                startActivityForResult(in, 1);
            }
        });
        btncamara18 = (Button) findViewById(R.id.btnopencamara18);
        btncamara18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                in.putExtra("numFoto", "Imagen18");
                in.putExtra("flgZona", 4);
                startActivityForResult(in, 1);
            }
        });
        btncamara19 = (Button) findViewById(R.id.btnopencamara19);
        btncamara19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                in.putExtra("numFoto", "Imagen19");
                in.putExtra("flgZona", 4);
                startActivityForResult(in, 1);
            }
        });
        btncamara20 = (Button) findViewById(R.id.btnopencamara20);
        btncamara20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                in.putExtra("numFoto", "Imagen20");
                in.putExtra("flgZona", 4);
                startActivityForResult(in, 1);
            }
        });
        btncamara21 = (Button) findViewById(R.id.btnopencamara21);
        btncamara21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Imagen21");
                in.putExtra("flgZona", 5);
                startActivityForResult(in, 1);
            }
        });
        btncamara22 = (Button) findViewById(R.id.btnopencamara22);
        btncamara22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                in.putExtra("numFoto", "Imagen22");
                in.putExtra("flgZona", 5);
                startActivityForResult(in, 1);
            }
        });
        btncamara23 = (Button) findViewById(R.id.btnopencamara23);
        btncamara23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                in.putExtra("numFoto", "Imagen23");
                in.putExtra("flgZona", 5);
                startActivityForResult(in, 1);
            }
        });
        btncamara24 = (Button) findViewById(R.id.btnopencamara24);
        btncamara24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                in.putExtra("numFoto", "Imagen24");
                in.putExtra("flgZona", 5);
                startActivityForResult(in, 1);
            }
        });
        btncamara25 = (Button) findViewById(R.id.btnopencamara25);
        btncamara25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                in.putExtra("numFoto", "Imagen25");
                in.putExtra("flgZona", 5);
                startActivityForResult(in, 1);
            }
        });
        btncamara26 = (Button) findViewById(R.id.btnopencamara26);
        btncamara26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Imagen26");
                in.putExtra("flgZona", 6);
                startActivityForResult(in, 1);
            }
        });
        btncamara27 = (Button) findViewById(R.id.btnopencamara27);
        btncamara27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                in.putExtra("numFoto", "Imagen27");
                in.putExtra("flgZona", 6);
                startActivityForResult(in, 1);
            }
        });
        btncamara28 = (Button) findViewById(R.id.btnopencamara28);
        btncamara28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                in.putExtra("numFoto", "Imagen28");
                in.putExtra("flgZona", 6);
                startActivityForResult(in, 1);
            }
        });
        btncamara29 = (Button) findViewById(R.id.btnopencamara29);
        btncamara29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                in.putExtra("numFoto", "Imagen29");
                in.putExtra("flgZona", 6);
                startActivityForResult(in, 1);
            }
        });
        btncamara30 = (Button) findViewById(R.id.btnopencamara30);
        btncamara30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                in.putExtra("numFoto", "Imagen30");
                in.putExtra("flgZona", 6);
                startActivityForResult(in, 1);
            }
        });
        btncamara31 = (Button) findViewById(R.id.btnopencamara31);
        btncamara31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Imagen31");
                in.putExtra("flgZona", 7);
                startActivityForResult(in, 1);
            }
        });
        btncamara32 = (Button) findViewById(R.id.btnopencamara32);
        btncamara32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                in.putExtra("numFoto", "Imagen32");
                in.putExtra("flgZona", 7);
                startActivityForResult(in, 1);
            }
        });
        btncamara33 = (Button) findViewById(R.id.btnopencamara33);
        btncamara33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                in.putExtra("numFoto", "Imagen33");
                in.putExtra("flgZona", 7);
                startActivityForResult(in, 1);
            }
        });
        btncamara34 = (Button) findViewById(R.id.btnopencamara34);
        btncamara34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                in.putExtra("numFoto", "Imagen34");
                in.putExtra("flgZona", 7);
                startActivityForResult(in, 1);
            }
        });
        btncamara35 = (Button) findViewById(R.id.btnopencamara35);
        btncamara35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                in.putExtra("numFoto", "Imagen35");
                in.putExtra("flgZona", 7);
                startActivityForResult(in, 1);
            }
        });
        btncamara36 = (Button) findViewById(R.id.btnopencamara36);
        btncamara36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Imagen36");
                in.putExtra("flgZona", 8);
                startActivityForResult(in, 1);
            }
        });
        btncamara37 = (Button) findViewById(R.id.btnopencamara37);
        btncamara37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                in.putExtra("numFoto", "Imagen37");
                in.putExtra("flgZona", 8);
                startActivityForResult(in, 1);
            }
        });
        btncamara38 = (Button) findViewById(R.id.btnopencamara38);
        btncamara38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                in.putExtra("numFoto", "Imagen38");
                in.putExtra("flgZona", 8);
                startActivityForResult(in, 1);
            }
        });
        btncamara39 = (Button) findViewById(R.id.btnopencamara39);
        btncamara39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                in.putExtra("numFoto", "Imagen39");
                in.putExtra("flgZona", 8);
                startActivityForResult(in, 1);
            }
        });
        btncamara40 = (Button) findViewById(R.id.btnopencamara40);
        btncamara40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                in.putExtra("numFoto", "Imagen40");
                in.putExtra("flgZona", 8);
                startActivityForResult(in, 1);
            }
        });
        btncamara41 = (Button) findViewById(R.id.btnopencamara41);
        btncamara41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Imagen41");
                in.putExtra("flgZona", 9);
                startActivityForResult(in, 1);
            }
        });
        btncamara42 = (Button) findViewById(R.id.btnopencamara42);
        btncamara42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                in.putExtra("numFoto", "Imagen42");
                in.putExtra("flgZona", 9);
                startActivityForResult(in, 1);
            }
        });
        btncamara43 = (Button) findViewById(R.id.btnopencamara43);
        btncamara43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                in.putExtra("numFoto", "Imagen43");
                in.putExtra("flgZona", 9);
                startActivityForResult(in, 1);
            }
        });
        btncamara44 = (Button) findViewById(R.id.btnopencamara44);
        btncamara44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                in.putExtra("numFoto", "Imagen44");
                in.putExtra("flgZona", 9);
                startActivityForResult(in, 1);
            }
        });
        btncamara45 = (Button) findViewById(R.id.btnopencamara45);
        btncamara45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                in.putExtra("numFoto", "Imagen45");
                in.putExtra("flgZona", 9);
                startActivityForResult(in, 1);
            }
        });
        btncamara46 = (Button) findViewById(R.id.btnopencamara46);
        btncamara46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Imagen46");
                in.putExtra("flgZona", 10);
                startActivityForResult(in, 1);
            }
        });
        btncamara47 = (Button) findViewById(R.id.btnopencamara47);
        btncamara47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                in.putExtra("numFoto", "Imagen47");
                in.putExtra("flgZona", 10);
                startActivityForResult(in, 1);
            }
        });
        btncamara48 = (Button) findViewById(R.id.btnopencamara48);
        btncamara48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                in.putExtra("numFoto", "Imagen48");
                in.putExtra("flgZona", 10);
                startActivityForResult(in, 1);
            }
        });
        btncamara49 = (Button) findViewById(R.id.btnopencamara49);
        btncamara49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                in.putExtra("numFoto", "Imagen49");
                in.putExtra("flgZona", 10);
                startActivityForResult(in, 1);
            }
        });
        btncamara50 = (Button) findViewById(R.id.btnopencamara50);
        btncamara50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                in.putExtra("numFoto", "Imagen50");
                in.putExtra("flgZona", 10);
                startActivityForResult(in, 1);
            }
        });
        btncamara51 = (Button) findViewById(R.id.btnopencamara51);
        btncamara51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Imagen51");
                in.putExtra("flgZona", 11);
                startActivityForResult(in, 1);
            }
        });
        btncamara52 = (Button) findViewById(R.id.btnopencamara52);
        btncamara52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                in.putExtra("numFoto", "Imagen52");
                in.putExtra("flgZona", 11);
                startActivityForResult(in, 1);
            }
        });
        btncamara53 = (Button) findViewById(R.id.btnopencamara53);
        btncamara53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                in.putExtra("numFoto", "Imagen53");
                in.putExtra("flgZona", 11);
                startActivityForResult(in, 1);
            }
        });
        btncamara54 = (Button) findViewById(R.id.btnopencamara54);
        btncamara54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                in.putExtra("numFoto", "Imagen54");
                in.putExtra("flgZona", 11);
                startActivityForResult(in, 1);
            }
        });
        btncamara55 = (Button) findViewById(R.id.btnopencamara55);
        btncamara55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                in.putExtra("numFoto", "Imagen55");
                in.putExtra("flgZona", 11);
                startActivityForResult(in, 1);
            }
        });
        btncamara56 = (Button) findViewById(R.id.btnopencamara56);
        btncamara56.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Imagen56");
                in.putExtra("flgZona", 12);
                startActivityForResult(in, 1);
            }
        });
        btncamara57 = (Button) findViewById(R.id.btnopencamara57);
        btncamara57.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                in.putExtra("numFoto", "Imagen57");
                in.putExtra("flgZona", 12);
                startActivityForResult(in, 1);
            }
        });
        btncamara58 = (Button) findViewById(R.id.btnopencamara58);
        btncamara58.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                in.putExtra("numFoto", "Imagen58");
                in.putExtra("flgZona", 12);
                startActivityForResult(in, 1);
            }
        });
        btncamara59 = (Button) findViewById(R.id.btnopencamara59);
        btncamara59.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                in.putExtra("numFoto", "Imagen59");
                in.putExtra("flgZona", 12);
                startActivityForResult(in, 1);
            }
        });
        btncamara60 = (Button) findViewById(R.id.btnopencamara60);
        btncamara60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                in.putExtra("numFoto", "Imagen60");
                in.putExtra("flgZona", 12);
                startActivityForResult(in, 1);
            }
        });
        btncamara61 = (Button) findViewById(R.id.btnopencamara61);
        btncamara61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Imagen61");
                in.putExtra("flgZona", 13);
                startActivityForResult(in, 1);
            }
        });
        btncamara62 = (Button) findViewById(R.id.btnopencamara62);
        btncamara62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                in.putExtra("numFoto", "Imagen62");
                in.putExtra("flgZona", 13);
                startActivityForResult(in, 1);
            }
        });
        btncamara63 = (Button) findViewById(R.id.btnopencamara63);
        btncamara63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                in.putExtra("numFoto", "Imagen63");
                in.putExtra("flgZona", 13);
                startActivityForResult(in, 1);
            }
        });
        btncamara64 = (Button) findViewById(R.id.btnopencamara64);
        btncamara64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                in.putExtra("numFoto", "Imagen64");
                in.putExtra("flgZona", 13);
                startActivityForResult(in, 1);
            }
        });
        btncamara65 = (Button) findViewById(R.id.btnopencamara65);
        btncamara65.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                in.putExtra("numFoto", "Imagen65");
                in.putExtra("flgZona", 13);
                startActivityForResult(in, 1);
            }
        });
        btncamara66 = (Button) findViewById(R.id.btnopencamara66);
        btncamara66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Imagen66");
                in.putExtra("flgZona", 14);
                startActivityForResult(in, 1);
            }
        });
        btncamara67 = (Button) findViewById(R.id.btnopencamara67);
        btncamara67.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                in.putExtra("numFoto", "Imagen67");
                in.putExtra("flgZona", 14);
                startActivityForResult(in, 1);
            }
        });
        btncamara68 = (Button) findViewById(R.id.btnopencamara68);
        btncamara68.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                in.putExtra("numFoto", "Imagen68");
                in.putExtra("flgZona", 14);
                startActivityForResult(in, 1);
            }
        });
        btncamara69 = (Button) findViewById(R.id.btnopencamara69);
        btncamara69.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                in.putExtra("numFoto", "Imagen69");
                in.putExtra("flgZona", 14);
                startActivityForResult(in, 1);
            }
        });
        btncamara70 = (Button) findViewById(R.id.btnopencamara70);
        btncamara70.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                in.putExtra("numFoto", "Imagen70");
                in.putExtra("flgZona", 14);
                startActivityForResult(in, 1);
            }
        });
        btncamara71 = (Button) findViewById(R.id.btnopencamara71);
        btncamara71.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Imagen71");
                in.putExtra("flgZona", 15);
                startActivityForResult(in, 1);
            }
        });
        btncamara72 = (Button) findViewById(R.id.btnopencamara72);
        btncamara72.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                in.putExtra("numFoto", "Imagen72");
                in.putExtra("flgZona", 15);
                startActivityForResult(in, 1);
            }
        });
        btncamara73 = (Button) findViewById(R.id.btnopencamara73);
        btncamara73.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                in.putExtra("numFoto", "Imagen73");
                in.putExtra("flgZona", 15);
                startActivityForResult(in, 1);
            }
        });
        btncamara74 = (Button) findViewById(R.id.btnopencamara74);
        btncamara74.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                in.putExtra("numFoto", "Imagen74");
                in.putExtra("flgZona", 15);
                startActivityForResult(in, 1);
            }
        });
        btncamara75 = (Button) findViewById(R.id.btnopencamara75);
        btncamara75.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                in.putExtra("numFoto", "Imagen75");
                in.putExtra("flgZona", 15);
                startActivityForResult(in, 1);
            }
        });
        btncamara76 = (Button) findViewById(R.id.btnopencamara76);
        btncamara76.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Imagen76");
                in.putExtra("flgZona", 16);
                startActivityForResult(in, 1);
            }
        });
        btncamara77 = (Button) findViewById(R.id.btnopencamara77);
        btncamara77.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                in.putExtra("numFoto", "Imagen77");
                in.putExtra("flgZona", 16);
                startActivityForResult(in, 1);
            }
        });
        btncamara78 = (Button) findViewById(R.id.btnopencamara78);
        btncamara78.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                in.putExtra("numFoto", "Imagen78");
                in.putExtra("flgZona", 16);
                startActivityForResult(in, 1);
            }
        });
        btncamara79 = (Button) findViewById(R.id.btnopencamara79);
        btncamara79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                in.putExtra("numFoto", "Imagen79");
                in.putExtra("flgZona", 16);
                startActivityForResult(in, 1);
            }
        });
        btncamara80 = (Button) findViewById(R.id.btnopencamara80);
        btncamara80.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                in.putExtra("numFoto", "Imagen80");
                in.putExtra("flgZona", 16);
                startActivityForResult(in, 1);
            }
        });
        btncamara81 = (Button) findViewById(R.id.btnopencamara81);
        btncamara81.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Imagen81");
                in.putExtra("flgZona", 17);
                startActivityForResult(in, 1);
            }
        });
        btncamara82 = (Button) findViewById(R.id.btnopencamara82);
        btncamara82.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                in.putExtra("numFoto", "Imagen82");
                in.putExtra("flgZona", 17);
                startActivityForResult(in, 1);
            }
        });
        btncamara83 = (Button) findViewById(R.id.btnopencamara83);
        btncamara83.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                in.putExtra("numFoto", "Imagen83");
                in.putExtra("flgZona", 17);
                startActivityForResult(in, 1);
            }
        });
        btncamara84 = (Button) findViewById(R.id.btnopencamara84);
        btncamara84.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                in.putExtra("numFoto", "Imagen84");
                in.putExtra("flgZona", 17);
                startActivityForResult(in, 1);
            }
        });
        btncamara85 = (Button) findViewById(R.id.btnopencamara85);
        btncamara85.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                in.putExtra("numFoto", "Imagen85");
                in.putExtra("flgZona", 17);
                startActivityForResult(in, 1);
            }
        });
        btncamara86 = (Button) findViewById(R.id.btnopencamara86);
        btncamara86.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Imagen86");
                in.putExtra("flgZona", 18);
                startActivityForResult(in, 1);
            }
        });
        btncamara87 = (Button) findViewById(R.id.btnopencamara87);
        btncamara87.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                in.putExtra("numFoto", "Imagen87");
                in.putExtra("flgZona", 18);
                startActivityForResult(in, 1);
            }
        });
        btncamara88 = (Button) findViewById(R.id.btnopencamara88);
        btncamara88.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                in.putExtra("numFoto", "Imagen88");
                in.putExtra("flgZona", 18);
                startActivityForResult(in, 1);
            }
        });
        btncamara89 = (Button) findViewById(R.id.btnopencamara89);
        btncamara89.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                in.putExtra("numFoto", "Imagen89");
                in.putExtra("flgZona", 18);
                startActivityForResult(in, 1);
            }
        });
        btncamara90 = (Button) findViewById(R.id.btnopencamara90);
        btncamara90.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                in.putExtra("numFoto", "Imagen90");
                in.putExtra("flgZona", 18);
                startActivityForResult(in, 1);
            }
        });
    }

    private BroadcastReceiver networkStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo ni = manager.getActiveNetworkInfo();
            onNetworkChange(ni);
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        registerReceiver(networkStateReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    public void onPause() {
        unregisterReceiver(networkStateReceiver);
        super.onPause();
    }

    private void onNetworkChange(NetworkInfo networkInfo) {
        if (networkInfo != null) {
            if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                Log.d("Form_auditoria", "CONNECTED");
            } else {
                Log.d("Form_auditoria", "DISCONNECTED");
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
                if (firmaTec != "" && firmanteTec !="" ){
                    btnFirmaTec.setEnabled(false);
                }
            } else if ("vacio".equals(data.getStringExtra("FirmaTEC"))) {
                firmaResp = data.getStringExtra("FirmaRESP");
                firmanteResp = data.getStringExtra("NombreResp");
                if (firmaResp != "" && firmanteResp !=""){
                    btnFirmaResp.setEnabled(false);
                }
            }

            if ("vacio".equals(data.getStringExtra("FotoDos")) && "vacio".equals(data.getStringExtra("FotoTres"))
                    && "vacio".equals(data.getStringExtra("FotoCuatro")) && "vacio".equals(data.getStringExtra("FotoCnco")))
            {
                imagenString = convertirimagen(data.getStringExtra("FotoUno"));
                fotosg.add(data.getStringExtra("numFoto") + ":" + data.getStringExtra("FotoUno"));
                fotos.add(data.getStringExtra("numFoto") + ":" + imagenString);
                DisabledButtonCam(data.getStringExtra("numFoto"));

            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoTres"))
                    && "vacio".equals(data.getStringExtra("FotoCuatro")) && "vacio".equals(data.getStringExtra("FotoCnco")))
            {
                imagenString = convertirimagen(data.getStringExtra("FotoDos"));
                fotosg.add(data.getStringExtra("numFoto") + ":" + data.getStringExtra("FotoDos"));
                fotos.add( data.getStringExtra("numFoto") + ":" + imagenString);
                DisabledButtonCam(data.getStringExtra("numFoto"));

            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoDos"))
                    && "vacio".equals(data.getStringExtra("FotoCuatro")) && "vacio".equals(data.getStringExtra("FotoCnco")))
            {
                imagenString = convertirimagen(data.getStringExtra("FotoTres"));
                fotosg.add(data.getStringExtra("numFoto") + ":" + data.getStringExtra("FotoTres"));
                fotos.add( data.getStringExtra("numFoto") + ":" + imagenString);
                DisabledButtonCam(data.getStringExtra("numFoto"));

            }else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoDos"))
                    && "vacio".equals(data.getStringExtra("FotoTres")) && "vacio".equals(data.getStringExtra("FotoCnco")))
            {
                imagenString = convertirimagen(data.getStringExtra("FotoCuatro"));
                fotosg.add(data.getStringExtra("numFoto") + ":" + data.getStringExtra("FotoCuatro"));
                fotos.add( data.getStringExtra("numFoto") + ":" + imagenString);
                DisabledButtonCam(data.getStringExtra("numFoto"));

            }else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoDos"))
                    &&"vacio".equals(data.getStringExtra("FotoTres")) && "vacio".equals(data.getStringExtra("FotoCuatro")))
            {
                imagenString = convertirimagen(data.getStringExtra("FotoCnco"));
                fotosg.add(data.getStringExtra("numFoto") + ":" + data.getStringExtra("FotoCnco"));
                fotos.add( data.getStringExtra("numFoto") + ":" + imagenString);
                DisabledButtonCam(data.getStringExtra("numFoto"));
            }

            if(data.getIntExtra("flgZona", 0) == 1)
            {
                ffEsc = true;
            }
            else if(data.getIntExtra("flgZona", 0) == 2)
            {
                ffEle = true;
            }
            else if(data.getIntExtra("flgZona", 0) == 3)
            {
                ffMon = true;
            }
            else if(data.getIntExtra("flgZona", 0) == 4)
            {
                ffBCI = true;
            }
            else if(data.getIntExtra("flgZona", 0) == 5)
            {
                ffPEM = true;
            }
            else if(data.getIntExtra("flgZona", 0) == 6)
            {
                ffSube = true;
            }
            else if(data.getIntExtra("flgZona", 0) == 7)
            {
                ffChill = true;
            }
            else if(data.getIntExtra("flgZona", 0) == 8)
            {
                ffBom = true;
            }
            else if(data.getIntExtra("flgZona", 0) == 9)
            {
                ffTorres = true;
            }
            else if(data.getIntExtra("flgZona", 0) == 10)
            {
                ffUMAs = true;
            }
            else if(data.getIntExtra("flgZona", 0) == 11)
            {
                ffUPs = true;
            }
            else if(data.getIntExtra("flgZona", 0) == 12)
            {
                ffULAs = true;
            }
            else if(data.getIntExtra("flgZona", 0) == 13)
            {
                ffMini = true;
            }
            else if(data.getIntExtra("flgZona", 0) == 14)
            {
                ffExtrac = true;
            }
            else if(data.getIntExtra("flgZona", 0) == 15)
            {
                ffTableros = true;
            }
            else if(data.getIntExtra("flgZona", 0) == 16)
            {
                ffCocinas = true;
            }
            else if(data.getIntExtra("flgZona", 0) == 17)
            {
                ffSanitarios = true;
            }
            else if(data.getIntExtra("flgZona", 0) == 18)
            {
                ffchecklist = true;
            }
        }
    }

    private  void DisabledButtonCam(String numFoto){
        if(numFoto.equals("Imagen01")){
            btncamara1.setEnabled(false);
        }
        else if(numFoto.equals("Imagen02")){
            btncamara2.setEnabled(false);
        }
        else if(numFoto.equals("Imagen03")){
            btncamara3.setEnabled(false);
        }
        else if(numFoto.equals("Imagen04")){
            btncamara4.setEnabled(false);
        }
        else if(numFoto.equals("Imagen05")){
            btncamara5.setEnabled(false);
        }
        else if(numFoto.equals("Imagen06")){
            btncamara6.setEnabled(false);
        }
        else if(numFoto.equals("Imagen07")){
            btncamara7.setEnabled(false);
        }
        else if(numFoto.equals("Imagen08")){
            btncamara8.setEnabled(false);
        }
        else if(numFoto.equals("Imagen09")){
            btncamara9.setEnabled(false);
        }
        else if(numFoto.equals("Imagen10")){
            btncamara10.setEnabled(false);
        }
        else if(numFoto.equals("Imagen11")){
            btncamara11.setEnabled(false);
        }
        else if(numFoto.equals("Imagen12")){
            btncamara12.setEnabled(false);
        }
        else if(numFoto.equals("Imagen13")){
            btncamara13.setEnabled(false);
        }
        else if(numFoto.equals("Imagen14")){
            btncamara14.setEnabled(false);
        }
        else if(numFoto.equals("Imagen15")){
            btncamara15.setEnabled(false);
        }
        else if(numFoto.equals("Imagen16")){
            btncamara16.setEnabled(false);
        }
        else if(numFoto.equals("Imagen17")){
            btncamara17.setEnabled(false);
        }
        else if(numFoto.equals("Imagen18")){
            btncamara18.setEnabled(false);
        }
        else if(numFoto.equals("Imagen19")){
            btncamara19.setEnabled(false);
        }
        else if(numFoto.equals("Imagen20")){
            btncamara20.setEnabled(false);
        }
        else if(numFoto.equals("Imagen21")){
            btncamara21.setEnabled(false);
        }
        else if(numFoto.equals("Imagen22")){
            btncamara22.setEnabled(false);
        }
        else if(numFoto.equals("Imagen23")){
            btncamara23.setEnabled(false);
        }
        else if(numFoto.equals("Imagen24")){
            btncamara24.setEnabled(false);
        }
        else if(numFoto.equals("Imagen25")){
            btncamara25.setEnabled(false);
        }
        else if(numFoto.equals("Imagen26")){
            btncamara26.setEnabled(false);
        }
        else if(numFoto.equals("Imagen27")){
            btncamara27.setEnabled(false);
        }
        else if(numFoto.equals("Imagen28")){
            btncamara28.setEnabled(false);
        }
        else if(numFoto.equals("Imagen29")){
            btncamara29.setEnabled(false);
        }
        else if(numFoto.equals("Imagen30")){
            btncamara30.setEnabled(false);
        }
        else if(numFoto.equals("Imagen31")){
            btncamara31.setEnabled(false);
        }
        else if(numFoto.equals("Imagen32")){
            btncamara32.setEnabled(false);
        }
        else if(numFoto.equals("Imagen33")){
            btncamara33.setEnabled(false);
        }
        else if(numFoto.equals("Imagen34")){
            btncamara34.setEnabled(false);
        }
        else if(numFoto.equals("Imagen35")){
            btncamara35.setEnabled(false);
        }
        else if(numFoto.equals("Imagen36")){
            btncamara36.setEnabled(false);
        }
        else if(numFoto.equals("Imagen37")){
            btncamara37.setEnabled(false);
        }
        else if(numFoto.equals("Imagen38")){
            btncamara38.setEnabled(false);
        }
        else if(numFoto.equals("Imagen39")){
            btncamara39.setEnabled(false);
        }
        else if(numFoto.equals("Imagen40")){
            btncamara40.setEnabled(false);
        }
        else if(numFoto.equals("Imagen41")){
            btncamara41.setEnabled(false);
        }
        else if(numFoto.equals("Imagen42")){
            btncamara42.setEnabled(false);
        }
        else if(numFoto.equals("Imagen43")){
            btncamara43.setEnabled(false);
        }
        else if(numFoto.equals("Imagen44")){
            btncamara44.setEnabled(false);
        }
        else if(numFoto.equals("Imagen45")){
            btncamara45.setEnabled(false);
        }
        else if(numFoto.equals("Imagen46")){
            btncamara46.setEnabled(false);
        }
        else if(numFoto.equals("Imagen47")){
            btncamara47.setEnabled(false);
        }
        else if(numFoto.equals("Imagen48")){
            btncamara48.setEnabled(false);
        }
        else if(numFoto.equals("Imagen49")){
            btncamara49.setEnabled(false);
        }
        else if(numFoto.equals("Imagen50")){
            btncamara50.setEnabled(false);
        }
        else if(numFoto.equals("Imagen51")){
            btncamara51.setEnabled(false);
        }
        else if(numFoto.equals("Imagen52")){
            btncamara52.setEnabled(false);
        }
        else if(numFoto.equals("Imagen53")){
            btncamara53.setEnabled(false);
        }
        else if(numFoto.equals("Imagen54")){
            btncamara54.setEnabled(false);
        }
        else if(numFoto.equals("Imagen55")){
            btncamara55.setEnabled(false);
        }
        else if(numFoto.equals("Imagen56")){
            btncamara56.setEnabled(false);
        }
        else if(numFoto.equals("Imagen57")){
            btncamara57.setEnabled(false);
        }
        else if(numFoto.equals("Imagen58")){
            btncamara58.setEnabled(false);
        }
        else if(numFoto.equals("Imagen59")){
            btncamara59.setEnabled(false);
        }
        else if(numFoto.equals("Imagen60")){
            btncamara60.setEnabled(false);
        }
        else if(numFoto.equals("Imagen61")){
            btncamara61.setEnabled(false);
        }
        else if(numFoto.equals("Imagen62")){
            btncamara62.setEnabled(false);
        }
        else if(numFoto.equals("Imagen63")){
            btncamara63.setEnabled(false);
        }
        else if(numFoto.equals("Imagen64")){
            btncamara64.setEnabled(false);
        }
        else if(numFoto.equals("Imagen65")){
            btncamara65.setEnabled(false);
        }
        else if(numFoto.equals("Imagen66")){
            btncamara66.setEnabled(false);
        }
        else if(numFoto.equals("Imagen67")){
            btncamara67.setEnabled(false);
        }
        else if(numFoto.equals("Imagen68")){
            btncamara68.setEnabled(false);
        }
        else if(numFoto.equals("Imagen69")){
            btncamara69.setEnabled(false);
        }
        else if(numFoto.equals("Imagen70")){
            btncamara70.setEnabled(false);
        }
        else if(numFoto.equals("Imagen71")){
            btncamara71.setEnabled(false);
        }
        else if(numFoto.equals("Imagen72")){
            btncamara72.setEnabled(false);
        }
        else if(numFoto.equals("Imagen73")){
            btncamara73.setEnabled(false);
        }
        else if(numFoto.equals("Imagen74")){
            btncamara74.setEnabled(false);
        }
        else if(numFoto.equals("Imagen75")){
            btncamara75.setEnabled(false);
        }
        else if(numFoto.equals("Imagen76")){
            btncamara76.setEnabled(false);
        }
        else if(numFoto.equals("Imagen77")){
            btncamara77.setEnabled(false);
        }
        else if(numFoto.equals("Imagen78")){
            btncamara78.setEnabled(false);
        }
        else if(numFoto.equals("Imagen79")){
            btncamara79.setEnabled(false);
        }
        else if(numFoto.equals("Imagen80")){
            btncamara80.setEnabled(false);
        }
        else if(numFoto.equals("Imagen81")){
            btncamara81.setEnabled(false);
        }
        else if(numFoto.equals("Imagen82")){
            btncamara82.setEnabled(false);
        }
        else if(numFoto.equals("Imagen83")){
            btncamara83.setEnabled(false);
        }
        else if(numFoto.equals("Imagen84")){
            btncamara84.setEnabled(false);
        }
        else if(numFoto.equals("Imagen85")){
            btncamara85.setEnabled(false);
        }
        else if(numFoto.equals("Imagen86")){
            btncamara86.setEnabled(false);
        }
        else if(numFoto.equals("Imagen87")){
            btncamara87.setEnabled(false);
        }
        else if(numFoto.equals("Imagen88")){
            btncamara88.setEnabled(false);
        }
        else if(numFoto.equals("Imagen89")){
            btncamara89.setEnabled(false);
        }
        else if(numFoto.equals("Imagen90")){
            btncamara90.setEnabled(false);
        }
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

    //Envia la información del fromulario a la BD y C#
    private void enviarFormulario() {
        // Banderas de validaciones por zona
        zonas = "";
        fEsc = false;
        fEle = false;
        fMon = false;
        fBCI = false;
        fPEM = false;
        fSube = false;
        fChill = false;
        fBom = false;
        fTorres = false;
        fUMAs = false;
        fUPs = false;
        fULAs = false;
        fMini = false;
        fExtrac = false;
        fTableros = false;
        fCocinas = false;
        fSanitarios = false;
        fDireccion = false;
        fJefe = false;
        fchecklist = false;

        // Llenado de conceptos seleccionados
        partida_concepto = addEscalerasButton();
        partida_concepto += addElevadoresButton();
        partida_concepto += addMontacargasButton();
        partida_concepto += addBCIButton();
        partida_concepto += addPemButton();
        partida_concepto += addSubestacionButton();
        partida_concepto += addChellersButton();
        partida_concepto += addBombasButton();
        partida_concepto += addTorresButton();
        partida_concepto += addCheckButton();
        addZonasButton();

        if (partida_concepto == "") {
            Toast.makeText(this, "No has seleccionado ninguna opción, el formulario no se envío", Toast.LENGTH_SHORT).show();
        }
        else if(fEsc && detalles.getText().length() == 0){
            Toast.makeText(this, "El campo de observaciones para la zona ETM - Escaleras no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fEsc && peticiones.getText().length() == 0){
            Toast.makeText(this, "El campo de peticiones para la zona ETM - Escaleras no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else  if(fEsc && !ffEsc) {
            Toast.makeText(this, "Se requiere 1 foto obligatoria en la zona ETM - Escaleras", Toast.LENGTH_SHORT).show();
        }
        else if(fEle && detalles1.getText().length() == 0){
            Toast.makeText(this, "El campo de observaciones para la zona ETM - Elevadores no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fEle && peticiones1.getText().length() == 0){
            Toast.makeText(this, "El campo de peticiones para la zona ETM - Elevadores no puede quedar vacía.", Toast.LENGTH_LONG).show();

        }
        else if(fEle && !ffEle) {
            Toast.makeText(this, "Se requiere 1 foto obligatoria en la zona ETM - Elevadores", Toast.LENGTH_SHORT).show();

        }
        else if(fMon && detalles2.getText().length() == 0){
            Toast.makeText(this, "El campo deobservaciones para la zona ETM - Montacargas no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fMon && peticiones2.getText().length() == 0){
            Toast.makeText(this, "El campo de peticiones para la zona ETM - Montacargas no puede quedar vacía.", Toast.LENGTH_LONG).show();

        }
        else if(fMon && !ffMon) {
            Toast.makeText(this, "Se requiere 1 foto obligatoria en la zona ETM -Montacargas", Toast.LENGTH_SHORT).show();
        }
        else if(fBCI && detalles3.getText().length() == 0){
            Toast.makeText(this, "El campo de observaciones para la zona BCI no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fBCI && peticiones3.getText().length() == 0){
            Toast.makeText(this, "El campo de peticiones para la zona BCI no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fBCI && !ffBCI) {
            Toast.makeText(this, "Se requiere 1 foto obligatoria en la zona BCI", Toast.LENGTH_SHORT).show();
        }
        else if(fPEM && detalles4.getText().length() == 0){
            Toast.makeText(this, "El campo de observaciones para la zona PEM no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fPEM && peticiones4.getText().length() == 0){
            Toast.makeText(this, "El campo de peticiones para la zona PEM no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fPEM && !ffPEM) {
            Toast.makeText(this, "Se requiere 1 foto obligatoria en la zona PEM", Toast.LENGTH_SHORT).show();
        }
        else if(fSube && detalles5.getText().length() == 0){
            Toast.makeText(this, "El campo de observaciones para la zona Subestación no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fSube && peticiones5.getText().length() == 0){
            Toast.makeText(this, "El campo de peticiones para la zona Subestación no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fSube && !ffSube) {
            Toast.makeText(this, "Se requiere 1 foto obligatoria en la zona Subestación", Toast.LENGTH_SHORT).show();
        }
        else if(fChill && detalles6.getText().length() == 0){
            Toast.makeText(this, "El campo de observaciones para la zona Chillers no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fChill && peticiones6.getText().length() == 0){
            Toast.makeText(this, "El campo de peticiones para la zona Chillers no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fChill && !ffChill) {
            Toast.makeText(this, "Se requiere 1 foto obligatoria en la zona Chillers", Toast.LENGTH_SHORT).show();
        }
        else if(fBom && detalles7.getText().length() == 0){
            Toast.makeText(this, "El campo de observaciones para la zona Bombas de agua helada no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fBom && peticiones7.getText().length() == 0){
            Toast.makeText(this, "El campo de peticiones para la zona Bombas de agua helada no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fBom && !ffBom) {
            Toast.makeText(this, "Se requiere 1 foto obligatoria en la zona Bombas de agua helada", Toast.LENGTH_SHORT).show();
        }
        else if(fTorres && detalles8.getText().length() == 0){
            Toast.makeText(this, "El campo de observaciones para la zona Torres de enfriamento no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fTorres && peticiones8.getText().length() == 0){
            Toast.makeText(this, "El campo de peticiones para la zona Torres de enfriamento no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fTorres && !ffTorres) {
            Toast.makeText(this, "Se requiere 1 foto obligatoria en la zona Torres de enfriamento", Toast.LENGTH_SHORT).show();
        }
        else if(fUMAs && detalles9.getText().length() == 0){
            Toast.makeText(this, "El campo de observaciones para la zona UMAs no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fUMAs && peticiones9.getText().length() == 0){
            Toast.makeText(this, "El campo de peticiones para la zona UMAs no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fUMAs && !ffUMAs) {
            Toast.makeText(this, "Se requiere 1 foto obligatoria en la zona UMAs", Toast.LENGTH_SHORT).show();
        }
        else if(fUPs && detalles10.getText().length() == 0){
            Toast.makeText(this, "El campo de observaciones para la zona UPs no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fUPs && peticiones10.getText().length() == 0){
            Toast.makeText(this, "El campo de peticiones para la zona UPs no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fUPs && !ffUPs) {
            Toast.makeText(this, "Se requiere 1 foto obligatoria en la zona UPs", Toast.LENGTH_SHORT).show();
        }
        else if(fULAs && detalles11.getText().length() == 0){
            Toast.makeText(this, "El campo de observaciones para la zona ULAs no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fULAs && peticiones11.getText().length() == 0){
            Toast.makeText(this, "El campo de peticiones para la zona ULAs no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fULAs && !ffULAs) {
            Toast.makeText(this, "Se requiere 1 foto obligatoria en la zona ULAs", Toast.LENGTH_SHORT).show();
        }
        else if(fMini && detalles12.getText().length() == 0){
            Toast.makeText(this, "El campo de observaciones para la zona Minisplit no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fMini && peticiones12.getText().length() == 0){
            Toast.makeText(this, "El campo de peticiones para la zona Minisplit no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fMini && !ffMini) {
            Toast.makeText(this, "Se requiere 1 foto obligatoria en la zona Minisplit", Toast.LENGTH_SHORT).show();
        }
        else if(fExtrac && detalles13.getText().length() == 0){
            Toast.makeText(this, "El campo de observaciones para la zona Extractores no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fExtrac && peticiones13.getText().length() == 0){
            Toast.makeText(this, "El campo de peticiones para la zona Extractores  no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fExtrac && !ffExtrac) {
            Toast.makeText(this, "Se requiere 1 foto obligatoria en la zona Extractores", Toast.LENGTH_SHORT).show();
        }
        else if(fTableros && detalles14.getText().length() == 0){
            Toast.makeText(this, "El campo de observaciones para la zona Tableros de control no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fTableros && peticiones14.getText().length() == 0){
            Toast.makeText(this, "El campo de peticiones para la zona Tableros de control no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fTableros && !ffTableros) {
            Toast.makeText(this, "Se requiere 1 foto obligatoria en la zona Tableros de control", Toast.LENGTH_SHORT).show();
        }
        else if(fCocinas && detalles15.getText().length() == 0){
            Toast.makeText(this, "El campo de observaciones para la zona Equipos de Cocina no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fCocinas && peticiones15.getText().length() == 0){
            Toast.makeText(this, "El campo de peticiones para la zona Equipos de Cocina no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fCocinas && !ffCocinas) {
            Toast.makeText(this, "Se requiere 1 foto obligatoria en la zona Equipos de Cocina", Toast.LENGTH_SHORT).show();
        }
        else if(fSanitarios && detalles16.getText().length() == 0){
            Toast.makeText(this, "El campo de observaciones para la zona Sanitarios no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fSanitarios && peticiones16.getText().length() == 0){
            Toast.makeText(this, "El campo de peticiones para la zona Sanitarios no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fSanitarios && !ffSanitarios) {
            Toast.makeText(this, "Se requiere 1 foto obligatoria en la zona Sanitarios", Toast.LENGTH_SHORT).show();

        }   else if(fchecklist && !ffchecklist) {
            Toast.makeText(this, "Se requiere 1 foto obligatoria en la zona CheckList", Toast.LENGTH_SHORT).show();

        } else if(firmaTec == "" && firmaResp == "") {
            Toast.makeText(this, "Se requieren las Firmas", Toast.LENGTH_SHORT).show();
            //return false;
        }
        else if(fchecklist && detalles19.getText().length() == 0){
            Toast.makeText(this, "El campo de observaciones para la zona CheckList no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fchecklist && peticiones19.getText().length() == 0) {
            Toast.makeText(this, "El campo de peticiones para la zona CheckList no puede quedar vacía.", Toast.LENGTH_LONG).show();

        }else if(fDireccion && detalles17.getText().length() == 0){
            Toast.makeText(this, "El campo de observaciones para la zona Entrevista con Dirección de Tienda  no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fDireccion && peticiones17.getText().length() == 0){
            Toast.makeText(this, "El campo de peticiones para la zona Entrevista con Dirección de Tienda no puede quedar vacía.", Toast.LENGTH_LONG).show();

        } else if(fJefe && detalles18.getText().length() == 0){
            Toast.makeText(this, "El campo de observaciones para la zona Entrevista con Jefe de MTTO de Tienda  no puede quedar vacía.", Toast.LENGTH_LONG).show();
        }
        else if(fJefe && peticiones18.getText().length() == 0) {
            Toast.makeText(this, "El campo de peticiones para la zona Entrevista con Jefe de MTTO de Tienda no puede quedar vacía.", Toast.LENGTH_LONG).show();

        }else if (firmaTec.equals("") && firmaResp.equals("")) {
            Toast.makeText(this, "Se requieren las Firmas, el formulario no se envío ", Toast.LENGTH_SHORT).show();
        } else if(firmaTec.equals("")){
            Toast.makeText(this, "Se requiere la Firma del Coordinador", Toast.LENGTH_SHORT).show();
            //return false;
        }else if(firmaResp.equals("")){
                Toast.makeText(this, "Se requiere la Firma del Jefe de Sitio", Toast.LENGTH_SHORT).show();
        } else {
            partida_concepto.substring(0, partida_concepto.length()-1);
            zonas.substring(0, zonas.length()-2);
            Bundle extras = getIntent().getExtras();
            Toast.makeText(this, "Enviando Formulario", Toast.LENGTH_LONG).show();
            Gson gsonFrom = new Gson();
            StoreFormAudiLibre miForm = new StoreFormAudiLibre();
            miForm.setFecha("");
            miForm.setDgc(etDgc.getText().toString());
            miForm.setMotivo(etMotivo.getText().toString());
            miForm.setSitio(etSitio.getText().toString());
            miForm.setSector(etSector.getText().toString());
            miForm.setProyecto(etProyecto.getText().toString());
            miForm.setZonas(zonas);
            miForm.setConceptos(partida_concepto);
            miForm.setObservaciones(etObservaciones.getText().toString());
            miForm.setObservaciones1(etObservaciones1.getText().toString());
            miForm.setPromesas(etPromesas.getText().toString());
            miForm.setPromesas1(etPromesas1.getText().toString());
            miForm.setFirmanteTec(firmanteTec);
            miForm.setFirmanteResp(firmanteResp);
            miForm.setFirmaTec(firmaTec);
            miForm.setFirmaResp(firmaResp);
            miForm.setFotos(fotos);
            miForm.setModulo(mes);

            miForm.setComment(detalles.getText().toString());
            miForm.setComment1(detalles1.getText().toString());
            miForm.setComment2(detalles2.getText().toString());
            miForm.setComment3(detalles3.getText().toString());
            miForm.setComment4(detalles4.getText().toString());
            miForm.setComment5(detalles5.getText().toString());
            miForm.setComment6(detalles6.getText().toString());
            miForm.setComment7(detalles7.getText().toString());
            miForm.setComment8(detalles8.getText().toString());
            miForm.setComment9(detalles9.getText().toString());
            miForm.setComment10(detalles10.getText().toString());
            miForm.setComment11(detalles11.getText().toString());
            miForm.setComment12(detalles12.getText().toString());
            miForm.setComment13(detalles13.getText().toString());
            miForm.setComment14(detalles14.getText().toString());
            miForm.setComment15(detalles15.getText().toString());
            miForm.setComment16(detalles16.getText().toString());
            miForm.setComment17(detalles17.getText().toString());
            miForm.setComment18(detalles18.getText().toString());
            miForm.setComment19(detalles19.getText().toString());

            miForm.setComment20(peticiones.getText().toString());
            miForm.setComment21(peticiones1.getText().toString());
            miForm.setComment22(peticiones2.getText().toString());
            miForm.setComment23(peticiones3.getText().toString());
            miForm.setComment24(peticiones4.getText().toString());
            miForm.setComment25(peticiones5.getText().toString());
            miForm.setComment26(peticiones6.getText().toString());
            miForm.setComment27(peticiones7.getText().toString());
            miForm.setComment28(peticiones8.getText().toString());
            miForm.setComment29(peticiones9.getText().toString());
            miForm.setComment30(peticiones10.getText().toString());
            miForm.setComment31(peticiones11.getText().toString());
            miForm.setComment32(peticiones12.getText().toString());
            miForm.setComment33(peticiones13.getText().toString());
            miForm.setComment34(peticiones14.getText().toString());
            miForm.setComment35(peticiones15.getText().toString());
            miForm.setComment36(peticiones16.getText().toString());
            miForm.setComment37(peticiones17.getText().toString());
            miForm.setComment38(peticiones18.getText().toString());
            miForm.setComment39(peticiones19.getText().toString());

          //  miForm.setSitio(autoCompleteTextView.getText().toString());


            //String json =  gsonFrom.toJson(miForm);
            try {
                taskZonaPuntosdeInicioOT2 = new taskZonaPuntosdeInicioOT2(gsonFrom.toJson(miForm));
                Toast.makeText(this, "Procesando solicitud", Toast.LENGTH_LONG).show();
                taskZonaPuntosdeInicioOT2.execute((Void) null);
                //return true;
            }catch (Exception e){
                //return false;
            }
        }
    }

    //Metodo para enviar los checkBox al formulario
    public String addZonasButton(){

        if(etm.isChecked()){
            zonas += "ETM - Escaleras, ";
            fEsc = true;
        }
        if (elevadores.isChecked()){
            zonas += "ETM - Elevadores, ";
            ffEle = true;

        }
        if (montacargas.isChecked()){
            zonas += "ETM - Montacargas, ";
            fMon = true;
        }
        if (bci.isChecked()){
            zonas += "BCI, ";
            fBCI = true;
        }
        if (pem.isChecked()){
            zonas += "PEM, ";
            fPEM = true;
        }
        if (subestacion.isChecked()){
            zonas += "Subestación, ";
            fSube = true;
        }
        if (chillers.isChecked()){
            zonas += "Chillers, ";
            fChill = true;
        }
        if (bombas.isChecked()){
            zonas += "Bombas de agua helada, ";
            fBom = true;
        }
        if (torres.isChecked()){
            zonas += "Torres de enfriamento, ";
            fTorres = true;
        }
        if (umas.isChecked()){
            zonas += "UMAs, ";
            fUMAs = true;
        }
        if (ups.isChecked()){
            zonas += "UPs, ";
            fUPs = true;
        }
        if (ulas.isChecked()){
            zonas += "ULAs, ";
            fULAs = true;
        }
        if (minis.isChecked()){
            zonas += "Minisplit, ";
            fMini = true;
        }
        if (extractores.isChecked()){
            zonas += "Extractores, ";
            fExtrac = true;
        }
        if (tableros.isChecked()){
            zonas += "Tableros de control, ";
            fTableros = true;
        }
        if (cocinas.isChecked()){
            zonas += "Equipos de Cocina, ";
            fCocinas = true;
        }
        if (sanitarios.isChecked()){
            zonas += "Sanitarios, ";
            fSanitarios = true;
        }
        if (check.isChecked()){
            zonas += "CheckList, ";
            fchecklist = true;
        }
        if (Direccion.isChecked()){
            zonas += "Direccion, ";
            fDireccion = true;
        }
        if (jefe.isChecked()){
            zonas += "jefe, ";
            fJefe = true;
        }

        return zonas;
    }

    //Metodo para enviar los checkBox al formulario
    public String addEscalerasButton(){

        String result = "";

        if (peines.isChecked()){
            result += peines.getText()+"|";
        }
        if (demarcaciones.isChecked()){
            result += demarcaciones.getText()+"|";
        }
        if (fosas.isChecked()){
            result +=  fosas.getText()+"|";
        }
        if (pasamanos.isChecked()){
            result +=  pasamanos.getText()+"|";
        }
        if (funcionamiento.isChecked()){
            result += funcionamiento.getText() +"0|";
        }
        return result;
    }

    //Se visualiza los checklist al momento de recuperar la info.
    public void Ischeckzonas(){

        if(etm.isChecked()) {
            zpi.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.etm);
            texto.setTextColor(Color.BLUE);
        }

        if(elevadores.isChecked()) {
            ztc.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.elevadores);
            texto.setTextColor(Color.BLUE);
        }

        if(montacargas.isChecked()) {
            zmt.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.montacargas);
            texto.setTextColor(Color.BLUE);
        }

        if(bci.isChecked()) {
            zfr.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.bci);
            texto.setTextColor(Color.BLUE);
        }

        if(pem.isChecked()) {
            zlv.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.pem);
            texto.setTextColor(Color.BLUE);
        }

        if(subestacion.isChecked()) {
            zlvt.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.subestacion);
            texto.setTextColor(Color.BLUE);
        }

        if(chillers.isChecked()) {
            zlva.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.chillers);
            texto.setTextColor(Color.BLUE);
        }

        if(bombas.isChecked()) {
            zlve.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.bombas);
            texto.setTextColor(Color.BLUE);
        }

        if(torres.isChecked()) {
            zlvo.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.torres);
            texto.setTextColor(Color.BLUE);
        }

        if(umas.isChecked()) {
            zlvp.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.umas);
            texto.setTextColor(Color.BLUE);
        }

        if(ups.isChecked()) {
            zlvk.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.ups);
            texto.setTextColor(Color.BLUE);
        }

        if(ulas.isChecked()) {
            zlvc.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.ulas);
            texto.setTextColor(Color.BLUE);
        }

        if(minis.isChecked()) {
            zlvf.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.minis);
            texto.setTextColor(Color.BLUE);
        }

        if(extractores.isChecked()) {
            zlvy.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.extractores);
            texto.setTextColor(Color.BLUE);
        }

        if(tableros.isChecked()) {
            zlvh.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.tableros);
            texto.setTextColor(Color.BLUE);
        }

        if(cocinas.isChecked()) {
            zlvx.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.cocinas);
            texto.setTextColor(Color.BLUE);
        }

        if(sanitarios.isChecked()) {
            zlvm.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.sanitarios);
            texto.setTextColor(Color.BLUE);
        }

        if(check.isChecked()) {
            zlvxx.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.check);
            texto.setTextColor(Color.BLUE);
        }

        if(Direccion.isChecked()) {
            zlvn.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.direccion);
            texto.setTextColor(Color.BLUE);
        }

        if(jefe.isChecked()) {
            zlvs.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.jefe);
            texto.setTextColor(Color.BLUE);
        }
    }

    public void  Ischeckescalera(){

        if(peines.isChecked()) {
            peines.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.peines);
            texto.setTextColor(Color.BLACK);
        }

        if(demarcaciones.isChecked()) {
            demarcaciones.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.demarcacion);
            texto.setTextColor(Color.BLACK);
        }

        if(fosas.isChecked()) {
            fosas.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.fosas);
            texto.setTextColor(Color.BLACK);
        }

        if(pasamanos.isChecked()) {
            pasamanos.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.pasamanos);
            texto.setTextColor(Color.BLACK);
        }

        if(funcionamiento.isChecked()) {
            funcionamiento.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.funcionamiento);
            texto.setTextColor(Color.BLACK);
        }
    }

    public void  Ischeckelevadores(){

        if(cables.isChecked()) {
            cables.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.cables);
            texto.setTextColor(Color.BLACK);
        }

        if(poleas.isChecked()) {
            poleas.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.poleas);
            texto.setTextColor(Color.BLACK);
        }

        if(correcto.isChecked()) {
            correcto.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.correcto);
            texto.setTextColor(Color.BLACK);
        }
    }

    public void  Ischeckmontecargas(){

        if(correctos.isChecked()) {
            correctos.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.correctos);
            texto.setTextColor(Color.BLACK);
        }

        if(correctas.isChecked()) {
            correctas.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.correctas);
            texto.setTextColor(Color.BLACK);
        }

        if(correcto1.isChecked()) {
            correcto1.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.correcto1);
            texto.setTextColor(Color.BLACK);
        }
    }

    public void  Ischeckbci(){

        if(combustion.isChecked()) {
            combustion.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.combustion);
            texto.setTextColor(Color.BLACK);
        }

        if(electrica.isChecked()) {
            electrica.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.electrica);
            texto.setTextColor(Color.BLACK);
        }

        if(bitacoras.isChecked()) {
            bitacoras.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.bitacoras);
            texto.setTextColor(Color.BLACK);
        }

        if(orden.isChecked()) {
            orden.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.orden);
            texto.setTextColor(Color.BLACK);
        }

        if(fugas.isChecked()) {
            fugas.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.fugas);
            texto.setTextColor(Color.BLACK);
        }
    }

    public void  Ischeckpem(){

        if(prueba.isChecked()) {
            prueba.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.prueba);
            texto.setTextColor(Color.BLACK);
        }

        if(cuenta1.isChecked()) {
            cuenta1.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.cuenta1);
            texto.setTextColor(Color.BLACK);
        }

        if(limpieza1.isChecked()) {
            limpieza1.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.limpieza1);
            texto.setTextColor(Color.BLACK);
        }

        if(presenta.isChecked()) {
            presenta.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.presenta);
            texto.setTextColor(Color.BLACK);
        }
    }

    public void  Ischecksubestacion(){

        if(correcto2.isChecked()) {
            correcto2.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.correcto2);
            texto.setTextColor(Color.BLACK);
        }

        if(encuentran.isChecked()) {
            encuentran.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.encuentran);
            texto.setTextColor(Color.BLACK);
        }

        if(orden1.isChecked()) {
            orden1.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.orden1);
            texto.setTextColor(Color.BLACK);
        }

        if(zonas1.isChecked()) {
            zonas1.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.zonas1);
            texto.setTextColor(Color.BLACK);
        }
    }

    public void  Ischeckchillers(){

        if(equipo.isChecked()) {
            equipo.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.equipo);
            texto.setTextColor(Color.BLACK);
        }

        if(se.isChecked()) {
            se.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.se);
            texto.setTextColor(Color.BLACK);
        }

        if(tienen.isChecked()) {
            tienen.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.tienen);
            texto.setTextColor(Color.BLACK);
        }

        if(limpieza2.isChecked()) {
            limpieza2.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.limpieza2);
            texto.setTextColor(Color.BLACK);
        }
    }

    public void  Ischeckbombas(){

        if(operando.isChecked()) {
            operando.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.operando);
            texto.setTextColor(Color.BLACK);
        }

        if(presenta.isChecked()) {
            presenta.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.presenta);
            texto.setTextColor(Color.BLACK);
        }
    }

    public void  Ischecktorres(){

        if(correcto3.isChecked()) {
            correcto3.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.correcto3);
            texto.setTextColor(Color.BLACK);
        }

        if(orden2.isChecked()) {
            orden2.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.orden2);
            texto.setTextColor(Color.BLACK);
        }

        if(fugas2.isChecked()) {
            fugas2.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.fugas2);
            texto.setTextColor(Color.BLACK);
        }

        if(limpieza2.isChecked()) {
            limpieza2.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.limpieza2);
            texto.setTextColor(Color.BLACK);
        }
    }

    public void  Ischeckchecklist(){

        if(herramienta.isChecked()) {
            herramienta.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.herramienta);
            texto.setTextColor(Color.BLACK);
        }

        if(epi.isChecked()) {
            epi.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.epi);
            texto.setTextColor(Color.BLACK);
        }

        if(sgi.isChecked()) {
            sgi.setVisibility(View.VISIBLE);
            texto = (TextView) findViewById(R.id.sgi);
            texto.setTextColor(Color.BLACK);
        }


    }

    //Metodo para enviar los checkBox al formulario
    public String addElevadoresButton(){

        String result = "";

        if (cables.isChecked()){
            result += cables.getText()+"|";
        }
        if (poleas.isChecked()){
            result += poleas.getText()+"0|";
        }
        if (correcto.isChecked()){
            result +=  correcto.getText()+"1|";
        }
        return result;
    }

    //Metodo para enviar los checkBox al formulario
    public String addMontacargasButton(){

        String result = "";

        if (correctos.isChecked()){
            result += correctos.getText()+"|";
        }
        if (correctas.isChecked()){
            result += correctas.getText()+"1|";
        }
        if (correcto1.isChecked()){
            result +=  correcto1.getText()+"2|";
        }
        return result;
    }

    //Metodo para enviar los checkBox al formulario
    public String addBCIButton(){

        String result = "";

        if (combustion.isChecked()){
            result += combustion.getText()+"|";
        }
        if (electrica.isChecked()){
            result += electrica.getText()+"|";
        }
        if (bitacoras.isChecked()){
            result +=  bitacoras.getText()+"0|";
        }
        if (orden.isChecked()){
            result +=  orden.getText()+"0|";
        }
        if (fugas.isChecked()){
            result += fugas.getText()+"0|";
        }
        return result;
    }

    public String addPemButton(){

        String result = "";

        if (prueba.isChecked()){
            result += prueba.getText()+"|";
        }
        if (cuenta1.isChecked()){
            result += cuenta1.getText()+"1|";
        }
        if (limpieza1.isChecked()){
            result +=  limpieza1.getText()+"1|";
        }
        if (presenta.isChecked()){
            result +=  presenta.getText()+"1|";
        }
        return result;
    }

    public String addSubestacionButton(){

        String result = "";

        if (correcto2.isChecked()){
            result += correcto2.getText()+"4|";
        }
        if (encuentran.isChecked()){
            result += encuentran.getText()+"2|";
        }
        if (orden1.isChecked()){
            result +=  orden1.getText()+"2|";
        }
        if (zonas1.isChecked()){
            result +=  zonas1.getText()+"|";
        }
        return result;
    }

    public String addChellersButton(){

        String result = "";

        if (equipo.isChecked()){
            result += equipo.getText()+"|";
        }
        if (se.isChecked()){
            result += se.getText()+"3|";
        }
        if (tienen.isChecked()){
            result +=  tienen.getText()+"2|";
        }
        if (limpieza2.isChecked()){
            result +=  limpieza2.getText()+"3|";
        }



        return result;

    }

    public String addBombasButton(){

        String result = "";

        if (operando.isChecked()){
            result += operando.getText()+"|";
        }
        if (presenta1.isChecked()){
            result += presenta1.getText()+"3|";
        }



        return result;

    }

    public String addTorresButton(){

        String result = "";

        if (correcto3.isChecked()){
            result += correcto3.getText()+"5|";
        }
        if (orden2.isChecked()){
            result += orden2.getText()+"4|";
        }
        if (fugas2.isChecked()){
            result +=  fugas2.getText()+"4|";
        }



        return result;

    }

    public String addCheckButton(){

        String result = "";

        if (herramienta.isChecked()){
            result += herramienta.getText()+"|";
        }
        if (epi.isChecked()){
            result += epi.getText()+"|";
        }
        if (sgi.isChecked()){
            result +=  sgi.getText()+"|";
        }



        return result;

    }

    private ContentValues insertsql(){
        String count = "0";
        int i=0;

        ContentValues cv = new ContentValues();
        cv. put("Director", etDgc.getText().toString());
        cv. put("Motivo", etMotivo.getText().toString());
        cv. put("Sitio", etSitio.getText().toString());
        cv. put("Sector", etSector.getText().toString());
        cv. put("Proyecto", etProyecto.getText().toString());

        cv.put("Zonas" , etm.isChecked() + "," + elevadores.isChecked() + "," + montacargas.isChecked() + "," + bci.isChecked() + "," +
                pem.isChecked() + "," + subestacion.isChecked() + "," + chillers.isChecked() + "," +  bombas.isChecked() + "," + torres.isChecked() + "," + umas.isChecked() + "," + ups.isChecked() + "," + ulas.isChecked() + "," +
                minis.isChecked() + "," + extractores.isChecked() + "," + tableros.isChecked() + "," + cocinas.isChecked() + "," + sanitarios.isChecked() + "," + check.isChecked() + "," + Direccion.isChecked() + "," + jefe.isChecked());

        cv.put("Escalera",  peines.isChecked() + "," + demarcaciones.isChecked() + "," + fosas.isChecked() + "," + pasamanos.isChecked() + "," +
                funcionamiento.isChecked());
        cv. put("Peticiones", peticiones.getText().toString());
        cv. put("Detalles", detalles.getText().toString());

        cv.put("Elevadores",  cables.isChecked() + "," + poleas.isChecked() + "," + correcto.isChecked());
        cv. put("Peticiones1", peticiones1.getText().toString());
        cv. put("Detalles1", detalles1.getText().toString());

        cv.put("Montacargas",  correctos.isChecked() + "," + correctas.isChecked() + "," + correcto1.isChecked());
        cv. put("Peticiones2", peticiones2.getText().toString());
        cv. put("Detalles2", detalles2.getText().toString());

        cv.put("BCI",  combustion.isChecked() + "," + electrica.isChecked() + "," + bitacoras.isChecked() + "," + orden.isChecked() + "," + fugas.isChecked());
        cv. put("Peticiones3", peticiones3.getText().toString());
        cv. put("Detalles3", detalles3.getText().toString());

        cv.put("PEM",  prueba.isChecked() + "," + cuenta1.isChecked() + "," + limpieza1.isChecked() + "," + presenta.isChecked());
        cv. put("Peticiones4", peticiones4.getText().toString());
        cv. put("Detalles4", detalles4.getText().toString());

        cv.put("Subestacion",  correcto2.isChecked() + "," + encuentran.isChecked() + "," + orden1.isChecked() + "," + zonas1.isChecked());
        cv. put("Peticiones5", peticiones5.getText().toString());
        cv. put("Detalles5", detalles5.getText().toString());

        cv.put("Chillers",  equipo.isChecked() + "," + se.isChecked() + "," + tienen.isChecked() + "," + limpieza2.isChecked());
        cv. put("Peticiones6", peticiones6.getText().toString());
        cv. put("Detalles6", detalles6.getText().toString());

        cv.put("Bombas",  operando.isChecked() + "," + presenta.isChecked());
        cv. put("Peticiones7", peticiones7.getText().toString());
        cv. put("Detalles7", detalles7.getText().toString());

        cv.put("Torres",  correcto3.isChecked() + "," + orden2.isChecked() + "," + fugas2.isChecked());
        cv. put("Peticiones8", peticiones8.getText().toString());
        cv. put("Detalles8", detalles8.getText().toString());

        cv. put("Peticiones9", peticiones9.getText().toString());
        cv. put("Detalles9", detalles9.getText().toString());
        cv. put("Peticiones10", peticiones10.getText().toString());
        cv. put("Detalles10", detalles10.getText().toString());
        cv. put("Peticiones11", peticiones11.getText().toString());
        cv. put("Detalles11", detalles11.getText().toString());
        cv. put("Peticiones12", peticiones12.getText().toString());
        cv. put("Detalles12", detalles12.getText().toString());
        cv. put("Peticiones13", peticiones13.getText().toString());
        cv. put("Detalles13", detalles13.getText().toString());
        cv. put("Peticiones14", peticiones14.getText().toString());
        cv. put("Detalles14", detalles14.getText().toString());
        cv. put("Peticiones15", peticiones15.getText().toString());
        cv. put("Detalles15", detalles15.getText().toString());
        cv. put("Peticiones16", peticiones16.getText().toString());
        cv. put("Detalles16", detalles16.getText().toString());

        cv.put("CheckList",  herramienta.isChecked() + "," + epi.isChecked() + "," + sgi.isChecked());
        cv. put("Peticiones17", peticiones17.getText().toString());
        cv. put("Detalles17", detalles17.getText().toString());

        cv. put("Peticiones18", peticiones18.getText().toString());
        cv. put("Detalles18", detalles18.getText().toString());
        cv.put("Promesas", etPromesas.getText().toString());

        cv. put("Peticiones19", peticiones19.getText().toString());
        cv. put("Detalles19", detalles19.getText().toString());
        cv.put("Promesas1", etPromesas1.getText().toString());

        if (fotosg.size()!=0){
            String cadena = fotosg.toString();
                    cv.put("Imagenes", cadena.substring(1, cadena.length() -1));
                }else{
                    cv.put("Imagenes", "");
                }

        cv.put("Coordinador", etObservaciones.getText().toString());
        cv.put("Jefe", etObservaciones1.getText().toString());
        cv.put("FirmaTec", firmaTec);
        cv.put("Firmante", firmanteTec);
        cv.put("FirmaRes", firmaResp);
        cv.put("Firmanres", firmanteResp);

        return cv;

    }

    public void borrar(View v) {

        MyOpenHelper dbHelper = new MyOpenHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("DELETE FROM AUSQL");
        Toast.makeText(this, "Los datos se han borrado", Toast.LENGTH_SHORT).show();
    }

    public void grabarau(View v) {

        addZonasButton();
        addEscalerasButton();
        addEscalerasButton();
        addMontacargasButton();
        addBCIButton();
        addPemButton();
        addPemButton();
        addSubestacionButton();
        addChellersButton();
        addBombasButton();
        addTorresButton();
        addCheckButton();

        MyOpenHelper dbHelper = new MyOpenHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM AUSQL", null);
        ContentValues cv = insertsql();
        if (c.getCount() ==0){
            db.insert("AUSQL", null, cv);
            Toast.makeText(this, "Los datos fueron grabados", Toast.LENGTH_SHORT).show();
        } else {
            c.moveToFirst();
            int id = c.getInt(c.getColumnIndex("_id"));
            db.update("AUSQL",  cv, "_id="+id, null);
            Toast.makeText(this, "Los datos se han actualizados", Toast.LENGTH_SHORT).show();
        }
        }

    public void recuperarau(View v) {

        int i;

        try {
            MyOpenHelper dbHelper = new MyOpenHelper(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            Cursor c = db.rawQuery("SELECT _id, Director, Motivo, Sitio, Sector,  Proyecto, " +
                    "Zonas, Escalera, Detalles, Peticiones, " +
                    "Elevadores, Detalles1, Peticiones1," +
                    "Montacargas, Detalles2, Peticiones2," +
                    "BCI, Detalles3, Peticiones3," +
                    "PEM, Detalles4, Peticiones4," +
                    "Subestacion, Detalles5, Peticiones5," +
                    "Chillers, Detalles6, Peticiones6," +
                    "Bombas, Detalles7, Peticiones7," +
                    "Torres, Detalles8, Peticiones8," +
                    "Detalles9, Peticiones9," +
                    "Detalles10, Peticiones10," +
                    "Detalles11, Peticiones11," +
                    "Detalles12, Peticiones12," +
                    "Detalles13, Peticiones13," +
                    "Detalles14, Peticiones14," +
                    "Detalles15, Peticiones15," +
                    "Detalles16, Peticiones16," +
                    "CheckList, Detalles17, Peticiones17," +
                    "Detalles18, Peticiones18, Promesas," +
                    "Detalles19, Peticiones19, Promesas1," +
                    "Imagenes , Coordinador, Jefe, FirmaTec, Firmante, FirmaRes, " +
                    "Firmanres FROM AUSQL", null);
            if (c.getCount() != 0 ) {
                c.moveToFirst();
                do {

                    String Director = c.getString(c.getColumnIndex("Director"));
                    String Motivo = c.getString(c.getColumnIndex("Motivo"));
                    String Sitio = c.getString(c.getColumnIndex("Sitio"));
                    String Sector = c.getString(c.getColumnIndex("Sector"));
                    String Proyecto = c.getString(c.getColumnIndex("Proyecto"));

                    String Zonas1 = c.getString(c.getColumnIndex("Zonas"));

                    String Escalera = c.getString(c.getColumnIndex("Escalera"));
                    String Detalles = c.getString(c.getColumnIndex("Detalles"));
                    String Peticiones = c.getString(c.getColumnIndex("Peticiones"));

                    String Elevadores = c.getString(c.getColumnIndex("Elevadores"));
                    String Detalles1 = c.getString(c.getColumnIndex("Detalles1"));
                    String Peticiones1 = c.getString(c.getColumnIndex("Peticiones1"));

                    String Montacargas = c.getString(c.getColumnIndex("Montacargas"));
                    String Detalles2 = c.getString(c.getColumnIndex("Detalles2"));
                    String Peticiones2 = c.getString(c.getColumnIndex("Peticiones2"));

                    String BCI = c.getString(c.getColumnIndex("BCI"));
                    String Detalles3 = c.getString(c.getColumnIndex("Detalles3"));
                    String Peticiones3 = c.getString(c.getColumnIndex("Peticiones3"));

                    String PEM = c.getString(c.getColumnIndex("PEM"));
                    String Detalles4 = c.getString(c.getColumnIndex("Detalles4"));
                    String Peticiones4 = c.getString(c.getColumnIndex("Peticiones4"));

                    String Subestacion = c.getString(c.getColumnIndex("Subestacion"));
                    String Detalles5 = c.getString(c.getColumnIndex("Detalles5"));
                    String Peticiones5 = c.getString(c.getColumnIndex("Peticiones5"));

                    String Chillers = c.getString(c.getColumnIndex("Chillers"));
                    String Detalles6 = c.getString(c.getColumnIndex("Detalles6"));
                    String Peticiones6 = c.getString(c.getColumnIndex("Peticiones6"));

                    String Bombas = c.getString(c.getColumnIndex("Bombas"));
                    String Detalles7 = c.getString(c.getColumnIndex("Detalles7"));
                    String Peticiones7 = c.getString(c.getColumnIndex("Peticiones7"));

                    String Torres = c.getString(c.getColumnIndex("Torres"));
                    String Detalles8 = c.getString(c.getColumnIndex("Detalles8"));
                    String Peticiones8 = c.getString(c.getColumnIndex("Peticiones8"));

                    String Detalles9 = c.getString(c.getColumnIndex("Detalles9"));
                    String Peticiones9 = c.getString(c.getColumnIndex("Peticiones9"));
                    String Detalles10 = c.getString(c.getColumnIndex("Detalles10"));
                    String Peticiones10 = c.getString(c.getColumnIndex("Peticiones10"));
                    String Detalles11 = c.getString(c.getColumnIndex("Detalles11"));
                    String Peticiones11 = c.getString(c.getColumnIndex("Peticiones11"));
                    String Detalles12 = c.getString(c.getColumnIndex("Detalles12"));
                    String Peticiones12 = c.getString(c.getColumnIndex("Peticiones12"));
                    String Detalles13 = c.getString(c.getColumnIndex("Detalles13"));
                    String Peticiones13 = c.getString(c.getColumnIndex("Peticiones13"));
                    String Detalles14 = c.getString(c.getColumnIndex("Detalles14"));
                    String Peticiones14 = c.getString(c.getColumnIndex("Peticiones14"));
                    String Detalles15 = c.getString(c.getColumnIndex("Detalles15"));
                    String Peticiones15 = c.getString(c.getColumnIndex("Peticiones15"));
                    String Detalles16 = c.getString(c.getColumnIndex("Detalles16"));
                    String Peticiones16 = c.getString(c.getColumnIndex("Peticiones16"));

                    String CheckList = c.getString(c.getColumnIndex("CheckList"));
                    String Detalles17 = c.getString(c.getColumnIndex("Detalles17"));
                    String Peticiones17 = c.getString(c.getColumnIndex("Peticiones17"));

                    //String DireccionEn = c.getString(c.getColumnIndex("DireccionEn"));
                    String Detalles18 = c.getString(c.getColumnIndex("Detalles18"));
                    String Peticiones18 = c.getString(c.getColumnIndex("Peticiones18"));
                    String Promesas = c.getString(c.getColumnIndex("Promesas"));

                   // String JefeEn = c.getString(c.getColumnIndex("JefeEn"));
                    String Detalles19 = c.getString(c.getColumnIndex("Detalles19"));
                    String Peticiones19 = c.getString(c.getColumnIndex("Peticiones19"));
                    String Promesas1 = c.getString(c.getColumnIndex("Promesas1"));


                    String Imau = c.getString(c.getColumnIndex("Imagenes"));
/*
                     List<String> fotospath = new ArrayList<String>();

                    for (i=0; i<90; i++){
                        if (c.getString(c.getColumnIndex("Imagen" + i + 1))!=""){
                            fotospath.add(c.getString(c.getColumnIndex("Imagen"+i+1)));
                        }
                    }
  */

                    String [] ima = Imau.split(", ") ;

                    for (int j = 0; j < ima.length; j++){
                        if(ima[j].contains("Imagen01")){
                            btncamara1.setEnabled(false);
                            fotosg.add(ima[j]);
                            ffEsc = true;
                        }
                        if(ima[j].contains("Imagen02")){
                            btncamara2.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen03")){
                            btncamara3.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen04")){
                            btncamara4.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen05")){
                            btncamara5.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen06")){
                            btncamara6.setEnabled(false);
                            fotosg.add(ima[j]);
                            ffEle = true;
                        }
                        if(ima[j].contains("Imagen07")){
                            btncamara7.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen08")){
                            btncamara8.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen09")){
                            btncamara9.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen10")){
                            btncamara10.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen11")){
                            btncamara11.setEnabled(false);
                            fotosg.add(ima[j]);
                            ffMon = true;
                        }
                        if(ima[j].contains("Imagen12")){
                            btncamara12.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen13")){
                            btncamara13.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen14")){
                            btncamara14.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen15")){
                            btncamara15.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen16")){
                            btncamara16.setEnabled(false);
                            fotosg.add(ima[j]);
                            ffBCI = true;
                        }
                        if(ima[j].contains("Imagen17")){
                            btncamara17.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen18")){
                            btncamara18.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen19")){
                            btncamara19.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen20")){
                            btncamara20.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen21")){
                            btncamara21.setEnabled(false);
                            fotosg.add(ima[j]);
                            ffPEM = true;
                        }
                        if(ima[j].contains("Imagen22")){
                            btncamara22.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen23")){
                            btncamara23.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen24")){
                            btncamara24.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen25")){
                            btncamara25.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen26")){
                            btncamara26.setEnabled(false);
                            fotosg.add(ima[j]);
                            ffSube = true;
                        }
                        if(ima[j].contains("Imagen27")){
                            btncamara27.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen28")){
                            btncamara28.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen29")){
                            btncamara29.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen30")){
                            btncamara30.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen31")){
                            btncamara31.setEnabled(false);
                            fotosg.add(ima[j]);
                            ffChill = true;
                        }
                        if(ima[j].contains("Imagen32")){
                            btncamara32.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen33")){
                            btncamara33.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen34")){
                            btncamara34.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen35")){
                            btncamara35.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen36")){
                            btncamara36.setEnabled(false);
                            fotosg.add(ima[j]);
                            ffBom = true;
                        }
                        if(ima[j].contains("Imagen37")){
                            btncamara37.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen38")){
                            btncamara38.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen39")){
                            btncamara39.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen40")){
                            btncamara40.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen41")){
                            btncamara41.setEnabled(false);
                            fotosg.add(ima[j]);
                            ffTorres = true;
                        }
                        if(ima[j].contains("Imagen42")){
                            btncamara42.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen43")){
                            btncamara43.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen44")){
                            btncamara44.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen45")){
                            btncamara45.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen46")){
                            btncamara46.setEnabled(false);
                            fotosg.add(ima[j]);
                            ffUMAs = true;
                        }
                        if(ima[j].contains("Imagen47")){
                            btncamara47.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen48")){
                            btncamara48.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen49")){
                            btncamara49.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen50")){
                            btncamara50.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen51")){
                            btncamara51.setEnabled(false);
                            fotosg.add(ima[j]);
                            ffUPs = true;
                        }
                        if(ima[j].contains("Imagen52")){
                            btncamara52.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen53")){
                            btncamara53.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen54")){
                            btncamara54.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen55")){
                            btncamara55.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen56")){
                            btncamara56.setEnabled(false);
                            fotosg.add(ima[j]);
                            ffULAs = true;
                        }
                        if(ima[j].contains("Imagen57")){
                            btncamara57.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen58")){
                            btncamara58.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen59")){
                            btncamara59.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen60")){
                            btncamara60.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen61")){
                            btncamara61.setEnabled(false);
                            fotosg.add(ima[j]);
                            ffMini = true;
                        }
                        if(ima[j].contains("Imagen62")){
                            btncamara62.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen63")){
                            btncamara63.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen64")){
                            btncamara64.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen65")){
                            btncamara65.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen66")){
                            btncamara66.setEnabled(false);
                            fotosg.add(ima[j]);
                            ffExtrac = true;
                        }
                        if(ima[j].contains("Imagen67")){
                            btncamara67.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen68")){
                            btncamara68.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen69")){
                            btncamara69.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen70")){
                            btncamara70.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen71")){
                            btncamara71.setEnabled(false);
                            fotosg.add(ima[j]);
                            ffTableros = true;
                        }
                        if(ima[j].contains("Imagen72")){
                            btncamara72.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen73")){
                            btncamara73.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen74")){
                            btncamara74.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen75")){
                            btncamara75.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen76")){
                            btncamara76.setEnabled(false);
                            fotosg.add(ima[j]);
                            ffCocinas = true;
                        }
                        if(ima[j].contains("Imagen77")){
                            btncamara77.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen78")){
                            btncamara78.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen79")){
                            btncamara79.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen80")){
                            btncamara80.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen81")){
                            btncamara81.setEnabled(false);
                            fotosg.add(ima[j]);
                            ffSanitarios = true;
                        }
                        if(ima[j].contains("Imagen82")){
                            btncamara82.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen83")){
                            btncamara83.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen84")){
                            btncamara84.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen85")){
                            btncamara85.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen86")){
                            btncamara86.setEnabled(false);
                            fotosg.add(ima[j]);
                            ffchecklist = true;
                        }
                        if(ima[j].contains("Imagen87")){
                            btncamara87.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen88")){
                            btncamara88.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen89")){
                            btncamara89.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                        if(ima[j].contains("Imagen90")){
                            btncamara90.setEnabled(false);
                            fotosg.add(ima[j]);
                        }
                    }

                    String Coordinador = c.getString(c.getColumnIndex("Coordinador"));
                    String Jefe = c.getString(c.getColumnIndex("Jefe"));

                    String FirmaTec = c.getString(c.getColumnIndex("FirmaTec"));
                    String Firmante = c.getString(c.getColumnIndex("Firmante"));
                    String FirmaRes = c.getString(c.getColumnIndex("FirmaRes"));
                    String Firmanres = c.getString(c.getColumnIndex("Firmanres"));

                    String[] Checks = Zonas1.split(",");

                    etm.setChecked(Boolean.parseBoolean(Checks[0]));
                    elevadores.setChecked(Boolean.parseBoolean(Checks[1]));
                    montacargas.setChecked(Boolean.parseBoolean(Checks[2]));
                    bci.setChecked(Boolean.parseBoolean(Checks[3]));
                    pem.setChecked(Boolean.parseBoolean(Checks[4]));
                    subestacion.setChecked(Boolean.parseBoolean(Checks[5]));
                    chillers.setChecked(Boolean.parseBoolean(Checks[6]));
                    bombas.setChecked(Boolean.parseBoolean(Checks[7]));
                    torres.setChecked(Boolean.parseBoolean(Checks[8]));
                    umas.setChecked(Boolean.parseBoolean(Checks[9]));
                    ups.setChecked(Boolean.parseBoolean(Checks[10]));
                    ulas.setChecked(Boolean.parseBoolean(Checks[11]));
                    minis.setChecked(Boolean.parseBoolean(Checks[12]));
                    extractores.setChecked(Boolean.parseBoolean(Checks[13]));
                    tableros.setChecked(Boolean.parseBoolean(Checks[14]));
                    cocinas.setChecked(Boolean.parseBoolean(Checks[15]));
                    sanitarios.setChecked(Boolean.parseBoolean(Checks[16]));
                    check.setChecked(Boolean.parseBoolean(Checks[17]));
                    Direccion.setChecked(Boolean.parseBoolean(Checks[18]));
                    jefe.setChecked(Boolean.parseBoolean(Checks[19]));

                    String[] ChecksEsc = Escalera.split(",");

                    peines.setChecked(Boolean.parseBoolean(ChecksEsc[0]));
                    demarcaciones.setChecked(Boolean.parseBoolean(ChecksEsc[1]));
                    fosas.setChecked(Boolean.parseBoolean(ChecksEsc[2]));
                    pasamanos.setChecked(Boolean.parseBoolean(ChecksEsc[3]));
                    funcionamiento.setChecked(Boolean.parseBoolean(ChecksEsc[4]));

                    String[] ChecksEle = Elevadores.split(",");

                    cables.setChecked(Boolean.parseBoolean(ChecksEle[0]));
                    poleas.setChecked(Boolean.parseBoolean(ChecksEle[1]));
                    correcto.setChecked(Boolean.parseBoolean(ChecksEle[2]));

                    String[] ChecksMon = Montacargas.split(",");

                    correctos.setChecked(Boolean.parseBoolean(ChecksMon[0]));
                    correctas.setChecked(Boolean.parseBoolean(ChecksMon[1]));
                    correcto1.setChecked(Boolean.parseBoolean(ChecksMon[2]));

                    String[] ChecksBci = BCI.split(",");

                    combustion.setChecked(Boolean.parseBoolean(ChecksBci[0]));
                    electrica.setChecked(Boolean.parseBoolean(ChecksBci[1]));
                    bitacoras.setChecked(Boolean.parseBoolean(ChecksBci[2]));
                    orden.setChecked(Boolean.parseBoolean(ChecksBci[3]));
                    fugas.setChecked(Boolean.parseBoolean(ChecksBci[4]));

                    String[] ChecksPem = PEM.split(",");

                    prueba.setChecked(Boolean.parseBoolean(ChecksPem[0]));
                    cuenta1.setChecked(Boolean.parseBoolean(ChecksPem[1]));
                    limpieza1.setChecked(Boolean.parseBoolean(ChecksPem[2]));
                    presenta.setChecked(Boolean.parseBoolean(ChecksPem[3]));

                    String[] ChecksSub = Subestacion.split(",");

                    correcto2.setChecked(Boolean.parseBoolean(ChecksSub[0]));
                    encuentran.setChecked(Boolean.parseBoolean(ChecksSub[1]));
                    orden1.setChecked(Boolean.parseBoolean(ChecksSub[2]));
                    zonas1.setChecked(Boolean.parseBoolean(ChecksSub[3]));

                    String[] ChecksChell = Chillers.split(",");

                    equipo.setChecked(Boolean.parseBoolean(ChecksChell[0]));
                    se.setChecked(Boolean.parseBoolean(ChecksChell[1]));
                    tienen.setChecked(Boolean.parseBoolean(ChecksChell[2]));
                    limpieza2.setChecked(Boolean.parseBoolean(ChecksChell[3]));

                    String[] ChecksBom = Bombas.split(",");

                    operando.setChecked(Boolean.parseBoolean(ChecksBom[0]));
                    presenta.setChecked(Boolean.parseBoolean(ChecksBom[1]));

                    String[] ChecksTorres = Torres.split(",");

                    correcto3.setChecked(Boolean.parseBoolean(ChecksTorres[0]));
                    orden2.setChecked(Boolean.parseBoolean(ChecksTorres[1]));
                    fugas2.setChecked(Boolean.parseBoolean(ChecksTorres[2]));

                    String[] ChecksChi = CheckList.split(",");

                    herramienta.setChecked(Boolean.parseBoolean(ChecksChi[0]));
                    epi.setChecked(Boolean.parseBoolean(ChecksChi[1]));
                    sgi.setChecked(Boolean.parseBoolean(ChecksChi[2]));

                    etDgc.setText(Director);
                    etMotivo.setText(Motivo);
                    etSitio.setText(Sitio);
                    etSector.setText(Sector);
                    etProyecto.setText(Proyecto);

                    detalles.setText(Detalles);
                    peticiones.setText(Peticiones);

                    detalles1.setText(Detalles1);
                    peticiones1.setText(Peticiones1);
                    detalles2.setText(Detalles2);
                    peticiones2.setText(Peticiones2);
                    detalles3.setText(Detalles3);
                    peticiones3.setText(Peticiones3);
                    detalles4.setText(Detalles4);
                    peticiones4.setText(Peticiones4);
                    detalles5.setText(Detalles5);
                    peticiones5.setText(Peticiones5);
                    detalles6.setText(Detalles6);
                    peticiones6.setText(Peticiones6);
                    detalles7.setText(Detalles7);
                    peticiones7.setText(Peticiones7);
                    detalles8.setText(Detalles8);
                    peticiones8.setText(Peticiones8);
                    detalles9.setText(Detalles9);
                    peticiones9.setText(Peticiones9);
                    detalles10.setText(Detalles10);
                    peticiones10.setText(Peticiones10);
                    detalles11.setText(Detalles11);
                    peticiones11.setText(Peticiones11);
                    detalles12.setText(Detalles12);
                    peticiones12.setText(Peticiones12);
                    detalles13.setText(Detalles13);
                    peticiones13.setText(Peticiones13);
                    detalles14.setText(Detalles14);
                    peticiones14.setText(Peticiones14);
                    detalles15.setText(Detalles15);
                    peticiones15.setText(Peticiones15);
                    detalles16.setText(Detalles16);
                    peticiones16.setText(Peticiones16);
                    detalles17.setText(Detalles17);
                    peticiones17.setText(Peticiones17);
                    detalles18.setText(Detalles18);
                    peticiones18.setText(Peticiones18);
                    etPromesas.setText(Promesas);
                    detalles19.setText(Detalles19);
                    peticiones19.setText(Peticiones19);
                    etPromesas1.setText(Promesas1);
                    etObservaciones.setText(Coordinador);
                    etObservaciones1.setText(Jefe);
                    firmaTec = FirmaTec;
                    firmanteTec = Firmante;
                    firmaResp = FirmaRes;
                    firmanteResp = Firmanres;

                    Ischeckzonas();
                    Ischeckescalera();
                    Ischeckelevadores();
                    Ischeckmontecargas();
                    Ischeckbci();
                    Ischeckpem();
                    Ischecksubestacion();
                    Ischeckchillers();
                    Ischeckbombas();
                    Ischecktorres();
                    Ischeckchecklist();

                    for (i=0; i< fotosg.size(); i++){
                        String str = fotosg.get(i).substring(9);
                        String idImg = "";

                        if(i+1 < 10)
                            idImg = "Imagen0"+(i+1) + ":";
                        else
                            idImg = "Imagen"+(i+1) + ":";

                        fotos.add(idImg+convertirimagen(str));
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

    public class getSitio extends AsyncTask<Void, Void, Void>{
        private String respuesta = "{'d':''}";
        String url = URLGPS + "EnvioFormIT.aspx/GetSitios";

        public getSitio() { }

        @Override
        protected Void doInBackground(Void... voids) {
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


                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(con.getOutputStream());
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

                } else {
                    Gson gsonFrom = new Gson();
                    Log.e("Nota", con.getResponseMessage());

                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            String json = respuesta;
            JSONObject obj;
            try {
                obj = new JSONObject(json);
                JSONArray jsonArray = obj.getJSONArray("d");
                int tamanhioJson = jsonArray.length();
                sitios = new String[tamanhioJson];
                for(int x=0; x<tamanhioJson; x++){
                    sitios[x] = jsonArray.get(x).toString();
                }
              /*  ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext,R.layout.support_simple_spinner_dropdown_item, sitios);
                autoCompleteTextView.setAdapter(adapter);*/

            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

    public class getEquipo extends AsyncTask<Void, Void, Void>{
        private String respuesta = "{'d':''}";
        String url = URLGPS + "EnvioFormIT.aspx/GetEquipos";
        String sitio = "";
        public getEquipo(String site) { this.sitio = site;  }

        @Override
        protected Void doInBackground(Void... voids) {
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

                JSONObject posiciones = new JSONObject();
                posiciones.put("sitio", sitio);

                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(con.getOutputStream());
                outputStreamWriter.write(posiciones.toString());
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

                } else {
                    Gson gsonFrom = new Gson();
                    Log.e("Nota", con.getResponseMessage());

                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            String json = respuesta;
            JSONObject obj;
            try {
                obj = new JSONObject(json);
                JSONArray jsonArray = obj.getJSONArray("d");
                int tamanhioJson = jsonArray.length();
                equipos = new String[tamanhioJson];
                for(int x=0; x<tamanhioJson; x++){
                    equipos[x] = jsonArray.get(x).toString();
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext,R.layout.support_simple_spinner_dropdown_item, equipos);
                autoCompleteEquipo.setAdapter(adapter);

            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

    public class taskZonaPuntosdeInicioOT2 extends AsyncTask<Void, Void, Boolean> {
        private String formualrio;
        private String respuesta = "{'d':''}";
        MyOpenHelper dbHelper = new MyOpenHelper(mContext);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String url = URLGPS + "EnvioFormAuditoria.aspx/GuardarAuditoria";
        public taskZonaPuntosdeInicioOT2(String formualrio) {
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

                con.setConnectTimeout(150000);
                con.setReadTimeout(150000);

                formualrio = "{\"formAudi\":" + formualrio + "}";
               // Log.e("Nota", formualrio);

                //for



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
                    Log.e("Nota", "algo anda mal :P "+ url);
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
                if (JSON.getString("d").equals("Formulario repetido")) {
                    alertDialog.setTitle("Error");
                    alertDialog.setMessage("Este formulario ya está generado. Solicite al SAC cerrarlo.");
                    alertDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    });


                }
                else if(JSON.getString("d").equals("Formulario guardado y enviado por correo.")) {
                    alertDialog.setTitle("Hecho");
                    alertDialog.setMessage("Reporte enviado exitósamente.");
                    alertDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent detail = new Intent(mContext, Formatos.class);
                            startActivity(detail);
                            db.execSQL("DELETE FROM AUSQL");
                        }
                    });

                }else if(JSON.getString("d").equals("Error al guardar")) {
                    alertDialog.setTitle("Error");
                    alertDialog.setMessage("El reporte no se.");
                    alertDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                }

                else {
                    alertDialog.setTitle("Error");
                    alertDialog.setMessage("El reporte no se pudo enviar por que no tiene conexión a internet. "+JSON.getString("d"));
                    alertDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    //Toast.makeText(getApplicationContext(), "Error al enviar..", Toast.LENGTH_SHORT).show();
                }
                alertDialog.setCancelable(false);
                AlertDialog result = alertDialog.create();
                result.show();
            } catch (JSONException je) {
                je.printStackTrace();
            }
        }
    }
}



