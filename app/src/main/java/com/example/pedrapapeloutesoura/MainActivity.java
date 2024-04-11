package com.example.pedrapapeloutesoura;

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
//sempre utilizar o metodo View quando usar o metodo onclick em imagens
    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
    }
    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario){

        //cruiando um metodo para poder alterar a imagem de escolha do app
        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textoResultado);
        //variavel que randomiza 3 numeros aleatorios
        int numero = new Random().nextInt(3);
        //um array com as opcoes do jogo
        String[] opcoes ={"pedra","papel","tesoura"};
        //uma string que os itens formada pelo array a cima e randomizada pela variavel numero
        String escolhaoApp = opcoes[numero];
        //nesse switch caso o usuario clique em uma opção o app randomiza uma imagem e troca a escolha do app
        switch (escolhaoApp){
            case "pedra" :
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel" :
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                (escolhaoApp == "tesoura" && escolhaUsuario == "papel") ||
                (escolhaoApp == "papel" && escolhaUsuario == "pedra") ||
                (escolhaoApp == "pedra" && escolhaUsuario == "tesoura")
        ){
        //app Ganhou
            textoResultado.setText("Você Perdeu");



        }else if(
                (escolhaUsuario == "tesoura" && escolhaoApp == "papel") ||
                (escolhaUsuario == "papel" && escolhaoApp == "pedra") ||
                (escolhaUsuario == "pedra" && escolhaoApp == "tesoura")
        ){
        //Usuario Ganhou
            textoResultado.setText("Você Ganhou");

        }else{
        //empate
            textoResultado.setText("Empate");
        };

    }
}
