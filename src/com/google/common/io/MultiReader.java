package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes2.dex */
@ElementTypesAreNonnullByDefault
class MultiReader extends Reader {

    @CheckForNull
    private Reader current;

    /* JADX INFO: renamed from: it, reason: collision with root package name */
    private final Iterator<? extends CharSource> f684it;

    MultiReader(Iterator<? extends CharSource> readers) throws IOException {
        this.f684it = readers;
        advance();
    }

    private void advance() throws IOException {
        close();
        if (this.f684it.hasNext()) {
            this.current = this.f684it.next().openStream();
        }
    }

    @Override // java.io.Reader
    public int read(char[] cbuf, int off, int len) throws IOException {
        Preconditions.checkNotNull(cbuf);
        Reader reader = this.current;
        if (reader == null) {
            return -1;
        }
        int i = reader.read(cbuf, off, len);
        if (i != -1) {
            return i;
        }
        advance();
        return read(cbuf, off, len);
    }

    @Override // java.io.Reader
    public long skip(long n2) throws IOException {
        Preconditions.checkArgument(n2 >= 0, "n is negative");
        if (n2 > 0) {
            while (true) {
                Reader reader = this.current;
                if (reader == null) {
                    break;
                }
                long jSkip = reader.skip(n2);
                if (jSkip > 0) {
                    return jSkip;
                }
                advance();
            }
        }
        return 0L;
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        Reader reader = this.current;
        return reader != null && reader.ready();
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Reader reader = this.current;
        if (reader != null) {
            try {
                reader.close();
            } finally {
                this.current = null;
            }
        }
    }
}
