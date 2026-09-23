package com.google.mlkit.common.sdkinternal.model;

import com.facebook.hermes.intl.Constants;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelType;
import io.reactivex.annotations.SchedulerSupport;
import java.io.File;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes6.dex */
public class ModelFileHelper {
    public static final int INVALID_INDEX = -1;
    private final MlKitContext zze;
    private static final GmsLogger zzd = new GmsLogger("ModelFileHelper", "");
    public static final String zza = String.format("com.google.mlkit.%s.models", "translate");
    public static final String zzb = String.format("com.google.mlkit.%s.models", SchedulerSupport.CUSTOM);
    static final String zzc = String.format("com.google.mlkit.%s.models", Constants.SENSITIVITY_BASE);

    public ModelFileHelper(MlKitContext mlKitContext) {
        this.zze = mlKitContext;
    }

    private final File zzc(String str, ModelType modelType, boolean z) throws MlKitException {
        File modelDirUnsafe = getModelDirUnsafe(str, modelType, z);
        if (!modelDirUnsafe.exists()) {
            GmsLogger gmsLogger = zzd;
            String strValueOf = String.valueOf(modelDirUnsafe.getAbsolutePath());
            gmsLogger.d("ModelFileHelper", strValueOf.length() != 0 ? "model folder does not exist, creating one: ".concat(strValueOf) : new String("model folder does not exist, creating one: "));
            if (!modelDirUnsafe.mkdirs()) {
                String strValueOf2 = String.valueOf(modelDirUnsafe);
                String.valueOf(strValueOf2).length();
                throw new MlKitException("Failed to create model folder: ".concat(String.valueOf(strValueOf2)), 13);
            }
        } else if (!modelDirUnsafe.isDirectory()) {
            String strValueOf3 = String.valueOf(modelDirUnsafe);
            String.valueOf(strValueOf3).length();
            throw new MlKitException("Can not create model folder, since an existing file has the same name: ".concat(String.valueOf(strValueOf3)), 6);
        }
        return modelDirUnsafe;
    }

    public synchronized void deleteAllModels(ModelType modelType, String str) {
        deleteRecursively(getModelDirUnsafe(str, modelType, false));
        deleteRecursively(getModelDirUnsafe(str, modelType, true));
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002c  */
    /* JADX WARN: Code duplicated, block: B:19:0x0032 A[RETURN] */
    public boolean deleteRecursively(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            boolean z = true;
            for (File file2 : (File[]) Preconditions.checkNotNull(file.listFiles())) {
                z = z && deleteRecursively(file2);
            }
            if (z) {
                if (file.delete()) {
                    return true;
                }
            }
        } else if (file.delete()) {
            return true;
        }
        return false;
    }

    public void deleteTempFilesInPrivateFolder(String str, ModelType modelType) throws MlKitException {
        File fileZzc = zzc(str, modelType, true);
        if (deleteRecursively(fileZzc)) {
            return;
        }
        GmsLogger gmsLogger = zzd;
        String strValueOf = String.valueOf(fileZzc != null ? fileZzc.getAbsolutePath() : null);
        gmsLogger.e("ModelFileHelper", strValueOf.length() != 0 ? "Failed to delete the temp labels file directory: ".concat(strValueOf) : new String("Failed to delete the temp labels file directory: "));
    }

    public int getLatestCachedModelVersion(File file) {
        File[] fileArrListFiles = file.listFiles();
        int iMax = -1;
        if (fileArrListFiles != null && (fileArrListFiles.length) != 0) {
            for (File file2 : fileArrListFiles) {
                try {
                    iMax = Math.max(iMax, Integer.parseInt(file2.getName()));
                } catch (NumberFormatException unused) {
                    GmsLogger gmsLogger = zzd;
                    String strValueOf = String.valueOf(file2.getName());
                    gmsLogger.d("ModelFileHelper", strValueOf.length() != 0 ? "Contains non-integer file name ".concat(strValueOf) : new String("Contains non-integer file name "));
                }
            }
        }
        return iMax;
    }

    public File getModelDir(String str, ModelType modelType) throws MlKitException {
        return zzc(str, modelType, false);
    }

    public File getModelDirUnsafe(String str, ModelType modelType, boolean z) {
        String str2;
        ModelType modelType2 = ModelType.UNKNOWN;
        int iOrdinal = modelType.ordinal();
        if (iOrdinal == 1) {
            str2 = zzc;
        } else if (iOrdinal == 2) {
            str2 = zza;
        } else {
            if (iOrdinal != 4) {
                String strName = modelType.name();
                StringBuilder sb = new StringBuilder(String.valueOf(strName).length() + 69);
                sb.append("Unknown model type ");
                sb.append(strName);
                sb.append(". Cannot find a dir to store the downloaded model.");
                throw new IllegalArgumentException(sb.toString());
            }
            str2 = zzb;
        }
        File file = new File(this.zze.getApplicationContext().getNoBackupFilesDir(), str2);
        if (z) {
            file = new File(file, "temp");
        }
        return new File(file, str);
    }

    public File getModelTempDir(String str, ModelType modelType) throws MlKitException {
        return zzc(str, modelType, true);
    }

    public File getTempFileInPrivateFolder(String str, ModelType modelType, String str2) throws MlKitException {
        File fileZzc = zzc(str, modelType, true);
        if (fileZzc.exists() && fileZzc.isFile() && !fileZzc.delete()) {
            String strValueOf = String.valueOf(fileZzc.getAbsolutePath());
            throw new MlKitException(strValueOf.length() != 0 ? "Failed to delete the temp labels file: ".concat(strValueOf) : new String("Failed to delete the temp labels file: "), 13);
        }
        if (!fileZzc.exists()) {
            GmsLogger gmsLogger = zzd;
            String strValueOf2 = String.valueOf(fileZzc.getAbsolutePath());
            gmsLogger.d("ModelFileHelper", strValueOf2.length() != 0 ? "Temp labels folder does not exist, creating one: ".concat(strValueOf2) : new String("Temp labels folder does not exist, creating one: "));
            if (!fileZzc.mkdirs()) {
                throw new MlKitException("Failed to create a directory to hold the AutoML model's labels file.", 13);
            }
        }
        return new File(fileZzc, str2);
    }

    public boolean modelExistsLocally(String str, ModelType modelType) throws MlKitException {
        String strZzb;
        if (modelType == ModelType.UNKNOWN || (strZzb = zzb(str, modelType)) == null) {
            return false;
        }
        File file = new File(strZzb);
        if (!file.exists()) {
            return false;
        }
        File file2 = new File(file, com.google.mlkit.common.sdkinternal.Constants.MODEL_FILE_NAME);
        GmsLogger gmsLogger = zzd;
        String strValueOf = String.valueOf(file2.getAbsolutePath());
        gmsLogger.i("ModelFileHelper", strValueOf.length() != 0 ? "Model file path: ".concat(strValueOf) : new String("Model file path: "));
        return file2.exists();
    }

    public final File zza(String str, ModelType modelType) throws MlKitException {
        return zzc(str, modelType, true);
    }

    public final String zzb(String str, ModelType modelType) throws MlKitException {
        File modelDir = getModelDir(str, modelType);
        int latestCachedModelVersion = getLatestCachedModelVersion(modelDir);
        if (latestCachedModelVersion == -1) {
            return null;
        }
        String absolutePath = modelDir.getAbsolutePath();
        StringBuilder sb = new StringBuilder(String.valueOf(absolutePath).length() + 12);
        sb.append(absolutePath);
        sb.append(RemoteSettings.FORWARD_SLASH_STRING);
        sb.append(latestCachedModelVersion);
        return sb.toString();
    }
}
