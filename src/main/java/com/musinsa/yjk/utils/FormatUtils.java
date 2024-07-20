package com.musinsa.yjk.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class FormatUtils {
    private static DecimalFormat priceFormat = new DecimalFormat("#,###");

    public static String bigDecimalToString(BigDecimal sellPrice){
        return priceFormat.format(sellPrice);
    }
}
