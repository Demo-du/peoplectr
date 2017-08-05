package org.djj.hrm.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.djj.hrm.domain.Dept;
import static org.djj.hrm.util.common.HrmConstants.DEPTTABLE;
public class DeptDynaSqlProvider {
	//分页查询
	public String selectWhitParam(Map<String, Object> param){
		final Map<String, Object> params=param;
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(DEPTTABLE);
				if(params.get("dept") != null){
					Dept dept = (Dept) params.get("dept");
					if(dept.getName() != null && !dept.getName().equals("")){
						WHERE("  name LIKE CONCAT ('%',#{dept.name},'%') ");
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
			final Map<String, Object> params=param;
			return new SQL(){
				{
					SELECT("count(*)");
					FROM(DEPTTABLE);
					if(params.get("dept") != null){
						Dept dept = (Dept) params.get("dept");
						if(dept.getName() != null && !dept.getName().equals("")){
							WHERE("  name LIKE CONCAT ('%',#{dept.name},'%') ");
						}
					}
				}
			}.toString();
		}	
		// 动态插入
		public String insertDept(Dept depts){
			final Dept dept=depts;
			return new SQL(){
				{
					INSERT_INTO(DEPTTABLE);
					if(dept.getName() != null && !dept.getName().equals("")){
						VALUES("name", "#{name}");
					}
					if(dept.getRemark() != null && !dept.getRemark().equals("")){
						VALUES("remark", "#{remark}");
					}
				}
			}.toString();
		}
		// 动态更新
		public String updateDept(Dept depts){
			final Dept dept=depts;
			return new SQL(){
				{
					UPDATE(DEPTTABLE);
					if(dept.getName() != null){
						SET(" name = #{name} ");
					}
					if(dept.getRemark() != null){
						SET(" remark = #{remark} ");
					}
					WHERE(" id = #{id} ");
				}
			}.toString();
		}

}
