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
