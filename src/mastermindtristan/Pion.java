/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermindtristan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author tristanguerin
 */
public class Pion {
    private static final List<Character> COLORS = new ArrayList<>(
            Arrays.asList('R', 'J', 'B', 'O', 'V', 'N'));
    
    private final char color;
    
    public Pion(){
        Random random = new Random();
        
        int num = random.nextInt(COLORS.size());
        
        color = COLORS.get(num);
    }
    
    public Pion(char userColor){
        if(COLORS.contains(userColor)){
            color = userColor;
        }else{
            color = 'X';
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.color;
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
        final Pion other = (Pion) obj;
        if (this.color != other.color) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+ color;
    }
    
    
}
