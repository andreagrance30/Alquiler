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
@Table(name = "notas_creditos_det_c")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotasCreditosDetC.findAll", query = "SELECT n FROM NotasCreditosDetC n"),
    @NamedQuery(name = "NotasCreditosDetC.findByIdNotaCreditoC", query = "SELECT n FROM NotasCreditosDetC n WHERE n.notasCreditosDetCPK.idNotaCreditoC = :idNotaCreditoC"),
    @NamedQuery(name = "NotasCreditosDetC.findByIdProducto", query = "SELECT n FROM NotasCreditosDetC n WHERE n.notasCreditosDetCPK.idProducto = :idProducto"),
    @NamedQuery(name = "NotasCreditosDetC.findByIdDeposito", query = "SELECT n FROM NotasCreditosDetC n WHERE n.notasCreditosDetCPK.idDeposito = :idDeposito"),
    @NamedQuery(name = "NotasCreditosDetC.findByCantidad", query = "SELECT n FROM NotasCreditosDetC n WHERE n.cantidad = :cantidad"),
    @NamedQuery(name = "NotasCreditosDetC.findByPorcIva", query = "SELECT n FROM NotasCreditosDetC n WHERE n.porcIva = :porcIva"),
    @NamedQuery(name = "NotasCreditosDetC.findByPrecioUni", query = "SELECT n FROM NotasCreditosDetC n WHERE n.precioUni = :precioUni")})
public class NotasCreditosDetC implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NotasCreditosDetCPK notasCreditosDetCPK;
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
    @JoinColumn(name = "id_nota_credito_c", referencedColumnName = "id_nota_credito_c", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NotasCreditosC notasCreditosC;
    @JoinColumns({
        @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false),
        @JoinColumn(name = "id_deposito", referencedColumnName = "id_deposito", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Stock stock;

    public NotasCreditosDetC() {
    }

    public NotasCreditosDetC(NotasCreditosDetCPK notasCreditosDetCPK) {
        this.notasCreditosDetCPK = notasCreditosDetCPK;
    }

    public NotasCreditosDetC(NotasCreditosDetCPK notasCreditosDetCPK, BigDecimal cantidad, BigDecimal porcIva, BigDecimal precioUni) {
        this.notasCreditosDetCPK = notasCreditosDetCPK;
        this.cantidad = cantidad;
        this.porcIva = porcIva;
        this.precioUni = precioUni;
    }

    public NotasCreditosDetC(int idNotaCreditoC, int idProducto, int idDeposito) {
        this.notasCreditosDetCPK = new NotasCreditosDetCPK(idNotaCreditoC, idProducto, idDeposito);
    }

    public NotasCreditosDetCPK getNotasCreditosDetCPK() {
        return notasCreditosDetCPK;
    }

    public void setNotasCreditosDetCPK(NotasCreditosDetCPK notasCreditosDetCPK) {
        this.notasCreditosDetCPK = notasCreditosDetCPK;
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

    public NotasCreditosC getNotasCreditosC() {
        return notasCreditosC;
    }

    public void setNotasCreditosC(NotasCreditosC notasCreditosC) {
        this.notasCreditosC = notasCreditosC;
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
        hash += (notasCreditosDetCPK != null ? notasCreditosDetCPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotasCreditosDetC)) {
            return false;
        }
        NotasCreditosDetC other = (NotasCreditosDetC) object;
        if ((this.notasCreditosDetCPK == null && other.notasCreditosDetCPK != null) || (this.notasCreditosDetCPK != null && !this.notasCreditosDetCPK.equals(other.notasCreditosDetCPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.NotasCreditosDetC[ notasCreditosDetCPK=" + notasCreditosDetCPK + " ]";
    }
    
}
