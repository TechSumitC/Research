package com.sumit.aop.looger.test.service;
import org.springframework.stereotype.Service;

import com.sumit.aop.logger.aspect.annotations.ExceptionLoggerAnnotation;
@Service
public class AopServiceTestMocker {
	//@AroundLoggerAnnotation
	public Integer multiply(int a, int b){
		int $ = a*b;
		System.out.println(a+ " * " + b +" = " + $);
		return $;
	}
	@ExceptionLoggerAnnotation
	public void AopThrowTestMocker(int z, int k){
		
		int $= z/k;
		System.out.println("In Throw Test Mocker Function "+ $);
//		try{
//			int $= z+k;
//			System.out.println("In Throw Test Mocker Function "+ $);
//			throw new Exception("Exception");
//		}catch(Exception exception){
//			//System.err.println("Exception Thrown");
//		}finally{
//			//System.err.println("Finally called after catch");
//		}
		
	}
}
