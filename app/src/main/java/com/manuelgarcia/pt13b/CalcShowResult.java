package com.manuelgarcia.pt13b;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalcShowResult extends AppCompatActivity {

    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_show_result);
        Intent intent = getIntent();

        setTitle("Resultat Calculadora");

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

        TextView text = findViewById(R.id.resultat);
        text.setText(String.format("El resultat de%s", res));
        result = text.getText().toString();

    }


    @Override
    public void finish() {
        if (!result.equals("")) {
            Intent intent = new Intent();
            intent.putExtra("result", result);
            setResult(RESULT_OK, intent);
        } else {
            Log.d("test", "passa finish ");
            //back botó , torna com a canceled
            Intent intent = new Intent();
            intent.putExtra("result", "");
            setResult(RESULT_CANCELED, intent);
        }
        Log.d("test", "passa ");
        super.finish();
    }

    public void Tornar(View view) {
        finish();
    }


}
