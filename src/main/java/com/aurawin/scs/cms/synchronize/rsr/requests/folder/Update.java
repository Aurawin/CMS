package com.aurawin.scs.cms.synchronize.rsr.requests.folder;

import com.aurawin.core.rsr.Item;
import com.aurawin.core.rsr.def.http.Field;
import com.aurawin.core.rsr.def.http.Request;
import com.aurawin.scs.stored.domain.network.Folder;

public class Update extends Request {
    public Update(Item owner) {
        super(owner);
    }

    public static Update generateRequest(Folder f, Item owner){

        Update r = new Update(owner);
        r.Method="PUT";
        r.NamespacePlugin="/core/social/cab";
        r.NamespaceEntry="/folder";
        r.URI=r.NamespacePlugin+r.NamespaceEntry;
        r.Headers.Update(Field.Query,f.getId());
        r.Payload.Write(owner.Owner.gsonParser.toJson(f));

        return r;

    }
}