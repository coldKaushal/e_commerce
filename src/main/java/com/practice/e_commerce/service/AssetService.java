package com.practice.e_commerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.e_commerce.model.Asset;
import com.practice.e_commerce.repo.AssetRepo;

@Service
public class AssetService {

    @Autowired
    private AssetRepo assetRepo;

    public Asset addNewAsset(Asset asset){
        return assetRepo.save(asset);
    }

    public Iterable<Asset> getAllAsset(){
        return assetRepo.findAll();
    }

    public Optional<Asset> getAssetById(String id){
        return assetRepo.findById(id);
    }

    public String deleteAsset(String id){
        try {
            assetRepo.deleteById(id);
            return "Asset Deleted";
        } catch (Exception e) {
            return "Something went wrong while deleting the asset: " + e.getMessage();
        }
    }

    public String addCountOfAsset(String id, Long countOfNewAsset){
        Asset asset = assetRepo.findById(id).orElse(null);
        if(asset==null){
            return "Asset not found";
        }
        asset.setAssetCount(countOfNewAsset + asset.getAssetCount());
        assetRepo.save(asset);
        return asset.toString();
    }

    public String removeCountOfAsset(String id, Long countOfAssetToDelete){
        Asset asset = assetRepo.findById(id).orElse(null);
        if(asset==null){
            return "Asset not found";
        }
        if(countOfAssetToDelete > asset.getAssetCount()){
            return "Total asset count with this id is less than the requested delete count";
        }
        asset.setAssetCount(asset.getAssetCount()-countOfAssetToDelete);
        assetRepo.save(asset);
        return asset.toString();
    }
}
