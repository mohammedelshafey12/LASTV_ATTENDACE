package studentattendancesystem.devteam.com.studentattendancesystem;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class LogInActivity extends AppCompatActivity {
    EditText LogInEditText;
    Button LogInBtn,AddStudentBtn;

    DBconnections StudentsDB;
    ArrayList<students> studentsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        if(!isFirstTimeStartApp()){
            //if not the first time to open the app --> go to home activity directly
            setFirstTimeStartStatus(false);
            startActivity(new Intent(this,Scan_Activity.class));
            finish();
        }
        //==========================================================================================
        LogInBtn = (Button)findViewById(R.id.LogInBtn);
        AddStudentBtn = (Button)findViewById(R.id.AddStudentBtn);
        LogInEditText = (EditText) findViewById(R.id.EditText);
        StudentsDB = new DBconnections(this);
        studentsList = new ArrayList<>();
        studentsList = StudentsDB.getAllStudentsList();

        //==========================================================================================
        AddStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LogInActivity.this,AddStudentToDB.class));
            }
        });

        LogInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String LogInTextViewText = LogInEditText.getText().toString().trim();
                for (int i = 0; i <studentsList.size() ; i++) {
                    if(Objects.equals(LogInTextViewText, studentsList.get(i).getMstudent_id().toString())){ // --> true)){

                        Toast.makeText(LogInActivity.this, "We found you in DataBase", Toast.LENGTH_SHORT).show();
                        setFirstTimeStartStatus(false);
                        startActivity(new Intent(LogInActivity.this,Scan_Activity.class));
                    }else{
                        Toast.makeText(LogInActivity.this, "false  \n"+LogInTextViewText + " \n" + studentsList.get(i).getmStudentNmae().toString() + " \n"+ studentsList.get(i).getMstudent_id().toString(), Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
        //==========================================================================================
        private boolean isFirstTimeStartApp(){
            SharedPreferences pref = getApplicationContext().getSharedPreferences("LogInActivity", Context.MODE_PRIVATE);
            return pref.getBoolean("FirstTimeStartFlag",true);
        }
        private void setFirstTimeStartStatus(boolean stt){
            SharedPreferences pref = getApplicationContext().getSharedPreferences("LogInActivity", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("FirstTimeStartFlag",stt);
            editor.commit();
        }
        //==========================================================================================
}
