# AppLinking Demo

## 简介

AppLinking服务允许AppLinking。AppLinking是跨平台工作的链接，即使在未安装应用程序的设备上也是如此。您可以使用AppLinking将用户引导到他们可以与他人共享的促销信息或本机应用程序内容。您可以创建AppLinking并将其发送给用户，也可以共享在您的应用程序中动态生成的AppLinking。任何收到AppLinking的人都可以点击它访问链接的内容。

## 准备

在使用演示应用程序之前，请准备好Android开发环境。

### 注册成为开发者

注册一个 [华为账号](https://developer.huawei.com/consumer/en/).

### 创建应用

创建应用，类型选择APK（Android应用），然后打开AppLinking，并参考章节添加URL前缀。 [Creating a Link in AppGallery Connect](https://developer.huawei.com/consumer/en/doc/development/AppGallery-connect-Guides/).

### 构建

要构建此demo，请首先在Android Studio (3.x+)中导入演示。 然后在AGC上下载应用的文件“agconnect-services.json”，并将该文件添加到演示的应用根目录（\app）中。

## 环境要求

Android Studio 3.0 或以上.

## 示例代码

应用的主入口，处理接收到的链接。
示例代码: src\main\java\com\huawei\applinkingdemo\MainActivity.java

## 证书许可

AppLinking demo is 在 [Apache License, version 2.0] (http://www.apache.org/licenses/LICENSE-2.0) 下获得许可。
