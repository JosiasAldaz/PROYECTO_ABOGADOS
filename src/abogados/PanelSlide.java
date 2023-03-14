
package abogados;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;


public class PanelSlide extends javax.swing.JPanel {


    public PanelSlide() {
        initComponents();
        list = new ArrayList<>();
        tiempo = new Timer(0, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                animacion();
                }
            
        });
    }

    private final List<Component> list; 
    private final Timer tiempo;
    private Component comeExit;
    private Component comeShow;  
    private int currentShowing;
    private boolean animateRight;
    
    public void primerelemento(Component com){
        com.setSize(getSize());
        com.setVisible(false);
        list.add(com);
        this.add(com);
        if (list.size() == 1) { // Si es el primer componente, mostrarlo
            com.setVisible(true);
            com.setLocation(0, 0);
        }
    }
            
    public void init (Component ...com){
        if(com.length>0){
            for (Component c:com) {
                list.add(c);
                c.setSize(getSize());
                c.setVisible(false);
                this.add(c);
            }
            //OBTENER EL PANLE PARA MOSTRAR
            Component show = list.get(0);
            show.setVisible(true);
            show.setLocation(0,0);
        }
    }
    
    public void show(int index){
        if(!tiempo.isRunning()){
            if(list.size()>1 && index<=list.size() && index != currentShowing){
                comeShow = list.get(index);
                comeExit  = list.get(currentShowing);
                animateRight = index < currentShowing;
                currentShowing = index;
                comeShow.setVisible(true);
                if(animateRight){
                    comeShow.setLocation(-comeShow.getWidth(), 0);
                }else{
                    comeShow.setLocation(getWidth(), 0);
                }
                tiempo.start();
            }
        }
    }
    private void animacion(){
        if(animateRight){
            if(comeShow.getLocation().x<0){
               comeShow.setLocation(comeShow.getLocation().x+1, 0);
               comeExit.setLocation(comeExit.getLocation().x + 1, 0);
            }else{
                //PARAR LA ANIMCACIÓN
                comeShow.setLocation(0,0);
                tiempo.stop();
                comeExit.setVisible(false);
            }
        }else{
            if(comeShow.getLocation().x>0){
                comeShow.setLocation(comeShow.getLocation().x - 1, 0);
                comeExit.setLocation(comeExit.getLocation().x - 1, 0);
            }else{ 
                comeShow.setLocation(0,0);
                tiempo.stop();
                comeExit.setVisible(false);
            }
        }
    }
    
    public void borrarelementos(){
        
    }
    
    public int tamaño(){
        return list.size();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
