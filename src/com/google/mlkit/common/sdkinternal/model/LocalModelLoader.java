package com.google.mlkit.common.sdkinternal.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzh;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.LocalModel;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes6.dex */
public class LocalModelLoader {
    private MappedByteBuffer zza;
    private final Context zzb;
    private final LocalModel zzc;

    public LocalModelLoader(Context context, LocalModel localModel) {
        this.zzb = context;
        this.zzc = localModel;
    }

    public LocalModel getLocalModel() {
        return this.zzc;
    }

    public MappedByteBuffer load() throws MlKitException {
        Preconditions.checkNotNull(this.zzb, "Context can not be null");
        Preconditions.checkNotNull(this.zzc, "Model source can not be null");
        MappedByteBuffer mappedByteBuffer = this.zza;
        if (mappedByteBuffer != null) {
            return mappedByteBuffer;
        }
        String absoluteFilePath = this.zzc.getAbsoluteFilePath();
        String assetFilePath = this.zzc.getAssetFilePath();
        Uri uri = this.zzc.getUri();
        if (absoluteFilePath != null) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(absoluteFilePath, "r");
                try {
                    FileChannel channel = randomAccessFile.getChannel();
                    try {
                        this.zza = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                        if (channel != null) {
                            channel.close();
                        }
                        randomAccessFile.close();
                        return this.zza;
                    } catch (Throwable th) {
                        if (channel != null) {
                            try {
                                channel.close();
                            } catch (Throwable unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable unused2) {
                    }
                    throw th2;
                }
            } catch (IOException e) {
                String strValueOf = String.valueOf(this.zzc.getAbsoluteFilePath());
                throw new MlKitException(strValueOf.length() != 0 ? "Can not open the local file: ".concat(strValueOf) : new String("Can not open the local file: "), 14, e);
            }
        }
        if (assetFilePath == null) {
            if (uri == null) {
                throw new MlKitException("Can not load the model. One of filePath, assetFilePath or URI must be set for the model.", 14);
            }
            try {
                AssetFileDescriptor assetFileDescriptorZza = zzh.zza(this.zzb, uri, "r");
                try {
                    FileChannel channel2 = assetFileDescriptorZza.createInputStream().getChannel();
                    try {
                        this.zza = channel2.map(FileChannel.MapMode.READ_ONLY, assetFileDescriptorZza.getStartOffset(), assetFileDescriptorZza.getLength());
                        if (channel2 != null) {
                            channel2.close();
                        }
                        if (assetFileDescriptorZza != null) {
                            assetFileDescriptorZza.close();
                        }
                        return this.zza;
                    } catch (Throwable th3) {
                        if (channel2 != null) {
                            try {
                                channel2.close();
                            } catch (Throwable unused3) {
                            }
                        }
                        throw th3;
                    }
                } catch (Throwable th4) {
                    if (assetFileDescriptorZza != null) {
                        try {
                            assetFileDescriptorZza.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    throw th4;
                }
            } catch (IOException e2) {
                throw new MlKitException("Can not load the file from URI: ".concat(uri.toString()), 14, e2);
            }
        }
        try {
            AssetFileDescriptor assetFileDescriptorOpenFd = this.zzb.getAssets().openFd(assetFilePath);
            try {
                FileChannel channel3 = new FileInputStream(assetFileDescriptorOpenFd.getFileDescriptor()).getChannel();
                try {
                    this.zza = channel3.map(FileChannel.MapMode.READ_ONLY, assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getDeclaredLength());
                    if (channel3 != null) {
                        channel3.close();
                    }
                    if (assetFileDescriptorOpenFd != null) {
                        assetFileDescriptorOpenFd.close();
                    }
                    return this.zza;
                } catch (Throwable th5) {
                    if (channel3 != null) {
                        try {
                            channel3.close();
                        } catch (Throwable unused5) {
                        }
                    }
                    throw th5;
                }
            } catch (Throwable th6) {
                if (assetFileDescriptorOpenFd != null) {
                    try {
                        assetFileDescriptorOpenFd.close();
                    } catch (Throwable unused6) {
                    }
                }
                throw th6;
            }
        } catch (IOException e3) {
            StringBuilder sb = new StringBuilder(assetFilePath.length() + 186);
            sb.append("Can not load the file from asset: ");
            sb.append(assetFilePath);
            sb.append(". Please double check your asset file name and ensure it's not compressed. See documentation for details how to use aaptOptions to skip file compression");
            throw new MlKitException(sb.toString(), 14, e3);
        }
    }
}
