package com.rnfs;

import android.os.AsyncTask;
import android.util.Log;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.mappls.sdk.navigation.NavigationConstants;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class Downloader extends AsyncTask<DownloadParams, long[], DownloadResult> {
    private AtomicBoolean mAbort = new AtomicBoolean(false);
    private DownloadParams mParam;
    DownloadResult res;

    protected void onPostExecute(Exception exc) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public DownloadResult doInBackground(DownloadParams... downloadParamsArr) {
        this.mParam = downloadParamsArr[0];
        this.res = new DownloadResult();
        new Thread(new Runnable() { // from class: com.rnfs.Downloader.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Downloader downloader = Downloader.this;
                    downloader.download(downloader.mParam, Downloader.this.res);
                    Downloader.this.mParam.onTaskCompleted.onTaskCompleted(Downloader.this.res);
                } catch (Exception e) {
                    Downloader.this.res.exception = e;
                    Downloader.this.mParam.onTaskCompleted.onTaskCompleted(Downloader.this.res);
                }
            }
        }).start();
        return this.res;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:101:0x022e  */
    /* JADX WARN: Code duplicated, block: B:103:0x0233  */
    /* JADX WARN: Code duplicated, block: B:112:0x0244  */
    /* JADX WARN: Code duplicated, block: B:114:0x0249  */
    /* JADX WARN: Code duplicated, block: B:116:0x024e  */
    /* JADX WARN: Code duplicated, block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x021e  */
    /* JADX WARN: Code duplicated, block: B:99:0x0229  */
    public void download(DownloadParams downloadParams, DownloadResult downloadResult) throws Exception {
        BufferedInputStream bufferedInputStream;
        HttpURLConnection httpURLConnection;
        int i;
        boolean z;
        long j;
        int i2;
        DownloadParams downloadParams2 = downloadParams;
        FileOutputStream fileOutputStream = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(downloadParams2.src.openConnection()));
            try {
                ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = downloadParams2.headers.keySetIterator();
                while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                    String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                    httpURLConnection2.setRequestProperty(strNextKey, downloadParams2.headers.getString(strNextKey));
                }
                httpURLConnection2.setConnectTimeout(downloadParams2.connectionTimeout);
                httpURLConnection2.setReadTimeout(downloadParams2.readTimeout);
                httpURLConnection2.connect();
                int responseCode = httpURLConnection2.getResponseCode();
                long contentLength = getContentLength(httpURLConnection2);
                if (responseCode != 200 && (responseCode == 301 || responseCode == 302 || responseCode == 307 || responseCode == 308)) {
                    String headerField = httpURLConnection2.getHeaderField(HttpHeaders.LOCATION);
                    httpURLConnection2.disconnect();
                    HttpURLConnection httpURLConnection3 = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(headerField).openConnection()));
                    try {
                        httpURLConnection3.setConnectTimeout(NavigationConstants.UI_HANDLER_LOCATION_SERVICE);
                        httpURLConnection3.connect();
                        int responseCode2 = httpURLConnection3.getResponseCode();
                        contentLength = getContentLength(httpURLConnection3);
                        responseCode = responseCode2;
                        httpURLConnection2 = httpURLConnection3;
                        if (responseCode >= 200) {
                            httpURLConnection = httpURLConnection2;
                            i = responseCode;
                            bufferedInputStream = null;
                            downloadResult.statusCode = i;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                                return;
                            }
                            return;
                        }
                        httpURLConnection = httpURLConnection2;
                        i = responseCode;
                        bufferedInputStream = null;
                        downloadResult.statusCode = i;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = null;
                        httpURLConnection = httpURLConnection3;
                    }
                } else {
                    if (responseCode >= 200 || responseCode >= 300) {
                        httpURLConnection = httpURLConnection2;
                        i = responseCode;
                        bufferedInputStream = null;
                    } else {
                        try {
                            Map<String, List<String>> headerFields = httpURLConnection2.getHeaderFields();
                            HashMap map = new HashMap();
                            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                                String key = entry.getKey();
                                String str = entry.getValue().get(0);
                                if (key != null && str != null) {
                                    map.put(key, str);
                                }
                            }
                            if (this.mParam.onDownloadBegin != null) {
                                this.mParam.onDownloadBegin.onDownloadBegin(responseCode, contentLength, map);
                            }
                            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection2.getInputStream(), 8192);
                            try {
                                FileOutputStream fileOutputStream2 = new FileOutputStream(downloadParams2.dest);
                                try {
                                    byte[] bArr = new byte[8192];
                                    boolean z2 = this.mParam.onDownloadProgress != null;
                                    long j2 = 0;
                                    long j3 = 0;
                                    double d = 0.0d;
                                    while (true) {
                                        int i3 = bufferedInputStream2.read(bArr);
                                        if (i3 != -1) {
                                            if (this.mAbort.get()) {
                                                throw new Exception("Download has been aborted");
                                            }
                                            HttpURLConnection httpURLConnection4 = httpURLConnection2;
                                            int i4 = responseCode;
                                            j3 += (long) i3;
                                            try {
                                                if (z2) {
                                                    try {
                                                        if (downloadParams2.progressInterval > 0) {
                                                            try {
                                                                long jCurrentTimeMillis = System.currentTimeMillis();
                                                                long j4 = contentLength;
                                                                if (jCurrentTimeMillis - j2 > downloadParams2.progressInterval) {
                                                                    publishProgress(new long[]{j4, j3});
                                                                    j2 = jCurrentTimeMillis;
                                                                }
                                                                bufferedInputStream = bufferedInputStream2;
                                                                z = z2;
                                                                httpURLConnection = httpURLConnection4;
                                                                j = j4;
                                                                i2 = 0;
                                                            } catch (Throwable th2) {
                                                                th = th2;
                                                                bufferedInputStream = bufferedInputStream2;
                                                                fileOutputStream = fileOutputStream2;
                                                                httpURLConnection = httpURLConnection4;
                                                            }
                                                        } else {
                                                            long j5 = contentLength;
                                                            if (downloadParams2.progressDivider <= 0.0f) {
                                                                publishProgress(new long[]{j5, j3});
                                                                bufferedInputStream = bufferedInputStream2;
                                                                z = z2;
                                                                httpURLConnection = httpURLConnection4;
                                                                j = j5;
                                                            } else {
                                                                bufferedInputStream = bufferedInputStream2;
                                                                z = z2;
                                                                httpURLConnection = httpURLConnection4;
                                                                j = j5;
                                                                double dRound = Math.round((j3 * 100.0d) / j);
                                                                if (dRound % ((double) downloadParams2.progressDivider) == 0.0d && (dRound != d || j3 == j)) {
                                                                    Log.d("Downloader", "EMIT: " + String.valueOf(dRound) + ", TOTAL:" + String.valueOf(j3));
                                                                    publishProgress(new long[]{j, j3});
                                                                    d = dRound;
                                                                }
                                                            }
                                                        }
                                                        fileOutputStream2.write(bArr, i2, i3);
                                                        responseCode = i4;
                                                        httpURLConnection2 = httpURLConnection;
                                                        z2 = z;
                                                        downloadParams2 = downloadParams;
                                                        bufferedInputStream2 = bufferedInputStream;
                                                        contentLength = j;
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        bufferedInputStream = bufferedInputStream2;
                                                        httpURLConnection = httpURLConnection4;
                                                        fileOutputStream = fileOutputStream2;
                                                        if (fileOutputStream != null) {
                                                            fileOutputStream.close();
                                                        }
                                                        if (bufferedInputStream != null) {
                                                            bufferedInputStream.close();
                                                        }
                                                        if (httpURLConnection != null) {
                                                            httpURLConnection.disconnect();
                                                        }
                                                        throw th;
                                                    }
                                                } else {
                                                    z = z2;
                                                    httpURLConnection = httpURLConnection4;
                                                    long j6 = contentLength;
                                                    bufferedInputStream = bufferedInputStream2;
                                                    j = j6;
                                                }
                                                fileOutputStream2.write(bArr, i2, i3);
                                                responseCode = i4;
                                                httpURLConnection2 = httpURLConnection;
                                                z2 = z;
                                                downloadParams2 = downloadParams;
                                                bufferedInputStream2 = bufferedInputStream;
                                                contentLength = j;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                fileOutputStream = fileOutputStream2;
                                                if (fileOutputStream != null) {
                                                    fileOutputStream.close();
                                                }
                                                if (bufferedInputStream != null) {
                                                    bufferedInputStream.close();
                                                }
                                                if (httpURLConnection != null) {
                                                    httpURLConnection.disconnect();
                                                }
                                                throw th;
                                            }
                                            i2 = 0;
                                        } else {
                                            httpURLConnection = httpURLConnection2;
                                            i = responseCode;
                                            bufferedInputStream = bufferedInputStream2;
                                            fileOutputStream2.flush();
                                            downloadResult.bytesWritten = j3;
                                            fileOutputStream = fileOutputStream2;
                                            break;
                                        }
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    httpURLConnection = httpURLConnection2;
                                    bufferedInputStream = bufferedInputStream2;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                httpURLConnection = httpURLConnection2;
                                bufferedInputStream = bufferedInputStream2;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            httpURLConnection = httpURLConnection2;
                            bufferedInputStream = null;
                        }
                    }
                    try {
                        downloadResult.statusCode = i;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            return;
                        }
                        return;
                    } catch (Throwable th8) {
                        th = th8;
                    }
                }
            } catch (Throwable th9) {
                th = th9;
                bufferedInputStream = null;
                httpURLConnection = httpURLConnection2;
            }
        } catch (Throwable th10) {
            th = th10;
            bufferedInputStream = null;
            httpURLConnection = null;
        }
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        if (bufferedInputStream != null) {
            bufferedInputStream.close();
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        throw th;
    }

    private long getContentLength(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getContentLengthLong();
    }

    protected void stop() {
        this.mAbort.set(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onProgressUpdate(long[]... jArr) {
        super.onProgressUpdate((Object[]) jArr);
        if (this.mParam.onDownloadProgress != null) {
            DownloadParams.OnDownloadProgress onDownloadProgress = this.mParam.onDownloadProgress;
            long[] jArr2 = jArr[0];
            onDownloadProgress.onDownloadProgress(jArr2[0], jArr2[1]);
        }
    }
}
