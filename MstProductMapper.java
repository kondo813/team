package jp.co.internous.smile.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.smile.model.domain.MstProduct;

@Mapper
public interface MstProductMapper {

	@Select("SELECT * FROM mst_product")
	List<MstProduct> find();

	/*商品名検索*/
	List<MstProduct> findByProductName(@Param("kensaku") String[] kensaku);
 	
	/*カテゴリー＆商品名検索*/
	List<MstProduct> findByCategoryAndProductName(@Param("category") int category, @Param("kensaku") String[] kensaku);

	/*商品IDを抽出*/
	@Select("SELECT * FROM mst_product WHERE id = #{id}")
	MstProduct findById(@Param("id") int id); /*@Param()の()内は、SELECT文の条件指定のカラム(#{})に対応*/

}