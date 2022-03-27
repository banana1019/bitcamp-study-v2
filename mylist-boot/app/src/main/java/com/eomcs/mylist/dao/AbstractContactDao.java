package com.eomcs.mylist.dao;

import com.eomcs.mylist.domain.Contact;
import com.eomcs.util.ArrayList;

// 서브 클래스의 공통 분모를 추출하여 수퍼 클래스를 정의할 경우,
// 보통 이런 수퍼 클래스는 직업 사용하려고 만든 클래스가 아니다.
// 단지 서브 클래스에게 공통 분모를 물려주려고 만든 클래스이다.
// 이런 경우 "추상 클래스"로 선언한다.
// 또한 추상 클래스만이 추상 메서드를 가질 수 있기 때문에
// 추상 메서드가 있는 클래스는 반드시 추상 클래스로 선언해야 한다.
//
public abstract class AbstractContactDao implements ContactDao {

  // 서브 클래스에서 접근해야 할 필드라면,
  // 접근 범위를 protected로 설정한다.
  //
  protected ArrayList contactList = new ArrayList(); // 변수 선언 = 변수를 만들라는 명령!

  // 1) 데이터를 저장하는 save() 메서드가 반드시 있어야 한다.
  //    - insert(), update(), delete(), increaseViewCount() 메서드에서 save()를 사용한다.
  //    - 그래서 수퍼 클래스에 save() 메서드를 둬야 한다.
  // 2) 그러나 save()를 통해 데이터를 저장하는 방법은 서브 클래스마다 다르다.
  //    - 수퍼 클래스에서 save() 메서드를 구현해봐야 의미가 없다.
  //    - 왜? 어차피 서브 클래스에서 재정의할 테니까!
  //    - 이런 경우 해당 메서드를 "추상 메서드"로 선언한다.
  // 3) 서브 클래스에서 오버라이딩 할 수 있도록 접근 가능해야 한다.
  //    - 서브 클래스가 다른 패키지에 있을 수 있다.
  //    - 이런 경우 메서드의 접근 범위를 protected로 한다.
  //
  protected abstract void save() throws Exception;

  @Override
  public int countAll() {
    return contactList.size();
  }

  @Override
  public Object[] findAll() {
    return contactList.toArray();
  }

  @Override
  public void insert(Contact contact) throws Exception {
    contactList.add(contact);
    save();
  }

  @Override
  public Contact findByEmail(String email) {
    int no = indexOf(email);
    if (no < 0 || no >= contactList.size()) {
      return null;
    }
    return (Contact) contactList.get(no);
  }

  @Override
  public int update(Contact contact) throws Exception {
    int no = indexOf(contact.getEmail());
    if (no < 0 || no >= contactList.size()) {
      return 0;
    }
    contactList.set(no, contact);
    save();
    return 1;
  }

  @Override
  public int delete(String email) throws Exception {
    int no = indexOf(email);
    if (no < 0 || no >= contactList.size()) {
      return 0;
    }
    contactList.remove(no);
    save();
    return 1;
  }

  private int indexOf(String email) {
    for (int i = 0; i < contactList.size(); i++) {
      Contact contact =  (Contact) contactList.get(i);
      if (contact.getEmail().equals(email)) { 
        return i;
      }
    }
    return -1;
  }

}
