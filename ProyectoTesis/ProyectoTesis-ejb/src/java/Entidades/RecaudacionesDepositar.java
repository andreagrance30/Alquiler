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
@Table(name = "recaudaciones_depositar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecaudacionesDepositar.findAll", query = "SELECT r FROM RecaudacionesDepositar r"),
    @NamedQuery(name = "RecaudacionesDepositar.findByIdRecaudacionDepositar", query = "SELECT r FROM RecaudacionesDepositar r WHERE r.idRecaudacionDepositar = :idRecaudacionDepositar"),
    @NamedQuery(name = "RecaudacionesDepositar.findByFecha", query = "SELECT r FROM RecaudacionesDepositar r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "RecaudacionesDepositar.findByEstado", query = "SELECT r FROM RecaudacionesDepositar r WHERE r.estado = :estado"),
    @NamedQuery(name = "RecaudacionesDepositar.findByTotalCheque", query = "SELECT r FROM RecaudacionesDepositar r WHERE r.totalCheque = :totalCheque"),
    @NamedQuery(name = "RecaudacionesDepositar.findByTotalEfectivo", query = "SELECT r FROM RecaudacionesDepositar r WHERE r.totalEfectivo = :totalEfectivo")})
public class RecaudacionesDepositar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_recaudacion_depositar")
    private Integer idRecaudacionDepositar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @Column(name = "total_cheque")
    private BigDecimal totalCheque;
    @Column(name = "total_efectivo")
    private BigDecimal totalEfectivo;
    @JoinColumn(name = "id_apertura_cierre_caja", referencedColumnName = "id_apertura_cierre_caja")
    @ManyToOne(optional = false)
    private AperturaCierreCaja idAperturaCierreCaja;

    public RecaudacionesDepositar() {
    }

    public RecaudacionesDepositar(Integer idRecaudacionDepositar) {
        this.idRecaudacionDepositar = idRecaudacionDepositar;
    }

    public RecaudacionesDepositar(Integer idRecaudacionDepositar, Date fecha, String estado) {
        this.idRecaudacionDepositar = idRecaudacionDepositar;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Integer getIdRecaudacionDepositar() {
        return idRecaudacionDepositar;
    }

    public void setIdRecaudacionDepositar(Integer idRecaudacionDepositar) {
        this.idRecaudacionDepositar = idRecaudacionDepositar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getTotalCheque() {
        return totalCheque;
    }

    public void setTotalCheque(BigDecimal totalCheque) {
        this.totalCheque = totalCheque;
    }

    public BigDecimal getTotalEfectivo() {
        return totalEfectivo;
    }

    public void setTotalEfectivo(BigDecimal totalEfectivo) {
        this.totalEfectivo = totalEfectivo;
    }

    public AperturaCierreCaja getIdAperturaCierreCaja() {
        return idAperturaCierreCaja;
    }

    public void setIdAperturaCierreCaja(AperturaCierreCaja idAperturaCierreCaja) {
        this.idAperturaCierreCaja = idAperturaCierreCaja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRecaudacionDepositar != null ? idRecaudacionDepositar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecaudacionesDepositar)) {
            return false;
        }
        RecaudacionesDepositar other = (RecaudacionesDepositar) object;
        if ((this.idRecaudacionDepositar == null && other.idRecaudacionDepositar != null) || (this.idRecaudacionDepositar != null && !this.idRecaudacionDepositar.equals(other.idRecaudacionDepositar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.RecaudacionesDepositar[ idRecaudacionDepositar=" + idRecaudacionDepositar + " ]";
    }
    
}
