package com.google.android.libraries.navigation.internal.abf;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l {
    public String a = "";
    public String b = "";
    public String c = "";

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        if (!this.b.isEmpty()) {
            sb.append("-");
            sb.append(this.b);
        }
        if (!this.c.isEmpty()) {
            sb.append("-");
            sb.append(this.c);
        }
        return sb.toString();
    }
}
