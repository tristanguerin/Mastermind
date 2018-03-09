/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermindtristan;

import java.util.Scanner;

/**
 *
 * @author tristanguerin
 */
public class Game {
    
    private int tentative;
    
    private final int MAX_TENTATIVE = 10;
    
    private boolean victoire;
    
    private final Code code;
    
    public Game(){
        this.tentative = 0;
        this.victoire = false;
        this.code = new Code();
    }
    
    public void run(){
        System.out.println("J’ai choisit ma combinaison, à vous de deviner !\n"
                + "Les couleurs possibles sont R J B O V et N.\n"
                + "Tapez RJBO pour tenter les couleurs R,J,B et O dans l’ordre.\n" 
                + "Voici la grille actuelle:");
        Scanner scan = new Scanner(System.in);
        //System.out.println("Secret code : "+this.code);
        String history = "|-------------------|\n";
        
        
        while(!this.victoire && tentative<MAX_TENTATIVE){
            System.out.print("Vous > ");
            String input = scan.nextLine();
            
            if(Code.checkValid(input)){
                Code userCode = new Code(input);

                if(userCode.equals(this.code)){
                    victoire = true;
                }

                int correct = this.code.checkCorrect(userCode);
                int goodColor = this.code.checkColor(userCode) - correct;

                tentative++;
                history += "|"+userCode+"| "+correct+" | "+goodColor+" | " +tentative+"/"+MAX_TENTATIVE+" |\n";
                System.out.println(history
                        +"|....| . | . | "+(tentative+1)+"/"+MAX_TENTATIVE+" |\n"
                        +"|-------------------|\n");
            }else{
                System.out.println("CODE INVALIDE, entrez 4 valeurs parmis R O B N V J.");
            }
            
            
        }
        
        if(this.victoire){
            System.out.println("Bravo, vous avez gagné en "+tentative+" coups !");
        }else{
            System.out.println("Raté, le code était "+code);
        }
    }
}
