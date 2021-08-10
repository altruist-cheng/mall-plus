package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Region;
import com.cskaoyan.mall.bean.RegionExample;
import com.cskaoyan.mall.mapper.RegionMapper;
import com.cskaoyan.mall.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author Created by altruist_cheng on 2021-08-10 17:28
 * @version 1.0
 */
@Service
public class MarketServiceImpl implements MarketService {

    @Autowired
    RegionMapper regionMapper;

    @Override
    public List<Region> getRegionList() {
        List<Region> regionList = regionMapper.selectByExample(new RegionExample());
        ArrayList<Region>  regionsList2= new ArrayList<>();
        for (Region reg1 : regionList) {
            if (reg1.getType() == 1) {
                for (Region reg2 : regionList) {
                    if (reg2.getType() == 2) {
                        for (Region reg3 : regionList) {
                            if (reg3.getType() == 3 && reg3.getPid().equals(reg2.getId())) {
                                if (reg2.getChildren() != null)
                                    reg2.getChildren().add(reg3);
                                else {
                                    reg2.setChildren(new LinkedHashSet<>());
                                    reg2.getChildren().add(reg3);
                                }
                            }
                        }
                        if (reg2.getPid().equals(reg2.getId())) {
                            if (reg1.getChildren() != null)
                                reg1.getChildren().add(reg2);
                            else {
                                reg1.setChildren(new LinkedHashSet<>());
                                reg1.getChildren().add(reg2);
                            }
                        }
                    }
                }
                regionsList2.add(reg1);
            }
        }
        return regionsList2;
    }
}
