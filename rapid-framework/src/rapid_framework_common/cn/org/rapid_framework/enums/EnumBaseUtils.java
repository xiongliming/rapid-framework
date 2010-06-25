package cn.org.rapid_framework.enums;

import java.util.LinkedHashMap;
/**
 * 枚举工具类
 * 
 * @author badqiu
 */
@SuppressWarnings("unchecked")
public class EnumBaseUtils {

    public static  <T extends EnumBase> LinkedHashMap toMap(T[] values) {
        LinkedHashMap map = new LinkedHashMap();
        for(EnumBase item : values) {
            map.put(item.getCode(), item.getDesc());
        }
        return map;
    }
    
   /**
    * 根据code查找得到Enum
    * @param code
    * @param values
    * @return
    */
   public static <T extends EnumBase> T getByCode(Object code,T[] values) {
       if(code == null) return null;
       for (T item : values) {
            if (item.getCode().equals(code)) {
                return item;
            }
       }
       return null;
   }
   
   public static <T extends EnumBase> Object getCode(T kv) {
       if(kv == null) return null;
       return kv.getCode();
   }
   
   public static <T extends EnumBase> Object getDesc(T kv) {
       if(kv == null) return null;
       return kv.getDesc();
   }
   
   /**
    * 根据code得到Enum,找不到则抛异常
    * @param <T>
    * @param code
    * @param values
    * @return
    * @throws IllegalArgumentException 根据code得到Enum,找不到则抛异常
    */
   public static <T extends EnumBase> T getRequiredByCode(Object code,T[] values) throws IllegalArgumentException {
       EnumBase v = getByCode(code,values);
       if(v == null) {
           if(values.length > 0) {
               String className = values[0].getClass().getName();
               throw new IllegalArgumentException("not found "+className+" by code:"+code);
           }else {
               throw new IllegalArgumentException("not found Enum by code:"+code);
           }
       }
       return (T)v;
   }
   
}
