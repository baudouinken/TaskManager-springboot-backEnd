package com.ken.employee.transfer.chef;

import java.util.List;
import java.util.stream.Collectors;

import com.ken.employee.model.Chef;

public class Chef2ChefListReadTO {

	public static ChefListReadTO apply(Chef in) {

		ChefListReadTO out = new ChefReadTO();
		out.setChefId(in.getChefId());
		out.setName(in.getName());
		out.setEmail(in.getEmail());
		out.setDepartment(in.getDepartment());
		out.setPhone(in.getPhone());
		out.setImageUrl(in.getImageUrl());
		out.setCode(in.getCode());
		out.setAuthId(in.getAuthId());

		return out;
	}

	public static List<ChefListReadTO> apply(List<Chef> in) {
		return in.stream().map(e -> apply(e)).collect(Collectors.toList());
	}

}
