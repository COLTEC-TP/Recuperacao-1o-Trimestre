package br.ufmg.coltec.tp.recuperacao1otrimestre;

import java.util.ArrayList;

/**
 * Created by a2015951487 on 19/06/18.
 */

public class ProdutoDAO {
    private ArrayList<Produto> produtos;

    // singleton para lidar com única instância do DAO
    private static ProdutoDAO instance;

    /**
     * Construtor privado (NÃO UTILIZAR)
     */
    private ProdutoDAO() {
        produtos = new ArrayList<>();
        carregaProdutos();
    }




    public static ProdutoDAO getInstance() {

        if(instance == null)
            instance = new ProdutoDAO();

        return instance;
    }
    private void carregaProdutos() {
    /*Aqui as informações serão recuperadas do banco de dados*/
        produtos.add(new Produto("Sabão", "Limpeza", 15.54));
        produtos.add(new Produto("Escova de dentes", "Higiene", 3.7));


    }

    /**
     * Adiciona um novo imóvel na lista
     *
     * @param novoProduto imóvel que será adicionado na lista
     */
    public void adicionarImovel(Produto novoProduto) {
        instance.produtos.add(novoProduto);
    }

    /**
     * Recupera lista completa dos imóveis
     * @return ArrayList com todos os imóveis cadastrados no DAO
     */
    public ArrayList<Produto> getImoveis() {
        return instance.produtos;
    }



}
