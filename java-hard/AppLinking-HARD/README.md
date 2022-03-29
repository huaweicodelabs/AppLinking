# App Linking Android CodeLab - hard

## Introduction

This project is a CodeLab for developed using App Linking Android SDK.

## Preparing the Environments
Before using the demo app, prepare your Android development environment.

## Quick Start

1. If you do not have a HUAWEI Developer account, you need to [register an account](https://developer.huawei.com/consumer/en/doc/start/registration-and-verification-0000001053628148) and pass identity verification.
2. Use your account to sign in to [AppGallery Connect](https://developer.huawei.com/consumer/en/doc/development/AppGallery-connect-Guides/agc-get-started).
3. Select your project and app in My projects, and go to "Grow > App Linking" to enable the App Linking service.
4. Select URL Prefix on the App Linking page, click **Add URL prefix** create a project-specific url prefix.
5. Go to General information, download the **agconnect-services.json** file and add it to the "./app" directory of the project directory.
6. Copy the value of **package_name** in the **agconnect-services.json** file to replace the value of **<your_android_package_name>** in the [build.gradle](./app/build.gradle).
7. Set the link prefix obtained in Step 4 to the DOMAIN_URI_PREFIX parameter of the [MainActivity](./app/src/main/java/com/huawei/applinking/hard/codelab/MainActivity.java) and synchronize it to the intent-filter in the [AndroidManifest](./app/src/main/AndroidManifest.xml) file.
8. Run **keytool -list -v -keystore <keystore-file>** to generate the SHA256 value and configure it on the AGC Page.
9. Run the Android project and test the App Linking Function point on your phone.

## Sample Code
app\src\main\java\com\huawei\applinking\hard\codelab\MainActivity.java

## Question or issues

If you have questions about how to use AppGallery Connect Demos, try the following options:
* [Stack Overflow](https://stackoverflow.com/) is the best place for any programming questions. Be sure to tag your question with `AppGallery`.
* [Huawei Developer Forum](https://forums.developer.huawei.com/forumPortal/en/home) AppGallery Module is great for general questions, or seeking recommendations and opinions.


## License
This demo is licensed under the [Apache License, version 2.0](http://www.apache.org/licenses/LICENSE-2.0).
