package com.encore.pms.dao;

import java.util.List;

import com.encore.pms.dto.Phone;
import com.encore.pms.dto.UserInfo;

public interface IPhoneDAO {
	
	int insert(Phone phone);
	int delete(List<String> list); //나중에 이 부분은 수정될 수도 있다.
	
//	동적쿼리에 대해서 일일이 대응하는 함수명을 만드는것 보다는 Overloading기법을 활용하자 --> 코드의 가독력을 높여준다.
	
	Phone select(Phone phone);
	List<Phone> select();
	UserInfo select(UserInfo user);
	int updatePhone(Phone phone);
}
