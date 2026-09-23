package com.google.android.libraries.navigation.internal.abg;

import android.content.SharedPreferences;
import android.os.StrictMode;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class w extends h {
    private final p b;

    public w(p pVar) {
        this.b = pVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abg.h, com.google.android.libraries.navigation.internal.abg.n
    public final boolean e() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public final int h() {
        return 15;
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public final void i(DataOutputStream dataOutputStream) throws IOException {
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public final void j(DataInputStream dataInputStream) throws IOException {
        long j = dataInputStream.readLong();
        com.google.android.libraries.navigation.internal.abf.p.f(p.a, 4);
        p pVar = this.b;
        synchronized (pVar) {
            pVar.c = Long.valueOf(j);
        }
        SharedPreferences.Editor editorEdit = pVar.e.edit();
        editorEdit.putLong("SessionID", j);
        StrictMode.ThreadPolicy threadPolicyB = com.google.android.libraries.navigation.internal.abf.w.a.b();
        try {
            editorEdit.commit();
        } finally {
            com.google.android.libraries.navigation.internal.abf.w.a.d(threadPolicyB);
        }
    }
}
