import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;


// Implémentation du serveur RMI
public class CalculatorServer extends UnicastRemoteObject implements CalculatorInterface {

    // Constructeur de la classe serveur
    public CalculatorServer() throws RemoteException {
        super();
    }

    // Implémentation des méthodes de calcul définies dans l'interface
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    public int subtract(int a, int b) throws RemoteException {
        return a - b;
    }

    public int multiply(int a, int b) throws RemoteException {
        return a * b;
    }

    public int divide(int a, int b) throws RemoteException {
        if (b != 0) {
            return a / b;
        } else {
            throw new ArithmeticException("Impossible de diviser par zéro");
        }
    }

    // Méthode principale pour lancer le serveur
    public static void main(String[] args) {
        try {
            // Création de l'instance du serveur
            CalculatorServer server = new CalculatorServer();
            // Création et liaison avec le registre RMI sur le port 1099
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("CalculatorService", server);
            System.out.println("Serveur prêt.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
