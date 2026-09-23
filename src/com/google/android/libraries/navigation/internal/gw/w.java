package com.google.android.libraries.navigation.internal.gw;

import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class w {
    public abstract x a();

    public abstract void b(boolean z);

    public final x c() {
        x xVarA = a();
        e eVar = (e) xVarA;
        Integer num = eVar.a;
        ar.b(num == null || num.intValue() > 0, "width <= 0");
        Integer num2 = eVar.b;
        ar.b(num2 == null || num2.intValue() > 0, "height <= 0");
        return xVarA;
    }
}
