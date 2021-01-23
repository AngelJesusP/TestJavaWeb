
package app.web.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para agregarCliente complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="agregarCliente">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nm_cliente" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cd_cliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dn_nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dn_direccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dn_email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecha_baja" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cd_usuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="s_activo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cd_telefono" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ds_contacto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ds_logo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "agregarCliente", propOrder = {
    "nmCliente",
    "cdCliente",
    "dnNombre",
    "dnDireccion",
    "dnEmail",
    "fechaBaja",
    "cdUsuario",
    "sActivo",
    "cdTelefono",
    "dsContacto",
    "dsLogo"
})
public class AgregarCliente {

    @XmlElement(name = "nm_cliente")
    protected Integer nmCliente;
    @XmlElement(name = "cd_cliente")
    protected String cdCliente;
    @XmlElement(name = "dn_nombre")
    protected String dnNombre;
    @XmlElement(name = "dn_direccion")
    protected String dnDireccion;
    @XmlElement(name = "dn_email")
    protected String dnEmail;
    @XmlElement(name = "fecha_baja")
    protected String fechaBaja;
    @XmlElement(name = "cd_usuario")
    protected String cdUsuario;
    @XmlElement(name = "s_activo")
    protected String sActivo;
    @XmlElement(name = "cd_telefono")
    protected String cdTelefono;
    @XmlElement(name = "ds_contacto")
    protected String dsContacto;
    @XmlElement(name = "ds_logo")
    protected String dsLogo;

    /**
     * Obtiene el valor de la propiedad nmCliente.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNmCliente() {
        return nmCliente;
    }

    /**
     * Define el valor de la propiedad nmCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNmCliente(Integer value) {
        this.nmCliente = value;
    }

    /**
     * Obtiene el valor de la propiedad cdCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdCliente() {
        return cdCliente;
    }

    /**
     * Define el valor de la propiedad cdCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdCliente(String value) {
        this.cdCliente = value;
    }

    /**
     * Obtiene el valor de la propiedad dnNombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDnNombre() {
        return dnNombre;
    }

    /**
     * Define el valor de la propiedad dnNombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDnNombre(String value) {
        this.dnNombre = value;
    }

    /**
     * Obtiene el valor de la propiedad dnDireccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDnDireccion() {
        return dnDireccion;
    }

    /**
     * Define el valor de la propiedad dnDireccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDnDireccion(String value) {
        this.dnDireccion = value;
    }

    /**
     * Obtiene el valor de la propiedad dnEmail.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDnEmail() {
        return dnEmail;
    }

    /**
     * Define el valor de la propiedad dnEmail.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDnEmail(String value) {
        this.dnEmail = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaBaja.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaBaja() {
        return fechaBaja;
    }

    /**
     * Define el valor de la propiedad fechaBaja.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaBaja(String value) {
        this.fechaBaja = value;
    }

    /**
     * Obtiene el valor de la propiedad cdUsuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdUsuario() {
        return cdUsuario;
    }

    /**
     * Define el valor de la propiedad cdUsuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdUsuario(String value) {
        this.cdUsuario = value;
    }

    /**
     * Obtiene el valor de la propiedad sActivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSActivo() {
        return sActivo;
    }

    /**
     * Define el valor de la propiedad sActivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSActivo(String value) {
        this.sActivo = value;
    }

    /**
     * Obtiene el valor de la propiedad cdTelefono.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdTelefono() {
        return cdTelefono;
    }

    /**
     * Define el valor de la propiedad cdTelefono.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdTelefono(String value) {
        this.cdTelefono = value;
    }

    /**
     * Obtiene el valor de la propiedad dsContacto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDsContacto() {
        return dsContacto;
    }

    /**
     * Define el valor de la propiedad dsContacto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDsContacto(String value) {
        this.dsContacto = value;
    }

    /**
     * Obtiene el valor de la propiedad dsLogo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDsLogo() {
        return dsLogo;
    }

    /**
     * Define el valor de la propiedad dsLogo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDsLogo(String value) {
        this.dsLogo = value;
    }

}
