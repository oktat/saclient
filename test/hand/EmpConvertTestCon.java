package hand;

import java.util.ArrayList;

import hu.szit.Convert;
/*
 * A konverzió tesztelése dolgozókkal
 */
public class EmpConvertTestCon {

    public static void main(String[] args) {
        toListObject();
        listToJson();
    }
    public static void toListObject() {
        
        String json = "[" +
            "{\"name\": \"Erős István\", \"city\": \"Szeged\"}," +
            "{\"name\": \"Beri Béla\", \"city\": \"Szolnok\"}" +
        "]";
        ArrayList<Employee> empList = Convert.toListObject(json, Employee.class);

        for(Employee emp : empList) {
            System.out.println(emp.name);
        }
    }
    public static void listToJson() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("John", "New York"));
        employeeList.add(new Employee("Alice", "London"));
        String json = Convert.listToJson(employeeList);
        System.out.println(json);
    }    
}
