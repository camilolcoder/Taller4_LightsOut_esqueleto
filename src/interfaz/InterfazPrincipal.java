package interfaz;
import uniandes.dpoo.taller4.modelo.Tablero;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class InterfazPrincipal extends JFrame {

    private int tamanoTablero = 5;
    private int dificultad = 3;
    //private Tablero tablero = new Tablero(tamanoTablero);
    private Tablero tablero;

    private PanelDificultad  panelDificultad;
    private PanelTablero panelTablero;
    private PanelOpcionesEste panelOpcionesEste;
    private PanelDatosJugadas panelDatosJugadas;

    public InterfazPrincipal()
    {
        tablero = new Tablero(tamanoTablero);
        tablero.desordenar(dificultad);
        setTitle("LightsOut");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout( new BorderLayout() );

        panelDificultad = new PanelDificultad(this);
        add(panelDificultad, BorderLayout.NORTH);
        panelDificultad.setBackground(Color.BLUE);

        panelTablero = new PanelTablero(this, tablero);
        add(panelTablero, BorderLayout.CENTER);

        panelOpcionesEste = new PanelOpcionesEste(this);
        add(panelOpcionesEste, BorderLayout.EAST);

        panelDatosJugadas = new PanelDatosJugadas(this);
        add(panelDatosJugadas, BorderLayout.SOUTH);
    }

    /*public void jugar(int casillaY, int casillaX)
    {
        tablero.jugar(casillaY, casillaX);
    }

    public boolean[][] darTablero()
    {
        //tablero = new Tablero(tamanoTablero);
        return tablero.darTablero();
    }*/

    public void setDificultad(int cantidad)
    {
        dificultad = cantidad;
    }

    public void desordenar()
    {
        tablero.desordenar(dificultad);
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

    public void updateJugador(String nuevoJugador)
    {
        panelDatosJugadas.nuevoJugador(nuevoJugador);
    }

    public int getJugadas()
    {
        return tablero.darJugadas();
    }

    public void countJugada()
    {
        panelDatosJugadas.jugadas();
    }

    public boolean checkIluminado()
    {
        return tablero.tableroIluminado();
    }

    public void reiniciar()
    {
        tablero.reiniciar();
    }

    public void showWinner()
    {
        JDialog dialog = new JDialog();
        dialog.setVisible(true);
        dialog.setSize(300,300);
        dialog.setLocationRelativeTo(this);
        dialog.add(new JLabel("felicidades ganaste"));
    }

    public static void main(String[] args)
    {
        InterfazPrincipal ventana = new InterfazPrincipal();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
