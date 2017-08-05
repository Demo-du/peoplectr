package org.djj.hrm.dao;
import static org.djj.hrm.util.common.HrmConstants.USERTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.djj.hrm.dao.provider.UserDynaSqlProvider;
import org.djj.hrm.domain.User;
/*
 * userdao接口
 * author:杜健健
 */
public interface UserDao {
	//根据登录名和密码查询人员
    //@Select("select * from "+USERTABLE+"where loginname=#{loginname} and pssword=#{password}")
	@Select("select * from "+USERTABLE+" where loginname = #{loginname} and password = #{password}")
	User selectByLoginnameAndPassword(
			@Param("loginname") String loginname,
			@Param("password") String password);
	//根据id查询
	@Select("select * from"+USERTABLE+"where id=#{id}")
	User selectById(Integer id);
	//根据id删除
	@Delete("delete from "+USERTABLE+"where id=#{id}")
	void deleteById(Integer id);
	//动态修改用户
	@SelectProvider(type=UserDynaSqlProvider.class,method="updateUser")
	void update(User user);
	//动态查询
	@SelectProvider(type=UserDynaSqlProvider.class,method="selectWhitParam")
	List<User> selectByPage(Map<String,Object>params);
	//根据参数查询用户总数
	@SelectProvider(type=UserDynaSqlProvider.class,method="count")
	Integer count(Map<String,Object>params);
	//动态插入用户
	@SelectProvider(type=UserDynaSqlProvider.class,method="insertUser")
	void save(User user);
}
