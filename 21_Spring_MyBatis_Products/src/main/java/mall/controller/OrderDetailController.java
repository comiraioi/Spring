package mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import product.model.JoinBean;
import product.model.JoinDao;

@Controller
public class OrderDetailController {
	private final String command = "/orderdetail.mall";
	private String detailPage = "orderDetail";
	
	@Autowired
	JoinDao jdao;	//orderdetails, product 조인
	
	/* start.jsp에서 나의 주문내역 클릭 */
	@RequestMapping(command)
	public String doAction(@RequestParam("oid") int oid, Model model) {
		
		List<JoinBean> jlist = jdao.getOrderDetail(oid);
		model.addAttribute("jlist",jlist);
		model.addAttribute("oid",oid);
		
		return detailPage;
	}
}
