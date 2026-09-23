package com.ammarahmed.mmkv;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class Storage {
    public static void writeValues(Context context, String str, byte[] bArr) throws IOException {
        FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(str, 0);
        fileOutputStreamOpenFileOutput.write(bArr);
        fileOutputStreamOpenFileOutput.close();
    }

    public static byte[] readValues(Context context, String str) throws IOException {
        FileInputStream fileInputStreamOpenFileInput = context.openFileInput(str);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        byte[] bArr = new byte[1024];
        for (int i = fileInputStreamOpenFileInput.read(bArr); i != -1; i = fileInputStreamOpenFileInput.read(bArr)) {
            byteArrayOutputStream.write(bArr, 0, i);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static boolean exists(Context context, String str) throws IOException {
        File fileStreamPath = context.getFileStreamPath(str);
        return fileStreamPath != null && fileStreamPath.exists();
    }

    public static void resetValues(Context context, String[] strArr) {
        for (String str : strArr) {
            context.deleteFile(str);
        }
    }
}
