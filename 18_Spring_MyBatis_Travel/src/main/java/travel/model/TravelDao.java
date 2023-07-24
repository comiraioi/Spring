package travel.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myTravelDao")
public class TravelDao {
	/* mapper ����(travel.xml) => namespace: travel.TravelBean */
	private String namespace = "travel.TravelBean"; 
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	/* count */
	public int getTotalCount(Map<String,String> map) {
		int total = sqlSessionTemplate.selectOne(namespace+".GetTotalCount",map);
		
		return total;
	}
	
	/* select */
	public List<TravelBean> getAllTravel(Map<String,String> map, Paging pageInfo) {
		List<TravelBean> lists = new ArrayList<TravelBean>();
		
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		//offset: �ǳʶ� ���ڵ� ��
		//limit: �� �������� ������ ���ڵ� ��(=pageSize)
		
		lists = sqlSessionTemplate.selectList(namespace+".GetTravelList",map,rowBounds);
		return lists;
	}
	
	/* insert */
	public int insertTravel(TravelBean tb) {
		int cnt = -1;
		
		//sql ����(ex.�Է°��̳ʹ�ŭ) �߻� �� ���� ���� �Ѿ��
		try {
			cnt = sqlSessionTemplate.insert(namespace+".InsertTravel", tb);
		} catch(DataAccessException e) {	//Exception e
			
		}
		System.out.println("cnt(insert): "+cnt);	//�����߻�: cnt=-1
		
		return cnt;
	}
	
	/* select by num */
	public TravelBean getTravelbyNum(int num) {
		TravelBean tb = null;
		tb = sqlSessionTemplate.selectOne(namespace+".GetTravelView", num);
		
		return tb;
	}
	
	/* update */
	public int updateTravel(TravelBean tb) {
		int cnt = -1;
		
		try {
			cnt = sqlSessionTemplate.insert(namespace+".UpdateTravel", tb);
		} catch(DataAccessException e) {
			
		}
		System.out.println("cnt(update): "+cnt);
		
		return cnt;
	}
	
	/* delete */
	public int deleteTravel(int num) {
		int cnt = -1;
		
		try {
			cnt = sqlSessionTemplate.insert(namespace+".DeleteTravel", num);
		} catch(DataAccessException e) {
			
		}
		System.out.println("cnt(delete): "+cnt);
		
		return cnt;
	}

}
