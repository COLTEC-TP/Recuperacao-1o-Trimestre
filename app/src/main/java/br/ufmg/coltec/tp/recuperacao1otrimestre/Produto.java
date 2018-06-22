package br.ufmg.coltec.tp.recuperacao1otrimestre;


public class Produto {
    private String nome;
    private String categoria;
    private double preco;


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
