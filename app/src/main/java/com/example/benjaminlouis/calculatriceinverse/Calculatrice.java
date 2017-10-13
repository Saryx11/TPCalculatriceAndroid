package com.example.benjaminlouis.calculatriceinverse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Stack;

public class Calculatrice extends AppCompatActivity {
    private Stack<Float> stack = new Stack<Float>();
    View.OnClickListener clicBouton = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView pile0 = (TextView) findViewById(R.id.pile0);
            TextView pile1 = (TextView) findViewById(R.id.pile1);
            TextView pile2 = (TextView) findViewById(R.id.pile2);
            TextView pile3 = (TextView) findViewById(R.id.pile3);
            TextView input = (TextView) findViewById(R.id.input);
            Button bouton = (Button) v;
            String texte = bouton.getText().toString();
            Float temp1;
            Float temp2;
            Float val;
            switch (texte) {
                case "Enter":
                    val = Float.parseFloat(input.getText().toString());
                    stack.push(val);
                    if (stack.size() >= 1)
                        pile0.setText(Float.toString(stack.elementAt(0)));
                    if (stack.size() >= 2)
                        pile1.setText(Float.toString(stack.elementAt(1)));
                    if (stack.size() >= 3)
                        pile2.setText(Float.toString(stack.elementAt(2)));
                    if (stack.size() >= 4)
                        pile3.setText(Float.toString(stack.elementAt(3)));
                    input.setText("");
                    break;
                case "pop":
                    if (!stack.empty())
                        stack.pop();
                    pile0.setText(Float.toString(stack.elementAt(0)));
                    pile1.setText(Float.toString(stack.elementAt(1)));
                    pile2.setText(Float.toString(stack.elementAt(2)));
                    pile3.setText(Float.toString(stack.elementAt(3)));
                    input.setText("");
                    break;
                case "swap":
                    if (stack.size() >= 2) {
                        temp1 = stack.pop();
                        temp2 = stack.pop();
                        stack.push(temp2);
                        stack.push(temp1);
                        pile0.setText(Float.toString(stack.elementAt(0)));
                        pile1.setText(Float.toString(stack.elementAt(1)));
                        pile2.setText(Float.toString(stack.elementAt(2)));
                        pile3.setText(Float.toString(stack.elementAt(3)));
                        input.setText("");
                    }
                    break;
                case "clear":
                    while (!stack.empty()) {
                        stack.pop();
                    }
                    pile0.setText(Float.toString(stack.elementAt(0)));
                    pile1.setText(Float.toString(stack.elementAt(1)));
                    pile2.setText(Float.toString(stack.elementAt(2)));
                    pile3.setText(Float.toString(stack.elementAt(3)));
                    input.setText("");
                    break;
                case "+":
                    if (!input.getText().toString().equals("")) {
                        val = Float.parseFloat(input.getText().toString());
                        stack.push(val);
                    }
                    if (stack.size() >= 2) {
                        temp1 = stack.pop();
                        temp2 = stack.pop();
                        stack.push(temp1 + temp2);
                    }
                    //mise à jour de l'affichage
                    if (stack.size() >= 1) {
                        pile0.setText(Float.toString(stack.elementAt(0)));
                    } else {
                        pile0.setText("");
                    }
                    if (stack.size() >= 2) {
                        pile1.setText(Float.toString(stack.elementAt(1)));
                    } else {
                        pile1.setText("");
                    }
                    if (stack.size() >= 3) {
                        pile2.setText(Float.toString(stack.elementAt(2)));
                    } else {
                        pile2.setText("");
                    }
                    if (stack.size() >= 4) {
                        pile3.setText(Float.toString(stack.elementAt(3)));
                    } else {
                        pile3.setText("");
                    }
                    input.setText("");
                    //fin de la mise à jour de l'affichage
                    break;
                case "-":
                    break;
                case "*":
                    break;
                case "/":
                    break;
                default:
                    input.setText(input.getText().toString() + ((Button) v).getText());
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatrice);
        GridLayout grid = (GridLayout) findViewById(R.id.grid);
        Log.d("grille", "grille trouvée");
        int fils = grid.getChildCount();
        View view;
        for (int i = 0; i < fils; i++) {
            view = grid.getChildAt(i);
            if (view instanceof Button) {
                view.setOnClickListener(clicBouton);
            }
        }


    }
}
