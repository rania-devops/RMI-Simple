import java.rmi.*;
import java.util.Scanner;

// Classe du client RMI
public class CalculatorClient {

    public static void main(String[] args) {
        try {
            // Création d'un scanner pour la saisie utilisateur
            Scanner scanner = new Scanner(System.in);
            // Recherche de l'objet distant en utilisant l'URL RMI
            CalculatorInterface calculator = (CalculatorInterface) Naming.lookup("rmi://localhost/CalculatorService");

            // Boucle principale du client
            while (true) {
                System.out.println("Choisissez une opération :");
                System.out.println("1. Addition");
                System.out.println("2. Soustraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Quitter");

                // Lecture du choix de l'utilisateur
                int choice = scanner.nextInt();

                // Sortir de la boucle si l'utilisateur choisit de quitter
                if (choice == 5) {
                    System.out.println("Sortie...");
                    break;
                }

                // Lecture des opérandes
                System.out.println("Saisissez le premier opérande :");
                int operand1 = scanner.nextInt();

                System.out.println("Saisissez le deuxième opérande :");
                int operand2 = scanner.nextInt();

                int result = 0;

                // Sélection de l'opération en fonction du choix de l'utilisateur
                switch (choice) {
                    case 1:
                        result = calculator.add(operand1, operand2);
                        break;
                    case 2:
                        result = calculator.subtract(operand1, operand2);
                        break;
                    case 3:
                        result = calculator.multiply(operand1, operand2);
                        break;
                    case 4:
                        try {
                            result = calculator.divide(operand1, operand2);
                        } catch (ArithmeticException e) {
                            System.out.println("Erreur : " + e.getMessage());
                            continue;
                        }
                        break;
                    default:
                        System.out.println("Choix invalide");
                        continue;
                }

                // Affichage du résultat
                System.out.println("Résultat : " + result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
