package in.kumar.AOPDemo.aspect;

import in.kumar.AOPDemo.dto.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

//    @AfterThrowing(
//            value = "execution(* in.kumar.AOPDemo.service.StudentService.createStudent(..))",
//            throwing = "exception"
//    )
//    public void logBeforeMethod(Throwable exception){
//
//        System.out.println(exception.getClass().getName());
//        System.out.println(exception.getMessage());
//
//        System.out.println("AfterThrowing method called");
//
//    }

//    @After(
//            value = "execution(* in.kumar.AOPDemo.service.StudentService.createStudent(..))"
//    )
//    public void logAfterMethod(){
//        System.out.println("logAfterMethod Executed");
//    }

    @Around(
            value = "execution(* in.kumar.AOPDemo.service.StudentService.dummyMethod(..))"
    )
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("Startng Target Method :"+ joinPoint.getSignature().getName());
//
//        try {
//            Object result = (Student) joinPoint.proceed();
//            System.out.println("Execution Successful");
//            return result;
//
//        }
//        catch (Exception e){
//            System.out.println("Some error occured");
//            throw e;
//        }
//        finally {
//            System.out.println("Execution Completed");
//        }

        Object[] arr = joinPoint.getArgs();

        String OriginalArg=(String) arr[0];

        String ModifiedArgs=OriginalArg.toUpperCase();

        Object[] modifiedArr={
                ModifiedArgs
        };
        String returnType = (String) joinPoint.proceed(modifiedArr);
        returnType=returnType +" : Intercepted String";
        return returnType;

    }
}
