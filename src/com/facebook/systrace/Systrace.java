package com.facebook.systrace;

import androidx.tracing.Trace;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.spotify.sdk.android.auth.AccountsQueryParameters;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Systrace.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001%B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0007J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007J \u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J \u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J(\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u0012\u0010\u0018\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J \u0010\u001b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J \u0010\u001c\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J \u0010\u001d\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u000fH\u0007J$\u0010 \u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\r2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0007J\u0012\u0010$\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/facebook/systrace/Systrace;", "", "()V", "TRACE_TAG_REACT_APPS", "", "TRACE_TAG_REACT_FRESCO", "TRACE_TAG_REACT_JAVA_BRIDGE", "TRACE_TAG_REACT_JS_VM_CALLS", "TRACE_TAG_REACT_VIEW", "beginAsyncSection", "", "tag", "sectionName", "", "cookie", "", "startNanos", "beginSection", "endAsyncFlow", "endAsyncSection", "endNanos", "endSection", "isTracing", "", "registerListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/facebook/systrace/TraceListener;", "startAsyncFlow", "stepAsyncFlow", "traceCounter", "counterName", "counterValue", "traceInstant", "title", AccountsQueryParameters.SCOPE, "Lcom/facebook/systrace/Systrace$EventScope;", "unregisterListener", "EventScope", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Systrace {
    public static final Systrace INSTANCE = new Systrace();
    public static final long TRACE_TAG_REACT_APPS = 0;
    public static final long TRACE_TAG_REACT_FRESCO = 0;
    public static final long TRACE_TAG_REACT_JAVA_BRIDGE = 0;
    public static final long TRACE_TAG_REACT_JS_VM_CALLS = 0;
    public static final long TRACE_TAG_REACT_VIEW = 0;

    @JvmStatic
    public static final boolean isTracing(long tag) {
        return false;
    }

    @JvmStatic
    public static final void registerListener(TraceListener listener) {
    }

    @JvmStatic
    public static final void stepAsyncFlow(long tag, String sectionName, int cookie) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
    }

    @JvmStatic
    public static final void traceInstant(long tag, String title, EventScope scope) {
    }

    @JvmStatic
    public static final void unregisterListener(TraceListener listener) {
    }

    private Systrace() {
    }

    @JvmStatic
    public static final void beginSection(long tag, String sectionName) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        Trace.beginSection(sectionName);
    }

    @JvmStatic
    public static final void endSection(long tag) {
        Trace.endSection();
    }

    @JvmStatic
    public static final void beginAsyncSection(long tag, String sectionName, int cookie) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        Trace.beginAsyncSection(sectionName, cookie);
    }

    @JvmStatic
    public static final void beginAsyncSection(long tag, String sectionName, int cookie, long startNanos) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        beginAsyncSection(tag, sectionName, cookie);
    }

    @JvmStatic
    public static final void endAsyncSection(long tag, String sectionName, int cookie) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        Trace.endAsyncSection(sectionName, cookie);
    }

    @JvmStatic
    public static final void endAsyncSection(long tag, String sectionName, int cookie, long endNanos) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        endAsyncSection(tag, sectionName, cookie);
    }

    @JvmStatic
    public static final void traceCounter(long tag, String counterName, int counterValue) {
        Intrinsics.checkNotNullParameter(counterName, "counterName");
        Trace.setCounter(counterName, counterValue);
    }

    @JvmStatic
    public static final void startAsyncFlow(long tag, String sectionName, int cookie) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        beginAsyncSection(tag, sectionName, cookie);
    }

    @JvmStatic
    public static final void endAsyncFlow(long tag, String sectionName, int cookie) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        endAsyncSection(tag, sectionName, cookie);
    }

    /* JADX INFO: compiled from: Systrace.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\f\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/facebook/systrace/Systrace$EventScope;", "", AccountsQueryParameters.CODE, "", "(Ljava/lang/String;IC)V", "getCode", "()C", "THREAD", "PROCESS", "GLOBAL", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum EventScope {
        THREAD('t'),
        PROCESS('p'),
        GLOBAL('g');

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final char code;

        public static EnumEntries<EventScope> getEntries() {
            return $ENTRIES;
        }

        EventScope(char c) {
            this.code = c;
        }

        public final char getCode() {
            return this.code;
        }
    }
}
