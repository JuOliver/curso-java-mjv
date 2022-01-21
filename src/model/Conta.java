package model;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private List<Historico> historicos = new ArrayList<>();
    private double saldo;
    private String nomeCorrentista;
    private String numero;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNomeCorrentista() {
        return nomeCorrentista;
    }

    public void setNomeCorrentista(String nomeCorrentista) {
        this.nomeCorrentista = nomeCorrentista;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Historico> getHistoricos() {
        return historicos;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "nomeCorrentista='" + nomeCorrentista + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
