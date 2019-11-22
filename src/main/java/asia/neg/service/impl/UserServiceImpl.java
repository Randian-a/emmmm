package asia.neg.service.impl;

import asia.neg.mapper.user.UserMapper;
import asia.neg.pojo.UserExample;
import asia.neg.pojo.UserPojo;
import asia.neg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public long countByExample(UserExample example){
    	return userMapper.countByExample(example);
    }
	@Override
	public int deleteByExample(UserExample example){
    	return userMapper.deleteByExample(example);
    }
	@Override
	public int deleteByPrimaryKey(Integer id){
    	return userMapper.deleteByPrimaryKey(id);
    }
	@Override
	public int insert(UserPojo record){
    	return userMapper.insert(record);
    }
	@Override
	public int insertSelective(UserPojo record){
    	return userMapper.insertSelective(record);
    }
	@Override
	public List<UserPojo> selectByExample(UserExample example){
    	return userMapper.selectByExample(example);
    }
    @Override
	public List<UserPojo> selectAll(){
    	return userMapper.selectAll();
    }
	@Override
	public UserPojo selectByPrimaryKey(Integer id){
    	return userMapper.selectByPrimaryKey(id);
    }
	@Override
	public int updateByExampleSelective(UserPojo record, UserExample example){
    	return userMapper.updateByExampleSelective(record, example);
    }
	@Override
	public int updateByExample(UserPojo record, UserExample example){
    	return userMapper.updateByExample(record, example);
    }
	@Override
	public int updateByPrimaryKeySelective(UserPojo record){
    	return userMapper.updateByPrimaryKeySelective(record);
    }
	@Override
	public int updateByPrimaryKey(UserPojo record){
    	return userMapper.updateByPrimaryKey(record);
    }
}
