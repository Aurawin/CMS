package com.aurawin.scs.cms.synchronize.configuration;

import java.util.Timer;

public class SaveTimer  {
    private Timer timer;

    public SaveTimer() {
    }
    public void setEnabled(){
        if (timer!=null) {
            timer.cancel();
        }
        timer = new Timer();
        timer.schedule(new SaveTimerTask(),ConfigController.SaveDelay);

    }
}
