package br.ufmg.coltec.tp.recuperacao1otrimestre;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends Activity {

    MainActivityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView ProdutosListView = findViewById(R.id.lista_produtos);
        adapter = new MainActivityAdapter(this);
        ProdutosListView.setAdapter(adapter);



//Parte lógica do acionamento do botão de "adcionar"
//da lista principal

        Button adcionar_produto = findViewById(R.id.Btn_adcionar);

        adcionar_produto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Cadastro_Produto.class );
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        MainActivity.this.adapter.notifyDataSetChanged();
    }
}
