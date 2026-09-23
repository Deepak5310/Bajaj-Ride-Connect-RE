package com.google.android.libraries.navigation.internal.qz;

import android.graphics.BitmapFactory;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d extends c {
    private final byte[] c;

    public d(k kVar, byte[] bArr) {
        super(kVar);
        this.c = bArr;
    }

    @Override // com.google.android.libraries.navigation.internal.qz.f
    protected final /* bridge */ /* synthetic */ Object b() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        options.inInputShareable = true;
        byte[] bArr = this.c;
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }
}
