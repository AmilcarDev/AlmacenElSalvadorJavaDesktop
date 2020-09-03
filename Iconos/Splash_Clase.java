/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wer;

import javax.swing.JProgressBar;

/**
 *
 * @author Baltazar
 */
public class Splash_Clase extends Thread{
    JProgressBar progreso;
   

    Splash_Clase(JProgressBar progreso) {
         super();
        this.progreso=progreso;
    }
    @Override
    public void run(){
        for(int i=1;i<=100;i++){
            progreso.setValue(i);
            pausa(1000);
        }
    }
    public void pausa(int mlSeg){
        try{
            Thread.sleep(mlSeg);
        }catch(Exception e){
            
        }
    }
    
    
}
