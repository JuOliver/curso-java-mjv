package bancodigial;

import model.Conta;
import repository.ContaRepository;
import service.ContaService;
import util.LeitorRemessa;
import util.LeitorRemessaDelimitado;

import java.util.*;

import model.Transacao;
import util.LeitorRemessaPosicional;
import util.TransacaoPrint;

import static util.FormaterUtil.cep;

public class SistemaBancario {
    public static void main(String[] args) {
        cambio();

    }

    public static void cambio() {
        LeitorRemessa leitor = null;
        String caminho = "C:\\Users\\Juliana\\Documents\\DELREMESSA.csv";
        //aplicando polimorfismo para verificar como o arquivo será manipulado
        if (caminho.contains("DEL")){
            leitor = new LeitorRemessaDelimitado();
        } else {
            leitor = new LeitorRemessaPosicional();
        }

        List<Transacao> transacoes = leitor.converter(caminho);

        TransacaoPrint print = new TransacaoPrint();
        for (Transacao t : transacoes) {
            print.imprimir(t);
        }
    }

    public static void OrdenandoArray() {
        List<String> nomes = new ArrayList<>();
        nomes.add("LUNA");
        nomes.add("MARIA");
        nomes.add("FERNANDA");
        Collections.sort(nomes);
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }

    public static void exemploRepositorio() {
        ContaRepository repository = new ContaRepository();
        Conta contaJuliana = new Conta();
        contaJuliana.setNomeCorrentista("Juliana");
        contaJuliana.setNumero("8874-4");
        repository.adicionarConta(contaJuliana);

        Conta contaLuna = new Conta();
        contaLuna.setNomeCorrentista("Luna de Oliveira");
        contaLuna.setNumero("5574-4");
        repository.adicionarConta(contaLuna);

        Conta contaMaria = new Conta();
        contaMaria.setNomeCorrentista("Maria Helena");
        contaMaria.setNumero("5574-4");
        repository.adicionarConta(contaMaria);

        Set<Conta> contas = repository.getContas();
        for (Conta conta : contas) {
            System.out.println(conta);
        }
    }

    public static void exemploSacarDepositar() {
        Conta conta = new Conta();
        ContaService terminal = new ContaService();
        terminal.depositar(conta, 50.0);
        System.out.println(conta.getSaldo());
        terminal.exibirExtrato(conta);
    }
}
