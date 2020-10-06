package com.ceiba.infraestructura.controlador;

import com.ceiba.infraestructura.soap.ObjectFactory;
import com.ceiba.infraestructura.soap.QueryTCRM;
import com.ceiba.infraestructura.soap.QueryTCRMResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class TcrmCliente extends WebServiceGatewaySupport {

    public QueryTCRMResponse getTcrm() {
        ObjectFactory objectFactory = new ObjectFactory();
        QueryTCRM queryTCRM = objectFactory.createQueryTCRM();

        try {
            XMLGregorianCalendar xmlGregorianCalendar =
                    DatatypeFactory.newInstance().newXMLGregorianCalendar("2019-04-25");
            queryTCRM.setTcrmQueryAssociatedDate(xmlGregorianCalendar);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        return (QueryTCRMResponse) getWebServiceTemplate()
                .marshalSendAndReceive("https://www.superfinanciera.gov.co/SuperfinancieraWebServiceTRM/TCRMServicesWebService/TCRMServicesWebService"
                        , queryTCRM);

    }
}
