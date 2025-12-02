import java.util.InputMismatchException; // Importa a classe de erro de formato
import java.util.Scanner;

public class Exercicio01Excecao {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int numero = 0;
        boolean entradaCorreta = false;

        // Loop 'while' para repetir enquanto a entrada não for correta
        while (!entradaCorreta) {
            try {
                System.out.println("Por favor, digite um número inteiro:");
                
                // --- Bloco TRY: Tenta executar o código que pode dar erro ---
                numero = leitor.nextInt();
                
                // Se chegou aqui, é porque deu certo!
                entradaCorreta = true; 

            } catch (InputMismatchException erro) {
                // --- Bloco CATCH: Captura o erro (InputMismatchException) se ele ocorrer ---
                
                System.out.println("\nOpa… Acho que você se enganou! Digite novamente…");
                System.out.println("Detalhe do erro: " + erro.getMessage());
                
                // Limpa o que o usuário digitou de errado, para que o 'Scanner' possa ler a próxima linha
                leitor.nextLine(); 
            }
        }

        // Se saiu do 'while', o número é válido.
        long quadrado = (long) numero * numero;
        System.out.println("\n-------------------------------------------");
        System.out.println("O quadrado de " + numero + " é: " + quadrado);
        System.out.println("-------------------------------------------");

        leitor.close();
    }
}