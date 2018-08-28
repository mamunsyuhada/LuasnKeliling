package com.example.praktikan.luasnkeliling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spName;
    EditText inPut;
    TextView hasil_luas;
    TextView hasil_keliling;
    String bentuk;
    private String sisi;
    private CheckBox luas, keliling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spName = findViewById(R.id.spinner);
        inPut = findViewById(R.id.input);
        luas = findViewById(R.id.luasCheck);
        keliling = findViewById(R.id.kelilingCheck);

        hasil_luas = findViewById(R.id.hasil_luas);
        hasil_keliling = findViewById(R.id.hasil_keliling);

        hasil_keliling.setVisibility(View.GONE);
        hasil_luas.setVisibility(View.GONE);

        spName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bentuk = spName.getSelectedItem().toString();
                Log.d("bentuknya : ", bentuk);

                pilihBentuk();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void pilihBentuk() {
        sisi = inPut.getText().toString();

        if (bentuk.equals("persegi")){
            Log.d("persegi", "yes");
            inPut.setHint("masukkan sisi " +bentuk);
            inPut.setEnabled(true);

            hasil_luas.setText(sisi);
            hasil_keliling.setText(sisi);

        }
        if (bentuk.equals("segitiga")){
            Log.d("segitiga", "yes");
            inPut.setHint("masukkan sisi " +bentuk);
            inPut.setEnabled(true);

            hasil_luas.setText(sisi);
            hasil_keliling.setText(sisi);
        }
        if (bentuk.equals("lingkaran")){
            inPut.setHint("masukkan sisi " +bentuk);
            inPut.setEnabled(true);

            hasil_luas.setText(sisi);
            hasil_keliling.setText(sisi);
        }
        if (bentuk.equals("pilih bentuk")){
            inPut.setHint("pilih bentuk dulu");
            inPut.setEnabled(false);
        }
    }

    public void checkBoxLuas(View view) {
        Boolean terChecked = ((CheckBox)view).isChecked();
        if (terChecked.equals(true)){
            hasil_luas.setVisibility(View.VISIBLE);
        }else {
            hasil_luas.setVisibility(View.GONE);
        }
    }

    public void checkBoxKeliling(View view) {
        Boolean terChecked = ((CheckBox)view).isChecked();
        if (terChecked.equals(true)){
            hasil_keliling.setVisibility(View.VISIBLE);
        }else {
            hasil_keliling.setVisibility(View.GONE);
        }

    }
}
