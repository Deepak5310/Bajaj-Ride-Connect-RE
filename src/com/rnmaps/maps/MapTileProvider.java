package com.rnmaps.maps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;
import com.google.android.gms.maps.model.UrlTileProvider;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class MapTileProvider implements TileProvider {
    protected static final int BUFFER_SIZE = 16384;
    protected static final int TARGET_TILE_SIZE = 512;
    protected Context context;
    protected boolean customMode;
    protected boolean doubleTileSize;
    protected boolean flipY;
    protected int maximumNativeZ;
    protected int maximumZ;
    protected int minimumZ;
    protected boolean offlineMode;
    protected int tileCacheMaxAge;
    protected String tileCachePath;
    protected UrlTileProvider tileProvider;
    protected int tileSize;
    protected String urlTemplate;

    public void setCustomMode() {
    }

    class AIRMapUrlTileProvider extends UrlTileProvider {
        private String urlTemplate;

        public AIRMapUrlTileProvider(int i, int i2, String str) {
            super(i, i2);
            this.urlTemplate = str;
        }

        @Override // com.google.android.gms.maps.model.UrlTileProvider
        public URL getTileUrl(int i, int i2, int i3) {
            if (MapTileProvider.this.flipY) {
                i2 = ((1 << i3) - i2) - 1;
            }
            String strReplace = this.urlTemplate.replace("{x}", Integer.toString(i)).replace("{y}", Integer.toString(i2)).replace("{z}", Integer.toString(i3));
            if (MapTileProvider.this.maximumZ > 0 && i3 > MapTileProvider.this.maximumZ) {
                return null;
            }
            if (MapTileProvider.this.minimumZ > 0 && i3 < MapTileProvider.this.minimumZ) {
                return null;
            }
            try {
                return new URL(strReplace);
            } catch (MalformedURLException e) {
                throw new AssertionError(e);
            }
        }

        public void setUrlTemplate(String str) {
            this.urlTemplate = str;
        }
    }

    public MapTileProvider(int i, boolean z, String str, int i2, int i3, int i4, boolean z2, String str2, int i5, boolean z3, Context context, boolean z4) {
        this.tileProvider = new AIRMapUrlTileProvider(i, i, str);
        this.tileSize = i;
        this.doubleTileSize = z;
        this.urlTemplate = str;
        this.maximumZ = i2;
        this.maximumNativeZ = i3;
        this.minimumZ = i4;
        this.flipY = z2;
        this.tileCachePath = str2;
        this.tileCacheMaxAge = i5;
        this.offlineMode = z3;
        this.context = context;
        this.customMode = z4;
    }

    @Override // com.google.android.gms.maps.model.TileProvider
    public Tile getTile(int i, int i2, int i3) throws Throwable {
        byte[] bArrScaleLowerZoomTile;
        int i4;
        if (!this.customMode) {
            return this.tileProvider.getTile(i, i2, i3);
        }
        int i5 = this.maximumZ;
        if (i5 <= 0) {
            i5 = Integer.MAX_VALUE;
        }
        if (this.tileSize != 256 || !this.doubleTileSize || (i4 = i3 + 1) > this.maximumNativeZ || i4 > i5) {
            bArrScaleLowerZoomTile = null;
        } else {
            Log.d("urlTile", "pullTilesFromHigherZoom");
            bArrScaleLowerZoomTile = pullTilesFromHigherZoom(i, i2, i3);
        }
        if (i3 > this.maximumNativeZ) {
            Log.d("urlTile", "scaleLowerZoomTile");
            bArrScaleLowerZoomTile = scaleLowerZoomTile(i, i2, i3, this.maximumNativeZ);
        }
        if (bArrScaleLowerZoomTile == null && i3 <= i5) {
            Log.d("urlTile", "getTileImage");
            bArrScaleLowerZoomTile = getTileImage(i, i2, i3);
        }
        if (bArrScaleLowerZoomTile == null && this.tileCachePath != null && this.offlineMode) {
            Log.d("urlTile", "findLowerZoomTileForScaling");
            int i6 = this.maximumNativeZ;
            int iMax = Math.max(this.minimumZ, i3 - 3);
            for (int i7 = i3 > i6 ? i6 - 1 : i3 - 1; i7 >= iMax; i7--) {
                bArrScaleLowerZoomTile = scaleLowerZoomTile(i, i2, i3, i7);
                if (bArrScaleLowerZoomTile != null) {
                    break;
                }
            }
        }
        if (bArrScaleLowerZoomTile == null) {
            return null;
        }
        int i8 = this.tileSize;
        return new Tile(i8, i8, bArrScaleLowerZoomTile);
    }

    byte[] getTileImage(int i, int i2, int i3) throws Throwable {
        byte[] bArrFetchTile;
        if (this.tileCachePath != null) {
            bArrFetchTile = readTileImage(i, i2, i3);
            if (bArrFetchTile != null) {
                Log.d("urlTile", "tile cache HIT for " + i3 + RemoteSettings.FORWARD_SLASH_STRING + i + RemoteSettings.FORWARD_SLASH_STRING + i2);
            } else {
                Log.d("urlTile", "tile cache MISS for " + i3 + RemoteSettings.FORWARD_SLASH_STRING + i + RemoteSettings.FORWARD_SLASH_STRING + i2);
            }
            if (bArrFetchTile != null && !this.offlineMode) {
                checkForRefresh(i, i2, i3);
            }
        } else {
            bArrFetchTile = null;
        }
        if (bArrFetchTile == null && !this.offlineMode && this.tileCachePath != null) {
            String tileFilename = getTileFilename(i, i2, i3);
            OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(MapTileWorker.class).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).addTag(tileFilename).setInputData(new Data.Builder().putString(ImagesContract.URL, getTileUrl(i, i2, i3).toString()).putString("filename", tileFilename).putInt("maxAge", -1).build()).build();
            WorkManager workManager = WorkManager.getInstance(this.context.getApplicationContext());
            try {
                workManager.enqueueUniqueWork(tileFilename, ExistingWorkPolicy.KEEP, oneTimeWorkRequestBuild).getResult().get(1L, TimeUnit.SECONDS);
                Thread.sleep(500L);
                Log.d("urlTile: ", workManager.getWorkInfosByTag(tileFilename).get(1L, TimeUnit.SECONDS).get(0).toString());
                if (this.tileCachePath != null) {
                    bArrFetchTile = readTileImage(i, i2, i3);
                    if (bArrFetchTile != null) {
                        Log.d("urlTile", "tile cache fetch HIT for " + i3 + RemoteSettings.FORWARD_SLASH_STRING + i + RemoteSettings.FORWARD_SLASH_STRING + i2);
                    } else {
                        Log.d("urlTile", "tile cache fetch MISS for " + i3 + RemoteSettings.FORWARD_SLASH_STRING + i + RemoteSettings.FORWARD_SLASH_STRING + i2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (bArrFetchTile == null && !this.offlineMode) {
            Log.d("urlTile", "Normal fetch");
            bArrFetchTile = fetchTile(i, i2, i3);
            if (bArrFetchTile == null) {
                Log.d("urlTile", "tile fetch TIMEOUT / FAIL for " + i3 + RemoteSettings.FORWARD_SLASH_STRING + i + RemoteSettings.FORWARD_SLASH_STRING + i2);
            }
        }
        return bArrFetchTile;
    }

    byte[] pullTilesFromHigherZoom(int i, int i2, int i3) throws Throwable {
        Bitmap newBitmap = getNewBitmap();
        Canvas canvas = new Canvas(newBitmap);
        Paint paint = new Paint();
        int i4 = i * 2;
        int i5 = i2 * 2;
        int i6 = i3 + 1;
        byte[] tileImage = getTileImage(i4, i5, i6);
        int i7 = i5 + 1;
        byte[] tileImage2 = getTileImage(i4, i7, i6);
        int i8 = i4 + 1;
        byte[] tileImage3 = getTileImage(i8, i5, i6);
        byte[] tileImage4 = getTileImage(i8, i7, i6);
        if (tileImage == null || tileImage2 == null || tileImage3 == null || tileImage4 == null) {
            return null;
        }
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(tileImage, 0, tileImage.length);
        canvas.drawBitmap(bitmapDecodeByteArray, 0.0f, 0.0f, paint);
        bitmapDecodeByteArray.recycle();
        Bitmap bitmapDecodeByteArray2 = BitmapFactory.decodeByteArray(tileImage2, 0, tileImage2.length);
        canvas.drawBitmap(bitmapDecodeByteArray2, 0.0f, 256.0f, paint);
        bitmapDecodeByteArray2.recycle();
        Bitmap bitmapDecodeByteArray3 = BitmapFactory.decodeByteArray(tileImage3, 0, tileImage3.length);
        canvas.drawBitmap(bitmapDecodeByteArray3, 256.0f, 0.0f, paint);
        bitmapDecodeByteArray3.recycle();
        Bitmap bitmapDecodeByteArray4 = BitmapFactory.decodeByteArray(tileImage4, 0, tileImage4.length);
        canvas.drawBitmap(bitmapDecodeByteArray4, 256.0f, 256.0f, paint);
        bitmapDecodeByteArray4.recycle();
        byte[] bArrBitmapToByteArray = bitmapToByteArray(newBitmap);
        newBitmap.recycle();
        return bArrBitmapToByteArray;
    }

    Bitmap getNewBitmap() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.eraseColor(0);
        return bitmapCreateBitmap;
    }

    byte[] bitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArray;
    }

    byte[] scaleLowerZoomTile(int i, int i2, int i3, int i4) throws Throwable {
        int i5 = i3 - i4;
        int i6 = 1 << i5;
        int i7 = i >> i5;
        int i8 = i2 >> i5;
        int i9 = i3 - i5;
        int i10 = i % i6;
        int i11 = i2 % i6;
        Bitmap newBitmap = getNewBitmap();
        Canvas canvas = new Canvas(newBitmap);
        Paint paint = new Paint();
        byte[] tileImage = getTileImage(i7, i8, i9);
        if (tileImage == null) {
            return null;
        }
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(tileImage, 0, tileImage.length);
        int i12 = this.tileSize / i6;
        int i13 = i10 * i12;
        int i14 = i11 * i12;
        canvas.drawBitmap(bitmapDecodeByteArray, new Rect(i13, i14, i13 + i12, i12 + i14), new Rect(0, 0, 512, 512), paint);
        bitmapDecodeByteArray.recycle();
        byte[] bArrBitmapToByteArray = bitmapToByteArray(newBitmap);
        newBitmap.recycle();
        return bArrBitmapToByteArray;
    }

    void checkForRefresh(int i, int i2, int i3) {
        String tileFilename = getTileFilename(i, i2, i3);
        if ((System.currentTimeMillis() - new File(tileFilename).lastModified()) / 1000 > this.tileCacheMaxAge) {
            Log.d("urlTile", "Refreshing");
            WorkManager.getInstance(this.context.getApplicationContext()).enqueueUniqueWork(tileFilename, ExistingWorkPolicy.KEEP, new OneTimeWorkRequest.Builder(MapTileWorker.class).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).addTag(tileFilename).setInputData(new Data.Builder().putString(ImagesContract.URL, getTileUrl(i, i2, i3).toString()).putString("filename", tileFilename).putInt("maxAge", this.tileCacheMaxAge).build()).build());
        }
    }

    /* JADX WARN: Code duplicated, block: B:51:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.net.URL] */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v0, types: [int] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r9v6 */
    byte[] fetchTile(int i, int i2, int i3) throws Throwable {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        ?? tileUrl = getTileUrl(i, i2, i3);
        try {
            try {
                tileUrl = ((URLConnection) FirebasePerfUrlConnection.instrument(tileUrl.openConnection())).getInputStream();
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[16384];
                        while (true) {
                            int i4 = tileUrl.read(bArr, 0, 16384);
                            if (i4 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i4);
                        }
                        byteArrayOutputStream.flush();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (tileUrl != 0) {
                            try {
                                tileUrl.close();
                            } catch (Exception unused) {
                            }
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused2) {
                        }
                        return byteArray;
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        if (tileUrl != 0) {
                            try {
                                tileUrl.close();
                            } catch (Exception unused3) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused4) {
                            }
                        }
                        return null;
                    } catch (OutOfMemoryError e2) {
                        e = e2;
                        e.printStackTrace();
                        if (tileUrl != 0) {
                            tileUrl.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return null;
                    }
                } catch (IOException e3) {
                    e = e3;
                    byteArrayOutputStream = null;
                    e.printStackTrace();
                    if (tileUrl != 0) {
                        tileUrl.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return null;
                } catch (OutOfMemoryError e4) {
                    e = e4;
                    byteArrayOutputStream = null;
                    e.printStackTrace();
                    if (tileUrl != 0) {
                        tileUrl.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    i3 = 0;
                    th = th2;
                    if (tileUrl != 0) {
                        try {
                            tileUrl.close();
                        } catch (Exception unused5) {
                        }
                    }
                    if (i3 != 0) {
                        try {
                            i3.close();
                            throw th;
                        } catch (Exception unused6) {
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e5) {
            e = e5;
            tileUrl = 0;
            byteArrayOutputStream = null;
            e.printStackTrace();
            if (tileUrl != 0) {
                tileUrl.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            return null;
        } catch (OutOfMemoryError e6) {
            e = e6;
            tileUrl = 0;
            byteArrayOutputStream = null;
            e.printStackTrace();
            if (tileUrl != 0) {
                tileUrl.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            return null;
        } catch (Throwable th4) {
            i3 = 0;
            th = th4;
            tileUrl = 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:59:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.io.FileInputStream, java.io.InputStream] */
    byte[] readTileImage(int i, int i2, int i3) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream2;
        ?? tileFilename = getTileFilename(i, i2, i3);
        if (tileFilename == 0) {
            return null;
        }
        File file = new File((String) tileFilename);
        try {
            try {
                tileFilename = new FileInputStream(file);
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[16384];
                        while (true) {
                            int i4 = tileFilename.read(bArr, 0, 16384);
                            if (i4 == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr, 0, i4);
                        }
                        byteArrayOutputStream2.flush();
                        if (this.tileCacheMaxAge == 0) {
                            file.setLastModified(System.currentTimeMillis());
                        }
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        try {
                            tileFilename.close();
                        } catch (Exception unused) {
                        }
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception unused2) {
                        }
                        return byteArray;
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        if (tileFilename != 0) {
                            try {
                                tileFilename.close();
                            } catch (Exception unused3) {
                            }
                        }
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Exception unused4) {
                            }
                        }
                        return null;
                    } catch (OutOfMemoryError e2) {
                        e = e2;
                        e.printStackTrace();
                        if (tileFilename != 0) {
                            tileFilename.close();
                        }
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                        return null;
                    }
                } catch (IOException e3) {
                    e = e3;
                    byteArrayOutputStream2 = null;
                    e.printStackTrace();
                    if (tileFilename != 0) {
                        tileFilename.close();
                    }
                    if (byteArrayOutputStream2 != null) {
                        byteArrayOutputStream2.close();
                    }
                    return null;
                } catch (OutOfMemoryError e4) {
                    e = e4;
                    byteArrayOutputStream2 = null;
                    e.printStackTrace();
                    if (tileFilename != 0) {
                        tileFilename.close();
                    }
                    if (byteArrayOutputStream2 != null) {
                        byteArrayOutputStream2.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    byteArrayOutputStream = null;
                    th = th2;
                    if (tileFilename != 0) {
                        try {
                            tileFilename.close();
                        } catch (Exception unused5) {
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                            throw th;
                        } catch (Exception unused6) {
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e5) {
            e = e5;
            tileFilename = 0;
            byteArrayOutputStream2 = null;
            e.printStackTrace();
            if (tileFilename != 0) {
                tileFilename.close();
            }
            if (byteArrayOutputStream2 != null) {
                byteArrayOutputStream2.close();
            }
            return null;
        } catch (OutOfMemoryError e6) {
            e = e6;
            tileFilename = 0;
            byteArrayOutputStream2 = null;
            e.printStackTrace();
            if (tileFilename != 0) {
                tileFilename.close();
            }
            if (byteArrayOutputStream2 != null) {
                byteArrayOutputStream2.close();
            }
            return null;
        } catch (Throwable th4) {
            byteArrayOutputStream = null;
            th = th4;
            tileFilename = 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0034 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    boolean writeTileImage(byte[] bArr, int i, int i2, int i3) throws Throwable {
        String tileFilename = getTileFilename(i, i2, i3);
        if (tileFilename == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(tileFilename);
                file.getParentFile().mkdirs();
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (Exception unused) {
                        return true;
                    }
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    return false;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            e = e3;
        } catch (OutOfMemoryError e4) {
            e = e4;
        }
    }

    String getTileFilename(int i, int i2, int i3) {
        if (this.tileCachePath == null) {
            return null;
        }
        return this.tileCachePath + '/' + i3 + RemoteSettings.FORWARD_SLASH_STRING + i + RemoteSettings.FORWARD_SLASH_STRING + i2;
    }

    protected URL getTileUrl(int i, int i2, int i3) {
        return this.tileProvider.getTileUrl(i, i2, i3);
    }

    public void setUrlTemplate(String str) {
        if (this.urlTemplate != str) {
            int i = this.tileSize;
            this.tileProvider = new AIRMapUrlTileProvider(i, i, str);
        }
        this.urlTemplate = str;
    }

    public void setTileSize(int i) {
        if (this.tileSize != i) {
            this.tileProvider = new AIRMapUrlTileProvider(i, i, this.urlTemplate);
        }
        this.tileSize = i;
    }

    public void setDoubleTileSize(boolean z) {
        this.doubleTileSize = z;
    }

    public void setMaximumZ(int i) {
        this.maximumZ = i;
    }

    public void setMaximumNativeZ(int i) {
        this.maximumNativeZ = i;
    }

    public void setMinimumZ(int i) {
        this.minimumZ = i;
    }

    public void setFlipY(boolean z) {
        this.flipY = z;
    }

    public void setTileCachePath(String str) {
        this.tileCachePath = str;
    }

    public void setTileCacheMaxAge(int i) {
        this.tileCacheMaxAge = i;
    }

    public void setOfflineMode(boolean z) {
        this.offlineMode = z;
    }
}
