/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrea Salinas
 */
@Entity
@Table(name = "cuentas_pagar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentasPagar.findAll", query = "SELECT c FROM CuentasPagar c"),
    @NamedQuery(name = "CuentasPagar.findByIdCuentaPagar", query = "SELECT c FROM CuentasPagar c WHERE c.idCuentaPagar = :idCuentaPagar"),
    @NamedQuery(name = "CuentasPagar.findByEstado", query = "SELECT c FROM CuentasPagar c WHERE c.estado = :estado"),
    @NamedQuery(name = "CuentasPagar.findByCuota", query = "SELECT c FROM CuentasPagar c WHERE c.cuota = :cuota"),
    @NamedQuery(name = "CuentasPagar.findByImporte", query = "SELECT c FROM CuentasPagar c WHERE c.importe = :importe"),
    @NamedQuery(name = "CuentasPagar.findByVencCuota", query = "SELECT c FROM CuentasPagar c WHERE c.vencCuota = :vencCuota"),
    @NamedQuery(name = "CuentasPagar.findBySaldo", query = "SELECT c FROM CuentasPagar c WHERE c.saldo = :saldo")})
public class CuentasPagar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cuenta_pagar")
    private Integer idCuentaPagar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuota")
    private int cuota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe")
    private BigDecimal importe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "venc_cuota")
    @Temporal(TemporalType.DATE)
    private Date vencCuota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo")
    private BigDecimal saldo;
    @JoinColumn(name = "id_compra", referencedColumnName = "id_compra")
    @ManyToOne(optional = false)
    private Compras idCompra;

    public CuentasPagar() {
    }

    public CuentasPagar(Integer idCuentaPagar) {
        this.idCuentaPagar = idCuentaPagar;
    }

    public CuentasPagar(Integer idCuentaPagar, String estado, int cuota, BigDecimal importe, Date vencCuota, BigDecimal saldo) {
        this.idCuentaPagar = idCuentaPagar;
        this.estado = estado;
        this.cuota = cuota;
        this.importe = importe;
        this.vencCuota = vencCuota;
        this.saldo = saldo;
    }

    public Integer getIdCuentaPagar() {
        return idCuentaPagar;
    }

    public void setIdCuentaPagar(Integer idCuentaPagar) {
        this.idCuentaPagar = idCuentaPagar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public Date getVencCuota() {
        return vencCuota;
    }

    public void setVencCuota(Date vencCuota) {
        this.vencCuota = vencCuota;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Compras getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Compras idCompra) {
        this.idCompra = idCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuentaPagar != null ? idCuentaPagar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentasPagar)) {
            return false;
        }
        CuentasPagar other = (CuentasPagar) object;
        if ((this.idCuentaPagar == null && other.idCuentaPagar != null) || (this.idCuentaPagar != null && !this.idCuentaPagar.equals(other.idCuentaPagar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.CuentasPagar[ idCuentaPagar=" + idCuentaPagar + " ]";
    }
    
}
