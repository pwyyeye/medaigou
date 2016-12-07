package com.xxl.medaigou.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxl.medaigou.bo.TempOrder;
import com.xxl.medaigou.dao.IMedaigouDao;
import com.xxl.medaigou.facade.TempRemote;
import common.exception.BaseException;
import common.service.BaseService;
import common.temp.vo.TempOrderVo;
import common.utils.SemAppUtils;
import common.value.PageList;

@Service("tempRemote")
public class TempService extends BaseService implements TempRemote{

	public Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	IMedaigouDao medaigouDAO;
	
	public TempOrderVo getTempOrder(Integer id){
		TempOrder rootModule = (TempOrder)medaigouDAO.loadBoById(
				TempOrder.class, id);
		return (TempOrderVo) rootModule.toVO();
	}
	
	public Integer addTempOrder(TempOrderVo vo) throws BaseException {
		Integer result = null;
		logger.debug(" addTempOrder" + vo);
		
		try {
			//hibernateSession = HibernateUtil.currentSession();
			
			TempOrder bo = new TempOrder();
			SemAppUtils.beanCopy(vo, bo);
			medaigouDAO.saveOrUpdate(bo);
			result = (Integer) bo.getId();
			vo.setId(result);
		} catch (HibernateException ee) {
			logger.error(ee);
			throw new BaseException("新增订单失败" + ee.getMessage());

		}
		return result;
	}
	
	public PageList getTempOrderList(
			TempOrderVo searchVO, Integer firstResult, Integer fetchSize)
			throws BaseException {
		try {

			DetachedCriteria criteria = DetachedCriteria.forClass(TempOrder.class);
			if(searchVO.getId()!=null){
				criteria.add(Expression.eq("id", searchVO.getId()));
			}
			criteria.addOrder(Order.desc("id"));
			PageList pageList=medaigouDAO.findByCriteriaByPage(criteria, firstResult, fetchSize);

			return pageList;
		} catch (HibernateException ee) {
			throw new BaseException("数据库操作异常", ee);
		}
	}
	
	
}
