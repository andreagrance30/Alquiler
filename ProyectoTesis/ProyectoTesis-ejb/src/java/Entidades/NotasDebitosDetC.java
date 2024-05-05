/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrea Salinas
 */
@Entity
@Table(name = "notas_debitos_det_c")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotasDebitosDetC.findAll", query = "SELECT n FROM NotasDebitosDetC n"),
    @NamedQuery(name = "NotasDebitosDetC.findByIdNotaDebitoC", query = "SELECT n FROM NotasDebitosDetC n WHERE n.notasDebitosDetCPK.idNotaDebitoC = :idNotaDebitoC"),
    @NamedQuery(name = "NotasDebitosDetC.findByIdProducto", query = "SELECT n FROM NotasDebitosDetC n WHERE n.notasDebitosDetCPK.idProducto = :idProducto"),
    @NamedQuery(name = "NotasDebitosDetC.findByIdDeposito", query = "SELECT n FROM NotasDebitosDetC n WHERE n.notasDebitosDetCPK.idDeposito = :idDeposito"),
    @NamedQuery(name = "NotasDebitosDetC.findByCantidad", query = "SELECT n FROM NotasDebitosDetC n WHERE n.cantidad = :cantidad"),
    @NamedQuery(name = "NotasDebitosDetC.findByPorcIva", query = "SELECT n FROM NotasDebitosDetC n WHERE n.porcIva = :porcIva"),
    @NamedQuery(name = "NotasDebitosDetC.findByPrecioUni", query = "SELECT n FROM NotasDebitosDetC n WHERE n.precioUni = :precioUni")})
public class NotasDebitosDetC implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NotasDebitosDetCPK notasDebitosDetCPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porc_iva")
    private BigDecimal porcIva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_uni")
    private BigDecimal precioUni;
    @JoinColumn(name = "id_nota_debito_c", referencedColumnName = "id_nota_debito_c", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NotasDebitosC notasDebitosC;
    @JoinColumns({
        @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false),
        @JoinColumn(name = "id_deposito", referencedColumnName = "id_deposito", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Stock stock;

    public NotasDebitosDetC() {
    }

    public NotasDebitosDetC(NotasDebitosDetCPK notasDebitosDetCPK) {
        this.notasDebitosDetCPK = notasDebitosDetCPK;
    }

    public NotasDebitosDetC(NotasDebitosDetCPK notasDebitosDetCPK, BigDecimal cantidad, BigDecimal porcIva, BigDecimal precioUni) {
        this.notasDebitosDetCPK = notasDebitosDetCPK;
        this.cantidad = cantidad;
        this.porcIva = porcIva;
        this.precioUni = precioUni;
    }

    public NotasDebitosDetC(int idNotaDebitoC, int idProducto, int idDeposito) {
        this.notasDebitosDetCPK = new NotasDebitosDetCPK(idNotaDebitoC, idProducto, idDeposito);
    }

    public NotasDebitosDetCPK getNotasDebitosDetCPK() {
        return notasDebitosDetCPK;
    }

    public void setNotasDebitosDetCPK(NotasDebitosDetCPK notasDebitosDetCPK) {
        this.notasDebitosDetCPK = notasDebitosDetCPK;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPorcIva() {
        return porcIva;
    }

    public void setPorcIva(BigDecimal porcIva) {
        this.porcIva = porcIva;
    }

    public BigDecimal getPrecioUni() {
        return precioUni;
    }

    public void setPrecioUni(BigDecimal precioUni) {
        this.precioUni = precioUni;
    }

    public NotasDebitosC getNotasDebitosC() {
        return notasDebitosC;
    }

    public void setNotasDebitosC(NotasDebitosC notasDebitosC) {
        this.notasDebitosC = notasDebitosC;
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
        hash += (notasDebitosDetCPK != null ? notasDebitosDetCPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotasDebitosDetC)) {
            return false;
        }
        NotasDebitosDetC other = (NotasDebitosDetC) object;
        if ((this.notasDebitosDetCPK == null && other.notasDebitosDetCPK != null) || (this.notasDebitosDetCPK != null && !this.notasDebitosDetCPK.equals(other.notasDebitosDetCPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.NotasDebitosDetC[ notasDebitosDetCPK=" + notasDebitosDetCPK + " ]";
    }
    
}
