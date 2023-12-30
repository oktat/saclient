# saclient

Java Client for REST API

## Dokumentáció

* [https://oktat.github.io/saclient/](https://oktat.github.io/saclient/)

## Letöltés

* [https://github.com/oktat/saclient/releases/](https://github.com/oktat/saclient/releases/)

## Példa

Hivatkozzuk meg a saclient.jar programozói könyvtárat a projektünkben.

REST API szervertől lekérés GET metódussal:

```java
String url = "http://valahol/valamik";
Client client = new Client();
String result = client.get(url);
System.out.println(result);
```

REST API szerveren például, új felhasználó felvétele, POST metódussal:

```java
String url = "http://valahol/valamik";
Client client = new Client();
String body = "{ \"username\": \"Por Péter\" }";
String result = client.post(url, body);
System.out.println(result);
```

REST API szerveren például, felhasználó módosítása, PUT metódussal:

```java
String url = "http://valahol/valamik";
Client client = new Client();
String body = "{ \"username\": \"Por Péter\" }";
String result = client.put(url + "/1", body);
System.out.println(result);
```

REST API szerveren például, felhasználó törlése, DELETE metódussal:

```java
String url = "http://valahol/valamik";
Client client = new Client();
String result = client.delete(url + "/1");
System.out.println(result);
```

REST API szerverről lekért JSON sztring átalakítása Java objektummá:

Készítsünk egy modellt:

```java
public class User {    
    String name;
    String username;    
}
```

Átalakítás:

```java
String url = "http://valahol/valamik";
Client client = new Client();
String result = client.get(url);
ArrayList<User> userList = Convert.toObject(result, User.class);
for(User user : userList) {
    System.out.println(user.name);
}
```

Java objektum átalakítása JSON sztringgé:

A User osztályban szükség van egy konstruktorra, ami előkészíti a name és username mezőket:

```java
public class User {    
    String name;
    String username;
    public User(String name, String username) {
        this.name = name;
        this.username = username;
    }    
}
```

JSON sztring készítése:

```java
String url = "http://valahol/valamik";
ArrayList<User> userList = new ArrayList<>();
userList.add(new User("Erős István", "erosi"));
userList.add(new User("Kiss Mária", "kissm"));
String json = Convert.toJson(userList);
System.out.println(json);
```
