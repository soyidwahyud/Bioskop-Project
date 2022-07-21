/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioskopproject;
import backEnd.*;
import java.util.Random;
/**
 *
 * @author Rifaul06
 */
public class tryStudio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //c.save();
        //a.save();
        //b.save();
        for (Studio studio : new Studio().getAll()) {
            System.out.println("Studio: "+studio.getStudio()+", Film: "+studio.getFilm().getJudul());
        }
        Random rn = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(rn.nextInt(3));
        }
        
    }
    
}
