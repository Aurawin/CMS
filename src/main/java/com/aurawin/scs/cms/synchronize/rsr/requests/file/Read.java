package com.aurawin.scs.cms.synchronize.rsr.requests.file;

import com.aurawin.core.rsr.Item;
import com.aurawin.core.rsr.def.http.Field;
import com.aurawin.core.rsr.def.http.Request;
import com.aurawin.scs.stored.domain.network.File;
import com.aurawin.scs.stored.domain.network.Folder;

public class Read extends Request {

    public Read(Item owner) {
        super(owner);
    }

    public static Read generateRequest(File f, Item owner){

        Read r = new Read(owner);
        r.Method="GET";
        r.NamespacePlugin="/core/social/cab";
        r.NamespaceEntry="/file";
        r.URI=r.NamespacePlugin+r.NamespaceEntry;
        r.Headers.Update(Field.Query,f.getId());

        return r;

    }
}
