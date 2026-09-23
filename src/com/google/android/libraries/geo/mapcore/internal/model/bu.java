package com.google.android.libraries.geo.mapcore.internal.model;

import android.util.SparseIntArray;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class bu {
    public ah a;
    public int b = 0;
    public final boolean c;
    private final List d;
    private ByteBuffer e;

    public bu(boolean z) {
        ai aiVar = ai.c;
        this.a = new ah();
        this.d = new ArrayList();
        this.e = null;
        this.c = z;
    }

    public final bt a(long j, SparseIntArray sparseIntArray) {
        ByteBuffer byteBuffer = this.e;
        if (byteBuffer == null) {
            return new bt(j, null, null, sparseIntArray, this.c);
        }
        List list = this.d;
        return new bt(j, (ai[]) list.toArray(new ai[0]), byteBuffer.array(), sparseIntArray, this.c);
    }

    public final void b(int i) {
        ah ahVar = this.a;
        ahVar.v = this.b;
        this.d.add(new ai(ahVar));
        ByteBuffer byteBuffer = this.e;
        if (byteBuffer != null) {
            byteBuffer.put((byte) i);
        }
    }

    public final void c(int i) {
        ai aiVar = ai.c;
        this.a = new ah();
        this.d.clear();
        this.e = ByteBuffer.allocate(i);
        this.b = 0;
    }
}
