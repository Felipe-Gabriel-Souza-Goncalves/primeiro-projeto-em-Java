import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner ler = new Scanner(System.in);
        boolean emExecucao = true;
        String nome;
        int senha;
        boolean temSenha = false;
        int confirmarSenha;
        double saldo = 1000.00;


        System.out.println("Olá, digite seu nome");
        nome = ler.nextLine();
        // ler.nextLine();
        System.out.println("Digite sua senha (somente números)");
        senha = ler.nextInt();
        while (emExecucao) {
            System.out.println("Olá " + nome + "!");
            System.out.println("Saldo: " + saldo);
            System.out.println("-----------------------");
            System.out.println("Depositar (1) \n" +
                               "Sacar (2) \n" +
                               "Sair (3)");
            int escolha = ler.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Quanto quer depositar?");
                    saldo += ler.nextDouble();
                    break;
                case 2:
                    System.out.println("Digite sua senha");
                    confirmarSenha = ler.nextInt();
                    if(confirmarSenha != senha){
                        while (confirmarSenha != senha) {
                            System.out.println("Senha incorreta,");
                            System.out.println("Digite sua senha");
                            confirmarSenha = ler.nextInt();
                        }
                    }
                    System.out.println("Quanto quer sacar?");
                    double saque = ler.nextDouble();
                    while (saque > saldo) {
                        System.out.println("Saque insuficiente");
                        saque = ler.nextFloat();
                    }
                    saldo -= saque;
                    break;
                case 3:
                    emExecucao = false;
                    break;
            
                default:
                    break;
            }
        }
    }
}
