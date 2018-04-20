package com.aurawin.scs.cms.synchronize.rsr.requests.folder;

import com.aurawin.core.rsr.Item;
import com.aurawin.core.rsr.def.http.Field;
import com.aurawin.core.rsr.def.http.Request;
import com.aurawin.scs.stored.domain.network.Folder;

public class Delete extends Request {
    public Delete(Item owner) {
        super(owner);
    }

    public static Delete generateRequest(Folder f, Item owner){

        Delete r = new Delete(owner);
        r.Method="DELETE";
        r.NamespacePlugin="/core/social/cab";
        r.NamespaceEntry="/folder";
        r.URI=r.NamespacePlugin+r.NamespaceEntry;
        r.Headers.Update(Field.Query,f.getId());

        return r;

    }
}