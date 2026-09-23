package com.google.android.libraries.navigation.internal.abn;

import com.drew.metadata.exif.ExifDirectoryBase;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ao implements bf {
    public ar a = null;
    final /* synthetic */ ac b;
    final /* synthetic */ as c;

    public ao(as asVar, ac acVar) {
        this.b = acVar;
        this.c = asVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.bf
    public final void a(aw awVar) {
        this.a = this.c.B(awVar, 1.0f, this.b, ExifDirectoryBase.TAG_SUB_IFD_OFFSET);
    }
}
