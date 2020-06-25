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
 
package uniandes.cupi2.fincaRaiz.interfaz;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import uniandes.cupi2.fincaRaiz.mundo.FincaRaiz;
import uniandes.cupi2.fincaRaiz.mundo.Inmueble;

/**
 * Panel con la lista de inmueble registrados
 */
public class PanelInmuebles extends JPanel implements ListSelectionListener
{

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * La lista de los inmuebles registrados
     */
	JList listaInmuebles;
    // nombre: listInmuebles;

    /**
     * Scroll para la lista de inmuebles
     */
    JScrollPane scrollLista;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Referencia a la interfaz principal
     */
    private InterfazFincaRaiz principal;

    /**
     * Clase principal del mundo.
     */

     FincaRaiz fRaiz;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel con la lista de inmuebles
     * @param nPrincipal La ventana principal
     * 
     */
    public PanelInmuebles( InterfazFincaRaiz nPrincipal )
    {
    	principal = nPrincipal;
    	setBorder( BorderFactory.createTitledBorder( "Inmuebles Registrados" ) );
        setLayout( new GridLayout( 1, 1 ) );
        
        listaInmuebles = new JList<String>();
        listaInmuebles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaInmuebles.addListSelectionListener(this);

        JScrollPane scrollableTextArea = new JScrollPane(listaInmuebles);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
 
        principal.add(scrollableTextArea);
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Método que selecciona el elemento con el índice dado en la lista de inmuebles
     * @param i El índice del inmueble a seleccionar
     */
    public void actualizarSeleccionado( int i )
    {
        listaInmuebles.setSelectedIndex(i);
        listaInmuebles.ensureIndexIsVisible(i);
    }

    /**
     * Método que actualiza la lista de inmuebles
     * @param array La lista de inmuebles
     */
    public void actualizarLista( ArrayList<Inmueble> array )
    {
        if (array != null)
        {
            listaInmuebles.setListData(array.toArray());
            //Recuerde dejar seleccionado el primer elemento
            listaInmuebles.setSelectedIndex(0);
        }                
    }

    /**
     * Método para el manejo de los  eventos de selección de la lista de inmuebles
     */
    public void valueChanged( ListSelectionEvent e )
    {
    	// TODO Completar según enunciado
        // Apóyese en el método actualizar(Inmueble nInmueble ) de la InterfazFincaRaiz
    	// Ayuda: Verifique el inmueble seleccionado sea distinto de null antes de hacer cualquier cosa
        
        if( listaInmuebles.getSelectedValue( ) != null )
        {
            Inmueble i = ( Inmueble )listaInmuebles.getSelectedValue( );
            InterfazFincaRaiz.actualizar( i );
        }


    }

}
