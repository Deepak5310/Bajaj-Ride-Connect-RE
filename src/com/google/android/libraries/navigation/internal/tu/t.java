package com.google.android.libraries.navigation.internal.tu;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class t {
    public abstract com.google.android.libraries.navigation.internal.ael.x a();

    public abstract String b();

    public final String toString() {
        com.google.android.libraries.navigation.internal.ael.x xVarA = a();
        if (xVarA == null || com.google.android.libraries.navigation.internal.ael.x.b.equals(xVarA)) {
            return b();
        }
        return "NLG_Data[" + b() + "]";
    }
}
