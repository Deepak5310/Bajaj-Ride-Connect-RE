package com.google.android.libraries.navigation.internal.pg;

import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.geo.mapcore.internal.model.cr;
import com.google.android.libraries.geo.mapcore.internal.model.ct;
import com.google.android.libraries.geo.mapcore.renderer.v;
import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class j implements f {
    protected final an a;
    long b = 0;
    final i c = new i();
    protected v d = null;
    protected final ct e;

    protected j(an anVar, ct ctVar) {
        this.a = anVar;
        this.e = ctVar;
    }

    @Override // com.google.android.libraries.navigation.internal.pg.f
    public final float b(x xVar) {
        e(xVar);
        return 22.0f;
    }

    @Override // com.google.android.libraries.navigation.internal.pg.f
    public final cd c(cd cdVar, x xVar) {
        int iBinarySearch;
        int i = cdVar.a;
        cr crVarE = e(xVar);
        byte b = -1;
        if (i <= 127) {
            byte[] bArr = crVarE.c;
            if (bArr.length != 0 && (iBinarySearch = Arrays.binarySearch(bArr, (byte) i)) > 0) {
                b = crVarE.c[iBinarySearch - 1];
            }
        }
        if (b < 0) {
            return null;
        }
        return cdVar.h(b);
    }

    @Override // com.google.android.libraries.navigation.internal.pg.f
    public final List d(cd cdVar, x xVar) {
        int i;
        int iBinarySearch;
        cr crVarE = e(xVar);
        byte[] bArr = crVarE.c;
        byte b = -1;
        if (bArr.length != 0 && (i = cdVar.a) <= 127 && (iBinarySearch = Arrays.binarySearch(bArr, (byte) i)) >= 0) {
            byte[] bArr2 = crVarE.c;
            if (iBinarySearch != bArr2.length - 1) {
                b = bArr2[iBinarySearch + 1];
            }
        }
        if (b < 0) {
            int i2 = ev.d;
            return lv.a;
        }
        int i3 = b - cdVar.a;
        int i4 = 1 << i3;
        ArrayList arrayList = new ArrayList(i4 * i4);
        for (int i5 = 0; i5 < i4; i5++) {
            for (int i6 = 0; i6 < i4; i6++) {
                arrayList.add(new cd(b, (cdVar.b << i3) + i6, (cdVar.c << i3) + i5, cdVar.d));
            }
        }
        return arrayList;
    }

    protected final cr e(x xVar) {
        return this.e.a(xVar, this.a);
    }

    protected final void f(List list, x xVar) {
        if (list.size() > 1) {
            i iVar = this.c;
            iVar.a = xVar.a;
            iVar.b = xVar.b;
            Collections.sort(list, iVar);
        }
    }
}
