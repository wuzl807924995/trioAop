package test.path.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FaceImpl implements Face {

	private static final List<UserBean> LIST = new ArrayList<>();
	static {
		UserBean u1 = new UserBean(1, "W1");
		UserBean u2 = new UserBean(2, "W2");
		UserBean u3 = new UserBean(3, "z3");
		List<UserBean> beans = Arrays.asList(u1, u2, u3);
		for (UserBean userBean : beans) {
			LIST.add(userBean);
		}
	}

	@Override
	public UserBean getByid(Integer id) {
		System.out.println("getByid");
		UserBean userBean = LIST.get(id);
		return userBean;
	}

	@Override
	public UserBean getByid_xml(int id) {
		System.out.println("getByid_xml");
		return LIST.get(id);
	}

	@Override
	public List<UserBean> getAll() {
		System.out.println("getAll");
		return LIST;
	}

	@Override
	public List<UserBean> getAll_xml() {
		System.out.println("getAll_xml");
		return LIST;
	}

	@Override
	public Map<Integer, UserBean> getAllMap() {
		System.out.println("getAllMap");
		Map<Integer, UserBean> map = new HashMap<>();
		for (UserBean userBean : LIST) {
			map.put(userBean.getId(), userBean);
		}
		return map;
	}

	@Override
	public List<Map<Integer, UserBean>> getAllListMap() {
		List<Map<Integer, UserBean>> list = new ArrayList<>();
		for (UserBean userBean : LIST) {
			Map<Integer, UserBean> map = new HashMap<>();
			map.put(userBean.getId(), userBean);
			list.add(map);
		}
		return list;
	}

	@Override
	public Map<Integer, List<UserBean>> getAllMapList() {
		System.out.println("getAllMapList");
		Map<Integer, List<UserBean>> map = new HashMap<>();
		map.put(1, LIST);
		map.put(2, LIST);
		map.put(3, LIST);
		return map;
	}

}
