package com.google.android.libraries.navigation.internal.ael;

import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bc extends e {
    private final bi a;

    public bc(bi biVar) {
        this.a = biVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.e
    public final /* bridge */ /* synthetic */ cy d(byte[] bArr, int i, int i2, ar arVar) throws cc {
        return bi.v(this.a, bArr, i, i2, arVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dg
    public final /* bridge */ /* synthetic */ Object k(ac acVar, ar arVar) throws cc {
        Map map = bi.al;
        bi biVarU = this.a.u();
        try {
            dr drVarB = di.a.b(biVarU);
            drVarB.h(biVarU, ad.p(acVar), arVar);
            drVarB.f(biVarU);
            return biVarU;
        } catch (cc e) {
            if (e.a) {
                throw new cc(e);
            }
            throw e;
        } catch (ee e2) {
            throw e2.a();
        } catch (IOException e3) {
            if (e3.getCause() instanceof cc) {
                throw ((cc) e3.getCause());
            }
            throw new cc(e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof cc) {
                throw ((cc) e4.getCause());
            }
            throw e4;
        }
    }
}
