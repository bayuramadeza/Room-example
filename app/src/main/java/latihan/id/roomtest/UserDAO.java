package latihan.id.roomtest;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDAO {
    @Query("SELECT * FROM user")
    List<User> getUser();

    @Insert
    Long insertAll(User users);

    @Delete
    void deleteData(User user);
}
