package com.abyte.wanandroid.base;

import com.google.gson.reflect.TypeToken;
import com.abyte.wanandroid.utils.GsonUtils;

/**
 * Created by geyan on 2018/9/29
 */
public class BaseObject {

    public String toGson() {
        return GsonUtils.toJson(this);
    }

    public static <T extends BaseObject> T buildObject(String jsonStr, TypeToken<T> typeToken) {
        return GsonUtils.fromJson(jsonStr,typeToken.getType());
    }
}
