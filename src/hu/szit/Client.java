package hu.szit;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse.BodyHandlers;

/**
 * REST API kliens készítése
 * 
 * Ez az osztály a Java 11-ben megjelent HttpClient osztályt használja.
 * 
 * Példa:
 * <pre>
 * Client client = new Client();
 * String result = client.get(url);
 * System.out.println(result);
 * </pre>
 * 
 * @author Sallai András
 * @author szit.hu
 * @version 0.9
 * @see     HttpClient
 */
public class Client {
    HttpClient client;

    /**
     * A Client osztályból készít egy példányt.
     */
    public Client() {
        this.client = HttpClient.newHttpClient();        
    }

    /**
     * A függvény lekéri az adatokat egy REST API szerverről.
     * Az eredményt sztringként adja vissza.
     * 
     * @param     url    A szerver URL-je
     * @return    A válasz JSON formátumban
     */
    public String get(String url) {
        HttpRequest request = genGetRequest(url);        
        return sendRequest(request);
    }
    private HttpRequest genGetRequest(String url, String... args) {
        Builder builder = HttpRequest.newBuilder();
        builder.uri(URI.create(url));
        if(args.length > 0) {
            String token = args[0];
            builder.header("Authorization", "Bearer " + token);            
        }
        return builder.build();
    }

    /**
     * A metódus felvesz egy új elemet a REST API szerveren.
     * Az eredmény a felvett elem adatai.
     * 
     * @param       url     A szerver URL-je
     * @param       body    Az új elem JSON sztring formátumban
     * @param       args    Bearer token azonosításhoz. Nem kötelező megadni.
     * @return      A válasz JSON formátumban a felvett elem
     */    
    public String post(String url, String body, String... args) {
        HttpRequest request = this.genPostRequest(url, body, args);        
        return this.sendRequest(request);
    }
    private HttpRequest genPostRequest(String url, String body, String... args) {
        Builder builder = HttpRequest.newBuilder();
        builder.uri(URI.create(url));
        builder.header("Content-Type", "application/json");
        if(args.length > 0) {
            String token = args[0];
            builder.header("Authorization", "Bearer " + token);            
        }        
        builder.POST(HttpRequest.BodyPublishers.ofString(body));
        return builder.build();
    }

    /**
     * A metódus módosít egy elemet a REST API szerveren.
     * A módosított adatokat sztringként adja vissza.
     * 
     * @param       url     A szerver URL-je
     * @param       body    A módosított elem JSON sztring formátumban
     * @param       args    Bearer token azonosításhoz. Nem kötelező megadni.
     * @return      A válasz JSON formátumban a módosított elem
     */      
    public String put(String url, String body, String... args) {
        HttpRequest request = this.genPutRequest(url, body, args);
        return this.sendRequest(request);
    }
    private HttpRequest genPutRequest(String url, String body, String... args) {
        Builder builder = HttpRequest.newBuilder();
        builder.uri(URI.create(url));
        builder.header("Content-Type", "application/json");
        if(args.length > 0) {
            String token = args[0];
            builder.header("Authorization", "Bearer " + token);            
        }
        builder.PUT(HttpRequest.BodyPublishers.ofString(body));
        return builder.build();
    }

    /**
     * A metódus töröl egy elemet a REST API szerveren.
     * Az eredmény {}, siker esetén.
     * 
     * @param       url     A szerver URL-je.
     * @param       args    Bearer token azonosításhoz. Nem kötelező megadni.
     * @return      A válasz {} siker esetén
     */     
    public String delete(String url, String... args) {
        HttpRequest request = this.genDeleteRequest(url, args);
        return this.sendRequest(request);
    }
    private HttpRequest genDeleteRequest(String url, String... args) {
        Builder builder = HttpRequest.newBuilder();
        builder.uri(URI.create(url));
        builder.header("Content-Type", "application/json");
        if(args.length > 0) {
            String token = args[0];
            builder.header("Authorization", "Bearer " + token);            
        }
        builder.DELETE();
        return builder.build();
    }

    private String sendRequest(HttpRequest request) {
        String result = "";
        try {
            result = trySendRequest(request);                     
        } catch (IOException e) {
            System.err.println("Hiba! A lekérés sikertelen!");
            System.err.println(e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Hiba! Megszakadt lekérés!");
            System.err.println(e.getMessage());            
        }
        return result;
    }
    private String trySendRequest(HttpRequest request) 
            throws IOException, InterruptedException {
        HttpResponse<String> response = 
        this.client.send(request, BodyHandlers.ofString());        
        return response.body();
    }
}