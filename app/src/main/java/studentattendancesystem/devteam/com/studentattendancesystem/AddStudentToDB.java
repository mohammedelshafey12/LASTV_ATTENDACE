package studentattendancesystem.devteam.com.studentattendancesystem;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudentToDB extends AppCompatActivity {
    EditText Name,ID;
    Button AddButton;
    DBconnections dBconnections;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_to_db);

        Name = (EditText)findViewById(R.id.StudentName);
        ID = (EditText)findViewById(R.id.StudentID);
        AddButton = (Button)findViewById(R.id.AddButton);

        //==========================================================================================
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dBconnections = new DBconnections(getApplicationContext());
                if(!Name.getText().toString().trim().isEmpty() && !ID.getText().toString().trim().isEmpty() ) {
                    dBconnections.addStudentDetail(ID.getText().toString(),Name.getText().toString());

                    Toast.makeText(AddStudentToDB.this, "Stored Successfully!" , Toast.LENGTH_SHORT).show();

                    Name.setText("");
                    ID.setText("");

                }else{
                    Toast.makeText(AddStudentToDB.this, " Not a valid info!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //==========================================================================================
    }
}
