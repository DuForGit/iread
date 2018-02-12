package com.iread.font.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iread.beans.domain.Class;
import com.iread.font.dao.BooksNavMapper;
import com.iread.font.service.BooksNavListService;

//没写@Service
//Context initialization failed
//org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'booksController': Unsatisfied dependency expressed through field 'nav'; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.iread.font.service.BooksNavListService' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}

@Service
public class BooksNavListServiceImpl implements BooksNavListService {
	
	@Autowired
	private BooksNavMapper nav;
	
	/* (non-Javadoc)
	 * @see com.iread.font.service.BooksNavListService#getBookNavs()
	 */
	@Override
	public List<Class> getBookNavs() {
		return nav.booksNavList();
	}
	
}
