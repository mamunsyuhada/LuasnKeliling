package com.example.praktikan.luasnkeliling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spName;
    private EditText inPut;
    private CheckBox luas;
    private CheckBox keliling;
    private TextView hasil_luas;
    private TextView hasil_keliling;
    private String bentuk;
    private Double luasHasil;
    private Double kelilingHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spName = (Spinner) findViewById(R.id.spinner);
        inPut = (EditText) findViewById(R.id.input);
        luas = (CheckBox) findViewById(R.id.luas);
        luas.setOnClickListener(this);
        keliling = (CheckBox) findViewById(R.id.keliling);
        keliling.setOnClickListener(this);
        hasil_luas = (TextView)findViewById(R.id.hasil_luas);
        hasil_keliling = (TextView) findViewById(R.id.hasil_keliling);

        pilihSpinner();


    }

    private void pilihSpinner() {
        spName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                bentuk = spName.getSelectedItem().toString();
                pilihBentuk();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void pilihBentuk() {

        double sisi = Double.parseDouble(String.valueOf(inPut.getText()));

        if (bentuk == "persegi"){
            luasHasil = sisi * sisi;
            kelilingHasil = sisi * 4;
        }
        if (bentuk == "linkaran"){
            luasHasil = Math.PI * Math.pow(sisi/2,2);
            kelilingHasil = Math.PI * sisi;
        }
        if (bentuk == "segitiga"){
            double tinggi = Math.pow(sisi,2) * Math.pow(sisi/2,2);
            luasHasil = 0.5 * sisi * tinggi;
            kelilingHasil = sisi * 3;
        }

        hasil_luas.setText("Luas " + bentuk + " = " + luasHasil);
        hasil_keliling.setText("Keliling " + bentuk + " = " + kelilingHasil);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.luas:
                if (luas.isChecked()){
                    Toast.makeText(MainActivity.this, "Luas Checked", Toast.LENGTH_LONG);
                }else {
                    Toast.makeText(MainActivity.this,"Keliling Checked", Toast.LENGTH_LONG);
                }
                break;
            case R.id.keliling:
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
