/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_fincaRaiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
 
package uniandes.cupi2.fincaRaiz.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import uniandes.cupi2.fincaRaiz.mundo.Inmueble;
import uniandes.cupi2.fincaRaiz.mundo.Inmueble.TipoInmueble;
import uniandes.cupi2.fincaRaiz.mundo.Inmueble.TipoOferta;

/**
 * Clase para probar el correcto funcionamiento de los métodos de la clase inmueble
 */
public class InmuebleTest
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    
    /**
     * Es la primera clase donde se harán las pruebas
     */
    private Inmueble inmueble1;

    /**
     * Es la segunda clase donde se harán las pruebas
     */
    private Inmueble inmueble2;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    
    /**
     * Construye los inmuebles 1 y 2 <br/>
     * <b>Datos del inmueble 1:</b> <br/>
     * TipoInmueble: Apartamento, Id: 1-B-A, TipoOferta: Venta, Ciudad: Bogotá, Barrio: Álamos, Dirección: Cra. 97 No. 51-51, Telefono: 123456, Tamaño: 123.2d, Precio: 567d,  Imagenes: ./data/ap1.jpg; ./data/ap2.jpg; ./data/ap3.jpg<br/>
     * <b>Datos del inmueble 2:</b> <br/>
     * TipoInmueble: Apartamento, Id: 2-C-C, TipoOferta: Arrendar, Ciudad: Cali, Barrio: Chico, Dirección: Cra. 75 No. 41-10, Telefono: 359845, Tamaño: 258741d, Precio: 98958d,Imagenes: ./data/ap1.jpg; ./data/ap2.jpg; ./data/ap3.jpg<br/>
     */
    @Before
    public void setupEscenario1( )
    {
        ArrayList<String> imagenes = new ArrayList<>( );
        imagenes.add( "./data/ap1.jpg" );
        imagenes.add( "./data/ap2.jpg" );
        imagenes.add( "./data/ap3.jpg" );
        inmueble1 = new Inmueble( TipoInmueble.APARTAMENTO, "1-B-A", TipoOferta.VENTA, "Bogotá", "Álamos", "Cra. 97 No. 51-51", "123456", 123.2d, 567d, imagenes );
        inmueble2 = new Inmueble( TipoInmueble.APARTAMENTO, "2-C-C", TipoOferta.ARRIENDO, "Cali", "Chico", "Cra. 75 No. 41-10", "359845", 258741d, 98958d, imagenes );
    }

    /**
     * Prueba 1 - Verifica el método darTipoAferta. <br>
     * <b> Métodos a probar: </b> <br>
     * darTipoOferta. <br>
     * <b> Objetivo: </b> Probar que el método darTipoOferta de la información correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. El tipo de oferta del inmueble 1 es VENTA.
     */
    @Test
    public void testDarTipoOferta( )
    {
        assertEquals( "Error en el valor del tipo de oferta", inmueble1.darTipoOferta( ), TipoOferta.VENTA );
    }

    /**
     * Prueba 2 - Verifica el método darIdentificador. <br>
     * <b> Métodos a probar: </b> <br>
     * darIdentificador. <br>
     * <b> Objetivo: </b> Probar que el método darIdentificador de la información correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. El identificador del inmueble 1 es 1-B-A.
     */
    @Test
    public void testDarIdentificador( )
    {
        assertEquals( "Error en el valor del identificador del inmueble", inmueble1.darIdentificador( ), "1-B-A" );
    }

    /**
     * Prueba 3 - Verifica el método darCiudad. <br>
     * <b> Métodos a probar: </b> <br>
     * darCiudad. <br>
     * <b> Objetivo: </b> Probar que el método darCiudad de la información correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. La ciudad del inmueble 1 es Bogotá.
     */
    @Test
    public void testDarCiudad( )
    {
        assertEquals( "Error en el valor de la ciudad", inmueble1.darCiudad( ), "Bogotá" );
    }

    /**
     * Prueba 4 - Verifica el método darBarrio. <br>
     * <b> Métodos a probar: </b> <br>
     * darBarrio. <br>
     * <b> Objetivo: </b> Probar que el método darBarrio de la información correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. El barrio del inmueble 1 es Álamos.
     */
    @Test
    public void testDarBarrio( )
    {
        assertEquals( "Error en el valor del barrio", inmueble1.darBarrio( ), "Álamos" );
    }

    /**
     * Prueba 5 - Verifica el método darDireccion. <br>
     * <b> Métodos a probar: </b> <br>
     * darDireccion. <br>
     * <b> Objetivo: </b> Probar que el método darDireccion de la información correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. La dirección del inmueble 1 es "Cra. 97 No. 51-51".
     */
    @Test
    public void testDarDireccion( )
    {
        assertEquals( "Error en el valor de la dirección", inmueble1.darDireccion( ), "Cra. 97 No. 51-51" );
    }

    /**
     * Prueba 6 - Verifica el método darTelefono. <br>
     * <b> Métodos a probar: </b> <br>
     * darTelefono. <br>
     * <b> Objetivo: </b> Probar que el método darTelefono de la información correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. El teléfono del inmueble 1 es 123456.
     */
    @Test
    public void testDarTelefono( )
    {
        assertEquals( "Error en el valor del teléfono", inmueble1.darTelefono( ), "123456" );
    }

    /**
     * Prueba 7 - Verifica el método darTamanio. <br>
     * <b> Métodos a probar: </b> <br>
     * darTamanio. <br>
     * <b> Objetivo: </b> Probar que el método darTamanio de la información correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. El tamaño del inmueble 1 es 123.2d
     */
    @Test
    public void testDarTamanio( )
    {
        assertEquals( "Error en el valor del tamaño", inmueble1.darTamanio( ), 123.2d, 0.0 );
    }

    /**
     * Prueba 8 - Verifica el método darPrecio. <br>
     * <b> Métodos a probar: </b> <br>
     * darPrecio. <br>
     * <b> Objetivo: </b> Probar que el método darPrecio de la información correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. El precio del inmueble 1 es 567d
     */
    @Test
    public void testDarPrecio( )
    {
        assertEquals( "Error en el valor del precio", inmueble1.darPrecio( ), 567d, 0.0 );
    }

    /**
     * Prueba 9 - Verifica el método darImagenes. <br>
     * <b> Métodos a probar: </b> <br>
     * darImagenes. <br>
     * <b> Objetivo: </b> Probar que el método darImegenes de la información correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. El inmueble 1 contiene 3 imágenes.
     */
    @Test
    public void testDarImagenes( )
    {
        assertEquals( "Error al dar las imágenes del inmueble", inmueble1.darImagenes( ).size( ), 3 );
    }

    /**
     * Prueba 10 - Verifica el método darTipoInmueble. <br>
     * <b> Métodos a probar: </b> <br>
     * darTipoInmueble. <br>
     * <b> Objetivo: </b> Probar que el método darPrecio de la información correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. El tipo del inmueble 1 es Apartamento
     */
    @Test
    public void testDarTipoInmueble( )
    {
        assertEquals( "Error en el valor del tipo de inmueble", inmueble1.darTipoInmueble( ), "Apartamento" );
    }


    // Prueba 11
    // TODO Declarar, implementar y documentar el caso de prueba para el método compararPorCiudad

    // Prueba 12
    // TODO Declarar, implementar y documentar el caso de prueba para el método compararPorIdentificador

    // Prueba 13
    // TODO Declarar, implementar y documentar el caso de prueba para el método compararPorPrecio
 
    // Prueba 14
    // TODO Declarar, implementar y documentar el caso de prueba para el método compararPorTamanio

}
