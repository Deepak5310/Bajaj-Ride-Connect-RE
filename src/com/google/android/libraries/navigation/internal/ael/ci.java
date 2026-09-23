package com.google.android.libraries.navigation.internal.ael;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ci {
    protected volatile cy a;
    public volatile x b;
    private volatile boolean c;

    public final x a() {
        if (this.b != null) {
            return this.b;
        }
        synchronized (this) {
            if (this.b != null) {
                return this.b;
            }
            if (this.a == null) {
                this.b = x.b;
            } else {
                this.b = this.a.k();
            }
            return this.b;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ci)) {
            return false;
        }
        ci ciVar = (ci) obj;
        cy cyVar = this.a;
        cy cyVar2 = ciVar.a;
        if (cyVar == null && cyVar2 == null) {
            return a().equals(ciVar.a());
        }
        if (cyVar == null || cyVar2 == null) {
            return cyVar != null ? cyVar.equals(ciVar.b(cyVar.al())) : b(cyVar2.al()).equals(cyVar2);
        }
        return cyVar.equals(cyVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final cy b(cy cyVar) {
        if (this.a == null) {
            synchronized (this) {
                if (this.a == null) {
                    try {
                        this.a = cyVar;
                        this.b = x.b;
                    } catch (cc unused) {
                        this.c = true;
                        this.a = cyVar;
                        this.b = x.b;
                    }
                }
            }
        }
        return this.a;
    }
}
