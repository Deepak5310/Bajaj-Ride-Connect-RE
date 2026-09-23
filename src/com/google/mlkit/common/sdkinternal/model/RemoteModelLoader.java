package com.google.mlkit.common.sdkinternal.model;

import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzll;
import com.google.android.gms.internal.mlkit_common.zzlo;
import com.google.android.gms.internal.mlkit_common.zzlw;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.io.File;
import java.nio.MappedByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes6.dex */
public class RemoteModelLoader {
    private static final GmsLogger zza = new GmsLogger("RemoteModelLoader", "");
    private static final Map zzb = new HashMap();
    private final MlKitContext zzc;
    private final RemoteModel zzd;
    private final RemoteModelDownloadManager zze;
    private final RemoteModelFileManager zzf;
    private final RemoteModelLoaderHelper zzg;
    private final zzll zzh;
    private boolean zzi;

    private RemoteModelLoader(MlKitContext mlKitContext, RemoteModel remoteModel, ModelValidator modelValidator, RemoteModelLoaderHelper remoteModelLoaderHelper, RemoteModelFileMover remoteModelFileMover) {
        RemoteModelFileManager remoteModelFileManager = new RemoteModelFileManager(mlKitContext, remoteModel, modelValidator, new ModelFileHelper(mlKitContext), remoteModelFileMover);
        this.zzf = remoteModelFileManager;
        this.zzi = true;
        this.zze = RemoteModelDownloadManager.getInstance(mlKitContext, remoteModel, new ModelFileHelper(mlKitContext), remoteModelFileManager, (ModelInfoRetrieverInterop) mlKitContext.get(ModelInfoRetrieverInterop.class));
        this.zzg = remoteModelLoaderHelper;
        this.zzc = mlKitContext;
        this.zzd = remoteModel;
        this.zzh = zzlw.zzb("common");
    }

    public static synchronized RemoteModelLoader getInstance(MlKitContext mlKitContext, RemoteModel remoteModel, ModelValidator modelValidator, RemoteModelLoaderHelper remoteModelLoaderHelper, RemoteModelFileMover remoteModelFileMover) {
        String uniqueModelNameForPersist;
        Map map;
        uniqueModelNameForPersist = remoteModel.getUniqueModelNameForPersist();
        map = zzb;
        if (!map.containsKey(uniqueModelNameForPersist)) {
            map.put(uniqueModelNameForPersist, new RemoteModelLoader(mlKitContext, remoteModel, modelValidator, remoteModelLoaderHelper, remoteModelFileMover));
        }
        return (RemoteModelLoader) map.get(uniqueModelNameForPersist);
    }

    private final MappedByteBuffer zza(String str) throws MlKitException {
        return this.zzg.loadModelAtPath(str);
    }

    private final MappedByteBuffer zzb(File file) throws MlKitException {
        try {
            return zza(file.getAbsolutePath());
        } catch (Exception e) {
            this.zzf.zzc(file);
            throw new MlKitException("Failed to load newly downloaded model.", 14, e);
        }
    }

    public RemoteModel getRemoteModel() {
        return this.zzd;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00c1 A[Catch: all -> 0x0102, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0020, B:9:0x0028, B:30:0x00c1, B:32:0x00d0, B:34:0x00d8, B:37:0x00de, B:38:0x00fc, B:39:0x00fd, B:10:0x002f, B:12:0x0046, B:15:0x004f, B:17:0x0063, B:19:0x006d, B:21:0x0079, B:23:0x0081, B:18:0x0068, B:24:0x0093, B:26:0x009b, B:27:0x00b2), top: B:46:0x0001, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00d0 A[Catch: all -> 0x0102, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0020, B:9:0x0028, B:30:0x00c1, B:32:0x00d0, B:34:0x00d8, B:37:0x00de, B:38:0x00fc, B:39:0x00fd, B:10:0x002f, B:12:0x0046, B:15:0x004f, B:17:0x0063, B:19:0x006d, B:21:0x0079, B:23:0x0081, B:18:0x0068, B:24:0x0093, B:26:0x009b, B:27:0x00b2), top: B:46:0x0001, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00fd A[Catch: all -> 0x0102, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0020, B:9:0x0028, B:30:0x00c1, B:32:0x00d0, B:34:0x00d8, B:37:0x00de, B:38:0x00fc, B:39:0x00fd, B:10:0x002f, B:12:0x0046, B:15:0x004f, B:17:0x0063, B:19:0x006d, B:21:0x0079, B:23:0x0081, B:18:0x0068, B:24:0x0093, B:26:0x009b, B:27:0x00b2), top: B:46:0x0001, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public synchronized MappedByteBuffer load() throws MlKitException {
        MappedByteBuffer mappedByteBufferZza;
        MappedByteBuffer mappedByteBufferZzb;
        String strZzb;
        GmsLogger gmsLogger = zza;
        gmsLogger.d("RemoteModelLoader", "Try to load newly downloaded model file.");
        boolean z = this.zzi;
        Long downloadingId = this.zze.getDownloadingId();
        String downloadingModelHash = this.zze.getDownloadingModelHash();
        mappedByteBufferZza = null;
        if (downloadingId == null || downloadingModelHash == null) {
            gmsLogger.d("RemoteModelLoader", "No new model is downloading.");
            this.zze.removeOrCancelDownload();
        } else {
            Integer downloadingModelStatusCode = this.zze.getDownloadingModelStatusCode();
            if (downloadingModelStatusCode == null) {
                this.zze.removeOrCancelDownload();
            } else {
                gmsLogger.d("RemoteModelLoader", "Download Status code: ".concat(downloadingModelStatusCode.toString()));
                if (downloadingModelStatusCode.intValue() == 8) {
                    File fileZzi = this.zze.zzi(downloadingModelHash);
                    if (fileZzi != null) {
                        mappedByteBufferZzb = zzb(fileZzi);
                        String strValueOf = String.valueOf(fileZzi.getParent());
                        gmsLogger.d("RemoteModelLoader", strValueOf.length() != 0 ? "Moved the downloaded model to private folder successfully: ".concat(strValueOf) : new String("Moved the downloaded model to private folder successfully: "));
                        this.zze.updateLatestModelHashAndType(downloadingModelHash);
                        if (z && this.zzf.zzd(fileZzi)) {
                            gmsLogger.d("RemoteModelLoader", "All old models are deleted.");
                            mappedByteBufferZzb = zzb(this.zzf.zza(fileZzi));
                        }
                    }
                    if (mappedByteBufferZzb == null) {
                        gmsLogger.d("RemoteModelLoader", "Loading existing model file.");
                        strZzb = this.zzf.zzb();
                        if (strZzb == null) {
                            gmsLogger.d("RemoteModelLoader", "No existing model file");
                        } else {
                            try {
                                mappedByteBufferZza = zza(strZzb);
                            } catch (Exception e) {
                                this.zzf.zzc(new File(strZzb));
                                SharedPrefManager.getInstance(this.zzc).clearLatestModelHash(this.zzd);
                                throw new MlKitException("Failed to load an already downloaded model.", 14, e);
                            }
                        }
                    } else {
                        this.zzi = false;
                        mappedByteBufferZza = mappedByteBufferZzb;
                    }
                } else if (downloadingModelStatusCode.intValue() == 16) {
                    this.zzh.zzd(zzlo.zzg(), this.zzd, false, this.zze.getFailureReason(downloadingId));
                    this.zze.removeOrCancelDownload();
                }
            }
        }
        mappedByteBufferZzb = null;
        if (mappedByteBufferZzb == null) {
            gmsLogger.d("RemoteModelLoader", "Loading existing model file.");
            strZzb = this.zzf.zzb();
            if (strZzb == null) {
                gmsLogger.d("RemoteModelLoader", "No existing model file");
            } else {
                mappedByteBufferZza = zza(strZzb);
            }
        } else {
            this.zzi = false;
            mappedByteBufferZza = mappedByteBufferZzb;
        }
        return mappedByteBufferZza;
    }
}
