package com.sena.crud_basic.dto.view;

/**
 * Vistas para controlar qué campos se serializan en las respuestas JSON.
 * 
 * - Summary: vista básica, por ejemplo para listados.
 * - Detail: vista detallada, hereda de Summary.
 */
public class JsonViews {

    // Vista básica, generalmente usada en listados
    public static class Resumen {
        // Esta clase se deja vacía a propósito
    }

    // Vista detallada, extiende Summary para incluir también los campos de Summary
    public static class Detalle extends Resumen {
        // Esta clase se deja vacía a propósito
    }
}
