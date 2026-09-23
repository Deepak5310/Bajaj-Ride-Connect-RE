package com.google.android.libraries.navigation.internal.ma;

import android.content.Context;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.libraries.navigation.internal.le.bd;
import com.google.android.libraries.navigation.internal.le.bi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class al extends com.google.android.libraries.navigation.internal.ld.o {
    public static final /* synthetic */ int a = 0;

    static {
        Pair.create(new an(), com.google.android.libraries.navigation.internal.me.ah.b(null));
    }

    public al(Context context) {
        super(context, x.a, com.google.android.libraries.navigation.internal.ld.g.a, com.google.android.libraries.navigation.internal.ld.n.a);
    }

    public final com.google.android.libraries.navigation.internal.me.w a(final String str) {
        bi biVar = new bi();
        biVar.a = new bd() { // from class: com.google.android.libraries.navigation.internal.ma.ad
            @Override // com.google.android.libraries.navigation.internal.le.bd
            public final void a(Object obj, Object obj2) throws RemoteException {
                int i = al.a;
                ((com.google.android.libraries.navigation.internal.mb.h) ((com.google.android.libraries.navigation.internal.mb.i) obj).u()).e(new ak((com.google.android.libraries.navigation.internal.me.aa) obj2), str);
            }
        };
        return g(biVar.a());
    }

    public final com.google.android.libraries.navigation.internal.me.w b(final String str, final int i, final String[] strArr) {
        bi biVar = new bi();
        biVar.a = new bd() { // from class: com.google.android.libraries.navigation.internal.ma.ae
            @Override // com.google.android.libraries.navigation.internal.le.bd
            public final void a(Object obj, Object obj2) throws RemoteException {
                int i2 = al.a;
                ((com.google.android.libraries.navigation.internal.mb.h) ((com.google.android.libraries.navigation.internal.mb.i) obj).u()).j(new ak((com.google.android.libraries.navigation.internal.me.aa) obj2), str, i, strArr);
            }
        };
        return g(biVar.a());
    }
}
