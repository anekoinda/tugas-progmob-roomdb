package id.anekoinda.room;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FormEdit extends AppCompatActivity {
    private ArrayList<Model> dataholder = new ArrayList<>();
//    DBHelper db;
    SQLiteDatabase sqLiteDatabase;
    EditText input_keterangan;
    TextView txt_nik, txt_nama, txt_telepon, txt_jenkel, txt_persentase, txt_kondisi;
    Button button_update;
    RadioGroup radioGroup;
    RadioButton radioButton;

    String nik, keterangan, is_valid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_edit);
//        DBHelper db = new DBHelper(this);

        findid();

        if (getIntent().getBundleExtra("datavaksin") != null) {
            Bundle bundle = getIntent().getBundleExtra("datavaksin");
            txt_nik.setText(bundle.getString("nik"));
            txt_nama.setText(bundle.getString("nama"));
            txt_telepon.setText(bundle.getString("telepon"));
            txt_jenkel.setText(bundle.getString("jenis_kelamin"));
            txt_kondisi.setText(bundle.getString("kondisi_kesehatan"));
            txt_persentase.setText(bundle.getString("persentase_kondisi"));
            input_keterangan.setText(bundle.getString("keterangan"));

            //get radio
            RadioButton radValid = (RadioButton)findViewById(R.id.yes);
            RadioButton radTidak = (RadioButton)findViewById(R.id.no);

            if ("1".equals(bundle.getString("is_valid"))){
                radValid.setChecked(true);
            } else if ("0".equals(bundle.getString("is_valid"))){
                radTidak.setChecked(true);
            } else {
                radValid.setChecked(false);
                radTidak.setChecked(false);
            }
        }

        button_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroup = findViewById(R.id.radio_valid);
                input_keterangan = findViewById(R.id.input_keterangan);

                int valid = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(valid);

                String value = "";
                if (radioButton.getText().toString().equals("Tolak")) {
                    value = "0";
                }else {
                    value = "1";
                }

                AppDatabase db  = AppDatabase.getDbInstance(id.anekoinda.room.FormEdit.this);
                is_valid = radioButton.getText().toString();
                keterangan = input_keterangan.getText().toString();
                Bundle bundle = getIntent().getBundleExtra("datavaksin");
                updateUser(bundle.getString("nik"), keterangan, value);
            }
        });
    }

    private void findid() {
        txt_nik = findViewById(R.id.txt_nik);
        txt_nama = findViewById(R.id.txt_nama);
        txt_telepon = findViewById(R.id.txt_telepon);
        txt_jenkel = findViewById(R.id.txt_jenkel);
        txt_kondisi = findViewById(R.id.txt_kondisi);
        txt_persentase = findViewById(R.id.txt_persentase);
        input_keterangan = findViewById(R.id.input_keterangan);
        button_update = findViewById(R.id.button_update);
    }

    private void updateUser(String nik, String keterangan, String is_valid) {
        AppDatabase db  = AppDatabase.getDbInstance(this.getApplicationContext());

        User user = new User();
        user.nik = nik;
        user.keterangan = keterangan;
        user.is_valid = is_valid;

        db.userDao().update(nik, keterangan, is_valid);

        Intent intent = new Intent(FormEdit.this, Data.class);
        startActivity(intent);
    }
}