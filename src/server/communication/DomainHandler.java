/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.communication;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 *
 * @author Oliver
 */
public class DomainHandler {
    private static DomainHandler domainHandler=null;
    private server.domain.DomainInterface domainInterface;
    private Lock lock;
    private Condition condition;
    
    DomainHandler(){
        domainInterface = new server.domain.DomainInterfaceImpl();
    }
    
    public static DomainHandler getDomainHandler(){
        if(domainHandler==null){
            domainHandler = new DomainHandler();
        }
        return domainHandler;
    }
    
    public List<String[]> parseQuery(String[] query){
        return domainHandler.parseQuery(query);
    }
}
