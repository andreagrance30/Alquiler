/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrea Salinas
 */
@Entity
@Table(name = "notas_debitos_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotasDebitosDet.findAll", query = "SELECT n FROM NotasDebitosDet n"),
    @NamedQuery(name = "NotasDebitosDet.findByCantidad", query = "SELECT n FROM NotasDebitosDet n WHERE n.cantidad = :cantidad"),
    @NamedQuery(name = "NotasDebitosDet.findByPorcIva", query = "SELECT n FROM NotasDebitosDet n WHERE n.porcIva = :porcIva"),
    @NamedQuery(name = "NotasDebitosDet.findByPrecioUni", query = "SELECT n FROM NotasDebitosDet n WHERE n.precioUni = :precioUni"),
    @NamedQuery(name = "NotasDebitosDet.findByIdNotaDebito", query = "SELECT n FROM NotasDebitosDet n WHERE n.notasDebitosDetPK.idNotaDebito = :idNotaDebito"),
    @NamedQuery(name = "NotasDebitosDet.findByIdProducto", query = "SELECT n FROM NotasDebitosDet n WHERE n.notasDebitosDetPK.idProducto = :idProducto"),
    @NamedQuery(name = "NotasDebitosDet.findByIdDeposito", query = "SELECT n FROM NotasDebitosDet n WHERE n.notasDebitosDetPK.idDeposito = :idDeposito")})
public class NotasDebitosDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NotasDebitosDetPK notasDebitosDetPK;
    @Column(name = "cantidad")
    private BigInteger cantidad;
    @Column(name = "porc_iva")
    private BigInteger porcIva;
    @Column(name = "precio_uni")
    private BigInteger precioUni;
    @JoinColumn(name = "id_nota_debito", referencedColumnName = "id_nota_debito", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NotasDebitos notasDebitos;
    @JoinColumns({
        @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false),
        @JoinColumn(name = "id_deposito", referencedColumnName = "id_deposito", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Stock stock;

    public NotasDebitosDet() {
    }

    public NotasDebitosDet(NotasDebitosDetPK notasDebitosDetPK) {
        this.notasDebitosDetPK = notasDebitosDetPK;
    }

    public NotasDebitosDet(int idNotaDebito, int idProducto, int idDeposito) {
        this.notasDebitosDetPK = new NotasDebitosDetPK(idNotaDebito, idProducto, idDeposito);
    }

    public NotasDebitosDetPK getNotasDebitosDetPK() {
        return notasDebitosDetPK;
    }

    public void setNotasDebitosDetPK(NotasDebitosDetPK notasDebitosDetPK) {
        this.notasDebitosDetPK = notasDebitosDetPK;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public BigInteger getPorcIva() {
        return porcIva;
    }

    public void setPorcIva(BigInteger porcIva) {
        this.porcIva = porcIva;
    }

    public BigInteger getPrecioUni() {
        return precioUni;
    }

    public void setPrecioUni(BigInteger precioUni) {
        this.precioUni = precioUni;
    }

    public NotasDebitos getNotasDebitos() {
        return notasDebitos;
    }

    public void setNotasDebitos(NotasDebitos notasDebitos) {
        this.notasDebitos = notasDebitos;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notasDebitosDetPK != null ? notasDebitosDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotasDebitosDet)) {
            return false;
        }
        NotasDebitosDet other = (NotasDebitosDet) object;
        if ((this.notasDebitosDetPK == null && other.notasDebitosDetPK != null) || (this.notasDebitosDetPK != null && !this.notasDebitosDetPK.equals(other.notasDebitosDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.NotasDebitosDet[ notasDebitosDetPK=" + notasDebitosDetPK + " ]";
    }
    
}
