package com.veolus.auditoria;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

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
    CheckBox cbOperacionAlter;
    CheckBox cbVerTerminales;
    CheckBox cbLimpiezaEquipo;
    CheckBox cbLimpiezaRadiador;
    CheckBox cbPruebaArranqueCarga;
    CheckBox cbPruebaArranqueCS;
    CheckBox cbSimularFallas;
    EditText etObserv;
    EditText etObserv1;
    EditText etConclusiones;
    EditText etRecomendaciones;
    EditText etCommentJFMtto;
    EditText etCorreo;
    EditText etNumEqNav;
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
    private List<String> fotos = new ArrayList<String>();
   /* private Boolean DejarFueraEquipo = false;
    private Boolean Lotto = false;
    private Boolean Aceite = false;
    private Boolean FiltrosAceite = false;
    private Boolean Baterias = false;
    private Boolean TerminalesBaterias = false;
    private Boolean Refrigerante = false;
    private Boolean FiltrosRefrigerante = false;
    private Boolean FiltrosAire = false;
    private Boolean ManguerasPrecalentador = false;*/
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

    //Widgets
    EditText etHora;
    EditText etHora2;

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
        cbOperacionAlter = findViewById(R.id.operacionAlternador);
        cbVerTerminales = findViewById(R.id.verTerminalesBaterias);
        cbLimpiezaEquipo = findViewById(R.id.limpiezaEquipo);
        cbLimpiezaRadiador = findViewById(R.id.limpiezaRadiador);
        cbPruebaArranqueCarga = findViewById(R.id.pruebaArranqueCarga);
        cbPruebaArranqueCS  = findViewById(R.id.pruebaArranqueCSCarga);
        cbSimularFallas = findViewById(R.id.simularFallasVelocidad);
        btnOpenCamara = findViewById(R.id.opencamara);
        btnOpenCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Foto01");
                btnOpenCamara.setEnabled(false);
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
                btnOpenCamara1.setEnabled(false);
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
                btnOpenCamara2.setEnabled(false);
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
                btnOpenCamara3.setEnabled(false);
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
                btnOpenCamara4.setEnabled(false);
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
                btnOpenCamara5.setEnabled(false);
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
                btnOpenCamara6.setEnabled(false);
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
                btnOpenCamara7.setEnabled(false);
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
                btnOpenCamara8.setEnabled(false);
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
                btnOpenCamara9.setEnabled(false);
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
                btnOpenCamara10.setEnabled(false);
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
                btnOpenCamara11.setEnabled(false);
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
                btnOpenCamara12.setEnabled(false);
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
                btnOpenCamara13.setEnabled(false);
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
                btnOpenCamara14.setEnabled(false);
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
                btnOpenCamara15.setEnabled(false);
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
                btnOpenCamara16.setEnabled(false);
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
                btnOpenCamara17.setEnabled(false);
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
                btnOpenCamara18.setEnabled(false);
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
                btnOpenCamara19.setEnabled(false);
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
                btnFirmaJFSitio.setEnabled(false);
            } else if ("vacio".equals(data.getStringExtra("FirmaTEC"))) {
                firmaJFMtto = data.getStringExtra("FirmaRESP");
                btnFirmaJFMtto.setEnabled(false);
            }
            if ("vacio".equals(data.getStringExtra("FotoDos")) && "vacio".equals(data.getStringExtra("FotoTres")) && "vacio".equals(data.getStringExtra("FotoCuatro")) && "vacio".equals(data.getStringExtra("FotoCnco"))) {
                fotos.add(data.getStringExtra("numFoto") + ":" + data.getStringExtra("FotoUno"));

            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoTres")) && "vacio".equals(data.getStringExtra("FotoCuatro")) && "vacio".equals(data.getStringExtra("FotoCnco"))) {
                fotos.add(data.getStringExtra("numFoto") + ":" + data.getStringExtra("FotoDos"));

            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoDos")) && "vacio".equals(data.getStringExtra("FotoCuatro")) && "vacio".equals(data.getStringExtra("FotoCnco"))) {
                fotos.add(data.getStringExtra("numFoto") + ":" + data.getStringExtra("FotoTres"));

            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoDos")) && "vacio".equals(data.getStringExtra("FotoTres")) && "vacio".equals(data.getStringExtra("FotoCnco"))) {
                fotos.add(data.getStringExtra("numFoto") + ":" + data.getStringExtra("FotoCuatro"));

            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoDos")) && "vacio".equals(data.getStringExtra("FotoTres")) && "vacio".equals(data.getStringExtra("FotoCuatro"))) {
                fotos.add(data.getStringExtra("numFoto") + ":" + data.getStringExtra("FotoCnco"));

            }
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

    public class taskEnviarFormToServiceWeb extends AsyncTask<Void, Void, Boolean> {
        private String formulario;
        private String respuesta = "{'d':''}";
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

                con.setConnectTimeout(150000);
                con.setReadTimeout(150000);

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
