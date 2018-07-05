package com.niit.dao;

import java.util.List;

import com.niit.model.Friend;
import com.niit.model.UserDetail;


public interface FriendDAO {
	
	
	public boolean sendFriendRequest(Friend friend);
	public boolean deleteFriendRequest(int friendId);
	public boolean acceptFriendRequest(int friendId);
	public boolean unFriendRequest(int friendId);
	public List<UserDetail> showSuggestedFriend(String loginname);
	public List<Friend> showAllFriends(String loginname);
	public List<Friend> showPendingFriendRequest(String loginname);
	

}
