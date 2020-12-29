package com.alhous.emam.samamarketing.beans;

import com.alhous.emam.samamarketing.entites.Client;

/**
 *
 * @author silah
 */
public class ClientFormat {

    private String nom;
    private String numero;
    private long id;
    private boolean selected = false;

    public ClientFormat() {
    } 
    
    

    public ClientFormat(Client client) {
        id = client.getId();
        nom = client.getNom();
        numero = client.getNumero();
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }  
    

}
