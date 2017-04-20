package test.path.business;

import java.util.List;
import java.util.Map;

public interface Face {

	UserBean getByid(Integer id);

	UserBean getByid_xml(int id);

	List<UserBean> getAll();

	List<UserBean> getAll_xml();

	Map<Integer, UserBean> getAllMap();

	List<Map<Integer, UserBean>> getAllListMap();

	Map<Integer, List<UserBean>> getAllMapList();
}
