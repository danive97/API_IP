package com.ufv.dis.final2022.DOV;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

@RestController
public class ControllerIP {
    @GetMapping("/Getips")
    public ArrayList<IP> Getips(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        ArrayList<IP> lista_ip;

        Type ip_listaType = new TypeToken<ArrayList<IP>>(){}.getType();

        FileReader file = null;
        try{
            file = new FileReader("LocalizaIP.json");
        }catch(IOException e){
            e.printStackTrace();
        }

        lista_ip = gson.fromJson(file, ip_listaType);

        try{
            file.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return lista_ip;
    }
}
