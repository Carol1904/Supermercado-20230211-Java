import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao sistema do mercado!");

        // Inicialize o scanner para interações no terminal
        Scanner scanner = new Scanner(System.in);

        // Exemplo básico para verificar se o programa roda
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Olá, " + nome + "!");

        // Feche o scanner
        scanner.close();
    }
}