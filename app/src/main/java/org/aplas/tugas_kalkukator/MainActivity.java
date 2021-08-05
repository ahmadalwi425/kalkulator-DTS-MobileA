package org.aplas.tugas_kalkukator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView hasil, operator;
    EditText angka1, angka2;
    Button tambah, kurang, kali, bagi, hitung;
    float hasilhitung;
    Character operasi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);
        angka1 = findViewById(R.id.inputangka1);
        operator = findViewById(R.id.txtoperator);
        angka2 = findViewById(R.id.inputangka2);
        hasil = findViewById(R.id.txthasil);
        tambah = findViewById(R.id.optambah);
        kurang = findViewById(R.id.opkurang);
        kali = findViewById(R.id.opkali);
        bagi = findViewById(R.id.opbagi);
        hitung = findViewById(R.id.buttonHitung);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator.setText("ditambah");
                operasi='+';
            }
        });
        kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator.setText("dikurang");
                operasi='-';
            }
        });
        kali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator.setText("dikali");
                operasi='*';
            }
        });
        bagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator.setText("dibagi");
                operasi='/';
            }
        });
        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEmpty(angka1) || isEmpty(angka2)) {
                    hasil.setText("Input kedua isian terlebih dahulu");
                }else if(operasi == null) {
                    hasil.setText("Pilih operator terlebih dahulu");
                }else {
                    int iangka1 = Integer.parseInt(angka1.getText().toString());
                    int iangka2 = Integer.parseInt(angka2.getText().toString());
                    switch (operasi) {
                        case '+':
                            hasilhitung = iangka1 + iangka2;
                            hasil.setText(Float.toString(hasilhitung));
                            break;
                        case '-':
                            hasilhitung = iangka1 - iangka2;
                            hasil.setText(Float.toString(hasilhitung));
                            break;
                        case '*':
                            hasilhitung = iangka1 * iangka2;
                            hasil.setText(Float.toString(hasilhitung));
                            break;
                        case '/':
                            hasilhitung = iangka1 / iangka2;
                            hasil.setText(Float.toString(hasilhitung));
                            break;
                        default:
                            hasil.setText("Tentukan operator terlebih dahulu");
                            break;
                    }

                }
            }
        });

    }

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }
}

