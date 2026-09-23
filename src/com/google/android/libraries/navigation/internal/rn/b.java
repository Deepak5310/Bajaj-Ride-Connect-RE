package com.google.android.libraries.navigation.internal.rn;

import com.google.android.libraries.navigation.internal.rm.d;
import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public final int a = 0;
    public final ArrayList b;
    public final d c;

    static {
        new b(new ArrayList(), new d(), new d());
    }

    public b(ArrayList arrayList, d dVar, d dVar2) {
        ArrayList arrayList2 = new ArrayList();
        this.b = arrayList2;
        arrayList2.addAll(arrayList);
        d dVar3 = new d(dVar2);
        this.c = dVar3;
        float[] fArr = dVar3.a;
        float f = fArr[0] * 0.5f;
        fArr[0] = f;
        fArr[1] = fArr[1] * 0.5f;
        fArr[2] = fArr[2] * 0.5f;
        float[] fArr2 = dVar.a;
        fArr[0] = f + fArr2[0];
        fArr[1] = fArr[1] + fArr2[1];
        fArr[2] = fArr[2] + fArr2[2];
    }

    public final boolean a() {
        return false;
    }
}
