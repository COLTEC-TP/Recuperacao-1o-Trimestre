package br.ufmg.coltec.tp.recuperacao1otrimestre;


public class Produto {
    private String nome;
    private String categoria;
    private double preco;
    /* Eu decidi que será obrigatório na criação do produto
     que o usuário defina todas as informações.
     Sendo assim, não haverá edição posterior e portanto
     os sets não são necessários.
     */

    public Produto(String nome, String categoria, double preco ){
        this.nome=nome;
        this.categoria=categoria;
        this.preco=preco;
    }
    public Produto(){
        nome=null;
        categoria=null;
        preco=0;
    }


    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria(){
        return this.categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPreco(){ return this.preco;}
    public void setPreco(Float preco) {
        this.preco = preco;
    }



}
