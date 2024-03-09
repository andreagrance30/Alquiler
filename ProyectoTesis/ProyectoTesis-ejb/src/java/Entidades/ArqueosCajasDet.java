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
@Table(name = "arqueos_cajas_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArqueosCajasDet.findAll", query = "SELECT a FROM ArqueosCajasDet a"),
    @NamedQuery(name = "ArqueosCajasDet.findByIdTransaccionComercial", query = "SELECT a FROM ArqueosCajasDet a WHERE a.arqueosCajasDetPK.idTransaccionComercial = :idTransaccionComercial"),
    @NamedQuery(name = "ArqueosCajasDet.findByIdArqueoCaja", query = "SELECT a FROM ArqueosCajasDet a WHERE a.arqueosCajasDetPK.idArqueoCaja = :idArqueoCaja"),
    @NamedQuery(name = "ArqueosCajasDet.findByMontoFisico", query = "SELECT a FROM ArqueosCajasDet a WHERE a.montoFisico = :montoFisico"),
    @NamedQuery(name = "ArqueosCajasDet.findByMontoTeorico", query = "SELECT a FROM ArqueosCajasDet a WHERE a.montoTeorico = :montoTeorico")})
public class ArqueosCajasDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ArqueosCajasDetPK arqueosCajasDetPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_fisico")
    private BigInteger montoFisico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_teorico")
    private BigInteger montoTeorico;
    @JoinColumn(name = "id_arqueo_caja", referencedColumnName = "id_arqueo_caja", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ArqueosCajas arqueosCajas;
    @JoinColumn(name = "id_transaccion_comercial", referencedColumnName = "id_transaccion_comercial", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TransaccionesComerciales transaccionesComerciales;

    public ArqueosCajasDet() {
    }

    public ArqueosCajasDet(ArqueosCajasDetPK arqueosCajasDetPK) {
        this.arqueosCajasDetPK = arqueosCajasDetPK;
    }

    public ArqueosCajasDet(ArqueosCajasDetPK arqueosCajasDetPK, BigInteger montoFisico, BigInteger montoTeorico) {
        this.arqueosCajasDetPK = arqueosCajasDetPK;
        this.montoFisico = montoFisico;
        this.montoTeorico = montoTeorico;
    }

    public ArqueosCajasDet(int idTransaccionComercial, int idArqueoCaja) {
        this.arqueosCajasDetPK = new ArqueosCajasDetPK(idTransaccionComercial, idArqueoCaja);
    }

    public ArqueosCajasDetPK getArqueosCajasDetPK() {
        return arqueosCajasDetPK;
    }

    public void setArqueosCajasDetPK(ArqueosCajasDetPK arqueosCajasDetPK) {
        this.arqueosCajasDetPK = arqueosCajasDetPK;
    }

    public BigInteger getMontoFisico() {
        return montoFisico;
    }

    public void setMontoFisico(BigInteger montoFisico) {
        this.montoFisico = montoFisico;
    }

    public BigInteger getMontoTeorico() {
        return montoTeorico;
    }

    public void setMontoTeorico(BigInteger montoTeorico) {
        this.montoTeorico = montoTeorico;
    }

    public ArqueosCajas getArqueosCajas() {
        return arqueosCajas;
    }

    public void setArqueosCajas(ArqueosCajas arqueosCajas) {
        this.arqueosCajas = arqueosCajas;
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
        hash += (arqueosCajasDetPK != null ? arqueosCajasDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArqueosCajasDet)) {
            return false;
        }
        ArqueosCajasDet other = (ArqueosCajasDet) object;
        if ((this.arqueosCajasDetPK == null && other.arqueosCajasDetPK != null) || (this.arqueosCajasDetPK != null && !this.arqueosCajasDetPK.equals(other.arqueosCajasDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ArqueosCajasDet[ arqueosCajasDetPK=" + arqueosCajasDetPK + " ]";
    }
    
}
