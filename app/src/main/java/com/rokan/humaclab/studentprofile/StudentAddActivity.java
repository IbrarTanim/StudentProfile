package com.rokan.humaclab.studentprofile;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rokan.humaclab.studentprofile.db.DaoMaster;
import com.rokan.humaclab.studentprofile.db.DaoSession;
import com.rokan.humaclab.studentprofile.db.Student;
import com.rokan.humaclab.studentprofile.db.StudentDao;

import java.util.Date;

public class StudentAddActivity extends AppCompatActivity {

    private ImageView studentPhoto;
    private EditText edtName;
    private EditText edtSubject;
    private EditText edtCGPA;
    private EditText edtUniversity;
    private Date dob;
    private TextView tvDOB;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_add);

        initUI();

    }

    private void initUI() {

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "lease-db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        final DaoSession daoSession = daoMaster.newSession();
        final Student student = new Student();

        initID();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = edtName.getText().toString();
                student.setName(name);

                String subject = edtSubject.getText().toString();
                student.setSubject(subject);

                String cgpa = edtCGPA.getText().toString();
                student.setCgpa(Double.parseDouble(cgpa));

                String university = edtUniversity.getText().toString();
                student.setUniversity(university);

                StudentDao studentDao = daoSession.getStudentDao();
                studentDao.insert(student);
                Toast.makeText(getApplicationContext(), "Data Added Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(StudentAddActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initID() {
        edtName = (EditText) findViewById(R.id.etName);
        edtSubject = (EditText) findViewById(R.id.etSubject);
        edtCGPA = (EditText) findViewById(R.id.etCGPA);
        edtUniversity = (EditText) findViewById(R.id.etUniversity);
        btnSave = (Button) findViewById(R.id.btnSave);
    }

}
