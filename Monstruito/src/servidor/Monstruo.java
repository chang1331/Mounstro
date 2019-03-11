/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

/**
 *
 * @author jchango
 */
public class Monstruo {
    private int id;
    private int pos;
    private int color;

    public Monstruo(int id, int pos, int color) {
        this.id = id;
        this.pos = pos;
        this.color = color;
    }

    public int getId() {
        return id;
    }


    public int getPos() {
        return pos;
    }


    public int getColor() {
        return color;
    }


    public boolean equals (Monstruo obj) {

        if (this.id != obj.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pos+ " "+ color;
    }
    
    
    
    
}
