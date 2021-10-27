package interfaz;

import javax.swing.*;
import java.awt.*;

public class PanelDatosJugadas extends JPanel {

    private InterfazPrincipal principal;

    private String nombreJugador = "invitado";

    private JLabel jugadasText;
    private JLabel jugadas;
    private JLabel jugadorText;
    private JLabel jugador;

    public PanelDatosJugadas(InterfazPrincipal Pprincipal)
    {
        principal = Pprincipal;
        setLayout(new GridLayout(1, 4));
        jugadasText = new JLabel("Jugadas:");
        add(jugadasText);

        jugadas = new JLabel("0");
        add(jugadas);

        jugadorText = new JLabel("Jugador:");
        add(jugadorText);

        jugador = new JLabel("Invitado");
        add(jugador);
    }

    public void nuevoJugador(String jugadorNuevo)
    {
        jugador.setText(jugadorNuevo);
        nombreJugador = jugadorNuevo;
    }
    public void jugadas()
    {
        jugadas.setText(String.valueOf(principal.getJugadas()));
    }
    public void reiniciarContador()
    {
        jugadas.setText("0");
    }

    public String getJugador()
    {
        return nombreJugador;
    }
}
