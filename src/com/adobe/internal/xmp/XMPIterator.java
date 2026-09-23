package com.adobe.internal.xmp;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public interface XMPIterator extends Iterator {
    void skipSiblings();

    void skipSubtree();
}
