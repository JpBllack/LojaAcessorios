package br.unitins.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Compra extends DefaultEntity {

    private double totalCompra;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private List<ItemCompra> itens;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCompra;

    private Pix pagamentoPix;
    
    private CartaoCredito pagamentoCartaoCredito;


    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public List<ItemCompra> getItens() {
        return itens;
    }

    public void setItens(List<ItemCompra> itens) {
        this.itens = itens;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

   public Pix getPagamentoPix() {
        return pagamentoPix;
    }

    public void setPagamentoPix(Pix pagamentoPix) {
        this.pagamentoPix = pagamentoPix;
    }

    public CartaoCredito getPagamentoCartaoCredito() {
        return pagamentoCartaoCredito;
    }

    public void setPagamentoCartaoCredito(CartaoCredito pagamentoCartaoCredito) {
        this.pagamentoCartaoCredito = pagamentoCartaoCredito;
    }


    public void setPagamento(Pix pagamento) {
        // Definir o pagamento por Pix
        this.pagamentoPix = pagamento;
        this.pagamentoCartaoCredito = null; // Limpar o pagamento por cartão de crédito
    
    }

    public void setPagamento(CartaoCredito pagamento) {
        // Definir o pagamento por cartão de crédito
        this.pagamentoCartaoCredito = pagamento;
        this.pagamentoPix = null; // Limpar o pagamento por Pix
    }

}
