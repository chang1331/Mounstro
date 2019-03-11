/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author JGUTIERRGARC
 */
public class MulticastServer {

    public static void main(String args[]) throws InterruptedException {

        MulticastSocket s = null;
        try {

            InetAddress group = InetAddress.getByName("228.5.6.7"); // destination multicast group 
            s = new MulticastSocket(6789);
            s.joinGroup(group);

            ///System.out.println("Messages' TTL (Time-To-Live): "+ s.getTimeToLive());
            while (true) {

                int idMonstruo = 0;
                Random r = new Random();
                Monstruo monstruo = new Monstruo(idMonstruo, r.nextInt(8), r.nextInt(1));
                String monstruoS = monstruo.toString();
                byte[] m = monstruoS.getBytes();
                DatagramPacket messageOut
                        = new DatagramPacket(m, m.length, group, 6789);
                s.send(messageOut);
                Thread.sleep(2000);
                idMonstruo++;

            }

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    

}
