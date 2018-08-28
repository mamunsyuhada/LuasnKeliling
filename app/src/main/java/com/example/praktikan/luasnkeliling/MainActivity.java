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
    CheckBox luas;
    CheckBox keliling;
    TextView hasil_luas;
    TextView hasil_keliling;
    String bentuk;
    Double luasHasil;
    Double kelilingHasil;
    TextView tvBentuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spName = findViewById(R.id.spinner);
        inPut = findViewById(R.id.input);
//        luas = (CheckBox) findViewById(R.id.luasCheck);
//        keliling = (CheckBox) findViewById(R.id.kelilingCheck);

        hasil_luas = findViewById(R.id.hasil_luas);
        hasil_keliling = findViewById(R.id.hasil_keliling);

        hasil_luas.setVisibility(View.GONE);
        hasil_keliling.setVisibility(View.GONE);

        spName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bentuk = spName.getSelectedItem().toString();
                Log.d("bentuknya : ", bentuk);
                inPut.setHint("masukkan sisi " +bentuk);

                pilihBentuk();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void pilihBentuk() {
        if (bentuk.equals("persegi")){
            Log.d("persegi", "yes");
        }
        if (bentuk.equals("segitiga")){
            Log.d("segitiga", "yes");
        }
        if (bentuk.equals("lingkaran")){
            Log.d("persegi", "yes");
        }
    }


    public void checkBox(View view) {
        Boolean terChecked = ((CheckBox)view).isChecked();

        switch (view.getId()){
            case R.id.luasCheck:
                if (terChecked){
                    hasil_luas.setVisibility(View.VISIBLE);
                }else {
                    hasil_luas.setVisibility(View.GONE);
                }
                break;
            case R.id.kelilingCheck:
                if (terChecked){
                    hasil_keliling.setVisibility(View.VISIBLE);
                }else {
                    hasil_keliling.setVisibility(View.GONE);
                }
        }
    }
}
