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
@Table(name = "notas_remisiones_det_c")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotasRemisionesDetC.findAll", query = "SELECT n FROM NotasRemisionesDetC n"),
    @NamedQuery(name = "NotasRemisionesDetC.findByCantidad", query = "SELECT n FROM NotasRemisionesDetC n WHERE n.cantidad = :cantidad"),
    @NamedQuery(name = "NotasRemisionesDetC.findByIdProducto", query = "SELECT n FROM NotasRemisionesDetC n WHERE n.notasRemisionesDetCPK.idProducto = :idProducto"),
    @NamedQuery(name = "NotasRemisionesDetC.findByIdNotaRemsionC", query = "SELECT n FROM NotasRemisionesDetC n WHERE n.notasRemisionesDetCPK.idNotaRemsionC = :idNotaRemsionC"),
    @NamedQuery(name = "NotasRemisionesDetC.findByIdDeposito", query = "SELECT n FROM NotasRemisionesDetC n WHERE n.notasRemisionesDetCPK.idDeposito = :idDeposito")})
public class NotasRemisionesDetC implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NotasRemisionesDetCPK notasRemisionesDetCPK;
    @Column(name = "cantidad")
    private BigInteger cantidad;
    @JoinColumn(name = "id_nota_remsion_c", referencedColumnName = "id_nota_remsion_c", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NotasRemisionesC notasRemisionesC;
    @JoinColumns({
        @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false),
        @JoinColumn(name = "id_deposito", referencedColumnName = "id_deposito", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Stock stock;

    public NotasRemisionesDetC() {
    }

    public NotasRemisionesDetC(NotasRemisionesDetCPK notasRemisionesDetCPK) {
        this.notasRemisionesDetCPK = notasRemisionesDetCPK;
    }

    public NotasRemisionesDetC(int idProducto, int idNotaRemsionC, int idDeposito) {
        this.notasRemisionesDetCPK = new NotasRemisionesDetCPK(idProducto, idNotaRemsionC, idDeposito);
    }

    public NotasRemisionesDetCPK getNotasRemisionesDetCPK() {
        return notasRemisionesDetCPK;
    }

    public void setNotasRemisionesDetCPK(NotasRemisionesDetCPK notasRemisionesDetCPK) {
        this.notasRemisionesDetCPK = notasRemisionesDetCPK;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public NotasRemisionesC getNotasRemisionesC() {
        return notasRemisionesC;
    }

    public void setNotasRemisionesC(NotasRemisionesC notasRemisionesC) {
        this.notasRemisionesC = notasRemisionesC;
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
        hash += (notasRemisionesDetCPK != null ? notasRemisionesDetCPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotasRemisionesDetC)) {
            return false;
        }
        NotasRemisionesDetC other = (NotasRemisionesDetC) object;
        if ((this.notasRemisionesDetCPK == null && other.notasRemisionesDetCPK != null) || (this.notasRemisionesDetCPK != null && !this.notasRemisionesDetCPK.equals(other.notasRemisionesDetCPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.NotasRemisionesDetC[ notasRemisionesDetCPK=" + notasRemisionesDetCPK + " ]";
    }
    
}
