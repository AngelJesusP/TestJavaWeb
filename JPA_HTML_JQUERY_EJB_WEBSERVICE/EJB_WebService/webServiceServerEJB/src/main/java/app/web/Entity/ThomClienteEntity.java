/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.web.Entity;

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

/**
 *
 * @author angel
 */
@Entity
@Table(name = "thom_cliente")
@NamedQueries({ @NamedQuery(name = "ThomClienteEntity.findAll", query = "SELECT t FROM ThomClienteEntity t") })
public class ThomClienteEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nm_cliente", nullable = false)
    private Integer nmCliente;
    
    @Column(name = "cd_cliente", length = 15)
    private String cdCliente;
    
    @Basic(optional = false)
    @Column(name = "dn_nombre", nullable = false, length = 120)
    private String dnNombre;
    
    @Column(name = "dn_direccion", length = 120)
    private String dnDireccion;
    
    @Basic(optional = false)
    @Column(name = "dn_email", nullable = false, length = 150)
    private String dnEmail;
    
    @Basic(optional = false)
    @Column(name = "fecha_registro", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    
    @Basic(optional = false)
    @Column(name = "fecha_baja", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;
    
    @Basic(optional = false)
    @Column(name = "cd_usuario", nullable = false, length = 120)
    private String cdUsuario;
    
    @Column(name = "s_activo", length = 1)
    private String sActivo;
    
    @Column(name = "cd_telefono", length = 60)
    private String cdTelefono;
    
    @Column(name = "ds_contacto", length = 120)
    private String dsContacto;
    
    @Column(name = "ds_logo", length = 50)
    private String dsLogo;

    public ThomClienteEntity() { }

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

    public Integer getNmCliente() { return nmCliente;    }
    public String getCdCliente()  { return cdCliente;    }
    public String getDnNombre()   { return dnNombre;     }
    public String getDnDireccion(){ return dnDireccion;  }
    public String getDnEmail()    { return dnEmail;      }
    public Date getFechaRegistro(){ return fechaRegistro;}
    public Date getFechaBaja()    { return fechaBaja;    }
    public String getCdUsuario()  { return cdUsuario;    }
    public String getSActivo()    { return sActivo;      }
    public String getCdTelefono() { return cdTelefono;   }
    public String getDsContacto() { return dsContacto;   }
    public String getDsLogo()     { return dsLogo;       }
    
    public void setNmCliente(Integer nmCli)   { this.nmCliente = nmCli;     }
    public void setCdCliente(String cdCli)    { this.cdCliente = cdCli;     }
    public void setDnNombre(String dnNombre)  { this.dnNombre = dnNombre;   }
    public void setDnDireccion(String dnDi)   { this.dnDireccion = dnDi;    }
    public void setDnEmail(String dnEmail)    { this.dnEmail = dnEmail;     }
    public void setFechaRegistro(Date fechaR) { this.fechaRegistro = fechaR;}
    public void setFechaBaja(Date fechaBaja)  {  this.fechaBaja = fechaBaja;}
    public void setCdUsuario(String cdUsuario){ this.cdUsuario = cdUsuario; }
    public void setSActivo(String sActivo)    { this.sActivo = sActivo;     }
    public void setCdTelefono(String cdTelef) { this.cdTelefono = cdTelef;  }
    public void setDsContacto(String dsConta) { this.dsContacto = dsConta;  }
    public void setDsLogo(String dsLogo)      {  this.dsLogo = dsLogo;      }

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
        return "app.web.Entity.ThomClienteEntity[ nmCliente=" + nmCliente + " ]";
    }    
}
