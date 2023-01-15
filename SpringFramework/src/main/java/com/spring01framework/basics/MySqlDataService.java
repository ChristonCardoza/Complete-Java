package com.spring01framework.basics;

import org.springframework.stereotype.Repository;

//@Component
@Repository
public class MySqlDataService implements DatabaseService {

	@Override
	public int[] retrieveData() {
		return new int[] { 1, 2, 3, 4, 5 };
	}

}
