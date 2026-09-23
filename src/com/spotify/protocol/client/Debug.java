package com.spotify.protocol.client;

/* JADX INFO: loaded from: classes4.dex */
public final class Debug {
    private static Logger sLogger = VoidLogger.INSTANCE;
    private static Assertion sAssertion = VoidAssertion.INSTANCE;

    public interface Assertion {
        void assertTrue(boolean z, String str);
    }

    public interface Logger {
        void d(String str, Object... objArr);

        void d(Throwable th, String str, Object... objArr);

        void e(String str, Object... objArr);

        void e(Throwable th, String str, Object... objArr);
    }

    private Debug() {
    }

    public static void setLogger(Logger logger) {
        if (logger == null) {
            logger = VoidLogger.INSTANCE;
        }
        sLogger = logger;
    }

    public static void setAssertion(Assertion assertion) {
        if (assertion == null) {
            assertion = VoidAssertion.INSTANCE;
        }
        sAssertion = assertion;
    }

    public static void e(Throwable th, String str, Object... objArr) {
        sLogger.e(th, str, objArr);
    }

    public static void d(Throwable th, String str, Object... objArr) {
        sLogger.d(th, str, objArr);
    }

    public static void e(String str, Object... objArr) {
        sLogger.e(str, objArr);
    }

    public static void d(String str, Object... objArr) {
        sLogger.d(str, objArr);
    }

    public static void assertTrue(boolean z, String str) {
        sAssertion.assertTrue(z, str);
    }

    private static class VoidLogger implements Logger {
        private static final VoidLogger INSTANCE = new VoidLogger();

        @Override // com.spotify.protocol.client.Debug.Logger
        public void d(String str, Object... objArr) {
        }

        @Override // com.spotify.protocol.client.Debug.Logger
        public void d(Throwable th, String str, Object... objArr) {
        }

        @Override // com.spotify.protocol.client.Debug.Logger
        public void e(String str, Object... objArr) {
        }

        @Override // com.spotify.protocol.client.Debug.Logger
        public void e(Throwable th, String str, Object... objArr) {
        }

        private VoidLogger() {
        }
    }

    private static class VoidAssertion implements Assertion {
        private static final VoidAssertion INSTANCE = new VoidAssertion();

        @Override // com.spotify.protocol.client.Debug.Assertion
        public void assertTrue(boolean z, String str) {
        }

        private VoidAssertion() {
        }
    }
}
