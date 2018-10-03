package studentattendancesystem.devteam.com.studentattendancesystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBconnections extends SQLiteOpenHelper{
    public static String DATABASE_NAME = "student_database";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_STUDENTS = "students";
    private static final String KEY_ID = "_id";
    private static final String KEY_FIRSTNAME = "name";
    private static final String KEY_STUDENT_ID = "id";
    /*CREATE TABLE students ( id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone_number TEXT......);*/

    private static final String CREATE_TABLE_STUDENTS = "CREATE TABLE "
            + TABLE_STUDENTS + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_STUDENT_ID + " TEXT ," + KEY_FIRSTNAME + " TEXT );";

    public DBconnections(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        Log.d("table", CREATE_TABLE_STUDENTS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STUDENTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_STUDENTS + "'");
        onCreate(db);
    }
    //==========================================================================================
    public long addStudentDetail(String student_id,String student_name) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Creating content values
        ContentValues values = new ContentValues();
        values.put(KEY_STUDENT_ID, student_id);
        values.put(KEY_FIRSTNAME, student_name);
        // insert row in students table
        long insert = db.insert(TABLE_STUDENTS, null, values);

        return insert;
    }

    public ArrayList<students> getAllStudentsList() {
        ArrayList<students> studentsArrayList = new ArrayList<students>();
        String name="";
        String ID ="";
        String selectQuery = "SELECT  * FROM " + TABLE_STUDENTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                ID = c.getString(c.getColumnIndex(KEY_STUDENT_ID));
                name = c.getString(c.getColumnIndex(KEY_FIRSTNAME));
                // adding to Students list

                studentsArrayList.add(new students(ID,name));
            } while (c.moveToNext());
            Log.d("array", studentsArrayList.toString());
        }
        return studentsArrayList;
    }
    //==========================================================================================
}
