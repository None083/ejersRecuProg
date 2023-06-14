/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejrec5noelia;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

@JsonPropertyOrder({
    "name",
    "height",
    "mass",
    "hair_color",
    "skin_color",
    "eye_color",
    "birth_year",
    "gender",
    "homeworld",
    "films",
    "species",
    "vehicles",
    "starships",
    "url"
})

/**
 *
 * @author noelia
 */
public class Personaje {
    
    @JsonProperty("name")
    private String nombre;
    @JsonProperty("height")
    private int altura;
    @JsonProperty("mass")
    private int peso;
    @JsonProperty("hair_color")
    private String colorPelo;
    @JsonProperty("skin_color")
    private String colorPiel;
    @JsonProperty("eye_color")
    private String colorOjos;
    @JsonProperty("birth_year")
    private String anyoNacim;
    @JsonProperty("gender")
    private String genero;
    @JsonProperty("homeworld")
    private String lugarNacim;
    @JsonProperty("films")
    private List<Pelicula> listaPeliculas;
    @JsonProperty("species")
    private List<Especie> listaEspecies;
    @JsonProperty("vehicles")
    private List<Vehiculo> listaVehiculos;
    @JsonProperty("starships")
    private List<NaveEspacial> listaNaves;
    @JsonProperty("url")
    private String url;
    
    public Personaje() {
    }

    public Personaje(String nombre, int altura, int peso, String colorPelo, String colorPiel, String colorOjos, String anyoNacim, String genero, String lugarNacim, List<Pelicula> listaPeliculas, List<Especie> listaEspecies, List<Vehiculo> listaVehiculos, List<NaveEspacial> listaNaves, String url) {
        this.nombre = nombre;
        this.altura = altura;
        this.peso = peso;
        this.colorPelo = colorPelo;
        this.colorPiel = colorPiel;
        this.colorOjos = colorOjos;
        this.anyoNacim = anyoNacim;
        this.genero = genero;
        this.lugarNacim = lugarNacim;
        this.listaPeliculas = listaPeliculas;
        this.listaEspecies = listaEspecies;
        this.listaVehiculos = listaVehiculos;
        this.listaNaves = listaNaves;
        this.url = url;
    }

    
    @JsonProperty("name")
    public String getNombre() {
        return nombre;
    }

    @JsonProperty("name")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonProperty("height")
    public int getAltura() {
        return altura;
    }

    @JsonProperty("height")
    public void setAltura(int altura) {
        this.altura = altura;
    }

    @JsonProperty("mass")
    public int getPeso() {
        return peso;
    }

    @JsonProperty("mass")
    public void setPeso(int peso) {
        this.peso = peso;
    }

    @JsonProperty("hair_color")
    public String getColorPelo() {
        return colorPelo;
    }

    @JsonProperty("hair_color")
    public void setColorPelo(String colorPelo) {
        this.colorPelo = colorPelo;
    }

    @JsonProperty("skin_color")
    public String getColorPiel() {
        return colorPiel;
    }

    @JsonProperty("skin_color")
    public void setColorPiel(String colorPiel) {
        this.colorPiel = colorPiel;
    }

    @JsonProperty("eye_color")
    public String getColorOjos() {
        return colorOjos;
    }

    @JsonProperty("eye_color")
    public void setColorOjos(String colorOjos) {
        this.colorOjos = colorOjos;
    }

    @JsonProperty("birth_year")
    public String getAnyoNacim() {
        return anyoNacim;
    }

    @JsonProperty("birth_year")
    public void setAnyoNacim(String anyoNacim) {
        this.anyoNacim = anyoNacim;
    }

    @JsonProperty("gender")
    public String getGenero() {
        return genero;
    }

    @JsonProperty("gender")
    public void setGenero(String genero) {
        this.genero = genero;
    }

    @JsonProperty("homworld")
    public String getLugarNacim() {
        return lugarNacim;
    }

    @JsonProperty("homeworld")
    public void setLugarNacim(String lugarNacim) {
        this.lugarNacim = lugarNacim;
    }

    @JsonProperty("films")
    public List<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }

    @JsonProperty("films")
    public void setListaPeliculas(List<Pelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    @JsonProperty("species")
    public List<Especie> getListaEspecies() {
        return listaEspecies;
    }

    @JsonProperty("species")
    public void setListaEspecies(List<Especie> listaEspecies) {
        this.listaEspecies = listaEspecies;
    }

    @JsonProperty("vehicles")
    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    @JsonProperty("vehicles")
    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    @JsonProperty("starships")
    public List<NaveEspacial> getListaNaves() {
        return listaNaves;
    }

    @JsonProperty("starships")
    public void setListaNaves(List<NaveEspacial> listaNaves) {
        this.listaNaves = listaNaves;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Personaje{" + "nombre=" + nombre + ", altura=" + altura + ", peso=" + peso + ", colorPelo=" + colorPelo + ", colorPiel=" + colorPiel + ", colorOjos=" + colorOjos + ", anyoNacim=" + anyoNacim + ", genero=" + genero + ", lugarNacim=" + lugarNacim + ", listaPeliculas=" + listaPeliculas + ", listaEspecies=" + listaEspecies + ", listaVehiculos=" + listaVehiculos + ", listaNaves=" + listaNaves + ", url=" + url + '}';
    }

    
    
    
    
}
