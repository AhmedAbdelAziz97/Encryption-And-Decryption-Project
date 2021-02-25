/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import javax.swing.UIManager;

/**
 *
 * @author Ahmed Abdelaziz
 */
public class ServerApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        try {
            UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        ServerFrame sframe = new ServerFrame();
        sframe.setVisible(true);
    }
}
