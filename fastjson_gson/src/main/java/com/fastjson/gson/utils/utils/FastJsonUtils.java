package com.fastjson.gson.utils.utils;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouwei on 2018/8/29.
 */
public class FastJsonUtils {
    /**
     * 按章节点得到相应的内容
     *
     * @param jsonString json字符串
     * @param note       节点
     * @return 节点对应的内容
     */
    public static String getNoteJson(String jsonString, String note) {
        if (!TextUtils.isEmpty(jsonString) && !TextUtils.isEmpty(note)) {
            try {
                JSONObject object = JSONObject.parseObject(jsonString);
                return object.getString(note);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    /**
     * 把相对应节点的内容封装为对象
     *
     * @param jsonString json字符串
     * @param beanClazz  要封装成的目标对象
     * @return 目标对象
     */
    public static <T> T parserObject(String jsonString, String note, Class<T> beanClazz) {
        if (jsonString != null) {
            String noteJson = getNoteJson(jsonString, note);
            T object = JSON.parseObject(noteJson, beanClazz);
            return object;
        }
        return null;
    }

    /**
     * 按照节点得到节点内容，转化为一个数组
     *
     * @param jsonString json字符串
     * @param beanClazz  集合里存入的数据对象
     * @return 含有目标对象的集合
     */
    public static <T> List<T> parserArray(String jsonString, String note, Class<T> beanClazz) {
        if (!TextUtils.isEmpty(jsonString) && !TextUtils.isEmpty(note)) {
            List<T> objects = new ArrayList<T>();
            String noteJson = getNoteJson(jsonString, note);
            if (!TextUtils.isEmpty(noteJson)) {
                objects = JSON.parseArray(noteJson, beanClazz);
            } else {
                return null;
            }

            return objects;
        }
        return null;
    }

    /**
     * 把对象转化为json字符串
     *
     * @param obj 要转化的对象
     * @return 返回json字符串
     */
    public static String toJsonString(Object obj) {
        if (obj != null) {
            return JSON.toJSONString(obj);
        } else {
            throw new RuntimeException("对象不能为空");
        }
    }

    public static <T> T jsonString2Bean(String jsonString, Class<T> beanClazz) {
        if (jsonString == null) {
            return null;
        }
        T object = JSON.parseObject(jsonString, beanClazz);
        return object;
    }

    /**
     * 把jsonString转化为多个bean对象数组
     *
     * @param jsonString
     * @param beanClazz
     * @return
     */
    public static <T> List<T> jsonString2Beans(String jsonString, Class<T> beanClazz) {
        if (jsonString == null) {
            return null;
        }
        List<T> objects = new ArrayList<T>();
        objects = JSON.parseArray(jsonString, beanClazz);
        return objects;
    }
}
