/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animacion_deslizamiento;

import java.awt.Component;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author LENOVO
 */
public class Slide_mostrar extends JLayeredPane{

    private final JPanel panel;
    private final Animator animacion;
    private final MigLayout layout;
    private Component componenteMostrar;
    private Component componenteOut;
    private int currentIndex;
    private boolean next;
    
    public Slide_mostrar(){
        layout = new MigLayout("inset 0");
        panel = new JPanel();
        TimingTarget target = new TimingTargetAdapter(){
            
            @Override
            public void begin(){
                componenteMostrar.setVisible(true);
                componenteOut.setVisible(true);
            }
            @Override
            public void timingEvent(float fraction){
                double with = panel.getWidth();
                int location = (int) (with * fraction);
                int LocationShow = (int) (with * (1f- fraction));
                if(next){
                    layout.setComponentConstraints(componenteMostrar,"pos " + LocationShow + " 0 100% 100%, w 100%!");
                    layout.setComponentConstraints(componenteOut,"pos -" +location+" 0 "+ (with - location)+ " 100%");
                }else{
                    layout.setComponentConstraints(componenteMostrar,"pos -" +LocationShow+" 0 "+ (with - LocationShow)+ " 100%");
                    layout.setComponentConstraints(componenteOut,"pos " + location + " 0 100% 100%, w 100%!");
                    
                }
                panel.revalidate();
            }
            @Override
            public void end(){
                componenteOut.setVisible(false);
                layout.setComponentConstraints(componenteMostrar, "pos 0 0 100% 100%, width 100%");
            }
    };
        animacion = new Animator(1000,target);
        animacion.setResolution(0);
        animacion.setAcceleration(0.5f);
        animacion.setDeceleration(0.5f);
        panel.setLayout(layout);
        setLayout(new MigLayout("fill, inset 0","[fill, center]", "3[fill]3"));
        add(panel,"w 100%-6%!");
    
    }
    
    public void initSlide_mostrar(Component... coms){
        if(coms.length>=2){
            for(Component com:coms){
                com.setVisible(false);
                panel.add(com,"pos 0 0 0 0");
            }
            if(panel.getComponentCount()>0){
                componenteMostrar = panel.getComponent(0);
                componenteMostrar.setVisible(true);
                layout.setComponentConstraints(componenteMostrar, "pos 0 0 100% 100%");
            }
        }
    }
    
    public void next(){
        if(!animacion.isRunning()){
            next = true;
            currentIndex = getNext(currentIndex);
            componenteMostrar = panel.getComponent(currentIndex);
            componenteOut = panel.getComponent(checkNext(currentIndex-1));
            animacion.start();
        }
    }
    
    public void back(){
        if(!animacion.isRunning()){
            next = false;
            currentIndex = getBack(currentIndex);
            componenteMostrar = panel.getComponent(currentIndex);
            componenteOut = panel.getComponent(checkBack(currentIndex+1));
            animacion.start();
        }
    }
    
    private int getNext(int index){
        if (index == panel.getComponentCount()-1) {
            return 0;
        }else{
            return index +1;
        }
    }
    
    private int checkNext(int index){
     if(index == -1){
         return panel.getComponentCount()-1;
     }else{
         return index;
     }
        
    }
    private int getBack(int index){
        if(index==0){
            return panel.getComponentCount()-1;
        }else{
            return index-1;
        }
    }
    
    private int checkBack(int index){
        if(index == panel.getComponentCount()){
            return 0;
        }else{
            return index;
        }
    }
}
