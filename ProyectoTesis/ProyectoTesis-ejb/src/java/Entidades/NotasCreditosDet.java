/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "notas_creditos_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotasCreditosDet.findAll", query = "SELECT n FROM NotasCreditosDet n"),
    @NamedQuery(name = "NotasCreditosDet.findByCantidad", query = "SELECT n FROM NotasCreditosDet n WHERE n.cantidad = :cantidad"),
    @NamedQuery(name = "NotasCreditosDet.findByPorcIva", query = "SELECT n FROM NotasCreditosDet n WHERE n.porcIva = :porcIva"),
    @NamedQuery(name = "NotasCreditosDet.findByPrecioUni", query = "SELECT n FROM NotasCreditosDet n WHERE n.precioUni = :precioUni"),
    @NamedQuery(name = "NotasCreditosDet.findByIdNotaCredito", query = "SELECT n FROM NotasCreditosDet n WHERE n.notasCreditosDetPK.idNotaCredito = :idNotaCredito"),
    @NamedQuery(name = "NotasCreditosDet.findByIdProducto", query = "SELECT n FROM NotasCreditosDet n WHERE n.notasCreditosDetPK.idProducto = :idProducto"),
    @NamedQuery(name = "NotasCreditosDet.findByIdDeposito", query = "SELECT n FROM NotasCreditosDet n WHERE n.notasCreditosDetPK.idDeposito = :idDeposito")})
public class NotasCreditosDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NotasCreditosDetPK notasCreditosDetPK;
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @Column(name = "porc_iva")
    private BigDecimal porcIva;
    @Column(name = "precio_uni")
    private BigDecimal precioUni;
    @JoinColumn(name = "id_nota_credito", referencedColumnName = "id_nota_credito", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NotasCreditos notasCreditos;
    @JoinColumns({
        @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false),
        @JoinColumn(name = "id_deposito", referencedColumnName = "id_deposito", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Stock stock;

    public NotasCreditosDet() {
    }

    public NotasCreditosDet(NotasCreditosDetPK notasCreditosDetPK) {
        this.notasCreditosDetPK = notasCreditosDetPK;
    }

    public NotasCreditosDet(int idNotaCredito, int idProducto, int idDeposito) {
        this.notasCreditosDetPK = new NotasCreditosDetPK(idNotaCredito, idProducto, idDeposito);
    }

    public NotasCreditosDetPK getNotasCreditosDetPK() {
        return notasCreditosDetPK;
    }

    public void setNotasCreditosDetPK(NotasCreditosDetPK notasCreditosDetPK) {
        this.notasCreditosDetPK = notasCreditosDetPK;
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

    public NotasCreditos getNotasCreditos() {
        return notasCreditos;
    }

    public void setNotasCreditos(NotasCreditos notasCreditos) {
        this.notasCreditos = notasCreditos;
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
        hash += (notasCreditosDetPK != null ? notasCreditosDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotasCreditosDet)) {
            return false;
        }
        NotasCreditosDet other = (NotasCreditosDet) object;
        if ((this.notasCreditosDetPK == null && other.notasCreditosDetPK != null) || (this.notasCreditosDetPK != null && !this.notasCreditosDetPK.equals(other.notasCreditosDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.NotasCreditosDet[ notasCreditosDetPK=" + notasCreditosDetPK + " ]";
    }
    
}
