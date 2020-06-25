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
 

package uniandes.cupi2.fincaRaiz.mundo;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import uniandes.cupi2.fincaRaiz.mundo.Inmueble.TipoInmueble;
import uniandes.cupi2.fincaRaiz.mundo.Inmueble.TipoOferta;

/**
 * Clase que representa un negocio de finca raíz que maneja la información de inmuebles para venta y arriendo
 * <b>inv: </b> <br>
 * Inmueble != null <br>
 * no hay dos inmuebles con las mismas características
 */
public class FincaRaiz
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista con los inmuebles registrados
     */
    private ArrayList<Inmueble> inmuebles;

    /**
     * Indica un número consecutivo para generar el id para un inmueble
     */
    private int siguienteId;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo manejador de finca raíz <br>
     * <b> post: </b> Se inicializó siguienteId en 0 <br>
     *                Se inicializó la lista de inmuebles vacía <br>
     */
    public FincaRaiz( )
    {
        siguienteId = 0;
        inmuebles = new ArrayList<>( );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Método que retorna la lista de inmuebles <br>
     * <b> pre: </b> La lista de inmuebles se encuentra inicializada. <br>
     * @return lista inmuebles
     */
    public ArrayList<Inmueble> darListaInmuebles( )
    {
        return inmuebles;
    }
<
    /**
     * Método que ordena la lista de inmuebles según la ciudad usando el algoritmo de selección.<br>
     * <b> pre: </b> La lista de inmuebles se encuentra inicializada. <br>
     * <b> post: </b> La lista de inmuebles está ordenada por ciudad (orden ascendente)
     */
    public void ordenarPorCiudad( )
    {
    	int n = inmuebles.size(); 
        for (int i = 0; i < n-1; i++) 
        { 
            int min_lexicon = i; 
            for (int j = i+1; j < n; j++)
            {
                if (inmuebles.get(j).darCiudad().compareTo(inmuebles.get(min_lexicon).darCiudad()) < 0); 
                {
                    min_lexicon = j;
                }
            }
            Inmueble temp = inmuebles.get(min_lexicon); 
            inmuebles.add(min_lexicon, inmuebles.get(i));
            inmuebles.add(i, temp); 
        }
    }

    /**
     * Método que ordena la lista de inmuebles según la ciudad usando el algoritmo de inserción.<br>
     * <b> pre: </b> La lista de inmuebles se encuentra inicializada. <br>
     * <b> post: La lista de inmuebles está ordenada por ciudad (orden ascendente)
     */
    public void ordenarPorIdentificador( )
    {
        int i,j;
    
        for (i = 1; i < inmuebles.size(); i++) {
            Inmueble key = inmuebles.get(i);
            j = i;
            while((j > 0) && (inmuebles.get(j - 1).darIdentificador().compareTo(key.darIdentificador()) > 0)) {
                inmuebles.set(j,inmuebles.get(j - 1));
                j--;
            }
            inmuebles.set(j,key);
        }
    
    }

    /**
     * Método que ordena la lista de inmuebles según el precio usando el algoritmo de burbuja. <br>
     * <b> pre: </b> La lista de inmuebles se encuentra inicializada. <br>
     * <b> post: La lista de inmuebles está ordenada por precio
     */
    public void ordenarPorPrecio( )
    {
    Inmueble temp;
    if (inmuebles.size()>1) // check if the number of orders is larger than 1
    {
        for (int i=0; i < inmuebles.size(); i++) // bubble sort outer loop
        {
            for (int j=0; j < inmuebles.size() -i -1; j++)
            {
                if (inmuebles.get(i).darPrecio() > (inmuebles.get(i+1).darPrecio()))
                {
                    temp = inmuebles.get(i);
                    inmuebles.set(i,inmuebles.get(i+1));
                    inmuebles.set(i+1, temp);
                }
            }
        }
    }
}


    /**
     * Método que ordena la lista de inmuebles según el tamaño usando el algoritmo de burbuja. <br>
     * <b> pre: </b> La lista de inmuebles se encuentra inicializada. <br>
     * <b> post: La lista de inmuebles está ordenada por tamaño
     */

    void ordenarBurbuja(ArrayList<Object> lista, String parametro)
    {
        int i,j;
    
        for (i = 1; i < lista.size(); i++) {
            Object key = lista.get(i);
            j = i;
            while((j > 0) && (lista.get(j - 1).getClass().getField(parametro).toString().compareTo(key.getClass().getField(parametro).toString()) > 0)) {
                lista.set(j,lista.get(j - 1));
                j--;
            }
            lista.set(j,key);
        }
    }

    public void ordenarPorTamanio( )
    {
        ordenarBurbuja((ArrayList<Object>) inmuebles, "tamanio");
    }

    /**
     * Busca un inmueble utilizando una búsqueda binaria. <br>
     * <b> pre: </b> La lista de inmuebles se encuentra inicializada. <br>
     *               La lista de inmuebles se encuentra ordenada por identificador. <br>
     * @param identificador es el identificador del inmueble que se va a buscar - identificador!=null
     * @return Retorna la posición del inmueble con el identificador dado. Si el inmueble no existe se retorna -1.
     */

    int binarysearch(ArrayList<Object> lista, String identifier, String argument)
    {
        int size = lista.size();  // Número de elementos
        int middle = size/2;

        Object templist[] = new Object[size];
        for (int i = 0; i < size; i++)
        {
            templist[i] = lista.get(i);
        }

        if (templist[middle].getClass().getField(argument).equals(identifier))
        {
            return middle;
            return -1;
        }
        else if (templist[middle].getClass().getField(argument).toString().compareTo(identifier) < 0)
        {
            ArrayList<Object> a = new ArrayList<Object>(Arrays.asList(Arrays.copyOfRange(templist, 0, middle)));
            return binarysearch(a,identifier,argument);
        }
        else if (templist[middle].getClass().getField(argument).toString().compareTo(identifier) > 0)
        {
            ArrayList<Object> a = new ArrayList<Object>(Arrays.asList(Arrays.copyOfRange(templist, middle, size)));
            return binarysearch(a,identifier,argument);
        }

    }
    

    public int buscarBinarioPorIdentificador( String identificador )
    {
        return binarysearch((ArrayList) inmuebles, identificador,"identificador");
    }

    /**
     * Busca el inmueble que tenga la menor precio y sea para arrendar. <br>
     * <b> pre: </b> La lista de inmuebles se encuentra inicializada. <br>
     * @return Retorna la posición donde se encuentra el inmueble más barato. Si no hay inmueble se retorna -1
     */
    public int buscarInmuebleMasBaratoArrendar( )
    {
        ordenarBurbuja(inmuebles, "precio");

        int posicion = -1;
        for (int i = 0; i < inmuebles.size() && posicion != -1; i++)
        {
            if (inmuebles.get(i).darTipoOferta().equals(Inmueble.TipoOferta.ARRIENDO)){
                return i;
            }
        }
    }

    /**
     * Busca el inmueble que tenga el costo más alto y sea para vender. <br>
     * <b> pre: </b> La lista de inmuebles se encuentra inicializada. <br>
     * @return Retorna la posición donde se encuentra el inmueble más costoso. Si no hay inmueble se retorna -1
     */
    public int buscarInmuebleMasCostosoVenta( )
    {
        ordenarBurbuja(inmuebles, "precio");

        int posicion = -1;
        for (int i = 0; i < inmuebles.size() && posicion != -1; i++)
        {
            if (inmuebles.get(i).darTipoOferta().equals(Inmueble.TipoOferta.VENTA)){
                return inmuebles.size();
            }
        }
    }

    /**
     * Método que agregar un nuevo inmueble con los parámetros dados
     * <b> pre: </b> La lista de inmuebles se encuentra inicializada. <br>
     * <b> post: </b> El inmueble creado con la información dada se agrego a la lista de inmuebles<br>
     *                El inmueble agregado tiene por id 'siguienteId-X-XX', donde X es la primera letra de la ciudad y XX es la primera letra del barrio <br>
     *                Se aumento siguienteId en uno <br>
     * @param nTipoInmueble El tipo de inmueble - nTipoInmueble != null
     * @param nTipoOferta El tipo de oferta del inmueble - nTipoOferta != null
     * @param nCiudad La ciudad donde se encuentra el inmueble - nCiudad != null
     * @param nBarrio El barrio donde se encuentra el inmueble - nBarrio != null
     * @param nDireccion Al dirección donde se encuentra el inmueble - nDireccion != null
     * @param nTelefono El teléfono del inmueble - nTelefono != null
     * @param nTamanio El tamaño del inmueble - nTamanio > 0
     * @param nPrecio El precio del inmueble - nPrecio > 0
     * @param imagenes La Lista de imágenes
     */
    public void agregarInmueble( TipoInmueble nTipoInmueble, TipoOferta nTipoOferta, String nCiudad, String nBarrio, String nDireccion, String nTelefono, double nTamanio, double nPrecio, ArrayList<String> imagenes )
    {
        String nIdentificador = siguienteId + "-" + nCiudad.charAt( 0 ) + "-" + nBarrio.charAt( 0 );
        siguienteId++;
        Inmueble inmueble = new Inmueble( nTipoInmueble, nIdentificador, nTipoOferta, nCiudad, nBarrio, nDireccion,
                nTelefono, nTamanio, nPrecio, imagenes);
        inmuebles.add( inmueble );
    }

    /**
     * El inmueble a eliminar <br>
     * <b> pre: </b> La lista de inmuebles se encuentra inicializada. <br>
     * <b> post: El inmueble con el identificador dado se elimina de la lista de inmuebles <br>
     * @param identificador El identificador del inmueble a eliminar
     */
    public void eliminarInmueble( String identificador )
    {

        boolean termino = false;
        for( int j = 0; j < inmuebles.size( ) && !termino; j++ )
        {
            Inmueble inmuebleJ = ( Inmueble )inmuebles.get( j );
            if( inmuebleJ.darIdentificador( ).equals( identificador ) )
            {
                inmuebles.remove( j );
                termino = true;
            }
        }
        
    }

    void ordenarInsercionPorBarrio()
    {
        for (int i = 0; i < inmuebles.size(); i++)
        {
            int posMinimo = -1;
            Inmueble temp; 
            for (int j = i; j < inmuebles.size() -1 j++)
            {
                if (inmuebles.get(j).compararPorBarrio(temp) < 0);
                {
                    posMinimo = i;
                    temp = inmuebles.get(j);
                }
            }
            inmuebles.set(j, inmuebles.get(i));
            inmuebles.set(i, temp);
        }
    }

    int buscarBinarioPorBarrio(String identificador)
    {
        return binarysearch((ArrayList) inmuebles, identificador,"Barrio");

    }

    
    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión2
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }
    
    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    // TODO Declarar, implementar y documentar el método verificarInvariante
    // Si utiliza métodos auxiliares, declárelos e impleméntelos en esta sección

}