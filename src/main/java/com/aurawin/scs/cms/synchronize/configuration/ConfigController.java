package com.aurawin.scs.cms.synchronize.configuration;

import com.aurawin.core.file.SystemDialog;
import com.aurawin.core.stream.MemoryStream;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;


import static com.aurawin.scs.cms.synchronize.Controller.mainController;
import static com.aurawin.scs.cms.synchronize.Controller.settingsForm;

public class ConfigController {
    public SystemDialog Dialog;
    public static long SaveDelay=1000*3;

    public static String Filename="Configuration.json";

    public static Gson parser;
    public static GsonBuilder builder;
    public static Configuration Config;

    public static void init() {
        builder = new GsonBuilder();
        parser = builder.create();
        try {
            Config = loadSettings();
        } catch (Exception ex){
            Config = new Configuration();
        }
    }
    public static void Enforce(){
        settingsForm.txtPath.setText(Config.Path);
        settingsForm.sThreads.setValue(Config.Threads);
    }

    public static void Extract(){
        Config.Path = settingsForm.txtPath.getText();
        Config.Threads = (int) settingsForm.sThreads.getValue();
    }

    public static void writeToFile(String filename) throws IOException {
        MemoryStream ms = new MemoryStream();
        try {
            ms.Write(parser.toJson(Config));
            ms.SaveToFile(new File(filename));
        } finally{
            ms.close();
        }
    }

    public static Configuration fromFile(String filename) throws IOException {
        MemoryStream ms = new MemoryStream();
        try{
            ms.LoadFromFile(new File(filename));
            return new Gson().fromJson(ms.toString(),Configuration.class);
        }finally {
            ms.close();
        }
    }


    public static Configuration loadSettings() throws Exception{
        java.io.File Path = new java.io.File(com.aurawin.core.solution.Settings.File.Data.Path());
        if (!Path.exists()) Path.mkdirs();
        return fromFile(com.aurawin.core.solution.Settings.File.Data.Path()+java.io.File.separator+Filename);
    }

    public static void saveSettings() throws Exception{
        writeToFile(com.aurawin.core.solution.Settings.File.Data.Path()+java.io.File.separator+Filename);
    }

}
