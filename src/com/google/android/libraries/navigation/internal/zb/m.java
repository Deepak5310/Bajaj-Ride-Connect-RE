package com.google.android.libraries.navigation.internal.zb;

import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class m extends ac {
    public m(Class cls) {
        super("group_by", cls, true);
    }

    @Override // com.google.android.libraries.navigation.internal.zb.ac
    public final void a(Iterator it2, ab abVar) {
        if (it2.hasNext()) {
            Object next = it2.next();
            if (!it2.hasNext()) {
                abVar.a(this.a, next);
                return;
            }
            StringBuilder sb = new StringBuilder("[");
            sb.append(next);
            do {
                sb.append(',');
                sb.append(it2.next());
            } while (it2.hasNext());
            String str = this.a;
            sb.append(']');
            abVar.a(str, sb.toString());
        }
    }
}
