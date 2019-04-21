/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package client.presentation.utils.credentials;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Hounsvad
 */
public class CredentialContainerTest {

    public CredentialContainerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setPassword method, of class CredentialContainer.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        CredentialContainer.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class CredentialContainer.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        CredentialContainer.setUsername(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class CredentialContainer.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        String expResult = "";
        String result = CredentialContainer.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class CredentialContainer.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        String expResult = "";
        String result = CredentialContainer.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
