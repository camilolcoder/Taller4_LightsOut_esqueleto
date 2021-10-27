package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDificultad extends JPanel implements ActionListener {

    private InterfazPrincipal principal;

    public final static String FACIL = "facil";
    public final static String MEDIO = "medio";
    public final static  String DIFICIL = "dificil";
    public final static String TABLERO = "tablero";

    private JRadioButton facil;
    private JRadioButton medio;
    private JRadioButton dificil;
    private JComboBox tamanoTablero;
    private ButtonGroup difs;

    private int tamano;

    public PanelDificultad(InterfazPrincipal Pprincipal)
    {
        principal = Pprincipal;
        String tamanos[] = {"5x5", "6x6", "7x7"};

        setLayout(new GridLayout(1, 4));
        //setBackground(Color.BLUE);
        tamanoTablero = new JComboBox(tamanos);
        add(tamanoTablero);

        difs = new ButtonGroup();

        facil = new JRadioButton("Facil");
        facil.setActionCommand(FACIL);
        facil.addActionListener(this);
        add(facil);

        medio = new JRadioButton("Medio");
        medio.setActionCommand(MEDIO);
        medio.addActionListener(this);
        add(medio);

        dificil = new JRadioButton("Dificil");
        dificil.setActionCommand(DIFICIL);
        dificil.addActionListener(this);
        add(dificil);

        difs.add(facil);
        difs.add(medio);
        difs.add(dificil);

    }

    @Override
    public void actionPerformed(ActionEvent pEvento)
    {
        String comando = pEvento.getActionCommand();
        String tamano = (String) tamanoTablero.getItemAt(tamanoTablero.getSelectedIndex());
        if (comando.equals(FACIL))
        {
            System.out.println("You pressed facil");
            System.out.println(tamano);
            principal.setDificultad(4);
        }
        else if (comando.equals(MEDIO))
        {
            System.out.println("You pressed medio");
            principal.setDificultad(8);
        }
        else if (comando.equals(DIFICIL))
        {
            System.out.println("You pressed dificil");
            principal.setDificultad(16);
        }
        if(tamano.equals("5x5"))
        {
            principal.darTamanoTablero(5);
            System.out.println("tamno 5");
        }
        if(tamano.equals("6x6"))
        {
            principal.darTamanoTablero(6);
            System.out.println("tamno 6");
        }
        if(tamano.equals("7x7"))
        {
            principal.darTamanoTablero(7);
            System.out.println("tamno 7");
        }

    }

    public int getTamano()
    {
        return tamano;
    }
}
