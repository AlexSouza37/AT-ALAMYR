import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AgendaUtils {

    /**
     * Lê o arquivo e retorna o Contatinho com o nome especificado, ou null se não encontrar.
     * @param fileName nome do arquivo (ex: contatinhos.txt)
     * @param nomePesquisado nome do contato a procurar
     * @return Contatinho ou null
     */
    public static Contatinho buscarContatinhoPorNome(String fileName, String nomePesquisado) {
        File f = new File(fileName);
        if (!f.exists()) {
            System.out.println("Arquivo não encontrado: " + fileName);
            return null;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] parts = linha.split("#", -1);
                if (parts.length >= 4) {
                    String nome = parts[0];
                    if (nome.equalsIgnoreCase(nomePesquisado)) { // compara ignorando caixa
                        String email = parts[1];
                        String telefone = parts[2];
                        String categoria = parts[3];
                        return new Contatinho(nome, email, telefone, categoria);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
        }
        return null; // não encontrou
    }

    // exemplo de uso
    public static void main(String[] args) {
        Contatinho c = buscarContatinhoPorNome("contatinhos.txt", "Nick Ferreira");
        if (c != null) {
            System.out.println("Encontrado: " + c.getNome() + ", " + c.getEmail() + ", " + c.getTelefone() + ", " + c.getCategoria());
        } else {
            System.out.println("Contato não encontrado.");
        }
    }
}
