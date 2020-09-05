package com.gyanko.restringmmptest

import com.chibatching.kotpref.KotprefModel

/**
 * Created by munnadroid on 10/29/17.
 */
object UserInfo : KotprefModel() {
    var pinSetupStatus by booleanPref(default = false)
    var firstLaunchStatus by booleanPref(default = false)
    var deviceKey by stringPref(default = "")
    var refreshToken by stringPref(default = "")
    var oldDeviceIdentifier by stringPref(default = "")
    var isNotificationActive by booleanPref(default = false)
    var deviceIdentifier by stringPref(default = "")
    var fullName by stringPref(default = "")
    var phoneNumber by stringPref(default = "")
    var crn by stringPref(default = "")
    var hasPasscode by booleanPref(default = false)
    var fcmToken by stringPref(default = "")
    var fcmTokenSendStatus by booleanPref(default = false)
    var languageCode by stringPref(default = "en")
//    var previousLanguageCode by stringPref(default = "en")
    var languagePosition by intPref(default = 0)
    var alreadyRegisteredUser by booleanPref(default = false)
    var isFirstLoggedInSuccess by booleanPref(default = false)

    var otpRefString by stringPref(default = "")

    /*User ID for virtual Registration*/
    var userID by stringPref(default = "")

    /*For Profile*/
    var profileImageURI by stringPref(default = "")
    var walletSize by stringPref(default = "")

    /*For Language*/
    var languageVersion by stringPref(default = "0")

    /*For Branch Locator*/
    var isAllATMDialogShown by booleanPref(default = false)


    /*For Sdk*/
    var mmRemitLanguageVersion by stringPref(default = "0")
    var wasApiForMMRemitEligible by booleanPref(default = false)

    var userIsRejected by booleanPref(default = false)

    /*flag set when user is to topup via register and further proceed to create passcode*/
    var isUserFromRegisterToCreatePasscode by booleanPref(default = false)

    /* Flag for security phrase*/
    var isSecurityPhraseSet by booleanPref(default = false)

    /*Flag for security phrase enabled for dynamic check from BO*/
    var isSecurityPhraseEnabled by booleanPref(default = false)
}
