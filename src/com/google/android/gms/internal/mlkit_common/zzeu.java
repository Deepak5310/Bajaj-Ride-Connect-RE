package com.google.android.gms.internal.mlkit_common;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzeu implements ObjectEncoder {
    static final zzeu zza = new zzeu();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;
    private static final FieldDescriptor zzh;
    private static final FieldDescriptor zzi;
    private static final FieldDescriptor zzj;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("name");
        zzbe zzbeVar = new zzbe();
        zzbeVar.zza(1);
        zzb = builder.withProperty(zzbeVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("version");
        zzbe zzbeVar2 = new zzbe();
        zzbeVar2.zza(2);
        zzc = builder2.withProperty(zzbeVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("source");
        zzbe zzbeVar3 = new zzbe();
        zzbeVar3.zza(3);
        zzd = builder3.withProperty(zzbeVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder(ReactNativeBlobUtilConst.DATA_ENCODE_URI);
        zzbe zzbeVar4 = new zzbe();
        zzbeVar4.zza(4);
        zze = builder4.withProperty(zzbeVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("hash");
        zzbe zzbeVar5 = new zzbe();
        zzbeVar5.zza(5);
        zzf = builder5.withProperty(zzbeVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("modelType");
        zzbe zzbeVar6 = new zzbe();
        zzbeVar6.zza(6);
        zzg = builder6.withProperty(zzbeVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("size");
        zzbe zzbeVar7 = new zzbe();
        zzbeVar7.zza(7);
        zzh = builder7.withProperty(zzbeVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("hasLabelMap");
        zzbe zzbeVar8 = new zzbe();
        zzbeVar8.zza(8);
        zzi = builder8.withProperty(zzbeVar8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("isManifestModel");
        zzbe zzbeVar9 = new zzbe();
        zzbeVar9.zza(9);
        zzj = builder9.withProperty(zzbeVar9.zzb()).build();
    }

    private zzeu() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zziq zziqVar = (zziq) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zziqVar.zzd());
        objectEncoderContext2.add(zzc, (Object) null);
        objectEncoderContext2.add(zzd, zziqVar.zzb());
        objectEncoderContext2.add(zze, (Object) null);
        objectEncoderContext2.add(zzf, zziqVar.zzc());
        objectEncoderContext2.add(zzg, zziqVar.zza());
        objectEncoderContext2.add(zzh, (Object) null);
        objectEncoderContext2.add(zzi, (Object) null);
        objectEncoderContext2.add(zzj, (Object) null);
    }
}
