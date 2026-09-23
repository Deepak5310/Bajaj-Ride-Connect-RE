package com.spotify.protocol.client;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ResultUtils {

    static class ErrorResult<T> implements Result<T> {
        private final Throwable mError;

        @Override // com.spotify.protocol.client.Result
        @Nullable
        public T getData() {
            return null;
        }

        @Override // com.spotify.protocol.client.Result
        public boolean isSuccessful() {
            return false;
        }

        ErrorResult(Throwable th) {
            this.mError = th;
        }

        @Override // com.spotify.protocol.client.Result
        public String getErrorMessage() {
            return this.mError.getMessage();
        }

        @Override // com.spotify.protocol.client.Result
        public Throwable getError() {
            return this.mError;
        }
    }

    public static <T> Result<T> createErrorResult(Throwable th) {
        return new ErrorResult(th);
    }

    static class SuccessfulResult<T> implements Result<T> {
        private final T mPayload;

        @Override // com.spotify.protocol.client.Result
        @Nullable
        public Throwable getError() {
            return null;
        }

        @Override // com.spotify.protocol.client.Result
        @Nullable
        public String getErrorMessage() {
            return null;
        }

        @Override // com.spotify.protocol.client.Result
        public boolean isSuccessful() {
            return true;
        }

        SuccessfulResult(T t) {
            this.mPayload = t;
        }

        @Override // com.spotify.protocol.client.Result
        public T getData() {
            return this.mPayload;
        }
    }

    public static <T> Result<T> createSuccessfulResult(T t) {
        return new SuccessfulResult(t);
    }

    private ResultUtils() {
    }
}
