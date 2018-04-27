package com.whp.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * 
 * @描述：字符串操作工具类
 *
 * @作者：whp
 * 
 * @时间：2017年5月25日 下午2:24:51
 */
public class StringUtil {

  private final static Logger logger = LoggerFactory.getLogger(StringUtil.class);

  /**
   * 
   * @描述：获取32位UUID
   *
   * @返回：String
   *
   * @作者：whp
   *
   * @时间：2017年8月9日 下午2:59:37
   */
  public static String getUUID() {
    String uuid = UUID.randomUUID().toString();
    uuid = uuid.replaceAll("-", "");
    return uuid;
  }

  /**
   * 
   * @描述：list转字符串，需要传入分隔符
   *
   * @返回：void
   *
   * @作者：whp
   *
   * @时间：2017年9月13日 上午10:03:09
   */
  public static String list2str(List<String> list, String split) {
    if (list == null || list.size() == 0) {
      return null;
    }
    String retStr = "";
    int n = 0;
    for (String s : list) {
      if (n == 0) {
        retStr = s;
      } else {
        retStr += split + s;
      }
      n++;
    }
    return retStr;
  }

  /**
   * 
   * @描述：判断字符串是否全部大写
   *
   * @返回：boolean
   *
   * @作者：whp
   *
   * @时间：2017年10月20日 下午2:10:58
   */
  public static boolean isAllUpperCase(String str) {
    char[] strCharArr = str.toCharArray();
    for (int i = 0; i < strCharArr.length; i++) {
      if (!Character.isDigit(strCharArr[i])) {
        if (!Character.isUpperCase(strCharArr[i])) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * 
   * @描述：接口签名
   *
   * @返回：String
   *
   * @作者：whp
   *
   * @时间：2017年10月23日 下午2:48:20
   */
  public static String getSign(SortedMap<Object, Object> parameters, String secret) {
    StringBuffer sb = new StringBuffer();
    // 所有参与传参的参数按照accsii排序（升序）
    Set<Entry<Object, Object>> set = parameters.entrySet();
    Iterator<Entry<Object, Object>> it = set.iterator();
    while (it.hasNext()) {
      Map.Entry<Object, Object> entry = it.next();
      String k = (String) entry.getKey();
      Object v = entry.getValue();

      if (!StringUtils.isEmpty(v) && !"sign".equals(k)) {
        sb.append(k + "=" + v + "&");
      }
    }
    logger.info("参数：" + sb.toString());
    sb.append("secret=" + secret);
    String sign = EncryptUtil.encryptMD5(sb.toString()).toUpperCase();
    return sign;
  }

  /**
   * 
   * @描述：取N(N>=1)位随机数字
   *
   * @返回：String
   *
   * @作者：whp
   *
   * @时间：2017年10月23日 下午2:48:34
   */
  public static String getNRandom(int n) {
    if (n < 1) {
      return null;
    } else {
      String zero = "";
      for (int i = 0; i < n; i++) {
        zero += "0";
      }
      zero = zero.substring(0, zero.length() - 1);
      String no1Str = "9" + zero;
      String no2Str = "1" + zero;
      int no1 = Integer.parseInt(no1Str);
      int no2 = Integer.parseInt(no2Str);
      int randomc = (int) (Math.random() * no1 + no2);
      return randomc + "";
    }
  }

 


  /**
   * 
   * @描述：获取n个随机字符串
   *
   * @返回：String
   *
   * @作者：whp
   *
   * @时间：2017年12月22日 下午4:14:17
   */
  public static final String randomString(int length) {
    Random randGen = null;
    char[] numbersAndLetters = null;
    Object initLock = new Object();
    if (length < 1) {
      return null;
    }
    if (randGen == null) {
      synchronized (initLock) {
        if (randGen == null) {
          randGen = new Random();
          numbersAndLetters =
              ("JGZYJOSWKCXGPEPKARCACBVCHLDTOMYIXFXUTTLCNBRMFRQBEPPVNGGZREWVTDAIVMCDBFOWRNLFSHSWRTPSFBIVAGIUAUPKVPXA")
                  .toCharArray();
        }
      }
    }
    char[] randBuffer = new char[length];
    for (int i = 0; i < randBuffer.length; i++) {
      randBuffer[i] = numbersAndLetters[randGen.nextInt(100)];
    }
    return new String(randBuffer);
  }

  public static void main(String[] args) throws Exception {
    // 202cb962ac59075b964b07152d234b70
    // SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
    // parameters.put("aa",
    // "EOTYIOOuexCU8CfOH18JBykSFiah4RqBX6VFJLNQTdNqIk3s8XIxdjNZ%2FmaL5TbLl8zMltmaG%2FWmz%2B85XsurT6UpYozxaeU7nDLMiTno5%2FmoEv3EaW65FDzokZ99B1zivvUyA5yBe%2BLih3wpA1oBVN9rg2LUj9x7%2BsFE4A8WoHc%3D");
    // parameters.put("bb",
    // "fVYIeV01MxjmkF6qPG8ccIUfBonkUweh2kyRqexZkyaJEZehZduIMAFtK%2BvuVkS56AjScEIvUABkIcFq88oV5SVSi%2Bn3g80Ua74nOEoU%2F1yX5HCLbA7mJ4OJLsaFbugUf0V3mUGsfT8G0ajLTe3wnC17Vani4TYYk5Fv0VKZIZE%3D");
    // parameters.put("cc", "cccc");
    // parameters.put("timestamp", "1509430871509");
    // parameters.put("token", "91715C30AAFA4254ACEDAC19BB3114ED");
    // System.out.println(getSign(parameters, "9987152585"));
    // date2cron(new Date());
    // System.out.println(DateUtil.datetime2str(cron2date("0 25 13 29 11 ? 2017")));

  }
}
