package br.ufmg.coltec.tp.recuperacao1otrimestre;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by a2015951487 on 19/06/18.
 */

public class ProdutoDAO{
    private ArrayList<Produto> produtos;
    // singleton para lidar com única instância do DAO
    private static ProdutoDAO instance;
    Context context;
    /**
     * Construtor privado (NÃO UTILIZAR)
     */

    private ProdutoDAO(Context cont) {
        context = cont;
        produtos = new ArrayList<>();
        carregaProdutos();
    }




    public static ProdutoDAO getInstance(Context cont) {
        if(instance == null)
            instance = new ProdutoDAO(cont);

        return instance;
    }
    private void carregaProdutos() {
        Database DB = new Database(context);
        produtos = DB.obterProdutos();
    /*Aqui as informações serão recuperadas do banco de dados*/
//        produtos.add(new Produto("Sabão", "Limpeza", 15.54));
//        produtos.add(new Produto("Escova de dentes", "Higiene", 3.7));
//        produtos.add(new Produto("Escova de dentes", "Higiene", 3.7));

    }


    /**
     * Adiciona um novo produto na lista
     *
     * @param novoProduto produto que será adicionado na lista
     */
    public void adicionarProduto(Produto novoProduto) {

        instance.produtos.add(novoProduto);
    }


    /**
     * Remover um produto na lista
     *
     *  produto que será removido na lista
     */

    public void removerProduto(int position){
        instance.produtos.remove(position);
    }


    /**
     * Recupera lista completa dos produtos
     * @return ArrayList com todos os produtos cadastrados no DAO
     */
    public ArrayList<Produto> getProdutos() {
        return instance.produtos;
    }



    //verifica se não existe nenhum produto com o mesmo nome
    public boolean existeNome(String nome) {
        for (int i = 0; i < produtos.size(); i++) {
            if (nome.toLowerCase().equals(produtos.get(i).getNome().toLowerCase())){
                return true;
            }
        }
        return false;
    }

    /**
     * @param busca expressão buscada oelo usuário
     * @return ArrayList apenas cuja categoria ou nome correspondem ao buscado pelo usuário
     */
    public ArrayList<Produto> filtrarProdutos(String busca) {
        ArrayList<Produto> filtrados = new ArrayList<>();

        for(int i=0;i<produtos.size();i++){
            if(produtos.get(i).getNome().toLowerCase().contains(busca.toLowerCase()) || produtos.get(i).getCategoria().toLowerCase().contains(busca.toLowerCase())){
                filtrados.add(produtos.get(i));
            }
        }
        return filtrados;
    }




}
