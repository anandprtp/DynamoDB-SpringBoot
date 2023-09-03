package com.atlasproject2.dynamoproject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.atlasproject2.dynamoproject.entity.Person;

@Repository
public class PersonRepository {
    
    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public List<Person> findAll() {
        return dynamoDBMapper.scan(Person.class, new DynamoDBScanExpression());
    }
    public Person findById(String id){
        return dynamoDBMapper.load(Person.class,id);
    }
    public Person save(Person person) {
        dynamoDBMapper.save(person);
        return person;
    }
    public String update(String id, Person person) {
        dynamoDBMapper.save(person, new DynamoDBSaveExpression()
        .withExpectedEntry("id", 
        new ExpectedAttributeValue(new AttributeValue().withS(id))));
        return id;
    }
    public String delete(String id) {
        Person person = dynamoDBMapper.load(Person.class,id);
        dynamoDBMapper.delete(person);
        return id;
    }

    public Person incrementAge(String id) {
        Person person = dynamoDBMapper.load(Person.class, id);
        person.incrementAge();
        dynamoDBMapper.save(person, new DynamoDBSaveExpression()
        .withExpectedEntry("id", 
        new ExpectedAttributeValue(new AttributeValue().withS(id))));
        return person;
    }
}
