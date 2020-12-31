package ech0132.write;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import ch.ech.xmlns.ech_0058._5.Header;
import ch.ech.xmlns.ech_0129._4.InsuranceObjectOnlyType;
import ch.ech.xmlns.ech_0132._2.Delivery;
import ch.ech.xmlns.ech_0132._2.NewInsuranceobject;
import ch.ech.xmlns.ech_0132._2.ObjectFactory;

public class App {
    public String getGreeting() {        
        try {
            JAXBContext context = JAXBContext.newInstance(ch.ech.xmlns.ech_0132._2.ObjectFactory.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            Delivery delivery = new Delivery();
            Header header = new Header();
            header.setSenderId("http://kaso.so.ch");
            header.setTestDeliveryFlag(true);
            delivery.setDeliveryHeader(header);
            
            
            ObjectFactory factory = new ObjectFactory();
            NewInsuranceobject newInsuranceObject = factory.createNewInsuranceobject();
            newInsuranceObject.setEvent("1");
            
            InsuranceObjectOnlyType insuranceObjectOnlyType = new ch.ech.xmlns.ech_0129._4.ObjectFactory().createInsuranceObjectOnlyType();
            insuranceObjectOnlyType.setInsuranceNumber("abc");
            newInsuranceObject.setInsuranceObject(insuranceObjectOnlyType);
            
            delivery.setNewInsuranceobject(newInsuranceObject);
            
            
            OutputStream os = new FileOutputStream("/Users/stefan/tmp/fubar-ech-0132.xml");
            marshaller.marshal( delivery, os );
            
            
            
            
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        
        
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
