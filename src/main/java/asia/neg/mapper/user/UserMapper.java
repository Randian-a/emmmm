package asia.neg.mapper.user;


import asia.neg.mapper.MyBatisBaseMapper;
import asia.neg.pojo.UserExample;
import asia.neg.pojo.UserPojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * UserDAO继承基类
 */
@Mapper
public interface UserMapper extends MyBatisBaseMapper<UserPojo, Integer, UserExample> {
}