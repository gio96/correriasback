//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.10.06 at 12:52:39 AM COT 
//


package com.ceiba.infraestructura.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.demo package. 
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

    private final static QName _QueryTCRM_QNAME = new QName("http://action.trm.services.generic.action.superfinanciera.nexura.sc.com.co/", "queryTCRM");
    private final static QName _QueryTCRMResponse_QNAME = new QName("http://action.trm.services.generic.action.superfinanciera.nexura.sc.com.co/", "queryTCRMResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.demo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link com.ceiba.infraestructura.soap.QueryTCRM }
     * 
     */
    public com.ceiba.infraestructura.soap.QueryTCRM createQueryTCRM() {
        return new com.ceiba.infraestructura.soap.QueryTCRM();
    }

    /**
     * Create an instance of {@link QueryTCRMResponse }
     * 
     */
    public QueryTCRMResponse createQueryTCRMResponse() {
        return new QueryTCRMResponse();
    }

    /**
     * Create an instance of {@link com.ceiba.infraestructura.soap.TcrmResponse }
     * 
     */
    public com.ceiba.infraestructura.soap.TcrmResponse createTcrmResponse() {
        return new com.ceiba.infraestructura.soap.TcrmResponse();
    }

    /**
     * Create an instance of {@link com.ceiba.infraestructura.soap.Tcrm }
     * 
     */
    public com.ceiba.infraestructura.soap.Tcrm createTcrm() {
        return new com.ceiba.infraestructura.soap.Tcrm();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link com.ceiba.infraestructura.soap.QueryTCRM }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link com.ceiba.infraestructura.soap.QueryTCRM }{@code >}
     */
    @XmlElementDecl(namespace = "http://action.trm.services.generic.action.superfinanciera.nexura.sc.com.co/", name = "queryTCRM")
    public JAXBElement<com.ceiba.infraestructura.soap.QueryTCRM> createQueryTCRM(com.ceiba.infraestructura.soap.QueryTCRM value) {
        return new JAXBElement<com.ceiba.infraestructura.soap.QueryTCRM>(_QueryTCRM_QNAME, com.ceiba.infraestructura.soap.QueryTCRM.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryTCRMResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link QueryTCRMResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://action.trm.services.generic.action.superfinanciera.nexura.sc.com.co/", name = "queryTCRMResponse")
    public JAXBElement<QueryTCRMResponse> createQueryTCRMResponse(QueryTCRMResponse value) {
        return new JAXBElement<QueryTCRMResponse>(_QueryTCRMResponse_QNAME, QueryTCRMResponse.class, null, value);
    }

}
