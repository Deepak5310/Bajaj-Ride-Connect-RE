package com.google.android.libraries.navigation.internal.hp;

import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import com.drew.metadata.mp4.media.Mp4VideoDirectory;
import com.google.android.libraries.navigation.internal.ace.dq;
import com.google.android.libraries.navigation.internal.ace.dr;
import com.google.android.libraries.navigation.internal.ace.ez;
import com.google.android.libraries.navigation.internal.ace.fa;
import com.google.android.libraries.navigation.internal.ace.fb;
import com.google.android.libraries.navigation.internal.ace.od;
import com.google.android.libraries.navigation.internal.ace.oe;
import com.google.android.libraries.navigation.internal.ace.x;
import com.google.android.libraries.navigation.internal.ace.y;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g {
    private final f a;

    public g(f fVar) {
        this.a = fVar;
    }

    public final y a(x xVar) {
        f fVar = this.a;
        d dVarZ = fVar.Z();
        fVar.aa();
        dVarZ.a(NikonType2MakernoteDirectory.TAG_AF_INFO_2);
        return new ez(xVar);
    }

    public final dr b(dq dqVar) {
        f fVar = this.a;
        d dVarZ = fVar.Z();
        return new fa(dqVar, dVarZ.a(Mp4VideoDirectory.TAG_COMPRESSION_TYPE), fVar.aa());
    }

    public final oe c(od odVar) {
        f fVar = this.a;
        d dVarZ = fVar.Z();
        return new fb(odVar, dVarZ.a(28), fVar.aa());
    }
}
