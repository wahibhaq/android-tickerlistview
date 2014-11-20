package com.wahibhaq.tickerlistview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * 
 * Main Activity Class
 * 
 * @author Wahib-Ul-Haq
 *
 */


public class TickerListViewActivity extends Activity {
	
	
  ListView lvProductStructures;
 
  String showId;
  
  TextView txtPrice;
  RelativeLayout txtPartLayout;
  
  ProductListAdapter prodAdapter;
  ProductStructure item1, item2, item3, item4;
  
  static int itemCount = 4;
  public static int product_checoutCount = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
	  
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_products);
    
    
    initialize();
    
    /**
     * This is just to keep the loop in continuous motion so that animation never stops.
     * 
     */
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            
        	
             	    
        	if(itemCount == 4)
        	{
        		prodAdapter.insert(item4, 0);
        		--itemCount;
        	}
        	else if(itemCount == 3)
        	{
        		prodAdapter.insert(item3, 0);
        		--itemCount;
        		
        	}
        	else if(itemCount == 2)
        	{
        		prodAdapter.insert(item2, 0);
        		--itemCount;
        	}
        	else if(itemCount == 1)
        	{
        		prodAdapter.insert(item1, 0);
        		itemCount = 4;
        	}
        	
        	
        	prodAdapter.notifyDataSetChanged();
        	
        	new Handler().postDelayed(this, 4000);

             
            
        }
        
    }, 4000); //4 seconds
    
    
  }
  
  public void onResume()
  {
	  super.onResume();
	  
	  populateListView();
	  
	  
  }
  
  /**
   * This is where items in list view are defined
   */
  private void initialize()
  {
	
	    
	    item1 = new ProductStructure("1", "Product #4", R.drawable.bike4 );
	    item2 = new ProductStructure("2", "Product #3", R.drawable.bike3);
	    item3 = new ProductStructure("3", "Product #2", R.drawable.bike2);
	    item4 = new ProductStructure("4", "Product #1", R.drawable.bike1);
   }
  
  /**
   * Listview is connected with adapter and populated
   */
  private void populateListView()
  {

	    
	    // populate data
	    prodAdapter = new ProductListAdapter(this);
	  
	    //
	    lvProductStructures = (ListView) findViewById( R.id.list_product);
	    lvProductStructures.setAdapter( prodAdapter );
	    
	    lvProductStructures.setOnItemClickListener(new OnItemClickListener() {
	        @Override
	        public void onItemClick(AdapterView<?> parent, View view, int position,
	                long id) {
	           
	        
	           Toast.makeText(getBaseContext(), "Clicked Id #" + String.valueOf(id), Toast.LENGTH_LONG).show();
	        	
	           
	        }
	    });

  }
  
  
}