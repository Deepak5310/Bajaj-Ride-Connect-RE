package com.google.android.libraries.navigation.internal.px;

import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.gs;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cf {
    private final Set a = new HashSet();
    private final Set b = new HashSet();
    private final Set c = new HashSet();
    private final Set d = new HashSet();
    private final Set e = new HashSet();
    private final Set f = new HashSet();
    private final Set g = new HashSet();

    public final com.google.android.libraries.navigation.internal.ol.af a() {
        fy fyVarN = fy.n(gs.b(this.a, new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.px.ce
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                ek ekVar = (ek) obj;
                ekVar.o();
                return new com.google.android.libraries.navigation.internal.ol.ae(ekVar.V());
            }
        }));
        fy fyVarN2 = fy.n(gs.b(this.b, new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.px.ce
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                ek ekVar = (ek) obj;
                ekVar.o();
                return new com.google.android.libraries.navigation.internal.ol.ae(ekVar.V());
            }
        }));
        fy fyVarN3 = fy.n(gs.b(this.c, new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.px.ce
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                ek ekVar = (ek) obj;
                ekVar.o();
                return new com.google.android.libraries.navigation.internal.ol.ae(ekVar.V());
            }
        }));
        fy fyVarN4 = fy.n(gs.b(this.d, new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.px.ce
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                ek ekVar = (ek) obj;
                ekVar.o();
                return new com.google.android.libraries.navigation.internal.ol.ae(ekVar.V());
            }
        }));
        fy.n(gs.b(this.e, new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.px.ce
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                ek ekVar = (ek) obj;
                ekVar.o();
                return new com.google.android.libraries.navigation.internal.ol.ae(ekVar.V());
            }
        }));
        fy.n(gs.b(this.g, new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.px.ce
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                ek ekVar = (ek) obj;
                ekVar.o();
                return new com.google.android.libraries.navigation.internal.ol.ae(ekVar.V());
            }
        }));
        fy.n(gs.b(this.f, new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.px.ce
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                ek ekVar = (ek) obj;
                ekVar.o();
                return new com.google.android.libraries.navigation.internal.ol.ae(ekVar.V());
            }
        }));
        return new com.google.android.libraries.navigation.internal.ol.af(fyVarN, fyVarN2, fyVarN3, fyVarN4);
    }

    public final void b() {
        this.a.clear();
        this.b.clear();
        this.c.clear();
        this.d.clear();
        this.e.clear();
        this.f.clear();
        this.g.clear();
    }

    public final void c(ek ekVar, int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            this.a.add(ekVar);
            return;
        }
        if (i2 == 1) {
            this.b.add(ekVar);
            return;
        }
        if (i2 == 2) {
            this.c.add(ekVar);
            return;
        }
        if (i2 == 3) {
            this.d.add(ekVar);
            return;
        }
        if (i2 == 4) {
            this.e.add(ekVar);
        } else if (i2 != 5) {
            this.g.add(ekVar);
        } else {
            this.f.add(ekVar);
        }
    }
}
