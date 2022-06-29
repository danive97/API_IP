package com.ufv.dis.final2022.DOV;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class LocalizaIP {
    //Funcion para leer un Json arraylist
    public static ArrayList<IP> getFile() {
        Gson gson = new Gson();

        ArrayList<IP> listIP;
        BufferedReader br = null;
        try {
            br = new BufferedReader (new FileReader("LocalizaIP.json"));
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        listIP = gson.fromJson(br, new TypeToken<ArrayList<IP>>(){}.getType());
        return listIP;
    }
    //Función para buscar una IP en el arraylist creado

    public IP locateIP(String IP, ArrayList<IP> listaGeoIP) throws Exception {
        if (IP == "") {
            throw new Exception("Ip vacía");
        }

        long longIP = Dot2LongIP(IP);

        if (longIP > (long)4294967295.0) {
            throw new Exception("Ip maxima superada");
        }

        if (longIP < (long)0) {
            throw new Exception("Ip minima superada");
        }
        boolean correcto = false;
        IP elementoEncontrado = null;
        int i = 0;

        while (correcto == false && i < listaGeoIP.size()) {
            IP item = listaGeoIP.get(i);

            if (longIP >= item.getIp_from(null) && longIP <= item.getIp_from(null)) {
                correcto = true;
                elementoEncontrado = item;
            }
            i++;
        }
        if (elementoEncontrado != null) {
            return elementoEncontrado;
        }
        else {
            return new IP();
        }
    }
    //Las dos funciones que nos proponía el enunciado

    public static String longToIp(long ip) {
        StringBuilder result = new StringBuilder(15);
        for (int i = 0; i < 4; i++) {
            result.insert(0, Long.toString(ip & 0xff));
            if (i < 3) {
                result.insert(0, '.');
            }
            ip = ip >> 8;
        }
        return result.toString();
    }


    public static Long Dot2LongIP(String dottedIP) {
        String[] addrArray = dottedIP.split("\\.");
        long num = 0;
        for (int i=0;i<addrArray.length;i++) {
            int power = 3-i;
            num += ((Integer.parseInt(addrArray[i]) % 256) * Math.pow(256,power));
        }
        return num;
    }
}
