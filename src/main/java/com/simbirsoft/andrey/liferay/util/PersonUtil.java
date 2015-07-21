package com.simbirsoft.andrey.liferay.util;

import java.util.ArrayList;
import java.util.List;

import com.simbirsoft.andrey.liferay.model.Person;
import com.simbirsoft.andrey.liferay.vo.PersonVO;

public abstract class PersonUtil {
	public static List<PersonVO> getPersonVOList(List<Person> personList) {
		List<PersonVO> personsVO = new ArrayList<PersonVO>();
		if (personList != null && !personList.isEmpty()) {
			for (Person person : personList) {
				PersonVO personVO = new PersonVO(person);
				personsVO.add(personVO);
			}
		}
		return personsVO;
	}
}
