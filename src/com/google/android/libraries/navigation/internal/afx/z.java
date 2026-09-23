package com.google.android.libraries.navigation.internal.afx;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class z {
    public static final b a = new b("io.grpc.EquivalentAddressGroup.ATTR_AUTHORITY_OVERRIDE");
    public final List b;
    public final c c;
    private final int d;

    public z(SocketAddress socketAddress) {
        this(socketAddress, c.a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        if (this.b.size() != zVar.b.size()) {
            return false;
        }
        for (int i = 0; i < this.b.size(); i++) {
            if (!((SocketAddress) this.b.get(i)).equals(zVar.b.get(i))) {
                return false;
            }
        }
        return this.c.equals(zVar.c);
    }

    public final int hashCode() {
        return this.d;
    }

    public final String toString() {
        c cVar = this.c;
        return "[" + String.valueOf(this.b) + RemoteSettings.FORWARD_SLASH_STRING + String.valueOf(cVar) + "]";
    }

    public z(SocketAddress socketAddress, c cVar) {
        this(Collections.singletonList(socketAddress), cVar);
    }

    public z(List list, c cVar) {
        com.google.android.libraries.navigation.internal.yx.ar.b(!list.isEmpty(), "addrs is empty");
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.b = listUnmodifiableList;
        com.google.android.libraries.navigation.internal.yx.ar.r(cVar, "attrs");
        this.c = cVar;
        this.d = listUnmodifiableList.hashCode();
    }
}
