package com.google.android.libraries.navigation.internal.ol;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class w {
    public final int a;
    public final int b;

    public w(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final boolean equals(Object obj) {
        w wVar;
        if (this == obj) {
            return true;
        }
        if ((obj instanceof w) && (wVar = (w) obj) != null) {
            if (wVar.a == this.a && wVar.b == this.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b), 0});
    }

    public final String toString() {
        return String.format("GeometryOrder[plane=%s grade=%s withinGrade=%s]", Integer.valueOf(this.a), Integer.valueOf(this.b), 0);
    }
}
