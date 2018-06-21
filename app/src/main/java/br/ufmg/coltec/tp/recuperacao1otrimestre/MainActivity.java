package br.ufmg.coltec.tp.recuperacao1otrimestre;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
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




    }

    @Override
    protected void onResume() {
        super.onResume();
        MainActivity.this.adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                // inicia a activity Cadastro_Produto quando o usuário clica no botão correspondente
                Intent intent = new Intent(MainActivity.this, Cadastro_Produto.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) { //durante a digitação do usuário filtra e seta a ListView com o resultado da busca
                ArrayList<Produto> listaFiltrada = ProdutoDAO.getInstance().filtrarProdutos(s);
                mostraBusca(listaFiltrada);
                return false;
            }


        });
        return super.onCreateOptionsMenu(menu);
    }

    private void mostraBusca(ArrayList<Produto> produtos) {
        ListView auxList = findViewById(R.id.lista_produtos);
        auxList.setAdapter(new MainActivityAdapter(this, produtos));
    }
}