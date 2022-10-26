package com.backup.backupsystemweb;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface Backuplibrary extends Library {
    public static Backuplibrary backuplibrary = Native.load("../resources/lib_backup.so", Backuplibrary.class);

    int main(int argc, String[] argv);
}
