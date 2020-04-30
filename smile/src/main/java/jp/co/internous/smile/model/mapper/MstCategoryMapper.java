package jp.co.internous.smile.model.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.smile.model.domain.MstCategory;

@Mapper
public interface MstCategoryMapper {
	
	@Select("SELECT * FROM mst_category")
	List<MstCategory> find();
}
