package com.wolborg.hangdroid;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    String mWord = "WORD";
    int failsCounter = 0,passCounter=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    public void introduceLetter(View v){

        EditText et = (EditText) findViewById(R.id.introducedLetter);
        String str = et.getText().toString();
        et.setText("");

        if(str.length() == 1)
            checkLetter(str);
        else{
            Toast.makeText(this,"Please Enter one  letter.",Toast.LENGTH_LONG).show();
        }
    }

    public void checkLetter(String str) {

        Vibrator vibe = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibe.vibrate(150);
        Boolean check = false;
        char letterEntered = str.charAt(0);
        for (int i =0;i<mWord.length();i++){

            char letterFromWord = mWord.charAt(i);
            if(letterFromWord == letterEntered){
                Toast.makeText(this,"You have a match",Toast.LENGTH_SHORT).show();
                check = true;
                showLetterAtIndex(i,letterEntered);
                passCounter++;
            }
        }

            if (check == false){
                Toast.makeText(this,"Opps, Wrong Guess",Toast.LENGTH_SHORT).show();
                letterFailed(Character.toString(letterEntered));
            }

            if(passCounter == mWord.length()){
                reset();
            }

        }


    public void reset(){

    }

    public void showLetterAtIndex(int position, char ch){

        LinearLayout ll = (LinearLayout) findViewById(R.id.layoutIntroducedLetter);
        TextView tv = (TextView) ll.getChildAt(position);
        tv.setText(Character.toString(ch));
    }

    public void letterFailed(String str){
        failsCounter++;
        ImageView im = (ImageView) findViewById(R.id.imageView);
        TextView fails = (TextView) findViewById(R.id.failedLetter);
        String pre = fails.getText().toString();
        fails.setText(pre+str);
        if (failsCounter == 1) {
            im.setImageResource(R.mipmap.image1);
        }
        if (failsCounter == 2) {
            im.setImageResource(R.mipmap.image2);
        }
        if (failsCounter == 3) {
            im.setImageResource(R.mipmap.image3);
        }
        if (failsCounter == 4){
            im.setImageResource(R.mipmap.image4);
        }

        if (failsCounter == 5){
            im.setImageResource(R.mipmap.image5);
        }

        if (failsCounter == 6){
            im.setImageResource(R.mipmap.image6);
        }

    }
}
