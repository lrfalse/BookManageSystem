package com.sdxmxy.bookmanage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdxmxy.bookmanage.entity.Admin;
import com.sdxmxy.bookmanage.mapper.AdminMapper;
import com.sdxmxy.bookmanage.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl  extends ServiceImpl<AdminMapper,Admin> implements AdminService {
}
