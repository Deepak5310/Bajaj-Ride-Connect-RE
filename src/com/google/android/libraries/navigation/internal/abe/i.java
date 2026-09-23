package com.google.android.libraries.navigation.internal.abe;

import android.content.Context;
import android.os.StrictMode;
import com.google.android.libraries.navigation.internal.abf.p;
import com.google.android.libraries.navigation.internal.abf.w;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i {
    static final String a = "_m_t";
    private static final String b = "i";
    private final Context c;

    public i(Context context) {
        this.c = context;
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
                    } else {
                        p.f(b, 4);
                    }
                } catch (EOFException unused) {
                    p.f(b, 4);
                }
            } finally {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    if (p.f(b, 5)) {
                        e.getMessage();
                    }
                }
            }
        } catch (IOException e2) {
            if (p.f(b, 5)) {
                e2.getMessage();
            }
        }
        return aVar;
    }

    final synchronized a a(String str) {
        a aVarD;
        StrictMode.ThreadPolicy threadPolicyA = w.a.a();
        try {
            aVarD = d(this.c.openFileInput(a), str);
        } catch (FileNotFoundException unused) {
            aVarD = null;
        } finally {
            w.a.d(threadPolicyA);
        }
        return aVarD;
    }

    final synchronized void b() {
        StrictMode.ThreadPolicy threadPolicyC = w.a.c();
        try {
            if (this.c.deleteFile(a)) {
                p.f(b, 4);
            } else {
                p.f(b, 6);
            }
            w.a.d(threadPolicyC);
        } catch (Throwable th) {
            w.a.d(threadPolicyC);
            throw th;
        }
    }

    final synchronized void c(String str, String str2, long j) {
        StrictMode.ThreadPolicy threadPolicyC = w.a.c();
        try {
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(this.c.openFileOutput(a, 0));
                try {
                    try {
                        dataOutputStream.writeLong(j);
                        dataOutputStream.writeUTF(str2);
                        dataOutputStream.writeUTF(str);
                        try {
                            dataOutputStream.close();
                        } catch (IOException e) {
                            e = e;
                            if (p.f(b, 5)) {
                                e.getMessage();
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException e2) {
                            if (p.f(b, 5)) {
                                e2.getMessage();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    if (p.f(b, 5)) {
                        e3.getMessage();
                    }
                    try {
                        dataOutputStream.close();
                    } catch (IOException e4) {
                        e = e4;
                        if (p.f(b, 5)) {
                            e.getMessage();
                        }
                    }
                }
                p.f(b, 4);
            } catch (Throwable th2) {
                w.a.d(threadPolicyC);
                throw th2;
            }
        } catch (FileNotFoundException e5) {
            if (p.f(b, 5)) {
                e5.getMessage();
            }
        }
        w.a.d(threadPolicyC);
    }
}
