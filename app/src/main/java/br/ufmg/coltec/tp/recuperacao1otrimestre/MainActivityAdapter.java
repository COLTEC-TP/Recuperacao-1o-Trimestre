package br.ufmg.coltec.tp.recuperacao1otrimestre;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivityAdapter extends BaseAdapter {

    private ArrayList<Produto> produtos;
    private Context context;

    public MainActivityAdapter(Context context) {
        this.context = context;
        produtos = new ArrayList<>();

        //... carrega dados da lista
        produtos.add(new Produto("Sabão", "Limpeza", 15.54));
        produtos.add(new Produto("Escova de dentes", "Higiene", 3.7));

    }

    @Override
    public int getCount() {
        return this.produtos.size();
    };

    @Override
    public Object getItem(int i) {
        return this.produtos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Produto prod = this.produtos.get(i);
        View newView  = LayoutInflater.from(this.context).inflate(R.layout.activity_main_adapter, viewGroup, false);

        // cria o componente que será carregado na lista
        TextView nome = newView.findViewById(R.id.nomeProduto);
        TextView categoria = newView.findViewById(R.id.categoriaProduto);
        TextView valor = newView.findViewById(R.id.valorProduto);

        nome.setText(prod.getNome());
        categoria.setText(prod.getCategoria());
        valor.setText(String.format("%s%s", "R$", String.valueOf(prod.getPreco())));

        return newView;
    }
}