package util;

import model.Transacao;

public class TransacaoPrint {
    public void imprimir(Transacao transacao) {
        StringBuilder cupom = new StringBuilder();

        cupom.append("----------------------------------\n");
        cupom.append("SIS CAMBIO - COMPROVANTE DE TRANSACAO\n");
        cupom.append("TRANSACAO DE CAMBIO\n");
        cupom.append("----------------------------------\n");
        //Justificando a esquerda conforme largura especificada (-10)
        cupom.append(String.format("%-10s%s\n","NOME:", transacao.getNome()));
        cupom.append(String.format("%-10s%s\n","CPF:", FormaterUtil.cpf(transacao.getCpf())));
        cupom.append("----------------------------------\n");
        cupom.append(String.format("%-10s%s\n","VENDIDO:", FormaterUtil.moeda(transacao.getValorVendido(), transacao.getMoedaVenda())));
        cupom.append(String.format("%-10s%s", "COMPRADO:", FormaterUtil.moeda(transacao.getValorComprado(), transacao.getMoedaCompra())));

        System.out.println(cupom);
    }
}
