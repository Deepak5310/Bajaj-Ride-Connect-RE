package com.google.android.libraries.navigation.internal.abn;

import com.drew.metadata.exif.ExifDirectoryBase;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class an implements bf {
    public float b;
    final /* synthetic */ float c;
    final /* synthetic */ float d;
    final /* synthetic */ boolean e;
    final /* synthetic */ float f;
    final /* synthetic */ as g;
    private float h;
    private float i;
    private ac j = null;
    public ar a = null;

    public an(as asVar, float f, float f2, boolean z, float f3) {
        this.c = f;
        this.d = f2;
        this.e = z;
        this.f = f3;
        this.g = asVar;
        this.h = f;
        this.i = f2;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.bf
    public final void a(aw awVar) {
        if (!this.g.y().j) {
            ac acVarI = awVar.i();
            this.j = acVarI;
            this.h = (float) acVarI.a;
            this.i = (float) acVarI.b;
        }
        if (this.e) {
            this.b = -1.0f;
            this.a = this.g.B(awVar, -1.0f, this.j, ExifDirectoryBase.TAG_SUB_IFD_OFFSET);
            return;
        }
        float fLog = (float) (Math.log(this.f) / as.a);
        this.b = fLog;
        as asVar = this.g;
        float f = this.h;
        float f2 = this.i;
        au auVarC = asVar.C();
        auVarC.b(fLog, 0.0f, f, f2, 0.0f, 0.0f);
        asVar.D(auVarC, awVar);
        ar arVar = null;
        if (asVar.f != null && asVar.d != null) {
            arVar = new ar(awVar.c() + fLog, awVar.i());
        }
        this.a = arVar;
    }
}
