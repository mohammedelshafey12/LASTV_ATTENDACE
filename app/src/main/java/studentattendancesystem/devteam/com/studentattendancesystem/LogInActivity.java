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

public class LogInActivity extends AppCompatActivity {
    EditText LogInTxt;
    Button LogInBtn,AddStudentBtn;
    String LogInTextViewText;
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
        LogInTxt = (EditText) findViewById(R.id.LogInTxt);
        StudentsDB = new DBconnections(this);
        studentsList = new ArrayList<>();
        LogInTextViewText = LogInTxt.getText().toString().trim();
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
               studentsList =  StudentsDB.getAllStudentsList();
                for (int i = 0; i <studentsList.size() ; i++) {
                    if(LogInTextViewText.equalsIgnoreCase(studentsList.get(i).getMstudent_id())){
                        Toast.makeText(LogInActivity.this, ""+studentsList.get(i).getMstudent_id()+"\n" , Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),Scan_Activity.class));
                        setFirstTimeStartStatus(false);

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
