package com.google.android.libraries.navigation.internal.pi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class w {
    private final Object a;

    protected w(Object obj) {
        this.a = obj;
    }

    public final Object a(Class cls) {
        Object obj = this.a;
        if (obj != null && cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        return null;
    }
}
