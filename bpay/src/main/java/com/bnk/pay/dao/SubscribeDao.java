package com.bnk.pay.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bnk.pay.dto.Subscribe;

public interface SubscribeDao extends JpaRepository<Subscribe, Integer>{
	@Modifying // insert , delete, update 를 네이티브 쿼리로 작성하려면 해당 어노테이션 필요
	@Query(value = "INSERT INTO subscribe(from_user_id,to_user_id,create_date) VALUES(:fromUserId,:toUserId,now())",nativeQuery = true)
	void mSubscribe(int fromUserId, int toUserId);
	
	@Modifying
	@Query(value = "DELETE FROM subscribe WHERE fromUserId = :fromUserId AND toUserId = :toUserId",nativeQuery = true)
	void mUnSubscribe(int fromUserId, int toUserId);

}
