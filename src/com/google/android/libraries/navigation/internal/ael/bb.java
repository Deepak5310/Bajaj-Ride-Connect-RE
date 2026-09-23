package com.google.android.libraries.navigation.internal.ael;

import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.bi;
import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class bb<MessageType extends bi<MessageType, BuilderType>, BuilderType extends bb<MessageType, BuilderType>> extends b<MessageType, BuilderType> {
    public final bi a;
    public bi b;

    protected bb(MessageType messagetype) {
        this.a = messagetype;
        if (messagetype.H()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.b = s();
    }

    private static void c(Object obj, Object obj2) {
        di.a.b(obj).g(obj, obj2);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.cz
    public final /* synthetic */ cy al() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.cz
    public final boolean am() {
        return bi.G(this.b, false);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.b
    protected final /* synthetic */ b k(c cVar) {
        x((bi) cVar);
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.b
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final bb j() {
        bb bbVar = (bb) this.a.aH(5, null);
        bbVar.b = u();
        return bbVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.cx
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final MessageType t() {
        MessageType messagetype = (MessageType) u();
        if (messagetype.am()) {
            return messagetype;
        }
        throw new ee();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.cx
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public MessageType u() {
        if (!this.b.H()) {
            return (MessageType) this.b;
        }
        this.b.D();
        return (MessageType) this.b;
    }

    public final bi s() {
        return this.a.u();
    }

    public void v() {
        bi biVarS = s();
        c(biVarS, this.b);
        this.b = biVarS;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.b, com.google.android.libraries.navigation.internal.ael.cx
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final void o(ac acVar, ar arVar) throws IOException {
        if (!this.b.H()) {
            v();
        }
        try {
            di.a.b(this.b).h(this.b, ad.p(acVar), arVar);
        } catch (RuntimeException e) {
            if (!(e.getCause() instanceof IOException)) {
                throw e;
            }
            throw ((IOException) e.getCause());
        }
    }

    public final void x(bi biVar) {
        if (this.a.equals(biVar)) {
            return;
        }
        if (!this.b.H()) {
            v();
        }
        c(this.b, biVar);
    }
}
