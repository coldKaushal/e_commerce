package com.practice.e_commerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PatchExchange;

import com.practice.e_commerce.model.Asset;
import com.practice.e_commerce.service.AssetService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/asset")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @PostMapping
    public String addNewAsset(@RequestBody Asset asset){
        System.out.println(asset);
        try{
            Asset added_asset = assetService.addNewAsset(asset);
            return added_asset.toString();
        }catch(Exception e){
            System.out.println(e);
            return e.getMessage();
        }
    }

    @GetExchange("/all")
    public Iterable<Asset> getAllAsset(){
        return assetService.getAllAsset();
    }

    @GetMapping("/{Id}")
    public String getMethodName(@PathVariable String Id) {
        Optional<Asset> found_asset = assetService.getAssetById(Id);
        return found_asset.toString();
    }
    
    @DeleteMapping("/{Id}")
    public String deleteAssetByID(@PathVariable String Id){
        return assetService.deleteAsset(Id);
    }

    @PatchExchange("/add/{Id}-{Count}")
    public String addCountOfAsset(@PathVariable String Id, @PathVariable Long Count){
        return assetService.addCountOfAsset(Id, Count);
    }

    @PatchMapping("/remove/{Id}-{Count}")
    public String deleteCountOfAsset(@PathVariable String Id, @PathVariable Long Count){
        return assetService.removeCountOfAsset(Id, Count);
    }


}
