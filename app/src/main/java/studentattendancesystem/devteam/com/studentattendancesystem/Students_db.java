package studentattendancesystem.devteam.com.studentattendancesystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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



}
