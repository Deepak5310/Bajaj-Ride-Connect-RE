package com.afollestad.sectionedrecyclerview;

/* JADX INFO: loaded from: classes3.dex */
interface ItemProvider {
    int getItemCount(int i);

    int getSectionCount();

    boolean showFooters();

    boolean showHeadersForEmptySections();
}
