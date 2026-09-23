package com.mappls.sdk.navigation;

import android.os.AsyncTask;

/* JADX INFO: loaded from: classes4.dex */
public final class t {

    private class a<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
        private final b<Params, Progress, Result> a;

        private a(b bVar) {
            this.a = bVar;
        }

        /* synthetic */ a(b bVar, int i) {
            this(bVar);
        }

        @Override // android.os.AsyncTask
        protected final Result doInBackground(Params... paramsArr) {
            return this.a.a((Object[]) paramsArr);
        }

        @Override // android.os.AsyncTask
        protected final void onPostExecute(Result result) {
            this.a.a(result);
        }

        @Override // android.os.AsyncTask
        protected final void onPreExecute() {
            this.a.a();
        }

        @Override // android.os.AsyncTask
        protected final void onProgressUpdate(Progress... progressArr) {
            this.a.getClass();
        }
    }

    public static abstract class b<Params, Progress, Result> {
        protected abstract Result a(Params... paramsArr);

        protected void a() {
        }

        protected abstract void a(Result result);
    }

    @SafeVarargs
    public static void a(b bVar, Object... objArr) {
        new a(bVar, 0).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, objArr);
    }
}
