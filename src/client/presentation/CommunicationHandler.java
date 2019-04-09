/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.presentation;

import client.communication.CommunicationInterface;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oliver
 */
public class CommunicationHandler {
    private static CommunicationHandler communicationHandler;
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
        List<String[]> sampleData = new ArrayList<>();
        sampleData.add(new String[]{"dummy","dummy2"});
        return sampleData;
    }
    
}
