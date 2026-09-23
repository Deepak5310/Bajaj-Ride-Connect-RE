package com.google.android.libraries.navigation.internal.fx;

import android.content.Context;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k {
    private final Context a;

    public k(Context context) {
        this.a = context;
    }

    private static a d(FileInputStream fileInputStream, String str) {
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        a aVar = null;
        try {
            try {
                long j = dataInputStream.readLong();
                String utf = dataInputStream.readUTF();
                try {
                    if (str.equals(dataInputStream.readUTF())) {
                        aVar = new a(utf, j);
                    }
                } catch (EOFException unused) {
                }
            } finally {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.getMessage();
                }
            }
        } catch (IOException e2) {
            e2.getMessage();
        }
        return aVar;
    }

    final synchronized a a(String str) {
        try {
        } catch (FileNotFoundException unused) {
            return null;
        }
        return d(this.a.openFileInput("_m_t"), str);
    }

    final synchronized void b() {
        this.a.deleteFile("_m_t");
    }

    final synchronized void c(String str, String str2, long j) {
        try {
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(this.a.openFileOutput("_m_t", 0));
                try {
                    try {
                        dataOutputStream.writeLong(j);
                        dataOutputStream.writeUTF(str2);
                        dataOutputStream.writeUTF(str);
                    } catch (IOException e) {
                        e.getMessage();
                    }
                    try {
                        dataOutputStream.close();
                    } catch (IOException e2) {
                        e2.getMessage();
                    }
                } catch (Throwable th) {
                    try {
                        dataOutputStream.close();
                    } catch (IOException e3) {
                        e3.getMessage();
                    }
                    throw th;
                }
            } catch (FileNotFoundException e4) {
                e4.getMessage();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
