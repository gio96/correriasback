package com.ceiba.dominio.utils;

import com.ceiba.dominio.excepcion.FacturaException;
import org.hamcrest.Matchers;
import org.junit.Test;

import static com.ceiba.dominio.utils.StringUtils.validarObligatorio;
import static com.ceiba.dominio.utils.StringUtils.validarObligatorios;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class StringUtilsTest {

    @Test
    public void isNullOrEmptyValueTestException() {
        //arrange
        String[] strings = {"", "valor"};

        try {
            //act
            validarObligatorios(strings);
            fail();
        } catch (FacturaException ex) {
            //assert
            assertThat(ex.getMessage(),
                    Matchers.is(FacturaException.Type.NO_VALUES_FULL.getMessage()));
        }

    }

    @Test
    public void validarObligatorioTestException() {
        //arrange
        Object valor = null;

        try {
            //act
            validarObligatorio(valor);
            fail();
        } catch (FacturaException ex) {
            //assert
            assertThat(ex.getMessage(),
                    Matchers.is(FacturaException.Type.NO_VALUES_FULL.getMessage()));
        }

    }

    @Test
    public void validarObligatorioTestExceptionString() {
        //arrange
        String valor = "";

        try {
            //act
            validarObligatorio(valor);
            fail();
        } catch (FacturaException ex) {
            //assert
            assertThat(ex.getMessage(),
                    Matchers.is(FacturaException.Type.NO_VALUES_FULL.getMessage()));
        }

    }
}
