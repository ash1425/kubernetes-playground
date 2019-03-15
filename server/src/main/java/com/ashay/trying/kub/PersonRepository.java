package com.ashay.trying.kub;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "people", collectionResourceRel = "people")
public interface PersonRepository extends MongoRepository<Person, String> {
}
