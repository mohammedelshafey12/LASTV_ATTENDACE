package studentattendancesystem.devteam.com.studentattendancesystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ArrayList arrayList;
    TextView tvnames;
    DBconnections dBconnections;
    EditText etname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
            //kjjkkjyuguyguugug
        arrayList = new ArrayList();
        dBconnections = new DBconnections(this);
        tvnames = (TextView) findViewById(R.id.tvnames);
        Button btnStore = (Button) findViewById(R.id.btnstore);
        Button btnGetall = (Button) findViewById(R.id.btnget);
        etname = (EditText) findViewById(R.id.etname);
        //==========================================================================================
        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dBconnections.addStudentDetail(etname.getText().toString(),"1234");
                etname.setText("");

            }
        });
        btnGetall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList = dBconnections.getAllStudentsList();
                tvnames.setText("");


            }
        });
        //==========================================================================================
    }

}
