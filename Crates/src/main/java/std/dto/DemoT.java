package std.dto;

import java.io.Serializable;

/**
 * demo_t
 * @author
 */
public class DemoT implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String organization;
    private Integer age;

    public DemoT(Long id, String name, String organization, Integer age){
        this.id = id;
        this.name = name;
        this.organization = organization;
        this.age = age;
    }

    public DemoT(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}