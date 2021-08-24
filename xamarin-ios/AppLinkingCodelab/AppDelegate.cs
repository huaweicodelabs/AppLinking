using Foundation;
using UIKit;
using Huawei.Agconnect.AgconnectCore;
using Huawei.Agconnect.Applinking;
using System;

namespace AppLinkingCodeLab
{
    // The UIApplicationDelegate for the application. This class is responsible for launching the
    // User Interface of the application, as well as listening (and optionally responding) to application events from iOS.
    [Register("AppDelegate")]
    public class AppDelegate : UIResponder, IUIApplicationDelegate
    {

        [Export("window")]
        public UIWindow Window { get; set; }

        [Export("application:didFinishLaunchingWithOptions:")]
        public bool FinishedLaunching(UIApplication application, NSDictionary launchOptions)
        {
            // Override point for customization after application launch.

            //Initialize the AppGallery Connect SDK in the system startup method.
            AGCInstance.StartUp();

            // Obtain the singleton object.
            AGCAppLinking appLinking = AGCAppLinking.GetSharedInstance();

            // Handle app link receiving.
            appLinking.HandleAppLinking(AppLinkReceivedCallback);

            // If not required for your application you can safely delete this method
            return true;
        }

        private void AppLinkReceivedCallback(AGCResolvedLink link, NSError error)
        {
            if (error != null)
                //Error occured
                Console.WriteLine("Error occured: " + error.Description);

            if (link != null)
            // App link handled.
            {
                //Display alert to show app link detail
                DisplayAlert(link);

                Console.WriteLine("App Link handled");
            }
        }
        private static void DisplayAlert(AGCResolvedLink link)
        {
            string appLinkInfo = $"App Link: {link?.DeepLink}";

            var alert = UIAlertController.Create("App Link Received", appLinkInfo, UIAlertControllerStyle.Alert);
            var defaultAction = UIAlertAction.Create("OK", UIAlertActionStyle.Default, null);
            alert.AddAction(defaultAction);

            (UIApplication.SharedApplication.KeyWindow.RootViewController as UIViewController)?.PresentViewController(alert, true, null);
        }
        // UISceneSession Lifecycle

        [Export("application:configurationForConnectingSceneSession:options:")]
        public UISceneConfiguration GetConfiguration(UIApplication application, UISceneSession connectingSceneSession, UISceneConnectionOptions options)
        {
            // Called when a new scene session is being created.
            // Use this method to select a configuration to create the new scene with.
            return UISceneConfiguration.Create("Default Configuration", connectingSceneSession.Role);
        }

        [Export("application:didDiscardSceneSessions:")]
        public void DidDiscardSceneSessions(UIApplication application, NSSet<UISceneSession> sceneSessions)
        {
            // Called when the user discards a scene session.
            // If any sessions were discarded while the application was not running, this will be called shortly after `FinishedLaunching`.
            // Use this method to release any resources that were specific to the discarded scenes, as they will not return.
        }
    }
}
