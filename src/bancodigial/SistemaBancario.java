package bancodigial;

import model.Conta;
import repository.ContaRepository;
import service.ContaService;

import java.util.*;

public class SistemaBancario {
    public static void main(String[] args) {
        OrdenandoArray();
    }

    public static void OrdenandoArray(){
        List<String> nomes = new ArrayList<>();
        nomes.add("LUNA");
        nomes.add("MARIA");
        nomes.add("FERNANDA");
        Collections.sort(nomes);
        for (String nome: nomes){
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

        Set<Conta>contas = repository.getContas();
        for (Conta conta : contas){
            System.out.println(conta);
        }
    }

    public static void exemploSacarDepositar() {
        Conta conta = new Conta();
        ContaService terminal = new ContaService();
        terminal.depositar(conta, 50.0);
        System.out.println(conta.getSaldo());
    }
}
