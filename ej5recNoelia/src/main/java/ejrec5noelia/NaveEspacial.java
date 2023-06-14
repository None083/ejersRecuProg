/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejrec5noelia;

/**
 *
 * @author noelia
 */
public class NaveEspacial {
    
    private String url;

    public NaveEspacial(String url) {
        this.url = url;
    }

    public NaveEspacial() {
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "NaveEspacial{" + "url=" + url + '}';
    }
    
    
    
}
