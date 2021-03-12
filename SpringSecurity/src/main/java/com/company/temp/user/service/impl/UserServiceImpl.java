package com.company.temp.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.company.temp.user.service.UserService;
import com.company.temp.user.service.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService{
	
	@Autowired UserMapper dao;

	public UserVO getUser(UserVO vo) {
		return dao.getUser(vo);
	}

	public List<UserVO> getSearchUser(UserVO vo) {
		// TODO Auto-generated method stub
		return dao.getSearchUser(vo);
	}

	public int deleteUser(UserVO vo) {
		// TODO Auto-generated method stub
		return dao.deleteUser(vo);
	}

	public int updateUser(UserVO vo) {
		// TODO Auto-generated method stub
		return dao.updateUser(vo);
	}

	public void insertUser(UserVO vo) {
		dao.insertUser(vo);
	}

	@Override
	public boolean logCheck(UserVO vo) {
		//단건조회
		UserVO uservo = dao.getUser(vo);		
		//id가 일치하는지 체크
		if(uservo == null) {
			return false;
		}
		//pw일치여부 체크
		if(uservo.getPassword().equals(vo.getPassword())) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int updatePw(UserVO vo) {//vo:controller에서 넘어온 값
		// 단건조회
		UserVO uservo = dao.getUser(vo); //getUser에 vo안에 id를 넣어 uservo에 getUser(단건조회)를 함
		//기존패스워드와 일치하는지 체크
		if(uservo.getPassword().equals(vo.getOldpassword())) {
			//원래 dao에 있는 password와 내가적은(oldpassword)를 비교, && 내가적은 password와 newpass를 비교
			//일차한다면 패스워드 업데이트 
			return dao.updateUser(vo);
		}
		return 0;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("===============userService 실행==================");
		UserVO uservo = new UserVO();
		uservo.setId(username);
		uservo = dao.getUser(uservo);
		if(uservo == null) {
			throw new UsernameNotFoundException("no user");
		}		
		return uservo;
	}

}
