# AppLinking Demo

## Introduction

The AppLinking service allows AppLinking. AppLinking are links that work across platforms even on devices where your app is not installed. You can use AppLinking to direct users to promotional information or native app content that they can share with others. You can create AppLinking and send them to users, or users can share AppLinking dynamically generated in your app. Anyone who receives an AppLinking can tap it to access the linked content.

## Preparation

Before using the demo app, prepare your Android development environment.

### Register as a developer.

Register a [HUAWEI account](https://developer.huawei.com/consumer/en/).

### Create an app.

Create an app and set Package type to App (HarmonyOS app).Then enable AppLinking  and adding a URL Prefix by referring the chapter [Creating a Link in AppGallery Connect](https://developer.huawei.com/consumer/en/doc/development/AppGallery-connect-Guides/).

### Build

To build this demo, please first import the demo in the DevEco Studio (2.1+). Then download the file "agconnect-services.json" of the app on AGC, and add the file to the app root directory(\entry) of the demo.

## Environment Requirements

DevEco Studio 2.1 or later.

## Sample Code

Main entry of the app, which processes received links.
Sample code: src\main\java\com\huawei\agconnect\applinking\slice\MainAbilitySlice.java

## License

AppLinking demo is licensed under the [Apache License, version 2.0] (http://www.apache.org/licenses/LICENSE-2.0).