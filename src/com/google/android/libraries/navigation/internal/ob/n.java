package com.google.android.libraries.navigation.internal.ob;

import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.yx.br;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class n {
    public static l g() {
        c cVar = new c();
        m mVar = m.DEFAULT;
        Objects.requireNonNull(mVar);
        cVar.b = mVar;
        cVar.a(false);
        cVar.d = (byte) (cVar.d | 1);
        cVar.c = "GL-Map";
        cVar.c(new s() { // from class: com.google.android.libraries.navigation.internal.ob.j
            @Override // com.google.android.libraries.navigation.internal.ob.s
            public final boolean a(an anVar) {
                return true;
            }
        });
        cVar.a = new br() { // from class: com.google.android.libraries.navigation.internal.ob.k
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return n.h();
            }
        };
        return cVar;
    }

    public static /* synthetic */ Boolean h() {
        return true;
    }

    public abstract m a();

    public abstract s b();

    public abstract br c();

    public abstract String d();

    public abstract boolean e();

    public abstract void f();

    public final boolean i() {
        return a() == m.EMBEDDED || a() == m.PROJECTED;
    }
}
