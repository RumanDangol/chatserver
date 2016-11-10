/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.MyServer.Handler;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ruman dangol
 */
public class ClientHandler {
    private List<Client> clients=new ArrayList<>();
    public void addClient(Client c){
        clients.add(c);
    }
    public boolean removeClient(Client client){
        
        for(Client c: clients){
            if(c.equals(clients)){
                clients.remove(c);
                return true;
            }
        }
        return false;
        
    }
    
    public List<Client> getClients(){
        return clients;
    }
    public Client getByUserName(String userName){
         for(Client c: clients){
            if(c.getUserName().equalsIgnoreCase(userName)){
                
                return c;
            }
        }
        return null;
    }
     public Client getBySocket(Socket s){
         for(Client c: clients){
            if(c.getSocket().equals(s)){
               
                return c;
            }
        }
        return null;
    }
}
