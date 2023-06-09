package com.cag.core.utils.groovy

import de.hybris.platform.core.model.product.ProductModel
import de.hybris.platform.servicelayer.search.SearchResult
import de.hybris.platform.variants.model.VariantProductModel


String productSkuQuery = "select {pk} from {Product}";
final SearchResult<ProductModel> productModelSearchResult = flexibleSearchService.search(productSkuQuery);
List<ProductModel> products = productModelSearchResult.getResult();

List<ProductModel> productModelList = products.stream().forEach({ p ->
    List<VariantProductModel> l1Variants = p.getVariants();
    List<VariantProductModel> l2Variants;
    if (l2Variants != null){
    l1Variants.forEach({ variant ->
        l2Variants.addAll(variant.getVariants())
    })}
    });

println productModelList;






