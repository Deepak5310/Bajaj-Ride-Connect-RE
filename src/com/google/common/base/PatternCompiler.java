package com.google.common.base;

/* JADX INFO: loaded from: classes7.dex */
@ElementTypesAreNonnullByDefault
interface PatternCompiler {
    CommonPattern compile(String pattern);

    boolean isPcreLike();
}
