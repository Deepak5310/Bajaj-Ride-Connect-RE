package com.google.android.libraries.navigation.internal.um;

import com.google.android.libraries.navigation.internal.gw.o;
import com.google.android.libraries.navigation.internal.gw.z;
import java.util.EnumMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class d {
    public final z a;
    public final o b;
    public final int c;
    public final int d;
    public final float e;
    public final EnumMap f = new EnumMap(b.class);

    /* JADX INFO: compiled from: PG */
    public class a {
        private final c a;
        private final c b;
        private final c c;
        private final c d;

        public a(c cVar, c cVar2, c cVar3, c cVar4) {
            this.a = cVar;
            this.b = cVar2;
            this.c = cVar3;
            this.d = cVar4;
        }

        public final c a(boolean z, boolean z2) {
            if (z) {
                return z2 ? this.b : this.d;
            }
            return z2 ? this.a : this.c;
        }
    }

    public d(z zVar, o oVar, int i, int i2, int i3) {
        this.a = zVar;
        this.b = oVar;
        this.c = i2;
        this.d = i3;
        this.e = i / 110.0f;
    }
}
