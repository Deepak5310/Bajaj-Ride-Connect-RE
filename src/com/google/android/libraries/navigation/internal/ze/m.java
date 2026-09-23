package com.google.android.libraries.navigation.internal.ze;

import android.util.Log;
import com.google.android.libraries.navigation.internal.zb.o;
import com.google.android.libraries.navigation.internal.zd.ae;
import com.google.android.libraries.navigation.internal.zd.ah;
import com.google.android.libraries.navigation.internal.zd.aj;
import com.google.android.libraries.navigation.internal.zd.u;
import com.google.android.libraries.navigation.internal.zd.x;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m extends a {
    public static final Set a;
    public static final u b;
    public static final k c;
    private final String d;
    private final com.google.android.libraries.navigation.internal.zd.h e;
    private final Level f;
    private final Set g;
    private final u h;

    static {
        Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(o.a, com.google.android.libraries.navigation.internal.zc.a.a, com.google.android.libraries.navigation.internal.zc.b.a)));
        a = setUnmodifiableSet;
        u uVarA = x.a(setUnmodifiableSet);
        b = uVarA;
        c = new k(com.google.android.libraries.navigation.internal.zd.i.NO_OP, Level.ALL, setUnmodifiableSet, uVarA);
    }

    public m(String str, com.google.android.libraries.navigation.internal.zd.h hVar, Level level, Set set, u uVar) {
        super(str);
        this.d = f.b(str);
        this.e = hVar;
        this.f = level;
        this.g = set;
        this.h = uVar;
    }

    public static void e(com.google.android.libraries.navigation.internal.zd.f fVar, com.google.android.libraries.navigation.internal.zd.h hVar, Level level, Set set, u uVar) {
        Boolean bool = (Boolean) fVar.i().d(com.google.android.libraries.navigation.internal.zc.b.a);
        if (bool == null || !bool.booleanValue()) {
            ae aeVarG = ae.g(ah.f(), fVar.i());
            boolean z = fVar.m().intValue() < level.intValue();
            if (!hVar.equals(com.google.android.libraries.navigation.internal.zd.i.NO_OP) || z || aj.b(fVar, aeVarG, set)) {
                StringBuilder sb = new StringBuilder();
                if (hVar.a(fVar.f(), sb)) {
                    sb.append(StringUtils.SPACE);
                }
                if (!z || fVar.j() == null) {
                    com.google.android.libraries.navigation.internal.zd.a.e(fVar, sb);
                    aj.c(aeVarG, uVar, sb);
                } else {
                    sb.append("(REDACTED) ");
                    sb.append(fVar.j().b);
                }
            } else {
                aj.a(fVar);
            }
            f.a(fVar.m());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zd.j
    public final void c(com.google.android.libraries.navigation.internal.zd.f fVar) {
        e(fVar, this.e, this.f, this.g, this.h);
    }

    @Override // com.google.android.libraries.navigation.internal.zd.j
    public final boolean d(Level level) {
        String str = this.d;
        int iA = f.a(level);
        return Log.isLoggable(str, iA) || Log.isLoggable("all", iA);
    }
}
