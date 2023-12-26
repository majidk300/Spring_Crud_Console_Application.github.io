package com.spring.orm.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Stuudent;

public class StudentDao {
	
    private HibernateTemplate hibernateTemplate;

    @Transactional
	public int insert(Stuudent student) {
		
		Integer i= (Integer) this.hibernateTemplate.save(student);
		return i;
	}
    
    public Stuudent getStudent(int studentId) {
    	Stuudent student = this.hibernateTemplate.get(Stuudent.class, studentId);
    	return student;
    }
    
    public List<Stuudent> getAllStudents(){
    	List<Stuudent> student  = this.hibernateTemplate.loadAll(Stuudent.class);
    	return student;
    }
    
    @Transactional
    public void deleteStudent(int studentId) {
    	Stuudent student = this.hibernateTemplate.get(Stuudent.class, studentId);
    	this.hibernateTemplate.delete(student);
    }
    
    @Transactional
    public void studentUpdate(Stuudent student) {
    	this.hibernateTemplate.update(student);
    }

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	

}
