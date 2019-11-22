package asia.neg.service;

import asia.neg.pojo.UserExample;
import asia.neg.pojo.UserPojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
   
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserPojo record);

    int insertSelective(UserPojo record);

    List<UserPojo> selectByExample(UserExample example);

    List<UserPojo> selectAll();

    UserPojo selectByPrimaryKey(Integer id);
  
    int updateByExampleSelective(@Param("record") UserPojo record, @Param("example") UserExample example);

    int updateByExample(@Param("record") UserPojo record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(UserPojo record);

    int updateByPrimaryKey(UserPojo record);
}
