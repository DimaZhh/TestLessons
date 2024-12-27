package org.base;

import org.ui.conf.ReadPropertyFile;

public class BaseTestClass {

    private static ReadPropertyFile readPropertyFile = new ReadPropertyFile();

    public static ReadPropertyFile getReadPropertyFile() {
        return readPropertyFile;
    }
}
