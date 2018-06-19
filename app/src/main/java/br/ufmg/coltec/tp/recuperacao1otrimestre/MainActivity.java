package br.ufmg.coltec.tp.recuperacao1otrimestre;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView ProdutosListView = findViewById(R.id.lista_produtos);
        ProdutosListView.setAdapter(new MainActivityAdapter(this));


    }
}
