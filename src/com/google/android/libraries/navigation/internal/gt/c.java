package com.google.android.libraries.navigation.internal.gt;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.gg.k;
import com.google.android.libraries.navigation.internal.nw.e;
import j$.time.Duration;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UploadDataSink;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class c extends UploadDataProvider {
    public final byte[] a;
    private final k b;
    private final com.google.android.libraries.navigation.internal.mj.a c;
    private int d = 0;

    public c(ByteArrayOutputStream byteArrayOutputStream, k kVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        this.a = byteArrayOutputStream.toByteArray();
        this.b = kVar;
        this.c = aVar;
    }

    @Override // org.chromium.net.UploadDataProvider
    public final long getLength() throws IOException {
        return this.a.length;
    }

    @Override // org.chromium.net.UploadDataProvider
    public final void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) throws IOException {
        com.google.android.libraries.navigation.internal.nw.d dVarB = e.b("RequestUploader Upload request data");
        try {
            int iRemaining = byteBuffer.remaining();
            int length = this.a.length;
            int i = this.d;
            int iMin = Math.min(iRemaining, length - i);
            if (i == 0) {
                this.b.c(Duration.ofMillis(this.c.a()));
            }
            byteBuffer.put(this.a, this.d, iMin);
            int i2 = this.d + iMin;
            this.d = i2;
            if (i2 == this.a.length) {
                this.b.e(Duration.ofMillis(this.c.a()));
            }
            uploadDataSink.onReadSucceeded(false);
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // org.chromium.net.UploadDataProvider
    public final void rewind(UploadDataSink uploadDataSink) throws IOException {
        this.d = 0;
        uploadDataSink.onRewindSucceeded();
    }
}
