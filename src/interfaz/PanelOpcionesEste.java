package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelOpcionesEste extends JPanel implements ActionListener {

    private InterfazPrincipal principal;

    public final static String NUEVO = "nuevo";
    public final static String REINICIAR = "reiniciar";
    public final static String TOP10 = "top10";
    public final static String CAMJUGA = "cambiarJugador";

    private JButton nuevo;
    private JButton reiniciar;
    private JButton top10;
    private JButton cambiarJugador;

    public PanelOpcionesEste(InterfazPrincipal Pprincipal)
    {
        principal = Pprincipal;

        setLayout(new GridLayout(4, 1));
        nuevo = new JButton("Nuevo");
        nuevo.setActionCommand(NUEVO);
        nuevo.addActionListener(this);
        add(nuevo);

        reiniciar = new JButton("Reiniciar");
        reiniciar.setActionCommand(REINICIAR);
        reiniciar.addActionListener(this);
        add(reiniciar);

        top10 = new JButton("TOP-10");
        top10.setActionCommand(TOP10);
        top10.addActionListener(this);
        add(top10);

        cambiarJugador = new JButton("Cambiar Jugador");
        cambiarJugador.setActionCommand(CAMJUGA);
        cambiarJugador.addActionListener(this);
        add(cambiarJugador);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();
        if (comando.equals(NUEVO))
        {
            System.out.println("Nuevo was pressed");
        }
        else if (comando.equals(REINICIAR))
        {
            System.out.println("Reiniciar was pressed");
            principal.reiniciar();
            principal.desordenar();
        }
        else if (comando.equals(TOP10))
        {
            System.out.println("TOP 10 was pressed");
        }
        else if (comando.equals(CAMJUGA))
        {
            System.out.println("Cambiar jugador was pressed was pressed");
            String jugadorNuevo = JOptionPane.showInputDialog(this, "Escriba su nombre");
            principal.updateJugador(jugadorNuevo);
        }
    }
}
