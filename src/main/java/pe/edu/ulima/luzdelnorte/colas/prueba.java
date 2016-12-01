/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.ulima.luzdelnorte.colas;

import pe.edu.ulima.luzdelnorte.model.Registro;

/**
 *
 * @author Diego Torres
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Registro reg = new Registro();
        
//        reg.setIdsum(1234567);
//        reg.setLectura(9863);
//        
//        Server s = new Server();
//        
//        s.mandarCola(reg);
        
        Client c = new Client();
        
        c.leerCola();
       
                
    }
    
}
