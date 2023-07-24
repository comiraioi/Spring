package mall.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import order.model.OrderBean;
import order.model.OrderDao;

@Controller
public class OrderMallController {
	private final String command = "/order.mall";
	private String listPage = "orderList";
	private String loginPage = "redirect:/login.mb";
	
	@Autowired
	OrderDao odao;
	
	/* start.jsp���� ���� �ֹ����� Ŭ�� */
	@RequestMapping(command)
	public ModelAndView doAction(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		MemberBean mb = (MemberBean)session.getAttribute("loginInfo");
		
		if(mb == null) {	//�α��� ��������
			//destination �Ӽ� ����
			session.setAttribute("destination","redirect:"+command);
			mav.setViewName(loginPage);
		}
		else {	//�α��� ������
			String mid = mb.getId();
			
			List<OrderBean> olist = odao.getOlistbyId(mid);
			
			mav.addObject("olist", olist);
			mav.setViewName(listPage);
		}
		
		return mav;
	}
}
