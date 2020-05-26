package com.ilp3.system.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ilp3.system.entity.TResult;
import com.ilp3.system.entity.TianYanDo;

public class JsonAndJson {
    public static String JsonandJson(JSONObject jsonObject){
        String j = jsonObject.toString();
        TianYanDo tianYanDo = JSON.parseObject(j,TianYanDo.class);
        TResult tResult = tianYanDo.gettResult();
        String regLocation = tResult.getRegLocation();

        return regLocation;
    }

    public static void main(String[] args) {
        TianYanDo tianYanDo = new TianYanDo();
        tianYanDo.setReason("草根");
        tianYanDo.setError_code(4);
        TResult  tResult  = new TResult();
        tResult.setRegLocation("5");
        tianYanDo.settResult(tResult);
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(tianYanDo);
        String xgs = JsonandJson(jsonObject);
        System.out.println(xgs);

    }
}
