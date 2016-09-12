package com.ibm.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ApplyTraceAspect {
    
    public static Level sizeLevel = Level.FINER;
    
    public static boolean secure = false;
    
    public static boolean trace = true;
    
    public static boolean printReturnValue = true;

    public static Logger serviceLogger = FakeClassWithAspect.SERVICE_LOGGER;
    
    public static void reset() {
        sizeLevel = Level.FINER;
        secure = false;
        trace = true;
        serviceLogger = FakeClassWithAspect.SERVICE_LOGGER;
    }
    
    @Around( "execution(com.ibm.logger.FakeClassWithAspect.new(int))" )
    public Object aroundConstructorWithLogger( ProceedingJoinPoint point ) throws Throwable {
        return TraceUtilities.traceAndMeasureConstructorJoinPointWithLogger( point, sizeLevel, secure, serviceLogger, "Operation : ", printReturnValue );
    }
    
    @Around( "execution(com.ibm.logger.FakeClassWithAspect.new(String))" )
    public Object aroundConstructor( ProceedingJoinPoint point ) throws Throwable {
        return TraceUtilities.traceAndMeasureConstructorJoinPoint( point, sizeLevel, secure, trace );
    }
    
    @Around( "execution(* com.ibm.logger.FakeClassWithAspect.methodWithTrace(..))" )
    public Object aroundTrace( ProceedingJoinPoint point ) throws Throwable {
        return TraceUtilities.traceAndMeasureJoinPoint( point, sizeLevel, secure, trace );
    }

    @Around( "execution(* com.ibm.logger.FakeClassWithAspect.methodWithServiceLogger(..))" )
    public Object aroundService( ProceedingJoinPoint point ) throws Throwable {
        return TraceUtilities.traceAndMeasureJoinPointWithLogger( point, sizeLevel, secure, serviceLogger, "Operation : ", printReturnValue );
    }
}
