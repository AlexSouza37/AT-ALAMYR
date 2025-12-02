EXERCÍCIO 1:



    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int numero = sc.nextInt();

        // cria o arquivo
        PrintWriter pw = new PrintWriter("tabuada_" + numero + ".txt");

        // escreve a tabuada
        for (int i = 1; i <= 10; i++) {
            pw.println(numero + " x " + i + " = " + (numero * i));
        }

        pw.close();
        sc.close();

        System.out.println("Tabuada salva com sucesso!");
    }
}
