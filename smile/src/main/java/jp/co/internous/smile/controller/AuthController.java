package jp.co.internous.smile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.internous.smile.model.domain.MstUser;
import jp.co.internous.smile.model.form.UserForm;
import jp.co.internous.smile.model.mapper.MstUserMapper;
import jp.co.internous.smile.model.mapper.TblCartMapper;
import jp.co.internous.smile.model.session.LoginSession;

@Controller
@RequestMapping("/smile/auth")
public class AuthController {
	
	@Autowired
	MstUserMapper mstUserMapper;
	
	@Autowired
	TblCartMapper tblCartMapper;

	@Autowired
	protected LoginSession loginSession;

	private Gson gson = new Gson();
	
	/* ログイン処理 */
	@ResponseBody
	@PostMapping("/login")
	public String login(@RequestBody UserForm form, Model m) {
		MstUser users = mstUserMapper.findByUserNameAndPassword(form.getUserName(), form.getPassword());
		m.addAttribute("logined", false);
		loginSession.setLogined(false);
		
		/* ユーザー名とパスワードが一致した場合 */
		if (users != null) {
			/* 仮ユーザーIDに紐づくカート情報をユーザーIDに紐づけ直す */
			tblCartMapper.updateUserId(users.getId(), loginSession.getTmpUserId());
			
			/* htmlへ返す情報の設定 */
			m.addAttribute("userId", users.getId());
			m.addAttribute("userName", users.getUserName());
			m.addAttribute("password", users.getPassword());
			m.addAttribute("logined", true);
			
			/* ログインセッション変更 */
			loginSession.setUserId(users.getId());
			loginSession.setTmpUserId(0);
			loginSession.setUserName(users.getUserName());
			loginSession.setPassword(users.getPassword());
			loginSession.setLogined(true);
			
		}
		
		return gson.toJson(m);
	}
	
	/* ログアウト処理 */
	@ResponseBody
	@PostMapping("/logout")
	public String logout() {
		/* ログインセッション破棄 */
		loginSession.setUserId(0);
		loginSession.setUserName(null);
		loginSession.setPassword(null);
		loginSession.setLogined(false);
		
		return null;
	}
	
	/* パスワード再設定 */
	@ResponseBody
	@PostMapping("/resetPassword")
	public String resetPassword(@RequestBody UserForm form) {
		MstUser users = mstUserMapper.findByUserNameAndPassword(form.getUserName(), form.getPassword());
		
		/* 認証失敗 */
		if (users == null) {
			return "現在のパスワードが正しくありません。";
		}
		
		/* 現パスワードと新パスワードが一致していた場合 */
		if (users.getPassword().equals(form.getNewPassword())) {
			return "現在のパスワードと同一文字列が入力されました。";
		}
		
		/* 新パスワードと新パスワード確認が一致していない場合 */
		if (!form.getNewPassword().equals(form.getNewPasswordConfirm())) {
			return "新パスワードと確認用パスワードが一致しません。";
		}
		
		/* パスワード更新 */
		mstUserMapper.updatePassword(users.getUserName(), form.getNewPassword());
		
		/* パスワード再設定によるログインセッションの更新 */
		loginSession.setPassword(form.getNewPassword());
		
		return "パスワードが再設定されました。";
	}
	
}