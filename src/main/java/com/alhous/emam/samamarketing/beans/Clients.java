package com.alhous.emam.samamarketing.beans;

import com.alhous.emam.samamarketing.ejb.ClientFacade;
import com.alhous.emam.samamarketing.entites.Client;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author silah
 */
@Named(value = "clients")
@RequestScoped
public class Clients {

    private List<Client> clients;
    @Inject
    ClientFacade cf;

    @PostConstruct
    public void init() {
        clients = cf.findAll();
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public ClientFacade getCf() {
        return cf;
    }

    public void setCf(ClientFacade cf) {
        this.cf = cf;
    }
     
    

    public Clients() {
    }

}
