/**
 * 
 */
package com.sumit.aop.logger.test.component;

import org.springframework.stereotype.Component;

import com.sumit.aop.logger.aspect.annotations.AfterLoggerAnnotation;
import com.sumit.aop.logger.aspect.annotations.AroundLoggerAnnotation;

/**
 * @author sumitchawla
 *
 */
@Component
public class AopComponentTestMocker {
	//@AroundLoggerAnnotation
	@AfterLoggerAnnotation
	public void Divide(int x, int y) {
		int $= x/y;
		System.out.println("Divide is " + $);
		
	}

}
