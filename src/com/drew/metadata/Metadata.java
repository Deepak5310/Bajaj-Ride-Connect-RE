package com.drew.metadata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class Metadata {
    private final List<Directory> _directories = new ArrayList();

    public Iterable<Directory> getDirectories() {
        return this._directories;
    }

    public <T extends Directory> Collection<T> getDirectoriesOfType(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        for (Directory directory : this._directories) {
            if (cls.isAssignableFrom(directory.getClass())) {
                arrayList.add(directory);
            }
        }
        return arrayList;
    }

    public int getDirectoryCount() {
        return this._directories.size();
    }

    public <T extends Directory> void addDirectory(T t) {
        this._directories.add(t);
    }

    public <T extends Directory> T getFirstDirectoryOfType(Class<T> cls) {
        Iterator<Directory> it2 = this._directories.iterator();
        while (it2.hasNext()) {
            T t = (T) it2.next();
            if (cls.isAssignableFrom(t.getClass())) {
                return t;
            }
        }
        return null;
    }

    public boolean containsDirectoryOfType(Class<? extends Directory> cls) {
        Iterator<Directory> it2 = this._directories.iterator();
        while (it2.hasNext()) {
            if (cls.isAssignableFrom(it2.next().getClass())) {
                return true;
            }
        }
        return false;
    }

    public boolean hasErrors() {
        Iterator<Directory> it2 = getDirectories().iterator();
        while (it2.hasNext()) {
            if (it2.next().hasErrors()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        int directoryCount = getDirectoryCount();
        return String.format("Metadata (%d %s)", Integer.valueOf(directoryCount), directoryCount == 1 ? "directory" : "directories");
    }
}
