package com.veolus.auditoria;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.text.SimpleDateFormat;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Form_Serv_Pem extends Activity {

    public static final String USER_CRED = "UserCredencials";
    private Context mContext;
    EditText etStartDate;
    EditText etFinishDate;
    EditText etSitio;
    EditText etSector;
    EditText etProyecto;
    EditText etNumOt;
    EditText etAsunto;
    EditText etObjetivo;
    EditText etAntecedentes;
    EditText etNivelCombTanqDia;
    EditText etNivelCombTanqMain;
    EditText etNivelComb;
    EditText etNivelAceite;
    EditText etPresionAceite;
    EditText etNivelAgua;
    EditText etElectrolito;
    EditText etTempOperacion;
    EditText etPorcentCargaAntesArr;
    EditText etPorcentCargaBateria;
    EditText etVoltBatArr;
    EditText etVoltBatStandBy;
    EditText etVoltAltArr;
    EditText etVoltAltStandBy;
    EditText etVoltGeneracion;
    EditText etTimeEnf;
    EditText etTimeTrans;
    EditText etTimeRTrans;
    EditText etLectura;
    EditText etMedicionCorrienteGen;
    EditText etTimeArr;
    EditText etTimeArrCS;
    EditText etTimeArrVacio;
    CheckBox cbAprieteTerminalCtrl;
    CheckBox cbDesulfatar;
    CheckBox cbCalibracionSensor;
    CheckBox cbEstadoBaterias;
    CheckBox cbFrecuenciaGen;
    CheckBox cbOperacionCargador;
    CheckBox cbSistemaLlenado;
    CheckBox cbTapon;
    CheckBox cbBandas;
    CheckBox cbMangueras;
    CheckBox cbOperacionTermo;
    CheckBox cbSimulacionFaltas;
    CheckBox cbInspeccionNivel;
    CheckBox cbDemandaCarga;
    CheckBox cbFugasAceiteAnti;
    CheckBox cbOperacionPrecalentadores;
    CheckBox cbRuidos;
    CheckBox cbFugas;
    CheckBox cbDensidad;
    CheckBox cbOperacionAlter;
    CheckBox cbVerTerminales;
    CheckBox cbLimpiezaEquipo;
    CheckBox cbLimpiezaRadiador;
    CheckBox cbPruebaArranqueCarga;
    CheckBox cbPruebaArranqueCS;
    CheckBox cbPruebaArranqueVacio;
    CheckBox cbSimularFallas;
    EditText etObserv;
    EditText etObserv1;
    EditText etConclusiones;
    EditText etRecomendaciones;
    EditText etCommentJFMtto;
    EditText etCorreo;
    EditText etNumEqNav;
    Button grabar;
    Button recuperar;
    Button borrar;
    Button btnOpenCamara;
    Button btnOpenCamara1;
    Button btnOpenCamara2;
    Button btnOpenCamara3;
    Button btnOpenCamara4;
    Button btnOpenCamara5;
    Button btnOpenCamara6;
    Button btnOpenCamara7;
    Button btnOpenCamara8;
    Button btnOpenCamara9;
    Button btnOpenCamara10;
    Button btnOpenCamara11;
    Button btnOpenCamara12;
    Button btnOpenCamara13;
    Button btnOpenCamara14;
    Button btnOpenCamara15;
    Button btnOpenCamara16;
    Button btnOpenCamara17;
    Button btnOpenCamara18;
    Button btnOpenCamara19;
    Button btnFirmaJFSitio;
    Button btnFirmaJFMtto;
    Button btnEnviaForm;

    private String firmaJFSitio = "";
    private String firmaJFMtto = "";
    private String NivelCombustibleTanqueDia = "";
    private String NivelCombustibleTanquePrincipal = "";
    private String NivelComb = "";
    private String NivelAceite = "";
    private String PresionAceite = "";
    private String NivelAgua = "";
    private String NivelElectrolito = "";
    private String TempreraturaOperacion = "";
    private String PorcentajeCargaAntesArranque = "";
    private String PorcentajeCargaBateria = "";
    private String VoltBateriaAlArranque = "";
    private String VoltBateriaStandBy = "";
    private String VoltAlternadorArrancar = "";
    private String VoltAlternadorStandBy = "";
    private String VoltGeneracion = "";
    private String TiempoEnfriamiento = "";
    private String TiempoTransferencia = "";
    private String TiempoRetransferencia = "";
    private String LecturaHorometro = "";
    private String MedicionCorrienteGeneracion = "";
    private String TiempoArranque = "";
    private String TiempoArranqueCSCarga = "";
    private String TiempoArranqueVacioCarga = "";
    // lista de fotos base64
    private List<String> fotos = new ArrayList<String>();
    // auxiliar de lista de fotos para sqlite, en el cual se guarda el path de la foto
    private List<String> fotosg = new ArrayList<String>();
    private Boolean AprieteTerminalesControl = false;
    private Boolean DesulfatarTerminalesBaterias = false;
    private Boolean CalibracionSensorVolt = false;
    private Boolean EstadoBaterias = false;
    private Boolean FrecuenciaGeneracion = false;
    private Boolean OperacionCargadorBaterias = false;
    private Boolean SistemaLlenadoComb = false;
    private Boolean TaponRadiador = false;
    private Boolean Bandas = false;
    private Boolean Mangueras = false;
    private Boolean OperacionTermostato = false;
    private Boolean SimulacionFallasEnergia = false;
    private Boolean InspeccionVisualNivelAceite = false;
    private Boolean DemandaCargaPlanta = false;
    private Boolean FugasAceiteAnticongelante = false;
    private Boolean NivelRefrigerante = false;
    private Boolean OperacionPrecalentadores = false;
    private Boolean TermostatoRefrigerante = false;
    private Boolean RuidosAnormales = false;
    private Boolean Fugas = false;
    private Boolean DensidadElectrolito = false;
    private Boolean OperacionAlternador = false;
    private Boolean VerTerminalesBaterias = false;
    private Boolean LimpiezaEquipo = false;
    private Boolean LimpiezaRadiador = false;
    private Boolean PruebaArranqueCarga = false;
    private Boolean PruebaArranqueCSCarga = false;
    private Boolean PruebaArranqueVacioCarga = false;
    private Boolean SimularFallasVelocidad = false;
    TextView tdate;
    private Form_Serv_Pem.taskEnviarFormToServiceWeb taskEnviarFormToServiceWeb = null;
    private static final String URLGPS = "http://www.veolus.com/gps/";
    //Calendario para obtener fecha & hora
    public final Calendar c = Calendar.getInstance();
    //Variables para obtener la hora hora
    final int hora = c.get(Calendar.HOUR_OF_DAY);
    final int minuto = c.get(Calendar.MINUTE);
    // sqlite
    MyOpenHelper dbHelper;
    SQLiteDatabase db;
    //Widgets
    EditText etHora;
    EditText etHora2;
    // gestión de fotos
    Bitmap bitmap;
    byte[] byteArray;
    String imagenString;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pem);
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
                            tdate = findViewById(R.id.fechaActual);
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

        etStartDate = findViewById(R.id.fechaInicio);
        etStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.fechaInicio:
                        showDatePickerDialogInicio();
                        break;
                }
            }
        });
        //Widget EditText donde se mostrara la hora obtenida
        etHora = (EditText) findViewById(R.id.et_hora_picker);
        etHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.et_hora_picker:
                        obtenerHora(R.id.et_hora_picker);
                        break;
                }
            }
        });
        etHora2 = (EditText) findViewById(R.id.et_hora_picker2);
        etHora2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.et_hora_picker2:
                        obtenerHora(R.id.et_hora_picker2);
                        break;
                }
            }
        });
        etFinishDate = findViewById(R.id.fechaFin);
        etFinishDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.fechaFin:
                        showDatePickerDialogFinish();
                        break;
                }
            }
        });
        etSitio = findViewById(R.id.sitio);
        etSector = findViewById(R.id.sector);
        etProyecto = findViewById(R.id.proyecto);
        etNumOt = findViewById(R.id.numOT);
        etAsunto = findViewById(R.id.asunto);
        etObjetivo = findViewById(R.id.objetivo);
        etAntecedentes = findViewById(R.id.antecedentes);
        etObserv = findViewById(R.id.observaciones);
        etObserv1 = findViewById(R.id.observaciones1);
        etConclusiones = findViewById(R.id.conclusiones);
        etRecomendaciones = findViewById(R.id.recomendaciones);
        etCommentJFMtto = findViewById(R.id.comentariosJefeMtto);
        etCorreo = findViewById(R.id.email);
        etNumEqNav = findViewById(R.id.numEquipoNav);
        etNivelCombTanqDia = findViewById(R.id.nivelCombTanqDia);
        etNivelCombTanqMain = findViewById(R.id.nivelCombTanqMain);
        etNivelComb = findViewById(R.id.nivelComb);
        etNivelAceite = findViewById(R.id.nivelOil);
        etPresionAceite = findViewById(R.id.presionAceite);
        etNivelAgua = findViewById(R.id.nivelAgua);
        etElectrolito = findViewById(R.id.nivelElecBateria);
        etTempOperacion = findViewById(R.id.TempOperacion);
        etPorcentCargaAntesArr = findViewById(R.id.porcentAntesArranque);
        etPorcentCargaBateria = findViewById(R.id.porcentCargaBateria);
        etVoltBatArr = findViewById(R.id.voltBateriaArranque);
        etVoltBatStandBy = findViewById(R.id.voltBatStandBy);
        etVoltAltArr = findViewById(R.id.voltAltArr);
        etVoltAltStandBy = findViewById(R.id.voltAltStandBy);
        etVoltGeneracion = findViewById(R.id.voltGen);
        etTimeEnf = findViewById(R.id.timeEnfria);
        etTimeTrans = findViewById(R.id.timeTrans);
        etTimeRTrans = findViewById(R.id.timeRTrans);
        etLectura = findViewById(R.id.lecHorometro);
        etMedicionCorrienteGen = findViewById(R.id.medicionCorriente);
        etTimeArr = findViewById(R.id.timeArr);
        etTimeArrCS = findViewById(R.id.timeArrCS);
        etTimeArrVacio = findViewById(R.id.timeArrVacio);
        /*cbDejarFueraEquipo = (CheckBox) findViewById(R.id.dejarFueraEquipo);
        cbLotto = (CheckBox) findViewById(R.id.lotto);
        cbAceite = (CheckBox) findViewById(R.id.aceite);
        cbFiltrosAceite = (CheckBox) findViewById(R.id.filtrosAceite);
        cbBaterias = (CheckBox) findViewById(R.id.baterias);
        cbTerminalesBaterias = (CheckBox) findViewById(R.id.terminalesBaterias);
        cbRefrigerante = (CheckBox) findViewById(R.id.refrigerante);
        cbFiltrosRefrigerante = (CheckBox) findViewById(R.id.filtrosRefrigerante);
        cbFiltrosAire = (CheckBox) findViewById(R.id.filtrosAire);
        cbManguerasPreca = (CheckBox) findViewById(R.id.manguerasPrecalentador);*/
        cbAprieteTerminalCtrl = findViewById(R.id.aprieteTerminalesControl);
        cbDesulfatar = findViewById(R.id.desulfatarterminalesBaterias);
        cbCalibracionSensor = findViewById(R.id.calibracionSensorVolt);
        cbEstadoBaterias = findViewById(R.id.estadoBaterias);
        cbFrecuenciaGen = findViewById(R.id.frecuenciaGeneracion);
        cbOperacionCargador = findViewById(R.id.operacionCargadorBaterias);
        cbSistemaLlenado = findViewById(R.id.sistemaLlenadoComb);
        cbTapon = findViewById(R.id.taponRadiador);
        cbBandas = findViewById(R.id.bandas);
        cbMangueras = findViewById(R.id.mangueras);
        cbOperacionTermo = findViewById(R.id.operacionTermostato);
        cbSimulacionFaltas = findViewById(R.id.simulacionFaltasEnergia);
        cbInspeccionNivel = findViewById(R.id.inspeccionNivelAceite);
        cbDemandaCarga = findViewById(R.id.demandaCargaPlanta);
        cbFugasAceiteAnti = findViewById(R.id.fugasAceiteAnticongelante);
        cbOperacionPrecalentadores = findViewById(R.id.operacionPrecalentadores);
        cbRuidos = findViewById(R.id.ruidosAnormales);
        cbFugas = findViewById(R.id.fugas);
        cbDensidad = findViewById(R.id.densidadElectrolito);
        cbOperacionAlter = findViewById(R.id.operacionAlternador);
        cbVerTerminales = findViewById(R.id.verTerminalesBaterias);
        cbLimpiezaEquipo = findViewById(R.id.limpiezaEquipo);
        cbLimpiezaRadiador = findViewById(R.id.limpiezaRadiador);
        cbPruebaArranqueCarga = findViewById(R.id.pruebaArranqueCarga);
        cbPruebaArranqueCS  = findViewById(R.id.pruebaArranqueCSCarga);
        cbPruebaArranqueVacio  = findViewById(R.id.pruebaArranqueVacio);
        cbSimularFallas = findViewById(R.id.simularFallasVelocidad);
        grabar = findViewById(R.id.grabrar);
        recuperar = findViewById(R.id.recuperar);
        borrar = findViewById(R.id.borrar);
        btnOpenCamara = findViewById(R.id.opencamara);
        btnOpenCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Foto01");
                startActivityForResult(in, 1);
            }
        });
        btnOpenCamara1 = findViewById(R.id.opencamara2);
        btnOpenCamara1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                in.putExtra("numFoto", "Foto02");
                startActivityForResult(in, 1);
            }
        });
        btnOpenCamara2 = findViewById(R.id.opencamara3);
        btnOpenCamara2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                in.putExtra("numFoto", "Foto03");

                startActivityForResult(in, 1);
            }
        });
        btnOpenCamara3 = findViewById(R.id.opencamara4);
        btnOpenCamara3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                in.putExtra("numFoto", "Foto04");

                startActivityForResult(in, 1);
            }
        });
        btnOpenCamara4 = findViewById(R.id.opencamara5);
        btnOpenCamara4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                in.putExtra("numFoto", "Foto05");

                startActivityForResult(in, 1);
            }
        });
        btnOpenCamara5 = findViewById(R.id.opencamara6);
        btnOpenCamara5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Foto06");

                startActivityForResult(in, 1);
            }
        });
        btnOpenCamara6 = findViewById(R.id.opencamara7);
        btnOpenCamara6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                in.putExtra("numFoto", "Foto07");

                startActivityForResult(in, 1);
            }
        });
        btnOpenCamara7 = findViewById(R.id.opencamara8);
        btnOpenCamara7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                in.putExtra("numFoto", "Foto08");

                startActivityForResult(in, 1);
            }
        });
        btnOpenCamara8 = findViewById(R.id.opencamara9);
        btnOpenCamara8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                in.putExtra("numFoto", "Foto09");

                startActivityForResult(in, 1);
            }
        });
        btnOpenCamara9 = findViewById(R.id.opencamara10);
        btnOpenCamara9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                in.putExtra("numFoto", "Foto10");

                startActivityForResult(in, 1);
            }
        });
        btnOpenCamara10 = findViewById(R.id.opencamara11);
        btnOpenCamara10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Foto11");

                startActivityForResult(in, 1);
            }
        });
        btnOpenCamara11 = findViewById(R.id.opencamara12);
        btnOpenCamara11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                in.putExtra("numFoto", "Foto12");

                startActivityForResult(in, 1);
            }
        });
        btnOpenCamara12 = findViewById(R.id.opencamara13);
        btnOpenCamara12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                in.putExtra("numFoto", "Foto13");

                startActivityForResult(in, 1);
            }
        });
        btnOpenCamara13 = findViewById(R.id.opencamara14);
        btnOpenCamara13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                in.putExtra("numFoto", "Foto14");

                startActivityForResult(in, 1);
            }
        });
        btnOpenCamara14 = findViewById(R.id.opencamara15);
        btnOpenCamara14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                in.putExtra("numFoto", "Foto15");

                startActivityForResult(in, 1);
            }
        });
        btnOpenCamara15 = findViewById(R.id.opencamara16);
        btnOpenCamara15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Foto16");

                startActivityForResult(in, 1);
            }
        });
        btnOpenCamara16 = findViewById(R.id.opencamara17);
        btnOpenCamara16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                in.putExtra("numFoto", "Foto17");

                startActivityForResult(in, 1);
            }
        });
        btnOpenCamara17 = findViewById(R.id.opencamara18);
        btnOpenCamara17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                in.putExtra("numFoto", "Foto18");

                startActivityForResult(in, 1);
            }
        });
        btnOpenCamara18 = findViewById(R.id.opencamara19);
        btnOpenCamara18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                in.putExtra("numFoto", "Foto19");

                startActivityForResult(in, 1);
            }
        });
        btnOpenCamara19 = findViewById(R.id.opencamara20);
        btnOpenCamara19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                in.putExtra("numFoto", "Foto20");

                startActivityForResult(in, 1);
            }
        });
        btnFirmaJFSitio = findViewById(R.id.btnFirmaJFSitio);
        btnFirmaJFSitio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), FirmaActivity.class);
                //0 para regresar firma del responsable de sitio y 1 para regresar firmadel tecnico
                in.putExtra("FirmaDE", 0);
                startActivityForResult(in, 1);

            }
        });
        btnFirmaJFMtto = findViewById(R.id.btnFirmaJFMtto);
        btnFirmaJFMtto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), FirmaActivity.class);
                //0 para regresar firma del responsable de sitio y 1 para regresar firmadel tecnico
                in.putExtra("FirmaDE", 1);
                
                startActivityForResult(in, 1);

            }
        });
        btnEnviaForm = findViewById(R.id.btnEnviar);
        btnEnviaForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarFormulario();
            }
        });
    }

    private void showDatePickerDialogInicio() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                //Formateo el día obtenido: antepone el 0 si son menores de 10
                String diaFormateado = (day < 10)? "0" + String.valueOf(day):String.valueOf(day);
                //Formateo el mes obtenido: antepone el 0 si son menores de 10
                String mesFormateado = ((month + 1) < 10)? "0" + String.valueOf(month+1):String.valueOf(month+1);
                // +1 because january is zero
                final String selectedDate = diaFormateado + "/" + mesFormateado + "/" + year;
                etStartDate.setText(selectedDate);
            }
        });
        newFragment.show(this.getFragmentManager(), "datePicker");
    }

    private void showDatePickerDialogFinish() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                //Formateo el día obtenido: antepone el 0 si son menores de 10
                String diaFormateado = (day < 10)? "0" + String.valueOf(day):String.valueOf(day);
                //Formateo el mes obtenido: antepone el 0 si son menores de 10
                String mesFormateado = ((month + 1) < 10)? "0" + String.valueOf(month+1):String.valueOf(month+1);
                // +1 because january is zero
                final String selectedDate = diaFormateado + "/" + mesFormateado + "/" + year;
                etFinishDate.setText(selectedDate);
            }
        });
        newFragment.show(this.getFragmentManager(), "datePicker");
    }

    private void obtenerHora(int id){
        TimePickerDialog recogerHora = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                //Formateo el hora obtenido: antepone el 0 si son menores de 10
                String horaFormateada =  (hourOfDay < 10)? String.valueOf("0" + hourOfDay) : String.valueOf(hourOfDay);
                //Formateo el minuto obtenido: antepone el 0 si son menores de 10
                String minutoFormateado = (minute < 10)? String.valueOf("0" + minute):String.valueOf(minute);
                //Obtengo el valor a.m. o p.m., dependiendo de la selección del usuario
                String AM_PM;
                if(hourOfDay < 12) {
                    AM_PM = "a.m.";
                } else {
                    AM_PM = "p.m.";
                }
                //Muestro la hora con el formato deseado
                switch (id){
                    case R.id.et_hora_picker:
                        etHora.setText(horaFormateada + ":" + minutoFormateado + " " + AM_PM);
                        break;
                    case R.id.et_hora_picker2:
                        etHora2.setText(horaFormateada + ":" + minutoFormateado + " " + AM_PM);
                        break;
                }

            }
            //Estos valores deben ir en ese orden
            //Al colocar en false se muestra en formato 12 horas y true en formato 24 horas
            //Pero el sistema devuelve la hora en formato 24 horas
        }, hora, minuto, false);

        recogerHora.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            if ("vacio".equals(data.getStringExtra("FirmaRESP"))) {
                firmaJFSitio = data.getStringExtra("FirmaTEC");
                if (firmaJFSitio != "" && firmaJFSitio !=""){
                    btnFirmaJFSitio.setEnabled(false);
                }
            } else if ("vacio".equals(data.getStringExtra("FirmaTEC"))) {
                firmaJFMtto = data.getStringExtra("FirmaRESP");
                if (firmaJFMtto != "" && firmaJFMtto !=""){
                    btnFirmaJFMtto.setEnabled(false);
                }
            }
            if ("vacio".equals(data.getStringExtra("FotoDos")) && "vacio".equals(data.getStringExtra("FotoTres")) && "vacio".equals(data.getStringExtra("FotoCuatro")) && "vacio".equals(data.getStringExtra("FotoCnco"))) {
                imagenString = convertirimagen(data.getStringExtra("FotoUno"));
                fotosg.add(data.getStringExtra("numFoto") + ":" + data.getStringExtra("FotoUno"));
                fotos.add(data.getStringExtra("numFoto") + ":" + imagenString);
                DisabledButtonCam(data.getStringExtra("numFoto"));
            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoTres")) && "vacio".equals(data.getStringExtra("FotoCuatro")) && "vacio".equals(data.getStringExtra("FotoCnco"))) {
                imagenString = convertirimagen(data.getStringExtra("FotoDos"));
                fotosg.add(data.getStringExtra("numFoto") + ":" + data.getStringExtra("FotoDos"));
                fotos.add(data.getStringExtra("numFoto") + ":" + imagenString);
                DisabledButtonCam(data.getStringExtra("numFoto"));
            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoDos")) && "vacio".equals(data.getStringExtra("FotoCuatro")) && "vacio".equals(data.getStringExtra("FotoCnco"))) {
                imagenString = convertirimagen(data.getStringExtra("FotoTres"));
                fotosg.add(data.getStringExtra("numFoto") + ":" + data.getStringExtra("FotoTres"));
                fotos.add(data.getStringExtra("numFoto") + ":" + imagenString);
                DisabledButtonCam(data.getStringExtra("numFoto"));
            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoDos")) && "vacio".equals(data.getStringExtra("FotoTres")) && "vacio".equals(data.getStringExtra("FotoCnco"))) {
                imagenString = convertirimagen(data.getStringExtra("FotoCuatro"));
                fotosg.add(data.getStringExtra("numFoto") + ":" + data.getStringExtra("FotoCuatro"));
                fotos.add(data.getStringExtra("numFoto") + ":" + imagenString);
                DisabledButtonCam(data.getStringExtra("numFoto"));
            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoDos")) && "vacio".equals(data.getStringExtra("FotoTres")) && "vacio".equals(data.getStringExtra("FotoCuatro"))) {
                imagenString = convertirimagen(data.getStringExtra("FotoCnco"));
                fotosg.add(data.getStringExtra("numFoto") + ":" + data.getStringExtra("FotoCnco"));
                fotos.add(data.getStringExtra("numFoto") + ":" + imagenString);
                DisabledButtonCam(data.getStringExtra("numFoto"));
            }

        }
    }

    private  void DisabledButtonCam(String numFoto){
        if(numFoto.equals("Foto01")){
            btnOpenCamara.setEnabled(false);
        }
        else if(numFoto.equals("Foto02")){
            btnOpenCamara1.setEnabled(false);
        }
        else if(numFoto.equals("Foto03")){
            btnOpenCamara2.setEnabled(false);
        }
        else if(numFoto.equals("Foto04")){
            btnOpenCamara3.setEnabled(false);
        }
        else if(numFoto.equals("Foto05")){
            btnOpenCamara4.setEnabled(false);
        }
        else if(numFoto.equals("Foto06")){
            btnOpenCamara5.setEnabled(false);
        }
        else if(numFoto.equals("Foto07")){
            btnOpenCamara6.setEnabled(false);
        }
        else if(numFoto.equals("Foto08")){
            btnOpenCamara7.setEnabled(false);
        }
        else if(numFoto.equals("Foto09")){
            btnOpenCamara8.setEnabled(false);
        }
        else if(numFoto.equals("Foto10")){
            btnOpenCamara9.setEnabled(false);
        }
        else if(numFoto.equals("Foto11")){
            btnOpenCamara10.setEnabled(false);
        }
        else if(numFoto.equals("Foto12")){
            btnOpenCamara11.setEnabled(false);
        }
        else if(numFoto.equals("Foto13")){
            btnOpenCamara12.setEnabled(false);
        }
        else if(numFoto.equals("Foto14")){
            btnOpenCamara13.setEnabled(false);
        }
        else if(numFoto.equals("Foto15")){
            btnOpenCamara14.setEnabled(false);
        }
        else if(numFoto.equals("Foto16")){
            btnOpenCamara15.setEnabled(false);
        }
        else if(numFoto.equals("Foto17")){
            btnOpenCamara16.setEnabled(false);
        }
        else if(numFoto.equals("Foto18")){
            btnOpenCamara17.setEnabled(false);
        }
        else if(numFoto.equals("Foto19")){
            btnOpenCamara18.setEnabled(false);
        }
        else if(numFoto.equals("Foto20")){
            btnOpenCamara19.setEnabled(false);
        }
    }

    private void validarChecklist(){
        NivelCombustibleTanqueDia = etNivelCombTanqDia.getText().toString();
        NivelCombustibleTanquePrincipal = etNivelCombTanqMain.getText().toString();
        NivelComb = etNivelComb.getText().toString();
        NivelAceite = etNivelAceite.getText().toString();
        PresionAceite = etPresionAceite.getText().toString();
        NivelAgua = etNivelAgua.getText().toString();
        NivelElectrolito = etElectrolito.getText().toString();
        TempreraturaOperacion = etTempOperacion.getText().toString();
        PorcentajeCargaAntesArranque = etPorcentCargaAntesArr.getText().toString();
        PorcentajeCargaBateria = etPorcentCargaBateria.getText().toString();
        VoltBateriaAlArranque = etVoltAltArr.getText().toString();
        VoltBateriaStandBy = etVoltAltStandBy.getText().toString();
        VoltAlternadorArrancar = etVoltAltArr.getText().toString();
        VoltAlternadorStandBy = etVoltAltStandBy.getText().toString();
        VoltGeneracion = etVoltGeneracion.getText().toString();
        TiempoEnfriamiento = etTimeEnf.getText().toString();
        TiempoTransferencia = etTimeTrans.getText().toString();
        TiempoRetransferencia = etTimeRTrans.getText().toString();
        LecturaHorometro = etLectura.getText().toString();
        MedicionCorrienteGeneracion = etMedicionCorrienteGen.getText().toString();
        TiempoArranque = etTimeArr.getText().toString();
        TiempoArranqueCSCarga = etTimeArrCS.getText().toString();
        TiempoArranqueVacioCarga = etTimeArrVacio.getText().toString();

        if(cbAprieteTerminalCtrl.isChecked()){
            AprieteTerminalesControl = true;
        }
        if(cbDesulfatar.isChecked()) {
            DesulfatarTerminalesBaterias = true;
        }
        if(cbCalibracionSensor.isChecked()){
            CalibracionSensorVolt = true;
        }
        if(cbEstadoBaterias.isChecked()){
            EstadoBaterias = true;
        }
        if(cbFrecuenciaGen.isChecked()){
            FrecuenciaGeneracion = true;
        }
        if(cbOperacionCargador.isChecked()){
            OperacionCargadorBaterias = true;
        }
        if(cbSistemaLlenado.isChecked()){
            SistemaLlenadoComb = true;
        }
        if(cbTapon.isChecked()){
            TaponRadiador = true;
        }
        if(cbBandas.isChecked()){
            Bandas = true;
        }
        if(cbMangueras.isChecked()){
            Mangueras = true;
        }
        if(cbOperacionTermo.isChecked()){
            OperacionTermostato = true;
        }
        if(cbSimulacionFaltas.isChecked()){
            SimulacionFallasEnergia= true;
        }
        if(cbInspeccionNivel.isChecked()){
            InspeccionVisualNivelAceite = true;
        }
        if(cbDemandaCarga.isChecked()){
            DemandaCargaPlanta = true;
        }
        if(cbFugasAceiteAnti.isChecked()){
            FugasAceiteAnticongelante = true;
        }
        if(cbOperacionPrecalentadores.isChecked()){
            OperacionPrecalentadores = true;
        }
        if(cbRuidos.isChecked()){
            RuidosAnormales = true;
        }
        if(cbFugas.isChecked()){
            Fugas = true;
        }
        if(cbDensidad.isChecked()){
            DensidadElectrolito = true;
        }
        if(cbOperacionAlter.isChecked()){
            OperacionAlternador = true;
        }
        if(cbVerTerminales.isChecked()){
            VerTerminalesBaterias = true;
        }
        if(cbLimpiezaEquipo.isChecked()){
            LimpiezaEquipo = true;
        }
        if(cbLimpiezaRadiador.isChecked()){
            LimpiezaRadiador = true;
        }
        if(cbPruebaArranqueCarga.isChecked()){
            PruebaArranqueCarga = true;
        }
        if(cbPruebaArranqueCS.isChecked()){
            PruebaArranqueCSCarga = true;
        }
        if(cbPruebaArranqueVacio.isChecked()){
            PruebaArranqueVacioCarga = true;
        }
        if(cbSimularFallas.isChecked()){
            SimularFallasVelocidad = true;
        }
    }

    private Boolean ContainsAny(String haystack, Iterable<String> needles)
    {
        Boolean condition = false;
        for (String elem : needles)
        {
            String el = elem.substring(0, 6);
            if (el.equals(haystack))
            {
                return true;
            }
        }
        return condition;
    }
    //Envia la información del fromulario a la BD y C#
    private void enviarFormulario() {
        validarChecklist();
        // Banderas de validaciones por zona
        if(!ContainsAny("Foto01", fotos) && !ContainsAny("Foto02", fotos)){
            Toast.makeText(this, "Se requieren fotos para el check de 'ACEITE'", Toast.LENGTH_SHORT).show();
        }
        else if(!ContainsAny("Foto03", fotos) && !ContainsAny("Foto04", fotos)){
            Toast.makeText(this, "Se requieren fotos para el check de 'FILTROS DE ACEITE'", Toast.LENGTH_SHORT).show();
        }
        /*else if(!ContainsAny("Foto05", fotos) && !ContainsAny("Foto06", fotos)){
            Toast.makeText(this, "Se requieren fotos para el check de 'BATERIAS'", Toast.LENGTH_SHORT).show();
        }*/
        else if(!ContainsAny("Foto07", fotos) && !ContainsAny("Foto08", fotos)){
            Toast.makeText(this, "Se requieren fotos para el check de 'TERMINALES DE BATERIAS'", Toast.LENGTH_SHORT).show();
        }
        else if(!ContainsAny("Foto09", fotos) && !ContainsAny("Foto10", fotos)){
            Toast.makeText(this, "Se requieren fotos para el check de 'REFRIGERANTE'", Toast.LENGTH_SHORT).show();
        }
        else if(!ContainsAny("Foto11", fotos) && !ContainsAny("Foto12", fotos)){
            Toast.makeText(this, "Se requieren fotos para el check de 'FILTROS DE REFRIGERANTE'", Toast.LENGTH_SHORT).show();
        }
        else if(!ContainsAny("Foto13", fotos) && !ContainsAny("Foto14", fotos)){
            Toast.makeText(this, "Se requieren fotos para el check de 'FILTROS DE AIRE'", Toast.LENGTH_SHORT).show();
        }
        /*else if(!ContainsAny("Foto15", fotos) && !ContainsAny("Foto16", fotos)){
            Toast.makeText(this, "Se requieren fotos para el check de 'MANGUERAS DE PRECALENTADOR'", Toast.LENGTH_SHORT).show();
        }*/
        else if(!ContainsAny("Foto17", fotos)){
            Toast.makeText(this, "Se requiere foto para el check de 'LIMPIEZA DEL EQUIPO'", Toast.LENGTH_SHORT).show();
        }
        else if(!ContainsAny("Foto18", fotos)){
            Toast.makeText(this, "Se requiere foto para el check de 'LIMPIEZA DEL RADIADOR'", Toast.LENGTH_SHORT).show();
        }
        else if(!ContainsAny("Foto19", fotos) && !ContainsAny("Foto20", fotos)){
            Toast.makeText(this, "Se requieren fotos para la sección de 'MEDICIÓN Y REGISTRO'", Toast.LENGTH_SHORT).show();
        }
        else if(firmaJFSitio == ""){
            Toast.makeText(this, "Se requiere la firma del Jefe de sitio", Toast.LENGTH_SHORT).show();
        }
        else if(firmaJFMtto == ""){
            Toast.makeText(this, "Se requiere la firma del Jefe de Mantenimiento", Toast.LENGTH_SHORT).show();
        }
        else {
            btnEnviaForm.setEnabled(false);
            Bundle extras = getIntent().getExtras();
            Toast.makeText(this, "Enviando Formulario", Toast.LENGTH_LONG).show();
            Gson gsonFrom = new Gson();
            StoreFormServPem miForm = new StoreFormServPem();
            miForm.setFechaActual(tdate.getText().toString());
            miForm.setFechaInicio(etStartDate.getText().toString() + " " + etHora.getText().toString());
            miForm.setFechaFin(etFinishDate.getText().toString() + " " + etHora2.getText().toString());
            miForm.setSitio(etSitio.getText().toString());
            miForm.setSector(etSector.getText().toString());
            miForm.setProyecto(etProyecto.getText().toString());
            miForm.setObjetivo(etObjetivo.getText().toString());
            miForm.setObservaciones(etObserv.getText().toString());
            miForm.setObservaciones1(etObserv1.getText().toString());
            miForm.setNumOT(etNumOt.getText().toString());
            miForm.setAntecedentes(etAntecedentes.getText().toString());
            miForm.setNivelCombustibleTanqueDia(NivelCombustibleTanqueDia);
            miForm.setNivelCombustibleTanquePrincipal(NivelCombustibleTanquePrincipal);
            miForm.setNivelComb(NivelComb);
            miForm.setNivelAceite(NivelAceite);
            miForm.setPresionAceite(PresionAceite);
            miForm.setNivelAgua(NivelAgua);
            miForm.setNivelElectrolito(NivelElectrolito);
            miForm.setTempreraturaOperacion(TempreraturaOperacion);
            miForm.setPorcentajeCargaAntesArranque(PorcentajeCargaAntesArranque);
            miForm.setPorcentajeCargaBateria(PorcentajeCargaBateria);
            miForm.setVoltBateriaAlArranque(VoltBateriaAlArranque);
            miForm.setVoltBateriaStandBy(VoltBateriaStandBy);
            miForm.setVoltAlternadorArrancar(VoltAlternadorArrancar);
            miForm.setVoltAlternadorStandBy(VoltAlternadorStandBy);
            miForm.setVoltGeneracion(VoltGeneracion);
            miForm.setTiempoEnfriamiento(TiempoEnfriamiento);
            miForm.setTiempoTransferencia(TiempoTransferencia);
            miForm.setTiempoRetransferencia(TiempoRetransferencia);
            miForm.setLecturaHorometro(LecturaHorometro);
            miForm.setMedicionCorrienteGeneracion(MedicionCorrienteGeneracion);
            miForm.setTiempoArranque(TiempoArranque);
            miForm.setTiempoArranqueCSCarga(TiempoArranqueCSCarga);
            miForm.setTiempoArranqueVacioCarga(TiempoArranqueVacioCarga);
            miForm.setAprieteTerminalesControl(AprieteTerminalesControl);
            miForm.setDesulfatarTerminalesBaterias(DesulfatarTerminalesBaterias);
            miForm.setCalibracionSensorVolt(CalibracionSensorVolt);
            miForm.setEstadoBaterias(EstadoBaterias);
            miForm.setFrecuenciaGeneracion(FrecuenciaGeneracion);
            miForm.setOperacionCargadorBaterias(OperacionCargadorBaterias);
            miForm.setSistemaLlenadoComb(SistemaLlenadoComb);
            miForm.setTaponRadiador(TaponRadiador);
            miForm.setBandas(Bandas);
            miForm.setMangueras(Mangueras);
            miForm.setOperacionTermostato(OperacionTermostato);
            miForm.setSimulacionFallasEnergia(SimulacionFallasEnergia);
            miForm.setInspeccionVisualNivelAceite(InspeccionVisualNivelAceite);
            miForm.setDemandaCargaPlanta(DemandaCargaPlanta);
            miForm.setFugasAceiteAnticongelante(FugasAceiteAnticongelante);
            miForm.setNivelRefrigerante(NivelRefrigerante);
            miForm.setOperacionPrecalentadores(OperacionPrecalentadores);
            miForm.setTermostatoRefrigerante(TermostatoRefrigerante);
            miForm.setRuidosAnormales(RuidosAnormales);
            miForm.setFugas(Fugas);
            miForm.setDensidadElectrolito(DensidadElectrolito);
            miForm.setOperacionAlternador(OperacionAlternador);
            miForm.setVerTerminalesBaterias(VerTerminalesBaterias);
            /*miForm.setLimpiezaEquipo(LimpiezaEquipo);
            miForm.setLimpiezaRadiador(LimpiezaRadiador);*/
            miForm.setPruebaArranqueCarga(PruebaArranqueCarga);
            miForm.setPruebaArranqueCSCarga(PruebaArranqueCSCarga);
            miForm.setPruebaArranqueVacioCarga(PruebaArranqueVacioCarga);
            miForm.setSimularFallasVelocidad(SimularFallasVelocidad);
            miForm.setComentariosJefeMtto(etCommentJFMtto.getText().toString());
            miForm.setEmail(etCorreo.getText().toString());
            miForm.setNumEquipoNav(etNumEqNav.getText().toString());
            miForm.setConclusiones(etConclusiones.getText().toString());
            miForm.setRecomendaciones(etRecomendaciones.getText().toString());
            miForm.setFirmaJFSitio(firmaJFSitio);
            miForm.setFirmaJFMtto(firmaJFMtto);
            miForm.setFotos(fotos);
            try {
                taskEnviarFormToServiceWeb = new taskEnviarFormToServiceWeb(gsonFrom.toJson(miForm));
                Toast.makeText(this, "Procesando solicitud", Toast.LENGTH_LONG).show();
                taskEnviarFormToServiceWeb.execute((Void) null);
                //return true;
            }catch (Exception e){
                //return false;
            }
        }
    }

    public void borrar(View view) {
        db.execSQL("DELETE FROM PEM");
        Toast.makeText(this, "Los datos se han borrado", Toast.LENGTH_SHORT).show();
    }

    public void grabarau(View view) {
        dbHelper = new MyOpenHelper(this);
        db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM PEMSQL", null);
        ContentValues cv = insertsql();
        if (c.getCount() ==0){
            db.insert("PEMSQL", null, cv);
            Toast.makeText(this, "Los datos han sigo grabados", Toast.LENGTH_SHORT).show();
        } else {
            c.moveToFirst();
            int id = c.getInt(c.getColumnIndex("_id"));
            db.update("PEMSQL",  cv, "_id="+id, null);
            Toast.makeText(this, "Los datos se han actualizado", Toast.LENGTH_SHORT).show();
        }
        c.close();
        db.close();
    }

    public void recuperarau(View view) {
        dbHelper = new MyOpenHelper(this);
        db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM PEMSQL", null);
        if (c.getCount() != 0 ) {
            c.moveToFirst();
            do{
                etStartDate.setText(c.getString(c.getColumnIndex("Fechainicio")));
                etHora.setText(c.getString(c.getColumnIndex("Horainicio")));
                etFinishDate.setText(c.getString(c.getColumnIndex("Fechafinal")));
                etHora2.setText(c.getString(c.getColumnIndex("Horafinal")));
                etSitio.setText(c.getString(c.getColumnIndex("Sitio")));
                etSector.setText(c.getString(c.getColumnIndex("Sector")));
                etProyecto.setText(c.getString(c.getColumnIndex("Proyecto")));
                etNumOt.setText(c.getString(c.getColumnIndex("OT")));
                etAntecedentes.setText(c.getString(c.getColumnIndex("Antecedentes")));
                etNivelCombTanqDia.setText(c.getString(c.getColumnIndex("Tanquedia")));
                etNivelCombTanqMain.setText(c.getString(c.getColumnIndex("Tanqueprin")));
                etNivelComb.setText(c.getString(c.getColumnIndex("Nivelcombus")));
                etNivelAceite.setText(c.getString(c.getColumnIndex("Aceite")));
                etPresionAceite.setText(c.getString(c.getColumnIndex("Presionace")));
                etNivelAgua.setText(c.getString(c.getColumnIndex("Nivelagua")));
                etElectrolito.setText(c.getString(c.getColumnIndex("Electrolito")));
                etTempOperacion.setText(c.getString(c.getColumnIndex("Temperatura")));
                etPorcentCargaAntesArr.setText(c.getString(c.getColumnIndex("Carga")));
                etPorcentCargaBateria.setText(c.getString(c.getColumnIndex("Bateria")));
                etVoltBatArr.setText(c.getString(c.getColumnIndex("Voltaje")));
                etVoltBatStandBy.setText(c.getString(c.getColumnIndex("Standby")));
                etVoltAltArr.setText(c.getString(c.getColumnIndex("Alternadorarra")));
                etVoltAltStandBy.setText(c.getString(c.getColumnIndex("Alternadorby")));
                etVoltGeneracion.setText(c.getString(c.getColumnIndex("Generacion")));
                etTimeEnf.setText(c.getString(c.getColumnIndex("Enfriamento")));
                etTimeTrans.setText(c.getString(c.getColumnIndex("Transferencia")));
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
                String Apriete = c.getString(c.getColumnIndex("Aprieta"));
                String Revisar = c.getString(c.getColumnIndex("Revisar"));
                String Verificar = c.getString(c.getColumnIndex("Verificar"));
                String Limpieza = c.getString(c.getColumnIndex("Limpieza"));
                String Medicion = c.getString(c.getColumnIndex("Medicion"));
                String [] ima = null;

                String[] Checks1 = Apriete.split(", ");
                String[] Checks2 = Revisar.split(", ");
                String[] Checks3 = Verificar.split(", ");
                String[] Checks4 = Limpieza.split(", ");
                String[] Checks5 = Medicion.split(", ");

                cbAprieteTerminalCtrl.setChecked(Boolean.parseBoolean(Checks1[0]));
                cbDesulfatar.setChecked(Boolean.parseBoolean(Checks1[1]));
                cbCalibracionSensor.setChecked(Boolean.parseBoolean(Checks2[0]));
                cbEstadoBaterias.setChecked(Boolean.parseBoolean(Checks2[1]));
                cbFrecuenciaGen.setChecked(Boolean.parseBoolean(Checks2[2]));
                cbOperacionCargador.setChecked(Boolean.parseBoolean(Checks2[3]));
                cbSistemaLlenado.setChecked(Boolean.parseBoolean(Checks2[4]));
                cbTapon.setChecked(Boolean.parseBoolean(Checks2[5]));
                cbBandas.setChecked(Boolean.parseBoolean(Checks2[6]));
                cbMangueras.setChecked(Boolean.parseBoolean(Checks2[7]));
                cbOperacionTermo.setChecked(Boolean.parseBoolean(Checks2[8]));
                cbSimulacionFaltas.setChecked(Boolean.parseBoolean(Checks2[9]));
                cbInspeccionNivel.setChecked(Boolean.parseBoolean(Checks3[0]));
                cbDemandaCarga.setChecked(Boolean.parseBoolean(Checks3[1]));
                cbFugasAceiteAnti.setChecked(Boolean.parseBoolean(Checks3[2]));
                cbOperacionPrecalentadores.setChecked(Boolean.parseBoolean(Checks3[3]));
                cbRuidos.setChecked(Boolean.parseBoolean(Checks3[4]));
                cbFugas.setChecked(Boolean.parseBoolean(Checks3[5]));
                cbDensidad.setChecked(Boolean.parseBoolean(Checks3[6]));
                cbOperacionAlter.setChecked(Boolean.parseBoolean(Checks3[7]));
                cbVerTerminales.setChecked(Boolean.parseBoolean(Checks3[8]));
                cbLimpiezaEquipo.setChecked(Boolean.parseBoolean(Checks4[0]));
                cbLimpiezaRadiador.setChecked(Boolean.parseBoolean(Checks4[1]));
                cbPruebaArranqueCarga.setChecked(Boolean.parseBoolean(Checks5[0]));
                cbPruebaArranqueCS.setChecked(Boolean.parseBoolean(Checks5[1]));
                cbPruebaArranqueVacio.setChecked(Boolean.parseBoolean(Checks5[2]));
                cbSimularFallas.setChecked(Boolean.parseBoolean(Checks5[3]));
                firmaJFMtto = c.getString(c.getColumnIndex("FirmaTec"));
                firmaJFSitio = c.getString(c.getColumnIndex("FirmaRes"));

                // llenar arreglo auxiliar de fotos y bloquear los botones para no reescribir la foto
                if(!Imau.equals("")){
                    ima = Imau.split(", ");
                    for (int j = 0; j < ima.length; j++){
                    if(ima[j].contains("Foto01")){
                        btnOpenCamara.setEnabled(false);
                    }
                    else if(ima[j].contains("Foto02")){
                        btnOpenCamara1.setEnabled(false);
                    }
                    else if(ima[j].contains("Foto03")){
                        btnOpenCamara2.setEnabled(false);
                    }
                    else if(ima[j].contains("Foto04")){
                        btnOpenCamara3.setEnabled(false);
                    }
                    else if(ima[j].contains("Foto05")){
                        btnOpenCamara4.setEnabled(false);
                    }
                    else if(ima[j].contains("Foto06")){
                        btnOpenCamara5.setEnabled(false);
                    }
                    else if(ima[j].contains("Foto07")){
                        btnOpenCamara6.setEnabled(false);
                    }
                    else if(ima[j].contains("Foto08")){
                        btnOpenCamara7.setEnabled(false);
                    }
                    else if(ima[j].contains("Foto09")){
                        btnOpenCamara8.setEnabled(false);
                    }
                    else if(ima[j].contains("Foto10")){
                        btnOpenCamara9.setEnabled(false);
                    }
                    else if(ima[j].contains("Foto11")){
                        btnOpenCamara10.setEnabled(false);
                    }
                    else if(ima[j].contains("Foto12")){
                        btnOpenCamara11.setEnabled(false);
                    }
                    else if(ima[j].contains("Foto13")){
                        btnOpenCamara12.setEnabled(false);
                    }
                    else if(ima[j].contains("Foto14")){
                        btnOpenCamara13.setEnabled(false);
                    }
                    else if(ima[j].contains("Foto15")){
                        btnOpenCamara14.setEnabled(false);
                    }
                    else if(ima[j].contains("Foto16")){
                        btnOpenCamara15.setEnabled(false);
                    }
                    else if(ima[j].contains("Foto17")){
                        btnOpenCamara16.setEnabled(false);
                    }
                    else if(ima[j].contains("Foto18")){
                        btnOpenCamara17.setEnabled(false);
                    }
                    else if(ima[j].contains("Foto19")){
                        btnOpenCamara18.setEnabled(false);
                    }
                    else if(ima[j].contains("Foto20")){
                        btnOpenCamara19.setEnabled(false);
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

        cv. put("Fechainicio", etStartDate.getText().toString());
        cv. put("Horainicio", etHora.getText().toString());
        cv. put("Fechafinal", etFinishDate.getText().toString());
        cv. put("Horafinal", etHora2.getText().toString());
        cv. put("Sitio", etSitio.getText().toString());
        cv. put("Sector", etSector.getText().toString());
        cv. put("Proyecto", etProyecto.getText().toString());
        cv. put("OT", etNumOt.getText().toString());
        cv. put("Antecedentes", etAntecedentes.getText().toString());
        cv.put("Aprieta", cbAprieteTerminalCtrl.isChecked() + ", " + cbDesulfatar.isChecked());
        cv.put("Tanqueprin", etNivelCombTanqMain.getText().toString());
        cv.put("Nivelcombus", etNivelComb.getText().toString());
        cv.put("Tanquedia", etNivelCombTanqDia.getText().toString());
        cv.put("Aceite", etNivelAceite.getText().toString());
        cv.put("Presionace", etPresionAceite.getText().toString());
        cv.put("Nivelagua", etNivelAgua.getText().toString());
        cv.put("Electrolito", etElectrolito.getText().toString());
        cv.put("Temperatura", etTempOperacion.getText().toString());
        cv.put("Carga", etPorcentCargaAntesArr.getText().toString());
        cv.put("Bateria", etPorcentCargaBateria.getText().toString());
        cv.put("Voltaje", etVoltBatArr.getText().toString());
        cv.put("Standby", etVoltBatStandBy.getText().toString());
        cv.put("Alternadorarra", etVoltAltArr.getText().toString());
        cv.put("Alternadorby", etVoltAltStandBy.getText().toString());
        cv.put("Generacion", etVoltGeneracion.getText().toString());
        cv.put("Enfriamento", etTimeEnf.getText().toString());
        cv.put("Transferencia", etTimeTrans.getText().toString());
        cv.put("Tiempo", etTimeRTrans.getText().toString());
        cv.put("Revisar", cbCalibracionSensor.isChecked() + ", " + cbEstadoBaterias.isChecked() + ", " + cbFrecuenciaGen.isChecked() +
                ", " + cbOperacionCargador.isChecked() + ", " + cbSistemaLlenado.isChecked() + ", " + cbTapon.isChecked() + ", " +
                cbBandas.isChecked() + ", " + cbMangueras.isChecked() + ", " + cbOperacionTermo.isChecked() + ", " + cbSimulacionFaltas.isChecked());
        cv.put("Verificar", cbInspeccionNivel.isChecked() + ", " + cbDemandaCarga.isChecked() + ", " + cbFugasAceiteAnti.isChecked() + ", " +
                cbOperacionPrecalentadores.isChecked() + ", " + cbRuidos.isChecked() + ", " + cbFugas.isChecked() + ", " + cbDensidad.isChecked() +
                ", " + cbOperacionAlter.isChecked() + ", " + cbVerTerminales.isChecked());
        cv.put("Limpieza", cbLimpiezaEquipo.isChecked() + ", " + cbLimpiezaRadiador.isChecked());
        cv.put("Medicion", cbPruebaArranqueCarga.isChecked() + ", " + cbPruebaArranqueCS.isChecked() + ", " + cbPruebaArranqueVacio.isChecked() +
                ", " + cbSimularFallas.isChecked());
        cv.put("Horometro", etLectura.getText().toString());
        cv.put("Corriente", etMedicionCorrienteGen.getText().toString());
        cv.put("Tiempocon", etTimeArr.getText().toString());
        cv.put("Observacionescon", etObserv.getText().toString());
        cv.put("Tiemposin", etTimeArrCS.getText().toString());
        cv.put("Observacionessin", etObserv1.getText().toString());
        cv.put("Tiempovacio", etTimeArrVacio.getText().toString());
        cv.put("Conclusionesservi", etConclusiones.getText().toString());
        cv.put("Recomendacionesservi", etRecomendaciones.getText().toString());
        cv.put("Comentariosjefe", etCommentJFMtto.getText().toString());
        cv.put("Correo", etCorreo.getText().toString());
        cv.put("Numnav", etNumEqNav.getText().toString());

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

    public class taskEnviarFormToServiceWeb extends AsyncTask<Void, Void, Boolean> {
        private String formulario;
        private String respuesta = "{'d':''}";
        MyOpenHelper dbHelper = new MyOpenHelper(mContext);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String url = URLGPS + "EnvioFormServPEM.aspx/EnviaCorreo";
        public taskEnviarFormToServiceWeb(String form) {
            this.formulario = form;
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

                con.setConnectTimeout(30000);
                con.setReadTimeout(30000);

                formulario = "{\"Form\":" + formulario + "}";
                Log.e("Nota", formulario);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(con.getOutputStream());
                outputStreamWriter.write(formulario);
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
                if(JSON.getString("d").equals("Reporte enviado exitosamente")) {
                    alertDialog.setTitle("Hecho");
                    alertDialog.setMessage("Reporte enviado exitósamente.");
                    alertDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent detail = new Intent(mContext, Formatos.class);
                            startActivity(detail);
                            db.execSQL("DELETE FROM PEMSQL");
                        }
                    });
                    //Toast.makeText(getApplicationContext(), "Reporte enviado exitósamente..", Toast.LENGTH_SHORT).show();
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
                    btnEnviaForm.setEnabled(true);
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
