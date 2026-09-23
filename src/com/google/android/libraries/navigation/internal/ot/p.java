package com.google.android.libraries.navigation.internal.ot;

import com.google.android.libraries.navigation.internal.ol.t;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class p {
    public static p c(o oVar) {
        t mVar;
        int iOrdinal = oVar.ordinal();
        if (iOrdinal == 0) {
            mVar = new m();
        } else {
            if (iOrdinal == 1 || iOrdinal == 2) {
                throw new IllegalArgumentException("MyLocation transformers must be created via the newMyLocationTransition[...]Transformer() APIs.");
            }
            if (iOrdinal == 3) {
                throw new IllegalArgumentException("ARWalkingCircletransformer must be created via newArWalkingCircleTextTransformer().");
            }
            if (iOrdinal == 4) {
                throw new IllegalArgumentException("LocationSharingPathTransformer must be created via newLocationSharingPathTransformer().");
            }
            mVar = n.a;
        }
        return new d(oVar, mVar);
    }

    public abstract t a();

    public abstract o b();
}
