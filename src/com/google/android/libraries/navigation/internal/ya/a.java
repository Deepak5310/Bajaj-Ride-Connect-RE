package com.google.android.libraries.navigation.internal.ya;

import com.google.android.libraries.navigation.internal.yb.f;
import com.google.android.libraries.navigation.internal.yc.b;
import com.google.android.libraries.navigation.internal.yz.gs;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private OutputStream a;
    private b b;

    public final void a() throws IOException {
        c();
    }

    public final void b(List list) throws IOException {
        OutputStream outputStream = (OutputStream) gs.d(list);
        if (outputStream instanceof b) {
            this.b = (b) outputStream;
            this.a = (OutputStream) list.get(0);
        }
    }

    public final void c() throws IOException {
        if (this.b == null) {
            throw new f("Cannot sync underlying stream");
        }
        this.a.flush();
        this.b.b();
    }
}
