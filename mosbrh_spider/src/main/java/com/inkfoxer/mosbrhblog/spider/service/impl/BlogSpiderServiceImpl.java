package com.inkfoxer.mosbrhblog.spider.service.impl;


import com.inkfoxer.mosbrhblog.spider.entity.BlogSpider;
import com.inkfoxer.mosbrhblog.spider.mapper.BlogSpiderMapper;
import com.inkfoxer.mosbrhblog.spider.service.BlogSpiderService;
import com.inkfoxer.mosbrhblog.base.serviceImpl.SuperServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客爬取服务实现类
 * </p>
 *
 * @author 灵雨
 * @since 2020年2月7日21:29:42
 */
@Slf4j
@Service
public class BlogSpiderServiceImpl extends SuperServiceImpl<BlogSpiderMapper, BlogSpider> implements BlogSpiderService {

}
