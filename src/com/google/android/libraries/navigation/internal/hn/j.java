package com.google.android.libraries.navigation.internal.hn;

import com.google.android.libraries.navigation.internal.afl.cd;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class j {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.hn.j");
    private final List b;

    public j(cd cdVar) {
        int i = ev.d;
        eq eqVar = new eq();
        for (String str : cdVar.b) {
            try {
                eqVar.h(Pattern.compile(str));
            } catch (PatternSyntaxException e) {
                ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F(658)).s("Invalid denylist regex: %s", str);
            }
        }
        this.b = eqVar.g();
    }

    public final String toString() {
        ak akVarB = al.b(this);
        akVarB.g("denylistedPatterns", this.b);
        return akVarB.toString();
    }
}
