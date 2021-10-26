package interfaz;
import uniandes.dpoo.taller4.modelo.Tablero;

import javax.swing.JFrame;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class InterfazPrincipal extends JFrame {

    private Tablero tablero;
    private int tamanoTablero = 5;

    private PanelDificultad  panelDificultad;
    private PanelTablero panelTablero;
    private PanelOpcionesEste panelOpcionesEste;
    private PanelDatosJugadas panelDatosJugadas;

    public InterfazPrincipal()
    {
        setTitle("LightsOut");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout( new BorderLayout() );

        panelDificultad = new PanelDificultad(this);
        add(panelDificultad, BorderLayout.NORTH);
        panelDificultad.setBackground(Color.BLUE);

        panelTablero = new PanelTablero(this);
        add(panelTablero, BorderLayout.CENTER);

        panelOpcionesEste = new PanelOpcionesEste(this);
        add(panelOpcionesEste, BorderLayout.EAST);

        panelDatosJugadas = new PanelDatosJugadas(this);
        add(panelDatosJugadas, BorderLayout.SOUTH);
    }

    public static void main(String[] args)
    {
        InterfazPrincipal ventana = new InterfazPrincipal();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    public void jugar(int casillaY, int casillaX)
    {
        tablero.jugar(casillaY, casillaX);
    }

    public boolean[][] darTablero()
    {
        tablero = new Tablero(tamanoTablero);
        return tablero.darTablero();
    }

    public void darTamanoTablero(int tamanoP)
    {
        //tablero = new Tablero(tamanoP);
        tamanoTablero = tamanoP;
        panelTablero.repaint();
    }

    public int getTamanoTablero()
    {
        return tamanoTablero;
    }
}
