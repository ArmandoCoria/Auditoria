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

public class ServicioBCI extends Activity {


    private EditText etFecha;
    private EditText etFechaInicio;
    private EditText etFechafin;
    private EditText etSitio;
    private EditText etSector;
    private EditText etProyecto;
    private TextView etNot;
    private EditText etAsunto;
    private TextView etObjetivo;
    private EditText etAntecedentes;
    private EditText etObservaciones;
    private EditText etConclusiones;
    private EditText etRecomendaciones;
    private EditText etComentarios;
    private EditText etCorreo;
    private EditText etNumero;

    private EditText nivelCombTanqDia;
    private EditText nivelCombMain;
    private EditText nivelRefrigerante;
    private EditText nivelAceite;
    private EditText nivelElectrolito;
    private EditText volt3times;
    private EditText porcentBaterias;
    private EditText lecHorometro;
    private EditText tiempoArranque;
    private CheckBox aprieta, apretar;
    private CheckBox fugas, cargador, precalentadores, llenado, tension, cargabaterias, estopero, tapon, presion, temperatura, badas, mangueras1, eventos;
    private CheckBox inspeccion, inspeccion1, inspeccion2, ruidos, acoplamiento, fugas3, densidad, operacion, bomba;
    private CheckBox arranque;

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

    private Button btnEnviar;
    private Button btnFirmaTec;
    private Button btnFirmaResp;

    private ServicioBCI.taskZonaPuntosdeInicioOT taskZonaPuntosdeInicioOT = null;

    private static final String URLGPS = "http://www.veolus.com/gps/";

    private Context mContext;

    private String firmaTec = "";
    private String firmaResp = "";
    private String firmanteTec = "";
    private String firmanteResp = "";
    private Boolean AprieteTerminalesControl = false;
    private Boolean DesulfatarTerminalesBaterias = false;
    private Boolean FugasAceiteAnticongelante = false;
    private Boolean OperacionCargadorBaterias = false;
    private Boolean OperacionPrecalentadores = false;
    private Boolean SistemaLlenadoComb = false;
    private Boolean TensionBateriaFlotacion = false;
    private Boolean EstoperoImpulsor = false;
    private Boolean TaponRadiador = false;
    private Boolean PresionAceite = false;
    private Boolean TempOperacion = false;
    private Boolean Bandas = false;
    private Boolean Mangueras = false;
    private Boolean EventosEquipo = false;
    private Boolean InspeccionEquipo = false;
    private Boolean InspeccionPrecalentadores = false;
    private Boolean InspeccionVisualNivelAceite = false;
    private Boolean RuidosAnormales = false;
    private Boolean AcoplamientoSello = false;
    private Boolean Fugas = false;
    private Boolean DensidadElectrolito = false;
    private Boolean OperacionAlternador = false;
    private Boolean BombaAutomatico = false;
    private Boolean LimpiezaEquipo = false;
    private Boolean LimpiezaRadiador = false;
    private Boolean PruebaArranque = false;
    private String NivelCombustibleTanqueDia = "";
    private String NivelCombustibleTanquePrincipal = "";
    private String NivelRefrigerante = "";
    private String NivelAceite ="";
    private String NivelElectrolito = "";
    private String VoltBaterias3Times = "";
    private String PorcentajeBaterias = "";
    private String LecturaHorometro = "";
    private String TiempoArranque = "";
    TextView texto;
    TextView tdate;
    private List<String> fotos = new ArrayList<String>();
    //Calendario para obtener fecha & hora
    public final Calendar c = Calendar.getInstance();
    //Variables para obtener la hora hora
    final int hora = c.get(Calendar.HOUR_OF_DAY);
    final int minuto = c.get(Calendar.MINUTE);
    //Widgets
    EditText etHora;
    EditText etHora2;

    //*private String direccion = "";
    private Context mContextt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicio_bci);

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
                            tdate = findViewById(R.id.fecha1);
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


        etFechaInicio = findViewById(R.id.fechainicio);
        etFechaInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(R.id.fechainicio);
            }
        });
        etFechafin = findViewById(R.id.fechafin);
        etFechafin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(R.id.fechafin);
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
        etSitio = findViewById(R.id.sitio);
        etSector = findViewById(R.id.sector);
        etProyecto = findViewById(R.id.proyecto);
        etNot = findViewById(R.id.not);
        etAsunto = findViewById(R.id.asunto);
        etObjetivo = findViewById(R.id.objetivo);
        etAntecedentes = findViewById(R.id.antecedentes);
        etObservaciones = findViewById(R.id.observaciones2);
        etConclusiones = findViewById(R.id.conclusiones1);
        etRecomendaciones = findViewById(R.id.recomendaciones);
        etComentarios = findViewById(R.id.comentarios);
        etCorreo = findViewById(R.id.correo);
        etNumero = findViewById(R.id.numero);
        nivelCombTanqDia = findViewById(R.id.nivelCombTanqDia);
        nivelCombMain = findViewById(R.id.nivelCombTanqMain);
        nivelRefrigerante = findViewById(R.id.nivelRefrigerante);
        nivelAceite = findViewById(R.id.nivelAceite);
        nivelElectrolito = findViewById(R.id.nivelElectrolito);
        volt3times = findViewById(R.id.voltBaterias3Times);
        porcentBaterias = findViewById(R.id.porcentBaterias);
        lecHorometro = findViewById(R.id.horometro);
        tiempoArranque = findViewById(R.id.tiempoArranque);

        // botón que realiza validaciones y envia el formulario
        btnEnviar = findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                enviarFormulario();
            }
        });

        // Botones para realizar las firmas
        btnFirmaTec = findViewById(R.id.btnFirmaTec);
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

        btnFirmaResp = findViewById(R.id.btnFirmaResp);
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
        btncamara1 = findViewById(R.id.btnusados);
        btncamara1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Imagen01");
                btncamara1.setEnabled(false);
                startActivityForResult(in, 1);
            }
        });

        btncamara2 = findViewById(R.id.btnnuevos);
        btncamara2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                in.putExtra("numFoto", "Imagen02");
                btncamara2.setEnabled(false);
                startActivityForResult(in, 1);
            }
        });

        btncamara3 = findViewById(R.id.btnusados1);
        btncamara3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                in.putExtra("numFoto", "Imagen03");
                btncamara3.setEnabled(false);
                startActivityForResult(in, 1);
            }
        });
        btncamara4 = findViewById(R.id.btnnuevos1);
        btncamara4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                in.putExtra("numFoto", "Imagen04");
                btncamara4.setEnabled(false);
                startActivityForResult(in, 1);
            }
        });
        btncamara5 = findViewById(R.id.btnusados2);
        btncamara5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                in.putExtra("numFoto", "Imagen05");
                btncamara5.setEnabled(false);
                startActivityForResult(in, 1);
            }
        });
        btncamara6 = findViewById(R.id.btnnuevos2);
        btncamara6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Imagen06");
                btncamara6.setEnabled(false);
                startActivityForResult(in, 1);
            }
        });
        btncamara7 = findViewById(R.id.btnusados3);
        btncamara7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                in.putExtra("numFoto", "Imagen7");
                btncamara7.setEnabled(false);
                startActivityForResult(in, 1);
            }
        });
        btncamara8 = findViewById(R.id.btnnuevos3);
        btncamara8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                in.putExtra("numFoto", "Imagen08");
                btncamara8.setEnabled(false);
                startActivityForResult(in, 1);
            }
        });
        btncamara9 = findViewById(R.id.btnusados4);
        btncamara9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                in.putExtra("numFoto", "Imagen09");
                btncamara9.setEnabled(false);
                startActivityForResult(in, 1);
            }
        });
        btncamara10 = findViewById(R.id.btnnuevos4);
        btncamara10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                in.putExtra("numFoto", "Imagen10");
                btncamara10.setEnabled(false);
                startActivityForResult(in, 1);
            }
        });
        btncamara11 = findViewById(R.id.btnusados5);
        btncamara11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Imagen11");
                btncamara11.setEnabled(false);
                startActivityForResult(in, 1);
            }
        });
        btncamara12 = findViewById(R.id.btnnuevos5);
        btncamara12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                in.putExtra("numFoto", "Imagen12");
                btncamara12.setEnabled(false);
                startActivityForResult(in, 1);
            }
        });
        btncamara13 = findViewById(R.id.btnusados6);
        btncamara13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                in.putExtra("numFoto", "Imagen13");
                btncamara13.setEnabled(false);
                startActivityForResult(in, 1);
            }
        });
        btncamara14 = findViewById(R.id.btnnuevos6);
        btncamara14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                in.putExtra("numFoto", "Imagen14");
                btncamara14.setEnabled(false);
                startActivityForResult(in, 1);
            }
        });
        btncamara15 = findViewById(R.id.btnusados7);
        btncamara15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 4);
                in.putExtra("numFoto", "Imagen15");
                btncamara15.setEnabled(false);
                startActivityForResult(in, 1);
            }
        });
        btncamara16 = findViewById(R.id.btnnuevos7);
        btncamara16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 0);
                in.putExtra("numFoto", "Imagen16");
                btncamara16.setEnabled(false);
                startActivityForResult(in, 1);
            }
        });
        btncamara17 = findViewById(R.id.btnusados8);
        btncamara17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 1);
                in.putExtra("numFoto", "Imagen17");
                btncamara17.setEnabled(false);
                startActivityForResult(in, 1);
            }
        });
        btncamara18 = findViewById(R.id.btnnuevos8);
        btncamara18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 2);
                in.putExtra("numFoto", "Imagen18");
                btncamara18.setEnabled(false);
                startActivityForResult(in, 1);
            }
        });
        btncamara19 = findViewById(R.id.btnnuevos9);
        btncamara19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Fotos.class);
                in.putExtra("Camera", 3);
                in.putExtra("numFoto", "Imagen19");
                btncamara19.setEnabled(false);
                startActivityForResult(in, 1);
            }
        });
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
                    && "vacio".equals(data.getStringExtra("FotoCuatro")) && "vacio".equals(data.getStringExtra("FotoCnco"))) {
                fotos.add(data.getStringExtra("numFoto") + ":" + data.getStringExtra("FotoUno"));

            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoTres"))
                    && "vacio".equals(data.getStringExtra("FotoCuatro")) && "vacio".equals(data.getStringExtra("FotoCnco"))) {
                fotos.add(data.getStringExtra("numFoto") + ":" + data.getStringExtra("FotoDos"));

            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoDos"))
                    && "vacio".equals(data.getStringExtra("FotoCuatro")) && "vacio".equals(data.getStringExtra("FotoCnco"))) {
                fotos.add(data.getStringExtra("numFoto") + ":" + data.getStringExtra("FotoTres"));

            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoDos"))
                    && "vacio".equals(data.getStringExtra("FotoTres")) && "vacio".equals(data.getStringExtra("FotoCnco"))) {
                fotos.add(data.getStringExtra("numFoto") + ":" + data.getStringExtra("FotoCuatro"));

            } else if ("vacio".equals(data.getStringExtra("FotoUno")) && "vacio".equals(data.getStringExtra("FotoDos"))
                    && "vacio".equals(data.getStringExtra("FotoTres")) && "vacio".equals(data.getStringExtra("FotoCuatro"))) {
                fotos.add(data.getStringExtra("numFoto") + ":" + data.getStringExtra("FotoCnco"));

            }
        }

    }

    private void showDatePickerDialog(int id) {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because january is zero
                final String selectedDate = day + "/" + (month + 1) + "/" + year;
                switch (id){
                    case R.id.fechainicio:
                        etFechaInicio.setText(selectedDate);
                        break;
                    case R.id.fechafin:
                        etFechafin.setText(selectedDate);
                        break;
                }

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

    private Boolean ContainsAny(String haystack, Iterable<String> needles)
    {
        Boolean condition = false;
        for (String elem : needles)
        {
            String el = elem.substring(0, 8);
            if (el.equals(haystack))
            {
                return true;
            }
        }
        return condition;
    }

    private void enviarFormulario() {

        verirficarChecks();

        if(!ContainsAny("Imagen01", fotos) && !ContainsAny("Imagen02", fotos)){
            Toast.makeText(this, "Se requieren fotos para el check de 'ACEITE'", Toast.LENGTH_SHORT).show();
        }
        else if(!ContainsAny("Imagen03", fotos) && !ContainsAny("Imagen04", fotos)){
            Toast.makeText(this, "Se requieren fotos para el check de 'FILTROS DE AIRE'", Toast.LENGTH_SHORT).show();
        }
        else if(!ContainsAny("Imagen05", fotos) && !ContainsAny("Imagen06", fotos)){
            Toast.makeText(this, "Se requieren fotos para el check de 'FILTROS DE ACEITE'", Toast.LENGTH_SHORT).show();
        }
        /*else if(!ContainsAny("Imagen07", fotos) && !ContainsAny("Imagen08", fotos)){
            Toast.makeText(this, "Se requieren fotos para el check de 'BATERIAS'", Toast.LENGTH_SHORT).show();
        }*/
        else if(!ContainsAny("Imagen09", fotos) && !ContainsAny("Imagen10", fotos)){
            Toast.makeText(this, "Se requieren fotos para el check de 'TERMINALES DE BATERIAS'", Toast.LENGTH_SHORT).show();
        }
        else if(!ContainsAny("Imagen11", fotos) && !ContainsAny("Imagen12", fotos)){
            Toast.makeText(this, "Se requieren fotos para el check de 'REFRIGERANTE'", Toast.LENGTH_SHORT).show();
        }
        else if(!ContainsAny("Imagen13", fotos) && !ContainsAny("Imagen14", fotos)){
            Toast.makeText(this, "Se requieren fotos para el check de 'FILTROS DE REFRIGERANTE'", Toast.LENGTH_SHORT).show();
        }
        /*else if(!ContainsAny("Imagen15", fotos) && !ContainsAny("Imagen16", fotos)){
            Toast.makeText(this, "Se requieren fotos para el check de 'MANGUERAS DE PRECALENTADOR'", Toast.LENGTH_SHORT).show();
        }*/
        else if(!ContainsAny("Imagen17", fotos)){
            Toast.makeText(this, "Se requiere foto para el check de 'LIMPIEZA DEL EQUIPO'", Toast.LENGTH_SHORT).show();
        }
        else if(!ContainsAny("Imagen18", fotos)){
            Toast.makeText(this, "Se requiere foto para el check de 'LIMPIEZA DEL RADIADOR'", Toast.LENGTH_SHORT).show();
        }
        else if(!ContainsAny("Imagen19", fotos)){
            Toast.makeText(this, "Se requieren fotos para la sección de 'MEDICIÓN Y REGISTRO'", Toast.LENGTH_SHORT).show();
        }
       else if (firmaResp == "") {
            Toast.makeText(this, "Se requiere la firma del Jefe de Mtto", Toast.LENGTH_SHORT).show();
            //return false;
        } else if (firmaTec == "") {
            Toast.makeText(this, "Se requiere la firma del Jefe del Sitio", Toast.LENGTH_SHORT).show();

        } else {
            btnEnviar.setEnabled(false);
            Bundle extras = getIntent().getExtras();
            Toast.makeText(this, "Enviando Formulario", Toast.LENGTH_LONG).show();
            Gson gsonFrom = new Gson();
            StoreServicioBCI miForm = new StoreServicioBCI();
            miForm.setFecha(tdate.getText().toString());
            miForm.setFechaInicio(etFechaInicio.getText().toString() + " " + etHora.getText().toString());
            miForm.setFechafin(etFechafin.getText().toString() + " " + etHora2.getText().toString());
            miForm.setSitio(etSitio.getText().toString());
            miForm.setSector(etSector.getText().toString());
            miForm.setProyecto(etProyecto.getText().toString());
            miForm.setNot(etNot.getText().toString());
            miForm.setAsunto(etAsunto.getText().toString());
            miForm.setObjetivo(etObjetivo.getText().toString());
            miForm.setAntecedentes(etAntecedentes.getText().toString());
            //miForm.setDesarrollo(etDesarrollo.getText().toString());
            miForm.setObservaciones(etObservaciones.getText().toString());
            miForm.setConclusiones(etConclusiones.getText().toString());
            miForm.setRecomendaciones(etRecomendaciones.getText().toString());
            miForm.setComentarios(etComentarios.getText().toString());
            miForm.setCorreo(etCorreo.getText().toString());
            miForm.setNumero(etNumero.getText().toString());
            /*miForm.setDejarFueraEquipo(dejar.isChecked());
            miForm.setLotto(ejecutar.isChecked());
            miForm.setAceite(aceite.isChecked());
            miForm.setFiltrosAire(filtros.isChecked());
            miForm.setBaterias(baterias.isChecked());
            miForm.setTerminalesBaterias(terminales.isChecked());
            miForm.setRefrigerante(refrigerante.isChecked());
            miForm.setFiltrosRefrigerante(filtrosrefrigerante.isChecked());
            miForm.setManguerasPrecalentador(mangueras.isChecked());*/
            miForm.setAprieteTerminalesControl(aprieta.isChecked());
            miForm.setDesulfatarTerminalesBaterias(apretar.isChecked());
            miForm.setTensionBateriaFlotacion(tension.isChecked());
            miForm.setEstoperoImpulsor( estopero.isChecked());
            miForm.setPresionAceite( presion.isChecked());
            miForm.setOperacionCargadorBaterias(cargabaterias.isChecked());
            miForm.setSistemaLlenadoComb(llenado.isChecked());
            miForm.setTaponRadiador( tapon.isChecked());
            miForm.setBandas(badas.isChecked());
            miForm.setMangueras(mangueras1.isChecked());
            miForm.setTempOperacion(temperatura.isChecked());
            miForm.setEventosEquipo( eventos.isChecked());
            miForm.setInspeccionVisualNivelAceite( inspeccion2.isChecked());
            miForm.setInspeccionEquipo( inspeccion.isChecked());
            miForm.setFugasAceiteAnticongelante(fugas.isChecked());
            miForm.setInspeccionPrecalentadores( inspeccion1.isChecked());
            miForm.setOperacionPrecalentadores( precalentadores.isChecked());
            miForm.setAcoplamientoSello( acoplamiento.isChecked());
            miForm.setRuidosAnormales( ruidos.isChecked());
            miForm.setFugas( fugas3.isChecked());
            miForm.setDensidadElectrolito( densidad.isChecked());
            miForm.setOperacionAlternador( operacion.isChecked());
            miForm.setBombaAutomatico( bomba.isChecked());
            /*miForm.setLimpiezaEquipo( delequipo.isChecked());
            miForm.setLimpiezaRadiador( delradiador.isChecked());*/
            miForm.setPruebaArranque( arranque.isChecked());
            miForm.setNivelCombustibleTanqueDia(NivelCombustibleTanqueDia);
            miForm.setNivelCombustibleTanquePrincipal(NivelCombustibleTanquePrincipal);
            miForm.setNivelRefrigerante(NivelRefrigerante);
            miForm.setNivelAceite(NivelAceite);
            miForm.setNivelElectrolito(NivelElectrolito);
            miForm.setVoltBaterias3Times(VoltBaterias3Times);
            miForm.setPorcentajeBaterias(PorcentajeBaterias);
            miForm.setLecturaHorometro(LecturaHorometro);
            miForm.setTiempoArranque(TiempoArranque);
            miForm.setFirmaJFSitio(firmaTec);
            miForm.setFirmaJFMtto(firmaResp);
            miForm.setFotos(fotos);
            try {
                taskZonaPuntosdeInicioOT = new taskZonaPuntosdeInicioOT(gsonFrom.toJson(miForm));
                Toast.makeText(this, "Procesando solicitud", Toast.LENGTH_LONG).show();
                taskZonaPuntosdeInicioOT.execute((Void) null);
            }catch (Exception e){
            }
        }
    }

    public void verirficarChecks(){

        NivelCombustibleTanqueDia = nivelCombTanqDia.getText().toString();
        NivelCombustibleTanquePrincipal = nivelCombMain.getText().toString();
        NivelAceite = nivelAceite.getText().toString();
        NivelRefrigerante = nivelRefrigerante.getText().toString();
        NivelElectrolito = nivelElectrolito.getText().toString();
        VoltBaterias3Times = volt3times.getText().toString();
        LecturaHorometro = lecHorometro.getText().toString();
        TiempoArranque = tiempoArranque.getText().toString();
        PorcentajeBaterias = porcentBaterias.getText().toString();
        aprieta = findViewById(R.id.aprieta);
        apretar= findViewById(R.id.apretar);
        fugas = findViewById(R.id.fugas);
        cargador = findViewById(R.id.cargador);
        precalentadores = findViewById(R.id.precalentadores);
        llenado = findViewById(R.id.llenado);
        tension = findViewById(R.id.tension);
        cargabaterias = findViewById(R.id.cargabaterias);
        estopero = findViewById(R.id.estopero);
        tapon = findViewById(R.id.tapon);
        presion = findViewById(R.id.presion);
        temperatura = findViewById(R.id.temperatura);
        badas = findViewById(R.id.badas);
        mangueras1 = findViewById(R.id.mangueras1);
        eventos = findViewById(R.id.eventos);
        inspeccion = findViewById(R.id.inspeccion);
        inspeccion1 = findViewById(R.id.inspeccion1);
        inspeccion2 = findViewById(R.id.inspeccion2);
        ruidos = findViewById(R.id.ruidos);
        acoplamiento = findViewById(R.id.acoplamiento);
        fugas3 = findViewById(R.id.fugas3);
        densidad = findViewById(R.id.densidad);
        operacion = findViewById(R.id.operacion);
        bomba = findViewById(R.id.bomba);
       /*delequipo = findViewById(R.id.delequipo);
        delradiador = findViewById(R.id.delradiador);*/
        arranque = findViewById(R.id.arranque);

        if (aprieta.isChecked()){
            AprieteTerminalesControl = true;
        }
        if (apretar.isChecked()){
            DesulfatarTerminalesBaterias = true;
        }
        if (fugas.isChecked()){
            FugasAceiteAnticongelante = true;
        }
        if (cargador.isChecked()){
            OperacionCargadorBaterias = true;
        }
        if (precalentadores.isChecked()){
            OperacionPrecalentadores = true;
        }
        if (llenado.isChecked()){
            SistemaLlenadoComb = true;
        }
        if (tension.isChecked()){
            TensionBateriaFlotacion = true;
        }
        if (cargabaterias.isChecked()){
            OperacionCargadorBaterias = true;
        }
        if (estopero.isChecked()){
            EstoperoImpulsor = true;
        }
        if (tapon.isChecked()){
            TaponRadiador = true;
        }
        if (presion.isChecked()){
            PresionAceite = true;
        }
        if (temperatura.isChecked()){
            TempOperacion = true;
        }
        if (badas.isChecked()){
            Bandas = true;
        }
        if (mangueras1.isChecked()){
            Mangueras = true;
        }
        if (eventos.isChecked()){
            EventosEquipo = true;
        }
        if (inspeccion.isChecked()){
            InspeccionEquipo = true;
        }
        if (inspeccion1.isChecked()){
            InspeccionPrecalentadores = true;
        }
        if (inspeccion2.isChecked()){
            InspeccionVisualNivelAceite = true;
        }
        if (ruidos.isChecked()){
            RuidosAnormales = true;
        }
        if (acoplamiento.isChecked()){
            AcoplamientoSello = true;
        }
        if (fugas3.isChecked()){
            Fugas = true;
        }
        if (densidad.isChecked()){
            DensidadElectrolito = true;
        }
        if (operacion.isChecked()){
            OperacionAlternador = true;
        }
        if (bomba.isChecked()){
            BombaAutomatico = true;
        }
        /*if (delequipo.isChecked()){
            LimpiezaEquipo = true;
        }
        if (delradiador.isChecked()){
            LimpiezaRadiador = true;
        }*/
        if (arranque.isChecked()){
            PruebaArranque = true;
        }
    }

    public class taskZonaPuntosdeInicioOT extends AsyncTask<Void, Void, Boolean> {
        private String formualrio;
        private String respuesta = "{'d':''}";
        String url = URLGPS + "EnvioFormServBCI.aspx/EnviaCorreo";
        public taskZonaPuntosdeInicioOT(String formualrio) {
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

                formualrio = "{\"Form\":" + formualrio + "}";
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
                    alertDialog.setMessage("El reporte no se pudo enviar por que no tiene conexión a internet. "+ JSON.getString("d"));
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