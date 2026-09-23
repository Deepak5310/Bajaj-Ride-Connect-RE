package org.chromium.net.impl;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.chromium.net.BidirectionalStream;
import org.chromium.net.ExperimentalBidirectionalStream;
import org.chromium.net.NetworkQualityRttListener;
import org.chromium.net.NetworkQualityThroughputListener;
import org.chromium.net.RequestFinishedInfo;
import org.chromium.net.UrlRequest;

/* JADX INFO: loaded from: classes5.dex */
public final class JavaCronetEngine extends CronetEngineBase {
    private static final String TAG = "JavaCronetEngine";
    private final Context mContext;
    private final int mCronetEngineId;
    private final ExecutorService mExecutorService;
    private final CronetLogger mLogger;
    private final String mUserAgent;
    private final AtomicInteger mActiveRequestCount = new AtomicInteger();
    private long mNetworkHandle = -1;

    @Override // org.chromium.net.CronetEngine
    public void addRequestFinishedListener(RequestFinishedInfo.Listener listener) {
    }

    @Override // org.chromium.net.CronetEngine
    public void addRttListener(NetworkQualityRttListener networkQualityRttListener) {
    }

    @Override // org.chromium.net.CronetEngine
    public void addThroughputListener(NetworkQualityThroughputListener networkQualityThroughputListener) {
    }

    @Override // org.chromium.net.CronetEngine
    public void configureNetworkQualityEstimatorForTesting(boolean z, boolean z2, boolean z3) {
    }

    @Override // org.chromium.net.CronetEngine
    public int getDownstreamThroughputKbps() {
        return -1;
    }

    @Override // org.chromium.net.CronetEngine
    public int getEffectiveConnectionType() {
        return 0;
    }

    @Override // org.chromium.net.CronetEngine
    public int getHttpRttMs() {
        return -1;
    }

    @Override // org.chromium.net.CronetEngine
    public int getTransportRttMs() {
        return -1;
    }

    @Override // org.chromium.net.CronetEngine
    public void removeRequestFinishedListener(RequestFinishedInfo.Listener listener) {
    }

    @Override // org.chromium.net.CronetEngine
    public void removeRttListener(NetworkQualityRttListener networkQualityRttListener) {
    }

    @Override // org.chromium.net.CronetEngine
    public void removeThroughputListener(NetworkQualityThroughputListener networkQualityThroughputListener) {
    }

    @Override // org.chromium.net.CronetEngine
    public void startNetLogToDisk(String str, boolean z, int i) {
    }

    @Override // org.chromium.net.CronetEngine
    public void startNetLogToFile(String str, boolean z) {
    }

    @Override // org.chromium.net.CronetEngine
    public void stopNetLog() {
    }

    @Override // org.chromium.net.impl.CronetEngineBase, org.chromium.net.ExperimentalCronetEngine, org.chromium.net.CronetEngine
    public /* bridge */ /* synthetic */ UrlRequest.Builder newUrlRequestBuilder(String str, UrlRequest.Callback callback, Executor executor) {
        return super.newUrlRequestBuilder(str, callback, executor);
    }

    public JavaCronetEngine(CronetEngineBuilderImpl cronetEngineBuilderImpl) {
        this.mContext = cronetEngineBuilderImpl.getContext();
        int iHashCode = hashCode();
        this.mCronetEngineId = iHashCode;
        final int iThreadPriority = cronetEngineBuilderImpl.threadPriority(9);
        this.mUserAgent = cronetEngineBuilderImpl.getUserAgent();
        this.mExecutorService = new ThreadPoolExecutor(10, 10, 50L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: org.chromium.net.impl.JavaCronetEngine.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(final Runnable runnable) {
                return Executors.defaultThreadFactory().newThread(new Runnable() { // from class: org.chromium.net.impl.JavaCronetEngine.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Thread.currentThread().setName("JavaCronetEngine");
                        Process.setThreadPriority(iThreadPriority);
                        runnable.run();
                    }
                });
            }
        });
        CronetLogger cronetLoggerCreateNoOpLogger = CronetLoggerFactory.createNoOpLogger();
        this.mLogger = cronetLoggerCreateNoOpLogger;
        try {
            cronetLoggerCreateNoOpLogger.logCronetEngineCreation(iHashCode, new CronetLogger.CronetEngineBuilderInfo(cronetEngineBuilderImpl), buildCronetVersion(), CronetLogger.CronetSource.CRONET_SOURCE_FALLBACK);
        } catch (RuntimeException e) {
            Log.e(TAG, "Error while trying to log JavaCronetEngine creation: ", e);
        }
        Log.w(TAG, "using the fallback Cronet Engine implementation. Performance will suffer and many HTTP client features, including caching, will not work.");
    }

    void incrementActiveRequestCount() {
        this.mActiveRequestCount.incrementAndGet();
    }

    void decrementActiveRequestCount() {
        this.mActiveRequestCount.decrementAndGet();
    }

    int getCronetEngineId() {
        return this.mCronetEngineId;
    }

    CronetLogger getCronetLogger() {
        return this.mLogger;
    }

    Context getContext() {
        return this.mContext;
    }

    @Override // org.chromium.net.impl.CronetEngineBase
    public UrlRequestBase createRequest(String str, UrlRequest.Callback callback, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4, int i2, boolean z5, int i3, RequestFinishedInfo.Listener listener, int i4, long j) {
        if (j != -1) {
            this.mNetworkHandle = j;
        }
        return new JavaUrlRequest(this, callback, this.mExecutorService, executor, str, this.mUserAgent, z3, z4, i2, z5, i3, this.mNetworkHandle);
    }

    @Override // org.chromium.net.impl.CronetEngineBase
    protected ExperimentalBidirectionalStream createBidirectionalStream(String str, BidirectionalStream.Callback callback, Executor executor, String str2, List<Map.Entry<String, String>> list, int i, boolean z, Collection<Object> collection, boolean z2, int i2, boolean z3, int i3, long j) {
        throw new UnsupportedOperationException("Can't create a bidi stream - httpurlconnection doesn't have those APIs");
    }

    @Override // org.chromium.net.impl.CronetEngineBase, org.chromium.net.ExperimentalCronetEngine, org.chromium.net.CronetEngine
    public ExperimentalBidirectionalStream.Builder newBidirectionalStreamBuilder(String str, BidirectionalStream.Callback callback, Executor executor) {
        throw new UnsupportedOperationException("The bidirectional stream API is not supported by the Java implementation of Cronet Engine");
    }

    @Override // org.chromium.net.CronetEngine
    public String getVersionString() {
        return "CronetHttpURLConnection/" + ImplVersion.getCronetVersionWithLastChange();
    }

    private CronetLogger.CronetVersion buildCronetVersion() {
        return new CronetLogger.CronetVersion(getVersionString().split(RemoteSettings.FORWARD_SLASH_STRING)[1].split("@")[0]);
    }

    @Override // org.chromium.net.CronetEngine
    public void shutdown() {
        this.mExecutorService.shutdown();
    }

    @Override // org.chromium.net.CronetEngine
    public byte[] getGlobalMetricsDeltas() {
        return new byte[0];
    }

    @Override // org.chromium.net.CronetEngine
    public int getActiveRequestCount() {
        return this.mActiveRequestCount.get();
    }

    @Override // org.chromium.net.CronetEngine
    public void bindToNetwork(long j) {
        this.mNetworkHandle = j;
    }

    @Override // org.chromium.net.CronetEngine
    public URLConnection openConnection(URL url) throws IOException {
        return (URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection());
    }

    @Override // org.chromium.net.ExperimentalCronetEngine
    public URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        return (URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection(proxy));
    }

    @Override // org.chromium.net.CronetEngine
    public URLStreamHandlerFactory createURLStreamHandlerFactory() {
        return new URLStreamHandlerFactory() { // from class: org.chromium.net.impl.JavaCronetEngine.2
            @Override // java.net.URLStreamHandlerFactory
            public URLStreamHandler createURLStreamHandler(String str) {
                return null;
            }
        };
    }
}
