package com.veolus.auditoria;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyOpenHelper extends SQLiteOpenHelper {

    private static final String INFORME_TECNICO_SQLITE = "CREATE TABLE IFSQL( _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "Sitio TEXT, Reparacion TEXT, Antecedentes TEXT, Desarrollo TEXT, " +
            "Recomendaciones TEXT, Conclusiones TEXT, Radio INT, Otros TEXT," +
            " Imagen1 TEXT, Imagen2 TEXT, Imagen3 TEXT, Imagen4 TEXT" +
            ", Imagen5 TEXT, Imagen6 TEXT, FirmaTec TEXT, Firmante TEXT, FirmaRes TEXT, Firmanres TEXT) ";

    private static final String AUDITORIA = "CREATE TABLE AUSQL( _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "Director TEXT, Motivo TEXT, Sitio TEXT, Sector TEXT, " +
            "Proyecto TEXT, Zonas STRING, Escalera STRING, Detalles TEXT, Peticiones TEXT, " +
            "Elevadores STRING, Detalles1 TEXT, Peticiones1 TEXT," +
            "Montacargas STRING, Detalles2 TEXT, Peticiones2 TEXT, " +
            "BCI STRING, Detalles3 TEXT, Peticiones3 TEXT, " +
            "PEM STRING, Detalles4 TEXT, Peticiones4 TEXT," +
            "Subestacion STRING, Detalles5 TEXT, Peticiones5 TEXT, " +
            "Chillers STRING, Detalles6 TEXT, Peticiones6 TEXT, " +
            "Bombas STRING, Detalles7 TEXT, Peticiones7 TEXT," +
            "Torres STRING, Detalles8 TEXT, Peticiones8 TEXT, " +
            "Detalles9 TEXT, Peticiones9 TEXT," +
            "Detalles10 TEXT, Peticiones10 TEXT," +
            "Detalles11 TEXT, Peticiones11 TEXT," +
            "Detalles12 TEXT, Peticiones12 TEXT," +
            "Detalles13 TEXT, Peticiones13 TEXT," +
            "Detalles14 TEXT, Peticiones14 TEXT," +
            "Detalles15 TEXT, Peticiones15 TEXT," +
            "Detalles16 TEXT, Peticiones16 TEXT," +
            "CheckList STRING, Detalles17 TEXT, Peticiones17 TEXT," +
            "Detalles18 TEXT, Peticiones18 TEXT, Promesas TEXT," +
            "Detalles19 TEXT, Peticiones19 TEXT, Promesas1 TEXT," +
            "Imagenes TEXT, Coordinador TEXT, Jefe TEXT, FirmaTec TEXT, Firmante TEXT, FirmaRes TEXT, Firmanres TEXT) ";

    private static final String BCI = "CREATE TABLE BCISQL( _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "Fechainicio TEXT, Horainicio TEXT, Fechafinal TEXT, Horafinal TEXT, Sitio TEXT, Sector TEXT, Proyecto TEXT, OT TEXT," +
            "Antecedentes TEXT, Aprieta STRING, Tanquedia TEXT, Tanqueprin TEXT, Refri TEXT, Aceite TEXT, Electrolito TEXT, Arrancar TEXT, Carga TEXT," +
            "Horometro TEXT, Arranquepru TEXT, Observacionespru TEXT, " +
            "Conclusiones TEXT, Recomendaciones TEXT, " +
            "Comentarios TEXT, Correo TEXT, Numnav TEXT," +
            "Imagenes TEXT,FirmaTec TEXT, Firmante TEXT, FirmaRes TEXT, Firmanres TEXT) ";

    private static final String PEM = "CREATE TABLE PEMSQL( _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "Fechainicio TEXT, Horainicio TEXT, Fechafinal TEXT, Horafinal TEXT, Sitio TEXT, Sector TEXT, Proyecto TEXT, OT TEXT," +
            "Antecedentes TEXT, Aprieta STRING, Tanqueprin TEXT, Nivelcombus TEXT, Tanquedia TEXT, Aceite TEXT, Presionace TEXT, Nivelagua TEXT," +
            "Electrolito TEXT, Temperatura TEXT, Carga TEXT, Bateria TEXT, Voltaje TEXT, Standby TEXT, Alternadorarra TEXT, Alternadorby TEXT," +
            " Generacion TEXt, Enfriamento TEXT, Transferencia TEXT, Tiempo TEXT, Revisar STRING, Verificar STRING, Limpieza STRING, Medicion STRING, " +
            "Horometro TEXT, Corriente TEXT, Tiempocon TEXT, Observacionescon TEXT, Tiemposin TEXT, Observacionessin TEXT, Tiempovacio TEXT," +
            "Conclusionesservi TEXT, Recomendacionesservi TEXT, Comentariosjefe TEXT, Correo TEXT, Numnav TEXT," +
            "Imagenes TEXT,FirmaTec TEXT, Firmante TEXT, FirmaRes TEXT, Firmanres TEXT) ";


    private static final String DB_INFO = "IFSQL.sqlite, AUSQL.sqlite, BCISQL.sqlite, PEMSQL.sqlite ";
    private static final int DB_version = 24;

    public MyOpenHelper(Context context) {
        super(context, DB_INFO, null, DB_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(INFORME_TECNICO_SQLITE);
        db.execSQL(AUDITORIA);
        db.execSQL(BCI);
        db.execSQL(PEM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("x", "#"+oldVersion);
       Log.d("x", "#"+newVersion);
        if (newVersion == 24) {
            db.execSQL("DROP TABLE IF EXISTS IFSQL");
            db.execSQL("DROP TABLE IF EXISTS AUSQL");
            db.execSQL("DROP TABLE IF EXISTS BCISQL");
            db.execSQL("DROP TABLE IF EXISTS PEMSQL");
            onCreate(db);
        }
    }

    public void delete (){
        SQLiteDatabase db = getWritableDatabase();
        if (db!=null){
            db.execSQL("DELETE FROM IFSQL");
            db.execSQL("DELETE FROM AUSQL");
            db.execSQL("DELETE FROM BCISQL");
            db.execSQL("DELETE FROM PEMSQL");
            db.close();
        }
    }
}
