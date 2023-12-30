package hand;

import java.util.ArrayList;

import hu.szit.Client;
import hu.szit.Convert;

public class TypecodeConvertTestCon {
    static String host = "https://jsonplaceholder.typicode.com/users";
    public static void main(String[] args) {
        usersToObject();
        // userToObject();
        // usersToJson();
        // userToJson();

    }
    public static void usersToObject() {
        Client client = new Client();
        String result = client.get(host);
        ArrayList<User> userList = Convert.toListObject(result, User.class);
        for(User user : userList) {
            System.out.println(user.name);
        }
    }
    public static void userToObject() {
        String url = host + "/1";
        Client client = new Client();
        String result = client.get(url);
        User user = Convert.toObject(result, User.class);        
        System.out.println(user.name);        
    }


    public static void usersToJson() {
        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User("Erős István", "erosi"));
        userList.add(new User("Kiss Mária", "kissm"));
        String json = Convert.listToJson(userList);
        System.out.println(json);
    }
    public static void userToJson() {        
        User user = new User("Erős István", "erosi");        
        String json = Convert.toJson(user);
        System.out.println(json);
    }
}
