package com.google.android.libraries.navigation.internal.nh;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.TransportFactory;
import com.google.android.libraries.navigation.internal.ael.x;
import com.google.android.libraries.navigation.internal.afk.w;
import com.google.android.libraries.navigation.internal.afr.p;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ez;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;

    public g(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        TransportFactory transportFactory = (TransportFactory) this.a.a();
        Set setA = ((p) this.b).a();
        ar.b(!setA.isEmpty(), "At least one supported log sources must be provided for the FirelogClearcutLoggerApi.");
        ez ezVar = new ez();
        Iterator it2 = setA.iterator();
        while (it2.hasNext()) {
            String str = ((w) it2.next()).o;
            ezVar.f(str, transportFactory.getTransport(str, x.class, Encoding.of("proto"), new Transformer() { // from class: com.google.android.libraries.navigation.internal.nh.f
                @Override // com.google.android.datatransport.Transformer
                public final Object apply(Object obj) {
                    return ((x) obj).B();
                }
            }));
        }
        return ezVar.c();
    }
}
