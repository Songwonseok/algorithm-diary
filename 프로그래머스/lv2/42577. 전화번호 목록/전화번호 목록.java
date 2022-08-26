import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>(Arrays.asList(phone_book));

		for (String phone: phone_book) {
			for(int length = 1; length < phone.length(); length++){
				if(set.contains(phone.substring(0, length))){
					return false;
				}
			}
		}

		return true;
    }
}