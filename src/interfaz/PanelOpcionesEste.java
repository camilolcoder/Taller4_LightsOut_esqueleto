package interfaz;

import javax.swing.*;
import java.awt.*;

public class PanelOpcionesEste extends JPanel {

    private InterfazPrincipal principal;

    private JButton nuevo;
    private JButton reiniciar;
    private JButton top10;
    private JButton cambiarJugador;

    public PanelOpcionesEste(InterfazPrincipal Pprincipal)
    {
        principal = Pprincipal;

        setLayout(new GridLayout(4, 1));
        nuevo = new JButton("Nuevo");
        add(nuevo);

        reiniciar = new JButton("Reiniciar");
        add(reiniciar);

        top10 = new JButton("TOP-10");
        add(top10);

        cambiarJugador = new JButton("Cambiar Jugador");
        add(cambiarJugador);

    }
}
