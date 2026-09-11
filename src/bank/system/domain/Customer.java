package bank.system.domain;

public class Customer {
    private String name;
    private int age;
    private String cpf;

    public Customer(String name, int age, String cpf) {
        this.name = name;
        this.age = age;
        this.cpf = cpf;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getCpf() {
        return this.cpf;
    }
}
