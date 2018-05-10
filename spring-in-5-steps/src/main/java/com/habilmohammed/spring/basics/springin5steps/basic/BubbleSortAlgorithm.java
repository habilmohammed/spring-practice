package com.habilmohammed.spring.basics.springin5steps.basic;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BubbleSortAlgorithm implements SortAlgorithm {

	@Override
	public int sort() {
		// TODO Auto-generated method stub
		
		return 1;
	}
	

}
