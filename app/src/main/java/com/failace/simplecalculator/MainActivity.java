package com.failace.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

// Implementando OnClickListener
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Criando objetos para cada botao da calculadora
    private Button bt_0, bt_1, bt_2,bt_3,bt_4,bt_5,bt_6,bt_7,bt_8,bt_9, bt_clear, bt_div,
    bt_multi,bt_min, bt_sum, bt_equal, bt_point;

    // Criando objetos para cada TextView da calculadora
    private TextView text_expression, text_result;

    // Criando objeto para ImageView do backspace da calculadora
    private ImageView bt_backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitComponents();
        getSupportActionBar().hide();

        // Pegando o contexto do Listener
        bt_0.setOnClickListener(this);
        bt_1.setOnClickListener(this);
        bt_2.setOnClickListener(this);
        bt_3.setOnClickListener(this);
        bt_4.setOnClickListener(this);
        bt_5.setOnClickListener(this);
        bt_6.setOnClickListener(this);
        bt_7.setOnClickListener(this);
        bt_8.setOnClickListener(this);
        bt_9.setOnClickListener(this);
        bt_point.setOnClickListener(this);
        bt_sum.setOnClickListener(this);
        bt_min.setOnClickListener(this);
        bt_div.setOnClickListener(this);
        bt_multi.setOnClickListener(this);

        // Metodo para limpar dados ao clicar no botao "C"
        bt_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_expression.setText("");
                text_result.setText("");
            }
        });

        // Metodo para limpar numeros ao clicar no backspace
        bt_backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView expression = findViewById(R.id.text_expression);
                String string = expression.getText().toString();

                if(!string.isEmpty()){
                    byte zero = 0;
                    int one = string.length()-1;
                    String textExpression = string.substring(zero, one);
                    expression.setText(textExpression);
                }
                text_result.setText("");
            }
        });

        // Metodo para calcular a expressao ao clicar no botao "="
        bt_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{

                Expression expression = new ExpressionBuilder(text_expression.getText().toString()).build();
                double result = expression.evaluate();
                long longResult = (long) result;

                if(result == (double)longResult){
                    text_result.setText((CharSequence) String.valueOf(longResult));
                } else {
                    text_result.setText((CharSequence) String.valueOf(result));
                }


            } catch(Exception e){

                }
            }
        });

    }

    // Metodo para instanciar os botoes pelo ID
    private void InitComponents(){
        bt_0 = findViewById(R.id.bt_0);
        bt_1 = findViewById(R.id.bt_1);
        bt_2 = findViewById(R.id.bt_2);
        bt_3 = findViewById(R.id.bt_3);
        bt_4 = findViewById(R.id.bt_4);
        bt_5 = findViewById(R.id.bt_5);
        bt_6 = findViewById(R.id.bt_6);
        bt_7 = findViewById(R.id.bt_7);
        bt_8 = findViewById(R.id.bt_8);
        bt_9 = findViewById(R.id.bt_9);
        bt_clear = findViewById(R.id.bt_clear);
        bt_div = findViewById(R.id.bt_div);
        bt_min = findViewById(R.id.bt_min);
        bt_multi = findViewById(R.id.bt_multi);
        bt_sum = findViewById(R.id.bt_sum);
        bt_equal = findViewById(R.id.bt_equal);
        bt_point = findViewById(R.id.bt_point);
        text_expression = findViewById(R.id.text_expression);
        text_result = findViewById(R.id.text_result);
        bt_backspace = findViewById(R.id.bt_backspace);
    }

    // Metodo para adicionar as expressoes na TextView
    public void AddExpression(String string, Boolean clearData){
        if(text_result.getText().equals("")){
            text_expression.setText(" ");
        }
        if(clearData){
            text_result.setText(" ");
            text_expression.append(string);
        }else {
            text_expression.append(text_result.getText());
            text_expression.append(string);
            text_result.setText(" ");
        }

    }

    // Definindo o valor/expressao de cada botao
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_0:
                AddExpression("0", true);
                break;
            case R.id.bt_1:
                AddExpression("1", true);
                break;
            case R.id.bt_2:
                AddExpression("2", true);
                break;
            case R.id.bt_3:
                AddExpression("3", true);
                break;
            case R.id.bt_4:
                AddExpression("4", true);
                break;
            case R.id.bt_5:
                AddExpression("5", true);
                break;
            case R.id.bt_6:
                AddExpression("6", true);
                break;
            case R.id.bt_7:
                AddExpression("7", true);
                break;
            case R.id.bt_8:
                AddExpression("8", true);
                break;
            case R.id.bt_9:
                AddExpression("9", true);
                break;
            case R.id.bt_point:
                AddExpression(".", true);
                break;
            case R.id.bt_sum:
                AddExpression("+", false);
                break;
            case R.id.bt_min:
                AddExpression("-", false);
                break;
            case R.id.bt_div:
                AddExpression("/", false);
                break;
            case R.id.bt_multi:
                AddExpression("*", false);
                break;
        }
    }
}