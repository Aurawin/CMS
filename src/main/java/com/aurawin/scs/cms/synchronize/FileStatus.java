package com.aurawin.scs.cms.synchronize;

import java.io.Serializable;
import java.util.ArrayList;

import com.google.gson.annotations.Expose;

public class FileStatus implements Serializable {
    @Expose(serialize = true, deserialize = true)
    public String Filename;
    @Expose(serialize = true, deserialize = true)
    public String Operation;
    @Expose(serialize = true, deserialize = true)
    public String Status;
    public FileStatus(String filename, String operation, String status) {
        Filename = filename;
        Operation = operation;
        Status = status;
    }
}
