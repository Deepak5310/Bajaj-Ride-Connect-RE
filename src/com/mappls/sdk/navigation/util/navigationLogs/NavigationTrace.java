package com.mappls.sdk.navigation.util.navigationLogs;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class NavigationTrace {
    private static File file = null;
    private static boolean init = false;
    private static final Object mutex = new Object();

    public static void init(Context context) {
        synchronized (mutex) {
            if (!init) {
                file = new File(context.getExternalFilesDir(null), "mappls_navigation_log.txt");
                init = true;
            }
        }
    }

    public static void writeLine(String str) {
        OutputStreamWriter outputStreamWriter;
        synchronized (mutex) {
            if (init) {
                try {
                    if ("mounted".equals(Environment.getExternalStorageState())) {
                        try {
                            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file, true), Charset.defaultCharset());
                            try {
                                outputStreamWriter.write(",\n" + str);
                                outputStreamWriter.close();
                            } catch (Throwable th) {
                                th = th;
                                if (outputStreamWriter != null) {
                                    outputStreamWriter.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            outputStreamWriter = null;
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void writeLine(String str, Object... objArr) {
        OutputStreamWriter outputStreamWriter;
        synchronized (mutex) {
            if (init) {
                try {
                    if ("mounted".equals(Environment.getExternalStorageState())) {
                        try {
                            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file, true), Charset.defaultCharset());
                            try {
                                outputStreamWriter.write(String.format("[" + new Date().toLocaleString() + "] " + str + "\r\n", objArr));
                                outputStreamWriter.close();
                            } catch (Throwable th) {
                                th = th;
                                if (outputStreamWriter != null) {
                                    outputStreamWriter.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            outputStreamWriter = null;
                        }
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    public static void writeLineNavigation(String str) {
        OutputStreamWriter outputStreamWriter;
        synchronized (mutex) {
            if (init) {
                try {
                    if ("mounted".equals(Environment.getExternalStorageState())) {
                        try {
                            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file, true), Charset.defaultCharset());
                            try {
                                outputStreamWriter.write("\n[" + new Date().toLocaleString() + " ;;;; " + System.currentTimeMillis() + "] " + str);
                                outputStreamWriter.close();
                            } catch (Throwable th) {
                                th = th;
                                if (outputStreamWriter != null) {
                                    outputStreamWriter.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            outputStreamWriter = null;
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }
}
