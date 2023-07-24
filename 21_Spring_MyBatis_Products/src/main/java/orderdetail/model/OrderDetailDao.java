package orderdetail.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component
public class OrderDetailDao {
	private String namespace = "orderdetail.model.OrderDetail";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	/* insert */
	public int insertOrderDetail(OrderDetailBean odb) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace+".InsertOrderDetail", odb);
		
		return cnt;
	}

	/* select by oid */
	public List<OrderDetailBean> getDetailbyOid(int oid) {
		List<OrderDetailBean> lists = new ArrayList<OrderDetailBean>();
		lists = sqlSessionTemplate.selectList(namespace+".GetOrderDetail", oid);
		
		return lists;
	}
	
}
