package studentattendancesystem.devteam.com.studentattendancesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LogInActivity extends AppCompatActivity {
    TextView LogInTxt;
    Button LogInBtn,AddStudentBtn;
    String LogInTextViewText;
    DBconnections StudentsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        LogInBtn = (Button)findViewById(R.id.LogInBtn);
        AddStudentBtn = (Button)findViewById(R.id.AddStudentBtn);
        LogInTxt = (TextView)findViewById(R.id.LogInTxt);

        LogInTextViewText = LogInTxt.getText().toString().trim();

        AddStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LogInActivity.this,AddStudentToDB.class));
            }
        });

        LogInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //StudentsDB.insertRowStudent(LogInTextViewText);
                startActivity(new Intent(getApplicationContext(),Scan_Activity.class));
            }
        });

    }
}
