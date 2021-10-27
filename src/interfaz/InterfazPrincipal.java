package interfaz;
import uniandes.dpoo.taller4.modelo.Tablero;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterfazPrincipal extends JFrame {

    private int tamanoTablero = 5;
    private int dificultad = 2;
    private String jugadorActual;
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

    /*public void desordenar()
    {
        tablero.desordenar(dificultad);
    }*/

    public void darTamanoTablero(int tamanoP)
    {
        //tablero = new Tablero(tamanoP);
        tamanoTablero = tamanoP;
        //tablero.setTamano(tamanoTablero);
        panelTablero.repaint();
    }

    public int getTamanoTablero()
    {
        return tamanoTablero;
    }

    public void updateJugador(String nuevoJugador)
    {
        panelDatosJugadas.nuevoJugador(nuevoJugador);
        jugadorActual = nuevoJugador;
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
        panelDatosJugadas.reiniciarContador();
        tablero.desordenar(dificultad);
        tablero.reiniciar();
    }

    public void showWinner()
    {
        JDialog dialog = new JDialog();
        dialog.setVisible(true);
        dialog.setSize(350,100);
        dialog.setLocationRelativeTo(panelTablero);
        dialog.setLayout(new GridLayout(3, 1));
        //dialog.add(new JLabel("felicidades ganaste", SwingConstants.CENTER));
        dialog.add(new JLabel("Felicidades "+panelDatosJugadas.getJugador()+" ganaste!!!", SwingConstants.CENTER));
        dialog.add(new JLabel("Obtuviste "+getPuntaje()+" puntos", SwingConstants.CENTER));
        //dialog.setBounds(400,323,34,44);
    }

    public int getPuntaje()
    {
        return tablero.calcularPuntaje();
    }

    public void getTop10()
    {

    }

    public void printTop10()
    {
        JDialog dialog = new JDialog();
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(this);
        dialog.setSize(400, 500);
        dialog.setLayout(new GridLayout(11, 1));
        String filepath = "C:\\Users\\juank\\Desktop\\Talleres\\Taller4_LightsOut_esqueleto\\src\\DataBase\\jugadores.csv" ;
        try(Scanner scanner = new Scanner(new File(filepath)))
        {
            scanner.useDelimiter(",");
            while (scanner.hasNext())
            {
                dialog.add(new JLabel(scanner.next() + "|"));
            }
            scanner.close();
        }
        catch (IOException e)
        {
            System.out.println("Error leyendo el archivo de la base de datos");
            e.printStackTrace();
        }
        //dialog.add(new JLabel("Felicidades "+panelDatosJugadas.getJugador()+" ganaste!!!", SwingConstants.CENTER));
        /*List textos = new ArrayList();
        for (String text : textos)
        {

        }*/
    }

    public String getJugador()
    {
        return jugadorActual;
    }

    public static void main(String[] args)
    {
        InterfazPrincipal ventana = new InterfazPrincipal();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
