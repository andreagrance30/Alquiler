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
@Table(name = "notas_remisiones_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotasRemisionesDet.findAll", query = "SELECT n FROM NotasRemisionesDet n"),
    @NamedQuery(name = "NotasRemisionesDet.findByCantidad", query = "SELECT n FROM NotasRemisionesDet n WHERE n.cantidad = :cantidad"),
    @NamedQuery(name = "NotasRemisionesDet.findByIdNotaRemision", query = "SELECT n FROM NotasRemisionesDet n WHERE n.notasRemisionesDetPK.idNotaRemision = :idNotaRemision"),
    @NamedQuery(name = "NotasRemisionesDet.findByIdProducto", query = "SELECT n FROM NotasRemisionesDet n WHERE n.notasRemisionesDetPK.idProducto = :idProducto"),
    @NamedQuery(name = "NotasRemisionesDet.findByIdDeposito", query = "SELECT n FROM NotasRemisionesDet n WHERE n.notasRemisionesDetPK.idDeposito = :idDeposito")})
public class NotasRemisionesDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NotasRemisionesDetPK notasRemisionesDetPK;
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @JoinColumn(name = "id_nota_remision", referencedColumnName = "id_nota_remision", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NotasRemisiones notasRemisiones;
    @JoinColumns({
        @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false),
        @JoinColumn(name = "id_deposito", referencedColumnName = "id_deposito", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Stock stock;

    public NotasRemisionesDet() {
    }

    public NotasRemisionesDet(NotasRemisionesDetPK notasRemisionesDetPK) {
        this.notasRemisionesDetPK = notasRemisionesDetPK;
    }

    public NotasRemisionesDet(int idNotaRemision, int idProducto, int idDeposito) {
        this.notasRemisionesDetPK = new NotasRemisionesDetPK(idNotaRemision, idProducto, idDeposito);
    }

    public NotasRemisionesDetPK getNotasRemisionesDetPK() {
        return notasRemisionesDetPK;
    }

    public void setNotasRemisionesDetPK(NotasRemisionesDetPK notasRemisionesDetPK) {
        this.notasRemisionesDetPK = notasRemisionesDetPK;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public NotasRemisiones getNotasRemisiones() {
        return notasRemisiones;
    }

    public void setNotasRemisiones(NotasRemisiones notasRemisiones) {
        this.notasRemisiones = notasRemisiones;
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
        hash += (notasRemisionesDetPK != null ? notasRemisionesDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotasRemisionesDet)) {
            return false;
        }
        NotasRemisionesDet other = (NotasRemisionesDet) object;
        if ((this.notasRemisionesDetPK == null && other.notasRemisionesDetPK != null) || (this.notasRemisionesDetPK != null && !this.notasRemisionesDetPK.equals(other.notasRemisionesDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.NotasRemisionesDet[ notasRemisionesDetPK=" + notasRemisionesDetPK + " ]";
    }
    
}
