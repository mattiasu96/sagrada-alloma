package Network.Client;

import Network.Shared.SharedMainClient;
import Network.Shared.SharedNetwork;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class mainClient implements SharedMainClient {
    private static final String SERVER_IP = "localhost";
    private String CLIENT_IP;
    public static final Integer RMI_PORT = 1099;
    public static final Integer SOCKET_PORT = 1101;
    public static final String RMI_IFACE_NAME = "Network";

    public mainClient() {
        super();
        try {
            this.CLIENT_IP = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public String getClientIp() {
        return CLIENT_IP;
    }

    public void printMessage(String s) {
        System.out.println(s);
    }

    public static void main(String [] args) throws NotBoundException, RemoteException {
        // Look for the RMI registry on specific server port
        Registry rmiRegistry = LocateRegistry.getRegistry(SERVER_IP, RMI_PORT);
        // Get a reference to the remote instance of Network, through SharedNetwork interface
        SharedNetwork netIface = (SharedNetwork) rmiRegistry.lookup(RMI_IFACE_NAME);
        System.out.println("Connecting...");

        // Create instance of client from its shared interface
        SharedMainClient myClient = new mainClient();
        // Inform the registry about symbolic server name
        System.setProperty("java.rmi.server.hostname", myClient.getClientIp());
        // Setup permissive security policy - yay haxorz come in
        System.setProperty("java.rmi.server.useCodebaseOnly", "false");
        // Export the object listener on anonymous port
        UnicastRemoteObject.exportObject(myClient,0);
        // Call method on remote object passing the local reference
        netIface.connect(myClient);

        // Close connection on command
        Scanner scan = new Scanner(System.in);
        while (!scan.nextLine().equals("exit")) {
            //
        }
        System.exit(0);
    }
}
