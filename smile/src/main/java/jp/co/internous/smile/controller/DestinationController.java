package jp.co.internous.smile.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.internous.smile.model.mapper.MstUserMapper;
import jp.co.internous.smile.model.domain.MstDestination;
import jp.co.internous.smile.model.domain.MstUser;
import jp.co.internous.smile.model.form.DestinationForm;
import jp.co.internous.smile.model.mapper.MstDestinationMapper;

import jp.co.internous.smile.model.session.LoginSession;


@Controller
@RequestMapping("/smile/destination")
public class DestinationController {
	
	@Autowired
	private MstUserMapper userMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	MstDestinationMapper destinationMapper;
	
	private Gson gson = new Gson();

	

	@RequestMapping("/")
	public String index(Model m) {
		MstUser user = userMapper.findByUserNameAndPassword(loginSession.getUserName(),loginSession.getPassword());
		
		m.addAttribute("user", user);
		m.addAttribute("loginSession",loginSession);
		return "destination";
	}
	
	
	
	@RequestMapping("/register")
	@ResponseBody
	public String register(@RequestBody DestinationForm f) {
		
		MstDestination destination = new MstDestination(f);
		int userId = loginSession.getUserId();
		destination.setUserId(userId);
		int count = destinationMapper.insert(destination);
		
		
		Integer id = 0;
		if (count > 0) {
			id = destinationMapper.findIdByUserId(userId);
		}
		return id.toString();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/delete")
	@ResponseBody
	public boolean delete(@RequestBody String destinationId) {
		
		Map<String, String> map = gson.fromJson(destinationId, Map.class);
		String id = map.get("destinationId");
		
		int result = destinationMapper.logicalDeleteById(Integer.parseInt(id));
		
		return result > 0;
	}
	
}
