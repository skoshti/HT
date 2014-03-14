
package net.restfulwebservices.servicecontracts._2008._01;

import javax.xml.ws.WebFault;
import faultcontracts.gotlservices._2008._01.DefaultFaultContract;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "DefaultFaultContract", targetNamespace = "http://GOTLServices.FaultContracts/2008/01")
public class IStockQuoteServiceGetWorldMajorIndicesDefaultFaultContractFaultFaultMessage
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private DefaultFaultContract faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public IStockQuoteServiceGetWorldMajorIndicesDefaultFaultContractFaultFaultMessage(String message, DefaultFaultContract faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public IStockQuoteServiceGetWorldMajorIndicesDefaultFaultContractFaultFaultMessage(String message, DefaultFaultContract faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: faultcontracts.gotlservices._2008._01.DefaultFaultContract
     */
    public DefaultFaultContract getFaultInfo() {
        return faultInfo;
    }

}
