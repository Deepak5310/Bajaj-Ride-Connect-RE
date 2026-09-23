package com.google.android.libraries.navigation.internal.ael;

import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class cc extends IOException {
    private static final long serialVersionUID = -1616151763072450476L;
    public boolean a;

    public cc(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    final void a() {
        this.a = true;
    }

    public cc(String str) {
        super(str);
    }
}
