package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzafv extends zzanr implements zzapa {
    private static final zzafv zzb;
    private static volatile zzapg zze;
    private int zzf;
    private int zzg;
    private boolean zzi;
    private double zzj;
    private int zzk;
    private boolean zzm;
    private zzafg zzn;
    private String zzh = "";
    private zzanw zzl = zzap();

    static {
        zzafv zzafvVar = new zzafv();
        zzb = zzafvVar;
        zzanr.zzaA(zzafv.class, zzafvVar);
    }

    private zzafv() {
    }

    public static zzaft zza() {
        return (zzaft) zzb.zzam();
    }

    static /* synthetic */ void zzd(zzafv zzafvVar, String str) {
        zzafvVar.zzf |= 2;
        zzafvVar.zzh = str;
    }

    static /* synthetic */ void zze(zzafv zzafvVar, boolean z) {
        zzafvVar.zzf |= 4;
        zzafvVar.zzi = z;
    }

    static /* synthetic */ void zzf(zzafv zzafvVar, double d) {
        zzafvVar.zzf |= 8;
        zzafvVar.zzj = d;
    }

    static /* synthetic */ void zzg(zzafv zzafvVar, int i) {
        zzafvVar.zzf |= 16;
        zzafvVar.zzk = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    static /* synthetic */ void zzh(zzafv zzafvVar, Iterable iterable) {
        zzanw zzanwVar = zzafvVar.zzl;
        if (!zzanwVar.zzc()) {
            zzafvVar.zzl = zzanr.zzaq(zzanwVar);
        }
        List list = zzafvVar.zzl;
        byte[] bArr = zzaoa.zzd;
        if (list instanceof ArrayList) {
            ((ArrayList) list).ensureCapacity(list.size() + iterable.size());
        }
        int size = list.size();
        for (Object obj : iterable) {
            if (obj == null) {
                String str = "Element at index " + (list.size() - size) + " is null.";
                int size2 = list.size();
                while (true) {
                    size2--;
                    if (size2 < size) {
                        throw new NullPointerException(str);
                    }
                    list.remove(size2);
                }
            } else {
                list.add(obj);
            }
        }
    }

    static /* synthetic */ void zzi(zzafv zzafvVar, boolean z) {
        zzafvVar.zzf |= 32;
        zzafvVar.zzm = z;
    }

    static /* synthetic */ void zzj(zzafv zzafvVar, zzafg zzafgVar) {
        zzafgVar.getClass();
        zzafvVar.zzn = zzafgVar;
        zzafvVar.zzf |= 64;
    }

    static /* synthetic */ void zzk(zzafv zzafvVar, int i) {
        zzafvVar.zzg = i - 1;
        zzafvVar.zzf |= 1;
    }

    @Override // com.google.android.libraries.places.internal.zzanr
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzax(zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004က\u0003\u0005င\u0004\u0006'\u0007ဇ\u0005\bဉ\u0006", new Object[]{"zzf", "zzg", zzafu.zza, "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn"});
        }
        if (i2 == 3) {
            return new zzafv();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzaft(zzabnVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzapg zzannVar = zze;
        if (zzannVar == null) {
            synchronized (zzafv.class) {
                zzannVar = zze;
                if (zzannVar == null) {
                    zzannVar = new zzann(zzb);
                    zze = zzannVar;
                }
            }
        }
        return zzannVar;
    }
}
