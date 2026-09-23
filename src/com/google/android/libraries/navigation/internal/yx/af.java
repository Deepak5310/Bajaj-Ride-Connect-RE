package com.google.android.libraries.navigation.internal.yx;

import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class af extends ah {
    final /* synthetic */ ah a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(ah ahVar, ah ahVar2) {
        super(ahVar2);
        this.a = ahVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.ah
    public final ah b() {
        throw new UnsupportedOperationException("already specified skipNulls");
    }

    @Override // com.google.android.libraries.navigation.internal.yx.ah
    public final void c(Appendable appendable, Iterator it2) throws IOException {
        ar.r(appendable, "appendable");
        ar.r(it2, "parts");
        while (it2.hasNext()) {
            Object next = it2.next();
            if (next != null) {
                appendable.append(this.a.a(next));
                break;
            }
        }
        while (it2.hasNext()) {
            Object next2 = it2.next();
            if (next2 != null) {
                appendable.append(this.a.c);
                appendable.append(this.a.a(next2));
            }
        }
    }
}
