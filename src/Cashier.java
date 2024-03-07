import javax.swing.*;

public class Cashier {
    private static int option;

    private static Account a = new Account();

    public static void main(String[] args) {
        int option = 0;

        while (option != 4) {
            try {
                option = Integer.parseInt(JOptionPane.showInputDialog("Escoja la opción deseada " +
                        "\n 1. Saldo \n 2. Ingreso \n 3. Retiro \n 4. Salir"));

                if (option == 1) {
                    JOptionPane.showMessageDialog(null, "Ha escogido la opción 1. Saldo");
                    obtainBalance();
                } else if (option == 2) {
                    JOptionPane.showMessageDialog(null, "Ha escogido la opción 2. Ingreso");
                    depositMoney();
                } else if (option == 3) {
                    JOptionPane.showMessageDialog(null, "Ha escogido la opción 3. Retiro");
                    extractMoney();
                } else if (option == 4) {
                    JOptionPane.showMessageDialog(null, "Ha escogido la opción 4. Salir");
                } else {
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, ingrese una opción válida.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "[ERROR]: Por favor, teclee una opción válida.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    public static void depositMoney() {
        int quantity = requestQuantity();
        a.setBalance(quantity);
        JOptionPane.showMessageDialog(null, "Tu saldo ahora es de: " + a.getBalance() + " euros.");
    }

    public static void extractMoney() {
        int quantity = requestQuantity();
        if (a.getBalance() < quantity) {
            JOptionPane.showMessageDialog(null, "No puedes sacar más dinero del que tienes.");
        } else {
            a.setBalance(quantity * -1);
            JOptionPane.showMessageDialog(null, "Tu saldo ahora es de: " + a.getBalance() + " euros.");
        }
    }

    public static void obtainBalance() {
        JOptionPane.showMessageDialog(null, "Tu saldo es de: " + a.getBalance() + " euros");
    }

    public static int requestQuantity() {
        int quantity = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                String input = JOptionPane.showInputDialog("Teclee la cantidad a extraer/ingresar:");
                quantity = Integer.parseInt(input);

                if(quantity > 0) {
                    validInput = true;
                } else {
                    JOptionPane.showMessageDialog(null,"[ERROR]: Por favor, teclee un número entero positivo.","Error de entrada", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"[ERROR]: Por favor, teclee una cantidad válida.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
            }
        }
        return quantity;
    }
}