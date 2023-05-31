package br.unitins.form;


import jakarta.ws.rs.FormParam;




public class ImageForm {

    @FormParam("nomeImagem")
    private String nomeImagem;

    @FormParam("imagem")
    
    private byte[] imagem;

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    
    
}
