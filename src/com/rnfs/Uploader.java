package com.rnfs;

import android.os.AsyncTask;
import android.webkit.MimeTypeMap;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.NoSuchKeyException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class Uploader extends AsyncTask<UploadParams, int[], UploadResult> {
    private AtomicBoolean mAbort = new AtomicBoolean(false);
    private UploadParams mParams;
    private UploadResult res;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public UploadResult doInBackground(UploadParams... uploadParamsArr) {
        this.mParams = uploadParamsArr[0];
        this.res = new UploadResult();
        new Thread(new Runnable() { // from class: com.rnfs.Uploader.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Uploader uploader = Uploader.this;
                    uploader.upload(uploader.mParams, Uploader.this.res);
                    Uploader.this.mParams.onUploadComplete.onUploadComplete(Uploader.this.res);
                } catch (Exception e) {
                    Uploader.this.res.exception = e;
                    Uploader.this.mParams.onUploadComplete.onUploadComplete(Uploader.this.res);
                }
            }
        }).start();
        return this.res;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:110:0x0346  */
    /* JADX WARN: Code duplicated, block: B:112:0x034b  */
    /* JADX WARN: Code duplicated, block: B:114:0x0350  */
    /* JADX WARN: Code duplicated, block: B:116:0x0355  */
    public void upload(UploadParams uploadParams, UploadResult uploadResult) throws Exception {
        DataOutputStream dataOutputStream;
        BufferedInputStream bufferedInputStream;
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader;
        String str;
        HttpURLConnection httpURLConnection2;
        String str2;
        String str3;
        String[] strArr;
        String str4;
        String string;
        String string2;
        String mimeType;
        String str5 = "filename";
        String str6 = "name";
        try {
            Object[] array = uploadParams.files.toArray();
            boolean z = uploadParams.binaryStreamOnly;
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(uploadParams.src.openConnection()));
            try {
                httpURLConnection3.setDoOutput(true);
                ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = uploadParams.headers.keySetIterator();
                httpURLConnection3.setRequestMethod(uploadParams.method);
                if (!z) {
                    httpURLConnection3.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
                }
                while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                    String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                    httpURLConnection3.setRequestProperty(strNextKey, uploadParams.headers.getString(strNextKey));
                }
                ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator2 = uploadParams.fields.keySetIterator();
                String str7 = "";
                while (true) {
                    str = "*****";
                    if (!readableMapKeySetIteratorKeySetIterator2.hasNextKey()) {
                        break;
                    }
                    try {
                        String strNextKey2 = readableMapKeySetIteratorKeySetIterator2.nextKey();
                        ReadableMapKeySetIterator readableMapKeySetIterator = readableMapKeySetIteratorKeySetIterator2;
                        httpURLConnection2 = httpURLConnection3;
                        try {
                            str7 = str7 + "--*****\r\nContent-Disposition: form-data; name=\"" + strNextKey2 + "\"\r\n\r\n" + uploadParams.fields.getString(strNextKey2) + "\r\n";
                            readableMapKeySetIteratorKeySetIterator2 = readableMapKeySetIterator;
                            httpURLConnection3 = httpURLConnection2;
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection2 = httpURLConnection3;
                    }
                    th = th;
                    httpURLConnection = httpURLConnection2;
                    dataOutputStream = null;
                    bufferedInputStream = null;
                    bufferedReader = null;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
                httpURLConnection2 = httpURLConnection3;
                String[] strArr2 = new String[array.length];
                Iterator<ReadableMap> it2 = uploadParams.files.iterator();
                String str8 = str7;
                String str9 = "" + str7;
                int i = 0;
                long length = 0;
                while (true) {
                    str2 = str9;
                    str3 = "filepath";
                    strArr = strArr2;
                    if (!it2.hasNext()) {
                        break;
                    }
                    try {
                        Iterator<ReadableMap> it3 = it2;
                        ReadableMap next = it2.next();
                        try {
                            string = next.getString(str6);
                            string2 = next.getString(str5);
                            str4 = "\r\n--*****--\r\n";
                            try {
                                mimeType = next.getString("filetype");
                            } catch (NoSuchKeyException unused) {
                                string = next.getString(str6);
                                string2 = next.getString(str5);
                                mimeType = getMimeType(next.getString("filepath"));
                            }
                        } catch (NoSuchKeyException unused2) {
                            str4 = "\r\n--*****--\r\n";
                        }
                        String str10 = string;
                        String str11 = str5;
                        String str12 = string2;
                        String str13 = str6;
                        File file = new File(next.getString("filepath"));
                        int i2 = i;
                        long length2 = file.length();
                        length += length2;
                        if (z) {
                            str = str;
                            str9 = str2;
                        } else {
                            String str14 = "--" + str + "\r\nContent-Disposition: form-data; name=\"" + str10 + "\"; filename=\"" + str12 + "\"\r\nContent-Type: " + mimeType + "\r\n";
                            if (array.length - 1 == i2) {
                                length += (long) str4.length();
                            }
                            String str15 = "Content-length: " + length2 + "\r\n";
                            strArr[i2] = str14 + str15 + "\r\n";
                            str9 = str2 + str14 + str15 + "\r\n";
                        }
                        i = i2 + 1;
                        str = str;
                        str5 = str11;
                        strArr2 = strArr;
                        it2 = it3;
                        str6 = str13;
                    } catch (Throwable th3) {
                        th = th3;
                        dataOutputStream = null;
                        bufferedInputStream = null;
                        bufferedReader = null;
                        httpURLConnection = httpURLConnection2;
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
                if (this.mParams.onUploadBegin != null) {
                    this.mParams.onUploadBegin.onUploadBegin();
                }
                if (z) {
                    httpURLConnection = httpURLConnection2;
                } else {
                    long length3 = ((long) (str2.length() + (array.length * 2))) + length;
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    int i3 = (int) length3;
                    sb.append(i3);
                    String string3 = sb.toString();
                    httpURLConnection = httpURLConnection2;
                    try {
                        httpURLConnection.setRequestProperty("Content-length", string3);
                        httpURLConnection.setFixedLengthStreamingMode(i3);
                    } catch (Throwable th4) {
                        th = th4;
                        dataOutputStream = null;
                    }
                }
                httpURLConnection.connect();
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    WritableByteChannel writableByteChannelNewChannel = Channels.newChannel(dataOutputStream);
                    if (!z) {
                        dataOutputStream.writeBytes(str8);
                    }
                    Iterator<ReadableMap> it4 = uploadParams.files.iterator();
                    int i4 = 0;
                    int i5 = 0;
                    while (it4.hasNext()) {
                        ReadableMap next2 = it4.next();
                        if (!z) {
                            dataOutputStream.writeBytes(strArr[i4]);
                        }
                        File file2 = new File(next2.getString(str3));
                        long length4 = file2.length();
                        String str16 = str3;
                        long jCeil = (long) Math.ceil(length4 / 100.0f);
                        FileInputStream fileInputStream = new FileInputStream(file2);
                        FileChannel channel = fileInputStream.getChannel();
                        Iterator<ReadableMap> it5 = it4;
                        long j = 0;
                        int i6 = i5;
                        while (j < length4) {
                            long jTransferTo = channel.transferTo(j, jCeil, writableByteChannelNewChannel);
                            j += jTransferTo;
                            WritableByteChannel writableByteChannel = writableByteChannelNewChannel;
                            if (this.mParams.onUploadProgress != null) {
                                int i7 = (int) (((long) i6) + jTransferTo);
                                this.mParams.onUploadProgress.onUploadProgress((int) length, i7);
                                i6 = i7;
                            }
                            writableByteChannelNewChannel = writableByteChannel;
                            jCeil = jCeil;
                        }
                        WritableByteChannel writableByteChannel2 = writableByteChannelNewChannel;
                        if (!z) {
                            dataOutputStream.writeBytes("\r\n");
                        }
                        i4++;
                        fileInputStream.close();
                        i5 = i6;
                        str3 = str16;
                        it4 = it5;
                        writableByteChannelNewChannel = writableByteChannel2;
                    }
                    if (!z) {
                        dataOutputStream.writeBytes("\r\n--*****--\r\n");
                    }
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream));
                        try {
                            WritableMap writableMapCreateMap = Arguments.createMap();
                            for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
                                writableMapCreateMap.putString(entry.getKey(), entry.getValue().get(0));
                            }
                            StringBuilder sb2 = new StringBuilder();
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                sb2.append(line);
                                sb2.append("\n");
                            }
                            String string4 = sb2.toString();
                            int responseCode = httpURLConnection.getResponseCode();
                            this.res.headers = writableMapCreateMap;
                            this.res.body = string4;
                            this.res.statusCode = responseCode;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            dataOutputStream.close();
                            bufferedInputStream.close();
                            bufferedReader.close();
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        bufferedReader = null;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    bufferedInputStream = null;
                }
            } catch (Throwable th8) {
                th = th8;
                httpURLConnection = httpURLConnection3;
            }
        } catch (Throwable th9) {
            th = th9;
            dataOutputStream = null;
            bufferedInputStream = null;
            httpURLConnection = null;
        }
    }

    protected String getMimeType(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        String mimeTypeFromExtension = fileExtensionFromUrl != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl.toLowerCase()) : null;
        return mimeTypeFromExtension == null ? "*/*" : mimeTypeFromExtension;
    }

    protected void stop() {
        this.mAbort.set(true);
    }
}
