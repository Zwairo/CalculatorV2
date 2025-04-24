package com.example.calculatorv2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calculatorv2.databinding.ActivityMainBinding;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    TextView result;
    Button buton1,buton2,buton3,buton4,buton5,buton6,buton7,buton8,buton9,buton0,buton10,buton11,buton12,buton13,buton14,buton15,buton16;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        result=binding.sonuc;

        int[] buttonIDs = {
                R.id.buton0, R.id.buton1, R.id.buton2, R.id.buton3,
                R.id.buton4, R.id.buton5, R.id.buton6, R.id.buton7,
                R.id.buton8, R.id.buton9,
                R.id.buton10, R.id.buton11, R.id.buton12, R.id.buton13,R.id.buton14,R.id.buton16,R.id.buton0

        };

        for (int id : buttonIDs) {
            Button btn = findViewById(id);
            btn.setOnClickListener(v -> {
                String current = result.getText().toString();
                String clicked = btn.getText().toString();

                if (clicked.equals("=")) {
                    try {
                        binding.islemgecmisi.setText(current);
                        Expression expression = new ExpressionBuilder(current).build();
                        double result = expression.evaluate();
                        binding.sonuc.setText(String.valueOf(result));
                    } catch (Exception e) {
                        result.setText("Hata");
                    }
                } else if (clicked.equals("C")) {
                    result.setText("".toString());
                } else {
                    result.setText(current + clicked);
                }
            });
        }



    }
}