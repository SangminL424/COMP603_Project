
import org.apache.derby.drda.NetworkServerControl;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 64224
 */
public class DatabaseServer {

    public static void startDerbyServer() {
        try {
            NetworkServerControl server = new NetworkServerControl(InetAddress.getByName("localhost"), 1527);
            server.start(null);
            System.out.println("Derby Network Server started on port 1527.");

            // Wait for server to be ready
            boolean serverReady = false;
            while (!serverReady) {
                try {
                    server.ping();
                    serverReady = true;
                    System.out.println("Derby Network Server is ready for connections.");
                } catch (Exception e) {
                    System.out.println("Waiting for Derby server to be ready...");
                    Thread.sleep(1000);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(DatabaseServer.class.getName()).log(Level.SEVERE, "Error starting Derby server", ex);
        }
    }
}
