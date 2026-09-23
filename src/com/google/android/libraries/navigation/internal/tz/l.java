package com.google.android.libraries.navigation.internal.tz;

import androidx.core.view.ViewCompat;
import java.util.Optional;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class l {
    public static k m() {
        a aVar = new a();
        aVar.b(-1);
        aVar.d(-7829368);
        aVar.c(ViewCompat.MEASURED_STATE_MASK);
        aVar.e();
        aVar.a = -1;
        byte b = aVar.g;
        aVar.b = -1;
        aVar.g = (byte) (b | 48);
        return aVar;
    }

    public abstract int a();

    public abstract int b();

    public abstract int c();

    public abstract int d();

    public abstract int e();

    public abstract int f();

    public abstract Optional g();

    public abstract Optional h();

    public abstract Optional i();

    public abstract Optional j();

    public abstract Optional k();

    public abstract Optional l();
}
