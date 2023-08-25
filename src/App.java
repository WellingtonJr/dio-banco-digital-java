public class App {
    public static void main(String[] args) throws Exception {
        Cliente wellington = new Cliente();
        wellington.setNome("Wellington");

        Conta cc = new ContaCorrente(wellington);
        Conta poupanca = new ContaPoupanca(wellington);

        cc.depositar(420);
        cc.sacar(43);
        cc.depositar(1203);
        cc.transferir(300, poupanca);

        poupanca.sacar(50);
        poupanca.depositar(100);
        poupanca.sacar(400);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
