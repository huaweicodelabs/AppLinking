# App Linking Xamarin.iOS CodeLab

## Introduction

This project is a CodeLab for developed using App Linking Xamarin.iOS SDK.

## Preparing the Environments
* A computer can compile and run Xamarin project

## Quick Start

1. If you do not have a HUAWEI Developer account, you need to [register an account](https://developer.huawei.com/consumer/en/doc/start/registration-and-verification-0000001053628148) and pass identity verification.
2. Use your account to sign in to [AppGallery Connect](https://developer.huawei.com/consumer/en/doc/development/AppGallery-connect-Guides/agc-get-started), create a project and add an iOS app.
3. Select your project and app in My projects, and go to "Grow > App Linking" to enable the App Linking service.
4. Select URL Prefix on the App Linking page, click **Add URL prefix** create a project-specific url prefix, copy and paste it into the **UriPrefix** parameter in the  [ViewController.cs](./AppLinkingCodelab/ViewController.cs)  file.
5. Select Project Settings, and go to Manage APIs, enable the App Linking Service.
6. Go to General information, download the **agconnect-services.plist** file and add it to the Projece directory. Note that you need to change the iOS BundleID accordingly.
7. Configuring the Temporary Signature File, and run the project into the Xcode simulator.
8. More details about [App Linking Xamarin iOS Usage](https://developer.huawei.com/consumer/cn/doc/development/AppGallery-connect-Guides/agc-applinking-xamarin-ios-usage-0000001083247709) 。

## Question or issues

If you have questions about how to use AppGallery Connect Demos, try the following options:
* [Stack Overflow](https://stackoverflow.com/) is the best place for any programming questions. Be sure to tag your question with `AppGallery`.
* [Huawei Developer Forum](https://forums.developer.huawei.com/forumPortal/en/home) AppGallery Module is great for general questions, or seeking recommendations and opinions.

If you run into a bug in our samples, please submit an [issue](https://github.com/AppGalleryConnect/agc-demos/issues) to the Repository. Even better you can submit a [Pull Request](https://github.com/AppGalleryConnect/agc-demos/pulls) with a fix.

## License
This demo is licensed under the [Apache License, version 2.0](http://www.apache.org/licenses/LICENSE-2.0).
