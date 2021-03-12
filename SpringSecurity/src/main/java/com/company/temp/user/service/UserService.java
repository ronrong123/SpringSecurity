package com.company.temp.user.service;

import java.util.List;

public interface UserService {

	//단건조회
	public UserVO getUser(UserVO vo);
	//전체조회
	public List<UserVO> getSearchUser(UserVO vo);
	//삭제
	public int deleteUser(UserVO vo);
	//수정
	public int updateUser(UserVO vo);
	//등록
	public void insertUser(UserVO vo);
	//로그인
	public boolean logCheck(UserVO vo);
	//패스워드변경
	public int updatePw(UserVO vo);
}
