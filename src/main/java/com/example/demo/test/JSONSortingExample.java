package com.example.demo.test;

import com.alibaba.fastjson.JSONObject;

import java.util.Comparator;
import java.util.TreeMap;

public class JSONSortingExample {

    public static void main(String[] args) {
        // 原始 JSON 数据
        String jsonStr = "{\"$config\":[{\"label\":\"容重\",\"field\":\"mp-bulkDensity\",\"isSku\":true,\"required\":false,\"homeDic\":false,\"value\":null,\"isInfluencePrice\":null},{\"label\":\"水分含量（%）\",\"field\":\"mp-moistureContent\",\"isSku\":true,\"required\":false,\"homeDic\":false,\"value\":null,\"isInfluencePrice\":null},{\"label\":\"杂质含量（%）\",\"field\":\"mp-impurityContent\",\"isSku\":true,\"required\":false,\"homeDic\":false,\"value\":null,\"isInfluencePrice\":null},{\"label\":\"不完善颗粒（%）\",\"field\":\"mp-notGoogGrain\",\"isSku\":true,\"required\":false,\"homeDic\":false,\"value\":null,\"isInfluencePrice\":null},{\"label\":\"霉变粒含量（%）\",\"field\":\"mp-moldyContent\",\"isSku\":true,\"required\":false,\"homeDic\":false,\"value\":null,\"isInfluencePrice\":null},{\"label\":\"色泽气味\",\"field\":\"mp-colorAndOdor\",\"isSku\":true,\"required\":false,\"homeDic\":false,\"value\":null,\"isInfluencePrice\":null},{\"label\":\"包装\",\"field\":\"mp-package\",\"isSku\":true,\"required\":false,\"homeDic\":false,\"value\":null,\"isInfluencePrice\":null},{\"label\":\"产地\",\"field\":\"mp-originPlace\",\"isSku\":false,\"required\":false,\"homeDic\":false,\"value\":null,\"isInfluencePrice\":null},{\"label\":\"等级\",\"field\":\"mp-level\",\"isSku\":true,\"required\":false,\"homeDic\":\"material_level\",\"value\":null,\"isInfluencePrice\":1},{\"label\":\"粮食年份\",\"field\":\"mp-grainYear\",\"isSku\":true,\"required\":false,\"homeDic\":false,\"value\":null,\"isInfluencePrice\":null},{\"label\":\"其他指标\",\"field\":\"mp-others\",\"isSku\":false,\"required\":false,\"homeDic\":false,\"value\":null,\"isInfluencePrice\":null}],\"mp-bulkDensity\":\"rz\",\"mp-moistureContent\":\"sfhl\",\"mp-impurityContent\":\"zzhl\",\"mp-notGoogGrain\":\"bwskl\",\"mp-moldyContent\":\"mbhl\",\"mp-colorAndOdor\":\"szqw\",\"mp-package\":\"bz\",\"mp-originPlace\":null,\"mp-level\":10,\"mp-grainYear\":\"1998\",\"mp-others\":null}";

        // 将 JSON 数据转换为 TreeMap
        TreeMap<String, Object> treeMap1 = new TreeMap<>(new KeyComparator());
        TreeMap<String, Object> treeMap = new TreeMap<>(new KeyComparator());
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        jsonObject.remove("$config");
        treeMap.putAll(jsonObject);
        jsonObject.keySet().forEach(key -> treeMap1.put(key, jsonObject.get(key)));

        // 将排序后的 TreeMap 转换为 JSON 数据
        JSONObject sortedJsonObject = new JSONObject(treeMap);
        String sortedJsonStr = sortedJsonObject.toString();

        System.out.println(sortedJsonStr);
    }

    // 定义比较器，按键的字母顺序排序
    static class KeyComparator implements Comparator<String> {
        @Override
        public int compare(String key1, String key2) {
            return key1.compareTo(key2);
        }
    }
}