package com.alhous.emam.samamarketing.beans;

import com.alhous.emam.samamarketing.ejb.ClientFacade;
import com.alhous.emam.samamarketing.ejb.MessageFacade;
import com.alhous.emam.samamarketing.entites.Client;
import com.alhous.emam.samamarketing.entites.Message;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author silah
 */
@Named(value = "message")
@ViewScoped
public class MessageController implements Serializable {

    private Message msg = new Message();
    private List<Client> clients = new ArrayList();
    private Client client = new Client();

    private List<ClientFormat> contacts = new ArrayList();
    private ClientFormat contact = new ClientFormat();
    private List<ClientFormat> selectedContacts = new ArrayList();

    private boolean tous;
    private boolean quelques;
    private boolean renderContact;

    @Inject
    ClientFacade cf;

    @Inject
    MessageFacade mf; 

    boolean exist = false; 
    @PostConstruct
    public void init() {
        cf.findAll().stream().forEach(c -> {
            ClientFormat cfm = new ClientFormat(c);
            contacts.add(cfm);
        });
    }

    public void addClient(ClientFormat clf) {
        selectedContacts.stream().filter(c -> c.getId() == clf.getId()).findFirst().ifPresent(c1 -> {
            selectedContacts.remove(c1);
            exist = true;
        });
        if (exist == false) {
            selectedContacts.add(clf);
        }

    }    
    
    public void sendMessage(){
                
    }

    public void selectAll() {
        quelques = false;
        renderContact = false;
    }

    public void selectSome() {
        tous = false;
        renderContact = true;

    }

    public Message getMsg() {
        return msg;
    }

    public void setMsg(Message msg) {
        this.msg = msg;
    }

    public void send() {
        msg.setDateEnvoi(new Date());
        msg.setHeure(new Date());        
        
    }

    public MessageController() {
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ClientFormat> getContacts() {
        return contacts;
    }

    public void setContacts(List<ClientFormat> contacts) {
        this.contacts = contacts;
    }

    public ClientFormat getContact() {
        return contact;
    }

    public void setContact(ClientFormat contact) {
        this.contact = contact;
    }

    public boolean isRenderContact() {
        return renderContact;
    }

    public void setRenderContact(boolean renderContact) {
        this.renderContact = renderContact;
    }

    public boolean isTous() {
        return tous;
    }

    public void setTous(boolean tous) {
        this.tous = tous;
    }

    public boolean isQuelques() {
        return quelques;
    }

    public void setQuelques(boolean quelques) {
        this.quelques = quelques;
    }

    public List<ClientFormat> getSelectedContacts() {
        return selectedContacts;
    }

    public void setSelectedContacts(List<ClientFormat> selectedContacts) {
        this.selectedContacts = selectedContacts;
    }

}
