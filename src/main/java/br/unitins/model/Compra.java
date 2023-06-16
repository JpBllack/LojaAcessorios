package br.unitins.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Compra extends DefaultEntity {

    private double totalCompra;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private Set<ItemCompra> itensCompra;    

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCompra;

   
    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }
    public Set<ItemCompra> getItens() {
        return itensCompra;
    }
    
    public void setItens(Set<ItemCompra> itensCompra) {
        this.itensCompra = itensCompra;
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

}
