package com.alhous.emam.samamarketing.ejb;

import com.alhous.emam.samamarketing.entites.Client;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Startup
public class ClientFacade extends AbstractFacade<Client> {

    @PersistenceContext
    private EntityManager em;

    public ClientFacade() {
        super(Client.class);
    }

    public ClientFacade(Class<Client> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
