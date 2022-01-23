package util;

import model.Transacao;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public abstract class LeitorRemessa {
/*
Obs: se tiver algum metodo abstract, a classe precisa ser abstract. Porem, a classe pode ser abstract,
mas pode conter metodos que não são.
 */
    public abstract List<Transacao> converter (String caminhoArquivo);

    //com protected somente as classes herdeiras podem visualiza-la
    protected List<String> ler(String caminhoArquivo){
        try{
            List<String> transacoes = Files.readAllLines(Paths.get(caminhoArquivo), StandardCharsets.UTF_8);
            return transacoes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
