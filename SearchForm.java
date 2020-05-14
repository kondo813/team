package jp.co.internous.smile.model.form;
//Webフロントから渡されるデータをJavaオブジェクトにマッピングするためのクラス

public class SearchForm {
	
	private String kensaku;
	private int category;
	
	public String getKensaku() {
		return kensaku;
	}
	public void setKensaku(String kensaku) {
		this.kensaku = kensaku;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
}
