package com.h6ah4i.android.widget.advrecyclerview.expandable;

import androidx.core.view.InputDeviceCompat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
class ExpandablePositionTranslator {
    private static final int ALLOCATE_UNIT = 256;
    public static final int BUILD_OPTION_COLLAPSED_ALL = 2;
    public static final int BUILD_OPTION_DEFAULT = 0;
    public static final int BUILD_OPTION_EXPANDED_ALL = 1;
    private static final long FLAG_EXPANDED = 2147483648L;
    private static final long LOWER_31BIT_MASK = 2147483647L;
    private static final long LOWER_32BIT_MASK = 4294967295L;
    private static final long UPPER_32BIT_MASK = -4294967296L;
    private ExpandableItemAdapter mAdapter;
    private int[] mCachedGroupId;
    private long[] mCachedGroupPosInfo;
    private int mEndOfCalculatedOffsetGroupPosition = -1;
    private int mExpandedChildCount;
    private int mExpandedGroupCount;
    private int mGroupCount;

    public void build(ExpandableItemAdapter expandableItemAdapter, int i, boolean z) {
        int groupCount = expandableItemAdapter.getGroupCount();
        boolean z2 = false;
        enlargeArraysIfNeeded(groupCount, false);
        long[] jArr = this.mCachedGroupPosInfo;
        int[] iArr = this.mCachedGroupId;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            boolean z3 = true;
            if (i2 < groupCount) {
                long groupId = expandableItemAdapter.getGroupId(i2);
                int childCount = expandableItemAdapter.getChildCount(i2);
                if (i != 1 && (i == 2 || (!z && !expandableItemAdapter.getInitialGroupExpandedState(i2)))) {
                    z3 = z2;
                }
                long[] jArr2 = jArr;
                jArr2[i2] = ((long) childCount) | (((long) (i2 + i4)) << 32) | (z3 ? FLAG_EXPANDED : 0L);
                iArr[i2] = (int) (LOWER_32BIT_MASK & groupId);
                if (z3) {
                    i3++;
                    i4 += childCount;
                }
                i2++;
                jArr = jArr2;
                z2 = false;
            } else {
                this.mAdapter = expandableItemAdapter;
                this.mGroupCount = groupCount;
                this.mExpandedGroupCount = i3;
                this.mExpandedChildCount = i4;
                this.mEndOfCalculatedOffsetGroupPosition = Math.max(0, groupCount - 1);
                return;
            }
        }
    }

    public void restoreExpandedGroupItems(long[] jArr, ExpandableItemAdapter expandableItemAdapter, RecyclerViewExpandableItemManager.OnGroupExpandListener onGroupExpandListener, RecyclerViewExpandableItemManager.OnGroupCollapseListener onGroupCollapseListener) {
        int i;
        if (jArr == null || jArr.length == 0 || this.mCachedGroupPosInfo == null) {
            return;
        }
        int i2 = this.mGroupCount;
        long[] jArr2 = new long[i2];
        for (int i3 = 0; i3 < this.mGroupCount; i3++) {
            jArr2[i3] = (((long) this.mCachedGroupId[i3]) << 32) | ((long) i3);
        }
        Arrays.sort(jArr2);
        int i4 = 0;
        int i5 = 0;
        while (i4 < jArr.length) {
            long j = jArr[i4];
            int i6 = (int) (j >>> 32);
            boolean z = (j & FLAG_EXPANDED) != 0;
            int i7 = i5;
            while (true) {
                if (i5 >= i2) {
                    i = i4;
                    break;
                }
                long j2 = jArr2[i5];
                i = i4;
                int i8 = (int) (j2 >>> 32);
                int i9 = (int) (j2 & LOWER_31BIT_MASK);
                if (i8 >= i6) {
                    if (i8 != i6) {
                        break;
                    }
                    int i10 = i5 + 1;
                    if (z) {
                        if ((expandableItemAdapter == null || expandableItemAdapter.onHookGroupExpand(i9, false, null)) && expandGroup(i9) && onGroupExpandListener != null) {
                            onGroupExpandListener.onGroupExpand(i9, false, null);
                        }
                    } else if ((expandableItemAdapter == null || expandableItemAdapter.onHookGroupCollapse(i9, false, null)) && collapseGroup(i9) && onGroupCollapseListener != null) {
                        onGroupCollapseListener.onGroupCollapse(i9, false, null);
                    }
                    i7 = i10;
                } else {
                    i7 = i5;
                }
                i5++;
                i4 = i;
            }
            i4 = i + 1;
            i5 = i7;
        }
    }

    public long[] getSavedStateArray() {
        long[] jArr = new long[this.mGroupCount];
        for (int i = 0; i < this.mGroupCount; i++) {
            long j = this.mCachedGroupPosInfo[i];
            jArr[i] = (j & FLAG_EXPANDED) | (((long) this.mCachedGroupId[i]) << 32);
        }
        Arrays.sort(jArr);
        return jArr;
    }

    public int getItemCount() {
        return this.mGroupCount + this.mExpandedChildCount;
    }

    public boolean isGroupExpanded(int i) {
        return (this.mCachedGroupPosInfo[i] & FLAG_EXPANDED) != 0;
    }

    public int getChildCount(int i) {
        return (int) (this.mCachedGroupPosInfo[i] & LOWER_31BIT_MASK);
    }

    public int getVisibleChildCount(int i) {
        if (isGroupExpanded(i)) {
            return getChildCount(i);
        }
        return 0;
    }

    public boolean collapseGroup(int i) {
        long[] jArr = this.mCachedGroupPosInfo;
        long j = jArr[i];
        if ((FLAG_EXPANDED & j) == 0) {
            return false;
        }
        int i2 = (int) (LOWER_31BIT_MASK & j);
        jArr[i] = j & (-2147483649L);
        this.mExpandedGroupCount--;
        this.mExpandedChildCount -= i2;
        this.mEndOfCalculatedOffsetGroupPosition = Math.min(this.mEndOfCalculatedOffsetGroupPosition, i);
        return true;
    }

    public boolean expandGroup(int i) {
        long[] jArr = this.mCachedGroupPosInfo;
        long j = jArr[i];
        if ((j & FLAG_EXPANDED) != 0) {
            return false;
        }
        int i2 = (int) (LOWER_31BIT_MASK & j);
        jArr[i] = j | FLAG_EXPANDED;
        this.mExpandedGroupCount++;
        this.mExpandedChildCount += i2;
        this.mEndOfCalculatedOffsetGroupPosition = Math.min(this.mEndOfCalculatedOffsetGroupPosition, i);
        return true;
    }

    public void moveGroupItem(int i, int i2) {
        if (i == i2) {
            return;
        }
        long j = this.mCachedGroupPosInfo[i];
        int i3 = this.mCachedGroupId[i];
        if (i2 < i) {
            for (int i4 = i; i4 > i2; i4--) {
                long[] jArr = this.mCachedGroupPosInfo;
                int i5 = i4 - 1;
                jArr[i4] = jArr[i5];
                int[] iArr = this.mCachedGroupId;
                iArr[i4] = iArr[i5];
            }
        } else {
            int i6 = i;
            while (i6 < i2) {
                long[] jArr2 = this.mCachedGroupPosInfo;
                int i7 = i6 + 1;
                jArr2[i6] = jArr2[i7];
                int[] iArr2 = this.mCachedGroupId;
                iArr2[i6] = iArr2[i7];
                i6 = i7;
            }
        }
        this.mCachedGroupPosInfo[i2] = j;
        this.mCachedGroupId[i2] = i3;
        int iMin = Math.min(i, i2);
        if (iMin > 0) {
            this.mEndOfCalculatedOffsetGroupPosition = Math.min(this.mEndOfCalculatedOffsetGroupPosition, iMin - 1);
        } else {
            this.mEndOfCalculatedOffsetGroupPosition = -1;
        }
    }

    public void moveChildItem(int i, int i2, int i3, int i4) {
        if (i == i3) {
            return;
        }
        long[] jArr = this.mCachedGroupPosInfo;
        long j = jArr[i];
        int i5 = (int) (j & LOWER_31BIT_MASK);
        int i6 = (int) (LOWER_31BIT_MASK & jArr[i3]);
        if (i5 == 0) {
            throw new IllegalStateException("moveChildItem(fromGroupPosition = " + i + ", fromChildPosition = " + i2 + ", toGroupPosition = " + i3 + ", toChildPosition = " + i4 + ")  --- may be a bug.");
        }
        jArr[i] = (j & (-2147483648L)) | ((long) (i5 - 1));
        long j2 = (jArr[i3] & (-2147483648L)) | ((long) (i6 + 1));
        jArr[i3] = j2;
        if ((jArr[i] & FLAG_EXPANDED) != 0) {
            this.mExpandedChildCount--;
        }
        if ((j2 & FLAG_EXPANDED) != 0) {
            this.mExpandedChildCount++;
        }
        int iMin = Math.min(i, i3);
        if (iMin > 0) {
            this.mEndOfCalculatedOffsetGroupPosition = Math.min(this.mEndOfCalculatedOffsetGroupPosition, iMin - 1);
        } else {
            this.mEndOfCalculatedOffsetGroupPosition = -1;
        }
    }

    public long getExpandablePosition(int i) {
        long packedPositionForGroup = -1;
        if (i == -1) {
            return -1L;
        }
        int i2 = this.mGroupCount;
        int iBinarySearchGroupPositionByFlatPosition = binarySearchGroupPositionByFlatPosition(this.mCachedGroupPosInfo, this.mEndOfCalculatedOffsetGroupPosition, i);
        int i3 = this.mEndOfCalculatedOffsetGroupPosition;
        int i4 = iBinarySearchGroupPositionByFlatPosition == 0 ? 0 : (int) (this.mCachedGroupPosInfo[iBinarySearchGroupPositionByFlatPosition] >>> 32);
        while (iBinarySearchGroupPositionByFlatPosition < i2) {
            long[] jArr = this.mCachedGroupPosInfo;
            long j = jArr[iBinarySearchGroupPositionByFlatPosition];
            jArr[iBinarySearchGroupPositionByFlatPosition] = (((long) i4) << 32) | (LOWER_32BIT_MASK & j);
            if (i4 >= i) {
                packedPositionForGroup = ExpandableAdapterHelper.getPackedPositionForGroup(iBinarySearchGroupPositionByFlatPosition);
            } else {
                i4++;
                if ((FLAG_EXPANDED & j) != 0) {
                    int i5 = (int) (j & LOWER_31BIT_MASK);
                    if (i5 <= 0 || (i4 + i5) - 1 < i) {
                        i4 += i5;
                    } else {
                        packedPositionForGroup = ExpandableAdapterHelper.getPackedPositionForChild(iBinarySearchGroupPositionByFlatPosition, i - i4);
                    }
                }
                i3 = iBinarySearchGroupPositionByFlatPosition;
                iBinarySearchGroupPositionByFlatPosition++;
            }
            this.mEndOfCalculatedOffsetGroupPosition = Math.max(this.mEndOfCalculatedOffsetGroupPosition, iBinarySearchGroupPositionByFlatPosition);
            return packedPositionForGroup;
        }
        iBinarySearchGroupPositionByFlatPosition = i3;
        this.mEndOfCalculatedOffsetGroupPosition = Math.max(this.mEndOfCalculatedOffsetGroupPosition, iBinarySearchGroupPositionByFlatPosition);
        return packedPositionForGroup;
    }

    public int getFlatPosition(long j) {
        int i = -1;
        if (j == -1) {
            return -1;
        }
        int packedPositionGroup = ExpandableAdapterHelper.getPackedPositionGroup(j);
        int packedPositionChild = ExpandableAdapterHelper.getPackedPositionChild(j);
        int i2 = this.mGroupCount;
        if (packedPositionGroup >= 0 && packedPositionGroup < i2) {
            if (packedPositionChild != -1 && !isGroupExpanded(packedPositionGroup)) {
                return -1;
            }
            int iMax = Math.max(0, Math.min(packedPositionGroup, this.mEndOfCalculatedOffsetGroupPosition));
            int i3 = this.mEndOfCalculatedOffsetGroupPosition;
            int i4 = (int) (this.mCachedGroupPosInfo[iMax] >>> 32);
            while (iMax < i2) {
                long[] jArr = this.mCachedGroupPosInfo;
                long j2 = jArr[iMax];
                jArr[iMax] = (((long) i4) << 32) | (LOWER_32BIT_MASK & j2);
                int i5 = (int) (LOWER_31BIT_MASK & j2);
                if (iMax == packedPositionGroup) {
                    if (packedPositionChild == -1) {
                        i = i4;
                    } else if (packedPositionChild < i5) {
                        i = i4 + 1 + packedPositionChild;
                    }
                    this.mEndOfCalculatedOffsetGroupPosition = Math.max(this.mEndOfCalculatedOffsetGroupPosition, iMax);
                } else {
                    i4++;
                    if ((j2 & FLAG_EXPANDED) != 0) {
                        i4 += i5;
                    }
                    i3 = iMax;
                    iMax++;
                }
            }
            iMax = i3;
            this.mEndOfCalculatedOffsetGroupPosition = Math.max(this.mEndOfCalculatedOffsetGroupPosition, iMax);
        }
        return i;
    }

    private static int binarySearchGroupPositionByFlatPosition(long[] jArr, int i, int i2) {
        int i3 = 0;
        if (i <= 0) {
            return 0;
        }
        int i4 = (int) (jArr[0] >>> 32);
        int i5 = (int) (jArr[i] >>> 32);
        if (i2 <= i4) {
            return 0;
        }
        if (i2 >= i5) {
            return i;
        }
        int i6 = 0;
        while (i3 < i) {
            int i7 = (i3 + i) >>> 1;
            if (((int) (jArr[i7] >>> 32)) < i2) {
                i6 = i3;
                i3 = i7 + 1;
            } else {
                i = i7;
            }
        }
        return i6;
    }

    public void removeChildItem(int i, int i2) {
        removeChildItems(i, i2, 1);
    }

    public void removeChildItems(int i, int i2, int i3) {
        long[] jArr = this.mCachedGroupPosInfo;
        long j = jArr[i];
        int i4 = (int) (LOWER_31BIT_MASK & j);
        if (i2 < 0 || i2 + i3 > i4) {
            throw new IllegalStateException("Invalid child position removeChildItems(groupPosition = " + i + ", childPosition = " + i2 + ", count = " + i3 + ")");
        }
        if ((FLAG_EXPANDED & j) != 0) {
            this.mExpandedChildCount -= i3;
        }
        jArr[i] = ((long) (i4 - i3)) | (j & (-2147483648L));
        this.mEndOfCalculatedOffsetGroupPosition = Math.min(this.mEndOfCalculatedOffsetGroupPosition, i - 1);
    }

    public void insertChildItem(int i, int i2) {
        insertChildItems(i, i2, 1);
    }

    public void insertChildItems(int i, int i2, int i3) {
        long[] jArr = this.mCachedGroupPosInfo;
        long j = jArr[i];
        int i4 = (int) (LOWER_31BIT_MASK & j);
        if (i2 < 0 || i2 > i4) {
            throw new IllegalStateException("Invalid child position insertChildItems(groupPosition = " + i + ", childPositionStart = " + i2 + ", count = " + i3 + ")");
        }
        if ((FLAG_EXPANDED & j) != 0) {
            this.mExpandedChildCount += i3;
        }
        jArr[i] = ((long) (i4 + i3)) | (j & (-2147483648L));
        this.mEndOfCalculatedOffsetGroupPosition = Math.min(this.mEndOfCalculatedOffsetGroupPosition, i);
    }

    public int insertGroupItems(int i, int i2, boolean z) {
        if (i2 <= 0) {
            return 0;
        }
        enlargeArraysIfNeeded(this.mGroupCount + i2, true);
        ExpandableItemAdapter expandableItemAdapter = this.mAdapter;
        long[] jArr = this.mCachedGroupPosInfo;
        int[] iArr = this.mCachedGroupId;
        int i3 = i - 1;
        int i4 = i3 + i2;
        for (int i5 = (this.mGroupCount - 1) + i2; i5 > i4; i5--) {
            int i6 = i5 - i2;
            jArr[i5] = jArr[i6];
            iArr[i5] = iArr[i6];
        }
        long j = z ? FLAG_EXPANDED : 0L;
        int i7 = i + i2;
        int i8 = 0;
        int i9 = i;
        while (i9 < i7) {
            long groupId = expandableItemAdapter.getGroupId(i9);
            int childCount = expandableItemAdapter.getChildCount(i9);
            jArr[i9] = ((long) childCount) | (((long) i9) << 32) | j;
            iArr[i9] = (int) (LOWER_32BIT_MASK & groupId);
            i8 += childCount;
            i9++;
            expandableItemAdapter = expandableItemAdapter;
            i3 = i3;
        }
        int i10 = i3;
        int i11 = this.mGroupCount + i2;
        this.mGroupCount = i11;
        if (z) {
            this.mExpandedGroupCount += i2;
            this.mExpandedChildCount += i8;
        }
        this.mEndOfCalculatedOffsetGroupPosition = Math.min(this.mEndOfCalculatedOffsetGroupPosition, i11 == 0 ? -1 : i10);
        return z ? i2 + i8 : i2;
    }

    public int insertGroupItem(int i, boolean z) {
        return insertGroupItems(i, 1, z);
    }

    public int removeGroupItems(int i, int i2) {
        int i3;
        if (i2 <= 0) {
            return 0;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            long j = this.mCachedGroupPosInfo[i + i5];
            if ((FLAG_EXPANDED & j) != 0) {
                int i6 = (int) (j & LOWER_31BIT_MASK);
                i4 += i6;
                this.mExpandedChildCount -= i6;
                this.mExpandedGroupCount--;
            }
        }
        int i7 = i4 + i2;
        this.mGroupCount -= i2;
        int i8 = i;
        while (true) {
            i3 = this.mGroupCount;
            if (i8 >= i3) {
                break;
            }
            long[] jArr = this.mCachedGroupPosInfo;
            int i9 = i8 + i2;
            jArr[i8] = jArr[i9];
            int[] iArr = this.mCachedGroupId;
            iArr[i8] = iArr[i9];
            i8++;
        }
        this.mEndOfCalculatedOffsetGroupPosition = Math.min(this.mEndOfCalculatedOffsetGroupPosition, i3 == 0 ? -1 : i - 1);
        return i7;
    }

    public int removeGroupItem(int i) {
        return removeGroupItems(i, 1);
    }

    private void enlargeArraysIfNeeded(int i, boolean z) {
        int i2 = (i + 511) & InputDeviceCompat.SOURCE_ANY;
        long[] jArr = this.mCachedGroupPosInfo;
        int[] iArr = this.mCachedGroupId;
        long[] jArr2 = (jArr == null || jArr.length < i) ? new long[i2] : jArr;
        int[] iArr2 = (iArr == null || iArr.length < i) ? new int[i2] : iArr;
        if (z) {
            if (jArr != null && jArr != jArr2) {
                System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
            }
            if (iArr != null && iArr != iArr2) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            }
        }
        this.mCachedGroupPosInfo = jArr2;
        this.mCachedGroupId = iArr2;
    }

    public int getExpandedGroupsCount() {
        return this.mExpandedGroupCount;
    }

    public int getCollapsedGroupsCount() {
        return this.mGroupCount - this.mExpandedGroupCount;
    }

    public boolean isAllExpanded() {
        return !isEmpty() && this.mExpandedGroupCount == this.mGroupCount;
    }

    public boolean isAllCollapsed() {
        return isEmpty() || this.mExpandedGroupCount == 0;
    }

    public boolean isEmpty() {
        return this.mGroupCount == 0;
    }
}
