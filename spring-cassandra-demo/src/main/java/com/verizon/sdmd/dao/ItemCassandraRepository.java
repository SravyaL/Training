package com.verizon.sdmd.dao;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.verizon.sdmd.model.Item;

public interface ItemCassandraRepository extends CassandraRepository<Item, Integer> {

}
