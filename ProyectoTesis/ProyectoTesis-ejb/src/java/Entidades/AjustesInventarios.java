/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrea Salinas
 */
@Entity
@Table(name = "ajustes_inventarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AjustesInventarios.findAll", query = "SELECT a FROM AjustesInventarios a"),
    @NamedQuery(name = "AjustesInventarios.findByIdAjusteInventario", query = "SELECT a FROM AjustesInventarios a WHERE a.idAjusteInventario = :idAjusteInventario"),
    @NamedQuery(name = "AjustesInventarios.findByMotivo", query = "SELECT a FROM AjustesInventarios a WHERE a.motivo = :motivo"),
    @NamedQuery(name = "AjustesInventarios.findByExistenciaFisica", query = "SELECT a FROM AjustesInventarios a WHERE a.existenciaFisica = :existenciaFisica"),
    @NamedQuery(name = "AjustesInventarios.findByExistenciaTeorica", query = "SELECT a FROM AjustesInventarios a WHERE a.existenciaTeorica = :existenciaTeorica"),
    @NamedQuery(name = "AjustesInventarios.findByEstado", query = "SELECT a FROM AjustesInventarios a WHERE a.estado = :estado")})
public class AjustesInventarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ajuste_inventario")
    private Integer idAjusteInventario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "motivo")
    private String motivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "existencia_fisica")
    private BigInteger existenciaFisica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "existencia_teorica")
    private BigInteger existenciaTeorica;
    @Size(max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @JoinColumns({
        @JoinColumn(name = "id_producto", referencedColumnName = "id_producto"),
        @JoinColumn(name = "id_deposito", referencedColumnName = "id_deposito")})
    @ManyToOne(optional = false)
    private Stock stock;
    @JoinColumns({
        @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal"),
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToOne(optional = false)
    private UsuariosSucursales usuariosSucursales;

    public AjustesInventarios() {
    }

    public AjustesInventarios(Integer idAjusteInventario) {
        this.idAjusteInventario = idAjusteInventario;
    }

    public AjustesInventarios(Integer idAjusteInventario, String motivo, BigInteger existenciaFisica, BigInteger existenciaTeorica) {
        this.idAjusteInventario = idAjusteInventario;
        this.motivo = motivo;
        this.existenciaFisica = existenciaFisica;
        this.existenciaTeorica = existenciaTeorica;
    }

    public Integer getIdAjusteInventario() {
        return idAjusteInventario;
    }

    public void setIdAjusteInventario(Integer idAjusteInventario) {
        this.idAjusteInventario = idAjusteInventario;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public BigInteger getExistenciaFisica() {
        return existenciaFisica;
    }

    public void setExistenciaFisica(BigInteger existenciaFisica) {
        this.existenciaFisica = existenciaFisica;
    }

    public BigInteger getExistenciaTeorica() {
        return existenciaTeorica;
    }

    public void setExistenciaTeorica(BigInteger existenciaTeorica) {
        this.existenciaTeorica = existenciaTeorica;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public UsuariosSucursales getUsuariosSucursales() {
        return usuariosSucursales;
    }

    public void setUsuariosSucursales(UsuariosSucursales usuariosSucursales) {
        this.usuariosSucursales = usuariosSucursales;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAjusteInventario != null ? idAjusteInventario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AjustesInventarios)) {
            return false;
        }
        AjustesInventarios other = (AjustesInventarios) object;
        if ((this.idAjusteInventario == null && other.idAjusteInventario != null) || (this.idAjusteInventario != null && !this.idAjusteInventario.equals(other.idAjusteInventario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.AjustesInventarios[ idAjusteInventario=" + idAjusteInventario + " ]";
    }
    
}
