package com.google.android.libraries.navigation.internal.abh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ci extends com.google.android.libraries.navigation.internal.ly.co {
    public final /* synthetic */ cm a;

    public ci(cm cmVar) {
        this.a = cmVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cp
    public final void as(boolean z) {
        cm cmVar = this.a;
        try {
            cmVar.h.a();
            cmVar.i.c(z ? com.google.android.libraries.navigation.internal.abx.b.MAP_ENABLE_ALL_GESTURES : com.google.android.libraries.navigation.internal.abx.b.MAP_DISABLE_ALL_GESTURES);
            cmVar.aC(z);
            cmVar.aE(z);
            cmVar.aD(z);
            cmVar.aB(z);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cp
    public final void at(boolean z) {
        cm cmVar = this.a;
        try {
            cmVar.h.a();
            cmVar.i.c(z ? com.google.android.libraries.navigation.internal.abx.b.MAP_ENABLE_MY_LOCATION_BUTTON : com.google.android.libraries.navigation.internal.abx.b.MAP_DISABLE_MY_LOCATION_BUTTON);
            cmVar.aA(z);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cp
    public final boolean au() {
        try {
            return this.a.b.L();
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }
}
