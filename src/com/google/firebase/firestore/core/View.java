package com.google.firebase.firestore.core;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.DocumentSet;
import com.google.firebase.firestore.remote.TargetChange;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class View {
    private boolean current;
    private DocumentSet documentSet;
    private final Query query;
    private ImmutableSortedSet<DocumentKey> syncedDocuments;
    private ViewSnapshot.SyncState syncState = ViewSnapshot.SyncState.NONE;
    private ImmutableSortedSet<DocumentKey> limboDocuments = DocumentKey.emptyKeySet();
    private ImmutableSortedSet<DocumentKey> mutatedKeys = DocumentKey.emptyKeySet();

    public static class DocumentChanges {
        final DocumentViewChangeSet changeSet;
        final DocumentSet documentSet;
        final ImmutableSortedSet<DocumentKey> mutatedKeys;
        private final boolean needsRefill;

        /* synthetic */ DocumentChanges(DocumentSet documentSet, DocumentViewChangeSet documentViewChangeSet, ImmutableSortedSet immutableSortedSet, boolean z, AnonymousClass1 anonymousClass1) {
            this(documentSet, documentViewChangeSet, immutableSortedSet, z);
        }

        private DocumentChanges(DocumentSet documentSet, DocumentViewChangeSet documentViewChangeSet, ImmutableSortedSet<DocumentKey> immutableSortedSet, boolean z) {
            this.documentSet = documentSet;
            this.changeSet = documentViewChangeSet;
            this.mutatedKeys = immutableSortedSet;
            this.needsRefill = z;
        }

        public boolean needsRefill() {
            return this.needsRefill;
        }
    }

    public View(Query query, ImmutableSortedSet<DocumentKey> immutableSortedSet) {
        this.query = query;
        this.documentSet = DocumentSet.emptySet(query.comparator());
        this.syncedDocuments = immutableSortedSet;
    }

    public ViewSnapshot.SyncState getSyncState() {
        return this.syncState;
    }

    public DocumentChanges computeDocChanges(ImmutableSortedMap<DocumentKey, Document> immutableSortedMap) {
        return computeDocChanges(immutableSortedMap, null);
    }

    /* JADX WARN: Code duplicated, block: B:72:0x0133 A[PHI: r17
      0x0133: PHI (r17v4 com.google.firebase.firestore.model.DocumentSet) = 
      (r17v0 com.google.firebase.firestore.model.DocumentSet)
      (r17v0 com.google.firebase.firestore.model.DocumentSet)
      (r17v5 com.google.firebase.firestore.model.DocumentSet)
      (r17v5 com.google.firebase.firestore.model.DocumentSet)
     binds: [B:70:0x012f, B:71:0x0131, B:58:0x0102, B:55:0x00f4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:73:0x0135 A[PHI: r17
      0x0135: PHI (r17v1 com.google.firebase.firestore.model.DocumentSet) = 
      (r17v0 com.google.firebase.firestore.model.DocumentSet)
      (r17v0 com.google.firebase.firestore.model.DocumentSet)
      (r17v5 com.google.firebase.firestore.model.DocumentSet)
      (r17v5 com.google.firebase.firestore.model.DocumentSet)
     binds: [B:67:0x0122, B:68:0x0124, B:60:0x0105, B:51:0x00dd] A[DONT_GENERATE, DONT_INLINE]] */
    public DocumentChanges computeDocChanges(ImmutableSortedMap<DocumentKey, Document> immutableSortedMap, DocumentChanges documentChanges) {
        Document firstDocument;
        DocumentSet documentSet;
        boolean z;
        ImmutableSortedSet<DocumentKey> immutableSortedSetRemove;
        DocumentViewChangeSet documentViewChangeSet = documentChanges != null ? documentChanges.changeSet : new DocumentViewChangeSet();
        DocumentSet documentSet2 = documentChanges != null ? documentChanges.documentSet : this.documentSet;
        ImmutableSortedSet<DocumentKey> immutableSortedSetRemove2 = documentChanges != null ? documentChanges.mutatedKeys : this.mutatedKeys;
        Document lastDocument = (this.query.getLimitType().equals(Query.LimitType.LIMIT_TO_FIRST) && ((long) documentSet2.size()) == this.query.getLimit()) ? documentSet2.getLastDocument() : null;
        Document firstDocument2 = (this.query.getLimitType().equals(Query.LimitType.LIMIT_TO_LAST) && ((long) documentSet2.size()) == this.query.getLimit()) ? documentSet2.getFirstDocument() : null;
        DocumentSet documentSetRemove = documentSet2;
        boolean z2 = false;
        for (Map.Entry<DocumentKey, Document> entry : immutableSortedMap) {
            DocumentKey key = entry.getKey();
            Document document = documentSet2.getDocument(key);
            Document value = this.query.matches(entry.getValue()) ? entry.getValue() : null;
            boolean z3 = document != null && this.mutatedKeys.contains(document.getKey());
            boolean z4 = value != null && (value.hasLocalMutations() || (this.mutatedKeys.contains(value.getKey()) && value.hasCommittedMutations()));
            if (document == null || value == null) {
                documentSet = documentSet2;
                if (document == null && value != null) {
                    documentViewChangeSet.addChange(DocumentViewChange.create(DocumentViewChange.Type.ADDED, value));
                } else if (document == null || value != null) {
                    z = false;
                } else {
                    documentViewChangeSet.addChange(DocumentViewChange.create(DocumentViewChange.Type.REMOVED, document));
                    if (lastDocument != null || firstDocument2 != null) {
                        z2 = true;
                    }
                }
                z = true;
            } else {
                documentSet = documentSet2;
                if (document.getData().equals(value.getData())) {
                    if (z3 != z4) {
                        documentViewChangeSet.addChange(DocumentViewChange.create(DocumentViewChange.Type.METADATA, value));
                        z = true;
                    } else {
                        z = false;
                    }
                } else if (shouldWaitForSyncedDocument(document, value)) {
                    z = false;
                } else {
                    documentViewChangeSet.addChange(DocumentViewChange.create(DocumentViewChange.Type.MODIFIED, value));
                    if ((lastDocument != null && this.query.comparator().compare(value, lastDocument) > 0) || (firstDocument2 != null && this.query.comparator().compare(value, firstDocument2) < 0)) {
                        z2 = true;
                    }
                    z = true;
                }
            }
            if (z) {
                if (value != null) {
                    documentSetRemove = documentSetRemove.add(value);
                    if (value.hasLocalMutations()) {
                        immutableSortedSetRemove = immutableSortedSetRemove2.insert(value.getKey());
                    } else {
                        immutableSortedSetRemove = immutableSortedSetRemove2.remove(value.getKey());
                    }
                } else {
                    documentSetRemove = documentSetRemove.remove(key);
                    immutableSortedSetRemove = immutableSortedSetRemove2.remove(key);
                }
                immutableSortedSetRemove2 = immutableSortedSetRemove;
            }
            documentSet2 = documentSet;
        }
        if (this.query.hasLimit()) {
            long size = documentSetRemove.size();
            long limit = this.query.getLimit();
            while (true) {
                size -= limit;
                if (size <= 0) {
                    break;
                }
                if (this.query.getLimitType().equals(Query.LimitType.LIMIT_TO_FIRST)) {
                    firstDocument = documentSetRemove.getLastDocument();
                } else {
                    firstDocument = documentSetRemove.getFirstDocument();
                }
                documentSetRemove = documentSetRemove.remove(firstDocument.getKey());
                immutableSortedSetRemove2 = immutableSortedSetRemove2.remove(firstDocument.getKey());
                documentViewChangeSet.addChange(DocumentViewChange.create(DocumentViewChange.Type.REMOVED, firstDocument));
                limit = 1;
            }
        }
        ImmutableSortedSet<DocumentKey> immutableSortedSet = immutableSortedSetRemove2;
        DocumentSet documentSet3 = documentSetRemove;
        Assert.hardAssert(!z2 || documentChanges == null, "View was refilled using docs that themselves needed refilling.", new Object[0]);
        return new DocumentChanges(documentSet3, documentViewChangeSet, immutableSortedSet, z2, null);
    }

    private boolean shouldWaitForSyncedDocument(Document document, Document document2) {
        return document.hasLocalMutations() && document2.hasCommittedMutations() && !document2.hasLocalMutations();
    }

    public ViewChange applyChanges(DocumentChanges documentChanges) {
        return applyChanges(documentChanges, null);
    }

    public ViewChange applyChanges(DocumentChanges documentChanges, TargetChange targetChange) {
        return applyChanges(documentChanges, targetChange, false);
    }

    public ViewChange applyChanges(DocumentChanges documentChanges, TargetChange targetChange, boolean z) {
        ViewSnapshot viewSnapshot;
        Assert.hardAssert(!documentChanges.needsRefill, "Cannot apply changes that need a refill", new Object[0]);
        DocumentSet documentSet = this.documentSet;
        this.documentSet = documentChanges.documentSet;
        this.mutatedKeys = documentChanges.mutatedKeys;
        List<DocumentViewChange> changes = documentChanges.changeSet.getChanges();
        Collections.sort(changes, new Comparator() { // from class: com.google.firebase.firestore.core.View$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return this.f$0.m1571lambda$applyChanges$0$comgooglefirebasefirestorecoreView((DocumentViewChange) obj, (DocumentViewChange) obj2);
            }
        });
        applyTargetChange(targetChange);
        List<LimboDocumentChange> listEmptyList = z ? Collections.emptyList() : updateLimboDocuments();
        ViewSnapshot.SyncState syncState = (this.limboDocuments.size() == 0 && this.current && !z) ? ViewSnapshot.SyncState.SYNCED : ViewSnapshot.SyncState.LOCAL;
        boolean z2 = syncState != this.syncState;
        this.syncState = syncState;
        if (changes.size() != 0 || z2) {
            viewSnapshot = new ViewSnapshot(this.query, documentChanges.documentSet, documentSet, changes, syncState == ViewSnapshot.SyncState.LOCAL, documentChanges.mutatedKeys, z2, false, (targetChange == null || targetChange.getResumeToken().isEmpty()) ? false : true);
        } else {
            viewSnapshot = null;
        }
        return new ViewChange(viewSnapshot, listEmptyList);
    }

    /* JADX INFO: renamed from: lambda$applyChanges$0$com-google-firebase-firestore-core-View, reason: not valid java name */
    /* synthetic */ int m1571lambda$applyChanges$0$comgooglefirebasefirestorecoreView(DocumentViewChange documentViewChange, DocumentViewChange documentViewChange2) {
        int iCompareIntegers = Util.compareIntegers(changeTypeOrder(documentViewChange), changeTypeOrder(documentViewChange2));
        return iCompareIntegers != 0 ? iCompareIntegers : this.query.comparator().compare(documentViewChange.getDocument(), documentViewChange2.getDocument());
    }

    public ViewChange applyOnlineStateChange(OnlineState onlineState) {
        if (this.current && onlineState == OnlineState.OFFLINE) {
            this.current = false;
            return applyChanges(new DocumentChanges(this.documentSet, new DocumentViewChangeSet(), this.mutatedKeys, false, null));
        }
        return new ViewChange(null, Collections.emptyList());
    }

    private void applyTargetChange(TargetChange targetChange) {
        if (targetChange != null) {
            Iterator<DocumentKey> it2 = targetChange.getAddedDocuments().iterator();
            while (it2.hasNext()) {
                this.syncedDocuments = this.syncedDocuments.insert(it2.next());
            }
            for (DocumentKey documentKey : targetChange.getModifiedDocuments()) {
                Assert.hardAssert(this.syncedDocuments.contains(documentKey), "Modified document %s not found in view.", documentKey);
            }
            Iterator<DocumentKey> it3 = targetChange.getRemovedDocuments().iterator();
            while (it3.hasNext()) {
                this.syncedDocuments = this.syncedDocuments.remove(it3.next());
            }
            this.current = targetChange.isCurrent();
        }
    }

    private List<LimboDocumentChange> updateLimboDocuments() {
        if (!this.current) {
            return Collections.emptyList();
        }
        ImmutableSortedSet<DocumentKey> immutableSortedSet = this.limboDocuments;
        this.limboDocuments = DocumentKey.emptyKeySet();
        for (Document document : this.documentSet) {
            if (shouldBeLimboDoc(document.getKey())) {
                this.limboDocuments = this.limboDocuments.insert(document.getKey());
            }
        }
        ArrayList arrayList = new ArrayList(immutableSortedSet.size() + this.limboDocuments.size());
        for (DocumentKey documentKey : immutableSortedSet) {
            if (!this.limboDocuments.contains(documentKey)) {
                arrayList.add(new LimboDocumentChange(LimboDocumentChange.Type.REMOVED, documentKey));
            }
        }
        for (DocumentKey documentKey2 : this.limboDocuments) {
            if (!immutableSortedSet.contains(documentKey2)) {
                arrayList.add(new LimboDocumentChange(LimboDocumentChange.Type.ADDED, documentKey2));
            }
        }
        return arrayList;
    }

    private boolean shouldBeLimboDoc(DocumentKey documentKey) {
        Document document;
        return (this.syncedDocuments.contains(documentKey) || (document = this.documentSet.getDocument(documentKey)) == null || document.hasLocalMutations()) ? false : true;
    }

    ImmutableSortedSet<DocumentKey> getLimboDocuments() {
        return this.limboDocuments;
    }

    ImmutableSortedSet<DocumentKey> getSyncedDocuments() {
        return this.syncedDocuments;
    }

    /* JADX INFO: renamed from: com.google.firebase.firestore.core.View$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type;

        static {
            int[] iArr = new int[DocumentViewChange.Type.values().length];
            $SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type = iArr;
            try {
                iArr[DocumentViewChange.Type.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type[DocumentViewChange.Type.MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type[DocumentViewChange.Type.METADATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type[DocumentViewChange.Type.REMOVED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static int changeTypeOrder(DocumentViewChange documentViewChange) {
        int i = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type[documentViewChange.getType().ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2 && i != 3) {
                if (i == 4) {
                    return 0;
                }
                throw new IllegalArgumentException("Unknown change type: " + documentViewChange.getType());
            }
        }
        return i2;
    }
}
