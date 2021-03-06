package org.fdroid.fdroid.mock;

import org.fdroid.fdroid.data.Apk;
import org.fdroid.fdroid.data.App;

public class MockApk extends Apk {

    public MockApk(String id, int versionCode) {
        this.packageName = id;
        this.versionCode = versionCode;
    }

    public MockApk(String id, int versionCode, String repoAddress, String apkName) {
        this.packageName = id;
        this.versionCode = versionCode;
        this.repoAddress = repoAddress;
        this.apkName = apkName;
    }

    public MockApk(App app, int versionCode) {
        this.appId = app.getId();
        this.versionCode = versionCode;
    }

    public MockApk(long appId, int versionCode) {
        this.appId = appId;
        this.versionCode = versionCode;
    }

}
