package id.anekoinda.room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    @NonNull
    public String nik ;

    @ColumnInfo(name = "nama")
    public String nama;

    @ColumnInfo(name = "telepon")
    public String telepon;

    @ColumnInfo(name = "jenis_kelamin")
    public String jenis_kelamin;

    @ColumnInfo(name = "kondisi_kesehatan")
    public String kondisi_kesehatan;

    @ColumnInfo(name = "persentase_kondisi")
    public String persentase_kondisi;

    @ColumnInfo(name = "keterangan")
    public String keterangan;

    @ColumnInfo(name = "is_valid")
    public String is_valid;
}
