package com.veolus.auditoria;

import android.annotation.SuppressLint;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Formatos extends AppCompatActivity {

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formatos);
    }

    public void onBackPressed(){

    }
        public void onEstatusClicked(View view) {

            Intent mio = null;

            switch (view.getId()){
                case R.id.formetm:
                    mio=new Intent(Formatos.this, Form_auditoria.class);
                    break;

                case R.id.infotec:
                    mio=new Intent(Formatos.this, informe_tecnico.class);
                    break;
                case R.id.infobci:
                    mio=new Intent(Formatos.this, ServicioBCI.class);
                    break;
                case R.id.infopem:
                    mio=new Intent(Formatos.this, Form_Serv_Pem.class);
                    break;
                case  R.id.cerrar:
                    mio=new Intent(Formatos.this, logeo.class);
                    break;
            }
            startActivity(mio);
        }
    }
