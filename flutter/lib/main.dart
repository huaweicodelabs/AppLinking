 // example/lib/main.dart

/*
    Copyright 2020. Huawei Technologies Co., Ltd. All rights reserved.
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/

import 'dart:async';

import 'package:flutter/material.dart';
import 'package:agconnect_crash/agconnect_crash.dart';

void main() {
  FlutterError.onError = AGCCrash.instance.onFlutterError;
  runZonedGuarded<Future<void>>(() async {
    runApp(MyApp());
  }, (Object error, StackTrace stackTrace) {
    AGCCrash.instance.recordError(error, stackTrace);
  });

}


//


class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {


  _MakeCrash() async {
    await AGCCrash.instance.testIt();
  }

  _MakeException() async {
     try {
    throw Exception('test exception');
    } catch (error, stackTrace) {
    AGCCrash.instance.recordError(error, stackTrace);
    }

  }

  _CustomReport() async {
    await AGCCrash.instance.setUserId("testuser");
    await AGCCrash.instance.setCustomKey("stringKey","This is Hello world");
    await AGCCrash.instance.setCustomKey("booleanKey","false");
    await AGCCrash.instance.setCustomKey("doubleKey","1.1");
    await AGCCrash.instance.setCustomKey("floatKey","1.1f");
    await AGCCrash.instance.setCustomKey("intKey","0");
    await AGCCrash.instance.setCustomKey("longKey","11L");
    await AGCCrash.instance.log(level: LogLevel.error, message: "This is  error log level");
    await AGCCrash.instance.log(level: LogLevel.debug, message:  "This is debug log level");
    await AGCCrash.instance.log(level: LogLevel.warning, message:  "This is warning log level");
    await AGCCrash.instance.log(level: LogLevel.info, message:  "This is info log level");

  }


  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Flutter CrashDemo'),
        ),
        body: Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                MaterialButton(onPressed: _MakeCrash, color: Colors.blue, child: Text('MakeCrash', style: TextStyle(color: Colors.white),)),
                MaterialButton(onPressed: _MakeException, color: Colors.blue, child: Text('MakeException', style: TextStyle(color: Colors.white),)),
                MaterialButton(onPressed: _CustomReport, color: Colors.blue, child: Text('CustomReport', style: TextStyle(color: Colors.white),)),
              ],)
        ),
      ),
    );
  }
}