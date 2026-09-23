package com.google.android.libraries.navigation.internal.ael;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ar {
    public static final ar a = new ar(null);
    private static volatile boolean b = false;
    private static volatile ar c;
    private final Map d;

    public ar() {
        this.d = new HashMap();
    }

    public static ar b() {
        ar arVar = c;
        if (arVar != null) {
            return arVar;
        }
        synchronized (ar.class) {
            ar arVar2 = c;
            if (arVar2 != null) {
                return arVar2;
            }
            di diVar = di.a;
            ar arVarB = az.b(ar.class);
            c = arVarB;
            return arVarB;
        }
    }

    public static ar c() {
        di diVar = di.a;
        return new ar();
    }

    public bh a(cy cyVar, int i) {
        return (bh) this.d.get(new aq(cyVar, i));
    }

    public final void d(bh bhVar) {
        this.d.put(new aq(bhVar.a, bhVar.a()), bhVar);
    }

    public ar(byte[] bArr) {
        this.d = Collections.emptyMap();
    }
}
