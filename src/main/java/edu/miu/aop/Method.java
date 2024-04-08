package edu.miu.aop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Method {
    private String name;
    private String returnType;
    private String[] parameterTypes;

    // Constructor
    public Method(String name, String returnType, String[] parameterTypes) {
        this.name = name;
        this.returnType = returnType;
        this.parameterTypes = parameterTypes;
    }
    public Method getMethod() {
        return new Method(name, returnType, parameterTypes);
    }

    public void addMethod(String methodName, String returnType, String[] parameterTypes) {
        this.name = methodName;
        this.returnType = returnType;
        this.parameterTypes = parameterTypes;
    }

    public ExecutionTime getAnnotation(Class<ExecutionTime> executionTimeClass) {
        return executionTimeClass.getAnnotation(ExecutionTime.class);
    }

    public Class<Object> getDeclaringClass() {
        return Object.class;
    }
}
