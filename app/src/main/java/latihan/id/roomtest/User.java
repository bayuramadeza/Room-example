package latihan.id.roomtest;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "Name")
    private String name;
    @ColumnInfo(name = "Gender")
    private String kelamin;

    public User(String name, String kelamin) {
        this.name = name;
        this.kelamin = kelamin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getKelamin() {
        return kelamin;
    }
}
