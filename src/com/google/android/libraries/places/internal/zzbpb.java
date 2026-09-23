package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbpb {
    public static final /* synthetic */ int zza = 0;
    private static final zzboz zzb;

    static {
        Object obj;
        Class<?> cls;
        zzboz zzbozVar;
        try {
            cls = Class.forName("io.perfmark.impl.SecretPerfMarkImpl$PerfMarkImpl");
            obj = null;
        } catch (Throwable th) {
            obj = th;
            cls = null;
        }
        if (cls != null) {
            try {
                zzbozVar = (zzboz) cls.asSubclass(zzboz.class).getConstructor(zzbpc.class).newInstance(zzboz.zza);
            } catch (Throwable th2) {
                obj = th2;
                zzbozVar = null;
            }
        } else {
            zzbozVar = null;
        }
        if (zzbozVar != null) {
            zzb = zzbozVar;
        } else {
            zzb = new zzboz(zzboz.zza);
        }
        if (obj != null) {
            try {
                if (Boolean.getBoolean("io.perfmark.PerfMark.debug")) {
                    Class<?> cls2 = Class.forName("java.util.logging.Logger");
                    Object objInvoke = cls2.getMethod("getLogger", String.class).invoke(null, zzbpb.class.getName());
                    Class<?> cls3 = Class.forName("java.util.logging.Level");
                    cls2.getMethod("log", cls3, String.class, Throwable.class).invoke(objInvoke, cls3.getField("FINE").get(null), "Error during PerfMark.<clinit>", obj);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private zzbpb() {
    }

    public static zzbpa zza() {
        return zzboz.zzb;
    }

    public static zzbpc zzb(String str) {
        return zzboz.zza;
    }

    public static zzbpc zzc(String str, long j) {
        return zzboz.zza;
    }
}
