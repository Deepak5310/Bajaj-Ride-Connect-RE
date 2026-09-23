package com.google.android.libraries.navigation.internal.zh;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends c {
    public static final Map c;
    private final com.google.android.libraries.navigation.internal.zd.b d;

    static {
        EnumMap enumMap = new EnumMap(com.google.android.libraries.navigation.internal.zd.b.class);
        for (com.google.android.libraries.navigation.internal.zd.b bVar : com.google.android.libraries.navigation.internal.zd.b.values()) {
            e[] eVarArr = new e[10];
            for (int i = 0; i < 10; i++) {
                eVarArr[i] = new e(i, bVar, com.google.android.libraries.navigation.internal.zd.c.a);
            }
            enumMap.put(bVar, eVarArr);
        }
        c = Collections.unmodifiableMap(enumMap);
    }

    public e(int i, com.google.android.libraries.navigation.internal.zd.b bVar, com.google.android.libraries.navigation.internal.zd.c cVar) {
        super(cVar, i);
        com.google.android.libraries.navigation.internal.zj.b.d(bVar, "format char");
        this.d = bVar;
        if (cVar.c()) {
            String str = bVar.o;
            return;
        }
        int i2 = bVar.l;
        i2 = cVar.d() ? i2 & 65503 : i2;
        StringBuilder sb = new StringBuilder("%");
        cVar.f(sb);
        sb.append((char) i2);
    }

    @Override // com.google.android.libraries.navigation.internal.zh.c
    public final void a(d dVar, Object obj) {
        dVar.d(obj, this.d, this.b);
    }
}
