package studentattendancesystem.devteam.com.studentattendancesystem;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    Students_db students_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        final TextView textView = (TextView)findViewById(R.id.TextViewHome);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });




    }

}
