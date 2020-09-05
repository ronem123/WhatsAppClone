package com.gyanko.restringmmptest.kotlin

/**
 * Created by munnadroid on 6/15/17.
 */

val KEY_CHANGE_PIN = "key_change_pin"
val OTP_VERIFICATION_TYPE = "otp_verification_type"

val KEY_URL = "key_url"
val KEY_TITLE = "key_title"
val FPX_HTML_STRING = "fpx_html_string"
val KEY_OTP_INTENT = "KeyOTPIntent"
val KEY_FPX_TYPE = "key_fpx_type"
val KEY_INTRO_INTENT = "KeyIntroIntent"
val KEY_VALIDATE_DETAIL = "KeyValidateDetail"
val KEY_MAILING_ADDRESS = "KeyMailingAddress"
val KEY_NATIONALITY = "KeyNationality"
val KEY_IDENTIFICATION_TYPE = "KeyIdentification"
val KEY_RESIDNETIAL_ADDRESS = "KeyResidentialAddress"
val KEY_VIRTUAL_CARD_RESPONSE = "KeyVirtualCardRespopnse"
const val KEY_FILE = "KeyFile"
const val KEY_REQUEST_CODE = "KeyRequestType"
val KEY_NEGATIVE_LIST = "KeyNegativeList"

val KEY_LANGUAGE_LIST = "KeyLanguageList"
val KEY_LAANGUAGE_CODE_LIST = "KeyLanguageCodeList"
val KEY_MCOUPON_ENABLED = "KeyMCouponEnabled"
const val REQUEST_CHECK_SETTINGS: Int = 1112

const val KEY_DIGITAL_MONEY_PACKET_ID = "KeyDigitalMoneyPacketID"
const val KEY_CARD_INFO = "KeyCardInfo"
const val KEY_CONTACT_LIST = "KeyContactList"
const val KEY_ALREADY_SELECTED_CONTACT_LIST = "AlreadySelectedContactList"
const val KEY_EXTRA_AMOUNT_VALUE = "AlreadyExtraAmountValue"

const val KEY_SPLIT_BILL_TRANSACTION = "KeySplitBillTransaction"

const val KEY_VIRTUAL_OTP_VERIFY_RESPONSE = "KeyVirtualOtpVerifyResponse"
const val KEY_VIRTUAL_OTP_VERIFY_RESPONSE_USER_DETAILS = "KeyVirtualOtpVerifyResponseUserDetails"


object EVENT_TRACKING {
    val AMOUNT_VALUE = "amount_value"
    val BANK = "bank"
    val TOP_UP = "top_up"
    val MOBILE_NUMBER = "mobile_number"
    val CARD_TO_CARD = "card_to_card"
    val CURRENCY_SELECTED = "currency_selected"
    val BUY_SELL = "buy_sell"
    val CURRENCY_EXCHANGE = "currency_exchange"
    val CHECK_RATE = "check_rate"
    val START_SIGNUP = "initiate_registration"
    val SUCCESS_SIGNUP = "success_signup"
    val COUNTRY_SELECTED = "country_selected"
    val INTERNATIONAL_RELOAD = "international_reload"
    val DOMESTIC_RELOAD = "domestic_reload"


    /*Online Registration*/
    /*OTP_CONTIUNE*/
    val OTP_CONTINUE = "otp_continue"
    val PHONE_NUMBER = "phone_number"

    /*FORM_NEXT*/
    val FULL_NAME = "full_name"
    val IDENTIFICATION_NUMBER = "identification_number"
    val EMBOSSED_CARD_LAST_NAME = "embossed_card_last_name"
    val DATE_OF_BIRTH = "date_of_birth"
    val NATIONALITY_CODE = "nationality_code"
    val IDENITIFCATION_TYPE_CODE = "identification_type_code"
    val PURPOSE_OF_CARD_CODE = "purpose_of_card_code"
    val EMAIL_ADDRESS = "email_address"
    val TITLE_CODE = "title_code"
    val OCCUPATION_CODE = "occupation_code"
    val UNEMPLOYED_CODE = "unemployed_code"
    val MOTHER_MAIDED_NAME = "mother_maiden_name"
    val REFERRAL_CODE = "referral_code"
    val SOURCE_CODE_VALUE = "source_code_value"
    val NATURE_OF_BUISNESS_ID = "nature_of_buisness_id"
    val OPT_IN_MARKETING = "opt_in_marketing"
    val MAILING_ADDRESS_DETAILS = "mailing_address_details"
    val RESIDENTIAL_ADDRESS_DETAILS = "residential_address_details"
    val ADDRESS = "address"
    val ADDRESS_1 = "address_1"
    val COUNTRY_CODE = "country_code"
    val POSTAL_CODE = "postal_code"
    val TOWN = "town"
    val STATE = "state"

    val FORM_NEXT = "form_next"

    /*DOC_NEXT*/
    val FORM_ID = "form_id"
    val IDMISSION_DATA = "idmission_data"

    val DOC_NEXT = "doc_next"

    /*TOPUP_LOAD*/
    val TOPUP_LOAD = "topup_load"
    val PROVIDER_ID = "provider_id"
    val USER_ID = "user_id"

    val REQUEST_OTP = "request_otp"
    val DOCUMENT_NEXT = "ic_image"
    val SELFIE_NEXT = "selfie_image"
    val PERSONAL_DETAILS = "personal_details"
    val DETAIL_SUBMIT = "details_submit"
    val ALMOST_THERE = "almost_there"
    val REGISTRATION_COMPLETE = "registration_completed"
    val CONFIRM_PASSCODE = "Confirm_passcode"
    val OTP_VERIFIED = "otp_verified"
    val IMAGE_TAKING_COMPLETE = "image_completed"
    val OTHER_NAT_COMPLETED = "other_nat_completed"
    val PERSONAL_DETAILS_P2 = "personal_details_P2"
    val PERSONAL_DETAILS_P3 = "personal_details_P3"
    val PERSONAL_DETAILS_P4 = "personal_details_P4"

    val INITIATE_OCR_FRONT = "initiate_OCR_front"
    val INITIATE_OCR_BACK = "initiate_OCR_back"
    val INITIATE_SELFIE = "initiate_selfie"

    /*Deeplink*/
    val DEEPLINK_EVENT = "deepLink"
    val DEVICE_IDENTIFIER = "deviceIdentifier"
    val DEEPLINK_SOURCE = "deepLink_source"
    val DEEPLINK_URL = "deeplink"
}