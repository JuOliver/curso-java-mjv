package bancodigial;

public enum Moeda {
    USD("$"),
    BRL("R$");

    private String simbolo;
    private Moeda(String simbolo){
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }
}
