public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println();

        System.out.println("Cliente: " + this.cliente.getNome());
        System.out.println("Agencia: " + this.agencia);
        System.out.println("Numero: " + this.numero);
        System.out.println("Saldo Atual: " + this.saldo);
        System.out.println("==========IMPRIMINDO EXTRATO==========");
        for (Transacao transacao : this.transacoes) {
            System.out.println(transacao.getTipoTransacao() + " : " +
                    transacao.getValor());
        }
    }

}
