package com.example.demo.api.dao.impl;

import com.example.demo.api.dao.AlbumDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("AlbumDao")
public class AlbumDaoImpl implements AlbumDao {

    @Autowired
    private SqlSession mapper;


}
