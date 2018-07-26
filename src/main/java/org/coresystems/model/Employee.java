package org.coresystems.model;

import com.google.gson.annotations.Expose;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author master
 */
@Entity
@Table(name = "employees")
public class Employee{
    
    @Id
    @Expose(deserialize = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Column(name = "name")
    private String name;
    
    @NotNull
    @Column(name = "position")
    private String position;
    
    public Employee(){}
    
    public Employee(String name, String position)
    {
        this.name = name;
        this.position = position;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }
    
    public Integer getId()
    {
        return id;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setPosition(String position)
    {
        this.position = position;
    }
    
    public String getPosition()
    {
        return position;
    }
    
}
