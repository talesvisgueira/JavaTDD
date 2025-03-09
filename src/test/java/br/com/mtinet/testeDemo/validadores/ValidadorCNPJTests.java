package br.com.mtinet.testeDemo.validadores;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.mtinet.testeDemo.exceptions.ValidateCnpjException;

class ValidadorCNPJTests {

    @Test
    @DisplayName("Não deve validar CNPJ nulo")
    public void naoDeveraValidarCNPJNulo() {
        String cnpj = null;
        Assertions.assertThatThrownBy(() ->ValidadorCnpj.execute(cnpj))
        .isInstanceOf(ValidateCnpjException.class)
        .hasMessageStartingWith("Valor nulo");
    }

    @Test
    @DisplayName("Não deve validar CNPJ com a quantidade de dígitos errada")
    public void naoDeveraValidarCNPJComQuantidadeNumerosErrados()  throws ValidateCnpjException{
        String cnpj = "89.889/0001-21";
        Assertions.assertThat( ValidadorCnpj.execute(cnpj) ).isFalse();
    }

    @Test
    public void naoDeveraValidarCNPJSemMascaraEquantNumerosErrados()  throws ValidateCnpjException {
        String cnpj = "89889000121";
        Assertions.assertThat( ValidadorCnpj.execute(cnpj) ).isFalse();
    }

    @Test
    public void deveraValidarCNPJComMascaraEquantidadeNumerosCorretos()  throws ValidateCnpjException {
        String cnpj = "69.625.200/0001-36";
        Assertions.assertThat(  ValidadorCnpj.execute(cnpj) ).isTrue();
    }

    @Test
    public void deveraValidarCNPJSemMascaraComQuantidadeNumerosCorretos()  throws ValidateCnpjException {
        String cnpj = "69625200000136";
        Assertions.assertThat( ValidadorCnpj.execute(cnpj) ).isTrue();
    }

    @Test
    public void naoDeveraValidarCNPJSemMascaraComDigitoVerificadorErrados()  throws ValidateCnpjException {
        String cnpj = "89012889000121";
        Assertions.assertThat( ValidadorCnpj.execute(cnpj) ).isFalse();
    }

    @Test
    public void naoDeveraValidarCNPJSemMascaraComZeros()  throws ValidateCnpjException {
        String cnpj = "00000000000000";
        Assertions.assertThat( ValidadorCnpj.execute(cnpj) ).isFalse();
    }

    @Test
    public void naoDeveraValidarCNPJSemMascaraComIguais()  throws ValidateCnpjException {
        String cnpj = "11111111111111";
        Assertions.assertThat( ValidadorCnpj.execute(cnpj) ).isFalse();
        cnpj = "22222222222222";
        Assertions.assertThat( ValidadorCnpj.execute(cnpj) ).isFalse();
        cnpj = "33333333333333";
        Assertions.assertThat( ValidadorCnpj.execute(cnpj) ).isFalse();
        cnpj = "44444444444444";
        Assertions.assertThat( ValidadorCnpj.execute(cnpj) ).isFalse();
        cnpj = "55555555555555";
        Assertions.assertThat( ValidadorCnpj.execute(cnpj) ).isFalse();
        cnpj = "66666666666666";
        Assertions.assertThat( ValidadorCnpj.execute(cnpj) ).isFalse();
        cnpj = "77777777777777";
        Assertions.assertThat( ValidadorCnpj.execute(cnpj) ).isFalse();
        cnpj = "88888888888888";
        Assertions.assertThat( ValidadorCnpj.execute(cnpj) ).isFalse();
        cnpj = "99999999999999";
        Assertions.assertThat( ValidadorCnpj.execute(cnpj) ).isFalse();
    }

    @Test
    public void deveraValidarCNPJSemMascaraComDigitoVerificadorCorreto()  throws ValidateCnpjException {
        String cnpj = "11371155000150";
        Assertions.assertThat( ValidadorCnpj.execute(cnpj) ).isTrue();
    }
}
