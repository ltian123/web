package util;

public class StringUtil {

	public static String arrayToString(String[] arr,String s){
		StringBuffer buffer = new StringBuffer();
		for(String str : arr){
			buffer.append(str).append(s);
		}
		
		return buffer.substring(0, buffer.toString().length()-1);
	}
	
	public static String checkHobby(String hobbies,String hobby){
		if(null != hobbies){
			String[] arr = hobbies.split(",");
			for (String str : arr) {
				if(str.equals(hobby)){
					return "checked";
				}
			}
		}
		return "";
	}
	
	public static void main(String[] args) {
//		String[] arr = {"1","2","3"};
		String[] arr = {"a","2"};
		String s = arrayToString(arr, ",");
		System.out.println(s);
	}
	
}
