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

    /*View.OnClickListener clicChiffre=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            input.setText(input.getText().toString() + ((Button) v).getText());
        }
    };*/

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
                    if (stack.size() >= 1) {
                        pile0.setText(Float.toString(stack.elementAt(stack.size()-1)));
                    } else {
                        pile0.setText("");
                    }
                    if (stack.size() >= 2) {
                        pile1.setText(Float.toString(stack.elementAt(stack.size()-2)));
                    } else {
                        pile1.setText("");
                    }
                    if (stack.size() >= 3) {
                        pile2.setText(Float.toString(stack.elementAt(stack.size()-3)));
                    } else {
                        pile2.setText("");
                    }
                    if (stack.size() >= 4) {
                        pile3.setText(Float.toString(stack.elementAt(stack.size()-4)));
                    } else {
                        pile3.setText("");
                    }
                    input.setText("");
                    break;
                case "Pop":
                    if (!stack.empty())
                        stack.pop();

                    if (stack.size() >= 1) {
                        pile0.setText(Float.toString(stack.elementAt(stack.size()-1)));
                    } else {
                        pile0.setText("");
                    }
                    if (stack.size() >= 2) {
                        pile1.setText(Float.toString(stack.elementAt(stack.size()-2)));
                    } else {
                        pile1.setText("");
                    }
                    if (stack.size() >= 3) {
                        pile2.setText(Float.toString(stack.elementAt(stack.size()-3)));
                    } else {
                        pile2.setText("");
                    }
                    if (stack.size() >= 4) {
                        pile3.setText(Float.toString(stack.elementAt(stack.size()-4)));
                    } else {
                        pile3.setText("");
                    }
                    input.setText("");
                    break;
                case "Swap":
                    if (stack.size() >= 2) {
                        temp1 = stack.pop();
                        temp2 = stack.pop();
                        stack.push(temp1);
                        stack.push(temp2);
                        if (stack.size() >= 1) {
                            pile0.setText(Float.toString(stack.elementAt(stack.size()-1)));
                        } else {
                            pile0.setText("");
                        }
                        if (stack.size() >= 2) {
                            pile1.setText(Float.toString(stack.elementAt(stack.size()-2)));
                        } else {
                            pile1.setText("");
                        }
                        if (stack.size() >= 3) {
                            pile2.setText(Float.toString(stack.elementAt(stack.size()-3)));
                        } else {
                            pile2.setText("");
                        }
                        if (stack.size() >= 4) {
                            pile3.setText(Float.toString(stack.elementAt(stack.size()-4)));
                        } else {
                            pile3.setText("");
                        }
                        input.setText("");
                    }
                    break;
                case "Clear":
                    while (!stack.empty()) {
                        stack.pop();
                    }
                    if (stack.size() >= 1) {
                        pile0.setText(Float.toString(stack.elementAt(stack.size()-1)));
                    } else {
                        pile0.setText("");
                    }
                    if (stack.size() >= 2) {
                        pile1.setText(Float.toString(stack.elementAt(stack.size()-2)));
                    } else {
                        pile1.setText("");
                    }
                    if (stack.size() >= 3) {
                        pile2.setText(Float.toString(stack.elementAt(stack.size()-3)));
                    } else {
                        pile2.setText("");
                    }
                    if (stack.size() >= 4) {
                        pile3.setText(Float.toString(stack.elementAt(stack.size()-4)));
                    } else {
                        pile3.setText("");
                    }
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
                        pile0.setText(Float.toString(stack.elementAt(stack.size()-1)));
                    } else {
                        pile0.setText("");
                    }
                    if (stack.size() >= 2) {
                        pile1.setText(Float.toString(stack.elementAt(stack.size()-2)));
                    } else {
                        pile1.setText("");
                    }
                    if (stack.size() >= 3) {
                        pile2.setText(Float.toString(stack.elementAt(stack.size()-3)));
                    } else {
                        pile2.setText("");
                    }
                    if (stack.size() >= 4) {
                        pile3.setText(Float.toString(stack.elementAt(stack.size()-4)));
                    } else {
                        pile3.setText("");
                    }
                    input.setText("");
                    //fin de la mise à jour de l'affichage
                    break;
                case "-":
                    if (!input.getText().toString().equals("")) {
                        val = Float.parseFloat(input.getText().toString());
                        stack.push(val);
                    }
                    if (stack.size() >= 2) {
                        temp1 = stack.pop();
                        temp2 = stack.pop();
                        stack.push(temp1 - temp2);
                    }
                    if (stack.size() >= 1) {
                        pile0.setText(Float.toString(stack.elementAt(stack.size()-1)));
                    } else {
                        pile0.setText("");
                    }
                    if (stack.size() >= 2) {
                        pile1.setText(Float.toString(stack.elementAt(stack.size()-2)));
                    } else {
                        pile1.setText("");
                    }
                    if (stack.size() >= 3) {
                        pile2.setText(Float.toString(stack.elementAt(stack.size()-3)));
                    } else {
                        pile2.setText("");
                    }
                    if (stack.size() >= 4) {
                        pile3.setText(Float.toString(stack.elementAt(stack.size()-4)));
                    } else {
                        pile3.setText("");
                    }
                    input.setText("");
                    break;
                case "*":
                    if (!input.getText().toString().equals("")) {
                        val = Float.parseFloat(input.getText().toString());
                        stack.push(val);
                    }
                    if (stack.size() >= 2) {
                        temp1 = stack.pop();
                        temp2 = stack.pop();
                        stack.push(temp1 * temp2);
                    }
                    if (stack.size() >= 1) {
                        pile0.setText(Float.toString(stack.elementAt(stack.size()-1)));
                    } else {
                        pile0.setText("");
                    }
                    if (stack.size() >= 2) {
                        pile1.setText(Float.toString(stack.elementAt(stack.size()-2)));
                    } else {
                        pile1.setText("");
                    }
                    if (stack.size() >= 3) {
                        pile2.setText(Float.toString(stack.elementAt(stack.size()-3)));
                    } else {
                        pile2.setText("");
                    }
                    if (stack.size() >= 4) {
                        pile3.setText(Float.toString(stack.elementAt(stack.size()-4)));
                    } else {
                        pile3.setText("");
                    }
                    input.setText("");
                    break;
                case "/":
                    if (!input.getText().toString().equals("")) {
                        val = Float.parseFloat(input.getText().toString());
                        stack.push(val);
                    }
                    if (stack.size() >= 2) {
                        temp1 = stack.pop();
                        temp2 = stack.pop();
                        stack.push(temp1 / temp2);
                    }
                    if (stack.size() >= 1) {
                        pile0.setText(Float.toString(stack.elementAt(stack.size()-1)));
                    } else {
                        pile0.setText("");
                    }
                    if (stack.size() >= 2) {
                        pile1.setText(Float.toString(stack.elementAt(stack.size()-2)));
                    } else {
                        pile1.setText("");
                    }
                    if (stack.size() >= 3) {
                        pile2.setText(Float.toString(stack.elementAt(stack.size()-3)));
                    } else {
                        pile2.setText("");
                    }
                    if (stack.size() >= 4) {
                        pile3.setText(Float.toString(stack.elementAt(stack.size()-4)));
                    } else {
                        pile3.setText("");
                    }
                    input.setText("");
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
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        ((TextView)findViewById(R.id.pile0)).setText(savedInstanceState.getString("pile0"));
        ((TextView)findViewById(R.id.pile1)).setText(savedInstanceState.getString("pile1"));
        ((TextView)findViewById(R.id.pile2)).setText(savedInstanceState.getString("pile2"));
        ((TextView)findViewById(R.id.pile3)).setText(savedInstanceState.getString("pile3"));
        float[] floats=savedInstanceState.getFloatArray("floats");
        for(float f:floats){
            stack.push(f);
        }

    };
    protected void onSaveInstanceState(Bundle outState){
        outState.putString("pile0",((TextView)findViewById(R.id.pile0)).getText().toString());
        outState.putString("pile1",((TextView)findViewById(R.id.pile1)).getText().toString());
        outState.putString("pile2",((TextView)findViewById(R.id.pile2)).getText().toString());
        outState.putString("pile3",((TextView)findViewById(R.id.pile3)).getText().toString());
        int i=0;
        float[] floats=new float[stack.size()];
        for(Float f:stack){
            floats[i]=f;
            i++;
        }
        outState.putFloatArray("floats",floats);

    };
}
