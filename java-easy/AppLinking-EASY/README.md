# App Linking Android CodeLab - easy

## Introduction

This project is a CodeLab for developed using App Linking Android SDK.

## Preparing the Environments
Before using the demo app, prepare your Android development environment.

## Quick Start

1. If you do not have a HUAWEI Developer account, you need to [register an account](https://developer.huawei.com/consumer/en/doc/start/registration-and-verification-0000001053628148) and pass identity verification.
2. Use your account to sign in to [AppGallery Connect](https://developer.huawei.com/consumer/en/doc/development/AppGallery-connect-Guides/agc-get-started).
3. Select your project and app in My projects, and go to "Grow > App Linking" to enable the App Linking service.
4. Select URL Prefix on the App Linking page, click **Add URL prefix** create a project-specific url prefix.
5. Click the App Linking tab and create an App Linking link on the AGC page as required.
6. Go to General information, download the **agconnect-services.json** file and add it to the "./app" directory of the project directory.
7. Copy the value of **package_name** in the **agconnect-services.json** file to replace the value of **<your_android_package_name>** in the [build.gradle](./app/build.gradle).
8. Run the Android project to the mobile phone, open the App Linking link created before scanning the QR code of the browser, and start the app,

## Sample Code
app\src\main\java\com\huawei\applinking\easy\codelab\MainActivity.java

## Question or issues

If you have questions about how to use AppGallery Connect Demos, try the following options:
* [Stack Overflow](https://stackoverflow.com/) is the best place for any programming questions. Be sure to tag your question with `AppGallery`.
* [Huawei Developer Forum](https://forums.developer.huawei.com/forumPortal/en/home) AppGallery Module is great for general questions, or seeking recommendations and opinions.


## License
This demo is licensed under the [Apache License, version 2.0](http://www.apache.org/licenses/LICENSE-2.0).
