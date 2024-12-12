import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner ler = new Scanner(System.in);
        String usuarios[][] = new String[100][4];
        boolean dentroDoPrograma = true;
        int index = 0;
        do {

            boolean emExecucao = true;
            String nome = "";
            String senha = "";
            boolean temSenha = false;
            String confirmarSenha;
            String saldo = "1000.00";

            System.out.println("Olá, digite seu nome");
            nome = ler.nextLine();
            // ler.nextLine();
            System.out.println("Digite sua senha (somente números)");
            senha = ler.nextLine();    

            for(int i = 0; i<usuarios.length; i++){
                if (usuarios[i][0] != null && usuarios[i][0].equals(nome) &&
                    usuarios[i][1] != null && usuarios[i][1].equals(senha)) {
                    index = i;
                    temSenha = true;
                    nome = usuarios[i][0];
                    senha = usuarios[i][1];
                    saldo = usuarios[i][2];
                    break;
                }
            }   
            if(!temSenha){
            
                usuarios[index][0] = nome;
                usuarios[index][1] = senha;
                usuarios[index][2] = "1000.00";
                usuarios[index][3] = "1";
            }
            
            
            
            while (emExecucao) {
                System.out.println("Olá " + nome + "!");
                System.out.println("Saldo: " + saldo);
                System.out.println("-----------------------");
                System.out.println("Depositar (1) \n" +
                                "Sacar (2) \n" +
                                "Sair (3)");

                int escolha = ler.nextInt();
                ler.nextLine();
                // System.out.println(escolha);
                switch (escolha) {
                    case 1:
                        System.out.println("Quanto quer depositar?");
                        double deposito = ler.nextDouble();
                        saldo = Double.toString(Double.parseDouble(saldo) + deposito);
                        usuarios[index][2] = saldo;

                        break;
                    case 2:
                        System.out.println("Digite sua senha");
                        confirmarSenha = ler.nextLine();
                        if(confirmarSenha.equals(senha) != true){
                            while (confirmarSenha.equals(senha) != true) {
                                System.out.println("Senha incorreta,");
                                System.out.println("Digite sua senha");
                                confirmarSenha = ler.nextLine();
                            }
                        }
                        System.out.println("Quanto quer sacar?");
                        double saque = ler.nextDouble();
                        while (saque > Double.parseDouble(saldo)) {
                            System.out.println("Saque insuficiente");
                            saque = ler.nextDouble();
                        }
                        saldo = Double.toString(Double.parseDouble(saldo) - saque);
                        usuarios[index][2] = saldo;
                        break;
                    case 3:
                        for(int i = 0; i< usuarios.length; i++){
                            if(usuarios[i][0] == null){
                                index = i;
                                break;
                            }
                        }
                        emExecucao = false;
                        break;
                
                    default:
                        break;
                }
            }
        } while (dentroDoPrograma);
        
    }
}
