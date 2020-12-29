package com.alhous.emam.samamarketing.ejb;

import com.alhous.emam.samamarketing.entites.Gerant;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Startup
public class GerantFacade extends AbstractFacade<Gerant> {

    @PersistenceContext
    private EntityManager em;

    public GerantFacade() {
        super(Gerant.class);
    }

    public GerantFacade(Class<Gerant> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
