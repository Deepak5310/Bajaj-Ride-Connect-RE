package com.google.android.libraries.navigation.internal.ael;

import com.google.android.libraries.navigation.internal.ael.b;
import com.google.android.libraries.navigation.internal.ael.c;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> implements cy {
    public int ak = 0;

    public int j(dr drVar) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.cy
    public final x k() {
        try {
            int iP = p();
            x xVar = x.b;
            t tVar = new t(iP);
            aJ(tVar.a);
            return tVar.a();
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.cy
    public final void l(OutputStream outputStream) throws IOException {
        ah ahVar = new ah(outputStream, ai.N(p()));
        aJ(ahVar);
        ahVar.aw();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.cy
    public final byte[] m() {
        try {
            byte[] bArr = new byte[p()];
            ai aiVarAb = ai.ab(bArr);
            aJ(aiVarAb);
            aiVarAb.ac();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
