package br.com.desafio.utils;

import java.util.Calendar;
import java.util.Random;

public class GeradorDeDados {

    public static String data() {
        Random random = new Random();
        Calendar cal = Calendar.getInstance();
        int day = random.nextInt(28) + 1;
        int month = random.nextInt(12) + 1;
        int age = random.nextInt(86) + 15;
        int year = cal.get(Calendar.YEAR) - age;

        if (day < 10) {
            if (month < 10) {
                return "0" + day + "/" + "0" + month + "/" + year;
            } else {
                return "0" + day + "/" + month + "/" + year;
            }
        } else {
            if (month < 10) {
                return day + "/" + "0" + month + "/" + year;
            } else {
                return day + "/" + month + "/" + year;
            }
        }
    }
}
