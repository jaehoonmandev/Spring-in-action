package com.skateboard.data;

import com.skateboard.DTO.Parts;
import org.springframework.data.repository.CrudRepository;

public interface PartsRepository extends CrudRepository<Parts, String> {

}