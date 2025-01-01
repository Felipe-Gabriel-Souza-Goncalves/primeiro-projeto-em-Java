import java.util.Scanner;

/*
 * METAS: 
 *  - CRIAR GERENTE
 *  - MÁXIMO DE 3 VEZES DIGITAR SENHA ✓
 *  - BLOQUEAR CONTA SE MAIS Q 3 VEZES SENHA ✓
 * 
 * FUNCIONALIDADES (gerente):
 *  - DESBLOQUEAR CONTA DE USUÁRIO
 * 
 * 
 * 
 * 
 * 
 */

public class App {
    public static void main(String[] args) throws Exception {

        Scanner ler = new Scanner(System.in);
        String usuarios[][] = new String[100][4];
        String gerentes[][] = new String[10][2];
        // Boolean para executar/sair do sistema
        boolean dentroDoPrograma = true;
        // Variável para registro do usuário (criar se vazio, ler se não vazio)
        int index = 0;
        do {
            // Variáveis padrão de um usuário recém criado
            boolean emExecucao = true;
            String nome;
            String senha;
            String confirmarSenha;
            boolean usuarioExiste = false;
            String saldo = "1000.00";
            String contaBloqueada = "false";

            // Perguntas para login
            System.out.println("Olá, digite seu nome");
            nome = ler.nextLine();
            System.out.println("Digite sua senha (somente números)");
            senha = ler.nextLine();    

            for(int i = 0; i<usuarios.length; i++){
                // Verifica se o usuário existe 
                if (usuarios[i][0] != null && usuarios[i][0].equals(nome) &&
                    usuarios[i][1] != null && usuarios[i][1].equals(senha)) {
                    // faz o index atual ser do usuário
                    index = i;
                    usuarioExiste = true;
                    nome = usuarios[i][0];
                    senha = usuarios[i][1];
                    saldo = usuarios[i][2];
                    contaBloqueada = usuarios[i][3];
                    break;
                }
            }   
            if(contaBloqueada.equals("true")){
                System.out.println("Esse usuário está bloqueado.");
                // Vai para o primeiro index vazio
                for(int i = 0; i< usuarios.length; i++){
                    if(usuarios[i][0] == null){
                        index = i;
                        break;
                    }
                }
                continue;
            }
            if(!usuarioExiste){
                // Criar usuário com as informações fornecidas
                usuarios[index][0] = nome;
                usuarios[index][1] = senha;
                usuarios[index][2] = "1000.00";
                usuarios[index][3] = "false";
            }
            
            // Se o usuário existe e não está bloqueado:
            while (emExecucao) {
                System.out.println("Olá " + nome + "!");
                System.out.println("Saldo: " + saldo);
                System.out.println("-----------------------");
                System.out.println(
                                "Depositar (1) \n" +
                                "Sacar (2) \n" +
                                "Sair (3)");

                int escolha = ler.nextInt();
                ler.nextLine();

                switch (escolha) {
                    case 1: // case de Depósito
                        System.out.println("Quanto quer depositar?");
                        double deposito = ler.nextDouble();
                        saldo = Double.toString(Double.parseDouble(saldo) + deposito);
                        usuarios[index][2] = saldo;
                        break;

                    case 2: // case de Saque
                        // Tentativas de inserir senha
                        int senhaTentativa = 1;

                        System.out.println("Digite sua senha");
                        confirmarSenha = ler.nextLine();
                        // Confirma se senha está certa
                        if(confirmarSenha.equals(senha) != true){
                            while (confirmarSenha.equals(senha) != true) {

                                senhaTentativa++;
                                System.out.println("Senha incorreta,");
                                System.out.println("Digite sua senha");
                                confirmarSenha = ler.nextLine();

                                if(senhaTentativa >= 3){
                                    usuarios[index][3] = "true";
                                    break;
                                }
                            }
                        }
                        if(usuarios[index][3] == "true"){
                            System.out.println("Senha incorreta 3 vezes, será necessário desbloquear com o gerente");
                            emExecucao = false;
                            break;
                        }
                        senhaTentativa = 1;

                        System.out.println("Quanto quer sacar?");
                        double saque = ler.nextDouble();
                        // Verifica se saque é válido
                        while (saque > Double.parseDouble(saldo)) {
                            System.out.println("Saque insuficiente");
                            saque = ler.nextDouble();
                        }
                        // Faz o saque
                        saldo = Double.toString(Double.parseDouble(saldo) - saque);
                        usuarios[index][2] = saldo;
                        break;
                    case 3: // case de Sair do sistema
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
