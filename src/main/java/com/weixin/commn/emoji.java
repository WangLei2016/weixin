package com.weixin.commn;

public class emoji {
	/* emoji表情转换(hex -> utf-16) 
    *  
    * @param hexEmoji 
    * @return 
    */  
   public static String emoji(int hexEmoji) {  
       return String.valueOf(Character.toChars(hexEmoji));  
   }  
}
