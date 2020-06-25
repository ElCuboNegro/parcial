/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_fincaRaiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
 

package uniandes.cupi2.fincaRaiz.mundo;

import java.util.ArrayList;

/**
 * Clase que representa un inmueble <br>
 * <b>inv: </b> <br>
 * TODO Definir y documentar el invariante de la clase
 */
public class Inmueble
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    
    /**
     * Enum con los posibles tipos de Oferta
     *
     */
    public enum TipoOferta{
    	VENTA, ARRIENDO;
    }
    
    /**
     * Enum con los posibles tipos de inmuebles.
     *
     */
    public enum TipoInmueble{
    	APARTAMENTO, CASA, FINCA
    }
    

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * El identificador �nico del inmueble
     */
    private String identificador;
    
    /**
     * Indica si el inmueble es para la venta o para ser arrendado
     */
    private TipoOferta tipoOferta;

    /**
     * La ciudad en la que se encuentra el inmueble
     */
    private String ciudad;

    /**
     * El barrio en el que se encuentra el inmueble
     */
    private String barrio;

    /**
     * La direcci�n donde se encuentra el inmueble
     */
    private String direccion;

    /**
     * El tel�fono para contactarse para recibir informaci�n del inmueble
     */
    private String telefono;

    /**
     * El tama�o del inmueble en metros cuadrados
     */
    private double tamanio;

    /**
     * El precio del inmueble
     */
    private double precio;

    /**
     * La lista de im�genes del inmueble
     */
    private ArrayList<String> imagenes;

    /**
     * El tipo de inmueble que se desea publicar
     */
    private TipoInmueble tipoInmueble;

    /**
     * El número de visitas que ha tenido el inmueble
     * */
    private int visitas;
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo inmueble con los par�metros indicados.
     * @param string El tipo de inmueble - nTipoInmueble != null
     * @param i El identificador �nico del inmueble - nIdentificador != null
     * @param string2 El tipo de oferta del inmueble - nTipoOferta != null
     * @param nCiudad La ciudad donde se encuentra el inmueble - nCiudad != null
     * @param nBarrio El barrio donde se encuentra el inmueble - nBarrio != null
     * @param nDireccion Al direcci�n donde se encuentra el inmueble - nDireccion != null
     * @param nTelefono El tel�fono del inmueble - nTelefono != null
     * @param nTamanio El tama�o del inmueble - nTamanio > 0
     * @param nPrecio El precio del inmueble - nPrecio > 0
     * @param string3 La lista de im�genes - nImagenes != null
     */
    public Inmueble( TipoInmueble string, String i, TipoOferta string2, String nCiudad, String nBarrio, String nDireccion,
            String nTelefono, double nTamanio, double nPrecio, ArrayList<String> string3)
    {
        identificador = i+"";
        tipoOferta = string2;
        tipoInmueble = string;
        identificador = i+"";
        ciudad = nCiudad;
        barrio = nBarrio;
        direccion = nDireccion;
        telefono = nTelefono;
        tamanio = nTamanio;
        precio = nPrecio;
        imagenes = string3;
        visitas = (int) (Math.random() * ((900) + 1));

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el tipo del oferta del inmueble
     * 
     * @return tipo oferta
     */
    public TipoOferta darTipoOferta( )
    {
        return tipoOferta;
    }

    /**
     * Retorna la identificaci�n del inmueble
     * 
     * @return identificaci�n
     */
    public String darIdentificador( )
    {
        return identificador;
    }

    /**
     * Retorna la ciudad donde se encuentra el inmueble
     * 
     * @return ciudad
     */
    public String darCiudad( )
    {
        return ciudad;
    }

    /**
     * Retorna el barrio donde se encuentra el inmueble
     * 
     * @return barrio
     */
    public String darBarrio( )
    {
        return barrio;
    }

    /**
     * Retorna la direcci�n donde se encuentra el inmueble
     * 
     * @return direcci�n
     */
    public String darDireccion( )
    {
        return direccion;
    }

    /**
     * Retorna el tel�fono donde se encuentra el inmueble
     * 
     * @return tel�fono
     */
    public String darTelefono( )
    {
        return telefono;
    }

    /**
     * Retorna el tama�o del inmueble
     * 
     * @return tama�o
     */
    public double darTamanio( )
    {
        return tamanio;
    }

    /**
     * Retorna el precio del inmueble
     * 
     * @return precio
     */
    public double darPrecio( )
    {
        return precio;
    }

    /**
     * Retorna la lista de im�genes del inmueble
     * 
     * @return lista Im�genes
     */
    public ArrayList<String> darImagenes( )
    {
        return imagenes;
    }

    /**
     * Retorna el tipo de inmueble
     * 
     * @return tipo inmueble
     */
    public TipoInmueble darTipoInmueble( )
    {
        return tipoInmueble;
    }

    /**
     * Retorna una representaci�n String del inmueble
     * @return Un String donde se indica el tipo de inmueble, el tipo de oferta, el tama�o y la ciudad
     */
    public String toString( )
    {
        return "Tipo :" + this.darTipoInmueble() + "\nTamaño: " + this.darTamanio() + "\nCiudad" + darCiudad();
    } 

    /**
     * M�todo que compara dos inmuebles basado en la ciudad en la que se encuentran
     * @param a El inmueble con el que se debe comparar
     * @return Retorna 0 si el inmueble a es igual<br>
     *         Retorna -1 si la ciudad del inmueble es menor que el del inmueble a<br>
     *         Retorna 1 si la ciudad del inmueble es mayor que el del inmueble a
     */
    public int compararPorCiudad( Inmueble a )
    {
        return this.darCiudad().compareTo(a.darCiudad());
    }

    /**
     * M�todo que compara dos inmuebles basado en el identificador
     * @param a El inmueble con el que se debe comparar
     * @return Retorna 0 si el inmueble a es igual<br>
     *         Retorna -1 si el identificador del inmueble es menor que el del inmueble a<br>
     *         Retorna 1 si el identificador del inmueble es mayor que el del inmueble a
     */
    public int compararPorIdentificador( Inmueble a )
    {
        return this.darIdentificador().compareTo(a.darIdentificador());
    }

    /**
     * M�todo que compara dos inmuebles basado en en el precio
     * @param a El inmueble con el que se debe comparar
     * @return Retorna 0 si el inmueble a es igual<br>
     *         Retorna -1 si el precio del inmueble es menor que el del inmueble a <br>
     *         Retorna 1 si el precio del inmueble es mayor que el del inmueble a
     */
    public int compararPorPrecio( Inmueble a )
    {
        if (this.darPrecio() == a.darPrecio())
        {
            return 0;
        }
        else if (this.darPrecio() >= a.darPrecio())
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

    /**
     * M�todo que compara dos inmuebles basado en el tama�o
     * @param a El inmueble con el que se debe comparar
     * @return Retorna 0 si el inmueble a es igual<br>
     *         Retorna -1 si el tama�o del inmueble es menor que el del inmueble a <br>
     *         Retorna 1 si el tama�o del inmueble es mayor que el del inmueble a
     */
    public int compararPorTamanio( Inmueble a )
    {
        
        if (this.darTamanio() == a.darTamanio())
        {
            return 0;
        }
        else if (this.darTamanio() >= a.darTamanio())
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

    private double darVisitas() {
        return visitas;
    }

    public int compararPorvisitas( Inmueble a )
    {
        
        if (this.darVisitas() == a.darVisitas())
        {
            return 0;
        }
        else if (this.darVisitas() >= a.darVisitas())
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

    public int compararPorBarrio( Inmueble a )
    {
        if (this.darBarrio().toLowerCase().compareTo(a.darBarrio().toLowerCase()) == 0)
        {
            return 0;
        } else if (this.darBarrio().toLowerCase().compareTo(a.darBarrio().toLowerCase()) > 0)
        {
            return 1;
        } else if (this.darBarrio().toLowerCase().compareTo(a.darBarrio().toLowerCase()) < 0)
        return -1;
        }
    }


    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------


    private void verificarInvariante()
    {
        assert(visitas >= 0) : "El numero de visitas no puede ser negativo";
    }

}
