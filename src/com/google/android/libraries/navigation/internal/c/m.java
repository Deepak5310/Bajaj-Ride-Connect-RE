package com.google.android.libraries.navigation.internal.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.google.android.libraries.navigation.internal.b.ag;
import com.google.android.libraries.navigation.internal.b.t;
import com.google.android.libraries.navigation.internal.b.x;
import com.google.android.libraries.navigation.internal.b.y;
import com.google.android.libraries.navigation.internal.b.z;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class m extends t {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Object f364n = new Object();
    private final Object o;
    private y p;
    private final Bitmap.Config q;

    @Deprecated
    public m(String str, y yVar, Bitmap.Config config, x xVar) {
        super(0, str, xVar);
        this.o = new Object();
        this.m = new com.google.android.libraries.navigation.internal.b.g(1000, 2, 2.0f);
        this.p = yVar;
        this.q = config;
    }

    @Override // com.google.android.libraries.navigation.internal.b.t
    protected final z b(com.google.android.libraries.navigation.internal.b.o oVar) {
        z zVar;
        synchronized (f364n) {
            try {
                try {
                    byte[] bArr = oVar.b;
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = this.q;
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                    zVar = bitmapDecodeByteArray == null ? new z(new com.google.android.libraries.navigation.internal.b.q(oVar)) : new z(bitmapDecodeByteArray, i.b(oVar));
                } catch (OutOfMemoryError e) {
                    ag.b("Caught OOM for %d byte image, url=%s", Integer.valueOf(oVar.b.length), this.c);
                    return new z(new com.google.android.libraries.navigation.internal.b.q(e));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zVar;
    }

    @Override // com.google.android.libraries.navigation.internal.b.t
    public final void g() {
        super.g();
        synchronized (this.o) {
            this.p = null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.b.t
    protected final /* bridge */ /* synthetic */ void h(Object obj) {
        y yVar;
        Bitmap bitmap = (Bitmap) obj;
        synchronized (this.o) {
            yVar = this.p;
        }
        if (yVar != null) {
            yVar.b(bitmap);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.b.t
    public final int p() {
        return 1;
    }
}
