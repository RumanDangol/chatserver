/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.MyServer.Command;

import com.leapfrog.MyServer.Handler.Client;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author ruman dangol
 */
public class PublilcMessageCommand extends ChatCommand {

    @Override
    public void execute(Client client, String msg) throws IOException {
        for (Client c : handler.getClients()) {
            PrintStream writer = new PrintStream(c.getSocket().getOutputStream());
            writer.println(client.getUserName() + "says >" + msg);

        }

    }
}
 

