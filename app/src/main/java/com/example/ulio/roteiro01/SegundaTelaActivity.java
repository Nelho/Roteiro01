package com.example.ulio.roteiro01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SegundaTelaActivity extends AppCompatActivity {

    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);
        mText = (TextView)findViewById(R.id.textView);
        Bundle bundle = getIntent().getExtras();
        String texto = bundle.getString("usuario");
        mText.setText("Olá "+texto+", seja bem-vindo");
    }
}
