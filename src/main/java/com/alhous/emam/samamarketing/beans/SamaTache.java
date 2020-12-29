package com.alhous.emam.samamarketing.beans;

import com.alhous.emam.samamarketing.ejb.ClientFacade;
import com.alhous.emam.samamarketing.ejb.GerantFacade;
import com.alhous.emam.samamarketing.entites.Client;
import com.alhous.emam.samamarketing.entites.Gerant;
import com.alhous.emam.samamarketing.entites.Message;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author silah
 */
@Named(value = "samaTache")
@RequestScoped
public class SamaTache {

    private Message msg;
    private Client client = new Client();
    private Gerant gerant = new Gerant();

    @Inject
    FacesContext context;

    @Inject
    ClientFacade cf;
    
    @Inject 
    GerantFacade gf;
    
   

    public void supprimer(Client client) {
        cf.remove(client);
        context.addMessage(null, new FacesMessage("Client supprimé avec succès !", client.getNom() + " -> " + client.getNumero()));
        MesClients();
    }

    public void modifier(Client client) {
        String nom = this.client.getNom();
        String numero = this.client.getNumero();
        
        client.setNom((nom != null || !nom.isEmpty()) ? this.client.getNom() : client.getNom());
        client.setNumero((numero != null || !numero.isEmpty()) ? this.client.getNumero() : client.getNumero());
        cf.edit(client);
        context.addMessage(null, new FacesMessage("Modification effectuée avec succès !", client.getNom() + " -> " + client.getNumero()));
        MesClients();
    }

    public void enregistrer() {
        cf.create(client);
        context.addMessage(null, new FacesMessage("Client ajouté avec succès !", client.getNom() + " -> " + client.getNumero()));

    }

    public void ajouterClient() {
        try {
            getExternalContext().redirect("/SamaMarketing/admin/nouveau-client.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(SamaTache.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void MesClients() {
        try {
            getExternalContext().redirect("/SamaMarketing/admin/mes-clients.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(SamaTache.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void historique() {
        try {
            getExternalContext().redirect("/SamaMarketing/admin/historique.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(SamaTache.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void parametres() {
        try {
            getExternalContext().redirect("/SamaMarketing/admin/param.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(SamaTache.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ExternalContext getExternalContext() {
        return context.getExternalContext();
    }

    public SamaTache() {
    }

    public Message getMsg() {
        return msg;
    }

    public void setMsg(Message msg) {
        this.msg = msg;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Gerant getGerant() {
        return gerant;
    }

    public void setGerant(Gerant gerant) {
        this.gerant = gerant;
    }
    

    public void logout() {

    }

    public void home() {
        try {
            getExternalContext().redirect("/SamaMarketing/admin/index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(SamaTache.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
