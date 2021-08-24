// WARNING
//
// This file has been generated automatically by Visual Studio to store outlets and
// actions made in the UI designer. If it is removed, they will be lost.
// Manual changes to this file may not be handled correctly.
//
using Foundation;
using System.CodeDom.Compiler;

namespace AppLinkingCodelab
{
	[Register ("ViewController")]
	partial class ViewController
	{
		[Outlet]
		UIKit.UITextView textLongLink { get; set; }

		[Outlet]
		UIKit.UITextView textShortLink { get; set; }

		[Action ("CreateAppLinking:")]
		partial void CreateAppLinking (UIKit.UIButton sender);

		[Action ("ShareShortLink:")]
		partial void ShareShortLink (UIKit.UIButton sender);
		
		void ReleaseDesignerOutlets ()
		{
			if (textShortLink != null) {
				textShortLink.Dispose ();
				textShortLink = null;
			}

			if (textLongLink != null) {
				textLongLink.Dispose ();
				textLongLink = null;
			}
		}
	}
}
