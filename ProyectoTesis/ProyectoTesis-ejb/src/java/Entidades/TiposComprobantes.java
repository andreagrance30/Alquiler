/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andrea Salinas
 */
@Entity
@Table(name = "tipos_comprobantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposComprobantes.findAll", query = "SELECT t FROM TiposComprobantes t"),
    @NamedQuery(name = "TiposComprobantes.findByIdTipoComprobante", query = "SELECT t FROM TiposComprobantes t WHERE t.idTipoComprobante = :idTipoComprobante"),
    @NamedQuery(name = "TiposComprobantes.findByDescripcion", query = "SELECT t FROM TiposComprobantes t WHERE t.descripcion = :descripcion")})
public class TiposComprobantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_comprobante")
    private Integer idTipoComprobante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoComprobante")
    private List<Timbrados> timbradosList;

    public TiposComprobantes() {
    }

    public TiposComprobantes(Integer idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
    }

    public TiposComprobantes(Integer idTipoComprobante, String descripcion) {
        this.idTipoComprobante = idTipoComprobante;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoComprobante() {
        return idTipoComprobante;
    }

    public void setIdTipoComprobante(Integer idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Timbrados> getTimbradosList() {
        return timbradosList;
    }

    public void setTimbradosList(List<Timbrados> timbradosList) {
        this.timbradosList = timbradosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoComprobante != null ? idTipoComprobante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposComprobantes)) {
            return false;
        }
        TiposComprobantes other = (TiposComprobantes) object;
        if ((this.idTipoComprobante == null && other.idTipoComprobante != null) || (this.idTipoComprobante != null && !this.idTipoComprobante.equals(other.idTipoComprobante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TiposComprobantes[ idTipoComprobante=" + idTipoComprobante + " ]";
    }
    
}
