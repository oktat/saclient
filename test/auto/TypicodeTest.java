package auto;
import org.testng.Assert;
import org.testng.annotations.Test;

import hu.szit.Client;

public class TypicodeTest {
    String url = "https://jsonplaceholder.typicode.com/users";
    @Test
    public void testGetUsers() {
        Client client = new Client();
        String body = client.get(url);
        boolean ok = body.contains("username");
        Assert.assertTrue(ok);        
    }
    @Test
    public void testPostUser() {
        Client client = new Client();
        String body = "{ \"username\": \"Por Péter\" }";
        String res = client.post(url, body);
        boolean ok = res.contains("username");
        Assert.assertTrue(ok);        
    }
    @Test
    public void testPutUser() {
        Client client = new Client();
        String body = "{ \"username\": \"Por Péter\" }";
        String res = client.put(url + "/1", body);
        boolean ok = res.contains("username");
        Assert.assertTrue(ok);
    }
    @Test
    public void testDeleteUser() {
        Client client = new Client();        
        String res = client.delete(url + "/1");
        boolean ok = res.contains("{}");
        Assert.assertTrue(ok);
    }

}
