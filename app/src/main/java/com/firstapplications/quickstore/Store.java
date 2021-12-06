package com.firstapplications.quickstore;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Store
{
    private int id_store;
    private String nombre;
    private String direccion;
    private String telefonoFijo;
    private String paginaWeb;
    private String categorias;
    private String geoLocalizacion;
    @JsonIgnore
    private int id_resorceImage;

    public Store()
    {

    }

    public Store(String nombre, String direccion, String telefonoFijo, String telefonoCelular, int image)
    {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonoFijo = telefonoFijo;
        this.paginaWeb = telefonoCelular;
        this.id_resorceImage = image;
    }

    public void setNombre(String nombre)
    {

        this.nombre = nombre;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    public void setTelefonoFijo(String telefonoFijo)
    {
        this.telefonoFijo = telefonoFijo;
    }

    public void setPaginaWeb(String paginaWeb)
    {
        this.paginaWeb = paginaWeb;
    }

    public void setId_resorceImage(int id_resorceImage)
    {
        this.id_resorceImage = id_resorceImage;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public String getTelefonoFijo()
    {
        return telefonoFijo;
    }

    public String getPaginaWeb()
    {
        return paginaWeb;
    }

    public int getId_resorceImage()
    {
        return id_resorceImage;
    }

    public void setId_store(int id_store)
    {
        this.id_store = id_store;
    }

    public int getId_store()
    {
        return id_store;
    }

    public String getCategorias()
    {
        return categorias;
    }

    public void setCategorias(String categorias)
    {
        this.categorias = categorias;
    }

    public String getGeoLocalizacion()
    {
        return geoLocalizacion;
    }

    public void setGeoLocalizacion(String geoLocalizacion)
    {
        this.geoLocalizacion = geoLocalizacion;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id_store=" + id_store +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefonoFijo='" + telefonoFijo + '\'' +
                ", paginaWeb='" + paginaWeb + '\'' +
                ", categorias='" + categorias + '\'' +
                ", geoLocalizcion='" + geoLocalizacion + '\'' +
                ", id_resorceImage=" + id_resorceImage +
                '}';
    }
}
