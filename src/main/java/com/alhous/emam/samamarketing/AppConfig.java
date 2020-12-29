package com.alhous.emam.samamarketing;

import com.alhous.emam.samamarketing.ejb.GerantFacade;
import com.alhous.emam.samamarketing.entites.Gerant;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.faces.annotation.FacesConfig;
import javax.inject.Inject;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author silahi
 */
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "jdbc/samamarketing",
        callerQuery = "select password from gerant where numero = ?",
        groupsQuery = "select nom from gerant where numero = ? "
)
@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/login.xhtml",
                errorPage = "",
                useForwardToLogin = false
        )
)

@FacesConfig(
        version = FacesConfig.Version.JSF_2_3
)
@Named(value = "appConfig")
@ApplicationScoped
public class AppConfig {

    @Inject
    Pbkdf2PasswordHash pph;

    @Inject
    GerantFacade gf;

    public void execute(@Observes @Initialized(ApplicationScoped.class) Object event) {
        if (gf.findAll().isEmpty()) {
            Gerant admin = new Gerant();
            admin.setNom("Admin");
            admin.setNumero("781585646");
            admin.setPassword(pph.generate("samamarketing".toCharArray()));
            gf.create(admin);
        }

    }

    public AppConfig() {
    }

}
