package models;

import classes.Contact;

public class TelManager {
	

	private Contact[] contacts = new Contact[10];
	private int index = 0;
	
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public void AddContact(Contact contact) {
		contacts[index] = contact;
		index++;
	}
	
	public Contact[] getContacts() {
		return contacts;
	}
	
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
	

}
