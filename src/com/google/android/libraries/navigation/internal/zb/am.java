package com.google.android.libraries.navigation.internal.zb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class am extends t {
    private final StackTraceElement b;

    public am(StackTraceElement stackTraceElement) {
        this.b = stackTraceElement;
    }

    @Override // com.google.android.libraries.navigation.internal.zb.t
    public final int a() {
        return Math.max(this.b.getLineNumber(), 0);
    }

    @Override // com.google.android.libraries.navigation.internal.zb.t
    public final String b() {
        return this.b.getClassName();
    }

    @Override // com.google.android.libraries.navigation.internal.zb.t
    public final String c() {
        return this.b.getFileName();
    }

    @Override // com.google.android.libraries.navigation.internal.zb.t
    public final String d() {
        return this.b.getMethodName();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof am) && this.b.equals(((am) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }
}
