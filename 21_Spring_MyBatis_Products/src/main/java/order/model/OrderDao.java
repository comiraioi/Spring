package order.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import product.model.ProductBean;

@Component
public class OrderDao {
	private String namespace = "order.model.Order";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	/* insert */
	public int insertOrder(String mid) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace+".InsertOrder", mid);
		
		return cnt;
	}
	
	/* select max */
	public int getMaxOid() {
		int oid = 0;
		oid = sqlSessionTemplate.selectOne(namespace+".GetMaxOid");
		
		return oid;
	}

	/* select by mid */
	public List<OrderBean> getOlistbyId(String mid) {
		List<OrderBean> lists = new ArrayList<OrderBean>();
		lists = sqlSessionTemplate.selectList(namespace+".OrderList", mid);
		
		return lists;
	}
	
	
}
