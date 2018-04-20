package com.aurawin.scs.cms.synchronize.rsr.requests.file;

import com.aurawin.core.rsr.Item;
import com.aurawin.core.rsr.def.http.Field;
import com.aurawin.core.rsr.def.http.Request;
import com.aurawin.scs.stored.domain.network.File;
import com.aurawin.scs.stored.domain.network.Folder;

public class List extends Request {
    public List(Item owner) {
        super(owner);
    }

    public static List generateRequest(Folder f, Item owner){

        List r = new List(owner);
        r.Method="LIST";
        r.NamespacePlugin="/core/social/cab";
        r.NamespaceEntry="/file";
        r.URI=r.NamespacePlugin+r.NamespaceEntry;

        r.Headers.Update(Field.Query,f.getId());

        return r;

    }
}
