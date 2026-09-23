package com.google.android.libraries.navigation.internal.aga;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public interface et {
    public static final et a;

    static {
        et tVar;
        try {
            tVar = new bc(Class.forName("java.time.Instant"));
        } catch (ClassNotFoundException unused) {
            tVar = new t();
        }
        a = tVar;
    }

    long a();
}
