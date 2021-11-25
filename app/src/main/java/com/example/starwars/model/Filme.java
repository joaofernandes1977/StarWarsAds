package com.example.starwars.model;

public class Filme {
    String nome, ano, genero, tempoFilme, historia, lancamento, diretor, bilheteria, produtora;
    private  int imagem;

    public Filme(String nome, String ano, String genero, String tempoFilme, String historia, String lancamento, String diretor, String bilheteria, String produtora, int imagem) {
        this.nome = nome;
        this.ano = ano;
        this.genero = genero;
        this.tempoFilme = tempoFilme;
        this.historia = historia;
        this.lancamento = lancamento;
        this.diretor = diretor;
        this.bilheteria = bilheteria;
        this.produtora = produtora;
        this.imagem = imagem;
    }

    public Filme() {
    }
    public Filme(String nome, String ano, int imagem){

    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTempoFilme() {
        return tempoFilme;
    }

    public void setTempoFilme(String tempoFilme) {
        this.tempoFilme = tempoFilme;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getLancamento() {
        return lancamento;
    }

    public void setLancamento(String lancamento) {
        this.lancamento = lancamento;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }



    public String getBilheteria() {
        return bilheteria;
    }

    public void setBilheteria(String bilheteria) {
        this.bilheteria = bilheteria;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }




    public Filme(int imagem) {
        this.imagem = imagem;
    }
}
