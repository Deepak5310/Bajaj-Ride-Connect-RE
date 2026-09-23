package com.google.android.libraries.navigation.internal.gt;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private final List a = new ArrayList();

    public final ByteBuffer a() {
        int iRemaining = 0;
        if (this.a.isEmpty()) {
            return ByteBuffer.allocateDirect(0);
        }
        if (this.a.size() == 1) {
            ByteBuffer byteBuffer = (ByteBuffer) this.a.get(0);
            if (byteBuffer.hasRemaining()) {
                byteBuffer.flip();
            }
            this.a.clear();
            byteBuffer.position(0);
            return byteBuffer;
        }
        for (ByteBuffer byteBuffer2 : this.a) {
            byteBuffer2.flip();
            iRemaining += byteBuffer2.remaining();
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(iRemaining);
        Iterator it2 = this.a.iterator();
        while (it2.hasNext()) {
            byteBufferAllocateDirect.put((ByteBuffer) it2.next());
        }
        this.a.clear();
        byteBufferAllocateDirect.flip();
        return byteBufferAllocateDirect;
    }

    public final void b(ByteBuffer byteBuffer) {
        this.a.add(byteBuffer);
    }
}
