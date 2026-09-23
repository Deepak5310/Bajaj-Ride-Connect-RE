package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public enum ea {
    INVALID,
    IDLE,
    BEGIN_FRAME,
    UPDATE,
    PRE_DRAW,
    DRAW,
    POST_DRAW,
    END_FRAME;

    public static long j;
    public static final ThreadLocal i = new ThreadLocal() { // from class: com.google.android.libraries.geo.mapcore.renderer.dz
        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ Object initialValue() {
            return ea.INVALID;
        }
    };
    public static int k = 0;
    public static final long[] l = new long[values().length];
    public static final long[] m = new long[values().length];

    static void a(ea eaVar, ea eaVar2) {
        if (eaVar == IDLE) {
            k++;
        }
        long jNanoTime = System.nanoTime();
        long j2 = jNanoTime - j;
        j = jNanoTime;
        long[] jArr = l;
        int iOrdinal = eaVar.ordinal();
        jArr[iOrdinal] = jArr[iOrdinal] + j2;
        long[] jArr2 = m;
        int iOrdinal2 = eaVar.ordinal();
        jArr2[iOrdinal2] = jArr2[iOrdinal2] + (j2 * j2);
        i.set(eaVar2);
    }
}
