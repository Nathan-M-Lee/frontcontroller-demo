package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.dao.EmployeeDao;
import com.revature.models.Employee;
import com.revature.service.EmployeeService;

public class EmployeeServiceTests {
	
	private EmployeeDao mockdao;
	
	private EmployeeService eserv;
	
	@Before
	public void setup() {
		
		mockdao = mock(EmployeeDao.class);
		eserv = new EmployeeService(mockdao);
		
	}
	
	@After
	public void teardown() {
		eserv = null;
		mockdao = null;
	}
	
	@Test
	public void testConfirmLogin_success() {
		
		// make a fake database
		Employee e1 = new Employee(3, "Scott", "Lang", "Antman", "bugs");
		Employee e2 = new Employee(43, "Clint", "Barton", "Hawkeye", "arrows");
		
		List<Employee> dummyDb = new ArrayList<>();
		dummyDb.add(e1);
		dummyDb.add(e2);
		
		when(mockdao.findAll()).thenReturn(dummyDb);
		
		// expected value, acutal value
		assertEquals(e2, eserv.confirmLogin("Hawkeye", "arrows"));
		
	}
	
	@Test
	public void testConfirmLogin_returnNull1() {
		
		// make a fake database
		Employee e1 = new Employee(3, "Scott", "Lang", "Antman", "bugs");
		Employee e2 = new Employee(43, "Clint", "Barton", "Hawkeye", "arrows");
		
		List<Employee> dummyDb = new ArrayList<>();
		dummyDb.add(e1);
		dummyDb.add(e2);
		
		when(mockdao.findAll()).thenReturn(dummyDb);
		
		// expected value, acutal value
		assertNull(eserv.confirmLogin("Hulk", "smash"));
		
	}
	
	@Test
	public void testConfirmLogin_returnNull2() {
		
		// make a fake database
		Employee e1 = new Employee(3, "Scott", "Lang", "Antman", "bugs");
		Employee e2 = new Employee(43, "Clint", "Barton", "Hawkeye", "arrows");
		
		List<Employee> dummyDb = new ArrayList<>();
		dummyDb.add(e1);
		dummyDb.add(e2);
		
		when(mockdao.findAll()).thenReturn(dummyDb);
		
		// expected value, acutal value
		assertNull(eserv.confirmLogin("Hawkeye", "aarrows"));
		
	}
	
	@Test
	public void testConfirmLogin_returnNull3() {
		
		// make a fake database
		Employee e1 = new Employee(3, "Scott", "Lang", "Antman", "bugs");
		Employee e2 = new Employee(43, "Clint", "Barton", "Hawkeye", "arrows");
		
		List<Employee> dummyDb = new ArrayList<>();
		dummyDb.add(e1);
		dummyDb.add(e2);
		
		when(mockdao.findAll()).thenReturn(dummyDb);
		
		// expected value, acutal value
		assertNull(eserv.confirmLogin("antman", "bugs"));
		
	}
	
	
}
