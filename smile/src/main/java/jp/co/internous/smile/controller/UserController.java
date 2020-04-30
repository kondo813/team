package jp.co.internous.smile.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.internous.smile.model.session.LoginSession;
import jp.co.internous.smile.model.domain.MstUser;
import jp.co.internous.smile.model.form.UserForm;
import jp.co.internous.smile.model.mapper.MstUserMapper;


@Controller
@RequestMapping("/smile/user")
public class UserController {
	
	@Autowired
	private MstUserMapper userMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	/**
	 *新規登録画面に遷移するメソッド
	 */
	@RequestMapping("/")
	public String index(Model m) {
		m.addAttribute("loginSession", loginSession);
		return "register_user";
	}
	
	/**
	 *UserNameが重複しているユーザーを探すメソッド
	 */
	@RequestMapping("/duplicatedUserName")
	@ResponseBody
	public boolean duplicatedUserName(@RequestParam String userName) {		
		int count = userMapper.findCountByUserName(userName);
		return count > 0;
	}
	
	/**
	 *確認ダイアログからdbにinsertするメソッド
	 */
	@RequestMapping("/register")
	@ResponseBody
	public boolean register(@RequestBody UserForm f) {
		MstUser user = new MstUser(f);
		
		int count = userMapper.insert(user);
		
		return count > 0;
	}


}
