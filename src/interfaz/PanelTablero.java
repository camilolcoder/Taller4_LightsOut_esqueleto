package interfaz;

import uniandes.dpoo.taller4.modelo.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.io.FileWriter;
import java.io.IOException;

public class PanelTablero extends JPanel implements MouseListener {

    private InterfazPrincipal principal;
    private Tablero tablero;
    private int ultima_fila;
    private int ultima_columna;

    public PanelTablero(InterfazPrincipal Pprincipal, Tablero tableroP)
    {
        principal = Pprincipal;
        tablero = tableroP;
        addMouseListener(this);
        //setSize(500,500);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        int deltaX = getWidth()/tablero.darTablero().length;
        int deltaY = getHeight()/tablero.darTablero().length;
        int cuadrados = 0;

        Graphics2D g2d = (Graphics2D) g;
        int tamanoTablero = principal.getTamanoTablero();
        if (tamanoTablero == 5)
        {
            cuadrados = 5;
        }
        else if (tamanoTablero == 6)
        {
            cuadrados = 6;
        }
        else if (tamanoTablero == 7)
        {
            cuadrados = 7;
        }
        for (int i = 0; i<cuadrados; i++)
        {
            for (int j = 0; j < cuadrados; j++)
            {
                if (tablero.darTablero()[i][j])
                {
                    Rectangle2D rect = new Rectangle2D.Double(i*deltaX, j*deltaY, deltaX, deltaY);
                    g2d.setColor(Color.YELLOW);
                    g2d.fill(rect);
                    g2d.setColor(Color.BLACK);
                    g2d.draw(rect);
                }
                else
                {
                    Rectangle2D rect = new Rectangle2D.Double(i*deltaX, j*deltaY, deltaX, deltaY);
                    g2d.setColor(Color.GRAY);
                    g2d.fill(rect);
                    g2d.setColor(Color.BLACK);
                    g2d.draw(rect);
                }
            }
        }
        updateUI();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        int click_x = e.getX();
        int click_y = e.getY();
        int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
        //cantidades[casilla[0]][casilla[1]]++;
        System.out.println("x: "+casilla[1]);
        System.out.println("y: "+casilla[0]);
        tablero.jugar(casilla[1], casilla[0]);
        this.ultima_fila = casilla[0];
        this.ultima_columna = casilla[1];
        principal.countJugada();
        boolean state = principal.checkIluminado();
        if (state)
        {
            String jugador = principal.getJugador();
            String puntos = String.valueOf(principal.getPuntaje());
            principal.showWinner();
            String filepath = "C:\\Users\\juank\\Desktop\\Talleres\\Taller4_LightsOut_esqueleto\\src\\DataBase\\jugadores.csv" ;
            StringBuilder stringBuilder = new StringBuilder();
            //stringBuilder.append("Name").append(",").append("Age").append(",").append("Sex").append("\n");
            stringBuilder.append(jugador).append(",").append(puntos).append("\n");
            try (FileWriter fileWriter = new FileWriter(filepath, true)) {
                fileWriter.write(stringBuilder.toString());
            } catch (IOException car) {
                car.printStackTrace();
            }
        }
        repaint();

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private int[] convertirCoordenadasACasilla(int x, int y) {
        int ladoTablero = tablero.darTablero().length; //tablero.length;
        int altoPanelTablero = getHeight();
        int anchoPanelTablero = getWidth();
        int altoCasilla = altoPanelTablero / ladoTablero;
        int anchoCasilla = anchoPanelTablero / ladoTablero;
        int fila = (int) (y / altoCasilla);
        int columna = (int) (x / anchoCasilla);
        return new int[]{fila, columna};
    }

}
