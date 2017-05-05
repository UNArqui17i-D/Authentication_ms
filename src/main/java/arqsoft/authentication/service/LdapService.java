package arqsoft.authentication.service;

import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPException;
import java.io.UnsupportedEncodingException;

public class LdapService {

    private LDAPConnection lc = new LDAPConnection();

    public Boolean login(String user, String password){

        if (connect()) {
            if (validatePassword(user, password)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Boolean connect(){

        String ldapHost = "0.0.0.0";
        String dn = "cn=admin,dc=jarkko,dc=com";
        String password = "admin";

        int ldapPort =  LDAPConnection.DEFAULT_PORT;
        int ldapVersion = LDAPConnection.LDAP_V3;

        try {
            lc.connect(ldapHost, ldapPort);
            System.out.println("==== Connecting to LDAP Server ====");
            lc.bind(ldapVersion, dn, password.getBytes("UTF8"));
            System.out.println("==== Authenticated in server ====");
            return true;
        } catch (LDAPException | UnsupportedEncodingException ex) {
            System.out.println("==== ERROR to connecto to the LDAP Server ====");
            return false;
        }

    }

    public Boolean validatePassword(String user, String password){

        String dn = "cn=" + user + ",ou=Chat,dc=jarkko,dc=com";

        try {
            lc.bind(dn, password);
            System.out.println("==== Password validated ====");
            return true;
        } catch (LDAPException ex) {
            System.out.println("==== ERROR to validate the password ====");
            return false;
        }
    }
}
