package com.google.android.libraries.navigation.internal.pg;

import com.adobe.internal.xmp.options.PropertyOptions;
import com.google.android.libraries.geo.mapcore.internal.model.cd;
import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements Comparator {
    public int a;
    public int b;

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        cd cdVar = (cd) obj;
        int i = cdVar.a;
        cd cdVar2 = (cd) obj2;
        int i2 = cdVar2.a;
        if (i != i2) {
            return i2 - i;
        }
        int i3 = PropertyOptions.DELETE_EXISTING >> i;
        int i4 = cdVar.e + i3;
        int i5 = cdVar.f + i3;
        int i6 = cdVar2.e + i3;
        int i7 = cdVar2.f + i3;
        int i8 = this.a;
        int iAbs = Math.abs(i4 - i8);
        int i9 = this.b;
        return (iAbs + Math.abs(i5 - i9)) - (Math.abs(i6 - i8) + Math.abs(i7 - i9));
    }
}
