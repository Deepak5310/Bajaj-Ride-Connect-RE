package com.mappls.sdk.services.api;

/* JADX INFO: loaded from: classes4.dex */
public class ApiResponse<T> {
    private final String errorMessage;
    private final T response;
    private final int responseCode;

    ApiResponse(T t) {
        this.response = t;
        this.responseCode = 200;
        this.errorMessage = null;
    }

    ApiResponse(T t, int i) {
        this.response = t;
        this.responseCode = i;
        this.errorMessage = null;
    }

    ApiResponse(int i, String str) {
        this.response = null;
        this.responseCode = i;
        this.errorMessage = str;
    }

    public static <T> ApiResponse<T> success(T t) {
        return new ApiResponse<>(t);
    }

    public static <T> ApiResponse<T> success(T t, int i) {
        return new ApiResponse<>(t, i);
    }

    public static <T> ApiResponse<T> error(int i, String str) {
        return new ApiResponse<>(i, str);
    }

    public T getResponse() {
        return this.response;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
