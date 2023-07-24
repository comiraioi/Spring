package member.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component
public class MemberDao {
	private String namespace = "member.model.Member";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	/* count */
	public int getTotalCount(Map<String, String> map) {
		int count = -1;
		
		count = sqlSessionTemplate.selectOne(namespace+".MemberCount", map);
		
		return count;
	}
	
	/* select */
	public List<MemberBean> getAllMember(Map<String, String> map, Paging pageInfo) {
		List<MemberBean> lists = new ArrayList<MemberBean>();
		
		RowBounds rowbounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace+".MemberList", map, rowbounds);
		
		return lists;
	}
	
	/* insert */
	public int register(MemberBean mb) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace+".InsertMember", mb);
		
		return cnt;
	}
	
	/* detail */
	public MemberBean getMemberbyId(String id) {
		MemberBean pb = sqlSessionTemplate.selectOne(namespace+".MemberDetail", id);
		
		return pb;
	}
	
	/* update */
	public int updateMember(MemberBean mb) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".UpdateMember", mb);
		
		return cnt;
	}
	
	/* update point */
	public int updatePoint(MemberBean mb) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".UpdatePoint", mb);
		
		return cnt;
	}
	
	/* delete */
	public int deleteMember(String id) {
		int cnt = -1;
		cnt = sqlSessionTemplate.delete(namespace+".DeleteMember", id);
		
		return cnt;
	}
	
}
