package org.example.ba03;

import org.example.ba02.Student;

public interface SomeService {
    void doSome(String name,Integer age);
    String doOther(String name,Integer age);
    Student doOther2(String name, Integer age);

    String doFirst(String name,Integer age);

}
