package com.google.android.libraries.navigation.internal.fd;

import android.content.Context;
import com.google.android.libraries.navigation.internal.zb.j;
import com.google.android.libraries.navigation.internal.zr.z;
import java.io.File;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class h implements e {
    public final com.google.android.libraries.navigation.internal.fe.a a;
    public final com.google.android.libraries.navigation.internal.ff.a b;

    public h() {
        com.google.android.libraries.navigation.internal.fe.h hVar = new com.google.android.libraries.navigation.internal.fe.h("unsuccessful-startup", z.b);
        com.google.android.libraries.navigation.internal.ff.a aVar = new com.google.android.libraries.navigation.internal.ff.a();
        int i = b.d;
        this.b = aVar;
        this.a = hVar;
    }

    @Override // com.google.android.libraries.navigation.internal.fd.e
    public final void a(final Context context) {
        try {
            com.google.android.libraries.navigation.internal.fh.a.a(new Callable() { // from class: com.google.android.libraries.navigation.internal.fd.f
                @Override // java.util.concurrent.Callable
                public final Object call() throws com.google.android.libraries.navigation.internal.ff.b {
                    File file = new File(context.getFilesDir(), this.a.b.a);
                    try {
                        file.delete();
                        return null;
                    } catch (Exception e) {
                        String strValueOf = String.valueOf(file.getName());
                        throw new com.google.android.libraries.navigation.internal.ff.b("Failed to unset marker file: ".concat(strValueOf), e, file.getName());
                    }
                }
            });
        } catch (Exception unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) j.b.F((char) 450)).p("Unable to unset marker");
        }
        try {
            if (((Boolean) com.google.android.libraries.navigation.internal.fh.a.a(new Callable() { // from class: com.google.android.libraries.navigation.internal.fd.g
                @Override // java.util.concurrent.Callable
                public final Object call() throws com.google.android.libraries.navigation.internal.fe.b {
                    this.a.a.a(context);
                    return true;
                }
            })).booleanValue()) {
                return;
            }
            j.a aVar = j.b;
            new RuntimeException("Unable to reset unsuccessful startup detector");
            ((com.google.android.libraries.navigation.internal.zb.h) aVar.F(448)).o();
        } catch (Exception unused2) {
            ((com.google.android.libraries.navigation.internal.zb.h) j.b.F((char) 449)).p("Error resetting unsuccessful startup crashloop counter");
        }
    }
}
