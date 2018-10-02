package studentattendancesystem.devteam.com.studentattendancesystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class Students_db extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="Student.db";
    private static final String TABLE_STUDENT="students";
    private static final String COLOUM_ID="_id";
    private static final String COLOUM_STUDENTID="Student_id";
    private static final String COLOUM_STUDENT_NAME="Student_Name";

    public Students_db(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
       String query = " CREATE TABLE " + TABLE_STUDENT + " ( " + COLOUM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLOUM_STUDENTID + "TEXT" + COLOUM_STUDENT_NAME + "TEXT" +  " ); ";
       db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
      db.execSQL(" DROP TABLE IF EXISTS " + TABLE_STUDENT);
      onCreate(db);
    }
    public void addstudent (students students){
        ContentValues values = new ContentValues();
        values.put(COLOUM_STUDENTID , students.getMstudent_id());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_STUDENT,null,values);
        db.close();
    }

    public boolean check_login(String u_name, String u_pwd) {

        SQLiteDatabase db = this.getWritableDatabase();
        String select = "SELECT * FROM students WHERE Student_Name ='" + u_name + "' AND Student_id='" + u_pwd + "'";

        Cursor c = db.rawQuery(select, null);

        if (c.moveToFirst()) {
            Log.d(TAG,"User exits");
            return true;
        }

        if(c!=null) {
            c.close();
        }
        db.close();
        return false;
    }
    public String getID(String u_name, String u_pwd) {

        SQLiteDatabase db = this.getWritableDatabase();
        String select = "SELECT * FROM students WHERE Student_Name ='" + u_name + "' AND Student_id='" + u_pwd + "'";
        String ID = "";
        Cursor c = db.rawQuery(select, null);
        c.moveToFirst();

        while (!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("Student_id")) != null){
               ID += c.getString(c.getColumnIndex("Student_id"));
               ID += "\n";
            }
            c.moveToNext();
        }
        return ID;
    }

    public String getName (String u_name, String u_pwd) {

        SQLiteDatabase db = this.getWritableDatabase();
        String select = "SELECT * FROM students WHERE Student_Name ='" + u_name + "' AND Student_id='" + u_pwd + "'";
        String ID = "";
        Cursor c = db.rawQuery(select, null);
        c.moveToFirst();

        while (!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("Student_id")) != null){
                ID += c.getString(c.getColumnIndex("Student_Name"));
                ID += "\n";
            }
            c.moveToNext();
        }
        return ID;
    }

}
