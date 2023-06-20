package com.teste.job.service.impl;

import com.teste.job.model.Cliente;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ClientePag {

    public static final int ONE_DAY = 1;
    public static final int ONE_MONTH = 30 * ONE_DAY;
    public static final int ONE_YEAR = 12 * ONE_MONTH;

    public static final double ONE_DAY_VALUE = 50;
    public static final double ONE_MONTH_VALUE= 300;
    public static final double ONE_YEAR_VALUE = 3000;

    public static Double getValor(Cliente cliente){
        return getValor(cliente.getEntryDate(), cliente.getExitDate());
    }

    private static Double getValor(LocalDateTime entryDate, LocalDateTime exitDate) {
        long periodo = entryDate.until(exitDate, ChronoUnit.DAYS);
        Double valor = 0.0;
        if(periodo <= ONE_MONTH) {
            return ONE_MONTH_VALUE;
        }
        if(periodo <= ONE_YEAR){
            valor = ONE_YEAR_VALUE;
            int days = (int) (periodo / ONE_DAY);
            System.out.println(days);
            for (int i = 0; i < days; i++) {
                valor += ONE_DAY_VALUE;
            }
            return valor;
        }
        int anos = (int) (periodo / ONE_YEAR);
        System.out.println(anos);
        for (int i = 0; i < anos; i++) {
            valor += ONE_YEAR_VALUE;
        }
        return valor;
    }
}
