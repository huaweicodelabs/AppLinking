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
using System;
using Android.App;
using Android.OS;
using Android.Runtime;
using Android.Views;
using AndroidX.AppCompat.App;
using Android.Widget;
using Huawei.Agconnect.Applinking;
using Uri = Android.Net.Uri;
using Debug = System.Diagnostics.Debug;
using Android.Content;

namespace AppLinkingCodeLab
{
    [Activity(Name = "com.company.app.MainActivity", Label = "@string/app_name", Theme = "@style/AppTheme", MainLauncher = true)]
    public class MainActivity : AppCompatActivity
    {
        protected override async void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            Xamarin.Essentials.Platform.Init(this, savedInstanceState);
            SetContentView(Resource.Layout.activity_main);

            FindViewById<Button>(Resource.Id.create).Click += CreateAppLinkAsync;
            FindViewById<Button>(Resource.Id.shareShort).Click += ShareShortAppLink_Click;

            try
            {
                // To receive links, initialize the AGConnectAppLinking instance.
                AGConnectAppLinking appLinkInstance = AGConnectAppLinking.Instance;

                // Call GetAppLinkingAsync to check for links of App Linking to be processed.
                ResolvedLinkData resolvedLinkData = await appLinkInstance.GetAppLinkingAsync(this);

                // Get App Linking data.
                Uri deepLink = resolvedLinkData.DeepLink;

                FindViewById<TextView>(Resource.Id.linking_info).Text = "get Linking success, the deepLink: " + deepLink.ToString();

            }
            catch (Exception ex)
            {
                Debug.WriteLine("Error: " + ex.ToString());
            }
        }

        private void ShareShortAppLink_Click(object sender, EventArgs e)
        {
            string agcLink = FindViewById<TextView>(Resource.Id.shortLinkText).Text;
            Intent intent = new Intent(Intent.ActionSend);
            intent.SetType("text/plain");
            intent.PutExtra(Intent.ExtraText, agcLink);
            intent.AddFlags(ActivityFlags.NewTask);
            StartActivity(intent);
        }

        private async void CreateAppLinkAsync(object sender, EventArgs e)
        {
            string UriPrefix = "<your_AppLinking_URL_Prefix>";
            string OpenDeep_Link = "https://developer.huawei.com";
            string AndroidDeep_Link = "androidlink://developer.huawei.com/consumer/cn";

            AppLinking.Builder builder = new AppLinking.Builder();

            // Set URL Prefix
            builder.SetUriPrefix(UriPrefix);
            // Set Deep Link
            builder.SetDeepLink(Uri.Parse(OpenDeep_Link));

            //Set the link preview type. If this method is not called, the preview page with app information is displayed by default.
            builder.SetPreviewType(AppLinking.LinkingPreviewType.AppInfo);

            // Set Android link behavior (Optional)
            // If this parameters not set, the link will be opened in the Android browser by default.
            var androidLinkInfo = new AppLinking.AndroidLinkInfo.Builder();
            androidLinkInfo.SetAndroidDeepLink(AndroidDeep_Link);
            androidLinkInfo.SetOpenType(AppLinking.AndroidLinkInfo.AndroidOpenType.AppGallery);
            builder.SetAndroidLinkInfo(androidLinkInfo.Build());

            // obtain the long link.
            FindViewById<TextView>(Resource.Id.longLinkText).Text = builder.BuildAppLinking().Uri.ToString();
            // obtain the short link.
            try
            {
                ShortAppLinking link = await builder.BuildAppShortLinkingAsync(ShortAppLinking.LENGTH.Short);
                FindViewById<TextView>(Resource.Id.shortLinkText).Text = link.ShortUrl.ToString();
            }
            catch (Exception ex)
            {
                Debug.WriteLine("Error: " + ex.ToString());
            }

        }

        public override bool OnCreateOptionsMenu(IMenu menu)
        {
            MenuInflater.Inflate(Resource.Menu.menu_main, menu);
            return true;
        }

        public override bool OnOptionsItemSelected(IMenuItem item)
        {
            int id = item.ItemId;
            if (id == Resource.Id.action_settings)
            {
                return true;
            }

            return base.OnOptionsItemSelected(item);
        }


        public override void OnRequestPermissionsResult(int requestCode, string[] permissions, [GeneratedEnum] Android.Content.PM.Permission[] grantResults)
        {
            Xamarin.Essentials.Platform.OnRequestPermissionsResult(requestCode, permissions, grantResults);

            base.OnRequestPermissionsResult(requestCode, permissions, grantResults);
        }
	}
}
