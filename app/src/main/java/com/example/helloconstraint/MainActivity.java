package com.example.helloconstraint;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button toastBtn = findViewById(R.id.button);
        Button zeroBtn = findViewById(R.id.button2);
        Button countBtn = findViewById(R.id.button3);
        TextView tekst = findViewById(R.id.textView);

        int i=0;
        zeroBtn.setBackgroundColor(Color.GRAY);

        toastBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(MainActivity.this, "Test", Toast.LENGTH_SHORT).show();
            }
        });

        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tekst.setText("0");
                v.setBackgroundColor(Color.GRAY);
            }
        });

        countBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int n = Integer.parseInt(tekst.getText().toString());
                if(n==0)
                    zeroBtn.setBackgroundColor(Color.RED);
                if(n%2==0)
                    v.setBackgroundColor(Color.GREEN);
                else
                    v.setBackgroundColor(Color.BLUE);
                tekst.setText(""+(n+1));
            }
        });
    }
}