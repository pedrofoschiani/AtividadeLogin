package com.example.atividadelogin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome;
    private EditText editTextSenha;
    private Button btnConectar;
    private Button btnLimpar;
    private ImageView imageView;

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

        editTextNome = findViewById(R.id.editTextText);
        editTextSenha = findViewById(R.id.editTextTextPassword);
        btnConectar = findViewById(R.id.button);
        btnLimpar = findViewById(R.id.button2);
        imageView = findViewById(R.id.imageView);

        btnConectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString().trim();
                String senha = editTextSenha.getText().toString().trim();

                if (nome.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                } else {
                    if (nome.equals("admin") && senha.equals("1234")) {
                        Toast.makeText(MainActivity.this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Usuário ou senha incorretos.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNome.setText("");
                editTextSenha.setText("");
                Toast.makeText(MainActivity.this, "Campos limpos.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
