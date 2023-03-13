/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animacion_deslizamiento;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.border.EmptyBorder;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax
/**
 *
 * @author LENOVO
 */
public class EventoPagina extends JComponent{
    
    private int index;
    private int currentIndex;
    private EventoPagina event;

    public void setEventoPagina(EventoPagina event){
        this.event = event;
    }
    
    public void setIndex(int index){
        this.index = index;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }
    
    public void setTotalPage(int totalpage){
        
    }
    public EventoPagina() {
    }
    
    private class Item extends JButton{
        
//        public Item(int index, EventoPagina event){
//            setContentAreaFilled(false);
//            setBorder(new EmptyBorder(5, 5, 5, 5));
//            setBackground(Color.WHITE);
//            setCursor(new Cursor(Cursor.HAND_CURSOR));
//            addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    event.onClick(index);
//                    }
//            });
//           
//        }
    }
}
