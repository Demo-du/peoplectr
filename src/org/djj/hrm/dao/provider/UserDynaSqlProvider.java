package org.djj.hrm.dao.provider;

import java.util.Map;
import static org.djj.hrm.util.common.HrmConstants.USERTABLE;
import org.apache.ibatis.jdbc.SQL;
import org.djj.hrm.domain.User;

/*
 * 动态SQL提供类
 * author:杜健健
 */
/*public class UserDynaSqlProvider {
    //分页动态查询
	public String selectWhitParam(Map<String,Object> params){
		String Sql=new SQL(){
			{
				SELECT("*");
				FROM(USERTABLE);
				if(params.get("user")!=null){
					User user=(User)params.get("user");
				}
			}
		}
	}
}*/
public class UserDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> param){
		final Map<String, Object> params=param;;//这里可以改一下试试8-05
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(USERTABLE);
				if(params.get("user") != null){
					User user = (User)params.get("user");
					if(user.getUsername() != null && !user.getUsername().equals("")){
						WHERE("  username LIKE CONCAT ('%',#{user.username},'%') ");
					}
					if(user.getStatus() != null && !user.getStatus().equals("")){
						WHERE(" status LIKE CONCAT ('%',#{user.status},'%') ");
					}
				}
			}
		}.toString();
		
		if(params.get("pageModel") != null){
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		}
		
		return sql;
	}	
	// 动态查询总数量
	public String count(Map<String, Object> param){
		final Map<String, Object> params=param;;//这里可以改一下试试8-05
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(USERTABLE);
				if(params.get("user") != null){
					User user = (User)params.get("user");
					if(user.getUsername() != null && !user.getUsername().equals("")){
						WHERE(" username LIKE CONCAT ('%',#{user.username},'%') ");
					}
					if(user.getStatus() != null && !user.getStatus().equals("")){
						WHERE(" status LIKE CONCAT ('%',#{user.status},'%') ");
					}
				}
			}
		}.toString();
	}	
	
	// 动态插入
	public String insertUser(User users){
		final User user=users;
		return new SQL(){
			{
				INSERT_INTO(USERTABLE);
				if(user.getUsername() != null && !user.getUsername().equals("")){
					VALUES("username", "#{username}");
				}
				if(user.getStatus() != null && !user.getStatus().equals("")){
					VALUES("status", "#{status}");
				}
				if(user.getLoginname() != null && !user.getLoginname().equals("")){
					VALUES("loginname", "#{loginname}");
				}
				if(user.getPassword() != null && !user.getPassword().equals("")){
					VALUES("password", "#{password}");
				}
			}
		}.toString();
	}
	// 动态更新
		public String updateUser(User users){
			final User user=users;
			return new SQL(){
				{
					UPDATE(USERTABLE);
					if(user.getUsername() != null){
						SET(" username = #{username} ");
					}
					if(user.getLoginname() != null){
						SET(" loginname = #{loginname} ");
					}
					if(user.getPassword()!= null){
						SET(" password = #{password} ");
					}
					if(user.getStatus()!= null){
						SET(" status = #{status} ");
					}
					if(user.getCreateDate()!= null){
						SET(" create_date = #{createDate} ");
					}
					WHERE(" id = #{id} ");
				}
			}.toString();
		}
}