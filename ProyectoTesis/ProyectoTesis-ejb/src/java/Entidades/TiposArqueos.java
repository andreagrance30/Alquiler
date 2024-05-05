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
@Table(name = "tipos_arqueos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposArqueos.findAll", query = "SELECT t FROM TiposArqueos t"),
    @NamedQuery(name = "TiposArqueos.findByIdTipoArqueo", query = "SELECT t FROM TiposArqueos t WHERE t.idTipoArqueo = :idTipoArqueo"),
    @NamedQuery(name = "TiposArqueos.findByDescripcion", query = "SELECT t FROM TiposArqueos t WHERE t.descripcion = :descripcion")})
public class TiposArqueos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_arqueo")
    private Integer idTipoArqueo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoArqueo")
    private List<ArqueosCajas> arqueosCajasList;

    public TiposArqueos() {
    }

    public TiposArqueos(Integer idTipoArqueo) {
        this.idTipoArqueo = idTipoArqueo;
    }

    public TiposArqueos(Integer idTipoArqueo, String descripcion) {
        this.idTipoArqueo = idTipoArqueo;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoArqueo() {
        return idTipoArqueo;
    }

    public void setIdTipoArqueo(Integer idTipoArqueo) {
        this.idTipoArqueo = idTipoArqueo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<ArqueosCajas> getArqueosCajasList() {
        return arqueosCajasList;
    }

    public void setArqueosCajasList(List<ArqueosCajas> arqueosCajasList) {
        this.arqueosCajasList = arqueosCajasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoArqueo != null ? idTipoArqueo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposArqueos)) {
            return false;
        }
        TiposArqueos other = (TiposArqueos) object;
        if ((this.idTipoArqueo == null && other.idTipoArqueo != null) || (this.idTipoArqueo != null && !this.idTipoArqueo.equals(other.idTipoArqueo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TiposArqueos[ idTipoArqueo=" + idTipoArqueo + " ]";
    }
    
}
