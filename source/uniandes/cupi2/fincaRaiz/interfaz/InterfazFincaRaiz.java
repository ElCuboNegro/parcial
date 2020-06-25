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
 

package uniandes.cupi2.fincaRaiz.interfaz;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.fincaRaiz.mundo.FincaRaiz;
import uniandes.cupi2.fincaRaiz.mundo.Inmueble;
import uniandes.cupi2.fincaRaiz.mundo.Inmueble.TipoInmueble;
import uniandes.cupi2.fincaRaiz.mundo.Inmueble.TipoOferta;

/**
 * Esta es la ventana principal de la aplicaci�n.
 */
public class InterfazFincaRaiz extends JFrame 
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serializaci�n
     */
    private static final long serialVersionUID = 1L;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo
     */
    private FincaRaiz fincaRaiz;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con las extensiones
     */
    private PanelExtension panelExtension;

    /**
     * Panel con la imagen del encabezado
     */
    private PanelImagen panelImagen;

    /**
     * Panel con la informaci�n detallada del inmueble seleccionado
     */
    private PanelInfoInmueble panelInformacionInmueble;

    /**
     * Panel con la lista de los inmuebles
     */
    private PanelInmuebles panelInmuebles;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de la ventana principal de la aplicaci�n
     */
    public InterfazFincaRaiz( )
    {
        // Crea la clase principal
        fincaRaiz = new FincaRaiz( );

        // Construye la forma
        setTitle( "Finca Ra�z Cupi2" );
        setLayout( new BorderLayout( ) );
        setSize( 815, 825 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // Creaci�n de los paneles aqu�
        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );

        JPanel panelPrincipal = new JPanel( );
        panelInmuebles = new PanelInmuebles( this  );

        panelInformacionInmueble = new PanelInfoInmueble( );

        panelPrincipal.setLayout( new BorderLayout( ) );

        panelPrincipal.add( panelInmuebles, BorderLayout.WEST );
        panelPrincipal.add( panelInformacionInmueble, BorderLayout.CENTER );
        add( panelPrincipal, BorderLayout.CENTER );

        panelExtension = new PanelExtension( this );
        add( panelExtension, BorderLayout.SOUTH );

        // Centrar la ventana
        setLocationRelativeTo( null );

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * M�todo para mostrar el dialogo para registrar un inmueble
     */
    public void registrarInmueble( )
    {
        DialogoInfoInmueble dialogoInfoInmueble = new DialogoInfoInmueble( this );
        dialogoInfoInmueble.setVisible( true );
    }

    /**
     * M�todo para eliminar un inmueble
     */
    public void eliminarInmueble( )
    {
        String idInmueble = JOptionPane.showInputDialog( "Ingrese el identificador del inmueble a eliminar" );
        if( idInmueble != null && idInmueble.length( ) > 0 )
        {
            fincaRaiz.eliminarInmueble( idInmueble );
            actualizar( );
        }
    }

    /**
     * M�todo para buscar el inmueble m�s costos para la venta
     */
    public void buscarMasCostoso( )
    {
        int i = fincaRaiz.buscarInmuebleMasCostosoVenta( );
        if( i == -1 )
        {
            JOptionPane.showMessageDialog( this, "No hay inmuebles registrados.", "B�squeda", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            panelInmuebles.actualizarSeleccionado( i );

        }
    }

    /**
     * M�todo para buscar el inmueble m�s econ�mico para arrendar
     */
    public void buscarMasEconomico( )
    {
        int i = fincaRaiz.buscarInmuebleMasBaratoArrendar( );
        if( i == -1 )
        {
            JOptionPane.showMessageDialog( this, "No hay inmuebles registrados.", "B�squeda", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            panelInmuebles.actualizarSeleccionado( i );

        }
    }

    /**
     * M�todo para buscar por la identificaci�n del inmueble
     */
    public void buscarPorIdentificador( )
    {
        String idInmueble = JOptionPane.showInputDialog( "Ingrese el identificador del inmueble" );
        if( idInmueble != null && idInmueble.length( ) > 0 )
        {
            fincaRaiz.ordenarPorIdentificador( );
            actualizar( );
            int i = fincaRaiz.buscarBinarioPorIdentificador( idInmueble );
            if( i == -1 )
            {
                JOptionPane.showMessageDialog( this, "No se encontr� un inmueble registrado con el identificador: " + idInmueble, "B�squeda", JOptionPane.INFORMATION_MESSAGE );
            }
            else
            {
                panelInmuebles.actualizarSeleccionado( i );
            }
        }
    }

    /**
     * M�todo para ordenar por ciudad la lista de inmuebles
     */
    public void ordenarPorCiudad( )
    {
        fincaRaiz.ordenarPorCiudad( );
        actualizar( );
    }

    /**
     * M�todo para ordenar por precio la lista de inmuebles
     */
    public void ordenarPorPrecio( )
    {
        fincaRaiz.ordenarPorPrecio( );
        actualizar( );
    }

    /**
     * M�todo para ordenar por tama�o la lista de inmuebles
     */
    public void ordenarPorTamanio( )
    {
        fincaRaiz.ordenarPorTamanio( );
        actualizar( );
    }

    /**
     * M�todo que actualiza la interfaz seg�n los valores del mundo
     */
    public void actualizar( )
    {
        panelInmuebles.actualizarLista( fincaRaiz.darListaInmuebles( ) );
        panelInformacionInmueble.limpiarEdicion( );
    }

    
    /**
     * M�todo que actualiza el inmueble seleccionado
     * @param nInmueble El inmueble seleccionado
     */
    public static void actualizar(Inmueble nInmueble )
    {
        panelInformacionInmueble.actualizar( nInmueble );
    }

    /**
     * M�todo que crea un inmueble
     * @param nTipoInmueble El tipo de inmueble
     * @param nTipoOferta El tipo de oferta del inmueble
     * @param nCiudad La ciudad donde se encuentra el inmueble
     * @param nBarrio El barrio donde se encuentra el inmueble
     * @param nDireccion Al direcci�n donde se encuentra el inmueble
     * @param nTelefono El tel�fono del inmueble
     * @param nTamanio El tama�o del inmueble
     * @param nPrecio El precio del inmueble
     * @param imagenes La lista de im�genes del inmueble
     */
    public void crearInmueble( TipoInmueble nTipoInmueble, TipoOferta nTipoOferta, String nCiudad, String nBarrio, String nDireccion, String nTelefono, double nTamanio, double nPrecio, ArrayList<String> imagenes )
    {
        fincaRaiz.agregarInmueble( nTipoInmueble, nTipoOferta, nCiudad, nBarrio, nDireccion, nTelefono, nTamanio, nPrecio, imagenes );
        panelInformacionInmueble.desHabilitarEdicion( );
        actualizar( );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1
     */
    public void reqFuncOpcion1( )
    {
        String resultado = fincaRaiz.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * M�todo para la extensi�n 2
     */
    public void reqFuncOpcion2( )
    {
        String resultado = fincaRaiz.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este m�todo ejecuta la aplicaci�n, creando una nueva interfaz
     * @param args
     */
    public static void main( String[] args )
    {

        InterfazFincaRaiz interfaz = new InterfazFincaRaiz( );
        interfaz.setVisible( true );
    }

}