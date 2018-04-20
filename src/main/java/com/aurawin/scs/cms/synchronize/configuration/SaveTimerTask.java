package com.aurawin.scs.cms.synchronize.configuration;

import java.util.TimerTask;

import static com.aurawin.scs.cms.synchronize.Controller.mainController;

public class SaveTimerTask extends TimerTask {

    @Override
    public void run(){
        try {
            ConfigController.Extract();
            ConfigController.saveSettings();
        } catch (Exception ex){

        }
    }


}
