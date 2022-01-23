package util;

import bancodigial.Moeda;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import model.Transacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LeitorRemessaDelimitado extends LeitorRemessa{

    public List<Transacao> converter (String caminhoArquivo){
        System.out.println("IMPLEMENTACAO DELIMITADA");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        List<String> conteudos = ler(caminhoArquivo);
        List<Transacao> transacaos = new ArrayList();

        for (String linha: conteudos){
            String[] campos =linha.split(";");
            Transacao t = new Transacao();
            t.setCpf(campos[1]);
            t.setNome(campos[2]);
            t.setValorVendido(Double.valueOf(campos[4]));
            t.setTaxaCambio(Double.valueOf(campos[5]));
            t.setValorComprado(Double.valueOf(campos[7]));
            t.setMoedaVenda(Moeda.valueOf(campos[3].toUpperCase()));
            t.setMoedaCompra(Moeda.valueOf(campos[6].toUpperCase()));

            String date = campos[0];
            LocalDate data = LocalDate.parse(date, formatter);
            t.setDataTransacao(data);

            transacaos.add(t);
        }

        return transacaos;
    }
}
