package com.google.android.libraries.navigation.internal.ael;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class e implements dg {
    private static final ar a;

    static {
        ar arVar = ar.a;
        di diVar = di.a;
        a = ar.a;
    }

    private static final void l(cy cyVar) throws cc {
        if (cyVar != null && !cyVar.am()) {
            throw new ee().a();
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.google.android.libraries.navigation.internal.ael.cy, java.lang.Object] */
    @Override // com.google.android.libraries.navigation.internal.ael.dg
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final cy h(InputStream inputStream, ar arVar) throws cc {
        ac acVarJ = ac.J(inputStream);
        ?? K = k(acVarJ, arVar);
        acVarJ.z(0);
        l(K);
        return K;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dg
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final cy i(byte[] bArr, ar arVar) throws cc {
        return j(bArr, 0, bArr.length, arVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dg
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final cy j(byte[] bArr, int i, int i2, ar arVar) throws cc {
        cy cyVarD = d(bArr, i, i2, arVar);
        l(cyVarD);
        return cyVarD;
    }

    public cy d(byte[] bArr, int i, int i2, ar arVar) throws cc {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dg
    public final /* bridge */ /* synthetic */ Object e(InputStream inputStream) throws cc {
        return h(inputStream, a);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0034  */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.libraries.navigation.internal.ael.cy, java.lang.Object] */
    @Override // com.google.android.libraries.navigation.internal.ael.dg
    public final /* bridge */ /* synthetic */ Object f(ByteBuffer byteBuffer) throws cc {
        ac acVarM;
        ar arVar = a;
        int i = ac.g;
        if (byteBuffer.hasArray()) {
            acVarM = ac.M(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), false);
        } else if (byteBuffer.isDirect()) {
            int i2 = ab.a;
            if (em.a) {
                acVarM = new ab(byteBuffer);
            } else {
                int iRemaining = byteBuffer.remaining();
                byte[] bArr = new byte[iRemaining];
                byteBuffer.duplicate().get(bArr);
                acVarM = ac.M(bArr, 0, iRemaining, true);
            }
        } else {
            int iRemaining2 = byteBuffer.remaining();
            byte[] bArr2 = new byte[iRemaining2];
            byteBuffer.duplicate().get(bArr2);
            acVarM = ac.M(bArr2, 0, iRemaining2, true);
        }
        ?? K = k(acVarM, arVar);
        acVarM.z(0);
        l(K);
        return K;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dg
    public final /* bridge */ /* synthetic */ Object g(byte[] bArr) throws cc {
        return i(bArr, a);
    }
}
