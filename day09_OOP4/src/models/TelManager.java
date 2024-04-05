package models;

import classes.Contact;

public class TelManager {
	

	private Contact[] contacts = new Contact[10];
	private int index = 0;
	
	/** getter & setter **/
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	/**
	 * 배열에 값을 추가하는 메서드
	 * @param contact
	 */
	public void AddContact(Contact contact) {
		contacts[index] = contact;
		index++;
	}
	
	/**
	 * 저장된 Contacts의 배열을 반환하는 메서드
	 * @return
	 */
	public Contact[] getContacts() {
		return contacts;
	}
	
	/**
	 * 전화번호의 일부분을 검색하여 일치하는 값의 배열만 반환하는 메서드
	 * @param search
	 * @return
	 */
	public Contact[] searchString(String search) {
		Contact[] arr = new Contact[10];
		int count = 0;
		for(int i=0; i<index; i++) {
			if(contacts[i].getPhone().contains(search)) {
				arr[count] = contacts[i];
				count++;
			}
		}
		Contact[] result = new Contact[count];
		
		/**
		 *  Array copy (System.arraycopy(Objec src, srcPos, dest, destPos, length)
		 *  1. Objec src: 복사할 데이터를 포함하는 원본 배열
		 *  2. srcPos: 원본 배ㅑ열에서 복사를 시작할 인덱스
		 *  3. dest: 데이터를 복사할 대상 배열
		 *  4. destPos: 대상 배열에서 데이터를 저장할 시작 인덱스
		 *  5. length: 복사할 요소의 수
		 */
		System.arraycopy(arr, 0, result, 0, count);
		
		return result;
	}
	
	/**
	 * 연락처를 업데이트 하는 메서드
	 * @param id
	 * @param number
	 * @return
	 */
	public int updateContact(String id, String number) {
		int success = 0; 
		
		for(int i=0; i<index; i++) {
			if(contacts[i].getId().equals(id)) {
				contacts[i].setPhone(number);
				success = 1;
			}
		}
		
		return success;
	}
	
	/**
	 * 연락처를 삭제 하는 메서드 
	 * @param id
	 * @return
	 */
	public int deleteContact(String id) {
		int success = 0;
		int count = 0;
		Contact[] arr = new Contact[10];
		for(int i=0; i<index; i++) {
			if(contacts[i].getId().equals(id)) {
				System.out.println("삭제 된 데이터 : " + id);
			} else {
				arr[count] = contacts[i];
				count++;
			}
		}
		contacts = arr;
		if(contacts.length == arr.length) {
			index = count;
			success = 1;
		}
		
		return success;
	}
	

}
