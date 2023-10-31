package com.allst.jcore.cos;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 计算余弦相似度
 *
 * @author Hutu
 * @since 2023-10-31 上午 09:27
 */
public class CalcCos {

    /**
     * 计算两个List对应的词频(List为拆词结果)
     *
     * @param wordsList word1的拆词结果
     * @param word2List word2的拆词结果
     *
     * @return 两个词的余弦相似度
     */
    public double calcVector(List<String> wordsList, List<String> word2List) {
        // 合并拆词
        List<String> combineList = Stream.concat(wordsList.stream(), word2List.stream()).distinct().collect(Collectors.toList());
        // 统计wordsList列表词频
        Map<String, Integer> wordMap = Maps.newHashMap();
        for (String s : wordsList) {
            if (wordMap.containsKey(s)) {
                wordMap.put(s, wordMap.get(s) + 1);
            } else {
                wordMap.put(s, 1);
            }
        }
        // 统计words2List列表词频
        Map<String, Integer> word2Map = Maps.newHashMap();
        for (String s : word2List) {
            if (word2Map.containsKey(s)) {
                word2Map.put(s, word2Map.get(s) + 1);
            } else {
                word2Map.put(s, 1);
            }
        }
        // 统计占总词汇的词频
        List<Integer> wsList = Lists.newArrayList();
        List<Integer> dsList = Lists.newArrayList();
        for (String s : combineList) {
            wsList.add(wordMap.getOrDefault(s, 0));
            dsList.add(word2Map.getOrDefault(s, 0));
        }
        // 计算余弦相似度
        return cosSimilarity(wsList, dsList);
    }


    /**
     * 计算两个List对应的余弦相似度
     * a = [ 1，1，2，1，1，1，0，0，0 ]
     * b = [ 1，1，1，0，1，1，1，1，1 ]
     * result = 1 * 1 + 1 *1 + 2 *1 + 1 * 0 + 1 * 1 + 1 * 1 + 0 * 1 + 0 * 1 + 0 * 1 / （√1² + 1² + 2² + 1² + 1² + 1² + 0²+ 0² + 0²）* （√1² + 1² + 1² + 0² + 1² + 1² + 1²+ 1² + 1²）
     *
     * @param va    词频列表a
     * @param vb    词频列表b
     *
     * @return 余弦相似度
     */
    public double cosSimilarity(List<Integer> va, List<Integer> vb) {
        if (va.size() > vb.size()) {
            int temp = va.size() - vb.size();
            for (int i = 0; i < temp; i++) {
                vb.add(0);
            }
        }
        if (va.size() < vb.size()) {
            int temp = vb.size() - va.size();
            for (int i = 0; i < temp; i++) {
                va.add(0);
            }
        }
        int size = va.size();
        double simVal, num = 0, den, powa_sum = 0, powb_sum = 0;
        for (int i = 0; i < size; i++) {
            double a = Double.parseDouble(va.get(i).toString());
            double b = Double.parseDouble(vb.get(i).toString());
            num += a * b;
            powa_sum += Math.pow(a, 2);
            powb_sum += Math.pow(b, 2);
        }
        double sqrta = Math.sqrt(powa_sum);
        double sqrtb = Math.sqrt(powb_sum);
        den = sqrta * sqrtb;
        simVal = num / den;
        return simVal;
    }
}
