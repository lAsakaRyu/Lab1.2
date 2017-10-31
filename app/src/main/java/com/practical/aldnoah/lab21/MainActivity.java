package com.practical.aldnoah.lab21;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText numWeight, numHeight;
    private TextView resultMessage;
    private ImageView resultImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numWeight = (EditText) findViewById(R.id.numWeight);
        numHeight = (EditText) findViewById(R.id.numHeight);
        resultMessage = (TextView) findViewById(R.id.resultView);
        resultImage = (ImageView) findViewById(R.id.imageView);
    }
    public void displayMessage(View view){
        double bmi;
        String resultMessage;
        int resultImage;
        if(!numHeight.getText().toString().isEmpty()&&!numWeight.getText().toString().isEmpty()){
            bmi = calcBMI(Double.parseDouble(numWeight.getText().toString()),Double.parseDouble(numHeight.getText().toString())/100.00);
            if(bmi<18.5){
                resultMessage = getString(R.string.resultUWeight);
                resultImage = R.drawable.under;
            }
            else if(bmi<21){
                resultMessage = getString(R.string.resultNWeight);
                resultImage = R.drawable.normal;
            }
            else {
                resultMessage = getString(R.string.resultOWeight);
                resultImage = R.drawable.over;
            }
            this.resultMessage.setText(resultMessage);
            this.resultImage.setImageResource(resultImage);
        }
        else{
            resetButton(view);
            this.resultMessage.setText(R.string.errorMessage);
        }
    }
    public void resetButton(View view) {
        numWeight.setText("");
        numHeight.setText("");
        resultMessage.setText("");
        resultImage.setImageResource(R.drawable.empty);
    }
    private double calcBMI(double weight,double height){
        return weight/(height*height);
    }
}
