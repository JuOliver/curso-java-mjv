package util;

import bancodigial.Moeda;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormaterUtil {
    public static String moeda(Double valor, Moeda moeda) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        if (moeda == Moeda.BRL)
            symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
        DecimalFormat decimalFormat = new DecimalFormat("¤ ###,###.###", symbols);
        return decimalFormat.format(valor);
    }

    public static String cpf(String cpf) {
        String parte1 = cpf.substring(0, 3);
        String parte2 = cpf.substring(3, 6);
        String parte3 = cpf.substring(6, 9);
        String parte4 = cpf.substring(9, 11);
        String cpfFormatado = parte1.concat(".").concat(parte2).concat(".").concat(parte3).concat(".").concat(parte4);
        return cpfFormatado;
    }

    public static String data(LocalDateTime data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }
}

