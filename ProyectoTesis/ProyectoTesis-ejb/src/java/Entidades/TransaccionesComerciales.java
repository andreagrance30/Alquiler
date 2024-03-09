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
@Table(name = "transacciones_comerciales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransaccionesComerciales.findAll", query = "SELECT t FROM TransaccionesComerciales t"),
    @NamedQuery(name = "TransaccionesComerciales.findByIdTransaccionComercial", query = "SELECT t FROM TransaccionesComerciales t WHERE t.idTransaccionComercial = :idTransaccionComercial"),
    @NamedQuery(name = "TransaccionesComerciales.findByDescripcion", query = "SELECT t FROM TransaccionesComerciales t WHERE t.descripcion = :descripcion")})
public class TransaccionesComerciales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_transaccion_comercial")
    private Integer idTransaccionComercial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transaccionesComerciales")
    private List<CobrosFormasDet> cobrosFormasDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transaccionesComerciales")
    private List<ArqueosCajasDet> arqueosCajasDetList;

    public TransaccionesComerciales() {
    }

    public TransaccionesComerciales(Integer idTransaccionComercial) {
        this.idTransaccionComercial = idTransaccionComercial;
    }

    public TransaccionesComerciales(Integer idTransaccionComercial, String descripcion) {
        this.idTransaccionComercial = idTransaccionComercial;
        this.descripcion = descripcion;
    }

    public Integer getIdTransaccionComercial() {
        return idTransaccionComercial;
    }

    public void setIdTransaccionComercial(Integer idTransaccionComercial) {
        this.idTransaccionComercial = idTransaccionComercial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<CobrosFormasDet> getCobrosFormasDetList() {
        return cobrosFormasDetList;
    }

    public void setCobrosFormasDetList(List<CobrosFormasDet> cobrosFormasDetList) {
        this.cobrosFormasDetList = cobrosFormasDetList;
    }

    @XmlTransient
    public List<ArqueosCajasDet> getArqueosCajasDetList() {
        return arqueosCajasDetList;
    }

    public void setArqueosCajasDetList(List<ArqueosCajasDet> arqueosCajasDetList) {
        this.arqueosCajasDetList = arqueosCajasDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransaccionComercial != null ? idTransaccionComercial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransaccionesComerciales)) {
            return false;
        }
        TransaccionesComerciales other = (TransaccionesComerciales) object;
        if ((this.idTransaccionComercial == null && other.idTransaccionComercial != null) || (this.idTransaccionComercial != null && !this.idTransaccionComercial.equals(other.idTransaccionComercial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TransaccionesComerciales[ idTransaccionComercial=" + idTransaccionComercial + " ]";
    }
    
}
