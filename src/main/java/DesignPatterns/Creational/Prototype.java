package DesignPatterns.Creational;

interface Prototype extends Cloneable {
    Prototype clone();
}

class Employee implements Prototype
{
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }


    @Override
    public Prototype clone() {
        try
        {
            return (Employee) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("e = " + e);
            return null;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

class PrototypeExample {
    public static void main(String[] args) {
        Employee e = new Employee(null ,null);

        e.setDepartment("CSEE");
        e.setName("HELLO");



        Employee e2 = (Employee) e.clone();

        e.setDepartment("EXCE");
        System.out.println("e = " + e);

        System.out.println("e2 = " + e2);
    }
}