package com.google.android.libraries.navigation.internal.hh;

import com.google.android.libraries.navigation.internal.aac.bm;
import com.google.android.libraries.navigation.internal.aac.cj;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.hy;
import java.io.ByteArrayInputStream;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class i {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.hh.i");
    final j b;
    final bm c;
    public final String d;
    private final ConcurrentMap e = new hy().c().f();
    private final Map f = new hy().c().f();
    private final c g;

    public i(j jVar, bm bmVar, String str, c cVar) {
        new AtomicInteger(0);
        this.b = jVar;
        this.c = bmVar;
        this.d = str;
        this.g = cVar;
    }

    private final synchronized Serializable e(s sVar, Serializable serializable) {
        Serializable serializable2 = (Serializable) this.f.get(sVar);
        if (serializable2 != null) {
            return serializable2;
        }
        if (serializable != null) {
            this.f.put(sVar, serializable);
        }
        return serializable;
    }

    private final synchronized Serializable f(s sVar) {
        return (Serializable) this.f.get(sVar);
    }

    public final w a(b bVar) {
        w wVar = (w) this.e.get(bVar);
        if (wVar != null) {
            return wVar;
        }
        final w wVar2 = new w(bVar, null, false, false);
        w wVar3 = (w) this.e.putIfAbsent(bVar, wVar2);
        if (wVar3 != null) {
            return wVar3;
        }
        ar.q(wVar2.a);
        final b bVar2 = wVar2.a;
        this.c.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.hh.f
            @Override // java.lang.Runnable
            public final void run() {
                wVar2.b(this.a.c(bVar2));
            }
        });
        return wVar2;
    }

    @Deprecated
    public final Serializable b(r rVar) {
        final s sVar = new s(rVar);
        Serializable serializableF = f(sVar);
        if (serializableF != null) {
            return serializableF;
        }
        try {
            return e(sVar, (Serializable) this.c.submit(new Callable() { // from class: com.google.android.libraries.navigation.internal.hh.e
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.c(sVar);
                }
            }).get());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new com.google.android.libraries.navigation.internal.hx.t(e);
        } catch (ExecutionException e2) {
            throw new cj(e2.getCause());
        }
    }

    public final Serializable c(u uVar) {
        ap.GMM_STORAGE.f();
        byte[] bArrB = this.b.b(uVar);
        if (bArrB == null) {
            return null;
        }
        try {
            String str = this.d;
            x xVar = new x(new ByteArrayInputStream(bArrB), this);
            xVar.a();
            String utf = xVar.readUTF();
            byte b = xVar.readByte();
            if (b != 1) {
                throw new InvalidObjectException(com.google.android.libraries.navigation.internal.b.b.k(1, b, "Object format version '", "' is not the required '", "'."));
            }
            String utf2 = xVar.readUTF();
            if (str.equals(utf2)) {
                Class<?> cls = Class.forName(utf);
                if (!v.class.isAssignableFrom(cls)) {
                    return (Serializable) xVar.readObject();
                }
                v vVar = (v) cls.getDeclaredConstructor(null).newInstance(null);
                vVar.a();
                return vVar;
            }
            throw new InvalidObjectException("Object build number '" + utf2 + "' is not the required '" + str + "'.");
        } catch (Exception e) {
            if ((e instanceof InvalidClassException) || (e instanceof IllegalArgumentException) || (e instanceof InvalidObjectException)) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 635)).p("Unable to deserialize storage item; this is expected after an app upgrade if the serialized format of this item changed.");
            } else {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 636)).p("Failed to load item");
            }
            this.b.c(uVar);
            return null;
        }
    }

    public final void d(w wVar) {
        b bVar = wVar.a;
        b bVarA = bVar == null ? this.g.a() : new b(bVar.b);
        wVar.a = bVarA;
        this.e.put(bVarA, wVar);
    }
}
