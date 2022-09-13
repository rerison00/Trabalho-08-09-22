import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Random random = new Random();
        Scanner sc1 = new Scanner(System.in);
        Hashtable<String, Cliente> clientes = new Hashtable<String, Cliente>();
        Hashtable<String, ContaCorrente> conta = new Hashtable<String, ContaCorrente>();
        Hashtable<String, ContaPoupanca> contap = new Hashtable<String, ContaPoupanca>();
        String opcao = "-";
        String nome;
        String cpf = null;
        String contanumero = null;
        Double saldo = null;
        String agencia = null;
        String senha = null;
        Double sacar, depositar;
        Integer tipoconta;

        do{
            System.out.println("Bem vindo ao Sistema do Banco");
            System.out.println("Opcao 1: Adicionar novo Cliente");
            System.out.println("Opcao 2: Buscar Cliente");
            System.out.println("Opcao 3: Criar Conta");
            System.out.println("Opcao 4: Verificar Conta");
            System.out.println("Opcao 5: Depositar");
            System.out.println("Opcao 6: Sacar");
            System.out.println("Opcao 0: Encerrar");
            try {

                opcao = sc1.next();

                switch (opcao) {
                    case "1":
                        System.out.println("Adicionar novo Cliente");
                        System.out.println("Digite Nome: ");
                        nome = sc1.next();
                        System.out.println("Digite CPF: ");
                        cpf = sc1.next();
                        Cliente cliente = new Cliente(nome,cpf);
                        clientes.put(cliente.getCpf(), cliente);
                        break;
                    case "2":
                        System.out.println("Digite o CPF do Cliente que deseja procurar");
                        cpf = sc1.next();
                        Cliente clientepesquisado = clientes.get(cpf);
                        System.out.println(clientepesquisado.getNome());
                            break;
                    case "3":
                        System.out.println("Tipo de conta que deseja criar: 1 para corrente 2 para poupanca");
                        tipoconta = sc1.nextInt();
                        if(tipoconta == 1){
                            System.out.println("CORRENTE SELECIONADA");
                            System.out.println("Digite CPF do cliente que deseja criar a conta");
                            cpf = sc1.next();
                            if(!clientes.containsKey(cpf)){
                                System.out.println("Cliente nao existe");
                                break;
                            }else{
                                if(conta.containsKey(cpf)){
                                    System.out.println("Conta ja existe!");
                                    break;
                                }
                            }
                            contanumero = String.valueOf(random.nextInt(999999));
                            agencia = "123";
                            saldo = 100.00;
                            System.out.println("Conta numero: " + contanumero);
                            System.out.println("Agencia Numero: " + agencia);
                            System.out.println("Saldo Inicial: " + saldo);
                            System.out.println("Digite a senha da conta: ");
                            senha = sc1.next();
                            ContaCorrente contaCorrente = new ContaCorrente(contanumero,saldo,agencia,senha,cpf);
                            conta.put(cpf, contaCorrente);
                            break;
                        } else if (tipoconta == 2) {
                            System.out.println("POUPANCA SELECIONADA");
                            System.out.println("Digite CPF do cliente que deseja criar a conta");
                            cpf = sc1.next();
                            if(!clientes.containsKey(cpf)){
                                System.out.println("Cliente nao existe");
                                break;
                            }else{
                                if(contap.containsKey(cpf)){
                                    System.out.println("Conta ja existe!");
                                    break;
                                }
                            }
                            contanumero = String.valueOf(random.nextInt(999999));
                            agencia = "123";
                            saldo = 100.00;
                            System.out.println("Conta numero: " + contanumero);
                            System.out.println("Agencia Numero: " + agencia);
                            System.out.println("Saldo Inicial: " + saldo);
                            System.out.println("Digite a senha da conta: ");
                            senha = sc1.next();
                            ContaPoupanca contaPoupanca = new ContaPoupanca(contanumero,saldo,agencia,senha,cpf);
                            contap.put(cpf, contaPoupanca);
                            break;
                        }else {
                            System.out.println("Tipo de conta nao existe");
                            break;
                        }
                    case "4":
                        System.out.println("Tipo de conta que deseja visualizar: 1 para corrente 2 para poupanca");
                        tipoconta = sc1.nextInt();
                        if(tipoconta == 1){
                            System.out.println("CORRENTE SELECIONADA");
                            System.out.println("Digite o CPF do cliente para verificar a conta");
                            cpf = sc1.next();
                            ContaCorrente contapesquisada = conta.get(cpf);
                            System.out.println("Conta: "+contapesquisada.getConta());
                            System.out.println("Agencia: "+contapesquisada.getAgencia());
                            System.out.println("Saldo: "+contapesquisada.getSaldo());
                            System.out.println("Senha: "+contapesquisada.getSenha());
                        } else if (tipoconta == 2) {
                            System.out.println("POUPANCA SELECIONADA");
                            System.out.println("Digite o CPF do cliente para verificar a conta");
                            cpf = sc1.next();
                            ContaPoupanca contapesquisada2 = contap.get(cpf);
                            System.out.println("Conta: "+contapesquisada2.getConta());
                            System.out.println("Agencia: "+contapesquisada2.getAgencia());
                            System.out.println("Saldo: "+contapesquisada2.getSaldo());
                            System.out.println("Senha: "+contapesquisada2.getSenha());
                        }else {
                            System.out.println("Tipo de conta nao existe");
                        }
                        break;
                    case "5":
                        System.out.println("Tipo de conta que deseja depositar: 1 para corrente 2 para poupanca");
                        sc1 = new Scanner(System.in);
                        tipoconta = sc1.nextInt();
                        if(tipoconta == 1){
                            System.out.println("Digite o CPF da conta que deseja depositar");
                            cpf = sc1.next();
                            if(conta.containsKey(cpf)){
                                ContaCorrente contaCorrente1 = conta.get(cpf);
                                System.out.println("Digite a agencia da conta");
                                agencia = sc1.next();
                                if(!agencia.equals(contaCorrente1.getAgencia())){
                                    System.out.println("Agencia nao existe");
                                    break;
                                }
                                System.out.println("Digite o numero da conta");
                                contanumero = sc1.next();
                                if(!contanumero.equals(contaCorrente1.getConta())){
                                    System.out.println("Conta nao existe");
                                    break;
                                }
                                System.out.println("Digite o valor que deseja depositar");
                                depositar = sc1.nextDouble();
                                contaCorrente1.creditar(depositar);
                                break;
                            }
                        }else if (tipoconta == 2) {
                            System.out.println("Digite o CPF da conta que deseja depositar");
                            cpf = sc1.next();
                            if(conta.containsKey(cpf)) {
                                ContaPoupanca contaPoupanca = contap.get(cpf);
                                System.out.println("Digite a agencia da conta");
                                agencia = sc1.next();
                                if (!agencia.equals(contaPoupanca.getAgencia())) {
                                    System.out.println("Agencia nao existe");
                                    break;
                                }
                                System.out.println("Digite o numero da conta");
                                contanumero = sc1.next();
                                if (!contanumero.equals(contaPoupanca.getConta())) {
                                    System.out.println("Conta nao existe");
                                    break;
                                }
                                System.out.println("Digite o valor que deseja depositar");
                                depositar = sc1.nextDouble();
                                contaPoupanca.creditar(depositar);
                                break;
                            }
                        }
                        break;
                    case "6":
                        System.out.println("Tipo de conta que deseja depositar: 1 para corrente 2 para poupanca");
                        sc1 = new Scanner(System.in);
                        tipoconta = sc1.nextInt();
                        if(tipoconta == 1){
                            System.out.println("Digite o CPF da conta que deseja sacar");
                            cpf = sc1.next();
                            if(conta.containsKey(cpf)){
                                System.out.println("Digite a agencia da conta");
                                agencia = sc1.next();
                                ContaCorrente contaCorrente1 = conta.get(cpf);
                                if(!agencia.equals(contaCorrente1.getAgencia())){
                                    System.out.println("Agencia nao existe");
                                    break;
                                }
                                System.out.println("Digite o numero da conta");
                                contanumero = sc1.next();
                                if(!contanumero.equals(contaCorrente1.getConta())){
                                    System.out.println("Conta nao existe");
                                    break;
                                }
                                System.out.println("Digite o valor que deseja sacar");
                                sacar = sc1.nextDouble();
                                contaCorrente1.debitar(sacar);
                                break;
                            }
                        } else if (tipoconta == 2) {
                            System.out.println("Digite o CPF da conta que deseja sacar");
                            cpf = sc1.next();
                            if(conta.containsKey(cpf)){
                                System.out.println("Digite a agencia da conta");
                                agencia = sc1.next();
                                ContaPoupanca contaPoupanca1 = contap.get(cpf);
                                if(!agencia.equals(contaPoupanca1.getAgencia())){
                                    System.out.println("Agencia nao existe");
                                    break;
                                }
                                System.out.println("Digite o numero da conta");
                                contanumero = sc1.next();
                                if(!contanumero.equals(contaPoupanca1.getConta())){
                                    System.out.println("Conta nao existe");
                                    break;
                                }
                                System.out.println("Digite o valor que deseja sacar");
                                sacar = sc1.nextDouble();
                                contaPoupanca1.debitar(sacar);
                                break;
                            }
                        }

                        break;
                    case "0":
                        System.out.println("Programa encerrado");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Valor digitado incorreto");
                        break;
                }
            }catch(Exception ex){
                System.out.println("Valor digitado invalido");
            }

        }while(!opcao.equals("0"));
    }
}