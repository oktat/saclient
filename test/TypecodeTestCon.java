
import java.util.ArrayList;

import hu.szit.Client;
import hu.szit.Convert;

public class TypecodeTestCon {
    static String url = "https://jsonplaceholder.typicode.com/users";
    public static void main(String[] args) {
        // getTest();
        // postTest();
        // putTest();
        // deleteTest();
        toObject();
        // toJson();
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
    public static void toObject() {
        
        String json = "[" +
            "{\"name\": \"Erős István\", \"city\": \"Szeged\"}," +
            "{\"name\": \"Beri Béla\", \"city\": \"Szolnok\"}" +
        "]";
        ArrayList<Employee> empList = Convert.toObject(json, Employee.class);

        for(Employee emp : empList) {
            System.out.println(emp.name);
        }
    }
    public static void toJson() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("John", "New York"));
        employeeList.add(new Employee("Alice", "London"));
        String json = Convert.toJson(employeeList);
        System.out.println(json);
    }
}
