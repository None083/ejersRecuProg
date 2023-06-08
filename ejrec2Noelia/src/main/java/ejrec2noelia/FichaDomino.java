/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejrec2noelia;

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
        return "FichaDomino{" + "ladoIzdo=" + ladoIzdo + ", ladoDer=" + ladoDer + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.ladoIzdo;
        hash = 61 * hash + this.ladoDer;
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
        if (this.ladoIzdo != other.ladoIzdo) {
            return false;
        }
        return this.ladoDer == other.ladoDer;
    }
    
    
    
}
