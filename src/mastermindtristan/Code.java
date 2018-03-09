/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermindtristan;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author tristanguerin
 */
public class Code {
    private List<Pion> pions;
    
    public Code(){
        this.pions = new ArrayList<>();
        
        for (int i=0; i<4; i++){
            this.pions.add(new Pion());
        }
    }
    
    public Code(String code){
        this.pions = new ArrayList<>();
        
        char[] userEntry = code.toCharArray();
        for(char c: userEntry){
            this.pions.add(new Pion(c));
        }
    }
    
    public int checkCorrect(Code c){
        int corrects = 0;
        for(int i = 0; i<c.getPions().size(); i++){
            if(c.getPions().get(i).equals(this.pions.get(i))){
                corrects++;
            }
        }
        return corrects;
    }
    
    public int checkColor(Code c){
        int corrects = 0;
        for(int i = 0; i<c.getPions().size(); i++){
            if(this.pions.contains(c.getPions().get(i))){
                corrects++;
            }
        }
        return corrects;
    }

    public List<Pion> getPions() {
        return pions;
    }  

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.pions);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Code other = (Code) obj;
        if (!Objects.equals(this.pions, other.pions)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String resp = "";
        for(Pion p: pions) resp+=p;
        return resp;
    }
    
    public static boolean checkValid(String input){
        if(input.matches("[ROBNVJ]{4}")) return true;
        return false;
    }
}
