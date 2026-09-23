package com.google.android.libraries.navigation.internal.bp;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ab extends ac {
    public final int a;

    public ab(int i) {
        this.a = i;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ab) && ((ab) obj).a == this.a;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "<canned_message id=\"" + this.a + "\">";
    }
}
