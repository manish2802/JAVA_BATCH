
package com.service.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getWheatherResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getWheatherResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gw" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getWheatherResponse", propOrder = {
    "gw"
})
public class GetWheatherResponse {

    protected String gw;

    /**
     * Gets the value of the gw property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGw() {
        return gw;
    }

    /**
     * Sets the value of the gw property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGw(String value) {
        this.gw = value;
    }

}
