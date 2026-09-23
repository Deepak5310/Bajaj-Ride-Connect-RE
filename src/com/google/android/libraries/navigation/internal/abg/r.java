package com.google.android.libraries.navigation.internal.abg;

import com.google.android.libraries.navigation.internal.b.ad;
import com.google.android.libraries.navigation.internal.b.z;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class r extends com.google.android.libraries.navigation.internal.b.t {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final s f113n;
    private final byte[] o;
    private final t p;
    private final com.google.android.libraries.navigation.internal.c.p q;
    private final boolean r;

    public r(s sVar, byte[] bArr, t tVar, String str, com.google.android.libraries.navigation.internal.c.p pVar, boolean z) {
        super(1, str, pVar);
        this.f113n = sVar;
        this.o = bArr;
        this.p = tVar;
        this.q = pVar;
        this.r = z;
    }

    @Override // com.google.android.libraries.navigation.internal.b.t
    protected final z b(com.google.android.libraries.navigation.internal.b.o oVar) {
        String str = (String) oVar.c.get("Content-Type");
        try {
            s sVar = this.f113n;
            int i = oVar.a;
            if (i == 200) {
                if (Objects.equals(str, "application/binary")) {
                    this.p.a();
                    return new z(oVar.b, null);
                }
                com.google.android.libraries.navigation.internal.abf.p.f(s.a, 6);
                throw new IOException("Bad HTTP content type: " + str + " for " + s.a(sVar.c));
            }
            com.google.android.libraries.navigation.internal.abf.p.f(s.a, 5);
            if (i == 500) {
                Iterator it2 = sVar.c.iterator();
                while (it2.hasNext()) {
                    ((n) it2.next()).c();
                }
                throw new u("Serverside failure (HTTP500) for " + s.a(sVar.c));
            }
            if (i == 403) {
                sVar.d.c();
                sVar.d.b(sVar.b);
                i = 403;
            } else if (i == 501) {
                sVar.b.n(2);
                throw new IOException("Server side HTTP not implemented");
            }
            throw new IOException("Bad HTTP response code: " + i + " for " + s.a(sVar.c));
        } catch (u | IOException e) {
            return new z(new ad(e));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.b.t
    public final String c() {
        return "application/binary";
    }

    @Override // com.google.android.libraries.navigation.internal.b.t
    public final Map e() throws com.google.android.libraries.navigation.internal.b.a {
        HashMap map = new HashMap();
        map.put(HttpHeaders.CONTENT_LENGTH, String.valueOf(this.o.length));
        if (!this.r) {
            s sVar = this.f113n;
            String strF = sVar.b.f();
            String strE = sVar.b.e();
            com.google.android.libraries.navigation.internal.abf.s.d(strE != null, "app version not set");
            map.put("X-Google-Maps-Mobile-API", com.google.android.libraries.navigation.internal.abf.x.b(new String[]{strF, strE, sVar.g, "9.0.0", sVar.f}));
        }
        return map;
    }

    @Override // com.google.android.libraries.navigation.internal.b.t
    protected final /* bridge */ /* synthetic */ void h(Object obj) {
        this.q.b((byte[]) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.b.t
    public final byte[] o() throws com.google.android.libraries.navigation.internal.b.a {
        return this.o;
    }
}
