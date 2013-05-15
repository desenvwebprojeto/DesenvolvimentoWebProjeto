/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabalho_final.controller;

import java.math.BigDecimal;

public final class Util {

    private Util() {
    }

    public static String bigDecimalToMonetary(BigDecimal val) {
        String aux = val.toString().replace(".", ",");
        int len = aux.length() - 3;
        StringBuilder s = new StringBuilder();
        int counter = 0;
        for (int i = len - 1; i >= 0; i--) {
            s.append(aux.charAt(i));
            if ((s.length() - counter) % 3 == 0) {
                s.append(".");
                counter++;
            }
        }
        String res = s.reverse().toString() + aux.substring(len, aux.length());
        return "R$ " + res;
    }
}
