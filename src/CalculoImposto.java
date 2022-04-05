import java.util.Scanner;

public class CalculoImposto {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("\n\nBem vindo a SimCity!");
        System.out.println("Este é nosso sistema de cálculo de impostos para o presente ano.");
        
        double[] salarios = cadastrarSalarios(12);
        double[] impostosCalculados = calcularImposto(salarios);
        String[] dadosUsuario = new String[2];


        while (true) {
            System.out.println("\n\nPara mostrar o menu, digite [menu]:");
            String opcao = leitor.nextLine();

            if (opcao.equals("menu")) {
                mostrarMenu();

            } else if (opcao.equals("c")) {
                dadosUsuario = cadastrarUsuario();

            } else if (opcao.equals("m")) {
                mostrarDadosCadastrais(dadosUsuario);

            } else if (opcao.equals("s")) {
                mostrarSalarios(salarios);

            } else if (opcao.equals("i")) {
                mostrarImpostos(impostosCalculados);

            } else if (opcao.equals("sair")) {
                System.exit(0);
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }

    public static double[] cadastrarSalarios(int meses) {
        System.out.println("Por gentileza, cadastre os salários do ano:");
        Scanner leitor = new Scanner(System.in);

        double[] salariosDoAno = new double[meses];
        for (int i = 0; i < salariosDoAno.length; i++) {
            System.out.println("Digite o valor do " + (i + 1) + "º salário:");
            salariosDoAno[i] = leitor.nextDouble();
        }  
        return salariosDoAno;
    }

    public static double[] calcularImposto(double[] salarios) {
        double[] imposto = new double[salarios.length];
        for (int i = 0; i < salarios.length; i++) {
            if (salarios[i] <= 2000.00) {
                imposto[i] = 0;
            } else if (salarios[i] <= 3000.00) {
                imposto[i] = salarios[i] * 8 / 100;
            } else if (salarios[i] <= 4500.00) {
                imposto[i] = salarios[i] * 18 / 100;
            } else {
                imposto[i] = salarios[i] * 28 / 100;
            }
        }
        return imposto;
    }

    public static void mostrarMenu(){
        System.out.println("\n\nMenu:");
        System.out.println("Para cadastrar seus dados, digite [c]:");
        System.out.println("Para mostrar seus dados cadastrais, digite [m]:");
        System.out.println("Para mostrar os salários cadastrados, digite [s]:");
        System.out.println("Para calcular o imposto de cada mês, digite [i]:");
        System.out.println("Para sair do sistema, digite [sair]:");
    }

    public static String[] cadastrarUsuario() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite seu nome:");
        String[] dados = new String[2];
        dados[0] = leitor.nextLine();

        System.out.println("Digite sua profissão:");
        dados[1] = leitor.nextLine();
        return dados;
    }

    public static void mostrarDadosCadastrais(String[] dados) {
        if (dados[0] != null && dados[1] != null) {
            System.out.println("Nome: " + dados[0]);
            System.out.println("Profissão: " + dados[1]);
            System.out.println();

        } else {
            System.out.println("------ATENÇÃO------");
            System.out.println("Cadastre todos os dados primeiro usando a opção [c].\n");
        }
    }

    public static void mostrarSalarios(double[] vetorSalarios) {
        System.out.println("------Salários por mês------\n");
        for (int i = 0; i < vetorSalarios.length; i++) {
            System.out.print("mês " + (i + 1) + ": ");
            System.out.printf("%.2f", vetorSalarios[i]);
            System.out.println();
        }
        System.out.println();
    }

    public static void mostrarImpostos(double[] vetorImpostos) {
        System.out.println("------Impostos por mês------\n");
        for (int i = 0; i < vetorImpostos.length; i++) {
            System.out.print("mês " + (i + 1) + ": ");
            System.out.printf("%.2f", vetorImpostos[i]);
            System.out.println();
        }
        System.out.println();
    }
}