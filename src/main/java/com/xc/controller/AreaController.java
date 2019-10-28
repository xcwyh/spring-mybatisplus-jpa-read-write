package com.xc.controller;

import com.alibaba.fastjson.JSONObject;
import com.xc.entity.mybatisplus.Area;
import com.xc.param.AreaParam;
import com.xc.service.IAreaService;
import com.xc.util.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/area")
@Slf4j
public class AreaController {

    @Autowired
    private IAreaService areaService;

    @GetMapping
    public JSONObject listByParam(AreaParam areaParam) {
        log.info("查看开始");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", HttpServletResponse.SC_OK);
        jsonObject.put("data", areaService.listByParam(areaParam));
        jsonObject.put("message", "获取成功");
        log.info("查看结束");
        return jsonObject;
    }

    @PostMapping
    public JSONObject add(AreaParam areaParam) {
        log.info("添加开始");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", HttpServletResponse.SC_OK);
        Area area = ObjectUtils.convert(areaParam, Area.class);
        jsonObject.put("data", areaService.save(area));
        jsonObject.put("message", "添加成功");
        log.info("添加结束");
        return jsonObject;
    }

    @PutMapping
    public JSONObject update(AreaParam areaParam) {
        log.info("修改开始");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", HttpServletResponse.SC_OK);
        Area area = ObjectUtils.convert(areaParam, Area.class);
        jsonObject.put("data", areaService.updateById(area));
        jsonObject.put("message", "修改成功");
        log.info("修改结束");
        return jsonObject;
    }

    @DeleteMapping(value = "{id}")
    public JSONObject delete(@PathVariable Integer id) {
        log.info("删除开始");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", HttpServletResponse.SC_OK);
        jsonObject.put("data", areaService.removeById(id));
        jsonObject.put("message", "删除成功");
        log.info("删除结束");
        return jsonObject;
    }

    @GetMapping(value = "{id}")
    public JSONObject get(@PathVariable Integer id) {
        log.info("ID查看开始");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", HttpServletResponse.SC_OK);
        jsonObject.put("data", areaService.findById(id));
        jsonObject.put("message", "ID查看成功");
        log.info("ID查看结束");
        return jsonObject;
    }

    @GetMapping(value = "findByName/{name}")
    public JSONObject findByName(@PathVariable String name) {
        log.info("name查看开始");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", HttpServletResponse.SC_OK);
        jsonObject.put("data", areaService.findByName(name));
        jsonObject.put("message", "name查看成功");
        log.info("name查看结束");
        return jsonObject;
    }

}
