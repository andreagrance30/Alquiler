/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
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
@Table(name = "cobros_cheques")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CobrosCheques.findAll", query = "SELECT c FROM CobrosCheques c"),
    @NamedQuery(name = "CobrosCheques.findByIdCobroCheque", query = "SELECT c FROM CobrosCheques c WHERE c.idCobroCheque = :idCobroCheque"),
    @NamedQuery(name = "CobrosCheques.findByNroCheque", query = "SELECT c FROM CobrosCheques c WHERE c.nroCheque = :nroCheque"),
    @NamedQuery(name = "CobrosCheques.findByEstado", query = "SELECT c FROM CobrosCheques c WHERE c.estado = :estado"),
    @NamedQuery(name = "CobrosCheques.findByFechaEmision", query = "SELECT c FROM CobrosCheques c WHERE c.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "CobrosCheques.findByFechaRetiro", query = "SELECT c FROM CobrosCheques c WHERE c.fechaRetiro = :fechaRetiro")})
public class CobrosCheques implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cobro_cheque")
    private Integer idCobroCheque;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nro_cheque")
    private String nroCheque;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_emision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @Column(name = "fecha_retiro")
    @Temporal(TemporalType.DATE)
    private Date fechaRetiro;
    @JoinColumn(name = "id_cobro", referencedColumnName = "id_cobro")
    @ManyToOne(optional = false)
    private Cobros idCobro;
    @JoinColumn(name = "id_entidad_emisora", referencedColumnName = "id_entidad_emisora")
    @ManyToOne(optional = false)
    private EntidadesEmisoras idEntidadEmisora;
    @JoinColumn(name = "id_tipo_cheque", referencedColumnName = "id_tipo_cheque")
    @ManyToOne(optional = false)
    private TiposCheques idTipoCheque;

    public CobrosCheques() {
    }

    public CobrosCheques(Integer idCobroCheque) {
        this.idCobroCheque = idCobroCheque;
    }

    public CobrosCheques(Integer idCobroCheque, String nroCheque, String estado, Date fechaEmision) {
        this.idCobroCheque = idCobroCheque;
        this.nroCheque = nroCheque;
        this.estado = estado;
        this.fechaEmision = fechaEmision;
    }

    public Integer getIdCobroCheque() {
        return idCobroCheque;
    }

    public void setIdCobroCheque(Integer idCobroCheque) {
        this.idCobroCheque = idCobroCheque;
    }

    public String getNroCheque() {
        return nroCheque;
    }

    public void setNroCheque(String nroCheque) {
        this.nroCheque = nroCheque;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(Date fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public Cobros getIdCobro() {
        return idCobro;
    }

    public void setIdCobro(Cobros idCobro) {
        this.idCobro = idCobro;
    }

    public EntidadesEmisoras getIdEntidadEmisora() {
        return idEntidadEmisora;
    }

    public void setIdEntidadEmisora(EntidadesEmisoras idEntidadEmisora) {
        this.idEntidadEmisora = idEntidadEmisora;
    }

    public TiposCheques getIdTipoCheque() {
        return idTipoCheque;
    }

    public void setIdTipoCheque(TiposCheques idTipoCheque) {
        this.idTipoCheque = idTipoCheque;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCobroCheque != null ? idCobroCheque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CobrosCheques)) {
            return false;
        }
        CobrosCheques other = (CobrosCheques) object;
        if ((this.idCobroCheque == null && other.idCobroCheque != null) || (this.idCobroCheque != null && !this.idCobroCheque.equals(other.idCobroCheque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.CobrosCheques[ idCobroCheque=" + idCobroCheque + " ]";
    }
    
}
