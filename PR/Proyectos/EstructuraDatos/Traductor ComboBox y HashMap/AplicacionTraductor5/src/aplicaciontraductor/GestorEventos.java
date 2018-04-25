package aplicaciontraductor;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author yo
 */
public class GestorEventos implements MouseListener{
    
    private Color colorAnterior;
    private Color colorAnterior2;
    
    @Override
    public void mouseClicked(MouseEvent e){}

    @Override
    public void mousePressed(MouseEvent e){}

    @Override
    public void mouseReleased(MouseEvent e){}

    @Override
    public void mouseExited(MouseEvent e){
        Component component = e.getComponent();
        component.setForeground(colorAnterior);
        component.setBackground(colorAnterior2);
        System.out.println("Fuera de Aqui :)");
    }

    @Override
    public void mouseEntered(MouseEvent e){
        Component component = e.getComponent();
        colorAnterior = component.getForeground();
        colorAnterior2 = component.getBackground();
        component.setForeground(java.awt.Color.BLUE);
        component.setBackground(Color.RED);
        System.out.println("Ninio que haces aqui :)");
    }
    
}
