package com.gyanko.restringmmptest;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by munnadroid on 2/16/17.
 */

public class Constants {

    /**
     * API base Main URL
     * SIT URL = https://demo.merchantrademoney.com:9443
     * UAT URL = https://demo.merchantrademoney.com
     * Production URL = https://www.merchantrademoney.com
     */

    public static final String TITLE = "title";
    public static final String AD_CATEGORY = "ad_category";
    public static final String MAIN_URL = "BuildConfig.MainUrl";
    public static final String BASE_URL = MAIN_URL + "/api/";
    public static final String FPX_BASE_URL = MAIN_URL;
    public static final String ADVERTISEMENT_IMAGE_BASE = MAIN_URL;

    //Language version
    public static int LATEST_LANGUAGE_VERSION = 700;
    public static int LATEST_LANGUAGE_VERSION_MMREMIT = 700;

    //for sellOrBuyMode
    public static final int MODE_BUY = 0;
    public static final int MODE_SELL = 1;


    //  Note: this is the Karsof API id assigned to MerchanTrade
    public static String KARSOF_API_ID = "995";
    public static String KARSOF_CUSTOMER_ID = UserInfo.INSTANCE.getCrn();
    public static String KARSOF_PHONE_NUMBER = "+9779841068278";

    public static final String API_VERSION = "24";
    public static final int APP_FORCE_UPDATE_ERROR_CODE = 420;
    public static final int APP_LANGUATE_UPDATE_CODE = 440;

    public static final String COUNTRY_FLAG_URL = "/images/flags/";
    public static final String CUSTOMER_CARE_EMAIL = "customerservice@merchantrademoney.com";

    public static final String FAQ_URL = MAIN_URL + "/help/faq/";
    public static final String ABOUT_US_URL = MAIN_URL + "/about-us/";
    public static final String TERMS_AND_CONDITION = MAIN_URL + "/wp-content/uploads/2019/01/MM-Cardholder-Agreement_181126-clean-copy.pdf";
    public static final String PRIVACY_POLICY = MAIN_URL + "/wp-content/themes/merchant_trade/assets/pdf/privacy-notice-merchantrade-asia-ecard.pdf";
    public static final String PRODUCT_DISCLOSURE = MAIN_URL + "/wp-content/uploads/2019/01/MM-Product-Disclosure-Sheet-181126-clean-copy-1.pdf";

    public static final String REFRESH_REQUEST_URL = "mobile/token/refresh";

    public static final String DEVICE_TYPE = "Android";
    public static final String PASSCODE_INTENT = "passcodeIntent";
    public static final String PASSCODE_VALUE = "passcode_vlaue";
    public static final String PASSCODE_STATUS = "passcode_status";
    public static final String ADVERTISEMENT_INTENT_DATA = "advertisement_intent_data";
    public static final String OTP_INTENT = "otp_intent";
    public static final String NOTIFICATION_INTENT_DATA = "notification_intent_data";
    public static final String LOGOUT_BROADCAST_ACTION = "com.mta.mmremit.logout";

    public static final String BALANCE_INFORMATION_INTENT_DATA = "balance_information_intent_data";
    public static final String CURRENCY_DETAIL_LIST_INTENT_DATA = "currency_detail_list_intent_data";
    public static final String CURRENCY_DETAIL_INTENT_DATA = "currency_detail_intent_data";
    public static final String FEATURE_ID_INTENT_DATA_KEY = "feature_id";

    public static final String NOTICE_TO_CUSTOMER_URL = "https://www.merchantrademoney.com/wp-content/uploads/2020/02/Customer-Notice.pdf";


    public static class MERCHANTS_URL {
        public static final String MY_DIN = "http://www.mydin.com.my";
        public static final String I_PRICE = "http://www.iprice.my";
        public static final String ELEVEN_STREET = "http://promotion.11street.my/2018/01/get-your-horoscope";
        public static final String CATCH_THE_BUS = "https://www.catchthatbus.com/";
        public static final String GRAB = "https://grab.onelink.me/2695613898?pid=MerchantTrade&af_dp=grab%3A%2F%2Fopen%3FscreenType%3DBOOKING&af_web_dp=https%3A%2F%2Fwww.grab.com%2Fdownload&is_retargeting=true";
        public static final String KLIA_EXPRESS = "https://goo.gl/iq5xw8";
        public static final String OBIKE = "http://o.bike/my";
        public static final String AXA = "https://www.axa.com.my/";
        public static final String KK_BOX = "https://www.kkbox.com";
        public static final String BOLT = "http://bd.bolt.global";
        public static final String TRAVEE = "http://www.travee.travel/TRV/B2C/index.aspx";
    }

    public static class LANGUAGE_ID {
        public static final int ENGLISH = 100;
        public static final int MALAYSIAN = 101;
        public static final int INDONESIAN = 102;
        public static final int BENGALI = 103;
        //        public static final int HINDI = 104;
        public static final int NEPALI = 105;
        public static final int TAMIL = 106;
    }

    public static class NOTIFICATION_FCM {
        public static final String IMAGE = "image";
        public static final String MESSAGE = "message";
        public static final String TITLE = "title";
        public static final String TYPE = "type";
        public static final String ID = "id";
    }

    public static final String NOTIFICATION_INTENT = "notification_ntent";
    public static final String SETTINGS_INTENT = "settings_intent";
    public static final String NOTIFICATION_MESSAGE_TYPE = "notification_message_type";
    public static final String NOTIFICATION_ID = "notification_id";
    public static final String VIEW_TYPE_INTENT = "view_type_intent";
    public static final String WEB_VIEW_TYPE_INTENT = "web_view_type_intent";
    public static final int IMAGE_CAPTURE_REQUEST = 1000;
    public static final int IMAGE_SELECT_REQUEST = 1001;
    public static final String PROFILE_IMAGE_URI = "profile_image_uri";
    public static final String TOP_UP_REFERENCE_NO = "top_up_reference_number";

    public static final String SPLIT_BILL_NOTIFICATION_ID = "split_bill_notification_id";

    public static class LANGUAGE_CODE {
        public static final String ENGLISH = "en";
        public static final String MALAYSIAN = "ms";//malay
        public static final String INDONESIAN = "id";
        public static final String BENGALI = "bn";
        //        public static final String HINDI = "hi";
        public static final String NEPALI = "ne";
        public static final String TAMIL = "ta";
    }

    public static class THEME {
        public static final int VANILLA_ICE = 0;
        public static final int PINK_LADY = 1;
    }

    public static final String BRANCH_LOCATOR_INTENT_DATA = "branch_locator_data";
    public static final String SELECTED_BRANCH_ID = "selected_branch_id";
    public static final String KEY_BRANCH_TYPE = "key_branch_type";
    public static final String KEY_SIGN_UP_COMPLETE = "key_sign_up_complete";
    public static final String KEY_LOGIN_RESPONSE = "key_login_response";
    public static final String KEY_TERMINATED_BODY = "key_terminated_body";
    public static final String KEY_TERMINATED_DATE = "key_terminated_date";

    public static final int REQUEST_CODE_PICK_CONTACTS = 1;
    public static final int REQUEST_CODE_PICK_CONTACTS_MULTIPLE = 2;
    public static final String GET_ONLY_NUMERIC_VALUE_REGEX = "[^A-Za-z0-9 ]";

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static final int NAV_BRANCH_LOCATION_POSITION = 7;//prev was 4
    public static final int NAV_LOGOUT_POSITION = 11;
    public static final int NAV_SETTING_POSITION = 9;//prev was 5
    public static final int NAV_NOTIFICATION_POSITION = 3;

    public static final String NotificationChannelId = "com.eightsquare.eremit.ANDROID";
    public static final String NotificationChannelName = "ANDROID CHANNEL";
    public static final String NOTIFICATION_GROUP_NAME = "MTA MONEY NOTIFICATION GROUP";
    public static final int SUMMARY_NOTIFCATION_ID = 0;

    public static class COUNTRY_CODE_ISO {
        public static final String MALAYSIA = "MY";
    }

    public static class VIRTUAL_REGISTRATION_URL {
        public static final String PRODUCT_DISCLOSURE = "http://www.merchantrademoney.com/product_disclosure.html";
        public static final String TERMS_AND_CONDITIONS = "http://www.merchantrademoney.com/terms_and_conditions.html";
        public static final String PRIVACY_POLICY = "http://www.merchantrademoney.com/privacy_notice.html";
        public static final String FPX_TERMS_AND_CONDITIONS = "https://www.mepsfpx.com.my/FPXMain/termsAndConditions.jsp";
    }

    // Location Updates
    public static class LOCATION_UPDATES {
        // The minimum distance to change Updates in meters
        public static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters
        // The minimum time between updates in milliseconds
        public static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute
    }

    public static final String NOTIFICATION_MCW_KEY = "MCW";
    public static final String NOTIFICATION_NOTIFICATION_KEY = "NotificationList";
    public static final String NOTIFICATION_DIGITAL_MONEY_PACKET_KEY = "DigitalMoneyPacket";
    public static final String NOTIFICATION_MMREMIT_KEY = "MMRemitHistory";
    public static final String NOTIFICATION_SPLIT_BUILD_KEY = "SplitBill";
    public static final String NOTIFICATION_REQUEST_MONEY_KEY = "RequestMoney";
    public static final String NOTIFICATION_REQUEST_VOUCHERTOPUP_KEY = "MerchantTopup";

    /*To redirect back to notification List*/
    public static final String SPLIT_BILL_NOTIFICATION_DETAILS_NOTIFICATION_KEY = "SplitBillNotificationDetailsNotificationKey";

    //mcoupon constants
    public static final String SUB_TITLE = "sub_title";
    public static final String STATUS_MESSAGE = "status_message";
    public static final String COUPON_PURCHAHSE_REFERENCE = "coupon_purchase_reference_number";
    public static final String COUPON_PRODUCT_NAME = "coupon_product_name";
    public static final String COUPON_CODE = "coupon_code";
    public static final String MOBILE_PRODUCT_ID = "mobile_product_id";
    public static final String IS_FROM_MY_VOUCHER = "is_from_my_voucher";
    public static final String IS_FROM_HISTORY = "is_from_history";

    public static final String DEFAULT_TAG = "tag";
    public static final String NEAR_BY_ME_TAG = "near";

    public static class Query {
        public final static String CATEGORY_ID = "categoryid";
        public final static String SUB_CATEGORY_ID = "subcategoryid";
        public final static String PAGE_NO = "pageno";
        public final static String PAGE_SIZE = "pagesize";
        public final static String LATITUDE = "lat";
        public final static String LONGITUDE = "lng";
        public final static String SEARCH_TAG = "searchkey";

    }

    public static class BROADCAST_INTENT_FILTERS {
        public final static String ACTION_CLOSE = "close_page";
        public final static String ACTION_HISTORY_PAGE_RECEIVER = "history_page_receiver";
        public final static String TERMINATED = "broad_cast_intent_filter_terminated";
    }

    public static class EFESTIVE_METHOD {
        public final static String EQUALLY_DISTRIBUTED = "1";
        public final static String RANDOM = "2";
    }

    public static class ATX {
        public final static String MCOUPON_KEY = "Mcoopon";
    }

    public static class OPEN_VIEW {
        public static int TRANSACTION_HISTORY_VIEW = 0;
    }


    public static class RequestMoney {
        public static final String REQUEST_MONEY_TXN_REFERENCE_NO = "request_money_txn_reference_no";
        public static final String REQUEST_MONEY_TXN_AMOUNT = "request_money_txn_amount";
        public static final String REQUEST_MONEY_TXN_PURPOSE = "request_money_txn_purpose";
        public static final String REQUEST_MONEY_TXN_RECIPIENT = "request_money_txn_recipient";
    }

    public static class SecurityPhrase {
        public static final String KEY_SECURITY_PHRASE_OTP_REF = "key_security_phrase_otp_ref";
        public static final String KEY_SECURITY_PHRASE = "key_security_phrase";
    }

    public static class IntentKey {
        public static final String OTP = "intent_key_otp";
        public static final String REFERENCE_NO = "intent_key_reference_no";
        public static final String SECURITY_PHRASE_UPDATE_REQUEST_BODY = "intent_key_security_phrase_update_request_body";
        public static final String IS_SECONDARY_NUMBER_LOGIN = "intent_key_is_secondary_number_login";
        public static final String NATIONALITY = "intent_key_nationality";
        public static final String ID_TYPE = "intent_key_id_type";
        public static final String ERROR_MSG = "intent_key_error_message";

    }


}
