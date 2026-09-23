package org.chromium.net;

import android.os.ParcelFileDescriptor;
import java.io.File;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class UploadDataProviders {
    public static UploadDataProvider create(File file) {
        return org.chromium.net.apihelpers.UploadDataProviders.create(file);
    }

    public static UploadDataProvider create(ParcelFileDescriptor parcelFileDescriptor) {
        return org.chromium.net.apihelpers.UploadDataProviders.create(parcelFileDescriptor);
    }

    public static UploadDataProvider create(ByteBuffer byteBuffer) {
        return org.chromium.net.apihelpers.UploadDataProviders.create(byteBuffer);
    }

    public static UploadDataProvider create(byte[] bArr, int i, int i2) {
        return org.chromium.net.apihelpers.UploadDataProviders.create(bArr, i, i2);
    }

    public static UploadDataProvider create(byte[] bArr) {
        return org.chromium.net.apihelpers.UploadDataProviders.create(bArr);
    }

    private UploadDataProviders() {
    }
}
