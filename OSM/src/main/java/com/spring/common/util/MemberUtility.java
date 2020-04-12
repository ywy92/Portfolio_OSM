package com.spring.common.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("memberUtil") 
public class MemberUtility {

	public MemberUtility() {
	}

	public static List<String> getBirth(String target) {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		List<String> list = new ArrayList<String>();
		int start = 0;
		int end = 0;
		boolean flag = target.equals("month");
		try {
			start = flag ? 1 : year;
			end = flag ? 12 : year - 100;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			while (true) {
				String element = String.valueOf(start);
				list.add(element.length() == 1 ? "0" + element : element);
				start = flag ? start + 1 : start - 1;
				if (flag ? start > end : start < end) {
					break;
				}
			}
		}
		return list;
	}

}
