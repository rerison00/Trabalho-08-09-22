public class ContaCorrente {
    private String conta;
    protected Double saldo;
    private String agencia;
    private String senha;
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getConta() {
        return conta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public ContaCorrente(String conta, Double saldo, String agencia, String senha, String cpf) {
        this.conta = conta;
        this.saldo = saldo;
        this.agencia = agencia;
        this.senha = senha;
        this.cpf = cpf;
    }
    public ContaCorrente(Double saldo) {
        this.saldo = saldo;
    }

    public void creditar(Double saldo) {
        if (saldo <= 0.0)
            throw  new RuntimeException("Valor Invalido");

        this.saldo += saldo;

    }

    public void debitar(Double saldo) {
        if (saldo <= 0.0)
            throw new RuntimeException("Valor Invalido");

        if ((this.saldo - saldo) <= 0.0)
            throw new RuntimeException("Valor Invalido para Debito");

        this.saldo -= saldo;
    }
}

