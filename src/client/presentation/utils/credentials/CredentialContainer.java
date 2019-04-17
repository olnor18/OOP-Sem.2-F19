/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package client.presentation.utils.credentials;

import java.util.Date;

/**
 *
 * @author Hounsvad
 */
public class CredentialContainer {

    private String password = null;
    private String username = null;
    private static CredentialContainer instance = null;
    private Date lastAccess;

    private CredentialContainer(String username, String password) {
        this.password = password;
        this.username = username;
    }

    private CredentialContainer getInstance() {
        if (instance == null) {
            getLogin();
        } else if (instance.lastAccess.before(new Date(System.currentTimeMillis() - 3600000))) {
            password = null;
            username = null;
            getLogin();
        }
        return instance;
    }

    private void getLogin() {

    }
}
