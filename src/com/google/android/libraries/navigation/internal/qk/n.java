package com.google.android.libraries.navigation.internal.qk;

import com.google.android.libraries.navigation.internal.yz.ck;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n implements i {
    public static final Comparator a = new Comparator() { // from class: com.google.android.libraries.navigation.internal.qk.j
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            m mVar = (m) ((Map.Entry) obj).getValue();
            m mVar2 = (m) ((Map.Entry) obj2).getValue();
            return ck.b.e(mVar.b, mVar2.b).c(mVar.c, mVar2.c).a();
        }
    };
    public final com.google.android.libraries.navigation.internal.ol.ai b;
    public final Object c = new Object();
    public final IdentityHashMap d = new IdentityHashMap();
    public final o e = new o();
    public final l f;
    public boolean g;
    public com.google.android.libraries.navigation.internal.pb.k h;

    public n(com.google.android.libraries.navigation.internal.ol.ai aiVar) {
        l lVar = new l(this);
        this.f = lVar;
        this.h = null;
        this.b = aiVar;
        this.g = false;
        aiVar.e(lVar.e);
    }
}
