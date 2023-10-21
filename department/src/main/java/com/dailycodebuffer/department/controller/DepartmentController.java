package com.dailycodebuffer.department.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.department.entity.Department;
import com.dailycodebuffer.department.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}
	
	   @GetMapping("/{id}")
	   public Department findDepartmentById(@PathVariable ("id") Long departmentId) {
	       return departmentService.findDepartmentById(departmentId);
	   }
	   
	   @PutMapping("/{id}")
	   public Department updateDepartment(@RequestBody Department department) {
		   return departmentService.updateDepartment(department);
	   }
	   
	   @GetMapping("/getdepartments")
	   public List<Department> getDepartments() {
		   return departmentService.getDepartment();
	   }
	   
	   @DeleteMapping("/{departmentId}")
	   public Long deleteDepartment(@PathVariable Long departmentId) {
		   
		   return departmentService.deleDepartment(departmentId);
	   }
	   
	    @PatchMapping("/{id}")
	    public Department updateDepartmentFields(@PathVariable Long id,@RequestBody Map<String, Object> fields){
	        return departmentService.updateDepartmentByFields(id,fields);
	    }

}
