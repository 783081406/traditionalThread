package com.ccjjltx.ThreadShareVariable;

/**
 * entity
 *
 * @author ccj
 * @version 1.0
 * @since 1.8
 */
public class MyThreadScopeData {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyThreadScopeData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
