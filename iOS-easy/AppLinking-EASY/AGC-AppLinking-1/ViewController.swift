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

    let deeplinkLabel = UILabel(frame: CGRect(x: 60, y: 250, width: 200, height: 60))

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        self.view.backgroundColor = UIColor.white
        
        let welcomeLabel = UILabel(frame: CGRect(x: 60, y: 100, width: 200, height: 60))
        welcomeLabel.textColor = UIColor.darkGray
        welcomeLabel.text = "Welcome to the Codelab"
        self.view.addSubview(welcomeLabel)

        let tipLabel = UILabel(frame: CGRect(x: 60, y: 200, width: 200, height: 60))
        tipLabel.font = UIFont.systemFont(ofSize: 16, weight: .bold)
        tipLabel.text = "deeplink:"
        self.view.addSubview(tipLabel)

        deeplinkLabel.textColor = UIColor.darkGray
        deeplinkLabel.numberOfLines = 0
        self.view.addSubview(deeplinkLabel)

    }
    
    func getDeepLink(deeplink: String?) {
        deeplinkLabel.text = deeplink
    }
     
}

