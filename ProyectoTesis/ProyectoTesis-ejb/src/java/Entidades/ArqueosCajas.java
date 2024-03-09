/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andrea Salinas
 */
@Entity
@Table(name = "arqueos_cajas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArqueosCajas.findAll", query = "SELECT a FROM ArqueosCajas a"),
    @NamedQuery(name = "ArqueosCajas.findByIdArqueoCaja", query = "SELECT a FROM ArqueosCajas a WHERE a.idArqueoCaja = :idArqueoCaja"),
    @NamedQuery(name = "ArqueosCajas.findByFecha", query = "SELECT a FROM ArqueosCajas a WHERE a.fecha = :fecha")})
public class ArqueosCajas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_arqueo_caja")
    private Integer idArqueoCaja;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_apertura_cierre_caja", referencedColumnName = "id_apertura_cierre_caja")
    @ManyToOne(optional = false)
    private AperturaCierreCaja idAperturaCierreCaja;
    @JoinColumn(name = "id_tipo_arqueo", referencedColumnName = "id_tipo_arqueo")
    @ManyToOne(optional = false)
    private TiposArqueos idTipoArqueo;
    @JoinColumns({
        @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal"),
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToOne(optional = false)
    private UsuariosSucursales usuariosSucursales;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "arqueosCajas")
    private List<ArqueosCajasDet> arqueosCajasDetList;

    public ArqueosCajas() {
    }

    public ArqueosCajas(Integer idArqueoCaja) {
        this.idArqueoCaja = idArqueoCaja;
    }

    public ArqueosCajas(Integer idArqueoCaja, Date fecha) {
        this.idArqueoCaja = idArqueoCaja;
        this.fecha = fecha;
    }

    public Integer getIdArqueoCaja() {
        return idArqueoCaja;
    }

    public void setIdArqueoCaja(Integer idArqueoCaja) {
        this.idArqueoCaja = idArqueoCaja;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public AperturaCierreCaja getIdAperturaCierreCaja() {
        return idAperturaCierreCaja;
    }

    public void setIdAperturaCierreCaja(AperturaCierreCaja idAperturaCierreCaja) {
        this.idAperturaCierreCaja = idAperturaCierreCaja;
    }

    public TiposArqueos getIdTipoArqueo() {
        return idTipoArqueo;
    }

    public void setIdTipoArqueo(TiposArqueos idTipoArqueo) {
        this.idTipoArqueo = idTipoArqueo;
    }

    public UsuariosSucursales getUsuariosSucursales() {
        return usuariosSucursales;
    }

    public void setUsuariosSucursales(UsuariosSucursales usuariosSucursales) {
        this.usuariosSucursales = usuariosSucursales;
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
        hash += (idArqueoCaja != null ? idArqueoCaja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArqueosCajas)) {
            return false;
        }
        ArqueosCajas other = (ArqueosCajas) object;
        if ((this.idArqueoCaja == null && other.idArqueoCaja != null) || (this.idArqueoCaja != null && !this.idArqueoCaja.equals(other.idArqueoCaja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ArqueosCajas[ idArqueoCaja=" + idArqueoCaja + " ]";
    }
    
}
