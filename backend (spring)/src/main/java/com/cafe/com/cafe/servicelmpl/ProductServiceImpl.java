package com.cafe.com.cafe.servicelmpl;

import com.cafe.com.cafe.JWT.JwtFilter;
import com.cafe.com.cafe.constants.CafeConstants;
import com.cafe.com.cafe.dao.ProductDao;
import com.cafe.com.cafe.modal.Category;
import com.cafe.com.cafe.modal.Product;
import com.cafe.com.cafe.service.ProductService;
import com.cafe.com.cafe.utils.CafeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Autowired
    JwtFilter jwtFilter;

    @Override
    public ResponseEntity<String> addNewProduct(Map<String, String> requestMap) {
        try {
            // only admins can add products
            if (jwtFilter.isAdmin()) {
                if (validateProductMap(requestMap, false)) {
                    productDao.save(getProductFromMap(requestMap, false)); // add to db
                    return CafeUtils.getResponseEntity(CafeConstants.PRODUCT_ADDED, HttpStatus.OK);
                }
                return CafeUtils.getResponseEntity(CafeConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
            else {
                return CafeUtils.getResponseEntity(CafeConstants.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // validId is used to distinguish between the 2 use cases -- addNewProduct and updateProduct
    private boolean validateProductMap(Map<String, String> requestMap, boolean validateId) {
        if (requestMap.containsKey("name")) {
            if (requestMap.containsKey("id") && validateId) {
                return true;
            }
            else if (!validateId) {
                return true;
            }
        }
        return false;
    }

    // validId is used to distinguish between the 2 use cases -- addNewProduct and updateProduct
    private Product getProductFromMap(Map<String, String> requestMap, boolean isAdd) {
        Category category = new Category();
        category.setId(Integer.parseInt(requestMap.get("categoryId"))); // retrieve category id as foreign key
        Product product = new Product();

        // set product attributes
        if (isAdd) {
            product.setId(Integer.parseInt(requestMap.get("id")));
        }
        else {
            product.setStatus("true");
        }
        product.setCategory(category);
        product.setName(requestMap.get("name"));
        product.setDescription(requestMap.get("description"));
        product.setPrice(Integer.parseInt(requestMap.get("price")));
        return product;
    }
}
