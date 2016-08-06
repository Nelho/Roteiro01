package com.example.ulio.roteiro01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    private EditText mNome;
    private EditText mSobrenome;
    private EditText mUsuario;
    private EditText mSenha;
    private EditText mConfirmaSenha;
    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        mNome = (EditText) findViewById(R.id.nome);
        mSobrenome = (EditText) findViewById(R.id.sobrenome);
        mUsuario = (EditText) findViewById(R.id.usuario);
        mSenha = (EditText) findViewById(R.id.senha);
        mConfirmaSenha = (EditText) findViewById(R.id.confirmaSenha);
        mBtn = (Button) findViewById(R.id.button);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrar();
            }
        });
    }

    private void cadastrar() {
        String nome = mNome.getText().toString();
        String sobrenome = mSobrenome.getText().toString();
        String usuario = mUsuario.getText().toString();
        String senha = mSenha.getText().toString();
        String confirmaSenha = mConfirmaSenha.toString();

        View focus = null;
        if (TextUtils.isEmpty(nome)) {
            this.mNome.setError("Campo nome vazio");
            focus = this.mNome;
            focus.requestFocus();
        }
        if (TextUtils.isEmpty(sobrenome)) {
            this.mSobrenome.setError("Campo sobrenome vazio");
            focus = this.mSobrenome;
            focus.requestFocus();
        }
        if (TextUtils.isEmpty(usuario)) {
            this.mUsuario.setError("Campo usuario vazio");
            focus = this.mUsuario;
            focus.requestFocus();
        }
        if (TextUtils.isEmpty(senha)) {
            this.mSenha.setError("Campo senha vazio");
            focus = this.mSenha;
            focus.requestFocus();

        }
        if (TextUtils.isEmpty(confirmaSenha)) {
            this.mConfirmaSenha.setError("Campo confirma senha vazio");
            focus = this.mConfirmaSenha;
            focus.requestFocus();

        }else{
            if (confirmaSenha.equalsIgnoreCase(senha)){
                Intent intent = new Intent(this, SegundaTelaActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("usuario", nome);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }else{
                this.mConfirmaSenha.setError("Senhas não conferem");
                focus = this.mConfirmaSenha;
                focus.requestFocus();
            }
        }

    }
}

