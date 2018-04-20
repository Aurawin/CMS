package com.aurawin.scs.cms.synchronize.configuration;

import com.aurawin.core.solution.Settings;
import com.aurawin.core.stream.MemoryStream;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import static com.aurawin.scs.cms.synchronize.Controller.mainController;
import static com.aurawin.scs.cms.synchronize.Controller.settingsForm;

public class Configuration {
    @Expose
    public String Path;

    @Expose
    public int Threads;


    public Configuration() {
        Threads = 1;
        Path = System.getProperty("user.home");
    }
}
