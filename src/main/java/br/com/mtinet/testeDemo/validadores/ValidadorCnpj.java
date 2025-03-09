package br.com.mtinet.testeDemo.validadores;

import br.com.mtinet.testeDemo.exceptions.ValidateCnpjException;

public class ValidadorCnpj {

    public static boolean execute(String cnpj) throws ValidateCnpjException {
        if (cnpj==null) throw new ValidateCnpjException("Valor nulo");;
        String numeros = ajustarCnpj(cnpj);
        return validarNumeracaoCnpj(numeros);
    }

    private static boolean validarNumeracaoCnpj(String numeros) {
        boolean result = validarQuantidadeNumeros(numeros);
        result = validarNumerosRepetidos(numeros);
        if (result) result = validarDigitoVerificadorValido(numeros);
        return result;
    }

    private static boolean validarQuantidadeNumeros(String cnpj) {
        return (cnpj.length()==14) ? true: false;
    }

    private static boolean validarNumerosRepetidos(String numeros) {
        if (numeros.equals("00000000000000")) return false;
        return true;
    }

    private static String ajustarCnpj(String cnpj) {
        String value = cnpj;
        if (value.contains(".")) value = value.replace(".", "");
        if (value.contains("-")) value = value.replace("-","");
        if (value.contains("/")) value = value.replace("/","");
        return value;
    }

    private static boolean validarDigitoVerificadorValido(String cnpj) {
        if (!cnpj.substring(0, 1).equals("")) {
            try {

                int soma = 0, dig;
                String cnpj_calc = cnpj.substring(0, 12);

                if (cnpj.length() != 14) {
                    return false;
                }
                char[] chr_cnpj = cnpj.toCharArray();
                /* Primeira parte */
                for (int i = 0; i < 4; i++) {
                    if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                        soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                        soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
                    }
                }
                dig = 11 - (soma % 11);
                cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(
                        dig);
                /* Segunda parte */
                soma = 0;
                for (int i = 0; i < 5; i++) {
                    if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                        soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                        soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
                    }
                }
                dig = 11 - (soma % 11);
                cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(
                        dig);
                return cnpj.equals(cnpj_calc);
            }
            catch (Exception e) {
                return false;
            }
        }
        else {
            return false;
        }
    }
}
