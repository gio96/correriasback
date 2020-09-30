package com.ceiba.dominio.utils;

import com.ceiba.dominio.excepcion.FacturaException;

import java.util.Objects;
import java.util.stream.Stream;

public class StringUtils {
    public static boolean isEmpty(String... strings) {
        return Stream.of(strings)
                .anyMatch(StringUtils::isNullOrEmpty);
    }

    public static boolean isNullOrEmpty(String value) {
        return Objects.isNull(value) || value.trim().isEmpty();
    }

    public static void validarObligatorio(Object value) {
        if (Objects.isNull(value)) {
            throw FacturaException.Type.NO_VALUES_FULL.build();
        }
    }

    public static void validarObligatorio(String value) {
        if (Objects.isNull(value) || value.trim().isEmpty()) {
            throw FacturaException.Type.NO_VALUES_FULL.build();
        }
    }
}
