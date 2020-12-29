 
package com.alhous.emam.samamarketing.ejb;

import com.alhous.emam.samamarketing.entites.Message;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Startup
public class MessageFacade extends AbstractFacade<Message> {

    @PersistenceContext
    private EntityManager em;

    public MessageFacade() {
        super(Message.class);
    }

    public MessageFacade(Class<Message> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
