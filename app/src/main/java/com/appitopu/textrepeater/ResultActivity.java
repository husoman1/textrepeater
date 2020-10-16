package com.appitopu.textrepeater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class ResultActivity extends AppCompatActivity {

    TextView sonuc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        sonuc = (TextView) findViewById(R.id.textView);

        Intent i = getIntent();
        String q = i.getStringExtra("Answer");
        String yont = i.getStringExtra("yonte");

        if ("a3".equals(yont)){
            sonuc.setTypeface(null, Typeface.BOLD);
        }
        else if ("a4".equals(yont))
            sonuc.setTypeface(null, Typeface.BOLD);
        else if ("a5".equals(yont))
            sonuc.setTypeface(null, Typeface.ITALIC);
        else if ("a6".equals(yont))
            sonuc.setTypeface(null, Typeface.ITALIC);

        sonuc.setText(q);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.clipboard,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.copy){

            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("EditText", sonuc.getText().toString());
            clipboard.setPrimaryClip(clip);
            clip.getDescription();
            Toast.makeText(ResultActivity.this, "Copied" , Toast.LENGTH_LONG).show();


        }
        if(item.getItemId() == android.R.id.home){
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
