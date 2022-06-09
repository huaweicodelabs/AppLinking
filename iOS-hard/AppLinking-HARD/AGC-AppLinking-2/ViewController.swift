/*
 * Copyright 2020. Huawei Technologies Co., Ltd. All rights reserved.
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


import UIKit
import AGConnectAppLinking

class ViewController: UIViewController {
    
    var shortAppLinking: String?
    
    let longLinkLabel = UILabel(frame: CGRect(x: 20, y: 180, width: 280, height: 160))
    let shortLinkLabel = UILabel(frame: CGRect(x: 20, y: 380, width: 280, height: 40))
    let resultLinkLabel = UILabel(frame: CGRect(x: 20, y: 510, width: 280, height: 40))

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        self.view.backgroundColor = UIColor.white

        let welcomeLabel = UILabel(frame: CGRect(x: 50, y: 50, width: 200, height: 40))
        welcomeLabel.text = "Welcome to the Codelab"
        welcomeLabel.textColor = UIColor.darkGray
        self.view.addSubview(welcomeLabel)
        
        let createButton = UIButton(frame: CGRect(x: 50, y: 100, width: 200, height: 40))
        createButton.setTitle("Create App Linking", for: .normal)
        createButton.setTitleColor(UIColor.white, for: .normal)
        createButton.backgroundColor = UIColor.blue
        createButton.addTarget(self, action: #selector(createLink), for: .touchUpInside)
        self.view.addSubview(createButton)
        
        let longLabel = UILabel(frame: CGRect(x: 20, y: 150, width: 200, height: 20))
        longLabel.text = "Long App Linking:"
        longLabel.textColor = UIColor.darkGray
        longLabel.font = UIFont.systemFont(ofSize: 15, weight: .bold)
        self.view.addSubview(longLabel)

        longLinkLabel.textColor = UIColor.darkGray
        longLinkLabel.numberOfLines = 0
        longLinkLabel.font = UIFont.systemFont(ofSize: 12)
        self.view.addSubview(longLinkLabel)

        let shortLabel = UILabel(frame: CGRect(x: 20, y: 350, width: 200, height: 20))
        shortLabel.text = "Short App Linking:"
        shortLabel.textColor = UIColor.darkGray
        shortLabel.font = UIFont.systemFont(ofSize: 15, weight: .bold)
        self.view.addSubview(shortLabel)

        shortLinkLabel.textColor = UIColor.darkGray
        shortLinkLabel.numberOfLines = 0
        shortLinkLabel.font = UIFont.systemFont(ofSize: 12)
        self.view.addSubview(shortLinkLabel)
        
        let shareButton = UIButton(frame: CGRect(x: 50, y: 430, width: 200, height: 40))
        shareButton.addTarget(self, action: #selector(shareLink), for: .touchUpInside)
        shareButton.setTitle("Share short App Linking", for: .normal)
        shareButton.setTitleColor(UIColor.white, for: .normal)
        shareButton.backgroundColor = UIColor.blue
        self.view.addSubview(shareButton)

        let resultLabel = UILabel(frame: CGRect(x: 20, y: 480, width: 200, height: 20))
        resultLabel.text = "getLinkingResult:"
        resultLabel.textColor = UIColor.darkGray
        resultLabel.font = UIFont.systemFont(ofSize: 15, weight: .bold)
        self.view.addSubview(resultLabel)

        resultLinkLabel.textColor = UIColor.darkGray
        resultLinkLabel.numberOfLines = 0
        resultLinkLabel.font = UIFont.systemFont(ofSize: 12)
        self.view.addSubview(resultLinkLabel)

    }

    @objc func createLink() {
        let components = AGCAppLinkingComponents()
        components.uriPrefix = "https://codelab.drcn.agconnect.link"
        components.deepLink = "https://developer.huawei.com/consumer/cn"
        components.iosBundleId = Bundle.main.bundleIdentifier
        components.iosDeepLink = "AppLinking://ios/test2=456"
        components.socialTitle = "AppLinking"
        
        longLinkLabel.text = components.buildLongLink().absoluteString
        
        components.buildShortLink { [self] (shortLink, error) in
            if let e = error {
                let alert = UIAlertController.init(title: "Error", message: e.localizedDescription, preferredStyle: .alert)
                alert.addAction(UIAlertAction.init(title: "OK", style: .cancel, handler: nil))
                self.present(alert, animated: true, completion: nil)
                return
            }
            shortAppLinking = shortLink?.url.absoluteString
            shortLinkLabel.text = shortAppLinking
        }
    }

    @objc func shareLink() {
        
        UIPasteboard.general.string = shortAppLinking

    }
    
    func getDeepLink(deeplink: String?) {
        resultLinkLabel.text = deeplink
    }


}

