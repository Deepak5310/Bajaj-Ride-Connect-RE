package com.google.android.libraries.navigation.internal.hh;

import com.drew.metadata.exif.makernotes.OlympusMakernoteDirectory;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.maps.android.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class w implements Serializable {
    private static final com.google.android.libraries.navigation.internal.zb.j b = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.hh.w");
    b a;
    private transient Serializable c;
    private transient boolean d;
    private transient boolean e;
    private final transient List f;

    public w(b bVar, Serializable serializable, boolean z, boolean z2) {
        int i = ev.d;
        this.f = lv.a;
        if (bVar != null) {
            this.a = bVar;
        }
        this.c = serializable;
        this.d = z;
        this.e = z2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        if (!(objectInputStream instanceof x)) {
            throw new IOException("Deserialize StorageReferences using GmmStorage#getSerializable: ".concat(toString()));
        }
        objectInputStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        if (!(objectOutputStream instanceof y)) {
            throw new IOException("Serialize StorageReferences using GmmStorage#putSerializable: ".concat(toString()));
        }
        objectOutputStream.defaultWriteObject();
    }

    public final synchronized Serializable a() {
        while (!this.d) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return this.c;
    }

    final synchronized void b(Serializable serializable) {
        ap.GMM_STORAGE.f();
        if (!this.d) {
            this.c = serializable;
            this.d = true;
            notifyAll();
            if (!this.f.isEmpty()) {
                ((com.google.android.libraries.navigation.internal.zb.h) b.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 653)).p("scheduleNotifyStorageListeners: storageListeners is non-empty, but uiExecutor is null");
            }
        }
    }

    public final synchronized void c(final i iVar) {
        ar.q(this.a);
        if (this.e) {
            this.e = false;
            final b bVar = this.a;
            final Serializable serializable = this.c;
            iVar.c.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.hh.g
                @Override // java.lang.Runnable
                public final void run() {
                    ap.GMM_STORAGE.f();
                    i iVar2 = iVar;
                    u uVar = bVar;
                    Serializable serializable2 = serializable;
                    try {
                        if (serializable2 == null) {
                            iVar2.b.c(uVar);
                            return;
                        }
                        serializable2.getClass();
                        String str = iVar2.d;
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        y yVar = new y(byteArrayOutputStream, iVar2);
                        try {
                            yVar.a();
                            yVar.writeUTF(serializable2.getClass().getName());
                            yVar.writeByte(1);
                            if (str != null) {
                                yVar.writeUTF(str);
                            }
                            if (serializable2 instanceof v) {
                                ((v) serializable2).b();
                            } else {
                                yVar.writeObject(serializable2);
                            }
                            yVar.close();
                            iVar2.b.a(uVar, byteArrayOutputStream.toByteArray());
                        } catch (Throwable th) {
                            try {
                                yVar.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (Exception e) {
                        ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) i.a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F(OlympusMakernoteDirectory.TAG_PREVIEW_IMAGE)).s("Failed to save item: %s", serializable2 == null ? BuildConfig.TRAVIS : serializable2.toString());
                    }
                }
            });
        }
    }

    public final String toString() {
        return "StorageReference(" + String.valueOf(this.c) + ")";
    }
}
