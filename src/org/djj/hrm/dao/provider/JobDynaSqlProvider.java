package org.djj.hrm.dao.provider;



import java.util.Map;
import org.djj.hrm.domain.Job;
import org.apache.ibatis.jdbc.SQL;
import org.djj.hrm.domain.Dept;
import static org.djj.hrm.util.common.HrmConstants.JOBTABLE;
/*
 * job动态SQL提供类
 * author：杜健健
 */
public class JobDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> param){
		final Map<String, Object> params=param;
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(JOBTABLE);
				if(params.get("job") != null){
					Job job = (Job) params.get("job");
					if(job.getName() != null && !job.getName().equals("")){
						WHERE("  name LIKE CONCAT ('%',#{job.name},'%') ");
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
				FROM(JOBTABLE);
				if(params.get("job") != null){
					Job job = (Job) params.get("job");
					if(job.getName() != null && !job.getName().equals("")){
						WHERE("  name LIKE CONCAT ('%',#{job.name},'%') ");
					}
				}
			}
		}.toString();
	}	
	// 动态插入
	public String insertJob(Job jobs){
		final Job job=jobs;
		return new SQL(){
			{
				INSERT_INTO(JOBTABLE);
				if(job.getName() != null && !job.getName().equals("")){
					VALUES("name", "#{name}");
				}
				if(job.getRemark() != null && !job.getRemark().equals("")){
					VALUES("remark", "#{remark}");
				}
			}
		}.toString();
	}
	// 动态更新
	public String updateJob(Job jobs){
		final Job job=jobs;
		return new SQL(){
			{
				UPDATE(JOBTABLE);
				if(job.getName() != null){
					SET(" name = #{name} ");
				}
				if(job.getRemark() != null){
					SET(" remark = #{remark} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
	
	
}