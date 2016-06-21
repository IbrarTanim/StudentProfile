package com.rokan.humaclab.studentprofile;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.rokan.humaclab.studentprofile.db.DaoMaster;
import com.rokan.humaclab.studentprofile.db.DaoSession;
import com.rokan.humaclab.studentprofile.db.StudentDao;

import java.util.List;

import StudentModel_Adapter.StudentAdapter;

public class MainActivity extends AppCompatActivity {

    private ImageView btnImage;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

    }

    private void initUI() {

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "lease-db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();
        StudentDao studentDao = daoSession.getStudentDao();
        List studentList = studentDao.loadAll();

        adapter = new StudentAdapter(studentList);
        layoutManager = new LinearLayoutManager(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        btnImage = (ImageView) findViewById(R.id.addButton);
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StudentAddActivity.class);
                startActivity(intent);

            }
        });

    }


}






