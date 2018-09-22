
package com.service.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.service.ws package. 
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

    private final static QName _GetWheather2_QNAME = new QName("http://ws.service.com/", "getWheather2");
    private final static QName _GetWheatherResponse_QNAME = new QName("http://ws.service.com/", "getWheatherResponse");
    private final static QName _GetWheather_QNAME = new QName("http://ws.service.com/", "getWheather");
    private final static QName _GetWheather2Response_QNAME = new QName("http://ws.service.com/", "getWheather2Response");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.service.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetWheather }
     * 
     */
    public GetWheather createGetWheather() {
        return new GetWheather();
    }

    /**
     * Create an instance of {@link GetWheather2Response }
     * 
     */
    public GetWheather2Response createGetWheather2Response() {
        return new GetWheather2Response();
    }

    /**
     * Create an instance of {@link GetWheather2 }
     * 
     */
    public GetWheather2 createGetWheather2() {
        return new GetWheather2();
    }

    /**
     * Create an instance of {@link GetWheatherResponse }
     * 
     */
    public GetWheatherResponse createGetWheatherResponse() {
        return new GetWheatherResponse();
    }

    /**
     * Create an instance of {@link WheatherVO }
     * 
     */
    public WheatherVO createWheatherVO() {
        return new WheatherVO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWheather2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.service.com/", name = "getWheather2")
    public JAXBElement<GetWheather2> createGetWheather2(GetWheather2 value) {
        return new JAXBElement<GetWheather2>(_GetWheather2_QNAME, GetWheather2 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWheatherResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.service.com/", name = "getWheatherResponse")
    public JAXBElement<GetWheatherResponse> createGetWheatherResponse(GetWheatherResponse value) {
        return new JAXBElement<GetWheatherResponse>(_GetWheatherResponse_QNAME, GetWheatherResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWheather }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.service.com/", name = "getWheather")
    public JAXBElement<GetWheather> createGetWheather(GetWheather value) {
        return new JAXBElement<GetWheather>(_GetWheather_QNAME, GetWheather.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWheather2Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.service.com/", name = "getWheather2Response")
    public JAXBElement<GetWheather2Response> createGetWheather2Response(GetWheather2Response value) {
        return new JAXBElement<GetWheather2Response>(_GetWheather2Response_QNAME, GetWheather2Response.class, null, value);
    }

}
