package cn.catsir.util;

import java.util.Map;

/**
 * 校验请求的必要参数工具类
 * 
 * @author JD 2016年6月22日
 */
public class ParamValidUtil {
	
	/**
	 * 校验接口必要参数
	 * @param paramMap
	 * @return String
	 */
	public static String validateParam(Map<String, Object> paramMap) {
		StringBuilder stringBuilder = new StringBuilder();
		for (String key : paramMap.keySet()) {
			if(paramMap.get(key) == null){
				stringBuilder.append(key).append(",");
			}
		}
		String rtn = stringBuilder.toString();
		if(rtn.length() > 0){
			rtn = rtn.substring(0, rtn.length()-1);
		}
		return rtn;
	}

}
