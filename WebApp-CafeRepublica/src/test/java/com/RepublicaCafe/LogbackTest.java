package com.RepublicaCafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class LogbackTest {
    private static final Logger logger = LoggerFactory.getLogger(LogbackTest.class);
    public static void main(String[] args) {
        logger.trace("Este es un mensaje TRACE (informacion detallada)");
        logger.debug("Este es un mensaje DEBUG (informacion de depuracion)");
        logger.info("Este es un mensaje INFO (informacion estandar)");
        logger.warn("Este es un mensaje WARN (advertencia)");
        logger.error("Este es un mensaje ERROR (error)");
        try {
            int resultado = dividir(10, 2);
            logger.info("El resultado de la division es: " + resultado);
        } catch (ArithmeticException e) {
            logger.error("Error en la operación: " + e.getMessage());
        }
        try {
            int resultado = dividir(10, 0);
            logger.info("El resultado de la division es: " + resultado);
        } catch (ArithmeticException e) {
            logger.error("Error al dividir entre cero: ", e);
        }
    }

    public static int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir entre cero");
        }
        return a / b;
    }
}