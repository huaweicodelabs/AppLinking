/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React from 'react';
import AgcAppLinking from '@react-native-agconnect/applinking';
import {Alert, Clipboard, Image, Linking, ScrollView, StyleSheet, Text, View} from 'react-native';
import {Colors} from 'react-native/Libraries/NewAppScreen';


export default class App extends React.Component {

  constructor(props) {
      super(props)
      this.state = {
          customViews: []
      }
  }


  buildAppLinkingObject() {
    /** socialCardInfo object is optional. **/
    const socialCardInfo = {
      "description": "SOME_DESCRIPTION",
      "title": "SOME_TITLE",
  }

  /** campaignInfo object is optional. **/
  const campaignInfo = {
      "medium": "MEDIUM",
      "name": "NAME",
      "source": "SOURCE"
  }

  /** androidLinkInfo object is optional. **/
  const androidLinkInfo = {
      "packageName": "<your_android_package_name>",    //replace your Android packageName.
      "androidDeepLink": "androidlink://developer.huawei.com/consumer/cn",
      "openType": AgcAppLinking.AppLinkingAndroidLinkInfoAndroidOpenTypeConstants.APP_GALLERY
  }
  /** IOSLinkInfo object is optional. **/
  const IOSLinkInfo = {
      "iosBundleId": "<your_ios_package_name>", //replace your iOS BundleId.
      "iosDeepLink": "ioslink://developer.huawei.com/consumer/cn",
  }

  /** ITunesLinkInfo object is optional. **/
  const ITunesLinkInfo = {
      "iTunesConnectMediaType": "iTunesConnectMediaType",
      "iTunesConnectAffiliateToken": "iTunesConnectAffiliateToken"
  }

  /**
   * In building short link, domainUriPrefix & deepLink fields are mandatory, other params are optional.
   **/
  const UriPrefix =  "<your_AppLinking_URL_Prefix>" //replace your url prefix here.
  const deepLink = "https://developer.huawei.com/consumer/cn"
  const appLinkingobject = {
      "shortAppLinkingLength": AgcAppLinking.ShortAppLinkingLengthConstants.SHORT,
      "domainUriPrefix": UriPrefix,//Add your url prefix here.
      "deepLink": deepLink,
    //   "androidLinkInfo": androidLinkInfo,
    //   "IOSLinkInfo": IOSLinkInfo,
    //   "socialCardInfo": socialCardInfo,
    //   "campaignInfo": campaignInfo,
    //   "ITunesLinkInfo": ITunesLinkInfo,
      "previewType": AgcAppLinking.AppLinkingLinkingPreviewTypeConstants.APP_INFO
  }
  return appLinkingobject
}

  buildShortAppLinking() {
    const object = this.buildAppLinkingObject();
    AgcAppLinking.buildShortAppLinking(object).then(result => {
        Alert.alert(
            "[buildShortAppLinking] ",
            JSON.stringify(result),
            [
                {
                    text: "Copy Short Link", onPress: () => {
                        Clipboard.setString(result.shortLink)
                    }
                }
            ],
            {cancelable: true}
        );
        this.createCustomView("buildShortAppLinking :  ", JSON.stringify(result.shortLink) + "")
    }).catch((err) => {
        Alert.alert("[buildShortAppLinking] Error/Exception: " + JSON.stringify(err));
        this.createCustomView("[buildShortAppLinking] Error/Exception: ", JSON.stringify(err) + "")
    });
  }


  buildLongAppLinking() {
    const object = this.buildAppLinkingObject();
    AgcAppLinking.buildLongAppLinking(object).then(result => {
        Alert.alert(
          "[buildLongAppLinking]" ,
          JSON.stringify(result),
          [
           {
                text: "Copy Long Link", onPress: () => {
                  Clipboard.setString(result)
                }
            }
        ],
        {cancelable: true}
        );
        this.createCustomView("buildLongAppLinking :  ", JSON.stringify(result) + "")
    }).catch((err) => {
        Alert.alert("[buildLongAppLinking] Error/Exception: " + JSON.stringify(err));
        this.createCustomView("[buildLongAppLinking] Error/Exception: ", JSON.stringify(err) + "")
    });
 }

 componentDidMount() {
    this.getAGConnectAppLinkingResolvedLinkData()
  }
  getAGConnectAppLinkingResolvedLinkData() {
      AgcAppLinking.getAGConnectAppLinkingResolvedLinkData().then(result => {
          Alert.alert("[getAGConnectAppLinkingResolvedLinkData] " + JSON.stringify(result));
          
          this.createCustomView("getAGConnectAppLinkingResolvedLinkData :  ", JSON.stringify(result) + "")
      }).catch((err) => {
          Alert.alert("Normal Startup");
          this.createCustomView("Normal Startup")
      });
  }

  createCustomView(title, description) {
      var view = (
          <View key={title + description} style={styles.resultView}>
              <Text style={[styles.txt, {width: 110, textAlign: "left"}]}>{title}</Text>
              <Text style={[styles.txt, {
                  color: Colors.dark,
                  textAlign: 'left',
                  width: 186,
                  marginLeft: 5
              }]}>{description}</Text>
          </View>
      )
      var views = []
      views.push(view)
      this.setState({customViews: views})
  }

  render() {
    return (
        <>
            <View style={styles.header}>
                <Text style={styles.title}>AGC CodeLab AppLinking RN</Text>
            </View>
            <ScrollView
                style={styles.scrollView}>
                <View style={styles.body}>
                <View style={styles.sectionContainer}>
                          <Text style={styles.sectionTitle}>
                              Creating a Link of App Linking in Your App
                          </Text>
                          <Text
                              style={styles.button}
                              onPress={() => {
                                  this.buildShortAppLinking()
                              }
                              }>
                              buildShortAppLinking
                          </Text>
                          <Text
                              style={styles.button}
                              onPress={() => {
                                  this.buildLongAppLinking()
                              }
                              }>
                              buildLongAppLinking
                          </Text>
                          <Text
                              style={styles.button}
                              onPress={() => {
                                  this.getAGConnectAppLinkingResolvedLinkData()
                              }
                              }>
                              getAGConnectAppLinkingResolvedLinkData
                          </Text>
                      </View>
                    <Text style={[styles.title]}> Results </Text>
                    {this.state.customViews}
                    <View style={{height: 70, width: '100%'}}/>
                </View>
            </ScrollView>
          </>
      )
  }
}


const styles = StyleSheet.create({
    scrollView: {
        backgroundColor: Colors.lighter,
    },
    header: {
        height: 140,
        width: '100%',
        backgroundColor: '#222222',
        flexDirection: 'row',
        paddingLeft: 20,
        alignItems: 'center'
    },
    title: {
        fontSize: 20,
        fontWeight: 'bold',
        color: Colors.white,
        margin: 20,
        marginTop: 50,
        textAlign: 'center',
        width: '40%',
    },
    button: {
        fontSize: 20,
        color: Colors.white,
        margin: 20,
        textAlign: 'center',
        marginTop: 20,
        backgroundColor: '#0b1528',
        borderRadius: 10,
        marginLeft: 5,
        marginRight: 5
    },
    logo: {
        height: '100%',
        width: '60%'
    },
    txt: {
        fontSize: 14,
        color: '#00ffad',
        textAlign: 'center'
    },
    resultView: {
        flexDirection: 'row',
        width: 250,
        alignSelf: 'center',
        marginLeft: 5,
        marginRight: 5,
        marginTop: 20
    },
    engine: {
        position: 'absolute',
        right: 0
    },
    body: {
        backgroundColor: Colors.white,
    },
    sectionContainer: {
        marginTop: 32,
        paddingHorizontal: 24,
    },
    sectionTitle: {
        fontSize: 24,
        fontWeight: '600',
        color: Colors.black,
    },
    sectionDescription: {
        marginTop: 8,
        fontSize: 18,
        fontWeight: '400',
        color: Colors.dark,
    },
    highlight: {
        fontWeight: '700',
    },
    footer: {
        color: Colors.dark,
        fontSize: 12,
        fontWeight: '600',
        padding: 4,
        paddingRight: 12,
        textAlign: 'right',
    },
  });
  
  