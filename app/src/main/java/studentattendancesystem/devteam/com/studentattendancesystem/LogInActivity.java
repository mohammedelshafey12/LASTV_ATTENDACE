package studentattendancesystem.devteam.com.studentattendancesystem;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LogInActivity extends AppCompatActivity {
    TextView LogInTxt;
    Button LogInBtn;
    String LogInTextViewText;
    Students_db StudentsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        LogInBtn = (Button)findViewById(R.id.LogInBtn);

        LogInTxt = (TextView)findViewById(R.id.LogInTxt);

        LogInTextViewText = LogInTxt.getText().toString().trim();



        LogInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Long id =   StudentsDB.insertData("Ahmed Fathy","1234");
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            }
        });

    }
}
