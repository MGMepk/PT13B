package com.manuelgarcia.pt13b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

import static java.util.Arrays.asList;

public class Calculadora extends AppCompatActivity {

    Spinner spinner;
    EditText edtP1, edtP2;
    public static final int ACTIVITY_CALC = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        ArrayList<String> llista = new ArrayList<>(asList("Suma", "Resta", "Multiplicació", "Divisió"));

        spinner = findViewById(R.id.spinnerOp);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, llista);
        spinner.setAdapter(arrayAdapter);


        edtP1 = findViewById(R.id.editText1);
        edtP2 = findViewById(R.id.editText2);

        //entrada 2 per números aleatoris
        String op1 = String.valueOf(new Random().nextInt(21));
        String op2 = String.valueOf(new Random().nextInt(21));

        edtP1.setText(op1);
        edtP2.setText(op2);
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == ACTIVITY_CALC && resultCode == Activity.RESULT_OK){
            Bundle extras = data.getExtras();
            if (extras != null) {
                String res = extras.getString("result");
                TextView text = findViewById(R.id.resultView);
                text.setText(res);
            }
        }
    }

    public void operar(View view) {
        try {
            String op1 = edtP1.getText().toString();
            String op2 = edtP2.getText().toString();

            int position = spinner.getSelectedItemPosition();

            Intent intent = new Intent(this, CalcShowResult.class);
            Bundle bundle = new Bundle();
            bundle.putString("primer", op1);
            bundle.putString("segon", op2);
            bundle.putInt("operador", position);

            intent.putExtras(bundle);
            startActivityForResult(intent, ACTIVITY_CALC);

        } catch (Exception e) {
            Log.d("Testing", e.getCause() + e.getMessage());
        }

    }

}
