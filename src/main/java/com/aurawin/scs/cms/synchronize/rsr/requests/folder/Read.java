package com.aurawin.scs.cms.synchronize.rsr.requests.folder;

import com.aurawin.core.rsr.Item;
import com.aurawin.core.rsr.def.http.Field;
import com.aurawin.core.rsr.def.http.Request;
import com.aurawin.scs.stored.domain.network.Folder;

public class Read extends Request {

    public Read(Item owner) {
        super(owner);
    }

    public static Read generateRequest(Folder f, Item owner){

        Read r = new Read(owner);
        r.Method="GET";
        r.NamespacePlugin="/core/social/cab";
        r.NamespaceEntry="/folder";
        r.URI=r.NamespacePlugin+r.NamespaceEntry;
        r.Headers.Update(Field.Query,f.getId());
        //r.Payload.Write(owner.Owner.gsonParser.toJson(f));

        return r;

    }
}
