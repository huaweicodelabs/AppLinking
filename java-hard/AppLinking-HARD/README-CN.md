# App Linking Android CodeLab - easy

## 介绍

此项目是使用AppGallery Connect App Linking Android SDK开发的CodeLab。

## 环境要求
- 一台可以编译运行Android项目的计算机。

## 使用指南

1. 如果没有华为开发者联盟帐号，需要先[注册账号](https://developer.huawei.com/consumer/cn/doc/start/registration-and-verification-0000001053628148) 并通过实名认证。
2. 使用申请的帐号登录[AppGallery Connect](https://developer.huawei.com/consumer/cn/doc/development/AppGallery-connect-Guides/agc-get-started) 。
3. 在我的项目中进入新建的项目，选择创建的Android应用，进入“增长”>“App Linking”页面，点击“立即使用”，开启App Linking服务。
4. 点击App Linking页面下的”链接前缀“页面，点击**创建**，创建一个项目专属的链接前缀。
5. 左侧找到“项目设置”，下载 **agconnect-services.json** 文件并且添加到项目目录的 ”./app“ 路径下。
6. 复制 **agconnect-services.json** 文件中的 “package_name” 对应的值，将其替换 [build.gradle](./app/build.gradle) 文件中的 **<your_android_package_name>** 参数。
7. 将步骤4中申请的链接前缀，配置到[MainActivity](./app/src/main/java/com/huawei/applinking/hard/codelab/MainActivity.java) 的DOMAIN_URI_PREFIX参数中，并且同步修改到[AndroidManifest](./app/src/main/AndroidManifest.xml) 文件的intent-filter中。
8. 执行 **keytool -list -v -keystore <keystore-file>** 命令生成SHA256指纹证书，并且将其配置到AGC页面上。
9. 运行该Android项目，并且在手机中测试App Linking功能点。

## Sample Code
app\src\main\java\com\huawei\applinking\hard\codelab\MainActivity.java


## 技术支持

如果您对使用AppGallery Connect示例代码有疑问，请通过如下途径寻求帮助：
- 访问[Stack Overflow](https://stackoverflow.com/) , 在`AppGallery`标签下提问，有华为研发专家在线一对一解决您的问题。
- 访问[华为开发者论坛](https://forums.developer.huawei.com/forumPortal/en/home) AppGallery Connect板块与其他开发者进行交流。


## 授权许可
该示例代码经过[Apache 2.0 授权许可](http://www.apache.org/licenses/LICENSE-2.0) 。
