package com.manuelgarcia.pt13b;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    private void setSupportActionBar(android.widget.Toolbar toolbar) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onSendURL(View v) {
        EditText url = findViewById(R.id.url);
        String link = url.getText().toString();

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        Intent chooser = Intent.createChooser(intent, link);

        startActivity(chooser);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.menuInsta) {
            try {
                String igUrl = "https://www.instagram.com/android";

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(igUrl));
                intent.setPackage("com.instagram.android");

                if (intent.resolveActivity(getPackageManager()) == null) {
                    Toast.makeText(this, "no troba instagram instal·lada, obre navegador", Toast.LENGTH_SHORT).show();
                    Log.d("test", "no troba instagram");

                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(igUrl)));
                } else {
                    Log.d("test", "invoca instagram ");
                }
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("test", e.getMessage() + e.getCause());
            }
            return true;
        } else if (id == R.id.menuWhats) {
 /*
            try {
                String igUrl = "https://www.instagram.com/android";

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(igUrl));
                intent.setPackage("com.whatsapp");

                if (intent.resolveActivity(getPackageManager()) == null) {
                    Toast.makeText(this, "no troba WhatsApp instal·lat, obre navegador", Toast.LENGTH_SHORT).show();
                    Log.d("test", "no troba WhatsApp");

                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(igUrl)));
                } else {
                    Log.d("test", "compart a WhatsApp ");
                }
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("test", e.getMessage() + e.getCause());
            }

  */
            return true;

        } else if (id == R.id.menuCalc) {
            startActivity(new Intent(this, Calculadora.class));

        }

        return super.onOptionsItemSelected(item);
    }
}
