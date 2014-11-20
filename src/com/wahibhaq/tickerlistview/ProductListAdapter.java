package com.wahibhaq.tickerlistview;
 
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 
 * Adapter class for the listview which fills populates each listview item and triggers animation
 *  
 * @author Wahib-Ul-Haq
 *
 */
 
public class ProductListAdapter extends ArrayAdapter<ProductStructure>{
 
Context appContext;

public ProductListAdapter(Context _context) { 
super(_context, R.layout.list_product_single); 
 
this.appContext = _context;
}
 
@Override
public View getView(int position, View convertView, ViewGroup parent) {

	convertView = new LinearLayout(getContext());

	
	String inflater = Context.LAYOUT_INFLATER_SERVICE;
	LayoutInflater vi = (LayoutInflater)getContext().getSystemService(inflater);
	convertView = vi.inflate(R.layout.list_product_single, parent, false);
	
	 
	// ProductStructure object
	ProductStructure productStructure = getItem(position);
	 
	//Initialization
	
	TextView txtProductTitle = (TextView)convertView.findViewById(R.id.txt_ProductTitle);
	ImageView imgProduct = (ImageView)convertView.findViewById(R.id.img_Product);
	
	// filling Values
	imgProduct.setBackgroundResource(productStructure.img_resource_product);
	txtProductTitle.setText(productStructure.product_title);
	
	// animate the item
	if (position == 0) {
	   
		
		Animation animation = AnimationUtils.loadAnimation(this.getContext(), R.anim.anim_left_in);
		convertView.startAnimation(animation);
		
	}
	
	
	
	return convertView;
}

 
 
}