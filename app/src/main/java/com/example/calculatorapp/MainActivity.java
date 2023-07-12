package com.example.calculatorapp;
/*
* package com.example.calculatorapp;: This line declares the package name for the Java file. In this case,
*  the file belongs to the com.example.calculatorapp package.
* The package name is used to organize classes and avoid naming conflicts.
* */

import androidx.appcompat.app.AppCompatActivity;
/*
*import androidx.appcompat.app.AppCompatActivity;: This line imports the AppCompatActivity class from the androidx.appcompat.app package.
*  The AppCompatActivity is a base class for activities in Android that provides support for the latest features on older versions of Android.
* */

import android.os.Bundle;
/*import android.os.Bundle;: This line imports the Bundle class from the android.os package.
The Bundle class is used to pass data between activities or fragments in Android.
* */
import android.view.View;
/*
* import android.view.View;: This line imports the View class from the android.view package.
*  The View class represents the basic building block for user interface components in Android.*/

import android.widget.TextView;
/*
*import android.widget.TextView;: This line imports the TextView class from the android.widget package.
*  The TextView class is a widget that displays text on the screen.
*/

import com.google.android.material.button.MaterialButton;
/*
import com.google.android.material.button.MaterialButton;: This line imports the MaterialButton class from the com.google.android.material.button package.
The MaterialButton class is a button implementation following the Material Design guidelines.
*/
import org.mozilla.javascript.Context;
/*
import org.mozilla.javascript.Context;: This line imports the Context class from the org.mozilla.javascript package.
This package provides a JavaScript engine that can be used to execute JavaScript code within an Android application.
*/


import org.mozilla.javascript.Scriptable;
/*
import org.mozilla.javascript.Scriptable;: This line imports the Scriptable class from the org.mozilla.javascript package.
 The Scriptable class represents a JavaScript object that can be used to interact with the JavaScript engine.
*/


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
 TextView result, solution;
 MaterialButton button_1, button_2, button_3;
 MaterialButton button_equalto, button_add, button_subtract, button_division, button_multiply;
 MaterialButton button_4, button_5, button_6;
 MaterialButton button_7, button_8, button_9;
 MaterialButton button_0, button_point, button_allClear;
 MaterialButton button_openbracket, button_closebracket, button_clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        solution = findViewById(R.id.solution)  ;
        assignId(button_1,R.id.button_1);
        assignId( button_2,R.id.button_2);
        assignId(button_3,R.id.button_3);
        assignId(button_equalto,R.id.button_equalto);
        assignId(button_add,R.id.button_add);
        assignId(button_subtract,R.id.button_subtract);
        assignId(button_division,R.id.button_division);
        assignId(button_multiply,R.id.button_multiply);
        assignId(button_4,R.id.button_4);
        assignId(button_5,R.id.button_5);
        assignId(button_6,R.id.button_6);
        assignId(button_7,R.id.button_7);
        assignId(button_8,R.id.button_8);
        assignId(button_9,R.id.button_9);
        assignId(button_0,R.id.button_0);
        assignId(button_point,R.id.button_point);
        assignId(button_allClear,R.id.button_allClear);
        assignId(button_openbracket,R.id.button_openbracket);
        assignId(button_closebracket,R.id.button_closebracket);
        assignId(button_clear,R.id.button_clear);

    }

    void assignId(MaterialButton btn ,int id){
btn = findViewById(id);
btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        MaterialButton button =(MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = solution.getText().toString();

    if(buttonText.equals("AC")){
        solution.setText("");
        result.setText("0");
        return;
    }

if(buttonText.equals("=")){
solution.setText(result.getText());
return;
}
if(buttonText.equals("C")){
    dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
} else{
    dataToCalculate = dataToCalculate+buttonText;

}
solution.setText(dataToCalculate);
String finalResult = getResult(dataToCalculate);

if (!finalResult.equals ("Err")){
result.setText(finalResult);
}
}

String getResult(String data){
try {
    Context context = Context.enter();
    context.setOptimizationLevel(-1);
    Scriptable scriptable = context.initStandardObjects();
  String finalResult =  context.evaluateString(scriptable,data, "Javascript",1,null).toString();


  return finalResult;

} catch (Exception e){
    return "Err";
}

}

}