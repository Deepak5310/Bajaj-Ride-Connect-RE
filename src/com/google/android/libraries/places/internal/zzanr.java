package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzanm;
import com.google.android.libraries.places.internal.zzanr;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzanr<MessageType extends zzanr<MessageType, BuilderType>, BuilderType extends zzanm<MessageType, BuilderType>> extends zzalw<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    public static final /* synthetic */ int zzd = 0;
    private int zze = -1;
    protected zzaqh zzc = zzaqh.zzc();

    private final int zza(zzapm zzapmVar) {
        return zzapi.zza().zzb(getClass()).zza(this);
    }

    protected static void zzaA(Class cls, zzanr zzanrVar) {
        zzanrVar.zzaz();
        zzb.put(cls, zzanrVar);
    }

    static zzanr zzan(Class cls) {
        Map map = zzb;
        zzanr zzanrVar = (zzanr) map.get(cls);
        if (zzanrVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzanrVar = (zzanr) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzanrVar == null) {
            zzanrVar = (zzanr) ((zzanr) zzaqq.zze(cls)).zzb(6, null, null);
            if (zzanrVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzanrVar);
        }
        return zzanrVar;
    }

    protected static zzanw zzap() {
        return zzans.zzf();
    }

    protected static zzanw zzaq(zzanw zzanwVar) {
        int size = zzanwVar.size();
        return zzanwVar.zzd(size == 0 ? 10 : size + size);
    }

    protected static zzany zzar() {
        return zzaoo.zzf();
    }

    protected static zzanz zzas() {
        return zzapj.zze();
    }

    protected static zzanz zzat(zzanz zzanzVar) {
        int size = zzanzVar.size();
        return zzanzVar.zzd(size == 0 ? 10 : size + size);
    }

    static Object zzaw(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static Object zzax(zzaoz zzaozVar, String str, Object[] objArr) {
        return new zzapk(zzaozVar, str, objArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzapi.zza().zzb(getClass()).zzg(this, (zzanr) obj);
    }

    public final int hashCode() {
        if (zzaD()) {
            return zzak();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iZzak = zzak();
        this.zza = iZzak;
        return iZzak;
    }

    public final String toString() {
        return zzapb.zza(this, super.toString());
    }

    final void zzaB(int i) {
        this.zze = (this.zze & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    @Override // com.google.android.libraries.places.internal.zzaoz
    public final void zzaC(zzamy zzamyVar) throws IOException {
        zzapi.zza().zzb(getClass()).zzj(this, zzamz.zza(zzamyVar));
    }

    final boolean zzaD() {
        return (this.zze & Integer.MIN_VALUE) != 0;
    }

    @Override // com.google.android.libraries.places.internal.zzapa
    public final /* synthetic */ zzaoz zzaE() {
        return (zzanr) zzb(6, null, null);
    }

    @Override // com.google.android.libraries.places.internal.zzapa
    public final boolean zzaF() {
        boolean zBooleanValue = Boolean.TRUE.booleanValue();
        byte bByteValue = ((Byte) zzb(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzh = zzapi.zza().zzb(getClass()).zzh(this);
        if (!zBooleanValue) {
            return zZzh;
        }
        zzb(2, true != zZzh ? null : this, null);
        return zZzh;
    }

    @Override // com.google.android.libraries.places.internal.zzalw
    final int zzag(zzapm zzapmVar) {
        if (zzaD()) {
            int iZza = zzapmVar.zza(this);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZza);
        }
        int i = this.zze & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZza2 = zzapmVar.zza(this);
        if (iZza2 >= 0) {
            this.zze = (this.zze & Integer.MIN_VALUE) | iZza2;
            return iZza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iZza2);
    }

    final int zzak() {
        return zzapi.zza().zzb(getClass()).zzb(this);
    }

    protected final zzanm zzam() {
        return (zzanm) zzb(5, null, null);
    }

    final zzanr zzao() {
        return (zzanr) zzb(4, null, null);
    }

    @Override // com.google.android.libraries.places.internal.zzaoz
    public final /* synthetic */ zzaoy zzau() {
        return (zzanm) zzb(5, null, null);
    }

    @Override // com.google.android.libraries.places.internal.zzaoz
    public final zzapg zzav() {
        return (zzapg) zzb(7, null, null);
    }

    protected final void zzay() {
        zzapi.zza().zzb(getClass()).zzd(this);
        zzaz();
    }

    final void zzaz() {
        this.zze &= Integer.MAX_VALUE;
    }

    protected abstract Object zzb(int i, Object obj, Object obj2);

    @Override // com.google.android.libraries.places.internal.zzaoz
    public final int zzal() {
        int iZza;
        if (zzaD()) {
            iZza = zza(null);
            if (iZza < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + iZza);
            }
        } else {
            iZza = this.zze & Integer.MAX_VALUE;
            if (iZza == Integer.MAX_VALUE) {
                iZza = zza(null);
                if (iZza < 0) {
                    throw new IllegalStateException("serialized size must be non-negative, was " + iZza);
                }
                this.zze = (this.zze & Integer.MIN_VALUE) | iZza;
            }
        }
        return iZza;
    }
}
