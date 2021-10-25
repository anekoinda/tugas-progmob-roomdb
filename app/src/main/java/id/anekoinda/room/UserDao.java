package id.anekoinda.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {


//    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
//    List<User> loadAllByIds(int[] userIds);

//    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    User findByName(String first, String last);

    @Insert
    void insertUser(User users);

    @Insert
    void getAllUsers(User users);

    @Query("DELETE FROM user WHERE nik = :nik")
    void delete(String nik);

    @Query("SELECT * FROM user")
    List<Model> getAllUsers();

    @Query("UPDATE user SET keterangan = :keterangan, is_valid = :is_valid WHERE nik =:nik")
    abstract void update(String nik, String keterangan, String is_valid);
}
