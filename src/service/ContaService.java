package service;

import model.Conta;
import model.Historico;

public class ContaService {
    public void depositar(Conta conta, double valorDepositado) {
        conta.setSaldo(conta.getSaldo() + valorDepositado);
        conta.getHistoricos().add(new Historico("21/01", valorDepositado, "DEPOSITO"));
    }

    public void sacar(Conta conta, double valorSacado) {
        conta.setSaldo(conta.getSaldo() - valorSacado);
        conta.getHistoricos().add(new Historico("20/01", valorSacado,"SAQUE"));
    }

    public void exibirExtrato(Conta conta) {
        for (Historico historico: conta.getHistoricos()){
            System.out.println(historico.getData()
            + "-" + historico.getTipoOperacao()
            + "-" + historico.getValor());
        }
    }
}
