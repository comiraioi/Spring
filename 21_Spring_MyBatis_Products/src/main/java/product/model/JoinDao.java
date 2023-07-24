package product.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JoinDao {
	private String namespace = "product.model.Composite";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	/* join */
	public List<JoinBean> getOrderDetail(int oid){
		List<JoinBean> lists = new ArrayList<JoinBean>();
		lists = sqlSessionTemplate.selectList(namespace+".GetOrderDetail", oid);
		
		return lists;
	}
	
}
