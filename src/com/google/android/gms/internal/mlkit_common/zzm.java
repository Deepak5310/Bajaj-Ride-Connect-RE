package com.google.android.gms.internal.mlkit_common;

import android.util.Log;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzm {
    private static final Method zza;
    private static final Method zzb;
    private static final Method zzc;
    private static final Field zzd;
    private static final Field zze;
    private static final Field zzf;
    private static final Object zzg;
    private static final Throwable zzh;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.reflect.Field] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.reflect.Field] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.reflect.Field] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.reflect.Field] */
    static {
        Throwable th;
        Object obj;
        Field field;
        Method declaredMethod;
        Method declaredMethod2;
        Method declaredMethod3;
        ?? field2;
        ?? field3;
        try {
            Class<?> cls = Class.forName("libcore.io.Libcore");
            Class<?> cls2 = Class.forName("libcore.io.StructStat");
            Class<?> cls3 = Class.forName("libcore.io.OsConstants");
            Class<?> cls4 = Class.forName("libcore.io.ForwardingOs");
            declaredMethod = cls3.getDeclaredMethod("S_ISLNK", Integer.TYPE);
            try {
                declaredMethod.setAccessible(true);
                declaredMethod3 = cls4.getDeclaredMethod("lstat", String.class);
                try {
                    declaredMethod2 = cls4.getDeclaredMethod("fstat", FileDescriptor.class);
                    try {
                        Field declaredField = cls.getDeclaredField("os");
                        declaredField.setAccessible(true);
                        obj = declaredField.get(cls);
                        try {
                            field2 = cls2.getField("st_dev");
                            try {
                                field3 = cls2.getField("st_ino");
                                try {
                                    field = cls2.getField("st_mode");
                                    try {
                                        field2.setAccessible(true);
                                        field3.setAccessible(true);
                                        field.setAccessible(true);
                                        zza = declaredMethod;
                                        zzb = declaredMethod3;
                                        zzc = declaredMethod2;
                                        zzd = field2;
                                        zze = field3;
                                        zzf = field;
                                        zzg = obj;
                                        zzh = null;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        try {
                                            Log.d("StructStatHelper", "Reflection failed", th);
                                            zza = declaredMethod;
                                            zzb = declaredMethod3;
                                            zzc = declaredMethod2;
                                            zzd = field2;
                                            zze = field3;
                                            zzf = field;
                                            zzg = obj;
                                            zzh = th;
                                        } catch (Throwable th3) {
                                            zza = declaredMethod;
                                            zzb = declaredMethod3;
                                            zzc = declaredMethod2;
                                            zzd = field2;
                                            zze = field3;
                                            zzf = field;
                                            zzg = obj;
                                            zzh = null;
                                            throw th3;
                                        }
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    field = null;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                field = null;
                                field3 = 0;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            field = null;
                            field2 = field;
                            field3 = field2;
                            Log.d("StructStatHelper", "Reflection failed", th);
                            zza = declaredMethod;
                            zzb = declaredMethod3;
                            zzc = declaredMethod2;
                            zzd = field2;
                            zze = field3;
                            zzf = field;
                            zzg = obj;
                            zzh = th;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        obj = null;
                        field = null;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    obj = null;
                    field = null;
                    declaredMethod2 = null;
                    field2 = 0;
                }
            } catch (Throwable th9) {
                th = th9;
                obj = null;
                field = null;
                declaredMethod2 = null;
                declaredMethod3 = declaredMethod2;
                field2 = declaredMethod3;
                field3 = field2;
                Log.d("StructStatHelper", "Reflection failed", th);
                zza = declaredMethod;
                zzb = declaredMethod3;
                zzc = declaredMethod2;
                zzd = field2;
                zze = field3;
                zzf = field;
                zzg = obj;
                zzh = th;
            }
        } catch (Throwable th10) {
            th = th10;
            obj = null;
            field = null;
            declaredMethod = null;
            declaredMethod2 = null;
        }
    }

    static zzo zza(final FileDescriptor fileDescriptor) throws IOException {
        return (zzo) zzf(new Callable() { // from class: com.google.android.gms.internal.mlkit_common.zzk
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzm.zze(zzm.zzc.invoke(zzm.zzg, fileDescriptor));
            }
        });
    }

    static zzo zzd(final String str) throws IOException {
        return (zzo) zzf(new Callable() { // from class: com.google.android.gms.internal.mlkit_common.zzl
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzm.zze(zzm.zzb.invoke(zzm.zzg, str));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzo zze(Object obj) throws Exception {
        long jLongValue = ((Long) zzd.get(obj)).longValue();
        long jLongValue2 = ((Long) zze.get(obj)).longValue();
        Integer num = (Integer) zzf.get(obj);
        num.intValue();
        return new zzo(jLongValue, jLongValue2, ((Boolean) zza.invoke(null, num)).booleanValue());
    }

    private static Object zzf(Callable callable) throws IOException {
        try {
            Throwable th = zzh;
            if (th == null) {
                return callable.call();
            }
            throw new IOException(th);
        } catch (Throwable th2) {
            throw new IOException(th2);
        }
    }
}
