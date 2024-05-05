/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "cobros_formas_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CobrosFormasDet.findAll", query = "SELECT c FROM CobrosFormasDet c"),
    @NamedQuery(name = "CobrosFormasDet.findByIdCobro", query = "SELECT c FROM CobrosFormasDet c WHERE c.cobrosFormasDetPK.idCobro = :idCobro"),
    @NamedQuery(name = "CobrosFormasDet.findByIdTransaccionComercial", query = "SELECT c FROM CobrosFormasDet c WHERE c.cobrosFormasDetPK.idTransaccionComercial = :idTransaccionComercial"),
    @NamedQuery(name = "CobrosFormasDet.findByMontoDet", query = "SELECT c FROM CobrosFormasDet c WHERE c.montoDet = :montoDet")})
public class CobrosFormasDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CobrosFormasDetPK cobrosFormasDetPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_det")
    private BigInteger montoDet;
    @JoinColumn(name = "id_cobro", referencedColumnName = "id_cobro", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cobros cobros;
    @JoinColumn(name = "id_transaccion_comercial", referencedColumnName = "id_transaccion_comercial", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TransaccionesComerciales transaccionesComerciales;

    public CobrosFormasDet() {
    }

    public CobrosFormasDet(CobrosFormasDetPK cobrosFormasDetPK) {
        this.cobrosFormasDetPK = cobrosFormasDetPK;
    }

    public CobrosFormasDet(CobrosFormasDetPK cobrosFormasDetPK, BigInteger montoDet) {
        this.cobrosFormasDetPK = cobrosFormasDetPK;
        this.montoDet = montoDet;
    }

    public CobrosFormasDet(int idCobro, int idTransaccionComercial) {
        this.cobrosFormasDetPK = new CobrosFormasDetPK(idCobro, idTransaccionComercial);
    }

    public CobrosFormasDetPK getCobrosFormasDetPK() {
        return cobrosFormasDetPK;
    }

    public void setCobrosFormasDetPK(CobrosFormasDetPK cobrosFormasDetPK) {
        this.cobrosFormasDetPK = cobrosFormasDetPK;
    }

    public BigInteger getMontoDet() {
        return montoDet;
    }

    public void setMontoDet(BigInteger montoDet) {
        this.montoDet = montoDet;
    }

    public Cobros getCobros() {
        return cobros;
    }

    public void setCobros(Cobros cobros) {
        this.cobros = cobros;
    }

    public TransaccionesComerciales getTransaccionesComerciales() {
        return transaccionesComerciales;
    }

    public void setTransaccionesComerciales(TransaccionesComerciales transaccionesComerciales) {
        this.transaccionesComerciales = transaccionesComerciales;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cobrosFormasDetPK != null ? cobrosFormasDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CobrosFormasDet)) {
            return false;
        }
        CobrosFormasDet other = (CobrosFormasDet) object;
        if ((this.cobrosFormasDetPK == null && other.cobrosFormasDetPK != null) || (this.cobrosFormasDetPK != null && !this.cobrosFormasDetPK.equals(other.cobrosFormasDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.CobrosFormasDet[ cobrosFormasDetPK=" + cobrosFormasDetPK + " ]";
    }
    
}
