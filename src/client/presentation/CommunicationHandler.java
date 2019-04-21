/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.presentation;

import client.communication.CommunicationInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oliver
 */
public class CommunicationHandler {
    private static CommunicationHandler communicationHandler;
    private String name;
    private CommunicationInterface communicationInterface;
    
    private CommunicationHandler()
    {
        //communicationInterface = new CommunicationInterfaceImpl();
    }
    
    public static CommunicationHandler getInstance()
    {
        if (communicationHandler == null)
        {
            communicationHandler = new CommunicationHandler();
        }
        return communicationHandler;
    }
    
    public List<String[]> sendQuery(String[] query)
    {
        //return communicationInterface.sendQuery(query);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CommunicationHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<String[]> sampleData = new ArrayList<>();
        sampleData.add(new String[]{"Dummy McDummy","dummy2"});
        name = sampleData.get(0)[0];
        return sampleData;
    }
    
    public String getName()
    {
        return name;
    }
}
