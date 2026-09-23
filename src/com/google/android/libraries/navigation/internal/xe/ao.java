package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.NavigationTransactionRecorder;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ao {
    public static void a(List list, boolean z) throws NavigationTransactionRecorder.TransactionException {
        if (list == null) {
            throw new NavigationTransactionRecorder.TransactionException("Transaction IDs must be non-null.");
        }
        if (!z && list.isEmpty()) {
            throw new NavigationTransactionRecorder.TransactionException("At least one transaction ID must be provided.");
        }
        if (list.size() > 100) {
            throw new NavigationTransactionRecorder.TransactionException("No more than 100 are allowed in a single call.");
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            if (str == null) {
                throw new NavigationTransactionRecorder.TransactionException("Individual Transaction ID must be non-null.");
            }
            if (str.isEmpty()) {
                throw new NavigationTransactionRecorder.TransactionException("Individual Transaction ID length must be at least 1.");
            }
            if (str.length() > 64) {
                throw new NavigationTransactionRecorder.TransactionException(String.format("Transaction ID length must be at most %d, found %d: %s", 64, Integer.valueOf(str.length()), str));
            }
        }
    }
}
