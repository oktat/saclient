# saclient

Java Client for REST API.

Jelenleg azonosítással is képes működni a push(), put() és a delete() metódus. A fejlécben a token előtt a Bearer szó kerül átadásra, ami jelenleg nem állítható.

Ez a programozói könyvtár használja a következőket:

* gson
* jcommander
* slf4j-api

A .jar kiadásba be vannak építve.

## Dokumentáció

* [https://oktat.github.io/saclient/](https://oktat.github.io/saclient/)

A Client osztály képes token alapú azonosításra, ami jelenleg nincs dokumentálva.

## Letöltés

* [https://github.com/oktat/saclient/releases/](https://github.com/oktat/saclient/releases/)

## Példa

A példában felhasználók vannak egy User osztállyal, ami felcserélhető az adott feladatnak megfelelő osztállyal.

### REST API elérése

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

### JSON és Java objektum konverziók

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
ArrayList<User> userList = Convert.toListObject(result, User.class);
for(User user : userList) {
    System.out.println(user.name);
}
```

Átalakítás szimpla objektummá:

```java
String host = "http://valahol/valamik";
String url = host + "/1";
Client client = new Client();
String result = client.get(url);
User user = Convert.toObject(result, User.class);        
System.out.println(user.name);
```

Java lista objektum átalakítása JSON sztringgé:

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

JSON sztring készítése listából:

```java
ArrayList<User> userList = new ArrayList<>();
userList.add(new User("Erős István", "erosi"));
userList.add(new User("Kiss Mária", "kissm"));
String json = Convert.listToJson(userList);
System.out.println(json);
```

Egy Java objektum átalakítása JSON sztringgé:

```java
User user = new User("Erős István", "erosi");        
String json = Convert.toJson(user);
System.out.println(json);
```
