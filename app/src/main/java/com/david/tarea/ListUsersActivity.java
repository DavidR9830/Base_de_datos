package com.david.tarea;

import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.room.Room;
import com.david.tarea.adapter.ListAdapter;
import com.david.tarea.model.AppDatabase;
import com.david.tarea.model.User;

import java.util.List;

public class ListUsersActivity extends AppCompatActivity {
    AppDatabase appDatabase;
    List<User> listUsers;
    private ListView listView;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "Tarea").allowMainThreadQueries().build();

        listUsers = appDatabase.userDao().getAllUsers();

        listView = findViewById(R.id.listView);

        listAdapter = new ListAdapter(this, R.layout.item_row, listUsers);

        listView.setAdapter(listAdapter);

    }
}