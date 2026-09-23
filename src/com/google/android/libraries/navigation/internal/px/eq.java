package com.google.android.libraries.navigation.internal.px;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class eq implements com.google.android.libraries.navigation.internal.fq.p {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.px.eq");
    private final com.google.android.libraries.navigation.internal.agg.eq b;
    private final com.google.android.libraries.navigation.internal.fq.f c;

    public eq(com.google.android.libraries.navigation.internal.fq.f fVar) {
        com.google.android.libraries.navigation.internal.agg.eq eqVar = new com.google.android.libraries.navigation.internal.agg.eq(3000);
        this.c = fVar;
        this.b = eqVar;
        com.google.android.libraries.navigation.internal.xn.a aVarD = com.google.android.libraries.navigation.internal.xn.a.d("Label Styled-off Cache");
        if (fVar != null) {
            fVar.c(this, aVarD);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.fq.p
    public final synchronized String a() {
        return "size: " + this.b.j;
    }

    public final synchronized void b() {
        h(0.0f);
    }

    public final synchronized void c(int i) {
        this.b.E(i);
        com.google.android.libraries.navigation.internal.agg.eq eqVar = this.b;
        if (eqVar.j > 3000) {
            eqVar.F();
        }
    }

    public final synchronized boolean d(int i) {
        boolean zF;
        zF = this.b.f(i);
        if (zF) {
            this.b.E(i);
        }
        return zF;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0031 A[Catch: all -> 0x0052, TryCatch #0 {, blocks: (B:8:0x0027, B:10:0x0031, B:17:0x0049, B:12:0x0036, B:14:0x003b, B:16:0x0043, B:7:0x000c), top: B:23:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:11:0x0035  */
    /* JADX WARN: Code duplicated, block: B:14:0x003b A[Catch: all -> 0x0052, TryCatch #0 {, blocks: (B:8:0x0027, B:10:0x0031, B:17:0x0049, B:12:0x0036, B:14:0x003b, B:16:0x0043, B:7:0x000c), top: B:23:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:16:0x0043 A[Catch: all -> 0x0052, LOOP:0: B:12:0x0036->B:16:0x0043, LOOP_END, TryCatch #0 {, blocks: (B:8:0x0027, B:10:0x0031, B:17:0x0049, B:12:0x0036, B:14:0x003b, B:16:0x0043, B:7:0x000c), top: B:23:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:26:0x0049 A[EDGE_INSN: B:26:0x0049->B:17:0x0049 BREAK  A[LOOP:0: B:12:0x0036->B:16:0x0043], SYNTHETIC] */
    @Override // com.google.android.libraries.navigation.internal.fq.p
    public final synchronized void h(float f) {
        com.google.android.libraries.navigation.internal.agg.eq eqVar;
        float f2;
        float f3;
        int i;
        com.google.android.libraries.navigation.internal.agg.eq eqVar2;
        if (f < 0.0f || f > 1.0f) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(1014)).s("fraction %f outside of bounds [0, 1]", Float.valueOf(f));
            f = 0.5f;
            eqVar = this.b;
            f2 = eqVar.j;
            f3 = 1.0f - f;
            if (f == 0.0f) {
                for (i = 0; i < ((int) (f2 * f3)); i++) {
                    eqVar2 = this.b;
                    if (!eqVar2.isEmpty()) {
                        break;
                    }
                    eqVar2.F();
                }
            } else {
                eqVar.clear();
            }
            com.google.android.libraries.navigation.internal.agg.eq eqVar3 = this.b;
            eqVar3.G(eqVar3.j);
        } else {
            eqVar = this.b;
            f2 = eqVar.j;
            f3 = 1.0f - f;
            if (f == 0.0f) {
                while (i < ((int) (f2 * f3))) {
                    eqVar2 = this.b;
                    if (!eqVar2.isEmpty()) {
                        break;
                        break;
                    }
                    eqVar2.F();
                }
            } else {
                eqVar.clear();
            }
            com.google.android.libraries.navigation.internal.agg.eq eqVar4 = this.b;
            eqVar4.G(eqVar4.j);
        }
        throw th;
    }
}
