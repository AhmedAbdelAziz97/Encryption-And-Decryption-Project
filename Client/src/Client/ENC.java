/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

/**
 *
 * @author Ahmed Abdelaziz
 */
public class ENC {
    public static String ENC1(String Message){
            char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray(); 
            char[] Data=Message.toCharArray();
            char ENC[]=new char[Data.length];
            int key=3;
            for(int j=0;j< Data.length;j++){
                for(int i=0;i<alpha.length;i++){
                    if(Data[j]==alpha[i]){
                        ENC[j]=alpha[(i+key+26)%26];
                    }}}
                   
        return ENC1(Message);
           
}
}