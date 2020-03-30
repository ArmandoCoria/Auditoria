package com.veolus.auditoria;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyOpenHelper extends SQLiteOpenHelper {

    /*
    private static final String INFORME_TECNICO_SQLITE = "CREATE TABLE IFSQL( _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "Sitio TEXT, Reparacion TEXT, Antecedentes TEXT, Desarrollo TEXT, " +
            "Recomendaciones TEXT, Conclusiones TEXT, Radio INT, Otros TEXT," +
            " Imagen1 TEXT, Imagen2 TEXT, Imagen3 TEXT, Imagen4 TEXT" +
            ", Imagen5 TEXT, Imagen6 TEXT, FirmaTec TEXT, Firmante TEXT, FirmaRes TEXT, Firmanres TEXT) ";
*/

    private static final String NEW_INFORME_TECNICO = "CREATE TABLE NIFSQL(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "Sitio TEXT, Sector TEXT, Proyecto TEXT, Asunto String, Equipo TEXT, Marca TEXT, Modelo TEXT, Noserie TEXT, Ubicacion TEXT," +
            "FechaMP TEXT, BreveMP TEXT, FechaMP1 TEXT, BreveMP1 TEXT, FechaMP2 TEXT, BreveMP2 TEXT, " +
            "FechaMM TEXT, BreveMM TEXT, FechaMM1 TEXT, BreveMM1 TEXT, FechaMM2 TEXT, BreveMM2 TEXT, " +
            "NO TEXT, FechaFA TEXT, BreveFA TEXT, NO1 TEXT, FechaFA1 TEXT, BreveFA1 TEXT, NO2 TEXT, FechaFA2 TEXT, BreveFA2 TEXT, " +
            "NOITE TEXT, FechaITE TEXT, BreveITE TEXT, NOITE1 TEXT, FechaITE1 TEXT, BreveITE1 TEXT, NOITE2 TEXT, FechaITE2 TEXT, BreveITE2 TEXT, " +
            "BreveDesa TEXT, HallazgoDesa TEXT, RepaDesa TEXT, EstadoDesa TEXT, DescripcionDesa1 TEXT, DescripcionDesa2 TEXT, DescripcionDesa3 TEXT, DescripcionDesa4 TEXT, " +
            "DescripcionDesa5 TEXT, DescripcionDesa6 TEXT, DescripcionDesa7 TEXT, DescripcionDesa8 TEXT, DescripcionDesa9 TEXT, DescripcionDesa10 TEXT,  " +
            "Imagen1 TEXT, Imagen2 TEXT, Imagen3 TEXT, Imagen4 TEXT, Imagen5 TEXT, Imagen6 TEXT, Imagen7 TEXT, Imagen8 TEXT, Imagen9 TEXT, Imagen10 TEXT, " +
            "Conclusion TEXT, DescripcionConclu1 TEXT, DescripcionConclu2 TEXT, DescripcionConclu3 TEXT, DescripcionConclu4 TEXT,   " +
            "DescripcionConclu5 TEXT, DescripcionConclu6 TEXT, DescripcionConclu7 TEXT, DescripcionConclu8 TEXT, DescripcionConclu9 TEXT, DescripcionConclu10 TEXT,  " +
            "FirmaTec TEXT, Firmante TEXT, FirmaRes TEXT, Firmanres TEXT) ";

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


    private static final String DB_INFO = "NIFSQL.sqlite, AUSQL.sqlite, BCISQL.sqlite, PEMSQL.sqlite ";
    private static final int DB_version = 26;

    public MyOpenHelper(Context context) {
        super(context, DB_INFO, null, DB_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NEW_INFORME_TECNICO);
        db.execSQL(AUDITORIA);
        db.execSQL(BCI);
        db.execSQL(PEM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("x", "#"+oldVersion);
       Log.d("x", "#"+newVersion);
        if (newVersion == 26) {
            db.execSQL("DROP TABLE IF EXISTS NIFSQL");
            db.execSQL("DROP TABLE IF EXISTS AUSQL");
            db.execSQL("DROP TABLE IF EXISTS BCISQL");
            db.execSQL("DROP TABLE IF EXISTS PEMSQL");
            onCreate(db);
        }
    }

    public void delete (){
        SQLiteDatabase db = getWritableDatabase();
        if (db!=null){
            db.execSQL("DELETE FROM NIFSQL");
            db.execSQL("DELETE FROM AUSQL");
            db.execSQL("DELETE FROM BCISQL");
            db.execSQL("DELETE FROM PEMSQL");
            db.close();
        }
    }
}
