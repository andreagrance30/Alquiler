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
@Table(name = "cobros_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CobrosDet.findAll", query = "SELECT c FROM CobrosDet c"),
    @NamedQuery(name = "CobrosDet.findByIdCobro", query = "SELECT c FROM CobrosDet c WHERE c.cobrosDetPK.idCobro = :idCobro"),
    @NamedQuery(name = "CobrosDet.findByIdCuentaCobrar", query = "SELECT c FROM CobrosDet c WHERE c.cobrosDetPK.idCuentaCobrar = :idCuentaCobrar"),
    @NamedQuery(name = "CobrosDet.findByMontoCobro", query = "SELECT c FROM CobrosDet c WHERE c.montoCobro = :montoCobro")})
public class CobrosDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CobrosDetPK cobrosDetPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_cobro")
    private BigInteger montoCobro;
    @JoinColumn(name = "id_cobro", referencedColumnName = "id_cobro", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cobros cobros;
    @JoinColumn(name = "id_cuenta_cobrar", referencedColumnName = "id_cuenta_cobrar", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CuentasCobrar cuentasCobrar;

    public CobrosDet() {
    }

    public CobrosDet(CobrosDetPK cobrosDetPK) {
        this.cobrosDetPK = cobrosDetPK;
    }

    public CobrosDet(CobrosDetPK cobrosDetPK, BigInteger montoCobro) {
        this.cobrosDetPK = cobrosDetPK;
        this.montoCobro = montoCobro;
    }

    public CobrosDet(int idCobro, int idCuentaCobrar) {
        this.cobrosDetPK = new CobrosDetPK(idCobro, idCuentaCobrar);
    }

    public CobrosDetPK getCobrosDetPK() {
        return cobrosDetPK;
    }

    public void setCobrosDetPK(CobrosDetPK cobrosDetPK) {
        this.cobrosDetPK = cobrosDetPK;
    }

    public BigInteger getMontoCobro() {
        return montoCobro;
    }

    public void setMontoCobro(BigInteger montoCobro) {
        this.montoCobro = montoCobro;
    }

    public Cobros getCobros() {
        return cobros;
    }

    public void setCobros(Cobros cobros) {
        this.cobros = cobros;
    }

    public CuentasCobrar getCuentasCobrar() {
        return cuentasCobrar;
    }

    public void setCuentasCobrar(CuentasCobrar cuentasCobrar) {
        this.cuentasCobrar = cuentasCobrar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cobrosDetPK != null ? cobrosDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CobrosDet)) {
            return false;
        }
        CobrosDet other = (CobrosDet) object;
        if ((this.cobrosDetPK == null && other.cobrosDetPK != null) || (this.cobrosDetPK != null && !this.cobrosDetPK.equals(other.cobrosDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.CobrosDet[ cobrosDetPK=" + cobrosDetPK + " ]";
    }
    
}
