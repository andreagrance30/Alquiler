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
@Table(name = "tipos_cheques")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposCheques.findAll", query = "SELECT t FROM TiposCheques t"),
    @NamedQuery(name = "TiposCheques.findByIdTipoCheque", query = "SELECT t FROM TiposCheques t WHERE t.idTipoCheque = :idTipoCheque"),
    @NamedQuery(name = "TiposCheques.findByDescripcion", query = "SELECT t FROM TiposCheques t WHERE t.descripcion = :descripcion")})
public class TiposCheques implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_cheque")
    private Integer idTipoCheque;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoCheque")
    private List<CobrosCheques> cobrosChequesList;

    public TiposCheques() {
    }

    public TiposCheques(Integer idTipoCheque) {
        this.idTipoCheque = idTipoCheque;
    }

    public TiposCheques(Integer idTipoCheque, String descripcion) {
        this.idTipoCheque = idTipoCheque;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoCheque() {
        return idTipoCheque;
    }

    public void setIdTipoCheque(Integer idTipoCheque) {
        this.idTipoCheque = idTipoCheque;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<CobrosCheques> getCobrosChequesList() {
        return cobrosChequesList;
    }

    public void setCobrosChequesList(List<CobrosCheques> cobrosChequesList) {
        this.cobrosChequesList = cobrosChequesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCheque != null ? idTipoCheque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposCheques)) {
            return false;
        }
        TiposCheques other = (TiposCheques) object;
        if ((this.idTipoCheque == null && other.idTipoCheque != null) || (this.idTipoCheque != null && !this.idTipoCheque.equals(other.idTipoCheque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TiposCheques[ idTipoCheque=" + idTipoCheque + " ]";
    }
    
}
