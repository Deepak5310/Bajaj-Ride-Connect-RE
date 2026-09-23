package com.google.android.libraries.navigation.internal.xf;

import com.google.android.libraries.navigation.internal.adr.bw;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k extends com.google.android.libraries.navigation.internal.bj.a {
    private bw a = bw.UNSET;

    @Override // com.google.android.libraries.navigation.internal.bj.b
    public final synchronized bw a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.bj.b
    public final synchronized boolean b(int i) {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.bj.b
    public final void c() {
    }

    public final synchronized void d(int i, String str) {
        if (!"BR".equals(str)) {
            if (!"ID".equals(str)) {
                this.a = bw.UNSET;
                return;
            } else if (i < 0 || i > 9) {
                this.a = bw.UNSET;
                return;
            } else {
                this.a = (i & 1) == 0 ? bw.JAKARTA_EVEN : bw.JAKARTA_ODD;
                return;
            }
        }
        switch (i) {
            case 0:
            case 9:
                this.a = bw.SAO_PAULO_RODIZIO_9_0;
                return;
            case 1:
            case 2:
                this.a = bw.SAO_PAULO_RODIZIO_1_2;
                return;
            case 3:
            case 4:
                this.a = bw.SAO_PAULO_RODIZIO_3_4;
                return;
            case 5:
            case 6:
                this.a = bw.SAO_PAULO_RODIZIO_5_6;
                return;
            case 7:
            case 8:
                this.a = bw.SAO_PAULO_RODIZIO_7_8;
                return;
            default:
                this.a = bw.UNSET;
                return;
        }
    }
}
