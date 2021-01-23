
package app.web.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the app.web.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BuscarClienteResponse_QNAME = new QName("http://webService.web.app/", "buscarClienteResponse");
    private final static QName _AgregarClienteResponse_QNAME = new QName("http://webService.web.app/", "agregarClienteResponse");
    private final static QName _ActualizarClienteResponse_QNAME = new QName("http://webService.web.app/", "actualizarClienteResponse");
    private final static QName _ListarCliente_QNAME = new QName("http://webService.web.app/", "listarCliente");
    private final static QName _AgregarCliente_QNAME = new QName("http://webService.web.app/", "agregarCliente");
    private final static QName _ElimiarCliente_QNAME = new QName("http://webService.web.app/", "elimiarCliente");
    private final static QName _ActualizarCliente_QNAME = new QName("http://webService.web.app/", "actualizarCliente");
    private final static QName _ElimiarClienteResponse_QNAME = new QName("http://webService.web.app/", "elimiarClienteResponse");
    private final static QName _ListarClienteResponse_QNAME = new QName("http://webService.web.app/", "listarClienteResponse");
    private final static QName _BuscarCliente_QNAME = new QName("http://webService.web.app/", "buscarCliente");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: app.web.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AgregarCliente }
     * 
     */
    public AgregarCliente createAgregarCliente() {
        return new AgregarCliente();
    }

    /**
     * Create an instance of {@link ElimiarCliente }
     * 
     */
    public ElimiarCliente createElimiarCliente() {
        return new ElimiarCliente();
    }

    /**
     * Create an instance of {@link ActualizarCliente }
     * 
     */
    public ActualizarCliente createActualizarCliente() {
        return new ActualizarCliente();
    }

    /**
     * Create an instance of {@link ElimiarClienteResponse }
     * 
     */
    public ElimiarClienteResponse createElimiarClienteResponse() {
        return new ElimiarClienteResponse();
    }

    /**
     * Create an instance of {@link ListarClienteResponse }
     * 
     */
    public ListarClienteResponse createListarClienteResponse() {
        return new ListarClienteResponse();
    }

    /**
     * Create an instance of {@link BuscarCliente }
     * 
     */
    public BuscarCliente createBuscarCliente() {
        return new BuscarCliente();
    }

    /**
     * Create an instance of {@link ListarCliente }
     * 
     */
    public ListarCliente createListarCliente() {
        return new ListarCliente();
    }

    /**
     * Create an instance of {@link ActualizarClienteResponse }
     * 
     */
    public ActualizarClienteResponse createActualizarClienteResponse() {
        return new ActualizarClienteResponse();
    }

    /**
     * Create an instance of {@link BuscarClienteResponse }
     * 
     */
    public BuscarClienteResponse createBuscarClienteResponse() {
        return new BuscarClienteResponse();
    }

    /**
     * Create an instance of {@link AgregarClienteResponse }
     * 
     */
    public AgregarClienteResponse createAgregarClienteResponse() {
        return new AgregarClienteResponse();
    }

    /**
     * Create an instance of {@link ThomClienteEntity }
     * 
     */
    public ThomClienteEntity createThomClienteEntity() {
        return new ThomClienteEntity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.web.app/", name = "buscarClienteResponse")
    public JAXBElement<BuscarClienteResponse> createBuscarClienteResponse(BuscarClienteResponse value) {
        return new JAXBElement<BuscarClienteResponse>(_BuscarClienteResponse_QNAME, BuscarClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.web.app/", name = "agregarClienteResponse")
    public JAXBElement<AgregarClienteResponse> createAgregarClienteResponse(AgregarClienteResponse value) {
        return new JAXBElement<AgregarClienteResponse>(_AgregarClienteResponse_QNAME, AgregarClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.web.app/", name = "actualizarClienteResponse")
    public JAXBElement<ActualizarClienteResponse> createActualizarClienteResponse(ActualizarClienteResponse value) {
        return new JAXBElement<ActualizarClienteResponse>(_ActualizarClienteResponse_QNAME, ActualizarClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.web.app/", name = "listarCliente")
    public JAXBElement<ListarCliente> createListarCliente(ListarCliente value) {
        return new JAXBElement<ListarCliente>(_ListarCliente_QNAME, ListarCliente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.web.app/", name = "agregarCliente")
    public JAXBElement<AgregarCliente> createAgregarCliente(AgregarCliente value) {
        return new JAXBElement<AgregarCliente>(_AgregarCliente_QNAME, AgregarCliente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ElimiarCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.web.app/", name = "elimiarCliente")
    public JAXBElement<ElimiarCliente> createElimiarCliente(ElimiarCliente value) {
        return new JAXBElement<ElimiarCliente>(_ElimiarCliente_QNAME, ElimiarCliente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.web.app/", name = "actualizarCliente")
    public JAXBElement<ActualizarCliente> createActualizarCliente(ActualizarCliente value) {
        return new JAXBElement<ActualizarCliente>(_ActualizarCliente_QNAME, ActualizarCliente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ElimiarClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.web.app/", name = "elimiarClienteResponse")
    public JAXBElement<ElimiarClienteResponse> createElimiarClienteResponse(ElimiarClienteResponse value) {
        return new JAXBElement<ElimiarClienteResponse>(_ElimiarClienteResponse_QNAME, ElimiarClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.web.app/", name = "listarClienteResponse")
    public JAXBElement<ListarClienteResponse> createListarClienteResponse(ListarClienteResponse value) {
        return new JAXBElement<ListarClienteResponse>(_ListarClienteResponse_QNAME, ListarClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.web.app/", name = "buscarCliente")
    public JAXBElement<BuscarCliente> createBuscarCliente(BuscarCliente value) {
        return new JAXBElement<BuscarCliente>(_BuscarCliente_QNAME, BuscarCliente.class, null, value);
    }

}
