package studentattendancesystem.devteam.com.studentattendancesystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBconnections extends SQLiteOpenHelper{
    public final static  String DATABASE_NAME = "studens_db";
    public final static  int VERSION = 1;
    public DBconnections(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists students (id INTEGER primary key, name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop table if exists studens");
        onCreate(db);
    }

    public void insertRowStudent(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name",name);
        db.insert("students",null,values);

    }
    public ArrayList getAllData(){
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from students",null);
        res.moveToFirst();
        while(res.isAfterLast()==false){
            arrayList.add(res.getString(res.getColumnIndex("name")));
            res.moveToNext();
        }
        return arrayList;
    }
}