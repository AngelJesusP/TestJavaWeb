/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.com.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author angel
 */
@Entity
@Table(name = "thom_cliente")
@NamedQueries({
    @NamedQuery(name = "ThomClienteEntity.findAll", query = "SELECT t FROM ThomClienteEntity t")})
public class ThomClienteEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nm_cliente")
    private Integer nmCliente;
    @Size(max = 15)
    @Column(name = "cd_cliente")
    private String cdCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "dn_nombre")
    private String dnNombre;
    @Size(max = 120)
    @Column(name = "dn_direccion")
    private String dnDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "dn_email")
    private String dnEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "cd_usuario")
    private String cdUsuario;
    @Size(max = 1)
    @Column(name = "s_activo")
    private String sActivo;
    @Size(max = 60)
    @Column(name = "cd_telefono")
    private String cdTelefono;
    @Size(max = 120)
    @Column(name = "ds_contacto")
    private String dsContacto;
    @Size(max = 50)
    @Column(name = "ds_logo")
    private String dsLogo;

    public ThomClienteEntity() {
    }

    public ThomClienteEntity(Integer nmCliente) {
        this.nmCliente = nmCliente;
    }

    public ThomClienteEntity(Integer nmCliente, String dnNombre, String dnEmail, Date fechaRegistro, Date fechaBaja, String cdUsuario) {
        this.nmCliente = nmCliente;
        this.dnNombre = dnNombre;
        this.dnEmail = dnEmail;
        this.fechaRegistro = fechaRegistro;
        this.fechaBaja = fechaBaja;
        this.cdUsuario = cdUsuario;
    }

    public Integer getNmCliente() {
        return nmCliente;
    }

    public void setNmCliente(Integer nmCliente) {
        this.nmCliente = nmCliente;
    }

    public String getCdCliente() {
        return cdCliente;
    }

    public void setCdCliente(String cdCliente) {
        this.cdCliente = cdCliente;
    }

    public String getDnNombre() {
        return dnNombre;
    }

    public void setDnNombre(String dnNombre) {
        this.dnNombre = dnNombre;
    }

    public String getDnDireccion() {
        return dnDireccion;
    }

    public void setDnDireccion(String dnDireccion) {
        this.dnDireccion = dnDireccion;
    }

    public String getDnEmail() {
        return dnEmail;
    }

    public void setDnEmail(String dnEmail) {
        this.dnEmail = dnEmail;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(String cdUsuario) {
        this.cdUsuario = cdUsuario;
    }

    public String getSActivo() {
        return sActivo;
    }

    public void setSActivo(String sActivo) {
        this.sActivo = sActivo;
    }

    public String getCdTelefono() {
        return cdTelefono;
    }

    public void setCdTelefono(String cdTelefono) {
        this.cdTelefono = cdTelefono;
    }

    public String getDsContacto() {
        return dsContacto;
    }

    public void setDsContacto(String dsContacto) {
        this.dsContacto = dsContacto;
    }

    public String getDsLogo() {
        return dsLogo;
    }

    public void setDsLogo(String dsLogo) {
        this.dsLogo = dsLogo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nmCliente != null ? nmCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThomClienteEntity)) {
            return false;
        }
        ThomClienteEntity other = (ThomClienteEntity) object;
        if ((this.nmCliente == null && other.nmCliente != null) || (this.nmCliente != null && !this.nmCliente.equals(other.nmCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.com.Entity.ThomClienteEntity[ nmCliente=" + nmCliente + " ]";
    }
    
}
