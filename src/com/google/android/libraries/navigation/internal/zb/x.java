package com.google.android.libraries.navigation.internal.zb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class x extends Exception {
    public x(Throwable th, an anVar, StackTraceElement[] stackTraceElementArr) {
        super(anVar.toString(), th);
        setStackTrace(stackTraceElementArr);
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        return this;
    }
}
