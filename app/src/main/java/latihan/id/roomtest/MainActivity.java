package latihan.id.roomtest;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    RecyclerView recyclerView;
    List<User> userList;
    UserAdapter userAdapter;
    String nama, kelamin;
    AppDatabase db;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "User Production")
                .allowMainThreadQueries()
                .build();

        floatingActionButton = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recycler_view);
        userList = db.userDAO().getUser();

        userAdapter = new UserAdapter(userList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userAdapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "pressed");
                Intent intentAddUser = new Intent(MainActivity.this, AddUser.class);
                startActivityForResult(intentAddUser, 1);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        userList = db.userDAO().getUser();
        userAdapter = new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);
    }
}
