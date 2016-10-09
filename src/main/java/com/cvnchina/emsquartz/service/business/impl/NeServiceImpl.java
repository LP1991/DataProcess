package com.cvnchina.emsquartz.service.business.impl;

import java.util.List;
import java.util.Map;

import com.cvnchina.emsquartz.dataaccess.NeMapper;

import com.cvnchina.emsquartz.service.business.NeService;


//@Component("neService")
public class NeServiceImpl implements NeService{
	
//	@Autowired
	private NeMapper neMapper;

	/* (non-Javadoc)
	 * @see com.cvnchina.emsquartz.service.business.QueryService#queryAll(java.util.Map)
	 */
	public List<Object> queryAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cvnchina.emsquartz.service.business.QueryService#queryAllCount(java.util.Map)
	 */
	public int queryAllCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.cvnchina.emsquartz.service.business.QueryService#add(java.util.Map)
	 */
	public int add(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.cvnchina.emsquartz.service.business.QueryService#edit(java.util.Map)
	 */
	public int edit(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.cvnchina.emsquartz.service.business.QueryService#del(int)
	 */
	public int del(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.cvnchina.emsquartz.service.business.NeService#getNeNum()
	 */
	public int getNeNum() {
		// TODO Auto-generated method stub
		return neMapper.getNeNum();
	}

	
	
}
