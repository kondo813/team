package jp.co.internous.smile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import jp.co.internous.smile.model.domain.MstCategory;
import jp.co.internous.smile.model.domain.MstProduct;
import jp.co.internous.smile.model.form.SearchForm;
import jp.co.internous.smile.model.mapper.MstCategoryMapper;
import jp.co.internous.smile.model.mapper.MstProductMapper;
import jp.co.internous.smile.model.session.LoginSession;

@Controller
@RequestMapping("/smile")
public class IndexController {
	
	@Autowired
	MstCategoryMapper categoryMapper;
	@Autowired
	MstProductMapper productMapper;
	@Autowired
	private LoginSession loginSession;
	
	@RequestMapping("/")
	public String index(Model m) {
		
		if (!loginSession.getLogined() && loginSession.getTmpUserId() == 0) {
			int tmpUserId = (int)(Math.random() * 1000000000 * -1);
			loginSession.setTmpUserId(tmpUserId);
		}
		
		List<MstCategory> categories = categoryMapper.find();
		List<MstProduct> products = productMapper.find();
		
		//index.htmlに渡す
		m.addAttribute("categories", categories);
		m.addAttribute("selected", 0);
		m.addAttribute("products", products);
		m.addAttribute("loginSession", loginSession);
		
		return "index";
	}
	
	@RequestMapping("/searchItem")
	public String index(SearchForm s, Model m) {
		
		List<MstCategory> categories = categoryMapper.find();
		List<MstProduct> products = productMapper.find();
		
		//	replaceAll()全角スペースを半角に,スペース2個を1個に,trim()前後のスペース削除
		String kensaku = s.getKensaku().replaceAll("　", " ").replaceAll("\\s{2,}", " ").trim();
		if (s.getCategory() == 0) {
			
			products = productMapper.findByProductName(kensaku.split(" "));
		} else {
			products = productMapper.findByCategoryAndProductName(s.getCategory(), kensaku.split(" "));
		}
		
		m.addAttribute("categories", categories);
		m.addAttribute("products", products);
		m.addAttribute("kensaku", kensaku);
		m.addAttribute("selected", s.getCategory()); 
		m.addAttribute("loginSession", loginSession);
				
		return "index";
	}
}
