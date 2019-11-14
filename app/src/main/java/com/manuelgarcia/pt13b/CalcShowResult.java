package com.manuelgarcia.pt13b;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CalcShowResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_show_result);
        Intent intent = getIntent();

        String res = "";
        int resInt;

        int primerOp = Integer.parseInt(intent.getStringExtra("primer"));
        int segonOp = Integer.parseInt(intent.getStringExtra("segon"));
        int op = intent.getIntExtra("operador", 0);
        switch (op) {
            case 0:
                resInt = primerOp + segonOp;
                res = " sumar " + primerOp + " i " + segonOp + " és: " + resInt;

                break;
            case 1:
                resInt = primerOp - segonOp;
                res = " restar " + primerOp + " i " + segonOp + " és: " + resInt;
                break;
            case 2:
                resInt = primerOp * segonOp;
                res = " multiplicar " + primerOp + " i " + segonOp + " és: " + resInt;
                break;
            case 3:
                resInt = primerOp / segonOp;
                res = " dividir " + primerOp + " i " + segonOp + " és: " + resInt;
                break;

        }

        Toast.makeText(this, "El resultat de" + res, Toast.LENGTH_LONG).show();
    }
}
