package com.spring.member.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberUtility {
	
	public Map<String,List<String>> getBrith(){
		Map<String, List<String>> map = new HashMap<String,List<String>>();
		map.put("year",getBrith("year"));
		map.put("month",getBrith("month"));
		return map ;
	}
	
	private List<String> getBrith(String target){
		List<String> list = new ArrayList<String>();
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.get(Calendar.YEAR));
		return list;
	}
}
