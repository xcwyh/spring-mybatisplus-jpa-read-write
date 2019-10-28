package com.xc.controller;

import com.alibaba.fastjson.JSONObject;
import com.xc.entity.jpa.Person;
import com.xc.param.PersonParam;
import com.xc.service.IPersonService;
import com.xc.util.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/person")
@Slf4j
public class PersonController {

    @Autowired
    private IPersonService personService;

    @GetMapping
    public JSONObject listByParam(PersonParam personParam) {
        log.info("查看开始");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", HttpServletResponse.SC_OK);
        jsonObject.put("data", personService.listByParam(personParam));
        jsonObject.put("message", "获取成功");
        log.info("查看结束");
        return jsonObject;
    }

    @PostMapping
    public JSONObject add(PersonParam personParam) {
        log.info("添加开始");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", HttpServletResponse.SC_OK);
        Person person = ObjectUtils.convert(personParam, Person.class);
        jsonObject.put("data", personService.add(person));
        jsonObject.put("message", "添加成功");
        log.info("添加结束");
        return jsonObject;
    }

    @PutMapping
    public JSONObject update(PersonParam personParam) {
        log.info("修改开始");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", HttpServletResponse.SC_OK);
        Person person = ObjectUtils.convert(personParam, Person.class);
        jsonObject.put("data", personService.update(person));
        jsonObject.put("message", "修改成功");
        log.info("修改结束");
        return jsonObject;
    }

    @DeleteMapping(value = "{id}")
    public JSONObject delete(@PathVariable Integer id) {
        log.info("删除开始");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", HttpServletResponse.SC_OK);
        personService.delete(id);
        jsonObject.put("message", "删除成功");
        log.info("删除结束");
        return jsonObject;
    }

    @GetMapping(value = "{id}")
    public JSONObject get(@PathVariable Integer id) {
        log.info("ID查看开始");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", HttpServletResponse.SC_OK);
        jsonObject.put("data", personService.findById(id));
        jsonObject.put("message", "ID查看成功");
        log.info("ID查看结束");
        return jsonObject;
    }

    @GetMapping(value = "findByName/{name}")
    public JSONObject findByName(@PathVariable String name) {
        log.info("name查看开始");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", HttpServletResponse.SC_OK);
        jsonObject.put("data", personService.findByName(name));
        jsonObject.put("message", "name查看成功");
        log.info("name查看结束");
        return jsonObject;
    }

}
