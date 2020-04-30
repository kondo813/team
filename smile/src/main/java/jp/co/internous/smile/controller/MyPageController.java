package jp.co.internous.smile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.smile.model.domain.MstUser;
import jp.co.internous.smile.model.mapper.MstUserMapper;
import jp.co.internous.smile.model.session.LoginSession;

@Controller
@RequestMapping("/smile/mypage")
public class MyPageController {
	
	@Autowired
	MstUserMapper mstUserMapper;
	
	@Autowired
	protected LoginSession loginSession;
	
	@RequestMapping("/")
	public String index(Model m) {
		MstUser user = mstUserMapper.findByUserNameAndPassword(loginSession.getUserName(), loginSession.getPassword());
		
		m.addAttribute("user", user);
		m.addAttribute("loginSession", loginSession);		

		return "my_page";
	}

}
