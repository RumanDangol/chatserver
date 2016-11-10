/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.MyServer.Command;

import com.leapfrog.MyServer.Handler.Client;
import java.io.IOException;
import java.io.PrintStream;
import sun.net.www.http.ChunkedOutputStream;

/**
 *
 * @author ruman dangol
 */
public class ListCommand extends ChatCommand{

    @Override
    public void execute(Client client, String msg) throws IOException {
        PrintStream ps=new PrintStream(client.getSocket().getOutputStream());
        StringBuilder content=new StringBuilder();
        for(Client c:handler.getClients()){
            content.append(c.getUserName()).append("\r\n");
        }
        ps.println(content.toString());
    }
    
    
}
