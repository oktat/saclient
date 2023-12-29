package hu.szit;

import java.util.ArrayList;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * JSON Java objektum konvertáló
 * 
 * Ez az osztály függ a Gson programozói könyvtártól.
 * 
 * @author Sallai András
 * @author szit.hu
 * @version 0.9
 * @see     Gson
 */
public class Convert {

    /**
     * A JSON sztringet átalakítja Java objektummá.
     * Visszaad egy paraméterként kapott típust.
     * 
     * @param     json      A konvertálandó JSON sztring.
     * @return    A válasz a Java objektum.
     */
    public static <T> ArrayList<T> toObject(String json, Class<T> type) {
        Type collType = TypeToken.getParameterized(ArrayList.class, type).getType();
        Gson gson = new Gson();        
        return gson.fromJson(json, collType);
    }

    /**
     * Java ArrayList objektumot JSON sztringgé alakít át.
     * Visszada egy JSON sztringet.
     * 
     * @param     list      A konvertálandó JSON sztring.
     * @return              A válasz egy JSON sztring.
     */    
    public static <T> String toJson(ArrayList<T> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }
}
