package com.google.android.libraries.navigation.internal.hh;

import java.io.Serializable;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class u implements Serializable {
    public final t a;
    public final String b;

    public u(t tVar, String str) {
        this.a = tVar;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return Intrinsics.areEqual(this.a.a(), uVar.a.a()) && Intrinsics.areEqual(this.b, uVar.b);
    }

    public final int hashCode() {
        return Objects.hash(this.a.a(), this.b);
    }

    public final String toString() {
        return this.a.a() + "-" + this.b;
    }
}
