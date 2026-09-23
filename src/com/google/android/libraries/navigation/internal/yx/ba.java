package com.google.android.libraries.navigation.internal.yx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ba extends bh {
    final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(bj bjVar, CharSequence charSequence, String str) {
        super(bjVar, charSequence);
        this.b = str;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.bh
    public final int b(int i) {
        return i + this.b.length();
    }

    @Override // com.google.android.libraries.navigation.internal.yx.bh
    public final int c(int i) {
        int length = this.c.length();
        int length2 = this.b.length();
        int i2 = length - length2;
        while (i <= i2) {
            for (int i3 = 0; i3 < length2; i3++) {
                if (this.c.charAt(i3 + i) != this.b.charAt(i3)) {
                    i++;
                }
            }
            return i;
        }
        return -1;
    }
}
