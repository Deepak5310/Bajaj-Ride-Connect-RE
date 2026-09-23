package com.google.android.libraries.navigation.internal.sb;

import com.google.android.libraries.navigation.internal.rz.ai;
import com.google.android.libraries.navigation.internal.rz.al;
import com.google.android.libraries.navigation.internal.rz.am;
import com.google.android.libraries.navigation.internal.rz.an;
import com.google.android.libraries.navigation.internal.rz.m;
import com.google.android.libraries.navigation.internal.sa.f;
import com.google.android.libraries.navigation.internal.sa.h;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static ai a(h hVar) {
        m mVar = new m();
        int i = ev.d;
        ev evVar = lv.a;
        Objects.requireNonNull(evVar);
        if (mVar.a != null) {
            throw new IllegalStateException();
        }
        mVar.b = evVar;
        if (hVar.a().isEmpty()) {
            return mVar.a();
        }
        boolean zIsEmpty = hVar.e().isEmpty();
        String strC = StringUtils.SPACE;
        if (!zIsEmpty) {
            al alVarG = an.g(am.PREPOSITION);
            alVarG.f(hVar.e());
            alVarG.d(false);
            mVar.c(alVarG.a());
            al alVarG2 = an.g(am.DELIMITER);
            alVarG2.f(hVar.c().isEmpty() ? StringUtils.SPACE : hVar.c());
            alVarG2.d(false);
            mVar.c(alVarG2.a());
        }
        int i2 = 0;
        while (i2 < hVar.a().size()) {
            f fVar = (f) hVar.a().get(i2);
            int i3 = 0;
            boolean z = false;
            while (true) {
                if (i3 >= ((lv) fVar.a()).c) {
                    break;
                }
                an anVar = (an) fVar.a().get(i3);
                mVar.c(anVar);
                boolean z2 = anVar.b() == am.ROAD_BADGE || anVar.b() == am.EXIT_NUMBER;
                boolean zF = anVar.f();
                i3++;
                if (((lv) fVar.a()).c > i3) {
                    boolean zF2 = ((an) fVar.a().get(i3)).f();
                    al alVarG3 = an.g(am.DELIMITER);
                    alVarG3.f(StringUtils.SPACE);
                    alVarG3.d(zF && zF2);
                    mVar.c(alVarG3.a());
                }
                z = z2;
            }
            i2++;
            if (hVar.a().size() > i2) {
                if (z) {
                    al alVarG4 = an.g(am.DELIMITER);
                    alVarG4.f(StringUtils.SPACE);
                    alVarG4.d(true);
                    mVar.c(alVarG4.a());
                } else {
                    al alVarG5 = an.g(am.DELIMITER);
                    alVarG5.f(hVar.b().isEmpty() ? StringUtils.SPACE : hVar.b());
                    alVarG5.d(true);
                    mVar.c(alVarG5.a());
                }
            }
        }
        if (!hVar.d().isEmpty()) {
            al alVarG6 = an.g(am.DELIMITER);
            if (!hVar.c().isEmpty()) {
                strC = hVar.c();
            }
            alVarG6.f(strC);
            alVarG6.d(false);
            mVar.c(alVarG6.a());
            al alVarG7 = an.g(am.PREPOSITION);
            alVarG7.f(hVar.d());
            alVarG7.d(false);
            mVar.c(alVarG7.a());
        }
        return mVar.a();
    }
}
