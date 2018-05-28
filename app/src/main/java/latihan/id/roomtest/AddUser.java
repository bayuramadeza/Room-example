package latihan.id.roomtest;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AddUser extends AppCompatActivity {

    TextInputEditText etName, etKelamin;
    Button bAdd;
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        etName = findViewById(R.id.ti_name);
        etKelamin = findViewById(R.id.ti_kelamin);
        bAdd = findViewById(R.id.b_add);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "User Production")
                .allowMainThreadQueries()
                .build();

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData(new User(etName.getText().toString(), etKelamin.getText().toString()));
                onBackPressed();
            }
        });
    }

    @SuppressLint("StaticFieldLeak")
    private void insertData(final User user){
        new AsyncTask<Void, Void, Long>(){
            @Override
            protected Long doInBackground(Void... voids) {
                return db.userDAO().insertAll(user);
            }

            @Override
            protected void onPostExecute(Long aLong) { ;
                Toast.makeText(AddUser.this, user.getName(), Toast.LENGTH_LONG).show();
            }
        }.execute();
    }
}
