package mx.com.neus.juanitovision.vo;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juan on 12/15/15.
 */
public class PuntosDAO {
    private static final String COMMA=" , ";
    private SQLiteDatabase database;
    private PuntosDBHelper dbHelper;

    private static final String SELECT_BY_PARAM_QUERY = "";
    private static final String SELECT_BY_ID = "";

    private String[] allColumns={
            PuntoDBHelper.PuntosContract._ID,
            PuntoDBHelper.PuntosContract.LATITUD,
            PuntoDBHelper.PuntosContract.LONGITUD,
            PuntoDBHelper.PuntosContract.NOMBRE
            };

    public PuntosDAO(Context context){
        dbHelper =  new PuntosDBHelper(context);
    }
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }
    public List<Punto> getAllPuntos(){
        ArrayList<Punto> listaPuntos = new ArrayList<Punto>();
        open();
        Cursor cursor = database.query(PuntoDBHelper.PuntosContract.TABLE_NAME, allColumns, null, null, null, null, null);
        if (cursor.moveToFirst()){

            while (!cursor.isAfterLast()) {
                Punto punto = cursorToPunto(cursor);
                listaPuntos.add(punto);
                cursor.moveToNext();
            }
        }
        cursor.close();
        dbHelper.close();
        return listaPuntos;
    }

    private Punto cursorToPunto(Cursor cursor) {
        Punto punto = new Punto();
        punto.setId(cursor.getInt(0));
        punto.setLatitud(cursor.getDouble(1));
        punto.setLongitud(cursor.getDouble(2));
        punto.setNombre(cursor.getString(3));
        return punto;
    }

    public  ArrayList<Punto> getAgenciasBy(String param){
        ArrayList<Punto> listaPuntos = new ArrayList<Punto>();
        open();
        Cursor cursor = database.rawQuery(SELECT_BY_PARAM_QUERY,new String[]{param,"%"+param+"%"});
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Punto punto = cursorToPunto(cursor);
                listaPuntos.add(punto);
                cursor.moveToNext();
            }
        }
        cursor.close();
        dbHelper.close();
        return listaPuntos;
    }



}
