/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejrec2noelia;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author noelia
 */
public class FichaDomino {

    private int ladoIzdo;
    private int ladoDer;

    public FichaDomino() {
    }

    public FichaDomino(int ladoIzdo, int ladoDer) {
        this.ladoIzdo = ladoIzdo;
        this.ladoDer = ladoDer;
    }

    public int getLadoIzdo() {
        return ladoIzdo;
    }

    public void setLadoIzdo(int ladoIzdo) {
        this.ladoIzdo = ladoIzdo;
    }

    public int getLadoDer() {
        return ladoDer;
    }

    public void setLadoDer(int ladoDer) {
        this.ladoDer = ladoDer;
    }

    @Override
    public String toString() {
        return ladoIzdo + " - " + ladoDer;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.ladoIzdo + this.ladoDer;
        hash = 61 * hash + this.ladoDer + this.ladoIzdo;
        return hash;
    }

     
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FichaDomino other = (FichaDomino) obj;
        if ((ladoIzdo == other.ladoIzdo && ladoDer == other.ladoDer)
                || (ladoIzdo == other.ladoDer && ladoDer == other.ladoIzdo)) {
            return true;
        } else {
            return false;
        }
    }
    
    public static Set<FichaDomino> generarDominoCompleto(){
        Set<FichaDomino> domino = new HashSet<>();
        
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                domino.add(new FichaDomino(i, j));
            }
        }
        
        return domino;
    }

}
