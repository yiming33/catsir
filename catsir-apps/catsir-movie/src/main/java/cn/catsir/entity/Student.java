package cn.catsir.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created by YiMing on 2016/10/31.
 */
public class Student implements Serializable {

	private static final long serialVersionUID = 2503680716941558703L;
	private Integer id;

	@JSONField(serialize = false)
	private String name;

	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
