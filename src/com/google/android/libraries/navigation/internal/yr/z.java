package com.google.android.libraries.navigation.internal.yr;

import androidx.collection.SimpleArrayMap;
import com.google.android.libraries.navigation.internal.yz.fy;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class z {
    public static final x c = new x();
    private final z a;
    public final SimpleArrayMap d;
    public boolean e = false;

    public z(z zVar, SimpleArrayMap simpleArrayMap) {
        if (zVar != null) {
            com.google.android.libraries.navigation.internal.yx.ar.a(zVar.e);
        }
        this.a = zVar;
        this.d = simpleArrayMap;
    }

    static z a(z zVar, z zVar2) {
        if (zVar.d()) {
            return zVar2;
        }
        if (zVar2.d()) {
            return zVar;
        }
        fy<z> fyVarQ = fy.q(zVar, zVar2);
        if (fyVarQ.isEmpty()) {
            return y.a;
        }
        if (fyVarQ.size() == 1) {
            return (z) fyVarQ.iterator().next();
        }
        int size = 0;
        for (z zVar3 : fyVarQ) {
            do {
                size += zVar3.d.getSize();
                zVar3 = zVar3.a;
            } while (zVar3 != null);
        }
        if (size == 0) {
            return y.a;
        }
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap(size);
        for (z zVar4 : fyVarQ) {
            do {
                for (int i = 0; i < zVar4.d.getSize(); i++) {
                    com.google.android.libraries.navigation.internal.yx.ar.f(simpleArrayMap.put((x) zVar4.d.keyAt(i), zVar4.d.valueAt(i)) == null, "Duplicate bindings: %s", zVar4.d.keyAt(i));
                }
                zVar4 = zVar4.a;
            } while (zVar4 != null);
        }
        return new y(null, simpleArrayMap).b();
    }

    final z b() {
        if (this.e) {
            throw new IllegalStateException("Already frozen");
        }
        this.e = true;
        return (this.a == null || !this.d.isEmpty()) ? this : this.a;
    }

    final boolean c(x xVar) {
        if (this.d.containsKey(xVar)) {
            return true;
        }
        z zVar = this.a;
        return zVar != null && zVar.c(xVar);
    }

    public final boolean d() {
        return this == y.a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SpanExtras<");
        for (z zVar = this; zVar != null; zVar = zVar.a) {
            for (int i = 0; i < zVar.d.getSize(); i++) {
                sb.append(this.d.valueAt(i));
                sb.append("], ");
            }
        }
        sb.append(">");
        return sb.toString();
    }
}
