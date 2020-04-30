package jp.co.internous.smile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.smile.model.domain.MstProduct;
import jp.co.internous.smile.model.mapper.MstProductMapper;
import jp.co.internous.smile.model.session.LoginSession;

@Controller
@RequestMapping("/smile/product")
public class ProductController {
	
	@Autowired
	MstProductMapper productMapper;

	@Autowired
	LoginSession loginSession;
	
	//ユーザーが{id}(＝商品)指定時
	@RequestMapping("/{id}")
	public String index(@PathVariable("id") int id, Model m) {
		// 商品情報を取得
		MstProduct product = productMapper.findById(id);
		m.addAttribute("product", product); 
		m.addAttribute("loginSession", loginSession);
				
		return "product_detail";
	}
}
