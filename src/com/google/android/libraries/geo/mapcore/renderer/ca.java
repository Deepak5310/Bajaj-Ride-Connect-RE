package com.google.android.libraries.geo.mapcore.renderer;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import androidx.tracing.Trace;
import com.drew.metadata.exif.makernotes.FujifilmMakernoteDirectory;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ca {
    public final Runnable b;
    public boolean c;
    private final ArrayList d = new ArrayList();
    public final ArrayList a = new ArrayList();

    public ca(Runnable runnable) {
        this.b = runnable;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x012e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:123:0x00f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:? A[Catch: all -> 0x013f, SYNTHETIC, TryCatch #10 {, blocks: (B:4:0x0007, B:6:0x0010, B:57:0x00f5, B:94:0x0137, B:93:0x0134, B:95:0x0138, B:89:0x012e, B:7:0x001c, B:9:0x0022, B:10:0x0028, B:12:0x002e, B:15:0x003a, B:17:0x0048, B:20:0x0052, B:29:0x0085, B:30:0x0088, B:34:0x0094, B:44:0x00a5, B:43:0x00a2, B:51:0x00e2, B:52:0x00e5, B:55:0x00f0, B:67:0x010d, B:66:0x010a, B:85:0x0129, B:84:0x0126, B:19:0x004e, B:14:0x0034, B:53:0x00eb, B:39:0x009c, B:80:0x0120, B:62:0x0104, B:32:0x008f, B:21:0x0058, B:25:0x007a, B:26:0x007d, B:45:0x00a6, B:46:0x00b2, B:48:0x00b6, B:49:0x00dd, B:76:0x011b, B:75:0x0118), top: B:120:0x0007, inners: #2, #7 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00f5 A[Catch: all -> 0x013f, TRY_ENTER, TRY_LEAVE, TryCatch #10 {, blocks: (B:4:0x0007, B:6:0x0010, B:57:0x00f5, B:94:0x0137, B:93:0x0134, B:95:0x0138, B:89:0x012e, B:7:0x001c, B:9:0x0022, B:10:0x0028, B:12:0x002e, B:15:0x003a, B:17:0x0048, B:20:0x0052, B:29:0x0085, B:30:0x0088, B:34:0x0094, B:44:0x00a5, B:43:0x00a2, B:51:0x00e2, B:52:0x00e5, B:55:0x00f0, B:67:0x010d, B:66:0x010a, B:85:0x0129, B:84:0x0126, B:19:0x004e, B:14:0x0034, B:53:0x00eb, B:39:0x009c, B:80:0x0120, B:62:0x0104, B:32:0x008f, B:21:0x0058, B:25:0x007a, B:26:0x007d, B:45:0x00a6, B:46:0x00b2, B:48:0x00b6, B:49:0x00dd, B:76:0x011b, B:75:0x0118), top: B:120:0x0007, inners: #2, #7 }] */
    public final synchronized void a(int i, int i2) {
        ArrayList arrayList = this.d;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            com.google.android.libraries.navigation.internal.abm.ea eaVar = (com.google.android.libraries.navigation.internal.abm.ea) arrayList.get(i3);
            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("GlSnapshotter.dispatchSnapshots");
            try {
                Bitmap bitmapB = eaVar.b();
                if (bitmapB == null) {
                    bitmapB = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                }
                if (bitmapB.getWidth() != i || bitmapB.getHeight() != i2) {
                    bitmapB = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                }
                int i4 = i * i2 * 4;
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(i4);
                if (byteBufferAllocateDirect.capacity() < i4 || !byteBufferAllocateDirect.isDirect()) {
                    byteBufferAllocateDirect = ByteBuffer.allocateDirect(i4);
                }
                com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("GlSnapshotter.getSnapshotSync");
                try {
                    int width = bitmapB.getWidth();
                    int height = bitmapB.getHeight();
                    byteBufferAllocateDirect.clear();
                    com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("GlSnapshotter.getSnapshotSync.glReadPixels");
                    try {
                        GLES20.glReadPixels(0, 0, width, height, 6408, FujifilmMakernoteDirectory.TAG_FILM_MODE, byteBufferAllocateDirect);
                        if (dVarB3 != null) {
                            Trace.endSection();
                        }
                        if (GLES20.glGetError() != 0) {
                            if (dVarB2 != null) {
                                Trace.endSection();
                            }
                            com.google.android.libraries.navigation.internal.nw.d dVarB4 = com.google.android.libraries.navigation.internal.nw.e.b("GlSnapshotter.dispatchSnapshots.nullListener");
                            try {
                                eaVar.a(null);
                                if (dVarB4 != null) {
                                    Trace.endSection();
                                }
                                if (dVarB != null) {
                                    Trace.endSection();
                                }
                            } catch (Throwable th) {
                                if (dVarB4 == null) {
                                    throw th;
                                }
                                try {
                                    Trace.endSection();
                                    throw th;
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                    throw th;
                                }
                            }
                        } else {
                            byteBufferAllocateDirect.rewind();
                            IntBuffer intBufferAsIntBuffer = byteBufferAllocateDirect.asIntBuffer();
                            int[] iArr = new int[width];
                            int[] iArr2 = new int[width];
                            for (int i5 = 0; i5 < height / 2; i5++) {
                                int i6 = i5 * width;
                                int i7 = ((height - i5) - 1) * width;
                                intBufferAsIntBuffer.position(i6);
                                intBufferAsIntBuffer.get(iArr);
                                intBufferAsIntBuffer.position(i7);
                                intBufferAsIntBuffer.get(iArr2);
                                intBufferAsIntBuffer.position(i7);
                                intBufferAsIntBuffer.put(iArr);
                                intBufferAsIntBuffer.position(i6);
                                intBufferAsIntBuffer.put(iArr2);
                            }
                            bitmapB.copyPixelsFromBuffer(byteBufferAllocateDirect);
                            if (dVarB2 != null) {
                                Trace.endSection();
                            }
                            com.google.android.libraries.navigation.internal.nw.d dVarB5 = com.google.android.libraries.navigation.internal.nw.e.b("GlSnapshotter.dispatchSnapshots.completeListener");
                            try {
                                eaVar.a(bitmapB);
                                if (dVarB5 != null) {
                                    Trace.endSection();
                                }
                                if (dVarB != null) {
                                    Trace.endSection();
                                }
                            } catch (Throwable th3) {
                                if (dVarB5 == null) {
                                    throw th3;
                                }
                                try {
                                    Trace.endSection();
                                    throw th3;
                                } catch (Throwable th4) {
                                    th3.addSuppressed(th4);
                                    throw th3;
                                }
                            }
                        }
                    } catch (Throwable th5) {
                        if (dVarB3 == null) {
                            throw th5;
                        }
                        try {
                            Trace.endSection();
                            throw th5;
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                            throw th5;
                        }
                        if (dVarB != null) {
                            throw th;
                        }
                        try {
                            Trace.endSection();
                            throw th;
                        } catch (Throwable th7) {
                            th.addSuppressed(th7);
                            throw th;
                        }
                    }
                } catch (Throwable th8) {
                    if (dVarB2 == null) {
                        throw th8;
                    }
                    try {
                        Trace.endSection();
                        throw th8;
                    } catch (Throwable th9) {
                        th8.addSuppressed(th9);
                        throw th8;
                    }
                }
            } catch (Throwable th10) {
                if (dVarB != null) {
                    throw th10;
                }
                Trace.endSection();
                throw th10;
            }
            throw th;
        }
        this.d.clear();
    }

    public final synchronized void b() {
        this.d.addAll(this.a);
        this.a.clear();
    }

    public final synchronized void c(boolean z) {
        this.c = z;
        if (z) {
            ArrayList arrayList = this.d;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((com.google.android.libraries.navigation.internal.abm.ea) arrayList.get(i)).a(null);
            }
            this.d.clear();
            ArrayList arrayList2 = this.a;
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((com.google.android.libraries.navigation.internal.abm.ea) arrayList2.get(i2)).a(null);
            }
            this.a.clear();
        }
    }
}
