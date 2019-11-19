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
        double resDouble;

        int primerOp = Integer.parseInt(intent.getStringExtra("primer"));
        int segonOp = Integer.parseInt(intent.getStringExtra("segon"));
        int op = intent.getIntExtra("operador", 0);
        switch (op) {
            case 0:
                resDouble = primerOp + segonOp;
                res = " sumar " + primerOp + " i " + segonOp + " és: " + resDouble;

                break;
            case 1:
                resDouble = primerOp - segonOp;
                res = " restar " + primerOp + " i " + segonOp + " és: " + resDouble;
                break;
            case 2:
                resDouble = primerOp * segonOp;
                res = " multiplicar " + primerOp + " i " + segonOp + " és: " + resDouble;
                break;
            case 3:
                resDouble = (double) primerOp / segonOp;
                res = " dividir " + primerOp + " i " + segonOp + " és: " + resDouble;
                break;

        }

        Toast.makeText(this, "El resultat de" + res, Toast.LENGTH_LONG).show();
    }
}
