package com.google.android.libraries.navigation.internal.yr;

import java.util.UUID;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a implements ag {
    public final String a;
    private final ag b;
    private final UUID c;
    private Thread d;

    public a(String str, ag agVar, ae aeVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(str);
        this.a = str;
        this.b = agVar;
        this.c = agVar.d();
        au auVar = aeVar.c;
        this.d = Thread.currentThread();
    }

    @Override // com.google.android.libraries.navigation.internal.yr.ag
    public final ag a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.yr.ag
    public final String b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yr.ag
    public final Thread c() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.yr.ai, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ae aeVarA = i.a();
        ag agVar = aeVarA.b;
        if (agVar == null) {
            throw new j("Tried to end [" + b() + "], but no trace was active. This is caused by mismatched or missing calls to beginSpan.");
        }
        if (this == agVar) {
            i.e(aeVarA, agVar.a());
            this.d = null;
            return;
        }
        throw new k("Tried to end span " + b() + ", but that span is not the current span. The current span is " + agVar.b() + ".");
    }

    @Override // com.google.android.libraries.navigation.internal.yr.ag
    public final UUID d() {
        return this.c;
    }

    public final String toString() {
        int i = i.a;
        ag agVarA = this;
        int i2 = 0;
        int length = 0;
        while (agVarA != null) {
            i2++;
            length += agVarA.b().length();
            agVarA = agVarA.a();
            if (agVarA != null) {
                length += 4;
            }
        }
        if (i2 > 250) {
            String[] strArr = new String[i2];
            ag agVarA2 = this;
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                strArr[i3] = agVarA2.b();
                agVarA2 = agVarA2.a();
            }
            String strG = i.g(strArr);
            if (!strG.isEmpty()) {
                return strG;
            }
        }
        char[] cArr = new char[length];
        ag agVarA3 = this;
        while (agVarA3 != null) {
            String strB = agVarA3.b();
            length -= strB.length();
            strB.getChars(0, strB.length(), cArr, length);
            agVarA3 = agVarA3.a();
            if (agVarA3 != null) {
                length -= 4;
                " -> ".getChars(0, 4, cArr, length);
            }
        }
        return new String(cArr);
    }

    public a(String str, UUID uuid, ae aeVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(str);
        this.a = str;
        this.b = null;
        this.c = uuid;
        au auVar = aeVar.c;
        this.d = Thread.currentThread();
    }
}
