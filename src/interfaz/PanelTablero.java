package interfaz;

import uniandes.dpoo.taller4.modelo.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

public class PanelTablero extends JPanel implements MouseListener {

    private InterfazPrincipal principal;

    public PanelTablero(InterfazPrincipal Pprincipal)
    {
        principal = Pprincipal;
        //setSize(500,500);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        int x_cor = 0;
        int y_cor = 0;
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
                Rectangle2D rect = new Rectangle2D.Double(x_cor, y_cor, 50, 50);
                g2d.setColor(Color.BLUE);
                g2d.fill(rect);
                g2d.setColor(Color.BLACK);
                g2d.draw(rect);
                x_cor += 50;
            }
            x_cor = 0;
            y_cor += 50;
        }
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
        principal.jugar(casilla[0], casilla[1]);
        //this.ultima_fila = casilla[0];
        //this.ultima_columna = casilla[1];
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
        int ladoTablero = 5; //tablero.length;
        int altoPanelTablero = getHeight();
        int anchoPanelTablero = getWidth();
        int altoCasilla = altoPanelTablero / ladoTablero;
        int anchoCasilla = anchoPanelTablero / ladoTablero;
        int fila = (int) (y / altoCasilla);
        int columna = (int) (x / anchoCasilla);
        return new int[]{fila, columna};
    }

}
