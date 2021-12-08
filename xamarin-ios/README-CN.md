# App Linking Xamarin.iOS CodeLab

## 介绍

此项目是使用AppGallery Connect App Linking Xamarin.iOS SDK开发的CodeLab。

## 环境要求
- 一台可以编译运行Xamarin项目的MAC电脑。

## 使用指南

1. 如果没有华为开发者联盟帐号，需要先[注册账号](https://developer.huawei.com/consumer/cn/doc/start/registration-and-verification-0000001053628148) 并通过实名认证。
2. 使用申请的帐号登录[AppGallery Connect](https://developer.huawei.com/consumer/cn/doc/development/AppGallery-connect-Guides/agc-get-started) 网站创建一个项目并添加iOS应用。
3. 在我的项目中进入新建的项目，选择创建的Android应用，进入“增长”>“App Linking”页面，点击“立即开通”，开启App Linking服务。
4. 点击App Linking页面下的”链接前缀“页面，点击**创建**，创建一个项目专属的链接前缀，将其复制并且粘贴到 [ViewController.cs](./AppLinkingCodelab/ViewController.cs) 文件的 **UriPrefix** 参数中。
5. 点击“项目设置”>“API管理”，开启App Linking。
6. 在项目设置下，点击“常规”页签，下载 **agconnect-services.plist** 文件并且添加到项目路径下。注意需同步修改相应的iOS BundleID。
7. 配置临时签名文件，将该项目运行到Xcode模拟器中。
8. 更多详情请点击[App Linking Xamarin.iOS使用指导](https://developer.huawei.com/consumer/cn/doc/development/AppGallery-connect-Guides/agc-applinking-xamarin-ios-usage-0000001083247709)

## 技术支持

如果您对使用AppGallery Connect示例代码有疑问，请通过如下途径寻求帮助：
- 访问[Stack Overflow](https://stackoverflow.com/) , 在`AppGallery`标签下提问，有华为研发专家在线一对一解决您的问题。
- 访问[华为开发者论坛](https://forums.developer.huawei.com/forumPortal/en/home) AppGallery Connect板块与其他开发者进行交流。

如果您在尝试示例代码中遇到问题，请向仓库提交[issue](https://github.com/AppGalleryConnect/agc-demos/issues) ，也欢迎您提交[Pull Request](https://github.com/AppGalleryConnect/agc-demos/pulls) 。

## 授权许可
该示例代码经过[Apache 2.0 授权许可](http://www.apache.org/licenses/LICENSE-2.0) 。