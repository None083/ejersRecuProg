/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejrec5noelia;

/**
 *
 * @author noelia
 */
public class Pelicula {
    
    private String url;

    public Pelicula(String url) {
        this.url = url;
    }

    public Pelicula() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "url=" + url + '}';
    }
    
    
    
}
