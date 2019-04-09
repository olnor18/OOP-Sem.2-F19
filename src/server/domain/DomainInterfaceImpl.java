/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.domain;

import java.util.List;
import server.persistance.PersistanceInterface;

/**
 *
 * @author Oliver
 */
public class DomainInterfaceImpl implements DomainInterface {
    
    private PersistanceInterface persistanceInterface;

    @Override
    public List<String[]> parseQuery(String[] query) {
        
    }
    
}
