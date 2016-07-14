package ly.generalassemb.drewmahrt.shoppinglistwithdetailview;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.StatusHints;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView nameText = (TextView) findViewById(R.id.textview_name);
        TextView descText = (TextView) findViewById(R.id.textview_desc);
        TextView priceText = (TextView) findViewById(R.id.textview_price);
        TextView typeText = (TextView) findViewById(R.id.textview_type);

        int query = getIntent().getIntExtra(ShoppingSQLiteOpenHelper.COL_ID,0);
    //    ShoppingSQLiteOpenHelper helper = ShoppingSQLiteOpenHelper.getInstance(DetailActivity.this);
        Cursor cursor = ShoppingSQLiteOpenHelper.getInstance(this).searchItemById(query);

        if(cursor.moveToFirst()) {

            nameText.setText(cursor.getString(cursor.getColumnIndex(ShoppingSQLiteOpenHelper.COL_ITEM_NAME)));
            descText.setText(cursor.getString(cursor.getColumnIndex(ShoppingSQLiteOpenHelper.COL_ITEM_DESCRIPTION)));
            priceText.setText(cursor.getString(cursor.getColumnIndex(ShoppingSQLiteOpenHelper.COL_ITEM_PRICE)));
            typeText.setText(cursor.getString(cursor.getColumnIndex(ShoppingSQLiteOpenHelper.COL_ITEM_TYPE)));
        }
        cursor.close();
    }

}
