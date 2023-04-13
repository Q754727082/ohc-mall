package com.ohc.controller;

import com.ohc.model.Comm;
import com.ohc.model.Commodity;
import com.ohc.model.CommodityResult;
import com.ohc.model.CountNumber;
import com.ohc.result.Result;
import com.ohc.result.ResultFactory;
import com.ohc.service.CommodityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @PostMapping("/search")
    public Result search(Commodity commodity){
        PageHelper.startPage(commodity.getPageable().get("pageNum"),commodity.getPageable().get("pageSize"));
        List<Commodity> commodityList = commodityService.search(commodity);
        PageInfo<Commodity> commodityPageInfo = new PageInfo<>(commodityList);
        return ResultFactory.buildSuccessResult(commodityPageInfo);
    }

    @PostMapping("/searchByStore")
    public Result searchByStore(Commodity commodity){
        PageHelper.startPage(commodity.getPageable().get("pageNum"),commodity.getPageable().get("pageSize"));
        List<Commodity> commodityList = commodityService.searchByStore(commodity);
        PageInfo<Commodity> commodityPageInfo = new PageInfo<>(commodityList);
        return ResultFactory.buildSuccessResult(commodityPageInfo);
    }

    @RequestMapping(value = "/get",method = RequestMethod.POST)
    public Commodity get(Integer id){
        return commodityService.selectOne(id);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(Commodity commodity){
        return commodityService.updateOne(commodity);
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String create(Commodity commodity){
        return commodityService.create(commodity);
    }

    @RequestMapping(value = "/updateStatus",method = RequestMethod.POST)
    public void updateStatus(Commodity commodity){
        commodityService.updateStatus(commodity);
    }

    @RequestMapping(value = "/getDetails",method = RequestMethod.POST)
    public Commodity getDetails(Integer id){
        return commodityService.selectOne(id);
    }

    @RequestMapping(value = "/countNumber",method = RequestMethod.POST)
    public CommodityResult countNumber(@RequestBody List<CountNumber> countNumber){
        return commodityService.countNumber(countNumber);
    }

    @RequestMapping(value = "/changeNumber",method = RequestMethod.POST)
    public void changeNumber(@RequestBody List<Comm> comm){
        commodityService.changeNumber(comm);
    }
}
