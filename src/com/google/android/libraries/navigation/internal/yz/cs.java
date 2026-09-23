package com.google.android.libraries.navigation.internal.yz;

import com.google.firebase.sessions.settings.RemoteSettings;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cs extends cv {
    private static final long serialVersionUID = 0;

    public cs(Comparable comparable) {
        super(comparable);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.cv
    public final void c(StringBuilder sb) {
        sb.append('(');
        sb.append(this.b);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.cv
    public final void d(StringBuilder sb) {
        sb.append(this.b);
        sb.append(']');
    }

    @Override // com.google.android.libraries.navigation.internal.yz.cv
    public final boolean e(Comparable comparable) {
        return lr.b(this.b, comparable) < 0;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.cv
    public final int hashCode() {
        return ~this.b.hashCode();
    }

    public final String toString() {
        return RemoteSettings.FORWARD_SLASH_STRING + String.valueOf(this.b) + "\\";
    }
}
