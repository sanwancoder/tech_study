package com.example.test.questions;

/**
 * @author yejingxuan
 */
public class QuestionOne {

    public static void main(String[] args) {
        Integer systemIn = -2;
        QuestionOne questionOne = new QuestionOne();
        Integer res = questionOne.reverse(systemIn);
        System.out.println(res);
    }

    public Integer reverse(Integer systemIn) {
        Integer res = 0;

        if (0 <= systemIn && systemIn < 10) {
            return systemIn;
        }

        Integer systemInAbs = Math.abs(systemIn);
        String systemInStr = systemInAbs.toString();
        StringBuilder systemInStrTemp = new StringBuilder(systemInStr);
        StringBuilder reverseStr = systemInStrTemp.reverse();

        if (systemIn > 0) {
            res = Integer.valueOf(reverseStr.toString());
        } else if (systemIn < 0) {
            res = -Integer.valueOf(reverseStr.toString());
        }
        return res;
    }

}
