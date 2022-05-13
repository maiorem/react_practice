package com.example.demo.common;



import java.util.Objects;

import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;


public class SequenceGenerator {
	private SequenceGenerator() {}
	
	public static int generateSequence(MongoTemplate mongoTemplate, String seqName) {
		
		//get sequence id
		  Query query = new Query(Criteria.where("_id").is(seqName));

		  //increase sequence id by 1
		  Update update = new Update();
		  update.inc("seq", 1);

		  //return new increased id
		  FindAndModifyOptions options = new FindAndModifyOptions();
		  options.returnNew(true);

		  //this is the magic happened.
		  CustomSequence seqId = 
		     mongoTemplate.findAndModify(query, update, options, CustomSequence.class);

		  if(seqId==null) return 1;
		  return seqId.getSeq();
	}
}
