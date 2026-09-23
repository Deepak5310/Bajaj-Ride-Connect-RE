package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.adg.ds;
import com.google.android.libraries.navigation.internal.adg.ee;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class k extends aj {
    private final ee a;
    private final ds b;

    public k(ee eeVar, ds dsVar) {
        Objects.requireNonNull(eeVar);
        this.a = eeVar;
        Objects.requireNonNull(dsVar);
        this.b = dsVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.aj
    public final ds a() {
        return this.b;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.aj
    public final ee b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof aj) {
            aj ajVar = (aj) obj;
            if (this.a.equals(ajVar.b()) && this.b.equals(ajVar.a())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }
}
