package com.dailycodebuffer.department.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.department.entity.Department;
import com.dailycodebuffer.department.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}

	public Department findDepartmentById(Long departmentId) {
		// TODO Auto-generated method stub
		return departmentRepository.findByDepartmentId(departmentId);
	}
	

	public Department updateDepartment(Department department) {
		
		Department updateDepartment = departmentRepository.findByDepartmentId(department.getDepartmentId());
		
		if(updateDepartment != null) {
			updateDepartment.setDepartmentName(department.getDepartmentName());
			updateDepartment.setDepartmentAddress(department.getDepartmentAddress());
			updateDepartment.setDepartmentCode(department.getDepartmentCode());
			departmentRepository.save(updateDepartment);
			return updateDepartment;
		}
		return null;
	}

	public List<Department> getDepartment() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	public Long deleDepartment(Long departmentId) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(departmentId);
		return departmentRepository.count();
	}

	public Department updateDepartmentByFields(Long id, Map<String, Object> fields) {
		  Optional<Department> existingProduct = departmentRepository.findById(id);
	        if (existingProduct.isPresent()) {
	            fields.forEach((key, value) -> {
	                Field field = ReflectionUtils.findRequiredField(Department.class,key);
	                field.setAccessible(true);
	                ReflectionUtils.setField(field, existingProduct.get(), value);
	            });
	            return departmentRepository.save(existingProduct.get());
	        }
	        return null;
	}


}
