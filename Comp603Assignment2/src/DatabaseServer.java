
import org.apache.derby.drda.NetworkServerControl;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseServer {

    //start apache derby database server
    public static void startDerbyServer() {
        try {
            NetworkServerControl server = new NetworkServerControl(InetAddress.getByName("localhost"), 1527);  //create a derby network server control object to manage the server at localhost on port 1527
            server.start(null);  //start the derby server
            System.out.println("Derby Network Server started on port 1527.");
            
            boolean serverReady = false;
            while (!serverReady) {  //while loop to wait until the server is ready to accept connections
                try {
                    server.ping();  //ping the server to check if it's ready
                    serverReady = true;  //if the ping is successful, the server is ready
                    System.out.println("Derby Network Server is ready for connections.");
                } catch (Exception e) {
                    System.out.println("Waiting for Derby server to be ready...");  //if ping fails try again after 1 second
                    Thread.sleep(1000);  //wait 1 second
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(DatabaseServer.class.getName()).log(Level.SEVERE, "Error starting Derby server", ex);
        }
    }
}
