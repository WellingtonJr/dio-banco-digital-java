
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conta implements ContaInterface {

    private static int SEQUENCIAL = 1;

    protected String agencia;
    protected String numero;
    protected Cliente cliente;
    protected double saldo;
    protected List<Transacao> transacoes;

    public Conta(Cliente cliente) {
        this.agencia = "0001";
        this.numero = String.valueOf(SEQUENCIAL++);
        this.cliente = cliente;
        this.saldo = 0;
        this.transacoes = new ArrayList<>();
    }

    @Override
    public void sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            this.transacoes.add(new Transacao(TipoTransacao.SAQUE, valor));
            System.out.println("Saque realizado com sucesso! Saldo atual: " + this.saldo);
        } else {
            System.out.println("Erro ao sacar! Saldo insuficiente");
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            this.transacoes.add(new Transacao(TipoTransacao.DEPOSITO, valor));
            System.out.println("Deposito realizado com sucesso! Saldo atual: " + this.saldo);
        } else {
            System.out.println("Erro ao depositar! Nenhum valor foi depositado!");
        }

    }

    @Override
    public void transferir(double valor, ContaInterface contaDestino) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            contaDestino.depositar(valor);
            this.transacoes.add(new Transacao(TipoTransacao.TRANSFERENCIA, valor));
            System.out.println("Transferência realizada com sucesso! Saldo atual: " + this.saldo);
        } else {
            System.out.println("Erro ao realizar transferência! Saldo insuficiente!!");

        }
    }

    @Override
    public void imprimirExtrato() {
        // TODO
    }

}
