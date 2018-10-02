package studentattendancesystem.devteam.com.studentattendancesystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddStudentToDB extends AppCompatActivity {
    EditText Name,ID;
    Button AddButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_to_db);

        Name = (EditText)findViewById(R.id.StudentName);
        ID = (EditText)findViewById(R.id.StudentID);
        AddButton = (Button)findViewById(R.id.AddButton);


    }
}
