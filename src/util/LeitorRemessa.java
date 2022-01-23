package util;

import bancodigial.Moeda;
import model.Transacao;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LeitorRemessa {
    private List<String> ler(String caminhoArquivo){
        try{
            List<String> transacoes = Files.readAllLines(Paths.get(caminhoArquivo), StandardCharsets.UTF_8);
            return transacoes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Transacao> converter (String caminhoArquivo){
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
