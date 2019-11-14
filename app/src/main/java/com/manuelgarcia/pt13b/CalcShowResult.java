package com.manuelgarcia.pt13b;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

class CalcShowResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_show_result);

        String res = null;

        Log.d("Startresult", "Comença el calcul");

        try {
            Intent intent = getIntent();
            res = "";
            int resInt;

            int primerOp = Integer.parseInt(intent.getStringExtra("primer"));
            int segonOp = Integer.parseInt(intent.getStringExtra("segon"));
            int op = intent.getIntExtra("operador", 0);
            switch (op) {
                case 0:
                    resInt = primerOp + segonOp;
                    res = " sumar " + primerOp + " i " + segonOp + " és: " + resInt + ";" + String.valueOf(resInt);
                    Log.d("suma",res);
                    break;
                case 1:
                    resInt = primerOp - segonOp;
                    res = " restar " + primerOp + " i " + segonOp + " és: " + String.valueOf(resInt);
                    Log.d("resta",res);
                    break;
                case 2:
                    resInt = primerOp * segonOp;
                    res = " multiplicar " + primerOp + " i " + segonOp + " és: " + String.valueOf(resInt);
                    Log.d("multiplicacio",res);
                    break;
                case 3:
                    resInt = primerOp / segonOp;
                    res = " dividir " + primerOp + " i " + segonOp + " és: " + String.valueOf(resInt);
                    Log.d("divisio",res);
                    break;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "El resultat de" + res, Toast.LENGTH_LONG).show();
    }
}