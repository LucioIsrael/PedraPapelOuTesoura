package br.com.treino.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionaPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionaPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionaTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada (String escolhaUsuario) {

        ImageView imagemResultado = findViewById(R.id.imagemResultado);
        TextView textoResultado = findViewById(R.id.text_resultado);

        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numero = new Random().nextInt(3);
        String escolhaApp = opcoes[numero];

        switch (escolhaApp) {
            case "pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if(
          (escolhaApp == "tesoura" && escolhaUsuario == "papel") ||
          (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
          (escolhaApp == "pedra" && escolhaUsuario == "tesoura")
        ) {

            textoResultado.setText("Você perdeu :(");

        }else if(
            (escolhaUsuario == "tesoura" && escolhaApp == "papel")||
            (escolhaUsuario == "papel" && escolhaApp == "pedra")||
            (escolhaUsuario == "pedra" && escolhaApp == "tesoura")
        ){

            textoResultado.setText("Você ganhou :)");

        } else {

            textoResultado.setText("Temos um empate");

        }

    }
}