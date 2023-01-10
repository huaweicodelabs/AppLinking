/*
 * Copyright 2021. Huawei Technologies Co., Ltd. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
using Foundation;
using Huawei.Agconnect.Applinking;
using System;
using System.Threading.Tasks;
using UIKit;

namespace AppLinkingCodelab
{
    public partial class ViewController : UIViewController
    {
        public ViewController(IntPtr handle) : base(handle)
        {
        }

        public override void ViewDidLoad()
        {
            base.ViewDidLoad();
            // Perform any additional setup after loading the view, typically from a nib.
        }

        public override void DidReceiveMemoryWarning()
        {
            base.DidReceiveMemoryWarning();
            // Release any cached data, images, etc that aren't in use.
        }


        partial void ShareShortLink(UIKit.UIButton sender)
        {
            Console.WriteLine("Share the short AppLinking");

            var items = new NSObject[] { (NSString)textShortLink.Text };
            var shareDalog = new UIActivityViewController(items, null);
            this.PresentViewController(shareDalog, true, null);
        }

        private AGCAppLinkingComponents appLinkingComponent;

        partial void CreateAppLinking(UIKit.UIButton sender)
        {
            Console.WriteLine("CreateAppLinking");
            appLinkingComponent = new AGCAppLinkingComponents
            {
                // Set URL Prefix
                UriPrefix = "<your_AppLinking_URL_Prefix>",
                // Set Deep Link
                DeepLink = "https://developer.huawei.com/consumer/cn/",

                //Set the link preview type. If this method is not called, the preview page with app information is displayed by default.
                PreviewType = AGCLinkingPreviewType.AppInfo
            };

            // Set Android app parameters. (Optional)
            appLinkingComponent.AndroidDeepLink = ("androidlink://developer.huawei.com/consumer/cn/");
            appLinkingComponent.AndroidPackageName = "<your_Android_packageName>";
            appLinkingComponent.AndroidOpenType = AGCLinkingAndroidOpenType.AppGallery;

            // Set iOS app parameters. (Optional)
            appLinkingComponent.IosBundleId = "<your_iOS_BundleID>";
            appLinkingComponent.IosDeepLink = "ioslink://developer.huawei.com/consumer/cn/";

            // Create AppLinking
            CreateShortAppLink();
            CreateLongAppLink();
        }

        public async void CreateShortAppLink()
        {
            //Build a short link
            Task<AGCShortAppLinking> shortLinkTask = appLinkingComponent.BuildShortLinkAsync();
            AGCShortAppLinking result = await shortLinkTask;
            if (shortLinkTask.IsCompleted && result != null)
            {
                NSUrl shortLink = result.Url;
                textShortLink.Text = shortLink.AbsoluteString;
                Console.WriteLine("The ShortLink is: " + shortLink.AbsoluteString);
            }
        }

        public void CreateLongAppLink()
        {
            //Build a long link
            NSUrl longLink = appLinkingComponent.BuildLongLink();
            textLongLink.Text = longLink.AbsoluteString;
        }
    }
}
