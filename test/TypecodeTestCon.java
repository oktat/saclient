import hu.szit.Client;

public class TypecodeTestCon {
    static String url = "https://jsonplaceholder.typicode.com/users";
    public static void main(String[] args) {
        // getTest();
        // postTest();
        putTest();
        // deleteTest();
    }
    public static void getTest() {
        Client client = new Client();
        String result = client.get(url);
        System.out.println(result);
    }
    public static void postTest() {
        Client client = new Client();
        String body = "{ \"username\": \"Por Péter\" }";
        String result = client.post(url, body);
        System.out.println(result);
    }
    public static void putTest() {
        Client client = new Client();
        String body = "{ \"username\": \"Por Péter\" }";
        String result = client.put(url + "/1", body);
        System.out.println(result);
    }
    public static void deleteTest() {
        Client client = new Client();
        String result = client.delete(url + "/1");
        System.out.println(result);
    }


}
