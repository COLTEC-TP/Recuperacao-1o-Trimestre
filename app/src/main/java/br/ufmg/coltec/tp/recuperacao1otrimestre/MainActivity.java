package br.ufmg.coltec.tp.recuperacao1otrimestre;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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

        //Criador de Dialog
        final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);

        ProdutosListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {



            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {


                //Toast.makeText(getBaseContext(), p, Toast.LENGTH_SHORT).show();

                // Define Parâmetros para o Dialog
                alertBuilder.setTitle("Excluir Produto?");


                // Define o que acontece quando o usuário seleciona a opção positiva
                alertBuilder.setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ProdutoDAO dao = ProdutoDAO.getInstance(getApplicationContext());
                        Database DB = new Database(getApplicationContext());

                        DB.removeProduto(dao.getProdutos().get(position));//remove da DB o produto especificado
                        dao.removerProduto(position);//remove da ListView o produto especificado
                        MainActivity.this.adapter.notifyDataSetChanged();
                    }
                });

                // Define o que acontece quando o usuário seleciona a opção negativa
                alertBuilder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });

                // cria o dialog e o exibe na tela
                AlertDialog dialog = alertBuilder.create();
                dialog.show();

                return true;
            }
        });



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
                ArrayList<Produto> listaFiltrada = ProdutoDAO.getInstance(getApplicationContext()).filtrarProdutos(s);
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


