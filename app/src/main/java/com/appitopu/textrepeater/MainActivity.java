package com.appitopu.textrepeater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText tx;
    TextView ans;
    EditText nr;
    String s;
    int carpim=0;
    String tekrar="";
    RadioButton textBold,textNormal,textItalic;
    Switch switchLine=null;
    String yontem="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button) findViewById(R.id.button);
        tx = (EditText) findViewById(R.id.editText);
        nr =  (EditText) findViewById(R.id.editText3);
        s = tx.getText().toString();
        switchLine = (Switch) findViewById(R.id.switch1);
        textBold = (RadioButton) findViewById(R.id.bold);
        textNormal = (RadioButton) findViewById(R.id.normal);
        textItalic = (RadioButton) findViewById(R.id.italic);

        String temp = nr.getText().toString();
        if(!"".equals(temp))
            carpim= Integer.parseInt(temp);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = tx.getText().toString();
                String temp = nr.getText().toString();
                if(!"".equals(temp)) {
                    carpim = Integer.parseInt(temp);
                    if (textNormal.isChecked()){
                        if (switchLine.isChecked()){
                            yontem="a1";
                            for(int i=0;i<carpim;i++)
                                tekrar= tekrar+s+"\n";
                        }
                        else{
                            yontem="a2";
                            for(int i=0;i<carpim;i++)
                                tekrar= tekrar+s;
                        }
                    }
                    else if (textBold.isChecked()){
                        if (switchLine.isChecked()){
                            yontem="a3";
                            for(int i=0;i<carpim;i++)
                                tekrar= tekrar+s+"\n";
                            ans.setTypeface(null, Typeface.BOLD);
                        }
                        else{
                            yontem="a4";
                            for(int i=0;i<carpim;i++)
                                tekrar= tekrar+s;
                            ans.setTypeface(null, Typeface.BOLD);
                        }
                    }
                    else {
                        if (switchLine.isChecked()){
                            yontem="a5";
                            for(int i=0;i<carpim;i++)
                                tekrar= tekrar+s+"\n";
                            ans.setTypeface(null, Typeface.ITALIC);
                        }
                        else{
                            yontem="a6";
                            for(int i=0;i<carpim;i++)
                                tekrar= tekrar+s;
                            ans.setTypeface(null, Typeface.ITALIC);
                        }
                    }
                }


                Intent i = new Intent(getApplicationContext(), ResultActivity.class);
                i.putExtra("Answer",tekrar);
                i.putExtra("yonte",yontem);
                i.putExtra("carpi",carpim);
                startActivity(i);





            }

        });





    }
}
