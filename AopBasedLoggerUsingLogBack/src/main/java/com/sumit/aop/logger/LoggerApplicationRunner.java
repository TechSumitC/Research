package com.sumit.aop.logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sumit.aop.logger.config.LoggingConfig;
import com.sumit.aop.logger.test.component.AopComponentTestMocker;
import com.sumit.aop.looger.test.service.AopServiceTestMocker;
public class LoggerApplicationRunner {
   public static void main(String[] args) {
       AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
       ctx.register(LoggingConfig.class);
       ctx.refresh();
       AopServiceTestMocker userService = ctx.getBean(AopServiceTestMocker.class);
       userService.multiply(2, 3);
       userService.AopThrowTestMocker(11,0);
       AopComponentTestMocker divide = ctx.getBean(AopComponentTestMocker.class);
       divide.Divide(0, 10);
       ctx.close();
   }
}
