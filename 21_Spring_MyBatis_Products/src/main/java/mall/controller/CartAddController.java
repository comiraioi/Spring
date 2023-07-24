package mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mall.cart.MyCartList;
import member.model.MemberBean;

@Controller
public class CartAddController {
	private final String command = "/add.mall";

	private String loginPage = "redirect:/login.mb";
	private String detailPage = "redirect:/detail.prd";
	private String cartPage = "redirect:/list.mall";	//CartListController
	
	/* ��ǰ �󼼺��� ������ => �ֹ� Ŭ�� */
	@RequestMapping(command)
	public ModelAndView doAction(@RequestParam("num") int num, @RequestParam("pageNumber") int pageNumber,
								@RequestParam("orderqty") int orderqty, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemberBean mb = (MemberBean)session.getAttribute("loginInfo");
		
		//�α��� ��������
		if(mb == null) {	
			//destination �Ӽ� ����
			session.setAttribute("destination", detailPage+"?num="+num+"&pageNumber="+pageNumber);	//destination �Ӽ� ����
			mav.setViewName(loginPage);	//memberLoginForm.jsp
		}
		else {	//�α��� ������
			MyCartList mycart = (MyCartList)session.getAttribute("mycart");
			
			if(mycart == null) {	//��ٱ��ϰ� ������
				mycart = new MyCartList();	//��ٱ��� ��ü ����
			}
			
			mycart.addOrder(num,orderqty);	//��ٱ��Ͽ� ��ǰ��ȣ,���� �ֱ�
			session.setAttribute("mycart",mycart);	//��ٱ��� ���� ���� (ȸ���� ��ٱ��� ��ü 1��)
			
			mav.setViewName(cartPage);	
		}
		
		return mav;
		
	}
}
