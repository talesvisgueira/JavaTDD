package br.com.mtinet.testeDemo.validadores;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidadorCNPJTests {

    @Test
    @DisplayName("Não deve validar CNPJ nulo")
    public void naoDeveraValidarCNPJNulo() {
        String cnpj = null;
        Assertions.assertThat( ValidadorCnpj.execute(cnpj) ).isFalse();
    }

    @Test
    @DisplayName("Não deve validar CNPJ com a quantidade de dígitos errada")
    public void naoDeveraValidarCNPJComQuantidadeNumerosErrados() {
        String cnpj = "89.889/0001-21";
        Assertions.assertThat( ValidadorCnpj.execute(cnpj) ).isFalse();
    }

    @Test
    public void naoDeveraValidarCNPJSemMascaraEquantNumerosErrados() {
        String cnpj = "89889000121";
        Assertions.assertThat( ValidadorCnpj.execute(cnpj) ).isFalse();
    }

    @Test
    public void deveraValidarCNPJComMascaraEquantidadeNumerosCorretos() {
        String cnpj = "69.625.200/0001-36";
        Assertions.assertThat(  ValidadorCnpj.execute(cnpj) ).isTrue();
    }

    @Test
    public void deveraValidarCNPJSemMascaraComQuantidadeNumerosCorretos() {
        String cnpj = "69625200000136";
        Assertions.assertThat( ValidadorCnpj.execute(cnpj) ).isTrue();
    }

    @Test
    public void naoDeveraValidarCNPJSemMascaraComDigitoVerificadorErrados() {
        String cnpj = "89012889000121";
        Assertions.assertThat( ValidadorCnpj.execute(cnpj) ).isFalse();
    }

    @Test
    public void naoDeveraValidarCNPJSemMascaraComZeros() {
        String cnpj = "00000000000000";
        Assertions.assertThat( ValidadorCnpj.execute(cnpj) ).isFalse();
    }

    @Test
    public void naoDeveraValidarCNPJSemMascaraComIguais() {
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
    public void deveraValidarCNPJSemMascaraComDigitoVerificadorCorreto() {
        String cnpj = "11371155000150";
        Assertions.assertThat( ValidadorCnpj.execute(cnpj) ).isTrue();
    }
}
