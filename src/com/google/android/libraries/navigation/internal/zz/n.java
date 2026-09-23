package com.google.android.libraries.navigation.internal.zz;

import com.google.android.libraries.navigation.internal.yz.de;
import com.google.android.libraries.navigation.internal.yz.dq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fy;
import java.io.Serializable;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n extends dq implements Serializable {
    private static final long serialVersionUID = 0;
    final /* synthetic */ o a;
    private transient fy b;

    public n(o oVar) {
        this.a = oVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.libraries.navigation.internal.yz.df, com.google.android.libraries.navigation.internal.yz.Cdo
    /* JADX INFO: renamed from: b */
    public final Set aF() {
        fy fyVar = this.b;
        if (fyVar != null) {
            return fyVar;
        }
        fy fyVarN = fy.n(de.d(l.a.d(ev.q(this.a))).c(m.IGNORE_TYPE_VARIABLE_OR_WILDCARD).h());
        this.b = fyVarN;
        return fyVarN;
    }

    public final Set h() {
        return fy.o(l.b.d(this.a.b()));
    }
}
