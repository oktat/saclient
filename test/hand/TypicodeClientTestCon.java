package hand;

import hu.szit.Client;

public class TypicodeClientTestCon {
    static String host = "https://jsonplaceholder.typicode.com/users";
    public static void main(String[] args) {
        getTest();
        postTest();
        putTest();
        deleteTest();
    }
    public static void getTest() {
        Client client = new Client();
        String result = client.get(host);
        System.out.println(result);
    }
    public static void postTest() {
        Client client = new Client();
        String body = "{ \"username\": \"Por Péter\" }";
        String result = client.post(host, body);
        System.out.println(result);
    }
    public static void putTest() {
        Client client = new Client();
        String body = "{ \"username\": \"Por Péter\" }";
        String result = client.put(host + "/1", body);
        System.out.println(result);
    }
    public static void deleteTest() {
        Client client = new Client();
        String result = client.delete(host + "/1");
        System.out.println(result);
    }
}
