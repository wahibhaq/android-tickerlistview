package com.wahibhaq.tickerlistview;
 
 
public class ProductStructure{
 
public String id;
public String product_title;
public int img_resource_product;

/**
 * 
 * Model class which defines the items to be shown in list view
 * 
 * @param p_id
 * @param p_title
 * @param p_img_product
 */
public ProductStructure(String p_id, String p_title, int p_img_product) {

	id = p_id;
	product_title = p_title;
	img_resource_product = p_img_product;

}
 
}