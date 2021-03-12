package com.company.temp.user.service.impl;

import java.util.List;

import com.company.temp.user.service.UserVO;

public interface UserMapper {
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
}
