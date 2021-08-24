/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

// Wait for the deviceready event before using any of Cordova's device APIs.
// See https://cordova.apache.org/docs/en/latest/cordova/events/events.html#deviceready
const $ = (x) => document.getElementById(x);

let shortLinkResult = "";
let longLinkResult = "";
let resolvedLinkDataResult = "";
document.addEventListener("deviceready", onDeviceReady, false);

function onDeviceReady() {
  // Cordova is now initialized. Have fun!

  // console.log('Running cordova-' + cordova.platformId + '@' + cordova.version);
  // document.getElementById('deviceready').classList.add('ready');
  var parentElement = $("deviceready");
  var listeningElement = parentElement.querySelector(".listening");
  var receivedElement = parentElement.querySelector(".received");

  listeningElement.setAttribute("style", "display:none;");
  receivedElement.setAttribute("style", "display:block;");

  $('AGConnectAppLinkingResolvedLinkDataResult').innerHTML = "AGConnectAppLinkingResolvedLinkDataResult";
  console.log("resolvedLinkDataResult");
  AGCAppLinking.addListener(
    AGCAppLinking.Events.RECEIVE_LINK,
    (resolvedLinkDataResult) => {
      this.resolvedLinkDataResult = resolvedLinkDataResult;
      console.log(
        "resolvedLinkDataResult" +
        JSON.stringify(resolvedLinkDataResult, null, 1)
      );
      $("AGConnectAppLinkingResolvedLinkDataResult").innerHTML = JSON.stringify(this.resolvedLinkDataResult ,null, 1);
    }
  );

}


function buildAppLinkingObject() {
  const socialCardInfo1 = {
    description: "description of long link",
    title: "title of social card",

  };
  const campaignInfo1 = {
    medium: "JULY",
    name: "summer campaign",
    source: "Huawei",
  };
  const androidLinkInfo1 = {
    androidDeepLink: "androidlink://developer.huawei.com/consumer/cn",
    androidPackageName: "<your_android_package_name>"",
    androidOpenType:
      AGCAppLinking.AppLinkingAndroidLinkInfoAndroidOpenTypeConstants
        .APP_GALLERY,
  };
  const iosLinkInfo1 = {
    iosDeepLink: "ioslink://developer.huawei.com/consumer/cn",
    iosFallbackUrl: "https://swift.org/",
    iosBundleId: "<your_ios_package_name>",
    //ipadFallbackUrl: '',
    //ipadBundleId: '',
  };
  const iTunesConnectCampaingnInfo1 = {
    iTunesConnectProviderToken: "iTunesConnectProviderToken1",
    iTunesConnectCampaignToken: "iTunesConnectCampaignToken1",
    iTunesConnectAffiliateToken: "iTunesConnectAffiliateToken1",
    iTunesConnectMediaType: "iTunesConnectMediaType1",
  };
  const appLinkingobject = {
    // socialCardInfo: socialCardInfo1,
    // campaignInfo: campaignInfo1,
    androidLinkInfo: androidLinkInfo1,
    // iosLinkInfo: iosLinkInfo1,
    // iTunesConnectCampaingnInfo: iTunesConnectCampaingnInfo1,
    previewType:
      AGCAppLinking.AppLinkingLinkingPreviewTypeConstants.SOCIAL_INFO,
    uriPrefix: "your_AppLinking_URL_Prefix>",
    deepLink: "https://developer.huawei.com/consumer/cn",
  };
  return appLinkingobject
};

$("buildLongLink").onclick = () => {
  const appLinkingWithInfo = this.buildAppLinkingObject();
  AGCAppLinking.buildLongLink(appLinkingWithInfo)
    .then((longLinkResult) => {
      this.longLinkResult = longLinkResult;
      $("longLinkResult").innerHTML = JSON.stringify(longLinkResult, null, 1);
    })
    .catch(function (err) {
      alert("buildLongLink -> Error : " + JSON.stringify(err, null, 1));
    });
};

$("buildShortLink").onclick = () => {
  const appLinkingWithInfo = this.buildAppLinkingObject();
  AGCAppLinking.buildShortLink(appLinkingWithInfo)
    .then((shortLinkResult) => {
      this.shortLinkResult = shortLinkResult;
      $("shortLinkResult").innerHTML = JSON.stringify(shortLinkResult, null, 1);
    })
    .catch(function (err) {
      alert("buildShortLink -> Error : " + JSON.stringify(err, null, 1));
    });
};


$("copyShortLink").onclick = () => {
  if (this.shortLinkResult.shortLink) {
    textToClipboard(this.shortLinkResult.shortLink);
    alert("Copied shortLink to clipboard.");
  } else {
    alert("Please build shortLink.");
  }
};

function textToClipboard(text) {
  var dummy = document.createElement("textarea");
  document.body.appendChild(dummy);
  dummy.value = text;
  dummy.select();
  document.execCommand("copy");
  document.body.removeChild(dummy);
}
