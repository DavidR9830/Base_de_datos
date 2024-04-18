package com.david.tarea;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.room.Room;
import com.david.tarea.model.AppDatabase;
import com.david.tarea.model.User;
import com.david.tarea.model.UserDao;

public class MainActivity extends AppCompatActivity {

    private String name, email, password;
    private EditText etName,etEmail, etPassword;
    AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "Tarea").allowMainThreadQueries().build();
    }

    public void addUser(View view){
        name = etName.getText().toString();
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();

        UserDao userDao = appDatabase.userDao();
        User user = new User(name, email, password);
        userDao.insertUserOrUsers(user);
    }

    public void listUsersActivity(View view){
        Intent listActivity = new Intent(this, ListUsersActivity.class);
        startActivity(listActivity);
    }
}