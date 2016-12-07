package com.xxl.medaigou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.xxl.medaigou.dao.IMedaigouDao;
import common.dao.impl.BaseDAOImpl;

@Repository("medaigouDAO")
public class MedaigouDaoImpl extends BaseDAOImpl<Object, java.lang.String> implements IMedaigouDao {
	public Log logger = LogFactory.getLog(this.getClass());
	
	private Connection conn;

	private Statement stmt;

	private PreparedStatement pstmt;

	private ResultSet rs;

	private PreparedStatement pstm;

	private DataSource ds = null;

	/**
	 * ȡ�ò��ŵ������ܵĹ���
	 * 
	 * @param deptID
	 *            String ���Ŵ��� ��A510
	 * @throws Exception
	 *             ��ݿ�����쳣
	 * @return String �����ܵ���Ϣ
	 */


	private String formatEmpID(String empID) {
		return (empID.length() == 5) ? "0" + empID : empID;
	}

}
