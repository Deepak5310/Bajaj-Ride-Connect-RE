package com.google.android.apps.gmm.jni.util;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.aac.ac;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.bk;
import com.google.android.libraries.navigation.internal.aac.ck;
import com.google.android.libraries.navigation.internal.yx.aa;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class NativeHelper {
    public static final /* synthetic */ int a = 0;
    private static final AtomicReference b = new AtomicReference();

    public static bj a(final Runnable runnable) {
        bk bkVar;
        AtomicReference atomicReference = b;
        bj bjVar = (bj) atomicReference.get();
        if (bjVar == null) {
            synchronized (atomicReference) {
                bjVar = (bj) atomicReference.get();
                if (bjVar == null) {
                    bkVar = new bk(new Runnable() { // from class: com.google.android.apps.gmm.jni.util.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i = NativeHelper.a;
                            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("NativeHelper.loadLibrary()");
                            try {
                                com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("NativeHelper.loadLibrary()_load");
                                try {
                                    Thread.currentThread().getName();
                                    System.loadLibrary("gmm-jni");
                                    if (dVarB2 != null) {
                                        Trace.endSection();
                                    }
                                    com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("NativeHelper.loadLibrary()_init");
                                    try {
                                        NativeHelper.nativeInitClass();
                                        NativeHelper.nativeRegisterExceptionClass(c.class);
                                        if (dVarB3 != null) {
                                            Trace.endSection();
                                        }
                                        if (dVarB != null) {
                                            Trace.endSection();
                                        }
                                    } catch (Throwable th) {
                                        if (dVarB3 != null) {
                                            try {
                                                Trace.endSection();
                                            } catch (Throwable th2) {
                                                th.addSuppressed(th2);
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    if (dVarB2 != null) {
                                        try {
                                            Trace.endSection();
                                        } catch (Throwable th4) {
                                            th3.addSuppressed(th4);
                                        }
                                    }
                                    throw th3;
                                }
                            } catch (Throwable th5) {
                                if (dVarB != null) {
                                    try {
                                        Trace.endSection();
                                    } catch (Throwable th6) {
                                        th5.addSuppressed(th6);
                                    }
                                }
                                throw th5;
                            }
                        }
                    });
                    atomicReference.set(bkVar);
                    bjVar = bkVar;
                } else {
                    bkVar = null;
                }
            }
            if (bkVar != null) {
                bkVar.run();
            }
        }
        return runnable != null ? com.google.android.libraries.navigation.internal.yu.c.b(bjVar, new aa() { // from class: com.google.android.apps.gmm.jni.util.b
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                int i = NativeHelper.a;
                runnable.run();
                return null;
            }
        }, ac.INSTANCE) : bjVar;
    }

    public static void b(bj bjVar) {
        try {
            ck.a(bjVar);
        } catch (ExecutionException e) {
            throw new RuntimeException("Exception loading native code!", e);
        }
    }

    @Deprecated
    public static void c() {
        b(a(null));
    }

    public static native boolean nativeInitClass();

    static native void nativeRegisterExceptionClass(Class<? extends Throwable> cls);

    private static void onNotInitialized(Object obj) {
        throw new NullPointerException("Tried to call native code on object of type " + String.valueOf(obj.getClass()) + ", whose native object has not been initialized or was already finalized.");
    }

    private static void onRegistrationError(Class<?> cls) {
        throw new NoSuchMethodError(com.google.android.libraries.navigation.internal.b.b.e(cls, "Error registering native methods for class ", ". Check the logcat output for errors from dalvikvm."));
    }
}
