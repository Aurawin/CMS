package com.aurawin.scs.cms.synchronize.rsr.requests.folder;

import com.aurawin.core.rsr.Item;
import com.aurawin.core.rsr.def.http.Request;
import com.aurawin.scs.stored.domain.network.Folder;

public class Create extends Request {

    public Create(Item owner) {
        super(owner);
    }

    public static Create generateRequest(Folder f, Item owner){

        Create r = new Create(owner);
        r.Method="POST";
        r.NamespacePlugin="/core/social/cab";
        r.NamespaceEntry="/folder";
        r.URI=r.NamespacePlugin+r.NamespaceEntry;


        r.Payload.Write(owner.Owner.gsonParser.toJson(f));

        return r;

    }
}
