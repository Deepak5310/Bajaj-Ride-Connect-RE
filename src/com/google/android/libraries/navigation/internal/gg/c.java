package com.google.android.libraries.navigation.internal.gg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements b {
    private final List a = new ArrayList();
    private boolean b;

    @Override // com.google.android.libraries.navigation.internal.gg.b
    public final boolean a() {
        boolean z;
        synchronized (this) {
            this.b = true;
            Iterator it2 = this.a.iterator();
            while (true) {
                z = false;
                while (true) {
                    if (!it2.hasNext()) {
                        this.a.clear();
                        Unit unit = Unit.INSTANCE;
                    } else if (((b) it2.next()).a() || z) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public final String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("numHandles=");
        synchronized (this) {
            sb.append(this.a.size());
            sb.append("\nalreadyCancelled=");
            synchronized (this) {
                z = this.b;
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
        sb.append(z);
        sb.append("\n");
        String string2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        return string2;
    }
}
