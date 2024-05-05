/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andrea Salinas
 */
@Entity
@Table(name = "cuentas_cobrar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentasCobrar.findAll", query = "SELECT c FROM CuentasCobrar c"),
    @NamedQuery(name = "CuentasCobrar.findByIdCuentaCobrar", query = "SELECT c FROM CuentasCobrar c WHERE c.idCuentaCobrar = :idCuentaCobrar"),
    @NamedQuery(name = "CuentasCobrar.findByEstado", query = "SELECT c FROM CuentasCobrar c WHERE c.estado = :estado"),
    @NamedQuery(name = "CuentasCobrar.findByCuota", query = "SELECT c FROM CuentasCobrar c WHERE c.cuota = :cuota"),
    @NamedQuery(name = "CuentasCobrar.findByImporte", query = "SELECT c FROM CuentasCobrar c WHERE c.importe = :importe"),
    @NamedQuery(name = "CuentasCobrar.findByVencCuota", query = "SELECT c FROM CuentasCobrar c WHERE c.vencCuota = :vencCuota"),
    @NamedQuery(name = "CuentasCobrar.findByInteres", query = "SELECT c FROM CuentasCobrar c WHERE c.interes = :interes"),
    @NamedQuery(name = "CuentasCobrar.findBySaldo", query = "SELECT c FROM CuentasCobrar c WHERE c.saldo = :saldo")})
public class CuentasCobrar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cuenta_cobrar")
    private Integer idCuentaCobrar;
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
    private BigInteger importe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "venc_cuota")
    @Temporal(TemporalType.DATE)
    private Date vencCuota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "interes")
    private BigInteger interes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo")
    private BigInteger saldo;
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta")
    @ManyToOne(optional = false)
    private Ventas idVenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentasCobrar")
    private List<CobrosDet> cobrosDetList;

    public CuentasCobrar() {
    }

    public CuentasCobrar(Integer idCuentaCobrar) {
        this.idCuentaCobrar = idCuentaCobrar;
    }

    public CuentasCobrar(Integer idCuentaCobrar, String estado, int cuota, BigInteger importe, Date vencCuota, BigInteger interes, BigInteger saldo) {
        this.idCuentaCobrar = idCuentaCobrar;
        this.estado = estado;
        this.cuota = cuota;
        this.importe = importe;
        this.vencCuota = vencCuota;
        this.interes = interes;
        this.saldo = saldo;
    }

    public Integer getIdCuentaCobrar() {
        return idCuentaCobrar;
    }

    public void setIdCuentaCobrar(Integer idCuentaCobrar) {
        this.idCuentaCobrar = idCuentaCobrar;
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

    public BigInteger getImporte() {
        return importe;
    }

    public void setImporte(BigInteger importe) {
        this.importe = importe;
    }

    public Date getVencCuota() {
        return vencCuota;
    }

    public void setVencCuota(Date vencCuota) {
        this.vencCuota = vencCuota;
    }

    public BigInteger getInteres() {
        return interes;
    }

    public void setInteres(BigInteger interes) {
        this.interes = interes;
    }

    public BigInteger getSaldo() {
        return saldo;
    }

    public void setSaldo(BigInteger saldo) {
        this.saldo = saldo;
    }

    public Ventas getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Ventas idVenta) {
        this.idVenta = idVenta;
    }

    @XmlTransient
    public List<CobrosDet> getCobrosDetList() {
        return cobrosDetList;
    }

    public void setCobrosDetList(List<CobrosDet> cobrosDetList) {
        this.cobrosDetList = cobrosDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuentaCobrar != null ? idCuentaCobrar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentasCobrar)) {
            return false;
        }
        CuentasCobrar other = (CuentasCobrar) object;
        if ((this.idCuentaCobrar == null && other.idCuentaCobrar != null) || (this.idCuentaCobrar != null && !this.idCuentaCobrar.equals(other.idCuentaCobrar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.CuentasCobrar[ idCuentaCobrar=" + idCuentaCobrar + " ]";
    }
    
}
