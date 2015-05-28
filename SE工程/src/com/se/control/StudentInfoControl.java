package com.se.control;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.se.dao.StudentInfoTableDAO;
import com.se.factory.HibernateSessionFactory;
import com.se.model.StudentInfoTable;

public class StudentInfoControl {
	
	private static StudentInfoControl siControl = null;
	public static StudentInfoControl getStudentInfoControl(){
		if(siControl == null){
			siControl = new StudentInfoControl();
		}
		return siControl;
	}
	
	private StudentInfoTableDAO studentInfoDao = null;
	private Session session = null;
	
	private StudentInfoControl(){
		studentInfoDao = new StudentInfoTableDAO();
		session = HibernateSessionFactory.getSession();
	}
	//����ѧ����Ϣ
	public void save(StudentInfoTable instance){
		Transaction transaction = session.beginTransaction();
		studentInfoDao.save(instance);
		transaction.commit();
		session.flush();
	}
	
	//��ѯһ��ѧ��
	public StudentInfoTable findStudent(String stuNo){
		Transaction transaction = session.beginTransaction();
		StudentInfoTable student = studentInfoDao.findById(stuNo);
		transaction.commit();
		session.flush();
		return student;
		
	}
	
	//ɾ��һ��ѧ��
	public void delete(StudentInfoTable student){
		Transaction transaction = session.beginTransaction();
		studentInfoDao.delete(student);
		transaction.commit();
		session.flush();
	}
	
	//�õ�����ѧ������Ϣ
	public List<StudentInfoTable> getAllStudent(){
		List<StudentInfoTable> list = studentInfoDao.findAll();
		return list;
	}
	
	//����ѧ����Ϣ
	public void updateStudent(StudentInfoTable student){
		Transaction tr = session.beginTransaction();
		studentInfoDao.attachDirty(student);
		tr.commit();
		session.flush();
	}
	
	
	
	
	

}
