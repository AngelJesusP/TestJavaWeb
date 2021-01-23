
package app.web.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para thomClienteEntity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="thomClienteEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cdCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cdTelefono" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cdUsuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dnDireccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dnEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dnNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dsContacto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dsLogo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaBaja" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="nmCliente" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="SActivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "thomClienteEntity", propOrder = {
    "cdCliente",
    "cdTelefono",
    "cdUsuario",
    "dnDireccion",
    "dnEmail",
    "dnNombre",
    "dsContacto",
    "dsLogo",
    "fechaBaja",
    "fechaRegistro",
    "nmCliente",
    "sActivo"
})
public class ThomClienteEntity {

    protected String cdCliente;
    protected String cdTelefono;
    protected String cdUsuario;
    protected String dnDireccion;
    protected String dnEmail;
    protected String dnNombre;
    protected String dsContacto;
    protected String dsLogo;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaBaja;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaRegistro;
    protected Integer nmCliente;
    @XmlElement(name = "SActivo")
    protected String sActivo;

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

    /**
     * Obtiene el valor de la propiedad fechaBaja.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaBaja() {
        return fechaBaja;
    }

    /**
     * Define el valor de la propiedad fechaBaja.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaBaja(XMLGregorianCalendar value) {
        this.fechaBaja = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaRegistro.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Define el valor de la propiedad fechaRegistro.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaRegistro(XMLGregorianCalendar value) {
        this.fechaRegistro = value;
    }

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

}
