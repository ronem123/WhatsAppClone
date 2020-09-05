package com.gyanko.restringmmptest;

import android.content.Context;

import com.ice.restring.Restring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyStringLoader implements Restring.StringsLoader {
    private Context context;

    public MyStringLoader(Context context) {
        this.context = context;
    }

    @Override
    public List<String> getLanguages() {
        return ConstantMethods.getListOfString(context, "KeyLanguageCodeList");
    }

    @Override
    public Map<String, String> getStrings(String language) {
        Map<String, String> map = new HashMap<>();
        switch (language) {
            case "en": {
                map = ConstantMethods.getHashMap(context, "en");
                break;
            }
            case "ne":{
                map = ConstantMethods.getHashMap(context, "ne");
                break;
            }
            case "in":{
                map = ConstantMethods.getHashMap(context, "in");
                break;
            }
            case "bn" :{
                map = ConstantMethods.getHashMap(context, "bn");
                break;
            }
            case "ms" :{
                map = ConstantMethods.getHashMap(context, "ms");
                break;
            }
            case "my" :{
                map = ConstantMethods.getHashMap(context, "my");
                break;
            }
            case "ta" :{
                map = ConstantMethods.getHashMap(context, "ta");
                break;
            }
            case "zh" :{
                map = ConstantMethods.getHashMap(context, "zh");
                break;
            }
        }
        return map;
    }
}
